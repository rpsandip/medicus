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
 * @author sandip.patel
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
	public boolean isFolderExist(long groupId, long parentFolderId,
		java.lang.String folderName) {
		return _medicusCommonLocalService.isFolderExist(groupId,
			parentFolderId, folderName);
	}

	@Override
	public com.liferay.portal.kernel.model.User getCampusAdminName(
		long campusId) {
		return _medicusCommonLocalService.getCampusAdminName(campusId);
	}

	@Override
	public com.liferay.portal.kernel.model.User isUserExist(
		java.lang.String emailAddress) {
		return _medicusCommonLocalService.isUserExist(emailAddress);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry addFileEntry(
		long groupId, long folderId, java.io.File file,
		java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _medicusCommonLocalService.addFileEntry(groupId, folderId, file,
			fileName);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry updateFileEntry(
		long fileEntryId, long groupId, long folderId, java.io.File file,
		java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _medicusCommonLocalService.updateFileEntry(fileEntryId, groupId,
			folderId, file, fileName);
	}

	@Override
	public com.liferay.portal.kernel.repository.model.Folder getFolder(
		long groupId, long parentFolderId, java.lang.String folderName) {
		return _medicusCommonLocalService.getFolder(groupId, parentFolderId,
			folderName);
	}

	@Override
	public java.io.File getStudentResumeContent(
		com.medicus.common.service.model.Student student) {
		return _medicusCommonLocalService.getStudentResumeContent(student);
	}

	@Override
	public java.lang.String getDLFileURL(
		com.liferay.document.library.kernel.model.DLFileEntry file) {
		return _medicusCommonLocalService.getDLFileURL(file);
	}

	@Override
	public java.lang.String getDLFileURL(
		com.liferay.portal.kernel.repository.model.FileEntry file) {
		return _medicusCommonLocalService.getDLFileURL(file);
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
	public java.util.List<com.medicus.common.service.model.Partner> getPartnerList() {
		return _medicusCommonLocalService.getPartnerList();
	}

	@Override
	public java.util.List<java.lang.String> getUSStateList() {
		return _medicusCommonLocalService.getUSStateList();
	}

	@Override
	public long getCampusOrgIdFromRoleIdAndUserId(long userId, long roleId) {
		return _medicusCommonLocalService.getCampusOrgIdFromRoleIdAndUserId(userId,
			roleId);
	}

	@Override
	public long getGlobalGroupId() {
		return _medicusCommonLocalService.getGlobalGroupId();
	}

	@Override
	public long getMedicusGroupId() {
		return _medicusCommonLocalService.getMedicusGroupId();
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
	public long getPartnerOrgRoleId() {
		return _medicusCommonLocalService.getPartnerOrgRoleId();
	}

	@Override
	public long getRoleIdFromName(java.lang.String roleName) {
		return _medicusCommonLocalService.getRoleIdFromName(roleName);
	}

	@Override
	public long getUserPhoneTypeId()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _medicusCommonLocalService.getUserPhoneTypeId();
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