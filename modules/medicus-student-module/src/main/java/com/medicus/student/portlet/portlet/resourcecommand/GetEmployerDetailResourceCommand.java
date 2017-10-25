package com.medicus.student.portlet.portlet.resourcecommand;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.medicus.common.service.model.Employer;
import com.medicus.common.service.service.EmployerLocalServiceUtil;
import com.medicus.student.portlet.portlet.StudentPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + StudentPortletConstant.PORTLET_ID,
	        "mvc.command.name=/getEmployerDetail"
	    },
	    service = MVCResourceCommand.class
	)
public class GetEmployerDetailResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(GetEmployerDetailResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		long employerId = ParamUtil.getLong(resourceRequest, "employerId");
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		if(employerId>0){
		try {
			Employer employer = EmployerLocalServiceUtil.getEmployer(employerId);
			responseObj.put("zipcode", employer.getZipcode());
			responseObj.put("websitelink", employer.getWebsiteLink());
		} catch (PortalException e) {
			
		}
		}
		try {
			resourceResponse.getWriter().write(responseObj.toString());
		} catch (IOException e) {
			_log.error(e);
		}
		return true;
	}

}
