package com.medicus.partner.portlet.portlet.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.partner.portlet.portlet.util.PartnerModuleContstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + PartnerModuleContstant.PORTLET_ID,
	        "mvc.command.name=/active_partner"
	    },
	    service = MVCActionCommand.class
	)
public class ActivatePartnerActionCommand  extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(ActivatePartnerActionCommand.class.getName());

	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long partnerId = ParamUtil.getLong(actionRequest, "activatepartnerId");
		
		if(partnerId>0){
			Partner partner;
			try {
				partner = PartnerLocalServiceUtil.getPartner(partnerId);
				User user = UserLocalServiceUtil.getUser(partner.getUserId());
				UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_APPROVED);
				SessionMessages.add(actionRequest, "partner-activate-success");
			} catch (PortalException e) {
				SessionErrors.add(actionRequest, "partner-activate-error");
				_log.error(e);
			}
		}else{
			SessionErrors.add(actionRequest, "partner-activate-error");
		}
	}

}
