package com.medicus.common.service.bean;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.School;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.SchoolLocalServiceUtil;

public class SchoolUserBean {
	
	Log _log = LogFactoryUtil.getLog(SchoolUserBean.class.getName());
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String contactNum;
	private String role;
	private long roleId;
	private String school;
	private long schoolId;
	private String campus;
	private long campusId;
	private User user;
	
	public SchoolUserBean(User user){
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.emailAddress = user.getEmailAddress();
		this.contactNum = user.getPhones().size()>0 ? user.getPhones().get(0).getNumber() : StringPool.BLANK;
	}
	
	public SchoolUserBean(User user, List<Long> schoolRoleList, List<Long> campusRoleList, long medicusOrgGroupId){
		if(Validator.isNotNull(user)){
			this.firstName = user.getFirstName();
			this.lastName = user.getLastName();
			this.emailAddress = user.getEmailAddress();
			this.contactNum = user.getPhones().size()>0 ? user.getPhones().get(0).getNumber() : StringPool.BLANK;
			this.role = StringPool.BLANK;
			this.school = StringPool.BLANK;
			this.campus = StringPool.BLANK;
			this.user=user;
			
			List<UserGroupRole> userGroupRoleList= UserGroupRoleLocalServiceUtil.getUserGroupRoles(user.getUserId());
			for(UserGroupRole userGroupRole : userGroupRoleList){
				if(schoolRoleList.contains(userGroupRole.getRoleId()) && userGroupRole.getGroupId() != medicusOrgGroupId){
					try {
						    Role role = RoleLocalServiceUtil.getRole(userGroupRole.getRoleId());
							this.role = this.role+ role.getTitleCurrentValue();
							this.roleId = role.getRoleId();
							
							Group group = GroupLocalServiceUtil.getGroup(userGroupRole.getGroupId());
							Organization org = OrganizationLocalServiceUtil.getOrganization(group.getClassPK());
							
							Campus campus = CampusLocalServiceUtil.getCampus(Long.parseLong(org.getName()));
							School school = SchoolLocalServiceUtil.getSchool(campus.getSchoolId());
							this.schoolId = school.getSchoolId();
							this.school = school.getName();
							this.campus = StringPool.DASH;
					} catch (PortalException e) {
						_log.error(e);
					}
					break;
				}
				if(campusRoleList.contains(userGroupRole.getRoleId()) && userGroupRole.getGroupId() != medicusOrgGroupId){
					try {
					    Role role = RoleLocalServiceUtil.getRole(userGroupRole.getRoleId());
						this.role = this.role+ role.getTitleCurrentValue();
						this.roleId = role.getRoleId();
						Group group = GroupLocalServiceUtil.getGroup(userGroupRole.getGroupId());
						Organization org = OrganizationLocalServiceUtil.getOrganization(group.getClassPK());
						
						Campus campus = CampusLocalServiceUtil.getCampus(Long.parseLong(org.getName()));
						School school = SchoolLocalServiceUtil.getSchool(campus.getSchoolId());
						this.campusId = campus.getCampusId();
						this.schoolId = school.getSchoolId();
						this.school = school.getName();
						this.campus = campus.getName();
				} catch (PortalException e) {
					_log.error(e);
				}
				break;	
				}
			}

		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}

	public long getCampusId() {
		return campusId;
	}

	public void setCampusId(long campusId) {
		this.campusId = campusId;
	}
	
	
	
	
}
