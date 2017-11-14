package com.medicus.student.portlet.portlet.actioncommand;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.student.portlet.portlet.StudentPortletConstant;


@Component(
	    property = {
	    	"javax.portlet.name=" + StudentPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_student"
	    },
	    service = MVCActionCommand.class
	)
public class AddStudentActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(AddStudentActionCommand.class.getName());
	
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){
				
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
			long studentId = ParamUtil.getLong(actionRequest, "studentId");
			String studentCampusId = ParamUtil.getString(actionRequest, "campusStudentId");
			String firstName = ParamUtil.getString(actionRequest, "firstName");
			String middleName = ParamUtil.getString(actionRequest, "middleName");
			String lastName = ParamUtil.getString(actionRequest, "lastName");
			String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date dob = ParamUtil.getDate(actionRequest, "dob", df);
			String gender = ParamUtil.getString(actionRequest, "gender");
			String contactNo= ParamUtil.getString(actionRequest, "contactNo");
			String homePhoneNumber = ParamUtil.getString(actionRequest, "homePhoneNumber");
			String[] primaryLanguageArray = ParamUtil.getStringValues(actionRequest, "primaryLanguage");
			String[] secondaryLanguageArray = ParamUtil.getStringValues(actionRequest, "secondaryLanguage");
			String address = ParamUtil.getString(actionRequest, "address");
			String city = ParamUtil.getString(actionRequest, "city");
			String zipcode = ParamUtil.getString(actionRequest, "zipcode");
			String state = ParamUtil.getString(actionRequest, "state");
			String pace= ParamUtil.getString(actionRequest, "pace");
			float gpa = ParamUtil.getFloat(actionRequest, "gpa");
			long schoolId = ParamUtil.getLong(actionRequest, "school");
			long campusId = ParamUtil.getLong(actionRequest, "campus");
			String profession = ParamUtil.getString(actionRequest, "profession");
			String practices = ParamUtil.getString(actionRequest, "practices");
			boolean haveExternship = ParamUtil.getBoolean(actionRequest, "haveExternship");
			long partnerId = ParamUtil.getLong(actionRequest, "partnerName");
			String partnerZipCode = ParamUtil.getString(actionRequest, "partnerZipCode");
			String partnerWebSiteLink = ParamUtil.getString(actionRequest, "partnerWebSiteLink");
			int externshipStatus = ParamUtil.getInteger(actionRequest, "externshipStatus");
			boolean isApproveInterviewRequest = ParamUtil.getBoolean(actionRequest, "isApproveInterviewRequest");
			
			Date externshipStartDate = null;
			Date externshipEndDate = null;
			int noOfHoursPerWeek = ParamUtil.getInteger(actionRequest, "noOfHoursPerWeek");
			Date midPointReviewDate =  null;
			String midPointReviewComment = ParamUtil.getString(actionRequest, "midPointReviewComment");
			Date finalReviewDate = null;
			String finalPointReviewComment = ParamUtil.getString(actionRequest, "finalPointReviewComment");
			boolean isHired = ParamUtil.getBoolean(actionRequest, "hired");
			Date graduationDate = null;
			boolean activelySeekingEmployment = ParamUtil.getBoolean(actionRequest, "activelySeekingEmployment");
			long employerId = ParamUtil.getLong(actionRequest, "employer");		
			
			try {
				externshipStartDate = df.parse(ParamUtil.getString(actionRequest, "externshipStartDate"));
			} catch (ParseException e) {
				_log.error(e.getMessage());
			}
			try {
				externshipEndDate = df.parse(ParamUtil.getString(actionRequest, "externshipEndDate"));
			} catch (ParseException e) {
				_log.error(e.getMessage());
			}	
			try {
				midPointReviewDate = df.parse(ParamUtil.getString(actionRequest, "midPointReviewDate"));
			} catch (ParseException e) {
				_log.error(e.getMessage());
			}	
			try {
				finalReviewDate = df.parse(ParamUtil.getString(actionRequest, "finalReviewDate"));
			} catch (ParseException e) {
				_log.error(e.getMessage());
			}	
			try {
				graduationDate = df.parse(ParamUtil.getString(actionRequest, "graduationDate"));
			} catch (ParseException e) {
				_log.error(e.getMessage());
			}	
					
			
			
			// Files
			File profilePic = uploadPortletRequest.getFile("profilePic");
			File resume = uploadPortletRequest.getFile("resume");
			String profilePicFileName = uploadPortletRequest.getFileName("profilePic");
			String resumeFileName = uploadPortletRequest.getFileName("resume");
			Map<String, FileItem[]> files= uploadPortletRequest.getMultipartParameterMap();
			Map<String, File> agreementsFileMap = new HashMap<String, File>();
			Map<String, File> othersFileMap = new HashMap<String, File>();
			Map<String, File> timeSheetsMap = new HashMap<String, File>();
			for (Entry<String, FileItem[]> file2 : files.entrySet()) {
				FileItem item[] =file2.getValue();
				String name  = file2.getKey();
				if(name.startsWith("other")){
					for (FileItem fileItem : item) {
						String fileName = fileItem.getFileName();
						File file = fileItem.getStoreLocation();
						othersFileMap.put(fileName, file);
					}
				}
				if(name.startsWith("agreements")){
					for (FileItem fileItem : item) {
						String fileName = fileItem.getFileName();
						File file = fileItem.getStoreLocation();
						agreementsFileMap.put(fileName, file);
					}
				}
				if(name.startsWith("timesheets")){
					for (FileItem fileItem : item) {
						String fileName = fileItem.getFileName();
						File file = fileItem.getStoreLocation();
						timeSheetsMap.put(fileName, file);
					}
				}
			}
			
			String primaryLanguage = StringPool.BLANK;
			String secondaryLanugage = StringPool.BLANK;
			for(String lang : primaryLanguageArray){
				primaryLanguage += lang + StringPool.COMMA;
			}
			for(String lang : secondaryLanguageArray){
				secondaryLanugage += lang + StringPool.COMMA;
			}
			if(primaryLanguage.indexOf(StringPool.COMMA)>0){
				primaryLanguage = primaryLanguage.substring(0, primaryLanguage.lastIndexOf(StringPool.COMMA));
			}
			if(secondaryLanugage.indexOf(StringPool.COMMA)>0){
				secondaryLanugage = secondaryLanugage.substring(0, secondaryLanugage.lastIndexOf(StringPool.COMMA));
			}
			
			if(studentId==0){
				
				Student student = StudentLocalServiceUtil.getStudentByStudentCampusId(studentCampusId);
				
				if(Validator.isNull(student) && Validator.isNotNull(studentCampusId)){
					 student = StudentLocalServiceUtil.addStudent(schoolId, campusId, studentCampusId, firstName, middleName,lastName,
							emailAddress, dob, gender, contactNo, homePhoneNumber,primaryLanguage, secondaryLanugage, address, city,zipcode, state, pace, gpa,profession,
							practices, isHired, graduationDate, activelySeekingEmployment, haveExternship, employerId,partnerId,externshipStatus,
							partnerZipCode, partnerWebSiteLink, externshipStartDate, externshipEndDate, 
							noOfHoursPerWeek, midPointReviewDate, midPointReviewComment, finalReviewDate,
							finalPointReviewComment, profilePic, profilePicFileName,resume, resumeFileName,agreementsFileMap,
							othersFileMap, timeSheetsMap,themeDisplay.getUserId());
					
					if(Validator.isNotNull(student)){
						SessionMessages.add(actionRequest, "student-add-success");
					}else{
						SessionErrors.add(actionRequest, "student-add-error");
					}
				}else{
					SessionErrors.add(actionRequest, "student-exist");
				}
			}else{
				
				Student student = StudentLocalServiceUtil.getStudentByStudentCampusId(studentCampusId);
				
				if(Validator.isNotNull(student) && Validator.isNotNull(studentCampusId)){
					try {
						 student = StudentLocalServiceUtil.updateStudent(studentId, schoolId, campusId, studentCampusId, firstName, middleName,lastName,
								emailAddress, dob, gender, contactNo, homePhoneNumber,primaryLanguage, secondaryLanugage, address, city,zipcode, state, pace, gpa,profession,
								practices, isHired, graduationDate, activelySeekingEmployment, haveExternship, employerId,partnerId,externshipStatus,
								partnerZipCode, partnerWebSiteLink, externshipStartDate, externshipEndDate, 
								noOfHoursPerWeek, midPointReviewDate, midPointReviewComment, finalReviewDate,
								finalPointReviewComment, profilePic, profilePicFileName,resume, resumeFileName,agreementsFileMap,
								othersFileMap, timeSheetsMap,isApproveInterviewRequest, themeDisplay.getUserId());
						SessionMessages.add(actionRequest, "student-update-success");
					} catch (PortalException e) {
						SessionErrors.add(actionRequest, "student-update-error");
					}
				}else{
					SessionErrors.add(actionRequest, "student-update-exist");
				}
			}
	}	
	

}
