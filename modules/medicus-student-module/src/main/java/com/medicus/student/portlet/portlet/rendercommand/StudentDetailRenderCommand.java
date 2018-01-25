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
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.bean.StudentBean;
import com.medicus.common.service.bean.Student_ExternshipBean;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.model.Student_Externship;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.common.service.service.Student_ExternshipLocalService;
import com.medicus.common.service.service.Student_ExternshipLocalServiceUtil;
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
		ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if(studentId>0){
			try {
				// Get Student 
				Student student = StudentLocalServiceUtil.getStudent(studentId);
				StudentBean studentBean = new StudentBean(student);
				renderRequest.setAttribute("studentBean", studentBean);
			
			} catch (PortalException e) {
				_log.error(e);
			}	
			
			try {
				// Get StudentExtership
				Student_Externship studentExternship = Student_ExternshipLocalServiceUtil.getStudentExternship(studentId);
				Student_ExternshipBean studentExternshipBean = new Student_ExternshipBean(studentExternship);
				renderRequest.setAttribute("studentExternshipBean", studentExternshipBean);
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}	
			
			renderRequest.setAttribute("isPartner", MedicusCommonLocalServiceUtil.isPartner(themeDisplay.getUserId()));
		}else{
			SessionErrors.add(renderRequest, "student-detail-err");
			return "/view.jsp";
		}
			
		return "/student/student_detail.jsp";
	}

}
