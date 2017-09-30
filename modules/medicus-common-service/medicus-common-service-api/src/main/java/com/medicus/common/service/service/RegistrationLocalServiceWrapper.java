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
 * @author Brian Wing Shun Chan
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
	public com.liferay.portal.kernel.model.User registerEmployer(
		java.lang.String fName, java.lang.String lastName,
		java.lang.String emailAddress, java.lang.String password1,
		java.lang.String password2, java.lang.String address1,
		java.lang.String address2, java.lang.String city,
		java.lang.String zipcode, java.lang.String state,
		java.lang.String country, java.lang.String contactPersonName,
		java.lang.String contactPersonEmail,
		java.lang.String contactPersonPhoneNumber,
		java.lang.String websiteLink, long creatorUserId, long groupId) {
		return _registrationLocalService.registerEmployer(fName, lastName,
			emailAddress, password1, password2, address1, address2, city,
			zipcode, state, country, contactPersonName, contactPersonEmail,
			contactPersonPhoneNumber, websiteLink, creatorUserId, groupId);
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