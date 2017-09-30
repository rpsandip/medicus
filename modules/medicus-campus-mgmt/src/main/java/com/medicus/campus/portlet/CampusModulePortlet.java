package com.medicus.campus.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.medicus.common.service.bean.CampusBean;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.service.CampusLocalServiceUtil;

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
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Medicus Campus Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.action-url-redirect=true",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CampusModulePortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<Campus> campusList = CampusLocalServiceUtil.getCampuses(-1, -1);
		List<CampusBean> campusBeanList = new ArrayList<CampusBean>();
		for(Campus campus : campusList){
			CampusBean campusBean = new CampusBean(campus);
			campusBeanList.add(campusBean);
		}
		renderRequest.setAttribute("campusBeanList", campusBeanList);
		include(viewTemplate, renderRequest, renderResponse);
	}
}