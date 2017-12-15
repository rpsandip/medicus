package com.medicus.partner.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.medicus.common.service.bean.PartnerBean;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.service.PartnerLocalServiceUtil;

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
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Medicus Partner Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.action-url-redirect=true",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PartnerModulePortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		List<Partner> partnerList = PartnerLocalServiceUtil.getPartners(-1, -1);
		List<PartnerBean> partnerBeanList = new ArrayList<PartnerBean>();
		for(Partner partner : partnerList){
			PartnerBean partnerBean = new PartnerBean(partner);
			if(partnerBean.getUser().isActive()){
				partnerBeanList.add(partnerBean);
			}
		}
		renderRequest.setAttribute("partnerBeanList", partnerBeanList);
		include(viewTemplate, renderRequest, renderResponse);
	}
}