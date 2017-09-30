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

import java.util.Date;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.medicus.common.service.model.School;
import com.medicus.common.service.service.SchoolLocalServiceUtil;
import com.medicus.common.service.service.base.SchoolLocalServiceBaseImpl;

/**
 * The implementation of the school local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.medicus.common.service.service.SchoolLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SchoolLocalServiceBaseImpl
 * @see com.medicus.common.service.service.SchoolLocalServiceUtil
 */
@ProviderType
public class SchoolLocalServiceImpl extends SchoolLocalServiceBaseImpl {
		
	/*
	 * Method for add school detail
	 * @see com.medicus.common.service.service.SchoolLocalService#addSchool(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long)
	 */
	public School addSchool(String name, String address1, String address2, String city, String state,
			String country, String schoolContactNumber, String websiteLink,String contactPersonName, 
			String contactPersonEmail, String contactPersonPhoneNumber, long createdBy){
		
		School school = SchoolLocalServiceUtil.createSchool(CounterLocalServiceUtil.increment());
		school.setName(name);
		school.setAddress1(address1);
		school.setAddress2(address2);
		school.setCity(city);
		school.setState(state);
		school.setCountry(country);
		school.setContactNumber(schoolContactNumber);
		school.setWebsiteLink(websiteLink);
		school.setContactPersonName(contactPersonName);
		school.setContactPersonEmail(contactPersonEmail);
		school.setContactPersonPhoneNumber(contactPersonPhoneNumber);
		school.setStatus(0);
		
		school.setCreateDate(new Date());
		school.setModifiedDate(new Date());
		school.setCreatedBy(createdBy);
		school.setModifiedBy(createdBy);
		
		school = SchoolLocalServiceUtil.addSchool(school);
		
		return school;
		
	}
	
	/*
	 * Method for edit school Detail
	 * @see com.medicus.common.service.service.SchoolLocalService#updateSchool(long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, long)
	 */
	public School updateSchool(long schoolId, String name, String address1, String address2, String city, String state,
			String country, String schoolContactNumber, String websiteLink,String contactPersonName, 
			String contactPersonEmail, String contactPersonPhoneNumber, long modifiedBy) throws PortalException{
		
		School school = SchoolLocalServiceUtil.getSchool(schoolId);
		school.setName(name);
		school.setAddress1(address1);
		school.setAddress2(address2);
		school.setCity(city);
		school.setState(state);
		school.setCountry(country);
		school.setContactNumber(schoolContactNumber);
		school.setWebsiteLink(websiteLink);
		school.setContactPersonName(contactPersonName);
		school.setContactPersonEmail(contactPersonEmail);
		school.setContactPersonPhoneNumber(contactPersonPhoneNumber);
		school.setStatus(0);
		school.setModifiedDate(new Date());
		school.setModifiedBy(modifiedBy);
		
		school = SchoolLocalServiceUtil.updateSchool(school);
		
		return school;
		
	}
	
}