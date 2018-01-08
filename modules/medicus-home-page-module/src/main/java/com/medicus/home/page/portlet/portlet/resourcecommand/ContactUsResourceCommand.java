package com.medicus.home.page.portlet.portlet.resourcecommand;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.medicus.common.service.bean.PartnerBean;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.Interview_Request;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.common.service.util.MedicusConstant;
import com.medicus.home.page.portlet.constants.MedicusHomePageModulePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name=" + MedicusHomePageModulePortletKeys.PORTLET_ID,
	        "mvc.command.name=/contact-us"
	    },
	    service = MVCResourceCommand.class
	)
public class ContactUsResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(ContactUsResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		String firstName = ParamUtil.getString(resourceRequest, "firstName");
		String lastName = ParamUtil.getString(resourceRequest, "lastName");
		String email = ParamUtil.getString(resourceRequest, "email");
		String subject = ParamUtil.getString(resourceRequest, "subject");
		String message = ParamUtil.getString(resourceRequest, "message");
		
		sendMail(firstName, lastName, email, subject, message);
		responseObj.put("success", true);

		try {
			resourceResponse.getWriter().write(responseObj.toString());
		} catch (IOException e) {
			_log.error(e);
		}
		return true;
	}
	
	
	private void sendMail(String firstName, String lastName, String email, String subject, String message){

		try {
				
				InputStream is = null;
			    UnsyncBufferedReader unsyncBufferedReader = null;
			    ClassLoader classloader = getClass().getClassLoader();
				is = classloader.getResourceAsStream("contact-us.tmpl");
				StringBundler sb = new StringBundler();
				unsyncBufferedReader = new UnsyncBufferedReader(new InputStreamReader(is));
				String line = null;
				while ((line = unsyncBufferedReader.readLine()) != null) {
					 sb.append(line);
					 sb.append(CharPool.NEW_LINE);
				}
				unsyncBufferedReader.close();
				is.close();
				
				String body = sb.toString().trim();
				String[] variables = new String[] {"[$FIRST_NAME]","[$LAST_NAME]", "[$EMAIL]","[$SUBJECT]","[$MESSAGE]"};
				String[] values = new String[] {firstName, lastName, email, subject, message};
				
				body = StringUtil.replace(body, variables, values);
				
				String mailSubject = "Constact Us Reqest from " + firstName + StringPool.SPACE + lastName;
				String fromMail = MedicusConstant.FROM_EMAIL;
				InternetAddress from = new InternetAddress(fromMail);
				InternetAddress[] to =new InternetAddress[1];
				to[0] = new InternetAddress(PropsUtil.get("contact.us.email"));
				
				MailMessage mailMessage = new MailMessage(from, mailSubject, body, true);
				
				mailMessage.setTo(to);
				MailServiceUtil.sendEmail(mailMessage);
				
				_log.info("Contact Us email send successfully");
				
			} catch (IOException | AddressException e) {
				_log.info("Error while send contact us email.");
				_log.error(e.getMessage());
			}
		
	}

}
