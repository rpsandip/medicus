package com.medicus.student.portlet.portlet.rendercommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.medicus.common.service.bean.PartnerBean;
import com.medicus.common.service.bean.StudentBean;
import com.medicus.common.service.bean.Student_ExternshipBean;
import com.medicus.common.service.model.Employer;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.model.School;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.model.Student_Externship;
import com.medicus.common.service.service.EmployerLocalServiceUtil;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.SchoolLocalServiceUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.common.service.service.Student_ExternshipLocalServiceUtil;
import com.medicus.common.service.util.Student_ExternshipStatus;
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
		
		List<School> schoolListForSchoolAdmin = new ArrayList<School>();
		schoolListForSchoolAdmin = MedicusCommonLocalServiceUtil.setUserSchoolIdCampusIdInRequest(renderRequest, schoolListForSchoolAdmin);
		
		renderRequest.setAttribute("usStateList", MedicusCommonLocalServiceUtil.getUSStateList());
		renderRequest.setAttribute("schoolList", schoolListForSchoolAdmin);
		
		// Get Partner List
		List<PartnerBean> partnerBeanList = new ArrayList<PartnerBean>();
		List<Partner> partnerList = MedicusCommonLocalServiceUtil.getPartnerList();
		for(Partner partner : partnerList){
			PartnerBean partnerBean = new PartnerBean(partner);
			if(partnerBean.getUser().isActive()){
				partnerBeanList.add(partnerBean);
			}
		}
		renderRequest.setAttribute("partnerBeanList", partnerBeanList);
		
		
		// Get Employer List
		List<Employer> employerList = new ArrayList<Employer>();
		employerList = EmployerLocalServiceUtil.getEmployers(-1, -1);
		renderRequest.setAttribute("employerList", employerList);
		
		// Get StudentBean
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
		
		// Prepare Map for Student Exnternship status
		Map<Integer,String> externshipStatusMap = new HashMap<Integer,String>();
		for(Student_ExternshipStatus externShipStatus : Student_ExternshipStatus.values()){
			externshipStatusMap.put(externShipStatus.getValue(), externShipStatus.getLabel());
		}
		
		//Check for approve Inrerview request
		boolean isApproveInterviewRequest = ParamUtil.getBoolean(renderRequest, "approveInterviewRequest");
				
		
		renderRequest.setAttribute("externshipStatusMap", externshipStatusMap);
		renderRequest.setAttribute("studentId", studentId);
		renderRequest.setAttribute("addExternship", ParamUtil.getBoolean(renderRequest, "addExternship"));
		renderRequest.setAttribute("isApproveInterviewRequest", isApproveInterviewRequest);
		renderRequest.setAttribute("inteviewRequestPartnerId", ParamUtil.getLong(renderRequest, "inteviewRequestPartnerId"));
		return "/student/add_student.jsp";
		
	}

}
