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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.common.service.service.base.MedicusCommonLocalServiceBaseImpl;
import com.medicus.common.service.util.MedicusConstant;


/**
 * The implementation of the medicus common local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.medicus.common.service.service.MedicusCommonLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MedicusCommonLocalServiceBaseImpl
 * @see com.medicus.common.service.service.MedicusCommonLocalServiceUtil
 */
@ProviderType
public class MedicusCommonLocalServiceImpl
	extends MedicusCommonLocalServiceBaseImpl {
	
	Log _log = LogFactoryUtil.getLog(MedicusCommonLocalServiceImpl.class.getName());
	
	public long getOrganizationGroupIdFromOrgId(long orgId){
		long orgGroupId=-1;
		try {
			orgGroupId = OrganizationLocalServiceUtil.getOrganization(orgId).getGroupId();
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		return orgGroupId;
	} 
	
	public long getMedicusOrganizationId(){
		long medicusOrgId=0l;
		try {
			Organization org = OrganizationLocalServiceUtil.getOrganization(PortalUtil.getDefaultCompanyId(), MedicusConstant.MEDICUS_ORG);
			medicusOrgId  = org.getOrganizationId();
		} catch (PortalException e) {
			_log.error(e);
		}
		return medicusOrgId;
	}
	
	public long getPartnerOrgRoleId(){
		long partnetRoleId = 0l;
		try {
			Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), MedicusConstant.PARTNER_ORG_ROLE);
			partnetRoleId = role.getRoleId();
		} catch (PortalException e) {
			_log.error(e);
		}
		return partnetRoleId;
	}
	
	public User isUserExist(String emailAddress){
		User user = null;
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), emailAddress);
		} catch (PortalException e) {
			//_log.error(e);
		}
		return user;
	}
	
	public long getUserPhoneTypeId() throws SystemException {
		long userPhoneType=0;	
		List<ListType> listTypes = ListTypeServiceUtil
					.getListTypes(ListTypeConstants.CONTACT_PHONE);
		if(listTypes.size()>0){	
			userPhoneType = listTypes.get(0).getListTypeId();
		}
		return userPhoneType;
	}
	
	public List<String> getUSStateList(){
		String[] usStateArray = PropsUtil.get("us.states").split(StringPool.COMMA);
		List<String> usStateList = ListUtil.fromArray(usStateArray);
		return usStateList;
	}
	
	public boolean isFolderExist(long groupId,long parentFolderId,String folderName){
		boolean folderExist = false;
		try { 
			DLAppServiceUtil.getFolder(groupId, parentFolderId, folderName); 
			folderExist = true;
		} catch (Exception e) {	
			//LOG.error(e.getMessage(), e);
		} 
		return folderExist; 
	}
	
	public Folder getFolder(long groupId, long parentFolderId,String folderName) { 
		boolean defaultFolderExist = isFolderExist(groupId,parentFolderId,String.valueOf(folderName)); 
		Folder patientFolder=null;
		if (!defaultFolderExist) {
			long repositoryId = groupId;
			try {
				ServiceContext serviceContext = new ServiceContext(); 
				patientFolder = DLAppServiceUtil.addFolder(repositoryId,parentFolderId, folderName,StringPool.BLANK, serviceContext);
			} catch (PortalException e1) { 
				_log.error(e1.getMessage(), e1);
			} catch (SystemException e1) {
				_log.error(e1.getMessage(), e1);
			}	
		}else{
			try {
				patientFolder =	DLAppServiceUtil.getFolder(groupId, parentFolderId, folderName);
			} catch (PortalException e1) {
				_log.error(e1.getMessage(), e1);
			}
		}
		return patientFolder;
	}
	
	
	public List<Partner> getPartnerList(){
		return PartnerLocalServiceUtil.getPartners(-1, -1);
	}
	
	public FileEntry addFileEntry(long groupId, long folderId, File file, String fileName) throws PortalException{
		ServiceContext serviceContext = new ServiceContext(); 
		return DLAppServiceUtil.addFileEntry(groupId, folderId, fileName, MimeTypesUtil.getContentType(file), fileName, StringPool.BLANK, StringPool.BLANK, file, serviceContext);
	}
	
	public FileEntry updateFileEntry(long fileEntryId,long groupId, long folderId, File file, String fileName) throws PortalException{
		ServiceContext serviceContext = new ServiceContext(); 
		return DLAppServiceUtil.updateFileEntry(fileEntryId, fileName, MimeTypesUtil.getContentType(file), fileName, StringPool.BLANK, StringPool.BLANK, true, file, serviceContext);
	}
	
	public long getGlobalGroupId(){
		try {
			return GroupLocalServiceUtil.getCompanyGroup(PortalUtil.getDefaultCompanyId()).getGroupId();
		} catch (PortalException e) {
		}
		return 0l;
	}
	
	public String getDLFileURL(DLFileEntry file) {
	       return "/documents/" + file.getGroupId() + StringPool.FORWARD_SLASH + file.getFolderId() + StringPool.FORWARD_SLASH
	            + file.getTitle() + StringPool.FORWARD_SLASH + file.getUuid();
	}
	
	public String getDLFileURL(FileEntry file) {
	       return "/documents/" + file.getGroupId() + StringPool.FORWARD_SLASH + file.getFolderId() + StringPool.FORWARD_SLASH
	            + file.getTitle() + StringPool.FORWARD_SLASH + file.getUuid();
	}
	

	public File getStudentResumeContent(Student student){
		File file = null;
		if(Validator.isNotNull(student) && student.getResumeFileEntryId()>0){
			try {
				DLFileEntry dlFileEntry  = DLFileEntryLocalServiceUtil.getDLFileEntry(student.getResumeFileEntryId());
				FileEntry fileEntry = DLAppServiceUtil.getFileEntry(dlFileEntry.getFileEntryId());
				 file = DLFileEntryLocalServiceUtil.getFile(fileEntry.getFileEntryId(), dlFileEntry.getClassName(), false);
			} catch (Exception e) {
				_log.error(e.getMessage());
			}
		}
		return file;
	}
}