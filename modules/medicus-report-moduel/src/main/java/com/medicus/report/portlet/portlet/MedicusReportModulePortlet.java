package com.medicus.report.portlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.School;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.SchoolLocalServiceUtil;
import com.medicus.report.portlet.portlet.util.ReportModuleConstant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.medicus",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Medicus Report Module Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MedicusReportModulePortlet extends MVCPortlet {
	
	Log _log = LogFactoryUtil.getLog(MedicusReportModulePortlet.class.getName());
	
	@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			
			ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long medicusOrgId = MedicusCommonLocalServiceUtil.getMedicusOrganizationId();
			long medicusOrgGroupId = MedicusCommonLocalServiceUtil.getOrganizationGroupIdFromOrgId(medicusOrgId);
			
			renderRequest.setAttribute("schoolList", SchoolLocalServiceUtil.getSchools(-1, -1));	
			
			// Check users role from CampusAdmin, Campus Super Admin, School Admin, School Super Admin
			// and set it as default search of users.

			long campusId=0;
			long schoolId=0;
			List<School> schoolListForSchoolAdmin = new ArrayList<School>();
			try {
				Role schoolSupreAdminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), PropsUtil.get("medicus.school.super.admin.role"));
				Role schoolAdminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), PropsUtil.get("medicus.school.admin.role"));
				Role campusSuperAdminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), PropsUtil.get("medicus.campus.super.admin.role"));
				Role campusAdminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), PropsUtil.get("medicus.campus.admin.role"));
		
				boolean hasSchoolAdminRole = UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), medicusOrgGroupId, schoolAdminRole.getRoleId());
				boolean hasSchoolSuperAdminRole = UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), medicusOrgGroupId, schoolSupreAdminRole.getRoleId());
				boolean hasCampusAdminRole = UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), medicusOrgGroupId, campusAdminRole.getRoleId());
				boolean hasCampusSuperAdminRole = UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), medicusOrgGroupId, campusSuperAdminRole.getRoleId());
				
				if(hasCampusAdminRole){
					 campusId = MedicusCommonLocalServiceUtil.getCampusOrgIdFromRoleIdAndUserId(themeDisplay.getUserId(), campusAdminRole.getRoleId());
				}
				if(hasCampusSuperAdminRole){
					 campusId = MedicusCommonLocalServiceUtil.getCampusOrgIdFromRoleIdAndUserId(themeDisplay.getUserId(), campusSuperAdminRole.getRoleId());
				}
				if(hasSchoolAdminRole){
					 campusId = MedicusCommonLocalServiceUtil.getCampusOrgIdFromRoleIdAndUserId(themeDisplay.getUserId(), schoolAdminRole.getRoleId());
				}
				if(hasSchoolSuperAdminRole){
					 campusId = MedicusCommonLocalServiceUtil.getCampusOrgIdFromRoleIdAndUserId(themeDisplay.getUserId(), schoolSupreAdminRole.getRoleId());
				}
				
				if(campusId>0){
					try{
						Campus campus = CampusLocalServiceUtil.getCampus(campusId);
						schoolId = campus.getSchoolId();
					}catch(PortalException e){
						_log.debug(e.getMessage());
					}
				}
				if(schoolId>0){
					try{
						School school = SchoolLocalServiceUtil.getSchool(schoolId);
						schoolListForSchoolAdmin.add(school);
					}catch(PortalException e){
						_log.debug(e.getMessage());
					}
				}
				renderRequest.setAttribute("userCampusId", campusId);
				renderRequest.setAttribute("userSchoolId", schoolId);
				// Update request attribure for school admin/ super admin.
				if(schoolListForSchoolAdmin.size()>0){
					renderRequest.setAttribute("schoolList", schoolListForSchoolAdmin);
				}
			} catch (PortalException e) {
				_log.error(e);
			}
			renderRequest.setAttribute("itemPerPage", ReportModuleConstant.MAX_STUDENTS_DISPLAY_PAGE);
			include(viewTemplate, renderRequest, renderResponse);
			
		}
}