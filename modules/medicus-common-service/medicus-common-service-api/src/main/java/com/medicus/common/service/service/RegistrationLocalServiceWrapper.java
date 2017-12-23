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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegistrationLocalService}.
 *
 * @author sandip.patel
 * @see RegistrationLocalService
 * @generated
 */
@ProviderType
public class RegistrationLocalServiceWrapper implements RegistrationLocalService,
	ServiceWrapper<RegistrationLocalService> {
	public RegistrationLocalServiceWrapper(
		RegistrationLocalService registrationLocalService) {
		_registrationLocalService = registrationLocalService;
	}

	@Override
	public com.liferay.portal.kernel.model.User createSchoolUser(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAddress, java.lang.String contactNumber,
		long schoolId, long campusId, long roleId, long creatorUserId,
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationLocalService.createSchoolUser(firstName, lastName,
			emailAddress, contactNumber, schoolId, campusId, roleId,
			creatorUserId, groupId);
	}

	@Override
	public com.liferay.portal.kernel.model.User registerPartner(
		java.lang.String fName, java.lang.String lastName,
		java.lang.String emailAddress, java.lang.String password1,
		java.lang.String password2, java.lang.String address1,
		java.lang.String city, java.lang.String zipcode,
		java.lang.String state, java.lang.String country,
		java.lang.String contactPersonName,
		java.lang.String contactPersonEmail,
		java.lang.String contactPersonPhoneNumber,
		java.lang.String websiteLink, long creatorUserId, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationLocalService.registerPartner(fName, lastName,
			emailAddress, password1, password2, address1, city, zipcode, state,
			country, contactPersonName, contactPersonEmail,
			contactPersonPhoneNumber, websiteLink, creatorUserId, groupId);
	}

	@Override
	public com.liferay.portal.kernel.model.User updateSchoolUser(long userId,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAddress, java.lang.String contactNumber,
		long schoolId, long campusId, long roleId, long creatorUserId,
		long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _registrationLocalService.updateSchoolUser(userId, firstName,
			lastName, emailAddress, contactNumber, schoolId, campusId, roleId,
			creatorUserId, groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _registrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void updateSchoolUserProfile(long userId,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String contactNumber, java.lang.String password,
		java.lang.String password1, java.lang.String profilePicName,
		java.io.File profilePic)
		throws com.liferay.portal.kernel.exception.PortalException,
			java.io.IOException {
		_registrationLocalService.updateSchoolUserProfile(userId, firstName,
			lastName, contactNumber, password, password1, profilePicName,
			profilePic);
	}

	@Override
	public RegistrationLocalService getWrappedService() {
		return _registrationLocalService;
	}

	@Override
	public void setWrappedService(
		RegistrationLocalService registrationLocalService) {
		_registrationLocalService = registrationLocalService;
	}

	private RegistrationLocalService _registrationLocalService;
}