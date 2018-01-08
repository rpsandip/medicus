package com.medicus.graph.portlet.portlet;

import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.School;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.SchoolLocalServiceUtil;
import com.medicus.common.service.util.MedicusConstant;
import com.medicus.graph.portlet.constants.MedicusGraphPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactory;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
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
		"javax.portlet.display-name=Medicus Graph Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MedicusGraphPortlet extends MVCPortlet {
	
		Log _log = LogFactoryUtil.getLog(MedicusGraphPortlet.class.getName());
	
		@Override
		public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
				throws IOException, PortletException {
			
			List<School> schoolListForSchoolAdmin = new ArrayList<School>();
			MedicusCommonLocalServiceUtil.setUserSchoolIdCampusIdInRequest(renderRequest, schoolListForSchoolAdmin);
			
			// Report Page layout plid
		    Layout layout;
			try {
				layout = LayoutLocalServiceUtil.getFriendlyURLLayout(MedicusCommonLocalServiceUtil.getMedicusGroupId(),
				        true, MedicusConstant.REPORT_PAGE_URL);
				long plid = layout.getPlid();
				renderRequest.setAttribute("report_page_plid", plid);
			} catch (PortalException e) {
				_log.error(e);
			}
			
			include(viewTemplate, renderRequest, renderResponse);
		}
}