package com.medicus.student.portlet.portlet.actioncommand;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.student.portlet.portlet.StudentPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + StudentPortletConstant.PORTLET_ID,
	        "mvc.command.name=/delete_student"
	    },
	    service = MVCActionCommand.class
	)
public class DeleteStudentActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(DeleteStudentActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long studentId = ParamUtil.getLong(actionRequest, "deletestudentId");
		boolean isDeleted = StudentLocalServiceUtil.deleteStudentDetail(studentId);
		if(isDeleted){
			SessionMessages.add(actionRequest, "student-delete-success");
		}else{
			SessionErrors.add(actionRequest, "student-delete-err");
		}
	}

}
