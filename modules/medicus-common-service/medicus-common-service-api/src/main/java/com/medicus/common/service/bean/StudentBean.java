package com.medicus.common.service.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.School;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.SchoolLocalServiceUtil;

public class StudentBean {
	
	Log _log = LogFactoryUtil.getLog(StudentBean.class.getName());
	
	private long studentId;
	private String stundetCampusId;
	private long campusId;
	private String campusName;
	private long schoolId;
	private String schoolName;
	private String firstName;
	private String lastName;
	private String middleName;
	private Date dateOfBirth;
	private String profession;
	private String gender;
	private DocumentBean profileDoc;
	private String primaryLanguages;
	private String contactNumber;
	private String homeNumber;
	private String emailAddress;
	private String secondaryLanguage;
	private String address;
	private String city;
	private String zipcode;
	private String state;
	private String pace;
	private String ethnicityDesc;
	private float gpa;
	private DocumentBean resumeDoc;
	private boolean hired;
	private Date graduationDate;
	private boolean activelySeekingEmployment;
	private boolean haveExternship;
	private List<DocumentBean> agreementDocs = new ArrayList<DocumentBean>();
	private List<DocumentBean> othetAttachments=new ArrayList<DocumentBean>();
	private List<DocumentBean> timeSheets=new ArrayList<DocumentBean>();
	
	public StudentBean(Student student){
		if(Validator.isNotNull(student)){
		this.studentId = student.getStudentId();
		this.stundetCampusId = student.getStundetCampusId();
		this.campusId = student.getCampusId();
		this.schoolId = student.getSchoolId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		if(Validator.isNotNull(student.getMiddleName())){
			this.middleName = student.getMiddleName();
		}
		this.dateOfBirth = student.getDateOfBirth();
		this.gender = student.getGender();
		this.profession  = student.getProfession();
		this.primaryLanguages = student.getPrimaryLanguage();
		if(Validator.isNotNull(student.getContactNumber())){
			this.contactNumber = student.getContactNumber();
		}
		if(Validator.isNotNull(student.getHomePhoneNumber())){
			this.homeNumber = student.getHomePhoneNumber();
		}
		this.emailAddress = student.getEmailAddress();
		if(Validator.isNotNull(student.getSecondaryLanguage())){
			this.secondaryLanguage = student.getSecondaryLanguage();
		}
		if(Validator.isNotNull(student.getAddress())){
			this.address = student.getAddress();
		}
		if(Validator.isNotNull(student.getCity())){
			this.city = student.getCity();
		}
		if(Validator.isNotNull(student.getZipcode())){
			this.zipcode = student.getZipcode();
		}
		if(Validator.isNotNull(student.getState())){
			this.state = student.getState();
		}
		this.pace = student.getPace();
		this.gpa = student.getGpa();
		this.hired = student.getHired();
		this.graduationDate = student.getGraduationDate();
		this.activelySeekingEmployment = student.getActivelySeekingEmployment();
		this.haveExternship = student.getHaveExternship();
		this.ethnicityDesc = student.getEthnicityDesc();
		if(this.campusId>0){
			try {
				Campus campus = CampusLocalServiceUtil.getCampus(this.campusId);
				this.campusName = campus.getName();
			} catch (PortalException e) {
				_log.debug(e);
			}
		}
		
		if(this.schoolId>0){
			try {
				School school = SchoolLocalServiceUtil.getSchool(this.schoolId);
				this.schoolName = school.getName();
			} catch (PortalException e) {
				_log.debug(e);
			}
		}
		
		if(student.getProfileImageId()>0){
			DLFileEntry fileEntry;
			try {
				fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(student.getProfileImageId());
				DocumentBean profileDoc = new DocumentBean(fileEntry);
				this.profileDoc = profileDoc;
				
			} catch (PortalException e) {
				_log.debug(e);
			}
		}
		
		if(student.getResumeFileEntryId()>0){
			DLFileEntry fileEntry;
			try {
				fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(student.getResumeFileEntryId());
				DocumentBean resumeDoc = new DocumentBean(fileEntry);
				this.resumeDoc = resumeDoc;
			} catch (PortalException e) {
				_log.debug(e);
			}
		}
		
		long medicusGroupId = MedicusCommonLocalServiceUtil.getMedicusGroupId();

		Folder studentFolder=null;
		try {
			studentFolder = DLAppServiceUtil.getFolder(medicusGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, String.valueOf(student.getStudentId()));
		} catch (PortalException e1) {
			_log.error(e1);
		}
		
		try{
			if(Validator.isNotNull(studentFolder)){
				//Agreements Documents folder 
				Folder agreementsFolder = DLAppServiceUtil.getFolder(medicusGroupId, studentFolder.getFolderId(), "Agreements");
				if(Validator.isNotNull(agreementsFolder)){
					List<FileEntry> agreementsDocuments = DLAppServiceUtil.getFileEntries(medicusGroupId, agreementsFolder.getFolderId());
					for(FileEntry fileEntry : agreementsDocuments){
						DocumentBean documentBean = new DocumentBean(fileEntry);
						this.agreementDocs.add(documentBean);
					}
					
				}
			}
		}catch(PortalException e){
			_log.debug(e.getMessage());
		}
		
		try{
			if(Validator.isNotNull(studentFolder)){
				//Other Docuement folder 
				Folder otherDocumentsFolder = DLAppServiceUtil.getFolder(medicusGroupId, studentFolder.getFolderId(), "Other Documents");
				if(Validator.isNotNull(otherDocumentsFolder)){
					List<FileEntry> otherDocuments = DLAppServiceUtil.getFileEntries(medicusGroupId, otherDocumentsFolder.getFolderId());
					for(FileEntry fileEntry : otherDocuments){
						DocumentBean documentBean = new DocumentBean(fileEntry);
						this.othetAttachments.add(documentBean);
					}
					
				}
			}
		}catch(PortalException e){
			_log.debug(e.getMessage());
		}
		
		try{
			if(Validator.isNotNull(studentFolder)){
				//TimeSheet documents folder 
				Folder timeSheetDocumentFolder = DLAppServiceUtil.getFolder(medicusGroupId, studentFolder.getFolderId(), "Timesheets");
				if(Validator.isNotNull(timeSheetDocumentFolder)){
					List<FileEntry> timeSheetDocuments = DLAppServiceUtil.getFileEntries(medicusGroupId, timeSheetDocumentFolder.getFolderId());
					for(FileEntry fileEntry : timeSheetDocuments){
						DocumentBean documentBean = new DocumentBean(fileEntry);
						this.timeSheets.add(documentBean);
					}
					
				}
			}
		}catch(PortalException e){
			_log.debug(e.getMessage());
		}
		
		
	  }	
	}
	
	public StudentBean(Student student,boolean showAsProfile){
		if(Validator.isNotNull(student)){
			this.studentId = student.getStudentId();
			this.stundetCampusId = student.getStundetCampusId();
			this.campusId = student.getCampusId();
			this.schoolId = student.getSchoolId();
			this.firstName = student.getFirstName();
			this.lastName = student.getLastName();
			this.activelySeekingEmployment = student.getActivelySeekingEmployment();
			if(Validator.isNotNull(student.getMiddleName())){
				this.middleName = student.getMiddleName();
			}
			this.gender = student.getGender();
			this.profession  = student.getProfession();
			this.primaryLanguages = student.getPrimaryLanguage();
			this.emailAddress = student.getEmailAddress();
			if(Validator.isNotNull(student.getZipcode())){
				this.zipcode = student.getZipcode();
			}
			if(this.campusId>0){
				try {
					Campus campus = CampusLocalServiceUtil.getCampus(this.campusId);
					this.campusName = campus.getName();
				} catch (PortalException e) {
					_log.debug(e);
				}
			}
			
			if(this.schoolId>0){
				try {
					School school = SchoolLocalServiceUtil.getSchool(this.schoolId);
					this.schoolName = school.getName();
				} catch (PortalException e) {
					_log.debug(e);
				}
			}
			
			if(student.getProfileImageId()>0){
				DLFileEntry fileEntry;
				try {
					fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(student.getProfileImageId());
					DocumentBean profileDoc = new DocumentBean(fileEntry);
					this.profileDoc = profileDoc;
					
				} catch (PortalException e) {
					_log.debug(e);
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
	
	public String getPrimaryLanguages() {
		return primaryLanguages;
	}
	public void setPrimaryLanguages(String primaryLanguages) {
		this.primaryLanguages = primaryLanguages;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getHomeNumber() {
		return homeNumber;
	}


	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getSecondaryLanguage() {
		return secondaryLanguage;
	}


	public void setSecondaryLanguage(String secondaryLanguage) {
		this.secondaryLanguage = secondaryLanguage;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPace() {
		return pace;
	}


	public void setPace(String pace) {
		this.pace = pace;
	}


	public float getGpa() {
		return gpa;
	}


	public void setGpa(float gpa) {
		this.gpa = gpa;
	}


	public boolean isHired() {
		return hired;
	}


	public void setHired(boolean hired) {
		this.hired = hired;
	}


	public Date getGraduationDate() {
		return graduationDate;
	}


	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}


	public boolean isActivelySeekingEmployment() {
		return activelySeekingEmployment;
	}


	public void setActivelySeekingEmployment(boolean activelySeekingEmployment) {
		this.activelySeekingEmployment = activelySeekingEmployment;
	}


	public boolean isHaveExternship() {
		return haveExternship;
	}


	public void setHaveExternship(boolean haveExternship) {
		this.haveExternship = haveExternship;
	}


	public String getSchoolName() {
		return schoolName;
	}


	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public DocumentBean getProfileDoc() {
		return profileDoc;
	}


	public void setProfileDoc(DocumentBean profileDoc) {
		this.profileDoc = profileDoc;
	}


	public DocumentBean getResumeDoc() {
		return resumeDoc;
	}


	public void setResumeDoc(DocumentBean resumeDoc) {
		this.resumeDoc = resumeDoc;
	}


	public List<DocumentBean> getAgreementDocs() {
		return agreementDocs;
	}


	public void setAgreementDocs(List<DocumentBean> agreementDocs) {
		this.agreementDocs = agreementDocs;
	}


	public List<DocumentBean> getOthetAttachments() {
		return othetAttachments;
	}


	public void setOthetAttachments(List<DocumentBean> othetAttachments) {
		this.othetAttachments = othetAttachments;
	}


	public List<DocumentBean> getTimeSheets() {
		return timeSheets;
	}


	public void setTimeSheets(List<DocumentBean> timeSheets) {
		this.timeSheets = timeSheets;
	}

	public String getEthnicityDesc() {
		return ethnicityDesc;
	}

	public void setEthnicityDesc(String ethnicityDesc) {
		this.ethnicityDesc = ethnicityDesc;
	}

	

	
	
}
