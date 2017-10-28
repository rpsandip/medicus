package com.medicus.student.portlet.portlet.rendercommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.student.portlet.portlet.StudentPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+ StudentPortletConstant.PORTLET_ID,
	        "mvc.command.name=/student_detail"
	    },
	    service = MVCRenderCommand.class
)
public class StudentDetailRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(StudentDetailRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		long studentId = ParamUtil.getLong(renderRequest, "studentId");
		if(studentId>0){
			try {
				Student student = StudentLocalServiceUtil.getStudent(studentId);
			} catch (PortalException e) {
				_log.error(e);
			}
		}else{
			SessionErrors.add(renderRequest, "student-detail-err");
			return "/view.jsp";
		}
			
		return "/student/import_student.jsp";
	}

}
