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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Registration. This utility wraps
 * {@link com.medicus.common.service.service.impl.RegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RegistrationLocalService
 * @see com.medicus.common.service.service.base.RegistrationLocalServiceBaseImpl
 * @see com.medicus.common.service.service.impl.RegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class RegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.medicus.common.service.service.impl.RegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.User registerEmployer(
		java.lang.String fName, java.lang.String lastName,
		java.lang.String emailAddress, java.lang.String password1,
		java.lang.String password2, java.lang.String address1,
		java.lang.String address2, java.lang.String city,
		java.lang.String zipcode, java.lang.String state,
		java.lang.String country, java.lang.String contactPersonName,
		java.lang.String contactPersonEmail,
		java.lang.String contactPersonPhoneNumber,
		java.lang.String websiteLink, long creatorUserId, long groupId) {
		return getService()
				   .registerEmployer(fName, lastName, emailAddress, password1,
			password2, address1, address2, city, zipcode, state, country,
			contactPersonName, contactPersonEmail, contactPersonPhoneNumber,
			websiteLink, creatorUserId, groupId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static RegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RegistrationLocalService, RegistrationLocalService> _serviceTracker =
		ServiceTrackerFactory.open(RegistrationLocalService.class);
}