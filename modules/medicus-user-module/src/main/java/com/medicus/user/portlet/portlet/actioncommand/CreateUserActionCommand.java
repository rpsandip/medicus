package com.medicus.user.portlet.portlet.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.RegistrationLocalServiceUtil;
import com.medicus.user.portlet.portlet.util.UserModuleConstant;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + UserModuleConstant.PORTLET_ID,
	        "mvc.command.name=/create_user"
	    },
	    service = MVCActionCommand.class
	)
public class CreateUserActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(CreateUserActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
		String contactNumber = ParamUtil.getString(actionRequest, "contactNumber");
		long schoolId = ParamUtil.getLong(actionRequest, "school");
		long campusId = ParamUtil.getLong(actionRequest, "campus");
		long roleId = ParamUtil.getLong(actionRequest, "role");
		long userId = ParamUtil.getLong(actionRequest, "userId");

		if(userId==0){
			
			// Create New User
			User user = MedicusCommonLocalServiceUtil.isUserExist(emailAddress);
			if(Validator.isNull(user)){
				try {
					user = RegistrationLocalServiceUtil.createSchoolUser(firstName, lastName, emailAddress, contactNumber,
							schoolId, campusId, roleId, themeDisplay.getUserId(), themeDisplay.getScopeGroupId());
				} catch (PortalException e) {
					_log.error(e);
				}
			
				if(Validator.isNotNull(user)){
					SessionMessages.add(actionRequest, "user-create-success");
				}else{
					SessionErrors.add(actionRequest, "user-create-error");
					SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				}
			}else{
				SessionErrors.add(actionRequest, "user-exist");
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}
		}else{
			
			// Update user
			User user = null;
			try {
				 user = RegistrationLocalServiceUtil.updateSchoolUser(userId, firstName, lastName, emailAddress, contactNumber,
						schoolId, campusId, roleId, themeDisplay.getUserId(), themeDisplay.getScopeGroupId());
			} catch (PortalException e) {
				_log.error(e);
			}
			
			if(Validator.isNotNull(user)){
				SessionMessages.add(actionRequest, "user-update-success");
			}else{
				SessionErrors.add(actionRequest, "user-update-error");
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}
			
		}
	}

}
