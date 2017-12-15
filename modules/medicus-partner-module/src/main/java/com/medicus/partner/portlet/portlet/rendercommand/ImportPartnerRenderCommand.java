package com.medicus.partner.portlet.portlet.rendercommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.medicus.common.service.model.Partner;
import com.medicus.partner.portlet.portlet.util.PartnerModuleContstant;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

@Component(
	    property = {
	    	"javax.portlet.name="+ PartnerModuleContstant.PORTLET_ID,
	        "mvc.command.name=/import_partner"
	    },
	    service = MVCRenderCommand.class
)
public class ImportPartnerRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		boolean isImported = ParamUtil.getBoolean(renderRequest, "isImported");
		if(isImported){
			renderRequest.setAttribute("totalPartnerCount", ParamUtil.getString(renderRequest, "totalPartnerCount"));
			renderRequest.setAttribute("successImportedPartnerCount", ParamUtil.getString(renderRequest, "successImportedPartnerCount"));
			renderRequest.setAttribute("UnsuccessImportedPartnerCount", ParamUtil.getString(renderRequest, "UnsuccessImportedPartnerCount"));
			renderRequest.setAttribute("isImported", isImported);
			
			PortalCache portalCache =   MultiVMPoolUtil.getCache(Partner.class.getName());
			List<String> unsuccessfullPartnerList = (List<String>)portalCache.get("unsuccessfullPartnerList");
			renderRequest.setAttribute("unsuccessfullPartnerList", unsuccessfullPartnerList);
			portalCache.remove("unsuccessfullPartnerList");
		}
		return "/partner/import_partner.jsp";
	}

}
