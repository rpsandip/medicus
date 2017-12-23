package com.medicus.user.portlet.portlet.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.medicus.user.portlet.portlet.util.UserModuleConstant;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + UserModuleConstant.PORTLET_ID,
	        "mvc.command.name=/delete_user"
	    },
	    service = MVCActionCommand.class
	)
public class DeleteUserActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(DeleteUserActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		long userId = ParamUtil.getLong(actionRequest, "userId");
		if(userId>0){
			try {
				UserLocalServiceUtil.updateStatus(userId, WorkflowConstants.STATUS_INACTIVE);
				SessionMessages.add(actionRequest, "user-delete-success");
			} catch (PortalException e) {
				SessionErrors.add(actionRequest, "user-delete-error");
				_log.error(e);
			}
		}else{
			SessionErrors.add(actionRequest, "user-delete-error");
		}
		
	}

}
