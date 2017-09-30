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
 * Provides a wrapper for {@link MedicusCommonLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MedicusCommonLocalService
 * @generated
 */
@ProviderType
public class MedicusCommonLocalServiceWrapper
	implements MedicusCommonLocalService,
		ServiceWrapper<MedicusCommonLocalService> {
	public MedicusCommonLocalServiceWrapper(
		MedicusCommonLocalService medicusCommonLocalService) {
		_medicusCommonLocalService = medicusCommonLocalService;
	}

	@Override
	public com.liferay.portal.kernel.model.User isUserExist(
		java.lang.String emailAddress) {
		return _medicusCommonLocalService.isUserExist(emailAddress);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _medicusCommonLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public long getEmployerOrgRoleId() {
		return _medicusCommonLocalService.getEmployerOrgRoleId();
	}

	@Override
	public long getMedicusOrganizationId() {
		return _medicusCommonLocalService.getMedicusOrganizationId();
	}

	@Override
	public long getOrganizationGroupIdFromOrgId(long orgId) {
		return _medicusCommonLocalService.getOrganizationGroupIdFromOrgId(orgId);
	}

	@Override
	public MedicusCommonLocalService getWrappedService() {
		return _medicusCommonLocalService;
	}

	@Override
	public void setWrappedService(
		MedicusCommonLocalService medicusCommonLocalService) {
		_medicusCommonLocalService = medicusCommonLocalService;
	}

	private MedicusCommonLocalService _medicusCommonLocalService;
}