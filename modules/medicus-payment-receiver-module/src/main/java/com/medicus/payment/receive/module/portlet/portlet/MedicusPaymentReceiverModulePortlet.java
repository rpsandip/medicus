package com.medicus.payment.receive.module.portlet.portlet;

import com.medicus.common.service.exception.NoSuchUser_SubscriptionException;
import com.medicus.common.service.model.Subscription;
import com.medicus.common.service.model.User_Subscription;
import com.medicus.common.service.service.User_SubscriptionLocalServiceUtil;
import com.medicus.common.service.service.persistence.User_SubscriptionPK;
import com.medicus.payment.receive.module.portlet.constants.MedicusPaymentReceiverModulePortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Props;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Enumeration;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author sandip
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=medicus-payment-receiver-module Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MedicusPaymentReceiverModulePortlet extends MVCPortlet {
		
		Log _log = LogFactoryUtil.getLog(MedicusPaymentReceiverModulePortlet.class.getName());
	
		@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			
			HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			
			
			Enumeration en = request.getParameterNames();
			String str = "cmd=_notify-validate";
			String customRes = StringPool.BLANK;
			while(en.hasMoreElements()){
			String paramName = (String)en.nextElement();
			String paramValue = request.getParameter(paramName);
						
			if(paramName.equals("custom")){
				customRes = paramValue;
			}
			
			str = str + "&" + paramName + "=" + URLEncoder.encode(paramValue, "UTF-8");
			}

			System.out.println("----------------------------------------------------------");
			
			// post back to PayPal system to validate
			// NOTE: change http: to https: in the following URL to verify using SSL (for increased security).
			// using HTTPS requires either Java 1.4 or greater, or Java Secure Socket Extension (JSSE)
			// and configured for older versions.
			URL u = new URL(PropsUtil.get("paypal.url"));
			URLConnection uc = u.openConnection();
			uc.setDoOutput(true);
			uc.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			PrintWriter pw = new PrintWriter(uc.getOutputStream());
			pw.println(str);
			pw.close();

			BufferedReader in = new BufferedReader(
			new InputStreamReader(uc.getInputStream()));
			String res = in.readLine();
			in.close();

			// assign posted variables to local variables
			String itemName = request.getParameter("item_name");
			String itemNumber = request.getParameter("item_number");
			String paymentStatus = request.getParameter("payment_status");
			String paymentAmount = request.getParameter("mc_gross");
			String paymentCurrency = request.getParameter("mc_currency");
			String txnId = request.getParameter("txn_id");
			String receiverEmail = request.getParameter("receiver_email");
			String payerEmail = request.getParameter("payer_email");

			//check notification validation
			
			_log.info("Paypal Response ->" + res);
			
			_log.info("paymentStatus->" + paymentStatus + " paymentAmount->" +paymentAmount + " txnId->" + txnId);
			
			
			if(res.equals("VERIFIED")) {
			
				_log.info("PayPal Response :: VERIFIED :) ");
				
				if(paymentStatus.equals("Completed") && Validator.isNotNull(customRes)){
					String[] custonResArray = customRes.split(StringPool.COMMA);
					long userId=0;
					int subscriptionId=0;
					if(custonResArray.length>0){
						userId = Long.parseLong(custonResArray[0]);
						subscriptionId = Integer.parseInt(custonResArray[1]);
					}
					if(userId>0 && subscriptionId>0){
						
						User_Subscription userSubscription = null;
						
						try {
							userSubscription = User_SubscriptionLocalServiceUtil.getUserSubcriptionByUserId(userId);
							userSubscription.setSubscriptionId(subscriptionId);
							userSubscription.setTxnId(txnId);
							userSubscription.setSubscriptionDate(new Date());
							User_SubscriptionLocalServiceUtil.updateUser_Subscription(userSubscription);
						} catch (PortalException e1) {
							_log.error(e1.getMessage());
						}
						
						if(Validator.isNull(userSubscription)){
							userSubscription = User_SubscriptionLocalServiceUtil.createUser_Subscription(userId);
							userSubscription.setSubscriptionId(subscriptionId);
							userSubscription.setTxnId(txnId);
							userSubscription.setUserId(userId);
							userSubscription.setSubscriptionDate(new Date());
							User_SubscriptionLocalServiceUtil.addUser_Subscription(userSubscription);
						}
					}
					}
			}
			else if(res.equals("INVALID")) {
				_log.info("Paypal Respnse :: INVALID :( ");
			}
			else {
				_log.info("Paypal Respnse :: ERROR :(((( ");
			}
			
			//include(viewTemplate, renderRequest, renderResponse);
		}
}