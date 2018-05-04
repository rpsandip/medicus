package com.medicus.partner.portlet.portlet.actioncommand;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.medicus.common.service.model.Subscription;
import com.medicus.common.service.service.SubscriptionLocalServiceUtil;
import com.medicus.common.service.service.User_SubscriptionLocalServiceUtil;
import com.medicus.partner.portlet.portlet.util.PartnerModuleContstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + PartnerModuleContstant.PORTLET_ID,
	        "mvc.command.name=/subscribe_partner"
	    },
	    service = MVCActionCommand.class
	)
public class SubscrivePartnerActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(SubscrivePartnerActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){
		String[] partnerToSubscribeUserIds = ParamUtil.getParameterValues(actionRequest, "subscribePartner");
		List<Subscription> subList = SubscriptionLocalServiceUtil.getSubscriptions(-1,-1);
		if(subList.size()>0){
			long subId = subList.get(0).getSubscriptionId();
			for(String partnerUserId : partnerToSubscribeUserIds){
				User_SubscriptionLocalServiceUtil.addUserSubscription(Long.parseLong(partnerUserId), StringPool.BLANK, subId);
			}
			SessionMessages.add(actionRequest, "partner-subscribe-success");
		}
		_log.info("partnerToSubscribeUserIds->" + partnerToSubscribeUserIds.length);
	}

}
