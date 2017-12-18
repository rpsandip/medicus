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

import com.liferay.document.library.kernel.model.DLFileEntry;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import com.medicus.common.service.model.Interview_Request;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.model.School;
import com.medicus.common.service.model.Student;

import java.io.File;

import java.util.List;

import javax.portlet.PortletRequest;

/**
 * Provides the local service interface for MedicusCommon. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author sandip.patel
 * @see MedicusCommonLocalServiceUtil
 * @see com.medicus.common.service.service.base.MedicusCommonLocalServiceBaseImpl
 * @see com.medicus.common.service.service.impl.MedicusCommonLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface MedicusCommonLocalService extends BaseLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MedicusCommonLocalServiceUtil} to access the medicus common local service. Add custom service methods to {@link com.medicus.common.service.service.impl.MedicusCommonLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isFolderExist(long groupId, long parentFolderId,
		java.lang.String folderName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public User getCampusAdminName(long campusId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public User isUserExist(java.lang.String emailAddress);

	public FileEntry addFileEntry(long groupId, long folderId, File file,
		java.lang.String fileName) throws PortalException;

	public FileEntry updateFileEntry(long fileEntryId, long groupId,
		long folderId, File file, java.lang.String fileName)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Folder getFolder(long groupId, long parentFolderId,
		java.lang.String folderName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public File getStudentResumeContent(Student student);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getDLFileURL(DLFileEntry file);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getDLFileURL(FileEntry file);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getPartnerImportFileURL();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getStudentImportFileURL();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Partner> getPartnerList();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<java.lang.String> getUSStateList();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getCampusOrgIdFromRoleIdAndUserId(long userId, long roleId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getGlobalGroupId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getMedicusGroupId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getMedicusOrganizationId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getOrganizationGroupIdFromOrgId(long orgId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getPartnerOrgRoleId();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getRoleIdFromName(java.lang.String roleName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getUserPhoneTypeId() throws SystemException;

	public void sendApproveInterviewRequestMail(
		Interview_Request interviewRequest);

	public void setUserSchoolIdCampusIdInRequest(PortletRequest request,
		List<School> schoolListForSchoolAdmin);
}