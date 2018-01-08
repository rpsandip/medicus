package com.medicus.employer.portlet.portlet.rendercommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.medicus.common.service.model.Employer;
import com.medicus.common.service.service.EmployerLocalServiceUtil;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.employer.portlet.portlet.util.EmployerPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+EmployerPortletConstant.PORTLET_ID,
	        "mvc.command.name=/add_employer"
	    },
	    service = MVCRenderCommand.class
)
public class AddEmployeRenderCommand  implements MVCRenderCommand{

	Log _log = LogFactoryUtil.getLog(AddEmployeRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		long employerId = ParamUtil.getLong(renderRequest, "employerId");
		if(employerId>0){
			try {
				Employer employer = EmployerLocalServiceUtil.getEmployer(employerId);
				renderRequest.setAttribute("employer", employer);
			} catch (PortalException e) {
				_log.error(e);
				SessionMessages.add(renderRequest, "employer-update-error");
				return "/view.jsp";
			}
		}
		renderRequest.setAttribute("usStateList", MedicusCommonLocalServiceUtil.getUSStateList());
		return "/employer/add_employer.jsp";
	}

}
