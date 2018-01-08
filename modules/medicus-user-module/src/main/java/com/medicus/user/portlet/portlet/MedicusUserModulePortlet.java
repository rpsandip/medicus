package com.medicus.user.portlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.medicus.common.service.bean.CampusBean;
import com.medicus.common.service.bean.SchoolUserBean;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Medicus User Module Portlet",
		"javax.portlet.init-param.template-path=/",
		"com.liferay.portlet.action-url-redirect=true",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MedicusUserModulePortlet extends MVCPortlet {
	
	Log _log = LogFactoryUtil.getLog(MedicusUserModulePortlet.class.getName());
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		getSchoolUserList(renderRequest, renderResponse);
		include(viewTemplate, renderRequest, renderResponse);
	}
	
	private void getSchoolUserList(RenderRequest renderRequest, RenderResponse renderResponse){
		long medicusOrgId = MedicusCommonLocalServiceUtil.getMedicusOrganizationId();
		long medicusOrgGroupId = MedicusCommonLocalServiceUtil.getOrganizationGroupIdFromOrgId(medicusOrgId);
		
		// TODO :  need to improve get list of users only from Campus Organizations
		List<User> medicusUserList = UserLocalServiceUtil.getOrganizationUsers(medicusOrgId);
		List<Long> schoolRoleList = new ArrayList<Long>();
		List<Long> campusRoleList = new ArrayList<Long>();
		List<SchoolUserBean> medicusUserBeanList =  new ArrayList<SchoolUserBean>();
		
		// Get user by School, Campus roles
		try {
			Role schoolSupreAdminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), PropsUtil.get("medicus.school.super.admin.role"));
			Role schoolAdminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), PropsUtil.get("medicus.school.admin.role"));
			Role campusSuperAdminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), PropsUtil.get("medicus.campus.super.admin.role"));
			Role campusAdminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), PropsUtil.get("medicus.campus.admin.role"));
	
			schoolRoleList.add(schoolSupreAdminRole.getRoleId());
			schoolRoleList.add(schoolAdminRole.getRoleId());
			campusRoleList.add(campusSuperAdminRole.getRoleId());
			campusRoleList.add(campusAdminRole.getRoleId());
		} catch (PortalException e) {
			_log.error(e);
		}
		
		Collections.sort(medicusUserList, new Comparator<User>() {

	        public int compare(User o1, User o2) {
	            return o2.getCreateDate().compareTo(o1.getCreateDate());
	        }
	    });
		for(User user : medicusUserList){
			SchoolUserBean medicusUserBean = new SchoolUserBean(user, schoolRoleList, campusRoleList, medicusOrgGroupId);
			
			// TODO :  need to improve get list of users only from Campus Organizations
			if(medicusUserBean.getSchoolId()>0){
				medicusUserBeanList.add(medicusUserBean);
			}
		}
		
		renderRequest.setAttribute("medicusUserBeanList", medicusUserBeanList);
		
	}
}