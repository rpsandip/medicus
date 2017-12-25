package com.medicus.subscription.portlet.actioncommand;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.model.Subscription;
import com.medicus.common.service.service.SubscriptionLocalServiceUtil;
import com.medicus.subscription.portlet.constants.MedicusSubscriptionModulePortletKeys;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + MedicusSubscriptionModulePortletKeys.PORTLET_ID,
	        "mvc.command.name=/edit_subscription"
	    },
	    service = MVCActionCommand.class
	)
public class EditSubscriptionActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(EditSubscriptionActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){
		
		long subscriptionId = ParamUtil.getLong(actionRequest, "subscriptionId");
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		if(subscriptionId>0){
			Subscription subscription;
			try {
				subscription = SubscriptionLocalServiceUtil.getSubscription(subscriptionId);
				
				double price = ParamUtil.getDouble(actionRequest, "price");
				int noOfStudents = ParamUtil.getInteger(actionRequest, "noOfStudents");
				
				subscription.setPrice(price);
				subscription.setNoOfStudents(noOfStudents);
				subscription.setModifiedBy(themeDisplay.getUserId());
				subscription.setModifiedDate(new Date());
				
				subscription  = SubscriptionLocalServiceUtil.updateSubscription(subscription);
				
				SessionMessages.add(actionRequest, "subscription-update-success");
			} catch (PortalException e) {
				_log.error(e);
				actionResponse.setRenderParameter("mvcRenderCommandName", "/edit_subscription");
				actionResponse.setRenderParameter("subcriptionId", String.valueOf(subscriptionId));
				SessionErrors.add(actionRequest, "subscription-update-error");
			}
			
			
		}else{
			actionResponse.setRenderParameter("mvcRenderCommandName", "/edit_subscription");
			actionResponse.setRenderParameter("subcriptionId", String.valueOf(subscriptionId));
			SessionErrors.add(actionRequest, "subscription-update-error");
		}
		
	}

}
