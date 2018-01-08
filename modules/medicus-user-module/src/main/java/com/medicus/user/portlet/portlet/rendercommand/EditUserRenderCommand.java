package com.medicus.user.portlet.portlet.rendercommand;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactory;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.medicus.common.service.bean.SchoolUserBean;
import com.medicus.common.service.model.School;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.SchoolLocalServiceUtil;
import com.medicus.user.portlet.portlet.util.UserModuleConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+ UserModuleConstant.PORTLET_ID,
	        "mvc.command.name=/edit_user"
	    },
	    service = MVCRenderCommand.class
)
public class EditUserRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(EditUserRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long userId = ParamUtil.getLong(renderRequest, "userId");
		long medicusOrgId = MedicusCommonLocalServiceUtil.getMedicusOrganizationId();
		long medicusOrgGroupId = MedicusCommonLocalServiceUtil.getOrganizationGroupIdFromOrgId(medicusOrgId);
		if(userId>0){
			List<Long> schoolRoleList = new ArrayList<Long>();
			List<Long> campusRoleList = new ArrayList<Long>();
			try {
				Role schoolSupreAdminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), PropsUtil.get("medicus.school.super.admin.role"));
				Role schoolAdminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), PropsUtil.get("medicus.school.admin.role"));
				Role campusSuperAdminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), PropsUtil.get("medicus.campus.super.admin.role"));
				Role campusAdminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), PropsUtil.get("medicus.campus.admin.role"));
		
				schoolRoleList.add(schoolSupreAdminRole.getRoleId());
				schoolRoleList.add(schoolAdminRole.getRoleId());
				campusRoleList.add(campusSuperAdminRole.getRoleId());
				campusRoleList.add(campusAdminRole.getRoleId());
				
				User user = UserLocalServiceUtil.getUser(userId);
				SchoolUserBean schoolUserBean = new SchoolUserBean(user, schoolRoleList, campusRoleList,medicusOrgGroupId);
				renderRequest.setAttribute("schoolUserBean", schoolUserBean);
				
				List<School> schoolList = SchoolLocalServiceUtil.getSchools(-1, -1);
				renderRequest.setAttribute("schoolList", schoolList);
				
			} catch (PortalException e) {
				_log.error(e);
				return "/view.jsp";
			}
		}else{
			return "/view.jsp";
		}
		
		return "/user/edit_user.jsp";
	}

}
