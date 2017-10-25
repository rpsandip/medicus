package com.medicus.student.portlet.portlet.rendercommand;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.medicus.common.service.bean.EmployerBean;
import com.medicus.common.service.model.Employer;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.SchoolLocalServiceUtil;
import com.medicus.student.portlet.portlet.StudentPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+ StudentPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_student"
	    },
	    service = MVCRenderCommand.class
)
public class AddStudentRenderCommand implements MVCRenderCommand{

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
		return "/student/add_student.jsp";
		
	}

}
