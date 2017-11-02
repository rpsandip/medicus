package com.medicus.student.portlet.portlet.rendercommand;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.util.ParamUtil;
import com.medicus.common.service.bean.EmployerBean;
import com.medicus.common.service.bean.StudentBean;
import com.medicus.common.service.bean.Student_ExternshipBean;
import com.medicus.common.service.model.Employer;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.model.Student_Externship;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.SchoolLocalServiceUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.common.service.service.Student_ExternshipLocalServiceUtil;
import com.medicus.student.portlet.portlet.StudentPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+ StudentPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_student"
	    },
	    service = MVCRenderCommand.class
)
public class AddStudentRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(AddStudentRenderCommand.class.getName());
			
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		renderRequest.setAttribute("usStateList", MedicusCommonLocalServiceUtil.getUSStateList());
		renderRequest.setAttribute("schoolList", SchoolLocalServiceUtil.getSchools(-1, -1));
		List<EmployerBean> employerBeanList = new ArrayList<EmployerBean>();
		List<Employer> employerList = MedicusCommonLocalServiceUtil.getEmployerList();
		for(Employer employer :employerList){
			EmployerBean employerBean = new EmployerBean(employer);
			employerBeanList.add(employerBean);
		}
		renderRequest.setAttribute("employerBeanList", employerBeanList);
		
		long studentId = ParamUtil.getLong(renderRequest,"studentId");
		if(studentId>0){
			try {
				Student student = StudentLocalServiceUtil.getStudent(studentId);
				StudentBean studentBean = new StudentBean(student);
				renderRequest.setAttribute("studentBean", studentBean);
			} catch (PortalException e) {
				_log.error(e);
			}
			try{
				Student_Externship studentExternShip = Student_ExternshipLocalServiceUtil.getStudentExternship(studentId);
				Student_ExternshipBean studentExternShipBean = new Student_ExternshipBean(studentExternShip);
				renderRequest.setAttribute("studentExternShipBean", studentExternShipBean);
			}catch(PortalException e){
				_log.error(e.getMessage());
			}
		}
		renderRequest.setAttribute("studentId", studentId);
		renderRequest.setAttribute("addExternship", ParamUtil.getBoolean(renderRequest, "addExternship"));
		return "/student/add_student.jsp";
		
	}

}
