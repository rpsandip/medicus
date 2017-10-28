package com.medicus.common.service.bean;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;

public class StudentBean {
	
	Log _log = LogFactoryUtil.getLog(StudentBean.class.getName());
	
	private long studentId;
	private String stundetCampusId;
	private long campusId;
	private String campusName;
	private long schoolId;
	private String firstName;
	private String lastName;
	private String middleName;
	private String dateOfBirth;
	private String profession;
	private String gender;
	private String profileURL;
	private String primaryLanguages;
	
	public StudentBean(Student student){
		if(Validator.isNotNull(student)){
		this.studentId = student.getStudentId();
		this.stundetCampusId = student.getStundetCampusId();
		this.campusId = student.getCampusId();
		this.schoolId = student.getSchoolId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.gender = student.getGender();
		this.profession  = student.getProfession();
		this.primaryLanguages = student.getPrimaryLanguage();
		
		if(this.campusId>0){
			try {
				Campus campus = CampusLocalServiceUtil.getCampus(this.campusId);
				this.campusName = campus.getName();
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		
		if(student.getProfileImageId()>0){
			DLFileEntry fileEntry;
			try {
				fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(student.getProfileImageId());
				this.profileURL = MedicusCommonLocalServiceUtil.getDLFileURL(fileEntry);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
	  }	
	}
	
	
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStundetCampusId() {
		return stundetCampusId;
	}
	public void setStundetCampusId(String stundetCampusId) {
		this.stundetCampusId = stundetCampusId;
	}
	public long getCampusId() {
		return campusId;
	}
	public void setCampusId(long campusId) {
		this.campusId = campusId;
	}
	public long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCampusName() {
		return campusName;
	}
	public void setCampusName(String campusName) {
		this.campusName = campusName;
	}
	public String getProfileURL() {
		return profileURL;
	}
	public void setProfileURL(String profileURL) {
		this.profileURL = profileURL;
	}


	public String getPrimaryLanguages() {
		return primaryLanguages;
	}


	public void setPrimaryLanguages(String primaryLanguages) {
		this.primaryLanguages = primaryLanguages;
	}
	
	
}
