package com.medicus.partner.portlet.portlet.rendercommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.medicus.common.service.bean.PartnerBean;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.partner.portlet.portlet.util.PartnerModuleContstant;

@Component(
	    property = {
	    	"javax.portlet.name="+ PartnerModuleContstant.PORTLET_ID,
	        "mvc.command.name=/edit_partner"
	    },
	    service = MVCRenderCommand.class
)
public class EditPartnerRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(EditPartnerRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long partnerId = ParamUtil.getLong(renderRequest, "partnerId");
		
		if(partnerId>0){
			try {
				Partner partner = PartnerLocalServiceUtil.getPartner(partnerId);
				PartnerBean partnerBean = new PartnerBean(partner);
				renderRequest.setAttribute("partnerBean", partnerBean);
			} catch (PortalException e) {
				_log.error(e.getMessage());
			}
		}
		renderRequest.setAttribute("partnerId", partnerId);
		renderRequest.setAttribute("usStateList", MedicusCommonLocalServiceUtil.getUSStateList());
		return "/partner/edit_partner.jsp";
	}

}
