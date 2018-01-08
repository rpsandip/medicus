package com.medicus.user.portlet.portlet.resourcecommand;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
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
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.user.portlet.portlet.util.UserModuleConstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + UserModuleConstant.PORTLET_ID,
	        "mvc.command.name=/getSchoolDetail"
	    },
	    service = MVCResourceCommand.class
	)
public class GetScholDetailResoueceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(GetScholDetailResoueceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		JSONArray schoolRolesArray = JSONFactoryUtil.createJSONArray();
		JSONArray schoolCampusArray = JSONFactoryUtil.createJSONArray();
		long schoolId = ParamUtil.getLong(resourceRequest, "schoolId");
		
		// Get School Roles Detail
		if(schoolId>0){
			String schoolRoles = PropsUtil.get("medicus.school.roles");
			for(String schoolRole : schoolRoles.split(StringPool.COMMA)){
				try {
					Role role = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), schoolRole);
					JSONObject schoolRoleJsonObj = JSONFactoryUtil.createJSONObject();
					schoolRoleJsonObj.put("roleId", role.getRoleId());
					schoolRoleJsonObj.put("name", role.getTitleCurrentValue());
					schoolRolesArray.put(schoolRoleJsonObj);
				} catch (PortalException e) {
					_log.error(e);
				}
			}
		}
		responseObj.put("roles",schoolRolesArray);
		
		// Get School Campus Detail
		if(schoolId>0){
			List<Campus> campusList = CampusLocalServiceUtil.getCampusListBySchooId(schoolId);
			for(Campus campus : campusList){
				JSONObject campusJsonObject = JSONFactoryUtil.createJSONObject();
				campusJsonObject.put("campusId", campus.getCampusId());
				campusJsonObject.put("name", campus.getName());
				schoolCampusArray.put(campusJsonObject);
			}
		}
		responseObj.put("campuses", schoolCampusArray);
		
		try {
			resourceResponse.getWriter().write(responseObj.toString());
		} catch (IOException e) {
			_log.error(e);
		}
		return true;
	}

}
