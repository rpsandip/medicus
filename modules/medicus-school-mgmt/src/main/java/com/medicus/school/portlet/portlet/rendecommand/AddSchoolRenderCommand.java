package com.medicus.school.portlet.portlet.rendecommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.medicus.common.service.model.School;
import com.medicus.common.service.service.SchoolLocalServiceUtil;
import com.medicus.school.portlet.portlet.util.SchoolPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+SchoolPortletConstant.PORTLED_ID,
	        "mvc.command.name=/add_school"
	    },
	    service = MVCRenderCommand.class
)
public class AddSchoolRenderCommand implements MVCRenderCommand{

	Log _log =LogFactoryUtil.getLog(AddSchoolRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long schoolId = ParamUtil.getLong(renderRequest, "schoolId");
		try {
			School school = SchoolLocalServiceUtil.getSchool(schoolId);
			renderRequest.setAttribute("school", school);
		} catch (PortalException e) {
			_log.error(e);
		}
		renderRequest.setAttribute("schoolId", schoolId);
		return "/school/add_school.jsp";
	}

}
