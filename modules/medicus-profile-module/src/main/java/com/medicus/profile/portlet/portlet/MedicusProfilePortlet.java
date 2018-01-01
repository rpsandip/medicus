package com.medicus.profile.portlet.portlet;

import com.medicus.common.service.bean.PartnerBean;
import com.medicus.common.service.bean.SchoolUserBean;
import com.medicus.common.service.exception.NoSuchPartnerException;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.profile.portlet.constants.MedicusProfilePortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author sandip
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Medicus Profile Portlet",
		"javax.portlet.init-param.template-path=/",
		"com.liferay.portlet.action-url-redirect=true",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MedicusProfilePortlet extends MVCPortlet {
		
		Log _log = LogFactoryUtil.getLog(MedicusProfilePortlet.class.getName());
	
		@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
				
				ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

				boolean isPartner = false;
				long partnerRoleId = MedicusCommonLocalServiceUtil.getPartnerOrgRoleId();
				long medicusGroupId = MedicusCommonLocalServiceUtil.getMedicusGroupId();
				if(partnerRoleId>0){
					List<UserGroupRole> userGroupRoleList = UserGroupRoleLocalServiceUtil.getUserGroupRoles(themeDisplay.getUserId(), medicusGroupId);
					for(UserGroupRole userGroupRole : userGroupRoleList){
						if(userGroupRole.getRoleId()==partnerRoleId){
							isPartner = true;
							break;
						}
					}
				}
					
				if(isPartner){
					try {
						Partner partner = PartnerLocalServiceUtil.getPartnerByUserId(themeDisplay.getUserId());
						PartnerBean partnerBean = new PartnerBean(partner);
						renderRequest.setAttribute("partnerBean", partnerBean);
					} catch (NoSuchPartnerException e) {
						_log.error(e);
					} 
				}else{
					try {
						User user =UserLocalServiceUtil.getUser(themeDisplay.getUserId());
						SchoolUserBean schoolUserBean = new SchoolUserBean(user);
						renderRequest.setAttribute("schoolUserBean", schoolUserBean);
					} catch (PortalException e) {
						_log.error(e);
					}
				}
				
				renderRequest.setAttribute("usStateList", MedicusCommonLocalServiceUtil.getUSStateList());
				renderRequest.setAttribute("isPartner", isPartner);
				include(viewTemplate, renderRequest, renderResponse);
		}
}