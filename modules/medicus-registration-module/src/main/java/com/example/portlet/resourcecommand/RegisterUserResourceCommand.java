package com.example.portlet.resourcecommand;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

@Component(
	    property = {
	    	"javax.portlet.name=" + "com_example_portlet_MedicusRegistrationModulemvcportletPortlet",
	        "mvc.command.name=/register-user"
	    },
	    service = MVCResourceCommand.class
	)
public class RegisterUserResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(RegisterUserResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		_log.info("ajax callleddd");
		
		return true;
	}

}
