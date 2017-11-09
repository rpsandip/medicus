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
import com.medicus.common.service.model.Employer;
import com.medicus.common.service.service.EmployerLocalServiceUtil;
import com.medicus.common.service.service.base.EmployerLocalServiceBaseImpl;

/**
 * The implementation of the employer local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.medicus.common.service.service.EmployerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployerLocalServiceBaseImpl
 * @see com.medicus.common.service.service.EmployerLocalServiceUtil
 */
@ProviderType
public class EmployerLocalServiceImpl extends EmployerLocalServiceBaseImpl {
	/*
	 * Add Employer Detail
	 */
	public Employer addEmployer(String firstName, String lastName, String emailAddress,String address1, String address2, 
			String city, String zipcode, String state, String country, String contactPersonName,
			String contactPersonEmail, String contactPersonPhoneNumber, String websiteLink,long creatorUserId){
		
		Employer employer = EmployerLocalServiceUtil.createEmployer(CounterLocalServiceUtil.increment());
		employer.setFirstName(firstName);
		employer.setLastName(lastName);
		employer.setEmailAddress(emailAddress);
		employer.setAddress1(address1);
		employer.setAddress2(address2);
		employer.setCity(city);
		employer.setZipcode(zipcode);
		employer.setState(state);
		employer.setCountry(country);
		employer.setContactPersonEmail(contactPersonEmail);
		employer.setContactPersonName(contactPersonName);
		employer.setContactPersonPhoneNumber(contactPersonPhoneNumber);
		employer.setWebsiteLink(websiteLink);
		
		employer.setCreatedBy(creatorUserId);
		employer.setCreateDate(new Date());
		employer.setModifiedBy(creatorUserId);
		employer.setModifiedDate(new Date());
		
		employer = EmployerLocalServiceUtil.addEmployer(employer);
		
		return employer;
	}
	
	/*
	 * Update Employer Detail
	 */
	public Employer editEmployer(long employerId, String firstName, String lastName, String emailAddress,String address1, String address2, 
			String city, String zipcode, String state, String country, String contactPersonName,
			String contactPersonEmail, String contactPersonPhoneNumber, String websiteLink,long modifiedBy) throws PortalException{
		
		Employer employer = EmployerLocalServiceUtil.getEmployer(employerId);
		
		employer.setFirstName(firstName);
		employer.setLastName(lastName);
		employer.setEmailAddress(emailAddress);
		employer.setAddress1(address1);
		employer.setAddress2(address2);
		employer.setCity(city);
		employer.setZipcode(zipcode);
		employer.setState(state);
		employer.setCountry(country);
		employer.setContactPersonEmail(contactPersonEmail);
		employer.setContactPersonName(contactPersonName);
		employer.setContactPersonPhoneNumber(contactPersonPhoneNumber);
		employer.setWebsiteLink(websiteLink);
		
		employer.setModifiedBy(modifiedBy);
		employer.setModifiedDate(new Date());
	
		employer = EmployerLocalServiceUtil.updateEmployer(employer);
		
		return employer;
	}
	
}