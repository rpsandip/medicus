package com.medicus.profile.portlet.actioncommand;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.profile.portlet.constants.MedicusProfilePortletKeys;


@Component(
	    property = {
	    	"javax.portlet.name=" + MedicusProfilePortletKeys.PORTLET_ID,
	        "mvc.command.name=/edit-profile"
	    },
	    service = MVCActionCommand.class
	)
public class EditPartnerProfileActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(EditPartnerProfileActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		long partnerId = ParamUtil.getLong(actionRequest, "partnerId");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String password1 = ParamUtil.getString(actionRequest, "password");
		String password2= ParamUtil.getString(actionRequest, "password2");
		String address1 = ParamUtil.getString(actionRequest, "address1");
		String zipcode = ParamUtil.getString(actionRequest, "zipcode");
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		String country = ParamUtil.getString(actionRequest, "country");
		String contactPersonName = ParamUtil.getString(actionRequest, "contactPersonName");
		String contactPersonEmail = ParamUtil.getString(actionRequest, "contactPersonEmail");
		String contactPersonPhoneNumber = ParamUtil.getString(actionRequest, "contactPersonPhoneNumber");
		String websiteLink = ParamUtil.getString(actionRequest, "websiteLink");
		
		try {
			
			//Update profile pic
			File profilePic = uploadPortletRequest.getFile("profilePic");
			String profilePicFileName = uploadPortletRequest.getFileName("profilePic");
			
			
			// Update personal info
			Partner partner = PartnerLocalServiceUtil.editPartner(partnerId, firstName,
					address1, city, zipcode, state, country, contactPersonName, contactPersonEmail, 
					contactPersonPhoneNumber, websiteLink, password1,password2, profilePic, profilePicFileName,themeDisplay.getUserId());
			
			
			SessionMessages.add(actionRequest, "profile-update-success");
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, "profile-update-error");
			actionResponse.setRenderParameter("partnerId", String.valueOf(partnerId));
			_log.error(e);
		}
			
	}

}
