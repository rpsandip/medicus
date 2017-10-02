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
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.base.CampusLocalServiceBaseImpl;

/**
 * The implementation of the campus local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.medicus.common.service.service.CampusLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CampusLocalServiceBaseImpl
 * @see com.medicus.common.service.service.CampusLocalServiceUtil
 */
@ProviderType
public class CampusLocalServiceImpl extends CampusLocalServiceBaseImpl {
	
	/*
	 * Method for add Campus detail
	 */
	public Campus addCampus(long schoolId,String name, String address1, String address2, String city, String state,
			String country, String campusContactNumber, String websiteLink,String contactPersonName, 
			String contactPersonEmail, String contactPersonPhoneNumber, long createdBy) throws PortalException{
		
		Campus campus = CampusLocalServiceUtil.createCampus(CounterLocalServiceUtil.increment());
		campus.setSchoolId(schoolId);
		campus.setName(name);
		campus.setAddress1(address1);
		campus.setAddress2(address2);
		campus.setCity(city);
		campus.setState(state);
		campus.setCountry(country);
		campus.setContactNumber(campusContactNumber);
		campus.setWebsiteLink(websiteLink);
		campus.setContactPersonName(contactPersonName);
		campus.setContactPersonEmail(contactPersonEmail);
		campus.setContactPersonPhoneNumber(contactPersonPhoneNumber);
		campus.setStatus(0);
		campus.setCreatedBy(createdBy);
		campus.setModifiedBy(createdBy);
		campus.setCreateDate(new Date());
		campus.setModifiedDate(new Date());
		
		campus = CampusLocalServiceUtil.addCampus(campus);
		
		// Create organization for Campus
		if(Validator.isNotNull(campus)){
			Organization campusOrg = OrganizationLocalServiceUtil.addOrganization(createdBy, 0l, String.valueOf(campus.getCampusId()), true);
		}
		
		return campus;
		
	}
	/*
	 * Method for update Campus detail
	 */
	public Campus upateCampus(long campusId, long schoolId,String name, String address1, String address2, String city, String state,
			String country, String campusContactNumber, String websiteLink,String contactPersonName, 
			String contactPersonEmail, String contactPersonPhoneNumber, long modifiedBy) throws PortalException{
		
		Campus campus = CampusLocalServiceUtil.getCampus(campusId);
		campus.setSchoolId(schoolId);
		campus.setName(name);
		campus.setAddress1(address1);
		campus.setAddress2(address2);
		campus.setCity(city);
		campus.setState(state);
		campus.setCountry(country);
		campus.setContactNumber(campusContactNumber);
		campus.setWebsiteLink(websiteLink);
		campus.setContactPersonName(contactPersonName);
		campus.setContactPersonEmail(contactPersonEmail);
		campus.setContactPersonPhoneNumber(contactPersonPhoneNumber);
		campus.setStatus(0);
		campus.setModifiedBy(modifiedBy);
		campus.setModifiedDate(new Date());
		
		campus = CampusLocalServiceUtil.updateCampus(campus);
		
		return campus;
		
	}
	
	/*
	 * Method for get all Campus from schoolId
	 */
	public List<Campus> getCampusListBySchooId(long schoolId){
		return campusPersistence.findByschoolId(schoolId);
	}
	
}