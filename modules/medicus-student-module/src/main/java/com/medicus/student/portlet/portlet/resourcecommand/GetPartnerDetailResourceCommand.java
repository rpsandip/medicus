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
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.student.portlet.portlet.StudentPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + StudentPortletConstant.PORTLET_ID,
	        "mvc.command.name=/getPartnerDetail"
	    },
	    service = MVCResourceCommand.class
	)
public class GetPartnerDetailResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(GetPartnerDetailResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		long partnerId = ParamUtil.getLong(resourceRequest, "partnerId");
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		if(partnerId>0){
		try {
			Partner partner = PartnerLocalServiceUtil.getPartner(partnerId);
			responseObj.put("zipcode", partner.getZipcode());
			responseObj.put("websitelink", partner.getWebsiteLink());
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
