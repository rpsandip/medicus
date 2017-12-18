/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.medicus.common.service.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexSearcherHelperUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.SortFactoryUtil;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.medicus.common.service.bean.GrooupByEntityBean;
import com.medicus.common.service.exception.NoSuchStudentException;
import com.medicus.common.service.model.Interview_Request;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.model.Student_Externship;
import com.medicus.common.service.service.Interview_RequestLocalServiceUtil;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.common.service.service.Student_ExternshipLocalServiceUtil;
import com.medicus.common.service.service.base.StudentLocalServiceBaseImpl;
import com.medicus.common.service.util.Interview_RequestStatus;
import com.medicus.common.service.util.MedicusConstant;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the student local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.medicus.common.service.service.StudentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudentLocalServiceBaseImpl
 * @see com.medicus.common.service.service.StudentLocalServiceUtil
 */
@ProviderType
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
	
	Log _log = LogFactoryUtil.getLog(StudentLocalServiceImpl.class.getName());
	
	/*
	 * Add Student Detail
	 */
	public Student addStudent(long schoolId, long campusId, String studentCampusId, String firstName, String middleName,String lastName, String emailAddress,
			Date dob, String gender, String contactNumber, String homePhoneNumber,String primaryLang, String secondaryLangs, String address, String city, String zipcode, String state, String pace,
			float gpa, String profession, String practices, boolean hired, Date graduationDate, boolean activelySeekingEmployment, boolean haveExternship,
			long employerId, long partnerId, int externshipStatus, String partnerZipCode, String partnerWebSiteLink,Date externshipStartDate, Date externshipEndDate, int noOfHoursPerWeek,
			Date midPointReviewDate,String midPointReviewComment,Date finalReviewDate, String finalPointReviewComment, String raceDesc, String shiftDesc,
			File profileImage, String profileImageFileName,File resume, String resumeFileName, Map<String, File> agreementFileMap, Map<String, File> othersFileMap, Map<String, File> timeSheetsFileMap,long createdBy ){
		
		// Check Student is Exist with studentCampusId
		Student student = getStudentByStudentCampusId(studentCampusId);
		if(Validator.isNull(student)){
		
		// Add student record
		student = StudentLocalServiceUtil.createStudent(counterLocalService.increment());
		student.setSchoolId(schoolId);
		student.setCampusId(campusId);
		student.setStundetCampusId(studentCampusId);
		student.setFirstName(firstName);
		student.setMiddleName(middleName);
		student.setLastName(lastName);
		student.setEmailAddress(emailAddress);
		student.setDateOfBirth(dob);
		student.setGender(gender);
		student.setContactNumber(contactNumber);
		student.setHomePhoneNumber(homePhoneNumber);
		student.setPrimaryLanguage(primaryLang);
		student.setSecondaryLanguage(secondaryLangs);
		student.setAddress(address);
		student.setCity(city);
		student.setZipcode(zipcode);
		student.setState(state);
		student.setPace(pace);
		student.setGpa(gpa);
		student.setStatus(0);
		student.setProfession(profession);
		student.setPractices(practices);
		student.setHired(hired);
		student.setGraduationDate(graduationDate);
		student.setActivelySeekingEmployment(activelySeekingEmployment);
		student.setHaveExternship(haveExternship);
		student.setRaceDesc(raceDesc);
		student.setCompanyId(PortalUtil.getDefaultCompanyId());
		student.setCreatedBy(createdBy);
		student.setModifiedBy(createdBy);
		student.setCreateDate(new Date());
		student.setModifiedDate(new Date());
		
		student = StudentLocalServiceUtil.addStudent(student);
		
		if(haveExternship){
			// Add Externship Detail
			Student_ExternshipLocalServiceUtil.addStudentExternship(student.getStudentId(), partnerId, employerId, externshipStatus,externshipStartDate, externshipEndDate,
				noOfHoursPerWeek, midPointReviewDate, midPointReviewComment, finalReviewDate, finalPointReviewComment, shiftDesc,createdBy);
		}
		// Get Global groupId and Student Id folder
		long medicusOrgGrouId = MedicusCommonLocalServiceUtil.getMedicusGroupId();
		Folder studentIdFolder = MedicusCommonLocalServiceUtil.getFolder(medicusOrgGrouId, 0l, String.valueOf(student.getStudentId()));
		
		
		if(Validator.isNotNull(studentIdFolder)){
			ServiceContext serviceContext = new ServiceContext(); 
			if(Validator.isNotNull(profileImageFileName)){
				// Add Profile Images
				 try{
					FileEntry fileEntry = DLAppServiceUtil.addFileEntry(medicusOrgGrouId, studentIdFolder.getFolderId(),  profileImageFileName, MimeTypesUtil.getContentType(profileImage),  profileImageFileName, StringPool.BLANK , StringPool.BLANK, profileImage, serviceContext);
					student.setProfileImageId(fileEntry.getFileEntryId());
				 }catch(PortalException e){
					 _log.error(e);
				 }
			}
			 
			if(Validator.isNotNull(resumeFileName)){
				
				// Add resume
				 try{
					FileEntry fileEntry = DLAppServiceUtil.addFileEntry(medicusOrgGrouId, studentIdFolder.getFolderId(),  resumeFileName, MimeTypesUtil.getContentType(resume),  resumeFileName, StringPool.BLANK , StringPool.BLANK, resume, serviceContext);
					student.setResumeFileEntryId(fileEntry.getFileEntryId());
				  }catch(PortalException e){
				 	 _log.error(e.getMessage());
				  } 
			}
			
			// Add Agreements
			Folder agreementsFolder = MedicusCommonLocalServiceUtil.getFolder(medicusOrgGrouId, studentIdFolder.getFolderId(), "Agreements");
			if(Validator.isNotNull(agreementsFolder)){
				for (Entry<String, File> fileDetail : agreementFileMap.entrySet()) {
					try{
						FileEntry fileEntry = DLAppServiceUtil.addFileEntry(medicusOrgGrouId, agreementsFolder.getFolderId(),  fileDetail.getKey(), MimeTypesUtil.getContentType(fileDetail.getValue()),  fileDetail.getKey(), StringPool.BLANK , StringPool.BLANK, fileDetail.getValue(), serviceContext);
					  }catch(PortalException e){
					 	 _log.error(e.getMessage());
					  }
				}
			} 
			
			
			 // Add attachment
			Folder otherDocumentsFolder = MedicusCommonLocalServiceUtil.getFolder(medicusOrgGrouId, studentIdFolder.getFolderId(), "Other Documents");
			if(Validator.isNotNull(otherDocumentsFolder)){
				for (Entry<String, File> fileDetail : othersFileMap.entrySet()) {
					try{
						FileEntry fileEntry = DLAppServiceUtil.addFileEntry(medicusOrgGrouId, otherDocumentsFolder.getFolderId(),  fileDetail.getKey(), MimeTypesUtil.getContentType(fileDetail.getValue()),  fileDetail.getKey(), StringPool.BLANK , StringPool.BLANK, fileDetail.getValue(), serviceContext);
					  }catch(PortalException e){
					 	 _log.error(e.getMessage());
					  }
				}
			}
			
			// Add Time Sheets
			Folder timeSheetsFolder = MedicusCommonLocalServiceUtil.getFolder(medicusOrgGrouId, studentIdFolder.getFolderId(), "Timesheets");
			if(Validator.isNotNull(timeSheetsFolder)){
				for (Entry<String, File> fileDetail : timeSheetsFileMap.entrySet()) {
					try{
						FileEntry fileEntry = DLAppServiceUtil.addFileEntry(medicusOrgGrouId, timeSheetsFolder.getFolderId(),  fileDetail.getKey(), MimeTypesUtil.getContentType(fileDetail.getValue()),  fileDetail.getKey(), StringPool.BLANK , StringPool.BLANK, fileDetail.getValue(), serviceContext);
					  }catch(PortalException e){
					 	 _log.error(e.getMessage());
					  }
				}
			}
			
			
			
			// Update student records
			student = StudentLocalServiceUtil.updateStudent(student);
		}
		
		// Index Student detail
		Indexer<Student> studentIndexer = IndexerRegistryUtil.getIndexer(Student.class);
		try {
			studentIndexer.reindex(student);
			_log.info("Student Index created ->" + student.getStudentId());
		} catch (SearchException e) {
			_log.error("Erro while index student -> "+ student.getStudentId() + " MSG:: " + e.getMessage());
		}

	
	  }
		
		return student;
		
	}
	/*
	 * Update Student
	 */
	public Student updateStudent(long studentId, long schoolId, long campusId, String studentCampusId, String firstName, String middleName,String lastName, String emailAddress,
			Date dob, String gender, String contactNumber, String homePhoneNumber,String primaryLang, String secondaryLangs, String address, String city, String zipcode, String state, String pace,
			float gpa, String profession, String practices, boolean hired, Date graduationDate, boolean activelySeekingEmployment, boolean haveExternship,
			long employerId,long partnerId, int externshipStatus,String partnerZipCode, String partnerWebSiteLink,Date externshipStartDate, Date externshipEndDate, int noOfHoursPerWeek,
			Date midPointReviewDate,String midPointReviewComment,Date finalReviewDate, String finalPointReviewComment,String raceDesc, String shiftDesc,
			File profileImage, String profileImageFileName,File resume, String resumeFileName,Map<String, File> agreementFileMap, Map<String, File> othersFileMap,  Map<String,File> timeSheetsFileMap,boolean isApprovedInterviewRequest,long modifiedBy) throws PortalException{
		
			Student student = null;
		    
			student = StudentLocalServiceUtil.getStudent(studentId);
		    
			if(Validator.isNotNull(student) && student.getStundetCampusId().equals(studentCampusId)){
			
			student.setSchoolId(schoolId);
			student.setCampusId(campusId);
			student.setFirstName(firstName);
			student.setMiddleName(middleName);
			student.setLastName(lastName);
			student.setEmailAddress(emailAddress);
			student.setDateOfBirth(dob);
			student.setGender(gender);
			student.setContactNumber(contactNumber);
			student.setHomePhoneNumber(homePhoneNumber);
			student.setPrimaryLanguage(primaryLang);
			student.setSecondaryLanguage(secondaryLangs);
			student.setAddress(address);
			student.setCity(city);
			student.setZipcode(zipcode);
			student.setState(state);
			student.setPace(pace);
			student.setGpa(gpa);
			student.setProfession(profession);
			student.setPractices(practices);
			student.setHired(hired);
			student.setGraduationDate(graduationDate);
			student.setActivelySeekingEmployment(activelySeekingEmployment);
			student.setHaveExternship(haveExternship);
			student.setRaceDesc(raceDesc);
			student.setModifiedBy(modifiedBy);
			student.setModifiedDate(new Date());
			
			student = StudentLocalServiceUtil.updateStudent(student);
			
			// Update Student_Externship
			Student_Externship studentExternship = null;
			try{
				studentExternship = Student_ExternshipLocalServiceUtil.getStudentExternship(studentId);
			}catch(PortalException e){
				_log.error(e.getMessage());
			}
			
			if(haveExternship && Validator.isNotNull(studentExternship)){
				// Update Existing Student Externship
				studentExternship = Student_ExternshipLocalServiceUtil.updateStudentExternship(studentExternship,student.getStudentId(), partnerId, employerId, externshipStatus,externshipStartDate, externshipEndDate,
					noOfHoursPerWeek, midPointReviewDate, midPointReviewComment, finalReviewDate, finalPointReviewComment, shiftDesc,modifiedBy);
			
			}else if(!haveExternship && Validator.isNotNull(studentExternship)) {
				// Delete Expternship
				Student_ExternshipLocalServiceUtil.deleteStudent_Externship(studentExternship);
				
				// Delete Externship documents 1. Agremeents 2. Other documents
				
				long medicusOrgGrouId = MedicusCommonLocalServiceUtil.getMedicusGroupId();
				
				try{
					Folder studentFolder = DLAppServiceUtil.getFolder(medicusOrgGrouId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, String.valueOf(student.getStudentId()));
					if(Validator.isNotNull(studentFolder)){
						
						Folder agreementsFolder = DLAppServiceUtil.getFolder(medicusOrgGrouId, studentFolder.getFolderId(), "Agreements");
						DLAppServiceUtil.deleteFolder(agreementsFolder.getFolderId());
					}
				}catch(PortalException e){
					_log.error(e.getMessage());
				}
				
				
				//Delete Other Document folder folders
				try{
					Folder studentFolder = DLAppServiceUtil.getFolder(medicusOrgGrouId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, String.valueOf(student.getStudentId()));
					if(Validator.isNotNull(studentFolder)){
						
						Folder otherDocumentsFolder = DLAppServiceUtil.getFolder(medicusOrgGrouId, studentFolder.getFolderId(), "Other Documents");
						DLAppServiceUtil.deleteFolder(otherDocumentsFolder.getFolderId());
					}
				}catch(PortalException e){
					_log.error(e.getMessage());
				}
			}else if(haveExternship && Validator.isNull(studentExternship)){
				// Add new Externship Detail
				Student_ExternshipLocalServiceUtil.addStudentExternship(student.getStudentId(), partnerId, employerId,  externshipStatus,externshipStartDate, externshipEndDate,
					noOfHoursPerWeek, midPointReviewDate, midPointReviewComment, finalReviewDate, finalPointReviewComment, shiftDesc,modifiedBy);
			}
			
			
			// Update approved Interivew Request
			if(isApprovedInterviewRequest){
				Interview_Request interviewRequest = Interview_RequestLocalServiceUtil.updateInterviewRequest(studentId, partnerId, Interview_RequestStatus.APPROVED.getValue(), modifiedBy);
				MedicusCommonLocalServiceUtil.sendApproveInterviewRequestMail(interviewRequest);
				if(Validator.isNull(interviewRequest)){
					_log.debug("error while update interview request studentId->" + studentId +" partnerId ->" + partnerId);
				}
			}
			
			// Get Global groupId and Student Id folder
			long medicusOrgGrouId = MedicusCommonLocalServiceUtil.getMedicusGroupId();
			Folder studentIdFolder = MedicusCommonLocalServiceUtil.getFolder(medicusOrgGrouId, 0l, String.valueOf(student.getStudentId()));
			
			if(Validator.isNotNull(studentIdFolder)){
				
				ServiceContext serviceContext = new ServiceContext(); 
				if(Validator.isNotNull(profileImageFileName)){
					if(student.getProfileImageId()>0){
						// Update Profile Images
						 try{
							FileEntry fileEntry = DLAppServiceUtil.updateFileEntry(student.getProfileImageId(), profileImageFileName, MimeTypesUtil.getContentType(profileImage),
									profileImage.getName(), StringPool.BLANK, StringPool.BLANK, false, profileImage, serviceContext);
							student.setProfileImageId(fileEntry.getFileEntryId());
						 }catch(PortalException e){
							 _log.error(e);
						 }
					}else{
						// Add Profile Image 
						try{
							FileEntry fileEntry = DLAppServiceUtil.addFileEntry(medicusOrgGrouId, studentIdFolder.getFolderId(),  profileImageFileName, MimeTypesUtil.getContentType(profileImage),  profileImageFileName, StringPool.BLANK , StringPool.BLANK, profileImage, serviceContext);
							student.setProfileImageId(fileEntry.getFileEntryId());
						 }catch(PortalException e){
							 _log.error(e);
						 }
					}
				}
				
				if(Validator.isNotNull(resumeFileName)){
					if(student.getResumeFileEntryId()>0){
						// Update Resume Images
						 try{
							FileEntry fileEntry = DLAppServiceUtil.updateFileEntry(student.getResumeFileEntryId(), resumeFileName, MimeTypesUtil.getContentType(resume),
									resumeFileName, StringPool.BLANK, StringPool.BLANK, false, resume, serviceContext);
							student.setResumeFileEntryId(fileEntry.getFileEntryId());
						 }catch(PortalException e){
							 _log.error(e);
						 }
					}else{
						// Add resume
						 try{
							FileEntry fileEntry = DLAppServiceUtil.addFileEntry(medicusOrgGrouId, studentIdFolder.getFolderId(),  resumeFileName, MimeTypesUtil.getContentType(resume),  resumeFileName, StringPool.BLANK , StringPool.BLANK, resume, serviceContext);
							student.setResumeFileEntryId(fileEntry.getFileEntryId());
						  }catch(PortalException e){
						 	 _log.error(e);
						  } 
					}
				}
				
				
				// Add agreements
				Folder agreementsFolder = MedicusCommonLocalServiceUtil.getFolder(medicusOrgGrouId, studentIdFolder.getFolderId(), "Agreements");
				if(Validator.isNotNull(agreementsFolder)){
					for (Entry<String, File> fileDetail : agreementFileMap.entrySet()) {
						try{
							if(Validator.isNotNull(fileDetail.getKey())){
								FileEntry fileEntry = DLAppServiceUtil.addFileEntry(medicusOrgGrouId, agreementsFolder.getFolderId(),  fileDetail.getKey(), MimeTypesUtil.getContentType(fileDetail.getValue()),  fileDetail.getKey(), StringPool.BLANK , StringPool.BLANK, fileDetail.getValue(), serviceContext);
							}
						  }catch(PortalException e){
						 	 _log.error(e);
						  }
					}
				}
				
				
				// Add attachment
				Folder otherDocumentsFolder = MedicusCommonLocalServiceUtil.getFolder(medicusOrgGrouId, studentIdFolder.getFolderId(), "Other Documents");
				if(Validator.isNotNull(otherDocumentsFolder)){
					for (Entry<String, File> fileDetail : othersFileMap.entrySet()) {
						try{
							if(Validator.isNotNull(fileDetail.getKey())){
								FileEntry fileEntry = DLAppServiceUtil.addFileEntry(medicusOrgGrouId, otherDocumentsFolder.getFolderId(),  fileDetail.getKey(), MimeTypesUtil.getContentType(fileDetail.getValue()),  fileDetail.getKey(), StringPool.BLANK , StringPool.BLANK, fileDetail.getValue(), serviceContext);
							}
						  }catch(PortalException e){
						 	 _log.error(e);
						  }
					}
				}
				
				// Add Time Sheets
				Folder timeSheetsFolder = MedicusCommonLocalServiceUtil.getFolder(medicusOrgGrouId, studentIdFolder.getFolderId(), "Timesheets");
				if(Validator.isNotNull(timeSheetsFolder)){
					for (Entry<String, File> fileDetail : timeSheetsFileMap.entrySet()) {
						try{
							FileEntry fileEntry = DLAppServiceUtil.addFileEntry(medicusOrgGrouId, timeSheetsFolder.getFolderId(),  fileDetail.getKey(), MimeTypesUtil.getContentType(fileDetail.getValue()),  fileDetail.getKey(), StringPool.BLANK , StringPool.BLANK, fileDetail.getValue(), serviceContext);
						  }catch(PortalException e){
						 	 _log.error(e.getMessage());
						  }
					}
				}
			}
			
			// Update student records
			student = StudentLocalServiceUtil.updateStudent(student);
			
			// Update reindex
			
			// Index Student detail
			Indexer<Student> studentIndexer = IndexerRegistryUtil.getIndexer(Student.class);
			try {
				studentIndexer.reindex(student);
				_log.info("Student Index updated ->" + student.getStudentId());
			} catch (SearchException e) {
				_log.error("Erro while update index student -> "+ student.getStudentId() + " MSG:: " + e.getMessage());
			}
	   }
		return student;
	}
	
	/*
	 * Create student while import it. While import we have limited information compare to UI
	 */
	public Student importStudent(String firstName, String middleName, String lastName, String emailAddress, Date dob,
			String studentCampusId, String address, String city, String zipcode, String state,String mobilePhone,
			String homePhone, String gender, String primaryLangs, String secondaryLangs, float gpa, String pace,String raceDesc,
			String shiftDesc, Date externshipStartDate,Date graduationDate,
			long schoolId, long campusId, String profession,long createdBy){
		
		// Add student record
		Student student = StudentLocalServiceUtil.createStudent(counterLocalService.increment());
		student.setFirstName(firstName);
		student.setMiddleName(middleName);
		student.setLastName(lastName);
		student.setEmailAddress(emailAddress);
		student.setDateOfBirth(dob);
		student.setStundetCampusId(studentCampusId);
		student.setAddress(address);
		student.setCity(city);
		student.setState(state);
		student.setZipcode(zipcode);
		student.setContactNumber(mobilePhone);
		student.setHomePhoneNumber(homePhone);
		student.setGender(gender);
		student.setPrimaryLanguage(primaryLangs);
		student.setSecondaryLanguage(secondaryLangs);
		student.setGpa(gpa);
		student.setProfession(profession);
		student.setStatus(0);
		student.setPace(pace);
		student.setGraduationDate(graduationDate);
		student.setRaceDesc(raceDesc);
		student.setSchoolId(schoolId);
		student.setCampusId(campusId);
		student.setProfession(profession);
		student.setHaveExternship(true);
		
		student.setCreatedBy(createdBy);
		student.setModifiedBy(createdBy);
		student.setCreateDate(new Date());
		student.setModifiedDate(new Date());
		
		student = StudentLocalServiceUtil.addStudent(student);
		
		if(Validator.isNotNull(student)){
			Student_Externship studentExternship = Student_ExternshipLocalServiceUtil.addStudentExternship(student.getStudentId(),
					0l, 0l, 0, externshipStartDate, null, 0,
					null, StringPool.BLANK, null, StringPool.BLANK, shiftDesc, createdBy);
		}
		
		// Index Student detail
		Indexer<Student> studentIndexer = IndexerRegistryUtil.getIndexer(Student.class);
		try {
			studentIndexer.reindex(student);
			_log.info("Student Index deleted ->" + student.getStudentId());
		} catch (SearchException e) {
			_log.error("Erro while index student -> "+ student.getStudentId() + " MSG:: " + e.getMessage());
		}
		
		return student;
	}
	
	
	public boolean deleteStudentDetail(long studentId) throws PortalException{
		boolean isDeleted = false;
		Student student = null;
		if(studentId>0){
			student = StudentLocalServiceUtil.getStudent(studentId);
			
			// Delete student documents
			long medicusOrgGrouId = MedicusCommonLocalServiceUtil.getMedicusGroupId();
			try{
				Folder studentFolder = DLAppServiceUtil.getFolder(medicusOrgGrouId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, String.valueOf(student.getStudentId()));
				DLAppServiceUtil.deleteFolder(studentFolder.getFolderId());
			}catch(PortalException e){
				_log.error(e.getMessage());
			}
			
			// Delete Student Externship
			try{
				Student_Externship student_Externship = Student_ExternshipLocalServiceUtil.getStudentExternship(studentId);
				Student_ExternshipLocalServiceUtil.deleteStudent_Externship(student_Externship);
			}catch(PortalException e){
				_log.error(e.getMessage());
			}
			
			// Delete inteview request
			List<Interview_Request> studentInteriewRequestList = Interview_RequestLocalServiceUtil.getInterviewRequestsByStudentId(studentId);
			for(Interview_Request interviewRequest : studentInteriewRequestList){
				Interview_RequestLocalServiceUtil.deleteInterview_Request(interviewRequest);
			}
			
			// Delete Student itself
			StudentLocalServiceUtil.deleteStudent(studentId);
			 
			isDeleted = true;
		 }	
		 if(Validator.isNotNull(student) && isDeleted){
			// Index Student detail
				Indexer<Student> studentIndexer = IndexerRegistryUtil.getIndexer(Student.class);
				try {
					studentIndexer.delete(PortalUtil.getDefaultCompanyId(), student.getUuid());
				} catch (SearchException e) {
					_log.error("Erro while delte index student -> "+ student.getStudentId() + " MSG:: " + e.getMessage());
				}
		 }
		return isDeleted;
	}
	
	public Student getStudentByStudentCampusId(String studentCampusId){
		Student student = null;
		try {
			return studentPersistence.findBystudentCampusId(studentCampusId);
		} catch (NoSuchStudentException e) {
			_log.error(e.getMessage());
		}
		return student;
	}
	
	public List<Student> searchStudents(String keyword, String zipcode, String gender, String profession, List<String> languages,
			long schoolId, long campusId, int start, int end){
		List<Student> studentList = new ArrayList<Student>();
		
		DynamicQuery dynamicQuery = StudentLocalServiceUtil.dynamicQuery();
		
		Criterion criterion = null;
		
		criterion  = RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.like("firstName", StringPool.PERCENT +keyword+StringPool.PERCENT),
					RestrictionsFactoryUtil.like("lastName", StringPool.PERCENT +keyword+StringPool.PERCENT));
			
		criterion = RestrictionsFactoryUtil.or(criterion, 
					RestrictionsFactoryUtil.like("emailAddress", StringPool.PERCENT +keyword+StringPool.PERCENT));
		
		if(Validator.isNotNull(zipcode)){
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("zipcode", zipcode));
		}
		
		if(languages.size()>0){
			Criterion langCriteria = RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.in("primaryLanguage", languages), RestrictionsFactoryUtil.in("secondaryLanguage", languages));
			criterion = RestrictionsFactoryUtil.and(criterion, langCriteria);
		}
		
		if(Validator.isNotNull(gender)){
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("gender", gender));
		}
		
		if(Validator.isNotNull(profession)){
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("profession", profession));
		}
		
		if(schoolId>0){
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("schoolId", schoolId));
		}
		
		if(campusId>0){
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("campusId", campusId));
		}
		
		if(Validator.isNotNull(criterion)){
			dynamicQuery.add(criterion);
		}
		
		
		dynamicQuery.setLimit(start, end);
		
		Order lastNameOrder = OrderFactoryUtil.asc("lastName");
		Order firstNameOrder = OrderFactoryUtil.asc("firstName");
		
		dynamicQuery.addOrder(lastNameOrder);
		dynamicQuery.addOrder(firstNameOrder);
		
		studentList = StudentLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		return studentList;
	}
	
	public JSONObject searchStudents(String keyword, String zipcode, String gender, String profession, List<String> languages,
			long schoolId, long campusId, int start, int end,  SearchContext searchContext){
		List<Student> studentList = new ArrayList<Student>();
		SearchContext countSearchContenct = searchContext;
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		
		try{
		BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
		
		// Add Student Class Name Criteria
	    searchQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, Student.class.getName());
	    
	    if(Validator.isNotNull(keyword)){
	    	 BooleanQuery lastNameQuery = new BooleanQueryImpl();
  	 	     lastNameQuery.addTerm(MedicusConstant.STUDENT_IDNEX_LASTNAME, keyword);

	         BooleanQuery firsNameQuery = new BooleanQueryImpl();
	         firsNameQuery.addTerm(MedicusConstant.STUDENT_IDNEX_FIRSTNAME, keyword);
	         
	         firsNameQuery.add(lastNameQuery, BooleanClauseOccur.SHOULD);
	         
	         BooleanQuery emailAddressQuery = new BooleanQueryImpl();
	         emailAddressQuery.addTerm(MedicusConstant.STUDENT_IDNEX_EMAIL_ADDRESS, keyword);
	         
	         emailAddressQuery.add(firsNameQuery, BooleanClauseOccur.SHOULD);
	         
	         BooleanQuery resumeQuery = new BooleanQueryImpl();
	         resumeQuery.addTerm(Field.CONTENT, keyword);
	         
	         resumeQuery.add(emailAddressQuery, BooleanClauseOccur.SHOULD);
	         
	 	    searchQuery.add(resumeQuery, BooleanClauseOccur.MUST);
	    }
	    
	    if(Validator.isNotNull(zipcode)){
	    	searchQuery.addRequiredTerm(MedicusConstant.STUDENT_IDNEX_ZIPCODE, zipcode);
	    }
	    
	    if(Validator.isNotNull(gender)){
	    	searchQuery.addRequiredTerm(MedicusConstant.STUDENT_IDNEX_GENDER, gender);
	    }
	    
	    if(Validator.isNotNull(profession)){
	    	BooleanQuery professionQuery = new BooleanQueryImpl();
	    	professionQuery.addRequiredTerm(MedicusConstant.STUDENT_IDNEX_PROFESSION, profession);
	    	searchQuery.add(professionQuery, BooleanClauseOccur.MUST);
	    }
	    
	    if(schoolId>0){
	    	searchQuery.addRequiredTerm(MedicusConstant.STUDENT_IDNEX_SCHOOLID, schoolId);
	    }
	    
	    if(campusId>0){
	    	searchQuery.addRequiredTerm(MedicusConstant.STUDENT_IDNEX_CAMPUSID, campusId);
	    }
	    
	    if(languages.size()>0){
	    	BooleanQuery langQuery = new BooleanQueryImpl();
	    	for(String lang : languages){
	    		BooleanQuery langQuery2 = new BooleanQueryImpl();
	    		langQuery2.addTerm(MedicusConstant.STUDENT_IDNEX_LANGUAGE, lang);
	    		langQuery.add(langQuery2, BooleanClauseOccur.SHOULD);
	    	}
	    	searchQuery.add(langQuery, BooleanClauseOccur.MUST);
	    }
	    
	    Sort sortLastName = SortFactoryUtil.create(MedicusConstant.STUDENT_IDNEX_LASTNAME, Sort.STRING_TYPE, false);
	    Sort sortFirstName = SortFactoryUtil.create(MedicusConstant.STUDENT_IDNEX_FIRSTNAME, Sort.STRING_TYPE, false);
	    searchContext.setSorts(sortLastName,sortFirstName);
	    searchContext.setStart(start);
	    searchContext.setEnd(end);
	    
	    Hits hits = IndexSearcherHelperUtil.search(searchContext, searchQuery);
		
	    Document[] documents = hits.getDocs();
	    
	    for(Document document : documents){
	    	try{
	    		Student student = StudentLocalServiceUtil.getStudent(Long.parseLong(document.get(Field.ENTRY_CLASS_PK)));
	    		studentList.add(student);
	    	}catch(Exception e){
	    		_log.debug(e.getMessage());
	    	}
	    }
	    	
	    jsonObject.put("totalHits", hits.getLength());
	    
		}catch(Exception e){
			_log.error(e);
		}
		
		jsonObject.put("studentList", studentList);
		
		return jsonObject;
	}
	
	public List<GrooupByEntityBean> groupByGender(long schoolId, long campusId){
		return studentFinder.groupByStudentGender(schoolId,campusId);
	}
	
	public List<GrooupByEntityBean> groupByProfession(long schoolId, long campusId){
		return studentFinder.groupByStudentProfession(schoolId,campusId);
	}
	
	public List<GrooupByEntityBean> groupByLanguages(String lanugage,String searchByColumnName, String searchByColumnValue,long schoolId, long campusId){
		return studentFinder.groupByStudentLanguages(lanugage, searchByColumnName, searchByColumnValue,schoolId,campusId);
	}
	
	public List<GrooupByEntityBean> searchByXAxis(String groupByColumnName, String searchColumnName, String searchColumnValue,long schoolId, long campusId){
		return studentFinder.searchByXAxis(groupByColumnName, searchColumnName, searchColumnValue,schoolId,campusId);
	}
	
}