package com.medicus.student.portlet.portlet.rendercommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.medicus.student.portlet.portlet.StudentPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+ StudentPortletConstant.PORTLET_ID,
	        "mvc.command.name=/import_student"
	    },
	    service = MVCRenderCommand.class
)
public class ImportStudentRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		boolean isImported = ParamUtil.getBoolean(renderRequest, "isImported");
		if(isImported){
			renderRequest.setAttribute("totalStudentCount", ParamUtil.getString(renderRequest, "totalStudentCount"));
			renderRequest.setAttribute("successImportedStudentCount", ParamUtil.getString(renderRequest, "successImportedStudentCount"));
			renderRequest.setAttribute("UnsuccessImportedStudentCount", ParamUtil.getString(renderRequest, "UnsuccessImportedStudentCount"));
			String[] unsuccessfullStudentEmail = ParamUtil.getString(renderRequest, "unsuccesfulltStudentEmail").split(StringPool.COMMA);
			List<String> unsuccessfullStudentEmailList =  ListUtil.fromArray(unsuccessfullStudentEmail);
			renderRequest.setAttribute("unsuccessfullStudentEmailList", unsuccessfullStudentEmailList);
			renderRequest.setAttribute("isImported", isImported);
		}
		return "/student/import_student.jsp";
	}

}
