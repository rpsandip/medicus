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
 * Provides the local service utility for MedicusCommon. This utility wraps
 * {@link com.medicus.common.service.service.impl.MedicusCommonLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author sandip.patel
 * @see MedicusCommonLocalService
 * @see com.medicus.common.service.service.base.MedicusCommonLocalServiceBaseImpl
 * @see com.medicus.common.service.service.impl.MedicusCommonLocalServiceImpl
 * @generated
 */
@ProviderType
public class MedicusCommonLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.medicus.common.service.service.impl.MedicusCommonLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean isFolderExist(long groupId, long parentFolderId,
		java.lang.String folderName) {
		return getService().isFolderExist(groupId, parentFolderId, folderName);
	}

	public static boolean isPartner(long userId) {
		return getService().isPartner(userId);
	}

	public static com.liferay.portal.kernel.model.User getCampusAdminName(
		long campusId) {
		return getService().getCampusAdminName(campusId);
	}

	public static com.liferay.portal.kernel.model.User isUserExist(
		java.lang.String emailAddress) {
		return getService().isUserExist(emailAddress);
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry addFileEntry(
		long groupId, long folderId, java.io.File file,
		java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().addFileEntry(groupId, folderId, file, fileName);
	}

	public static com.liferay.portal.kernel.repository.model.FileEntry updateFileEntry(
		long fileEntryId, long groupId, long folderId, java.io.File file,
		java.lang.String fileName)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateFileEntry(fileEntryId, groupId, folderId, file,
			fileName);
	}

	public static com.liferay.portal.kernel.repository.model.Folder getFolder(
		long groupId, long parentFolderId, java.lang.String folderName) {
		return getService().getFolder(groupId, parentFolderId, folderName);
	}

	public static java.io.File getStudentResumeContent(
		com.medicus.common.service.model.Student student) {
		return getService().getStudentResumeContent(student);
	}

	public static java.lang.String getDLFileURL(
		com.liferay.document.library.kernel.model.DLFileEntry file) {
		return getService().getDLFileURL(file);
	}

	public static java.lang.String getDLFileURL(
		com.liferay.portal.kernel.repository.model.FileEntry file) {
		return getService().getDLFileURL(file);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.lang.String getPartnerImportFileURL() {
		return getService().getPartnerImportFileURL();
	}

	public static java.lang.String getStudentImportFileURL() {
		return getService().getStudentImportFileURL();
	}

	public static java.util.List<com.medicus.common.service.model.Partner> getPartnerList() {
		return getService().getPartnerList();
	}

	public static java.util.List<java.lang.String> getUSStateList() {
		return getService().getUSStateList();
	}

	public static long getCampusOrgIdFromRoleIdAndUserId(long userId,
		long roleId) {
		return getService().getCampusOrgIdFromRoleIdAndUserId(userId, roleId);
	}

	public static long getGlobalGroupId() {
		return getService().getGlobalGroupId();
	}

	public static long getMedicusGroupId() {
		return getService().getMedicusGroupId();
	}

	public static long getMedicusOrganizationId() {
		return getService().getMedicusOrganizationId();
	}

	public static long getOrganizationGroupIdFromOrgId(long orgId) {
		return getService().getOrganizationGroupIdFromOrgId(orgId);
	}

	public static long getPartnerOrgRoleId() {
		return getService().getPartnerOrgRoleId();
	}

	public static long getRoleIdFromName(java.lang.String roleName) {
		return getService().getRoleIdFromName(roleName);
	}

	public static long getUserPhoneTypeId()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserPhoneTypeId();
	}

	public static void sendApproveInterviewRequestMail(
		com.medicus.common.service.model.Interview_Request interviewRequest) {
		getService().sendApproveInterviewRequestMail(interviewRequest);
	}

	public static void setUserSchoolIdCampusIdInRequest(
		javax.portlet.PortletRequest request,
		java.util.List<com.medicus.common.service.model.School> schoolListForSchoolAdmin) {
		getService()
			.setUserSchoolIdCampusIdInRequest(request, schoolListForSchoolAdmin);
	}

	public static MedicusCommonLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MedicusCommonLocalService, MedicusCommonLocalService> _serviceTracker =
		ServiceTrackerFactory.open(MedicusCommonLocalService.class);
}