package com.medicus.user.portlet.portlet.resourcecommand;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.medicus.user.portlet.portlet.util.UserModuleConstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + UserModuleConstant.PORTLET_ID,
	        "mvc.command.name=/getCampusDetail"
	    },
	    service = MVCResourceCommand.class
	)
public class GetCampusDetailResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(GetCampusDetailResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		long campusId = ParamUtil.getLong(resourceRequest, "campusId");
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		JSONArray campusRolesArray = JSONFactoryUtil.createJSONArray();
		if(campusId>0){
			String campusRoles = PropsUtil.get("medicus.campus.roles");
			for(String schoolRole : campusRoles.split(StringPool.COMMA)){
				try {
					Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), schoolRole);
					JSONObject schoolRoleJsonObj = JSONFactoryUtil.createJSONObject();
					schoolRoleJsonObj.put("roleId", role.getRoleId());
					schoolRoleJsonObj.put("name", role.getTitleCurrentValue());
					campusRolesArray.put(schoolRoleJsonObj);
				} catch (PortalException e) {
					_log.error(e);
				}
			}
		}
		responseObj.put("roles",campusRolesArray);
		try {
			resourceResponse.getWriter().write(responseObj.toString());
		} catch (IOException e) {
			_log.error(e);
		}
		return true;
	}

}
