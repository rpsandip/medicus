package com.medicus.school.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.medicus.common.service.model.School;
import com.medicus.common.service.service.SchoolLocalServiceUtil;

import java.io.IOException;
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
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=School Managment Portlet",
		"javax.portlet.init-param.template-path=/",
		"com.liferay.portlet.action-url-redirect=true",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SchoolManagmentModulePortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		List<School> schoolList = SchoolLocalServiceUtil.getSchools(-1, -1);
		renderRequest.setAttribute("schoolList", schoolList);
		include(viewTemplate, renderRequest, renderResponse);
	}
}