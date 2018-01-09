package com.medicus.report.portlet.portlet.resourcecommand;

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
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.report.portlet.portlet.util.ReportModuleConstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + ReportModuleConstant.PORTLET_ID,
	        "mvc.command.name=/getSchoolDetail"
	    },
	    service = MVCResourceCommand.class
	)
public class GetScholDetailResoueceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(GetScholDetailResoueceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		JSONArray schoolCampusArray = JSONFactoryUtil.createJSONArray();
		long schoolId = ParamUtil.getLong(resourceRequest, "schoolId");
		long medicusOrgId = MedicusCommonLocalServiceUtil.getMedicusOrganizationId();
		long medicusOrgGroupId = MedicusCommonLocalServiceUtil.getOrganizationGroupIdFromOrgId(medicusOrgId);
		boolean hasCampusAdminRole = false;
		boolean hasCampusSuperAdminRole = false;
		long search_campusId=0;
		try {
			Role campusSuperAdminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), PropsUtil.get("medicus.campus.super.admin.role"));
			Role campusAdminRole = RoleLocalServiceUtil.getRole(PortalUtil.getDefaultCompanyId(), PropsUtil.get("medicus.campus.admin.role"));
	
			 hasCampusAdminRole = UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), medicusOrgGroupId, campusAdminRole.getRoleId());
			 hasCampusSuperAdminRole = UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), medicusOrgGroupId, campusSuperAdminRole.getRoleId());
	
			 if(hasCampusAdminRole){
				 search_campusId = MedicusCommonLocalServiceUtil.getCampusOrgIdFromRoleIdAndUserId(themeDisplay.getUserId(), campusAdminRole.getRoleId());
			 }
			 if(hasCampusSuperAdminRole){
				 search_campusId  =MedicusCommonLocalServiceUtil.getCampusOrgIdFromRoleIdAndUserId(themeDisplay.getUserId(), campusSuperAdminRole.getRoleId());
			 }
		} catch (PortalException e) {
			_log.error(e);
		}
		
		// Get School Campus Detail
		if(schoolId>0){
			List<Campus> campusList = CampusLocalServiceUtil.getCampusListBySchooId(schoolId);
			
			if(search_campusId>0){
				for(Campus campus : campusList){
					if(campus.getCampusId()==search_campusId){
						JSONObject campusJsonObject = JSONFactoryUtil.createJSONObject();
						campusJsonObject.put("campusId", campus.getCampusId());
						campusJsonObject.put("name", campus.getName());
						schoolCampusArray.put(campusJsonObject);
					}
				}
			}else{
				for(Campus campus : campusList){
					JSONObject campusJsonObject = JSONFactoryUtil.createJSONObject();
					campusJsonObject.put("campusId", campus.getCampusId());
					campusJsonObject.put("name", campus.getName());
					schoolCampusArray.put(campusJsonObject);
				}
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
