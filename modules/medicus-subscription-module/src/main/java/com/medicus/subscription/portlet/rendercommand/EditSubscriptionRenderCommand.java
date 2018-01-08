package com.medicus.subscription.portlet.rendercommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.medicus.common.service.model.Subscription;
import com.medicus.common.service.service.SubscriptionLocalServiceUtil;
import com.medicus.subscription.portlet.constants.MedicusSubscriptionModulePortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name="+MedicusSubscriptionModulePortletKeys.PORTLET_ID,
	        "mvc.command.name=/edit_subscription"
	    },
	    service = MVCRenderCommand.class
)
public class EditSubscriptionRenderCommand implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(EditSubscriptionRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse)  {
		long subscriptionId = ParamUtil.getLong(renderRequest, "subscriptionId");
		if(subscriptionId>0){
			try {
				Subscription subscription = SubscriptionLocalServiceUtil.getSubscription(subscriptionId);
				renderRequest.setAttribute("subscription", subscription);
			} catch (PortalException e) {
				_log.error(e);
				return "/view.jsp";
			}
		}
		return "/edit_subscription.jsp";
	}

}
