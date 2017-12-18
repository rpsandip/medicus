package com.medicus.student.portlet.portlet.rendercommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
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
			renderRequest.setAttribute("isImported", isImported);
			
			PortalCache portalCache =   MultiVMPoolUtil.getCache(Student.class.getName());
			List<String> unsuccessfullStudentList = (List<String>)portalCache.get("unsuccessfullStudentList");
			portalCache.remove("unsuccessfullStudentList");
			renderRequest.setAttribute("unsuccessfullStudentList", unsuccessfullStudentList);
			
		}
		renderRequest.setAttribute("import_studnet_file_url", MedicusCommonLocalServiceUtil.getStudentImportFileURL());
		return "/student/import_student.jsp";
	}
}
