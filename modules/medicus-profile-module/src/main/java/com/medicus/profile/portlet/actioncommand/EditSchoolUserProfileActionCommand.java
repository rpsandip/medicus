package com.medicus.profile.portlet.actioncommand;

import java.io.File;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
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
import com.medicus.common.service.service.RegistrationLocalServiceUtil;
import com.medicus.profile.portlet.constants.MedicusProfilePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name=" + MedicusProfilePortletKeys.PORTLET_ID,
	        "mvc.command.name=edit-school-user-profile"
	    },
	    service = MVCActionCommand.class
	)
public class EditSchoolUserProfileActionCommand extends BaseMVCActionCommand{

	Log _log  = LogFactoryUtil.getLog(EditSchoolUserProfileActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {

		ThemeDisplay themeDisplay =( ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String contactNumber = ParamUtil.getString(actionRequest, "contactNumber");
		String password = ParamUtil.getString(actionRequest, "password");
		String password2= ParamUtil.getString(actionRequest, "password2");
		
		try {
		
		File profilePic = uploadPortletRequest.getFile("profilePic");
		String profilePicFileName = uploadPortletRequest.getFileName("profilePic");
		
		RegistrationLocalServiceUtil.updateSchoolUserProfile(themeDisplay.getUserId(), firstName, lastName,
				contactNumber, password, password2, profilePicFileName, profilePic);	
			
		SessionMessages.add(actionRequest, "profile-update-success");
		
		
		} catch (PortalException | IOException e) {
			SessionErrors.add(actionRequest, "profile-update-error");
			_log.error(e);
		}
		
		
	}

}
