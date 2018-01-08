package com.medicus.campus.portlet.rendercommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.medicus.campus.portlet.util.CampusPortletConstant;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.School;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.SchoolLocalServiceUtil;

@Component(
	    property = {
	    	"javax.portlet.name="+CampusPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_campus"
	    },
	    service = MVCRenderCommand.class
)
public class AddCampusRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(AddCampusRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long campusId = ParamUtil.getLong(renderRequest, "campusId");
		List<School> schoolList = SchoolLocalServiceUtil.getSchools(-1,-1);
		renderRequest.setAttribute("schoolList", schoolList);
		renderRequest.setAttribute("usStateList", MedicusCommonLocalServiceUtil.getUSStateList());
		if(campusId>0){
			try {
				Campus campus = CampusLocalServiceUtil.getCampus(campusId);
				renderRequest.setAttribute("campus", campus);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		return "/campus/add_campus.jsp";
	}

}
