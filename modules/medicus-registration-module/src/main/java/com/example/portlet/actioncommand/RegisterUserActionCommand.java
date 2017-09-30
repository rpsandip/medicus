package com.example.portlet.actioncommand;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.sound.sampled.Port;

import org.osgi.service.component.annotations.Component;

import com.example.portlet.util.RegistrationPortletConstant;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;import com.liferay.portal.kernel.upgrade.RenameUpgradePortalPreferences;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.RegistrationLocalServiceUtil;


@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + RegistrationPortletConstant.PORTLET_ID,
	        "mvc.command.name=/register-user"
	    },
	    service = MVCActionCommand.class
	)
public class RegisterUserActionCommand extends BaseMVCActionCommand{

	
	Log _log = LogFactoryUtil.getLog(RegisterUserActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String firstName = ParamUtil.getString(actionRequest, "firstName");
			String lastName = ParamUtil.getString(actionRequest, "lastName");
			String emailAddress= ParamUtil.getString(actionRequest, "emailAddress");
			String password1 = ParamUtil.getString(actionRequest, "password");
			String password2= ParamUtil.getString(actionRequest, "password2");
			String address1 = ParamUtil.getString(actionRequest, "address1");
			String address2 = ParamUtil.getString(actionRequest, "address2");
			String zipcode = ParamUtil.getString(actionRequest, "zipcode");
			String city = ParamUtil.getString(actionRequest, "city");
			String state = ParamUtil.getString(actionRequest, "state");
			String country = ParamUtil.getString(actionRequest, "country");
			String contactPersonName = ParamUtil.getString(actionRequest, "contactPersonName");
			String contactPersonEmail = ParamUtil.getString(actionRequest, "contactPersonEmail");
			String contactPersonPhoneNumber = ParamUtil.getString(actionRequest, "contactPersonPhoneNumber");
			String websiteLink = ParamUtil.getString(actionRequest, "websiteLink");
			
			User user = MedicusCommonLocalServiceUtil.isUserExist(emailAddress);
			if(Validator.isNull(user)){
				user = RegistrationLocalServiceUtil.registerEmployer(firstName,lastName, emailAddress, password1, password2,
						address1, address2, city, zipcode, state, country, contactPersonName, contactPersonEmail,
						contactPersonPhoneNumber, websiteLink, themeDisplay.getUserId(), themeDisplay.getScopeGroupId());
				if(Validator.isNull(user)){
					SessionErrors.add(actionRequest, "err-register-user");
					SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				}
			}else{
					SessionErrors.add(actionRequest, "user-exist");
					SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

			}
		}
	}
