package com.medicus.report.portlet.portlet.resourcecommand;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
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
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.medicus.common.service.bean.StudentBean;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.report.portlet.portlet.util.ReportFileUtil;
import com.medicus.report.portlet.portlet.util.ReportModuleConstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + ReportModuleConstant.PORTLET_ID,
	        "mvc.command.name=/export_students"
	    },
	    service = MVCResourceCommand.class
	)
public class ExportStudentsResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(ExportStudentsResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
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
		
		if(userCampusId>0){
			campusId = userCampusId;
		}
		
		List<String> languageList = new ArrayList<String>();
		if(Validator.isNotNull(languages)){
			languageList = ListUtil.fromArray(languages.split(StringPool.COMMA));
		}
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);
	    SearchContext searchContext = SearchContextFactory.getInstance(request);
	    
		JSONObject jsonObject = StudentLocalServiceUtil.searchStudents(keyword, zipcode, gender, profession,
				languageList,schoolId, campusId, -1, -1,searchContext);
		
		List<Student> studentList = (List<Student>)jsonObject.get("studentList");
		
		try {
        	resourceResponse.setContentType("application/vnd.ms-excel");
        	resourceResponse.addProperty(
                    HttpHeaders.CONTENT_DISPOSITION, "attachment;  filename=Medicus_Students.xlsx");

        	File file = ReportFileUtil.generateReport(studentList);
            OutputStream pos = resourceResponse.getPortletOutputStream();
            try {
            	byte[] bytesArray = new byte[(int) file.length()];
            	FileInputStream fis = new FileInputStream(file);
            	fis.read(bytesArray); //read file into bytes[]
            	fis.close();

                pos.write(bytesArray);
                pos.flush();
            } finally {
                pos.close();
            }
        } catch(IOException e){
        	_log.error(e);
        }
		
		return true;
	}

}
