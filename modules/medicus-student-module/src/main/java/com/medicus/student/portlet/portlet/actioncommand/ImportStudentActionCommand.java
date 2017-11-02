package com.medicus.student.portlet.portlet.actioncommand;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.exception.NoSuchCampusException;
import com.medicus.common.service.exception.NoSuchSchoolException;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.School;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.SchoolLocalServiceUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.student.portlet.portlet.StudentPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + StudentPortletConstant.PORTLET_ID,
	        "mvc.command.name=/import_student"
	    },
	    service = MVCActionCommand.class
	)
public class ImportStudentActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(ImportStudentActionCommand.class.getName());
	private static Map<String,Long> schoolMap = new HashMap<String,Long>();
	private static Map<String,Long> campusMap = new HashMap<String,Long>();
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadRequest.getFile("importStudentFile");
		String sourceFileName =uploadRequest.getFileName("importStudentFile");
		String fileExtension = sourceFileName.substring(sourceFileName.lastIndexOf(".") + 1);
		if(Validator.isNotNull(file)){
			if(fileExtension.equals("xlsx")|| fileExtension.equals("xls")){
				uploadStudents(actionRequest, actionResponse,file);
			}
		}else{
			SessionErrors.add(actionRequest, "not-valid-file");
		}
	}

	private void uploadStudents(ActionRequest request, ActionResponse response, File file) throws IOException{
		 ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		 FileInputStream inputStream = new FileInputStream(file);
		 SimpleDateFormat df = new SimpleDateFormat("MM/DD/YYYY");
		 XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	     Sheet firstSheet = workbook.getSheetAt(0);
	     Iterator<Row> iterator = firstSheet.iterator();
	     List<String> unsuccessfullStudentList = new ArrayList<String>();
	     if(iterator.hasNext()){
	    	  	Row row = iterator.next(); 
	        	boolean isValidFile = validateFile(row);
	        	if(!isValidFile){
	        		SessionErrors.add(request, "file-format-err");
	        		response.setRenderParameter("mvcRenderCommandName", "/import_student");
	        		return;
	        	}
	      }
	     int totalStudentCount = 0;
	     int successImportedStudentCount = 0;
	     while (iterator.hasNext()) {
	    	 Row nextRow = iterator.next();
	    	 
	    	 long schoolId = getSchoolId(nextRow.getCell(17).toString());
	    	 long campusId = getCampusId(nextRow.getCell(18).toString());
	    	 
	    	 Date dob = null;
	    	 try {
				dob = df.parse( nextRow.getCell(5).toString());
			} catch (ParseException e) {
				_log.error(e.getMessage());
			}
	    	 
	    	 if(nextRow.getRowNum()!=0 && Validator.isNotNull(nextRow.getCell(0).toString()) && schoolId!=0 && campusId !=0){
	    		 totalStudentCount++;
	    		 boolean validRow = validateRow(nextRow);
	    		 if(validRow){
	    			 
	    			 Student student = StudentLocalServiceUtil.getStudentByStudentCampusId(nextRow.getCell(3).toString());
	    			 
	    			 if(Validator.isNull(student)){
		    		 student = StudentLocalServiceUtil.importStudent(
		    				 nextRow.getCell(0).toString() /*First Name*/, 
		    				 nextRow.getCell(1).toString() /*Middle Name*/, 
		    				 nextRow.getCell(2).toString() /*Last Name*/, 
		    				 nextRow.getCell(4).toString() /*Email Address*/,
		    				 dob/*DOB*/,
		    				 nextRow.getCell(3).toString() /*Student Id*/,
		    				 nextRow.getCell(6).toString() /*Address*/, 
		    				 nextRow.getCell(7).toString() /*City*/, 
		    				 nextRow.getCell(8).toString() /*Zipcode*/,
		    				 nextRow.getCell(9).toString() /*State*/, 
		    				 nextRow.getCell(10).toString() /*Mobile Phone*/, 
		    				 nextRow.getCell(11).toString() /*Home Phone*/,
		    				 nextRow.getCell(12).toString() /*Gender*/,
		    				 nextRow.getCell(13).toString() /*primaryLangs*/,
		    				 nextRow.getCell(14).toString() /*Secondary Languages*/, 
		    				 Float.parseFloat(nextRow.getCell(15).toString()) /*GPA*/,
		    				 nextRow.getCell(16).toString() /* Pace*/,
		    				 schoolId,
		    				 campusId,
		    				 nextRow.getCell(19).toString() /*Profession*/, 
		    				 themeDisplay.getUserId());
		    		 
			    		 if(Validator.isNotNull(student)){
			    			 successImportedStudentCount++;
			    		 }else{
			    			 unsuccessfullStudentList.add(nextRow.getCell(3).toString()+StringPool.COMMA+nextRow.getCell(4).toString());
			    		 }
	    			 }else{
	    				 unsuccessfullStudentList.add(nextRow.getCell(3).toString()+StringPool.COMMA+nextRow.getCell(4).toString());
	    			 }
	    		 }else{
	    			 unsuccessfullStudentList.add(nextRow.getCell(3).toString()+StringPool.COMMA+nextRow.getCell(4).toString());
	    		 }
	    	 }
	     }
	     
	     response.setRenderParameter("totalStudentCount", String.valueOf(totalStudentCount));
	     response.setRenderParameter("successImportedStudentCount", String.valueOf(successImportedStudentCount));
	     response.setRenderParameter("UnsuccessImportedStudentCount", String.valueOf(totalStudentCount-successImportedStudentCount));
	     response.setRenderParameter("isImported",String.valueOf(true));
	     SessionMessages.add(request, "student-import-success");
	     request.setAttribute("unsuccessfullStudentList", unsuccessfullStudentList);
	     response.setRenderParameter("mvcRenderCommandName", "/import_student");
	}
	
	public boolean validateFile(Row firstRow){
		 if(!firstRow.getCell(0).toString().trim().equalsIgnoreCase("First Name")){
			 return false;
		 }else if(!firstRow.getCell(1).toString().trim().equalsIgnoreCase("Middle Name")){
			 return false;
		 }else if(!firstRow.getCell(2).toString().trim().equalsIgnoreCase("Last Name")){
			 return false;
		 }else if(!firstRow.getCell(3).toString().trim().equalsIgnoreCase("Student ID")){
			 return false;
		 }else if(!firstRow.getCell(4).toString().trim().equalsIgnoreCase("Email Address")){
			 return false;
		 }else if(!firstRow.getCell(5).toString().trim().equalsIgnoreCase("DOB")){
			 return false;
		 }else if(!firstRow.getCell(6).toString().trim().equalsIgnoreCase("Address")){
			 return false;
		 }else if(!firstRow.getCell(7).toString().trim().equalsIgnoreCase("City")){
			 return false;
		 }else if(!firstRow.getCell(8).toString().trim().equalsIgnoreCase("Zip Code")){
			 return false;
		 }else if(!firstRow.getCell(9).toString().trim().equalsIgnoreCase("State")){
			 return false;
		 }else if(!firstRow.getCell(10).toString().trim().equalsIgnoreCase("Mobile Phone")){
			 return false;
		 }else if(!firstRow.getCell(11).toString().trim().equalsIgnoreCase("Home Phone")){
			 return false;
		 }else if(!firstRow.getCell(12).toString().trim().equalsIgnoreCase("Gender (Male / Female / LGBT)")){
			 return false;
		 }else if(!firstRow.getCell(13).toString().trim().equalsIgnoreCase("Primary Language")){
			 return false;
		 }else if(!firstRow.getCell(14).toString().trim().equalsIgnoreCase("Secondary Language")){
			 return false;
		 }else if(!firstRow.getCell(15).toString().trim().equalsIgnoreCase("GPA")){
			 return false;
		 }else if(!firstRow.getCell(16).toString().trim().equalsIgnoreCase("Pace")){
			 return false;
		 }else if(!firstRow.getCell(17).toString().trim().equalsIgnoreCase("School")){
			 return false;
		 }else if(!firstRow.getCell(18).toString().trim().equalsIgnoreCase("Campus")){
			 return false;
		 }else if(!firstRow.getCell(19).toString().trim().equalsIgnoreCase("Profession")){
			 return false;
		 }else{
			 return true;
		 }
	 }
	
	private boolean validateRow(Row row){
		if(Validator.isNull(row.getCell(0).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(1).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(2).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(3).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(4).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(5).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(6).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(7).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(8).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(9).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(10).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(11).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(12).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(13).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(14).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(15).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(16).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(17).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(18).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(19).toString().trim())){
			 return false;
		 }else{
			 return true;
		 }
	}
	
	 private long getSchoolId(String schoolName){
		 long schoolId=0;
		 if(Validator.isNull(schoolMap.get(schoolName.trim()))){
			 try {
				School school = SchoolLocalServiceUtil.getSchoolByName(schoolName.trim());
				schoolId = school.getSchoolId();
				schoolMap.put(schoolName, schoolId);
			} catch (NoSuchSchoolException e) {
				_log.error(e.getMessage());
			}
		 }else{
			 return schoolMap.get(schoolName);
		 }
		 return schoolId;
	 }
	 
	 private long getCampusId(String campusName){
		 long campusId=0;
		 if(Validator.isNull(campusMap.get(campusName.trim()))){
			 try {
				Campus campus = CampusLocalServiceUtil.getCampusByName(campusName.trim());
				campusId = campus.getCampusId();
				campusMap.put(campusName, campusId);
			} catch (NoSuchCampusException e) {
				_log.error(e.getMessage());
			}
		 }else{
			 return campusMap.get(campusName);
		 }
		 return campusId;
	 }
}
