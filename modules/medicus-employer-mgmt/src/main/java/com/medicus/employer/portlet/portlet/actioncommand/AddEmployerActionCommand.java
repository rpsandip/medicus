package com.medicus.employer.portlet.portlet.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.model.Employer;
import com.medicus.common.service.service.EmployerLocalServiceUtil;
import com.medicus.employer.portlet.portlet.util.EmployerPortletConstant;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + EmployerPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_employer"
	    },
	    service = MVCActionCommand.class
	)
public class AddEmployerActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long employerId = ParamUtil.getLong(actionRequest, "employerId");
		
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String lastName = ParamUtil.getString(actionRequest, "lastName");
		String emailAddress= ParamUtil.getString(actionRequest, "emailAddress");
		String address1 = ParamUtil.getString(actionRequest, "address1");
		String zipcode = ParamUtil.getString(actionRequest, "zipcode");
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		String country = ParamUtil.getString(actionRequest, "country");
		String contactPersonName = ParamUtil.getString(actionRequest, "contactPersonName");
		String contactPersonEmail = ParamUtil.getString(actionRequest, "contactPersonEmail");
		String contactPersonPhoneNumber = ParamUtil.getString(actionRequest, "contactPersonPhoneNumber");
		String websiteLink = ParamUtil.getString(actionRequest, "websiteLink");
		
		if(employerId==0){
			Employer employer = EmployerLocalServiceUtil.addEmployer(firstName, lastName, emailAddress, address1, city, zipcode, state,country, contactPersonName, contactPersonEmail,
				contactPersonPhoneNumber, websiteLink, themeDisplay.getUserId());
			if(Validator.isNotNull(employer)){
				SessionMessages.add(actionRequest, "employer-add-success");
			}else{
				SessionErrors.add(actionRequest, "employer-add-error");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_employer");
			}
		}else{
			Employer employer = EmployerLocalServiceUtil.editEmployer(employerId, firstName, lastName,
					emailAddress, address1, city, zipcode, state, country, contactPersonName,
					contactPersonEmail, contactPersonPhoneNumber, websiteLink, themeDisplay.getUserId());
			if(Validator.isNotNull(employer)){
				SessionMessages.add(actionRequest, "employer-update-success");
			}else{
				SessionErrors.add(actionRequest, "employer-update-error");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_employer");
				actionResponse.setRenderParameter("employerId",String.valueOf(employerId));
			}
		}
	}

}
