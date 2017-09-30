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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.medicus.common.service.service.RegistrationLocalService;
import com.medicus.common.service.service.persistence.CampusPersistence;
import com.medicus.common.service.service.persistence.EmployerPersistence;
import com.medicus.common.service.service.persistence.SchoolPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the registration local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.medicus.common.service.service.impl.RegistrationLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.medicus.common.service.service.impl.RegistrationLocalServiceImpl
 * @see com.medicus.common.service.service.RegistrationLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class RegistrationLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements RegistrationLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.medicus.common.service.service.RegistrationLocalServiceUtil} to access the registration local service.
	 */

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
	public RegistrationLocalService getRegistrationLocalService() {
		return registrationLocalService;
	}

	/**
	 * Sets the registration local service.
	 *
	 * @param registrationLocalService the registration local service
	 */
	public void setRegistrationLocalService(
		RegistrationLocalService registrationLocalService) {
		this.registrationLocalService = registrationLocalService;
	}

	/**
	 * Returns the school local service.
	 *
	 * @return the school local service
	 */
	public com.medicus.common.service.service.SchoolLocalService getSchoolLocalService() {
		return schoolLocalService;
	}

	/**
	 * Sets the school local service.
	 *
	 * @param schoolLocalService the school local service
	 */
	public void setSchoolLocalService(
		com.medicus.common.service.service.SchoolLocalService schoolLocalService) {
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
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return RegistrationLocalService.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = InfrastructureUtil.getDataSource();

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
	@BeanReference(type = RegistrationLocalService.class)
	protected RegistrationLocalService registrationLocalService;
	@BeanReference(type = com.medicus.common.service.service.SchoolLocalService.class)
	protected com.medicus.common.service.service.SchoolLocalService schoolLocalService;
	@BeanReference(type = SchoolPersistence.class)
	protected SchoolPersistence schoolPersistence;
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
}