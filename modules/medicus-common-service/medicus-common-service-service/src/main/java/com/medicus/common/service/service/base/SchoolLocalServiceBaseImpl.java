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

package com.medicus.common.service.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.medicus.common.service.model.School;
import com.medicus.common.service.service.SchoolLocalService;
import com.medicus.common.service.service.persistence.CampusPersistence;
import com.medicus.common.service.service.persistence.EmployerPersistence;
import com.medicus.common.service.service.persistence.SchoolPersistence;
import com.medicus.common.service.service.persistence.StudentPersistence;
import com.medicus.common.service.service.persistence.Student_ExternshipPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the school local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.medicus.common.service.service.impl.SchoolLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.medicus.common.service.service.impl.SchoolLocalServiceImpl
 * @see com.medicus.common.service.service.SchoolLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class SchoolLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements SchoolLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.medicus.common.service.service.SchoolLocalServiceUtil} to access the school local service.
	 */

	/**
	 * Adds the school to the database. Also notifies the appropriate model listeners.
	 *
	 * @param school the school
	 * @return the school that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public School addSchool(School school) {
		school.setNew(true);

		return schoolPersistence.update(school);
	}

	/**
	 * Creates a new school with the primary key. Does not add the school to the database.
	 *
	 * @param schoolId the primary key for the new school
	 * @return the new school
	 */
	@Override
	public School createSchool(long schoolId) {
		return schoolPersistence.create(schoolId);
	}

	/**
	 * Deletes the school with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param schoolId the primary key of the school
	 * @return the school that was removed
	 * @throws PortalException if a school with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public School deleteSchool(long schoolId) throws PortalException {
		return schoolPersistence.remove(schoolId);
	}

	/**
	 * Deletes the school from the database. Also notifies the appropriate model listeners.
	 *
	 * @param school the school
	 * @return the school that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public School deleteSchool(School school) {
		return schoolPersistence.remove(school);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(School.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return schoolPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return schoolPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return schoolPersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return schoolPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return schoolPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public School fetchSchool(long schoolId) {
		return schoolPersistence.fetchByPrimaryKey(schoolId);
	}

	/**
	 * Returns the school with the primary key.
	 *
	 * @param schoolId the primary key of the school
	 * @return the school
	 * @throws PortalException if a school with the primary key could not be found
	 */
	@Override
	public School getSchool(long schoolId) throws PortalException {
		return schoolPersistence.findByPrimaryKey(schoolId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(schoolLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(School.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("schoolId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(schoolLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(School.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("schoolId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(schoolLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(School.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("schoolId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return schoolLocalService.deleteSchool((School)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return schoolPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the schools.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of schools
	 * @param end the upper bound of the range of schools (not inclusive)
	 * @return the range of schools
	 */
	@Override
	public List<School> getSchools(int start, int end) {
		return schoolPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of schools.
	 *
	 * @return the number of schools
	 */
	@Override
	public int getSchoolsCount() {
		return schoolPersistence.countAll();
	}

	/**
	 * Updates the school in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param school the school
	 * @return the school that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public School updateSchool(School school) {
		return schoolPersistence.update(school);
	}

	/**
	 * Returns the campus local service.
	 *
	 * @return the campus local service
	 */
	public com.medicus.common.service.service.CampusLocalService getCampusLocalService() {
		return campusLocalService;
	}

	/**
	 * Sets the campus local service.
	 *
	 * @param campusLocalService the campus local service
	 */
	public void setCampusLocalService(
		com.medicus.common.service.service.CampusLocalService campusLocalService) {
		this.campusLocalService = campusLocalService;
	}

	/**
	 * Returns the campus persistence.
	 *
	 * @return the campus persistence
	 */
	public CampusPersistence getCampusPersistence() {
		return campusPersistence;
	}

	/**
	 * Sets the campus persistence.
	 *
	 * @param campusPersistence the campus persistence
	 */
	public void setCampusPersistence(CampusPersistence campusPersistence) {
		this.campusPersistence = campusPersistence;
	}

	/**
	 * Returns the employer local service.
	 *
	 * @return the employer local service
	 */
	public com.medicus.common.service.service.EmployerLocalService getEmployerLocalService() {
		return employerLocalService;
	}

	/**
	 * Sets the employer local service.
	 *
	 * @param employerLocalService the employer local service
	 */
	public void setEmployerLocalService(
		com.medicus.common.service.service.EmployerLocalService employerLocalService) {
		this.employerLocalService = employerLocalService;
	}

	/**
	 * Returns the employer persistence.
	 *
	 * @return the employer persistence
	 */
	public EmployerPersistence getEmployerPersistence() {
		return employerPersistence;
	}

	/**
	 * Sets the employer persistence.
	 *
	 * @param employerPersistence the employer persistence
	 */
	public void setEmployerPersistence(EmployerPersistence employerPersistence) {
		this.employerPersistence = employerPersistence;
	}

	/**
	 * Returns the medicus common local service.
	 *
	 * @return the medicus common local service
	 */
	public com.medicus.common.service.service.MedicusCommonLocalService getMedicusCommonLocalService() {
		return medicusCommonLocalService;
	}

	/**
	 * Sets the medicus common local service.
	 *
	 * @param medicusCommonLocalService the medicus common local service
	 */
	public void setMedicusCommonLocalService(
		com.medicus.common.service.service.MedicusCommonLocalService medicusCommonLocalService) {
		this.medicusCommonLocalService = medicusCommonLocalService;
	}

	/**
	 * Returns the registration local service.
	 *
	 * @return the registration local service
	 */
	public com.medicus.common.service.service.RegistrationLocalService getRegistrationLocalService() {
		return registrationLocalService;
	}

	/**
	 * Sets the registration local service.
	 *
	 * @param registrationLocalService the registration local service
	 */
	public void setRegistrationLocalService(
		com.medicus.common.service.service.RegistrationLocalService registrationLocalService) {
		this.registrationLocalService = registrationLocalService;
	}

	/**
	 * Returns the school local service.
	 *
	 * @return the school local service
	 */
	public SchoolLocalService getSchoolLocalService() {
		return schoolLocalService;
	}

	/**
	 * Sets the school local service.
	 *
	 * @param schoolLocalService the school local service
	 */
	public void setSchoolLocalService(SchoolLocalService schoolLocalService) {
		this.schoolLocalService = schoolLocalService;
	}

	/**
	 * Returns the school persistence.
	 *
	 * @return the school persistence
	 */
	public SchoolPersistence getSchoolPersistence() {
		return schoolPersistence;
	}

	/**
	 * Sets the school persistence.
	 *
	 * @param schoolPersistence the school persistence
	 */
	public void setSchoolPersistence(SchoolPersistence schoolPersistence) {
		this.schoolPersistence = schoolPersistence;
	}

	/**
	 * Returns the student local service.
	 *
	 * @return the student local service
	 */
	public com.medicus.common.service.service.StudentLocalService getStudentLocalService() {
		return studentLocalService;
	}

	/**
	 * Sets the student local service.
	 *
	 * @param studentLocalService the student local service
	 */
	public void setStudentLocalService(
		com.medicus.common.service.service.StudentLocalService studentLocalService) {
		this.studentLocalService = studentLocalService;
	}

	/**
	 * Returns the student persistence.
	 *
	 * @return the student persistence
	 */
	public StudentPersistence getStudentPersistence() {
		return studentPersistence;
	}

	/**
	 * Sets the student persistence.
	 *
	 * @param studentPersistence the student persistence
	 */
	public void setStudentPersistence(StudentPersistence studentPersistence) {
		this.studentPersistence = studentPersistence;
	}

	/**
	 * Returns the student_ externship local service.
	 *
	 * @return the student_ externship local service
	 */
	public com.medicus.common.service.service.Student_ExternshipLocalService getStudent_ExternshipLocalService() {
		return student_ExternshipLocalService;
	}

	/**
	 * Sets the student_ externship local service.
	 *
	 * @param student_ExternshipLocalService the student_ externship local service
	 */
	public void setStudent_ExternshipLocalService(
		com.medicus.common.service.service.Student_ExternshipLocalService student_ExternshipLocalService) {
		this.student_ExternshipLocalService = student_ExternshipLocalService;
	}

	/**
	 * Returns the student_ externship persistence.
	 *
	 * @return the student_ externship persistence
	 */
	public Student_ExternshipPersistence getStudent_ExternshipPersistence() {
		return student_ExternshipPersistence;
	}

	/**
	 * Sets the student_ externship persistence.
	 *
	 * @param student_ExternshipPersistence the student_ externship persistence
	 */
	public void setStudent_ExternshipPersistence(
		Student_ExternshipPersistence student_ExternshipPersistence) {
		this.student_ExternshipPersistence = student_ExternshipPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.medicus.common.service.model.School",
			schoolLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.medicus.common.service.model.School");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return SchoolLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return School.class;
	}

	protected String getModelClassName() {
		return School.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = schoolPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.medicus.common.service.service.CampusLocalService.class)
	protected com.medicus.common.service.service.CampusLocalService campusLocalService;
	@BeanReference(type = CampusPersistence.class)
	protected CampusPersistence campusPersistence;
	@BeanReference(type = com.medicus.common.service.service.EmployerLocalService.class)
	protected com.medicus.common.service.service.EmployerLocalService employerLocalService;
	@BeanReference(type = EmployerPersistence.class)
	protected EmployerPersistence employerPersistence;
	@BeanReference(type = com.medicus.common.service.service.MedicusCommonLocalService.class)
	protected com.medicus.common.service.service.MedicusCommonLocalService medicusCommonLocalService;
	@BeanReference(type = com.medicus.common.service.service.RegistrationLocalService.class)
	protected com.medicus.common.service.service.RegistrationLocalService registrationLocalService;
	@BeanReference(type = SchoolLocalService.class)
	protected SchoolLocalService schoolLocalService;
	@BeanReference(type = SchoolPersistence.class)
	protected SchoolPersistence schoolPersistence;
	@BeanReference(type = com.medicus.common.service.service.StudentLocalService.class)
	protected com.medicus.common.service.service.StudentLocalService studentLocalService;
	@BeanReference(type = StudentPersistence.class)
	protected StudentPersistence studentPersistence;
	@BeanReference(type = com.medicus.common.service.service.Student_ExternshipLocalService.class)
	protected com.medicus.common.service.service.Student_ExternshipLocalService student_ExternshipLocalService;
	@BeanReference(type = Student_ExternshipPersistence.class)
	protected Student_ExternshipPersistence student_ExternshipPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}