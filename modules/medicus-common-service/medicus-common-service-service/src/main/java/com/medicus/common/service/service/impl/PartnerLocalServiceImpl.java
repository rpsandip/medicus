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
import java.io.IOException;
import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.medicus.common.service.exception.NoSuchPartnerException;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.common.service.service.base.PartnerLocalServiceBaseImpl;

/**
 * The implementation of the partner local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.medicus.common.service.service.PartnerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sandip.patel
 * @see PartnerLocalServiceBaseImpl
 * @see com.medicus.common.service.service.PartnerLocalServiceUtil
 */
@ProviderType
public class PartnerLocalServiceImpl extends PartnerLocalServiceBaseImpl {
	
	Log _log = LogFactoryUtil.getLog(PartnerLocalServiceImpl.class.getName());
	
	public Partner getPartnerByUserId(long userId) throws NoSuchPartnerException{
		return partnerPersistence.findByuserId(userId);
	}	
	
	public Partner editPartner(long partnerId, String fName,
			String address1, String city, String zipcode, String state, String country, String contactPersonName,
			String contactPersonEmail, String contactPersonPhoneNumber, String websiteLink, String password, String password1,
			File profilePic, String profilePicName,
			long modifiedUserId) throws PortalException, IOException{
		
			Partner partner = PartnerLocalServiceUtil.getPartner(partnerId);
			User user = UserLocalServiceUtil.getUser(partner.getUserId());
			
			user.setFirstName(fName);
			
			 // Update passsword
			if(Validator.isNotNull(password1) && Validator.isNotNull(password) && Validator.equals(password1,password1)){
				UserLocalServiceUtil.updatePassword(user.getUserId(), password1, password1, false);
			}
			
			// Update user
			user = UserLocalServiceUtil.updateUser(user);
			
			// Update profilepic
			if(Validator.isNotNull(profilePic) && Validator.isNotNull(profilePicName)){
				UserLocalServiceUtil.updatePortrait(user.getUserId(), FileUtil.getBytes(profilePic));
			}
			
			// Update Partner Detail
			
			partner.setAddress1(address1);
			partner.setCountry(country);
			partner.setCity(city);
			partner.setState(state);
			partner.setZipcode(zipcode);
			partner.setContactPersonEmail(contactPersonName);
			partner.setContactPersonEmail(contactPersonEmail);
			partner.setContactPersonPhoneNumber(contactPersonPhoneNumber);
			partner.setWebsiteLink(websiteLink);
			
			partner.setModifiedBy(modifiedUserId);
			partner.setModifiedDate(new Date());
			
			partner = PartnerLocalServiceUtil.updatePartner(partner);
		
			return partner;
	}
}