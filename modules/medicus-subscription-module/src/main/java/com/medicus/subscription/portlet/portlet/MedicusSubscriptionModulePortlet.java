package com.medicus.subscription.portlet.portlet;

import com.medicus.common.service.exception.NoSuchUser_SubscriptionException;
import com.medicus.common.service.model.Subscription;
import com.medicus.common.service.model.User_Subscription;
import com.medicus.common.service.service.SubscriptionLocalServiceUtil;
import com.medicus.common.service.service.User_SubscriptionLocalServiceUtil;
import com.medicus.subscription.portlet.constants.MedicusSubscriptionModulePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

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
		"javax.portlet.display-name=medicus-subscription-module Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.action-url-redirect=true",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MedicusSubscriptionModulePortlet extends MVCPortlet {
		@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			
			List<Subscription> subscirptionList = SubscriptionLocalServiceUtil.getSubscriptions(-1, -1);
			ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			
			
			for(Subscription subscription : subscirptionList){
				if(subscription.getName().equals("Subscription Plan")){
					renderRequest.setAttribute("subsciptionPlan", subscription);
				}
			}
			
			renderRequest.setAttribute("isSuperAdmin", themeDisplay.getPermissionChecker().isOmniadmin());
			renderRequest.setAttribute("userId", themeDisplay.getUserId());
			renderRequest.setAttribute("userSubscription", getUserSubscrption(themeDisplay.getUserId()));
			
			renderRequest.setAttribute("paypalURL", PropsUtil.get("paypal.url"));
			renderRequest.setAttribute("businessEmail", PropsUtil.get("paypal.bussiness.email"));
			renderRequest.setAttribute("hostedButtonId", PropsUtil.get("paypal.hosted.button.id"));
			renderRequest.setAttribute("returnURL", PropsUtil.get("paypal.return.url"));
			renderRequest.setAttribute("cancelURL", PropsUtil.get("paypal.cancel.url"));
			
			boolean checkout = ParamUtil.getBoolean(request, "checkout");
			if(checkout){
				SessionMessages.add(renderRequest, "subscription-success");
			}else{
				SessionMessages.add(renderRequest, "subscription-error");
			}
			
			include(viewTemplate, renderRequest, renderResponse);
		}
		
		private User_Subscription getUserSubscrption(long userId){
			User_Subscription userSubscription = null;
			try {
				userSubscription = User_SubscriptionLocalServiceUtil.getUserSubcriptionByUserId(userId);
			} catch (NoSuchUser_SubscriptionException e) {
				
			}
			return userSubscription;
		}
}