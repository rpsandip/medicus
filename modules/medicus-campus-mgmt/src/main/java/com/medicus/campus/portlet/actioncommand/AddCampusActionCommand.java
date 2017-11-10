package com.medicus.campus.portlet.actioncommand;

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
import com.medicus.campus.portlet.util.CampusPortletConstant;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.service.CampusLocalServiceUtil;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + CampusPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_campus"
	    },
	    service = MVCActionCommand.class
	)
public class AddCampusActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(AddCampusActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long campusId = ParamUtil.getLong(actionRequest, "campusId");
		long schoolId = ParamUtil.getLong(actionRequest, "schoolId");
		String name = ParamUtil.getString(actionRequest, "name");
		String address1 = ParamUtil.getString(actionRequest, "address1");
		String address2 = ParamUtil.getString(actionRequest, "address2");
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		String country = ParamUtil.getString(actionRequest, "country");
		String campusContactNumber = ParamUtil.getString(actionRequest, "contactNumber");
		String websiteLink = ParamUtil.getString(actionRequest, "websiteLink");
		String contactPersonName = ParamUtil.getString(actionRequest, "contactPersonName");
		String contactPersonPhoneNumber = ParamUtil.getString(actionRequest, "contactPersonPhoneNumber");
		String contactPersonEmail = ParamUtil.getString(actionRequest, "contactPersonEmail");
		
		if(campusId==0){
			try {
				Campus	campus = CampusLocalServiceUtil.addCampus(schoolId,name, address1, address2, city, state, country, 
						campusContactNumber, websiteLink, contactPersonName, contactPersonEmail, 
						contactPersonPhoneNumber, themeDisplay.getUserId());
				SessionMessages.add(actionRequest, "campus-add-successes");
			} catch (PortalException e) {
				SessionErrors.add(actionRequest, "campus-add-error");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_campus");
				actionResponse.setRenderParameter("campusId", String.valueOf(campusId));
				_log.error(e);
			}
		}else{
			try {
				Campus campus = CampusLocalServiceUtil.upateCampus(campusId, schoolId,name, address1, address2, city, state,
						country, campusContactNumber, websiteLink, contactPersonName, contactPersonEmail,
						contactPersonPhoneNumber, themeDisplay.getUserId());
				SessionMessages.add(actionRequest, "campus-update-success");
			} catch (PortalException e) {
				SessionErrors.add(actionRequest, "campus-update-error");
				actionResponse.setRenderParameter("mvcRenderCommandName", "/add_campus");
				actionResponse.setRenderParameter("campusId", String.valueOf(campusId));
				_log.error(e);
			}
		}
	}

}
