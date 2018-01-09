package com.medicus.student.portlet.portlet.resourcecommand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.bean.StudentBean;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.student.portlet.portlet.StudentPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + StudentPortletConstant.PORTLET_ID,
	        "mvc.command.name=/search_studetns"
	    },
	    service = MVCResourceCommand.class
	)
public class SearchStudentResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(SearchStudentResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		int pageIndex = ParamUtil.getInteger(resourceRequest, "pagetIndex");
		int start = StudentPortletConstant.STUDENT_DISPLAY_ITEMS*pageIndex;
		int end  = start + StudentPortletConstant.STUDENT_DISPLAY_ITEMS;
		String keyword = ParamUtil.getString(resourceRequest, "keyword");
		String zipcode = ParamUtil.getString(resourceRequest, "zipcode");
		String gender = ParamUtil.getString(resourceRequest, "gender");
		String profession = ParamUtil.getString(resourceRequest, "profession");
		long schoolId = ParamUtil.getLong(resourceRequest, "schoolId");
		long campusId = ParamUtil.getLong(resourceRequest, "campusId");
		long userSchoolId = ParamUtil.getLong(resourceRequest, "userSchoolId");
		long userCampusId = ParamUtil.getLong(resourceRequest, "userCampusId");
		String languages = ParamUtil.getString(resourceRequest, "languages");
		
		if(userSchoolId>0){
			schoolId = userSchoolId;
		}
		
		if(userCampusId>0 && campusId==0){
			campusId = userCampusId;
		}
		
		List<String> languageList = new ArrayList<String>();
		if(Validator.isNotNull(languages)){
			languageList = ListUtil.fromArray(languages.split(StringPool.COMMA));
		}
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
	    SearchContext searchContext = SearchContextFactory.getInstance(request);
		
		List<StudentBean> studentBeanList = new ArrayList<StudentBean>();
		JSONObject jsonObject = StudentLocalServiceUtil.searchStudents(keyword, zipcode, gender, profession,
				languageList,schoolId, campusId, start, end,searchContext);
		
		List<Student> studentList = (List<Student>)jsonObject.get("studentList");
		long totalHits = jsonObject.getLong("totalHits");
		
		
		for(Student student : studentList){
			StudentBean studentBean = new StudentBean(student,true);
			studentBeanList.add(studentBean);
		}
		
		resourceRequest.setAttribute("studentBeanList", studentBeanList);
		
		if(totalHits>end){
			resourceRequest.setAttribute("showLoadMore", true);
		}else{
			resourceRequest.setAttribute("showLoadMore", false);
		}
		
		// Set Permission
		
		PermissionChecker pc = themeDisplay.getPermissionChecker();
	    boolean hasStudentInterviewRequestPermission  = pc.hasPermission(MedicusCommonLocalServiceUtil.getOrganizationGroupIdFromOrgId(MedicusCommonLocalServiceUtil.getMedicusOrganizationId()),
	    		Student.class.getName(), Student.class.getName(), "STUDENT_INTERVIEW_REQUEST");
	    resourceRequest.setAttribute("hasStudentInterviewRequestPermission", hasStudentInterviewRequestPermission);
	    
	    boolean hasViewStudentProfilePermission  = pc.hasPermission(MedicusCommonLocalServiceUtil.getOrganizationGroupIdFromOrgId(MedicusCommonLocalServiceUtil.getMedicusOrganizationId()),
	    		Student.class.getName(), Student.class.getName(), "VIEW_STUDENT_PROFILE");
	    resourceRequest.setAttribute("hasViewStudentProfilePermission", hasViewStudentProfilePermission);
	    
	    boolean hasUpdateStudentPermission  = pc.hasPermission(MedicusCommonLocalServiceUtil.getOrganizationGroupIdFromOrgId(MedicusCommonLocalServiceUtil.getMedicusOrganizationId()),
	    		Student.class.getName(), Student.class.getName(), "UPDATE_STUDENT");
	    resourceRequest.setAttribute("hasUpdateStudentPermission", hasUpdateStudentPermission);
	    
	    boolean hasDeleteStudentPermission  = pc.hasPermission(MedicusCommonLocalServiceUtil.getOrganizationGroupIdFromOrgId(MedicusCommonLocalServiceUtil.getMedicusOrganizationId()),
	    		Student.class.getName(), Student.class.getName(), "DELETE_STUDENT");
	    resourceRequest.setAttribute("hasDeleteStudentPermission", hasDeleteStudentPermission);
	    
		
		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
				.getRequestDispatcher("/student/student_list.jsp");

		try {
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (IOException e) {
			_log.error(e);
		}
		
		return true;
	}

}
