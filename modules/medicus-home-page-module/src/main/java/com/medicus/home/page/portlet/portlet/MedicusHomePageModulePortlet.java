package com.medicus.home.page.portlet.portlet;

import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.CampusLocalService;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.common.service.service.SchoolLocalServiceUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.home.page.portlet.constants.MedicusHomePageModulePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author sandip
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=medicus-home-page-module Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MedicusHomePageModulePortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
			ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
			if(themeDisplay.isSignedIn()){
				PortalUtil.getHttpServletResponse(renderResponse).sendRedirect("/group/medicus/");
			}
			
			//
			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			String registrationResponse = httpReq.getParameter("registration");
			if(Validator.isNotNull(registrationResponse)){
				if(registrationResponse.equals("success")){
					SessionMessages.add(renderRequest, "user-register-success");
				}else if(registrationResponse.endsWith("error")){
					SessionErrors.add(renderRequest, "err-register-user");
					SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				}
			}
		
			include(viewTemplate, renderRequest, renderResponse);
	}
}