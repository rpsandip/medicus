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

import aQute.bnd.annotation.ProviderType;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.liferay.document.library.kernel.exception.DuplicateFileEntryException;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.upload.FileItem;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.common.service.service.Student_ExternshipLocalServiceUtil;
import com.medicus.common.service.service.base.StudentLocalServiceBaseImpl;

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
			long employerId, String employerZipCode, String employerWebSiteLink,Date externshipStartDate, Date externshipEndDate, int noOfHoursPerWeek,
			Date midPointReviewDate,String midPointReviewComment,Date finalReviewDate, String finalPointReviewComment,
			File profileImage, String profileImageFileName,File resume, String resumeFileName,File agreement, String agreementFileName, Map<String, File> othersFileMap,long createdBy ){
		
		// Add student record
		Student student = StudentLocalServiceUtil.createStudent(counterLocalService.increment());
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
		student.setProfession(profession);
		student.setPractices(practices);
		student.setHired(hired);
		student.setGraduationDate(graduationDate);
		student.setActivelySeekingEmployment(activelySeekingEmployment);
		student.setHaveExternship(haveExternship);
		
		student.setCreatedBy(createdBy);
		student.setModifiedBy(createdBy);
		student.setCreateDate(new Date());
		student.setModifiedDate(new Date());
		
		student = StudentLocalServiceUtil.addStudent(student);
		
		// Add Externship Detail
		Student_ExternshipLocalServiceUtil.addStudentExternship(student.getStudentId(), employerId, externshipStartDate, externshipEndDate,
				noOfHoursPerWeek, midPointReviewDate, midPointReviewComment, finalReviewDate, finalPointReviewComment, createdBy);
		
		// Get Global groupId and Student Id folder
		long globalGroupId = MedicusCommonLocalServiceUtil.getGlobalGroupId();
		Folder studentIdFolder = MedicusCommonLocalServiceUtil.getFolder(globalGroupId, 0l, String.valueOf(student.getStudentId()));
		
		
		if(Validator.isNotNull(studentIdFolder)){
			ServiceContext serviceContext = new ServiceContext(); 
			if(Validator.isNotNull(profileImage)){
				
				// Add Profile Images
				 try{
					FileEntry fileEntry = DLAppServiceUtil.addFileEntry(globalGroupId, studentIdFolder.getFolderId(),  profileImageFileName, MimeTypesUtil.getContentType(profileImage),  profileImage.getName(), StringPool.BLANK , StringPool.BLANK, profileImage, serviceContext);
					student.setProfileImageId(fileEntry.getFileEntryId());
				 }catch(PortalException e){
					 _log.error(e);
				 }
			}
			 
			if(Validator.isNotNull(resume)){
				
				// Add resume
				 try{
					FileEntry fileEntry = DLAppServiceUtil.addFileEntry(globalGroupId, studentIdFolder.getFolderId(),  resumeFileName, MimeTypesUtil.getContentType(resume),  resume.getName(), StringPool.BLANK , StringPool.BLANK, resume, serviceContext);
					student.setResumeFileEntryId(fileEntry.getFileEntryId());
				  }catch(PortalException e){
				 	 _log.error(e);
				  } 
			}
			
			if(Validator.isNotNull(agreement)){
				 
				// Add Agreeements
				 try{
					FileEntry fileEntry = DLAppServiceUtil.addFileEntry(globalGroupId, studentIdFolder.getFolderId(),  agreementFileName, MimeTypesUtil.getContentType(agreement),  agreement.getName(), StringPool.BLANK , StringPool.BLANK, agreement, serviceContext);
					student.setAgreementFileEntryId(fileEntry.getFileEntryId());
				  }catch(PortalException e){
				 	 _log.error(e);
				  }
				}
			 
			 // Add attachment
			Folder otherDocumentsFolder = MedicusCommonLocalServiceUtil.getFolder(globalGroupId, studentIdFolder.getFolderId(), "Other Documents");
			if(Validator.isNotNull(otherDocumentsFolder)){
				for (Entry<String, File> fileDetail : othersFileMap.entrySet()) {
					try{
						FileEntry fileEntry = DLAppServiceUtil.addFileEntry(globalGroupId, otherDocumentsFolder.getFolderId(),  fileDetail.getKey(), MimeTypesUtil.getContentType(fileDetail.getValue()),  fileDetail.getKey(), StringPool.BLANK , StringPool.BLANK, fileDetail.getValue(), serviceContext);
					  }catch(PortalException e){
					 	 _log.error(e);
					  }
				}
			}
			
			// Update student records
			
			student = StudentLocalServiceUtil.updateStudent(student);
		}
		
		return student;
		
	}
	
	/*
	 * Create student while import it. While import we have limited information compare to UI
	 */
	public Student importStudent(String firstName, String middleName, String lastName, String emailAddress, Date dob,
			String studentCampusId, String address, String city, String state, String zipcode, String mobilePhone,
			String homePhone, String gender, String primaryLangs, String secondaryLangs, float gpa, String pace, long schoolId, long campusId, String profession,long createdBy){
		
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
		student.setPace(pace);
		student.setSchoolId(schoolId);
		student.setCampusId(campusId);
		student.setProfession(profession);
		
		student.setCreatedBy(createdBy);
		student.setModifiedBy(createdBy);
		student.setCreateDate(new Date());
		student.setModifiedDate(new Date());
		
		student = StudentLocalServiceUtil.addStudent(student);
		
		return student;
	}
	
}