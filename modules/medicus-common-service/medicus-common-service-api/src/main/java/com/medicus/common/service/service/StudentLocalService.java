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

package com.medicus.common.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.medicus.common.service.bean.GrooupByEntityBean;
import com.medicus.common.service.model.Student;

import java.io.File;
import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Provides the local service interface for Student. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author sandip.patel
 * @see StudentLocalServiceUtil
 * @see com.medicus.common.service.service.base.StudentLocalServiceBaseImpl
 * @see com.medicus.common.service.service.impl.StudentLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface StudentLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudentLocalServiceUtil} to access the student local service. Add custom service methods to {@link com.medicus.common.service.service.impl.StudentLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public boolean deleteStudentDetail(long studentId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject searchStudents(java.lang.String keyword,
		java.lang.String zipcode, java.lang.String gender,
		java.lang.String profession, List<java.lang.String> languages,
		long schoolId, long campusId, int start, int end,
		SearchContext searchContext);

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the student to the database. Also notifies the appropriate model listeners.
	*
	* @param student the student
	* @return the student that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Student addStudent(Student student);

	public Student addStudent(long schoolId, long campusId,
		java.lang.String studentCampusId, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String emailAddress, Date dob, java.lang.String gender,
		java.lang.String contactNumber, java.lang.String homePhoneNumber,
		java.lang.String primaryLang, java.lang.String secondaryLangs,
		java.lang.String address, java.lang.String city,
		java.lang.String zipcode, java.lang.String state,
		java.lang.String pace, float gpa, java.lang.String profession,
		java.lang.String practices, boolean hired, Date graduationDate,
		boolean activelySeekingEmployment, boolean haveExternship,
		long employerId, long partnerId, int externshipStatus,
		java.lang.String partnerZipCode, java.lang.String partnerWebSiteLink,
		Date externshipStartDate, Date externshipEndDate, int noOfHoursPerWeek,
		Date midPointReviewDate, java.lang.String midPointReviewComment,
		Date finalReviewDate, java.lang.String finalPointReviewComment,
		java.lang.String ethnicityDesc, java.lang.String shiftDesc,
		File profileImage, java.lang.String profileImageFileName, File resume,
		java.lang.String resumeFileName,
		Map<java.lang.String, File> agreementFileMap,
		Map<java.lang.String, File> othersFileMap,
		Map<java.lang.String, File> timeSheetsFileMap, long createdBy)
		throws SearchException;

	/**
	* Creates a new student with the primary key. Does not add the student to the database.
	*
	* @param studentId the primary key for the new student
	* @return the new student
	*/
	public Student createStudent(long studentId);

	/**
	* Deletes the student from the database. Also notifies the appropriate model listeners.
	*
	* @param student the student
	* @return the student that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Student deleteStudent(Student student);

	/**
	* Deletes the student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student
	* @return the student that was removed
	* @throws PortalException if a student with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Student deleteStudent(long studentId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Student fetchStudent(long studentId);

	/**
	* Returns the student with the matching UUID and company.
	*
	* @param uuid the student's UUID
	* @param companyId the primary key of the company
	* @return the matching student, or <code>null</code> if a matching student could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Student fetchStudentByUuidAndCompanyId(java.lang.String uuid,
		long companyId);

	/**
	* Returns the student with the primary key.
	*
	* @param studentId the primary key of the student
	* @return the student
	* @throws PortalException if a student with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Student getStudent(long studentId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Student getStudentByStudentCampusId(java.lang.String studentCampusId);

	/**
	* Returns the student with the matching UUID and company.
	*
	* @param uuid the student's UUID
	* @param companyId the primary key of the company
	* @return the matching student
	* @throws PortalException if a matching student could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Student getStudentByUuidAndCompanyId(java.lang.String uuid,
		long companyId) throws PortalException;

	public Student importStudent(java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String emailAddress, Date dob,
		java.lang.String studentCampusId, java.lang.String address,
		java.lang.String city, java.lang.String zipcode,
		java.lang.String state, java.lang.String mobilePhone,
		java.lang.String homePhone, java.lang.String gender,
		java.lang.String primaryLangs, java.lang.String secondaryLangs,
		float gpa, java.lang.String pace, java.lang.String ethnicityDesc,
		java.lang.String shiftDesc, Date externshipStartDate,
		Date graduationDate, long schoolId, long campusId,
		java.lang.String profession, long createdBy) throws PortalException;

	public Student updateImportStudent(Student student,
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String emailAddress, Date dob,
		java.lang.String gender, java.lang.String profession,
		java.lang.String address, java.lang.String city,
		java.lang.String zipcode, java.lang.String state,
		java.lang.String mobilePHone, java.lang.String homePhone,
		java.lang.String primaryLang, java.lang.String secodLang, float gpa,
		java.lang.String pace, java.lang.String shift,
		java.lang.String ethnicity, Date graduationDate,
		Date externshipStartDate) throws SearchException;

	/**
	* Updates the student in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param student the student
	* @return the student that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Student updateStudent(Student student);

	public Student updateStudent(long studentId, long schoolId, long campusId,
		java.lang.String studentCampusId, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String emailAddress, Date dob, java.lang.String gender,
		java.lang.String contactNumber, java.lang.String homePhoneNumber,
		java.lang.String primaryLang, java.lang.String secondaryLangs,
		java.lang.String address, java.lang.String city,
		java.lang.String zipcode, java.lang.String state,
		java.lang.String pace, float gpa, java.lang.String profession,
		java.lang.String practices, boolean hired, Date graduationDate,
		boolean activelySeekingEmployment, boolean haveExternship,
		long employerId, long partnerId, int externshipStatus,
		java.lang.String partnerZipCode, java.lang.String partnerWebSiteLink,
		Date externshipStartDate, Date externshipEndDate, int noOfHoursPerWeek,
		Date midPointReviewDate, java.lang.String midPointReviewComment,
		Date finalReviewDate, java.lang.String finalPointReviewComment,
		java.lang.String ethnicityDesc, java.lang.String shiftDesc,
		File profileImage, java.lang.String profileImageFileName, File resume,
		java.lang.String resumeFileName,
		Map<java.lang.String, File> agreementFileMap,
		Map<java.lang.String, File> othersFileMap,
		Map<java.lang.String, File> timeSheetsFileMap,
		boolean isApprovedInterviewRequest, long modifiedBy)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getActiveStudentCount();

	/**
	* Returns the number of students.
	*
	* @return the number of students
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStudentsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns a range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of students
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Student> getStudents(int start, int end);

	public List<GrooupByEntityBean> groupByGender(long schoolId, long campusId);

	public List<GrooupByEntityBean> groupByLanguages(
		java.lang.String lanugage, java.lang.String searchByColumnName,
		java.lang.String searchByColumnValue, long schoolId, long campusId);

	public List<GrooupByEntityBean> groupByProfession(long schoolId,
		long campusId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<GrooupByEntityBean> searchByXAxis(
		java.lang.String groupByColumnName, java.lang.String searchColumnName,
		java.lang.String searchColumnValue, long schoolId, long campusId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Student> searchStudents(java.lang.String keyword,
		java.lang.String zipcode, java.lang.String gender,
		java.lang.String profession, List<java.lang.String> languages,
		long schoolId, long campusId, int start, int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}