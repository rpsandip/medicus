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

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.common.service.service.base.RegistrationLocalServiceBaseImpl;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.medicus.common.service.service.RegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sandip.patel
 * @see RegistrationLocalServiceBaseImpl
 * @see com.medicus.common.service.service.RegistrationLocalServiceUtil
 */
@ProviderType
public class RegistrationLocalServiceImpl extends RegistrationLocalServiceBaseImpl {
	
	Log  _log = LogFactoryUtil.getLog(RegistrationLocalServiceImpl.class.getName());
	
	public User registerPartner(String fName, String lastName, String emailAddress, String password1, String password2,
			String address1, String city, String zipcode, String state, String country, String contactPersonName,
			String contactPersonEmail, String contactPersonPhoneNumber, String websiteLink,long creatorUserId, long groupId) throws PortalException{
		
		User user = null;
		
		// Get default Medicus Organization
		long medicusOrganizationId = MedicusCommonLocalServiceUtil.getMedicusOrganizationId();
		long medicusOrganizationGroupId = MedicusCommonLocalServiceUtil.getOrganizationGroupIdFromOrgId(medicusOrganizationId);			
		
		// Get Partner Organization  role 
		long partnerRoleId = MedicusCommonLocalServiceUtil.getPartnerOrgRoleId();
		
		if(medicusOrganizationId>0 && partnerRoleId>0){
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setUuid(UUID.randomUUID().toString());
			serviceContext.setCreateDate(new Date());
			serviceContext.setModifiedDate(new Date());
			long[] organizationIds = new long[]{medicusOrganizationId};

			if(Validator.isNotNull(password1) && Validator.isNotNull(password2)){
				user = UserLocalServiceUtil.addUser(creatorUserId, PortalUtil.getDefaultCompanyId(), false, password1, password2,
						 true, null, emailAddress, 0l, StringPool.BLANK, 
						PortalUtil.getSiteDefaultLocale(groupId), fName,StringPool.BLANK, lastName, 1l, 
						1l, true, 1, 1, 1970,
						StringPool.BLANK, null, organizationIds, null, null,
						true, serviceContext);
			}else{
				user = UserLocalServiceUtil.addUser(creatorUserId, PortalUtil.getDefaultCompanyId(), true, StringPool.BLANK, StringPool.BLANK,
						 true, null, emailAddress, 0l, StringPool.BLANK, 
						PortalUtil.getSiteDefaultLocale(groupId), fName,StringPool.BLANK, lastName, 1l, 
						1l, true, 1, 1, 1970,
						StringPool.BLANK, null, organizationIds, null, null,
						true, serviceContext);
			}
			
			_log.info("User crearted ->" + user.getUserId());
			
			// Add Partner Organization level role to user
			 if(Validator.isNotNull(user)){
				 UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(), medicusOrganizationGroupId, new long[]{partnerRoleId});
				
			 // Add Partner detail
				 addPartnerDetail(creatorUserId, user.getUserId(),password1, password2, address1, city, zipcode, state, country,
					 contactPersonName, contactPersonEmail, contactPersonPhoneNumber, websiteLink,  creatorUserId);
		
			 }

		}
		return user;
	}
	
	private void addPartnerDetail(long creatorUserId, long userId, String password1, String password2,
			String address1, String city, String zipcode, String state, String country, String contactPersonName,
			String contactPersonEmail, String contactPersonPhoneNumber, String websiteLink, long createdBy) throws PortalException{
			
			// Create Organization for Partner on name of userId
			Organization partnerOrg = createPartnerOrg(creatorUserId, userId);
			if(Validator.isNotNull(partnerOrg)){
				Partner partner = PartnerLocalServiceUtil.createPartner(CounterLocalServiceUtil.increment());
				partner.setAddress1(address1);
				partner.setZipcode(zipcode);
				partner.setUserId(userId);
				partner.setPartnerOrgId(partnerOrg.getOrganizationId());
				partner.setCity(city);
				partner.setState(state);
				partner.setCountry(country);
				partner.setContactPersonName(contactPersonName);
				partner.setContactPersonEmail(contactPersonEmail);
				partner.setContactPersonPhoneNumber(contactPersonPhoneNumber);
				partner.setWebsiteLink(websiteLink);
				
				partner.setCreatedBy(createdBy);
				partner.setModifiedBy(createdBy);
				partner.setCreateDate(new Date());
				partner.setModifiedDate(new Date());
				
				partner = PartnerLocalServiceUtil.addPartner(partner);
				
				 _log.info("partner crearted ->" + partner.getPartnerId());
			}
	}
	
	private Organization createPartnerOrg(long creatorUserId, long userId) throws PortalException{
		return OrganizationLocalServiceUtil.addOrganization(creatorUserId, 0l, String.valueOf(userId), true);
	}
	
	public User createSchoolUser(String firstName, String lastName, String emailAddress, String contactNumber, long schoolId,
			long campusId, long roleId, long creatorUserId, long groupId) throws PortalException{
		User user = null;
		Organization campusOrg = null;
		Role role = null;
		long[] organizationIds=null;
		
		// Get default Medicus Organization
		long medicusOrganizationId = MedicusCommonLocalServiceUtil.getMedicusOrganizationId();
				
		
		// Get Campus Organization
		if(schoolId>0 && campusId>0){
			try{
				campusOrg = OrganizationLocalServiceUtil.getOrganization(PortalUtil.getDefaultCompanyId(), String.valueOf(campusId));
				organizationIds = new long[]{campusOrg.getOrganizationId(),medicusOrganizationId};
			}catch(PortalException e){
				_log.error(e);
			}
		}else if(schoolId>0 && campusId==0){
			List<Campus> campusList = CampusLocalServiceUtil.getCampusListBySchooId(schoolId);
			organizationIds = new long[campusList.size()+1];
			for(int i=0;i<campusList.size();i++){
				organizationIds[i] = OrganizationLocalServiceUtil.getOrganizationId(PortalUtil.getDefaultCompanyId(), String.valueOf(campusList.get(i).getCampusId()));
			}
			organizationIds[campusList.size()]=medicusOrganizationId;
		}
		if(roleId>0){
			 try {
				role  = RoleLocalServiceUtil.getRole(roleId);
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		
		// Add LR User
			
			ServiceContext serviceContext = new ServiceContext();
			serviceContext.setUuid(UUID.randomUUID().toString());
			serviceContext.setCreateDate(new Date());
			serviceContext.setModifiedDate(new Date());
			
			user = UserLocalServiceUtil.addUser(creatorUserId, PortalUtil.getDefaultCompanyId(), true, null, null,
					 true, null, emailAddress, 0l, StringPool.BLANK, 
					PortalUtil.getSiteDefaultLocale(groupId), firstName,StringPool.BLANK, lastName, 1l, 
					1l, true, 1, 1, 1970,
					StringPool.BLANK, null, organizationIds, null, null,
					true, serviceContext);
			
			// Add Campus/School Role to user
			 if(Validator.isNotNull(user) && Validator.isNotNull(role)){
				 _log.info("User created ->" + user.getUserId());
				 for(long orgId : organizationIds){
					 long orgGroupId = MedicusCommonLocalServiceUtil.getOrganizationGroupIdFromOrgId(orgId);
					 if(orgGroupId!=0){
						 UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(), orgGroupId, new long[]{role.getRoleId()});
					 }
				 }
			 }
			 
			 // Add user Phone Number
			 long phoneTypId = MedicusCommonLocalServiceUtil.getUserPhoneTypeId();
			 PhoneLocalServiceUtil.addPhone(user.getUserId(), Contact.class.getName(),
					 user.getContactId(), contactNumber, StringPool.BLANK, phoneTypId, true, new ServiceContext());
			
		return user;
	}
	
	public User updateSchoolUser(long userId, String firstName, String lastName, String emailAddress, String contactNumber, long schoolId,
			long campusId, long roleId, long creatorUserId, long groupId) throws PortalException{
		
		User user = null;
		Organization campusOrg = null;
		Role role = null;
		long[] organizationIds=null;
		user = UserLocalServiceUtil.getUser(userId);
		 
		// Get default Medicus Organization
			long medicusOrganizationId = MedicusCommonLocalServiceUtil.getMedicusOrganizationId();
					
			
			// Get Campus Organization
			if(schoolId>0 && campusId>0){
				try{
					campusOrg = OrganizationLocalServiceUtil.getOrganization(PortalUtil.getDefaultCompanyId(), String.valueOf(campusId));
					organizationIds = new long[]{campusOrg.getOrganizationId(),medicusOrganizationId};
				}catch(PortalException e){
					_log.error(e);
				}
			}else if(schoolId>0 && campusId==0){
				List<Campus> campusList = CampusLocalServiceUtil.getCampusListBySchooId(schoolId);
				organizationIds = new long[campusList.size()+1];
				for(int i=0;i<campusList.size();i++){
					organizationIds[i] = OrganizationLocalServiceUtil.getOrganizationId(PortalUtil.getDefaultCompanyId(), String.valueOf(campusList.get(i).getCampusId()));
				}
				organizationIds[campusList.size()]=medicusOrganizationId;
			}
			if(roleId>0){
				 try {
					role  = RoleLocalServiceUtil.getRole(roleId);
				} catch (PortalException e) {
					_log.error(e);
				}
			}
		 
			user.setFirstName(firstName);
			user.setLastName(lastName);
			
			// User user basic detail
			UserLocalServiceUtil.updateUser(user);
			
			// Update user organizations
			UserLocalServiceUtil.updateOrganizations(user.getUserId(), organizationIds, new ServiceContext());
			
			// Update organization roles
			UserGroupRoleLocalServiceUtil.deleteUserGroupRolesByUserId(userId);
			
			for(long orgId : organizationIds){
				 long orgGroupId = MedicusCommonLocalServiceUtil.getOrganizationGroupIdFromOrgId(orgId);
				 if(orgGroupId!=0){
					 UserGroupRoleLocalServiceUtil.addUserGroupRoles(user.getUserId(), orgGroupId, new long[]{role.getRoleId()});
				 }
			 }
			
			// Update phone number
			if(user.getPhones().size()>0){
				Phone phone = user.getPhones().get(0);
				phone.setNumber(contactNumber);
				PhoneLocalServiceUtil.updatePhone(phone);
			}
			
			return user;
	}
	
}