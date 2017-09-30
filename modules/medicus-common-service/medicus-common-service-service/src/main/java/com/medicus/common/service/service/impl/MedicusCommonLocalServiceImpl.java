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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.medicus.common.service.service.base.MedicusCommonLocalServiceBaseImpl;

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
			Organization org = OrganizationLocalServiceUtil.getOrganization(PortalUtil.getDefaultCompanyId(), "Medicus");
			medicusOrgId  = org.getOrganizationId();
		} catch (PortalException e) {
			_log.error(e);
		}
		return medicusOrgId;
	}
	
	public long getEmployerOrgRoleId(){
		long employerRoleId = 0l;
		try {
			Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), "Employer");
			employerRoleId = role.getRoleId();
		} catch (PortalException e) {
			_log.error(e);
		}
		return employerRoleId;
	}
	
	public User isUserExist(String emailAddress){
		User user = null;
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(PortalUtil.getDefaultCompanyId(), emailAddress);
		} catch (PortalException e) {
			_log.error(e);
		}
		return user;
	}
	
}