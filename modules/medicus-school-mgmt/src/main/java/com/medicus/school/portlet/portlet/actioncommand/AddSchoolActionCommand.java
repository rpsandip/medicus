package com.medicus.school.portlet.portlet.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.model.School;
import com.medicus.common.service.service.SchoolLocalServiceUtil;
import com.medicus.school.portlet.portlet.util.SchoolPortletConstant;
@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + SchoolPortletConstant.PORTLED_ID,
	        "mvc.command.name=/add_school"
	    },
	    service = MVCActionCommand.class
	)
public class AddSchoolActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(AddSchoolActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long schoolId = ParamUtil.getLong(actionRequest, "schoolId");
		String name = ParamUtil.getString(actionRequest, "name");
		String address1 = ParamUtil.getString(actionRequest, "address1");
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		String country = ParamUtil.getString(actionRequest, "country");
		String schoolContactNumber = ParamUtil.getString(actionRequest, "contactNumber");
		String websiteLink = ParamUtil.getString(actionRequest, "websiteLink");
		String contactPersonName = ParamUtil.getString(actionRequest, "contactPersonName");
		String contactPersonPhoneNumber = ParamUtil.getString(actionRequest, "contactPersonPhoneNumber");
		String contactPersonEmail = ParamUtil.getString(actionRequest, "contactPersonEmail");
		
		if(schoolId==0){
			School school = SchoolLocalServiceUtil.addSchool(name, address1, city, state, country,
					schoolContactNumber, websiteLink, contactPersonName, contactPersonEmail, contactPersonPhoneNumber, themeDisplay.getUserId());
			if(Validator.isNotNull(school)){
				SessionMessages.add(actionRequest, "school-add-success");
			}else{
				SessionErrors.add(actionRequest, "school-add-error");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_school");
			}
		}else{
			try {
				School school = SchoolLocalServiceUtil.updateSchool(schoolId,name, address1, city, state, country,
						schoolContactNumber, websiteLink, contactPersonName, contactPersonEmail, contactPersonPhoneNumber, themeDisplay.getUserId());
				SessionMessages.add(actionRequest, "school-update-success");
			} catch (PortalException e) {
				SessionErrors.add(actionRequest, "school-update-error");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_school");
				actionResponse.setRenderParameter("schoolId", String.valueOf(schoolId));
				_log.error(e);
			}
		}
		
	}

}
