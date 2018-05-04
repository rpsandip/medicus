package com.medicus.partner.portlet.portlet.rendercommand;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.medicus.common.service.bean.PartnerBean;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.partner.portlet.portlet.util.PartnerModuleContstant;

@Component(
	    property = {
	    	"javax.portlet.name="+ PartnerModuleContstant.PORTLET_ID,
	        "mvc.command.name=/subscribe_partners"
	    },
	    service = MVCRenderCommand.class
)
public class SubscribePartnersRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse)  {

		List<Partner> unsubscribePartnerList = PartnerLocalServiceUtil.getUnSubscribePartners();
		List<PartnerBean> unsubscribePartnerBeanList = new ArrayList<PartnerBean>();
		for(Partner partner : unsubscribePartnerList){
			PartnerBean partnerBean = new PartnerBean(partner);
			unsubscribePartnerBeanList.add(partnerBean);
		}
		
		renderRequest.setAttribute("unsubscribePartnerBeanList", unsubscribePartnerBeanList);
		
		return "/partner/subscribe_partner.jsp";
	}

}
