package com.medicus.report.portlet.portlet.resourcecommand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.bean.StudentBean;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.report.portlet.portlet.util.ReportModuleConstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + ReportModuleConstant.PORTLET_ID,
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
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		JSONArray dataArray = JSONFactoryUtil.createJSONArray();
		
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		int start = Integer.parseInt(httpRequest.getParameter("start"));
		int length = Integer.parseInt(httpRequest.getParameter("length"));
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
				languageList,schoolId, campusId, start, start+length,searchContext);
		
		List<Student> studentList = (List<Student>)jsonObject.get("studentList");
		long totalHits = jsonObject.getLong("totalHits");
		
		
		for(Student student : studentList){
			StudentBean studentBean = new StudentBean(student, true);
			JSONObject studentJSONObject = JSONFactoryUtil.createJSONObject();
			String middleName = StringPool.BLANK;
			if(Validator.isNotNull(student.getMiddleName())){
				middleName = StringUtil.upperCase(student.getMiddleName().substring(0, 1)).concat(".");
			}
			studentJSONObject.put("name", student.getFirstName()+StringPool.SPACE+ middleName+ StringPool.SPACE + student.getLastName());
			studentJSONObject.put("studentId", student.getStundetCampusId());
			studentJSONObject.put("gender", studentBean.getGender());
			studentJSONObject.put("zipcode", studentBean.getZipcode());
			studentJSONObject.put("profession", studentBean.getProfession());
			studentJSONObject.put("language", studentBean.getPrimaryLanguages());
			studentJSONObject.put("school", studentBean.getSchoolName());
			studentJSONObject.put("campus", studentBean.getCampusName());
			dataArray.put(studentJSONObject);
		}
		
		 responseObj.put("iTotalRecords", totalHits);
		 responseObj.put("iTotalDisplayRecords", totalHits);
		 responseObj.put("aaData", dataArray);
		    
		 try {
				resourceResponse.getWriter().write(responseObj.toString());
			} catch (IOException e) {
				_log.error(e.getMessage(), e);
		 }
		 
		return true;
	}

}
