package com.medicus.student.portlet.portlet.actioncommand;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.search.SearchException;
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
	    	 totalStudentCount++;
	    	 Row nextRow = iterator.next();
	    	 
	    	 long schoolId = getSchoolId(nextRow.getCell(17).toString());
	    	 long campusId = getCampusId(nextRow.getCell(18).toString());
	    	 
	    	 Date dob = null;
	    	 try {
	    		 Date cellDate  =  nextRow.getCell(5).getDateCellValue();
	    		 dob = cellDate;
			 } catch (Exception e) {
				_log.error(e.getMessage());
			 }
	    	 
	    	 Date graduationDate = null;
	    	 try{
	    		 graduationDate = nextRow.getCell(22).getDateCellValue();
	    	 }catch(Exception e){
	    		 _log.error(e.getMessage());
	    	 }
	    	 
	    	 Date externshipStartDate = null;
	    	 try{
	    		 externshipStartDate = nextRow.getCell(23).getDateCellValue();
	    	 }catch(Exception e){
	    		 _log.error(e.getMessage());
	    	 }
	    	 
	    	 if(Validator.isNotNull(nextRow.getCell(0).toString())){
		    	 if(nextRow.getRowNum()!=0  && schoolId!=0 && campusId !=0){
		    		 
		    		 boolean isEmptyRow = checkIfRowIsEmpty(nextRow);;
	
		    		 if(!isEmptyRow){
		    		 
		    		 boolean validRow = validateRow(nextRow);
		    		 if(validRow){
		    			 
		    			 Cell studentCampusIdCell = nextRow.getCell(3);
		    			 studentCampusIdCell.setCellType(Cell.CELL_TYPE_STRING);
		    			 
		    			 Student student = StudentLocalServiceUtil.getStudentByStudentCampusId(studentCampusIdCell.toString());
		    			 
		    			 Cell zipCodeCell = nextRow.getCell(8);
		    			 zipCodeCell.setCellType(Cell.CELL_TYPE_STRING);
		    			 
		    			 Cell mobileCell = nextRow.getCell(10);
		    			 mobileCell.setCellType(Cell.CELL_TYPE_STRING);
		    			 
		    			 Cell homeCell = nextRow.getCell(11);
		    			 homeCell.setCellType(Cell.CELL_TYPE_STRING);
		    			 
		    			 Cell studentIdCell = nextRow.getCell(3);
		    			 studentIdCell.setCellType(Cell.CELL_TYPE_STRING);
		    			 
		    			 if(Validator.isNull(student)){
			    		 try {
									student = StudentLocalServiceUtil.importStudent(
											 nextRow.getCell(0).toString() /*First Name*/, 
											 nextRow.getCell(1).toString() /*Middle Name*/, 
											 nextRow.getCell(2).toString() /*Last Name*/, 
											 nextRow.getCell(4).toString() /*Email Address*/,
											 dob/*DOB*/,
											 nextRow.getCell(3).getStringCellValue() /*Student Id*/,
											 nextRow.getCell(6).toString() /*Address*/, 
											 nextRow.getCell(7).toString() /*City*/, 
											 zipCodeCell.toString() /*Zipcode*/,
											 nextRow.getCell(9).toString() /*State*/, 
											 mobileCell.toString() /*Mobile Phone*/, 
											 homeCell.toString() /*Home Phone*/,
											 nextRow.getCell(12).toString() /*Gender*/,
											 nextRow.getCell(13).toString() /*primaryLangs*/,
											 nextRow.getCell(14).toString() /*Secondary Languages*/, 
											 Float.parseFloat(nextRow.getCell(15).toString()) /*GPA*/,
											 nextRow.getCell(16).toString() /* Pace*/,
											 nextRow.getCell(20).toString(),/*shift*/
											 nextRow.getCell(21).toString(),/*Ethinicity*/
											 externshipStartDate,
											 graduationDate,
											 schoolId,
											 campusId,
											 nextRow.getCell(19).toString() /*Profession*/, 
											 themeDisplay.getUserId());
								} catch (NumberFormatException e) {
									_log.error(e);
								} catch (PortalException e) {
									_log.error(e);
								}
					    		 
				    		 if(Validator.isNotNull(student)){
				    			 successImportedStudentCount++;
				    		 }else{
				    			 unsuccessfullStudentList.add(nextRow.getCell(3).toString()+StringPool.COMMA+nextRow.getCell(4).toString());
				    		 }
		    			 }else{
		    				 try {
								StudentLocalServiceUtil.updateImportStudent(student, 
										nextRow.getCell(0).toString() /*First Name*/, 
										 nextRow.getCell(1).toString() /*Middle Name*/, 
										 nextRow.getCell(2).toString() /*Last Name*/, 
										 nextRow.getCell(4).toString() /*Email Address*/,
										 dob/*DOB*/,
										 nextRow.getCell(12).toString() /*Gender*/,
										 nextRow.getCell(19).toString() /*Profession*/, 
										 nextRow.getCell(6).toString() /*Address*/, 
										 nextRow.getCell(7).toString() /*City*/,
										 zipCodeCell.toString() /*Zipcode*/,
										 nextRow.getCell(9).toString() /*State*/, 
										 mobileCell.toString() /*Mobile Phone*/, 
										 homeCell.toString() /*Home Phone*/,
										 nextRow.getCell(13).toString() /*primaryLangs*/,
										 nextRow.getCell(14).toString() /*Secondary Languages*/, 
										 Float.parseFloat(nextRow.getCell(15).toString()) /*GPA*/,
										 nextRow.getCell(16).toString() /* Pace*/,
										 nextRow.getCell(20).toString(),/*shift*/
										 nextRow.getCell(21).toString(),
										 graduationDate,
										 externshipStartDate);
								successImportedStudentCount++;
							} catch (SearchException e) {
								unsuccessfullStudentList.add(nextRow.getCell(3).toString()+StringPool.COMMA+nextRow.getCell(4).toString());
								_log.error(e);
							} catch (NumberFormatException e) {
								unsuccessfullStudentList.add(nextRow.getCell(3).toString()+StringPool.COMMA+nextRow.getCell(4).toString());
								_log.error(e);
							}
		    			 }
		    		 }else{
		    			 unsuccessfullStudentList.add(nextRow.getCell(3).toString()+StringPool.COMMA+nextRow.getCell(4).toString());
		    		 }
		    	   }
		    	 }else{
		    		 unsuccessfullStudentList.add(nextRow.getCell(3).toString()+StringPool.COMMA+nextRow.getCell(4).toString());
		    	 }
	    	 }else{
	    		 totalStudentCount--;
	    	 }
	     }
	     
	     response.setRenderParameter("totalStudentCount", String.valueOf(totalStudentCount));
	     response.setRenderParameter("successImportedStudentCount", String.valueOf(successImportedStudentCount));
	     response.setRenderParameter("UnsuccessImportedStudentCount", String.valueOf(totalStudentCount-successImportedStudentCount));
	     response.setRenderParameter("isImported",String.valueOf(true));
	     SessionMessages.add(request, "student-import-success");
	     PortalCache portalCache =   MultiVMPoolUtil.getCache(Student.class.getName());
    	 portalCache.put("unsuccessfullStudentList", unsuccessfullStudentList);
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
		 }else if(!firstRow.getCell(15).toString().trim().equalsIgnoreCase("GPA (0.00 to 4.00)")){
			 return false;
		 }else if(!firstRow.getCell(16).toString().trim().equalsIgnoreCase("Pace (Slow/Mid/Quick)")){
			 return false;
		 }else if(!firstRow.getCell(17).toString().trim().equalsIgnoreCase("School")){
			 return false;
		 }else if(!firstRow.getCell(18).toString().trim().equalsIgnoreCase("Campus")){
			 return false;
		 }else if(!firstRow.getCell(19).toString().trim().equalsIgnoreCase("Profession")){
			 return false;
		 }else if(!firstRow.getCell(20).toString().trim().equalsIgnoreCase("Shift")){
			 return false;
		 }else if(!firstRow.getCell(21).toString().trim().equalsIgnoreCase("Ethnicity")){
			 return false;
		 }else if(!firstRow.getCell(22).toString().trim().equalsIgnoreCase("Graduation Date")){
			 return false;
		 }else if(!firstRow.getCell(23).toString().trim().equalsIgnoreCase("Externship Start Date")){
			 return false;
		 }else{
			 return true;
		 }
	 }
	
	private boolean validateRow(Row row){
		if(Validator.isNull(row.getCell(0).toString().trim())){
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
		 }else if(Validator.isNull(row.getCell(8).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(9).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(10).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(12).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(13).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(15).toString().trim())){
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
	 
	 public boolean checkIfRowIsEmpty(Row row) {
		    if (row == null) {
		        return true;
		    }
		    if (row.getLastCellNum() <= 0) {
		        return true;
		    }
		    for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
		        Cell cell = row.getCell(cellNum);
		        if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK && Validator.isNotNull(cell.toString())) {
		            return false;
		        }
		    }
		    return true;
		}
}
