package com.medicus.graph.portlet.portlet.resourcecommand;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.medicus.graph.portlet.constants.MedicusGraphPortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name=" + MedicusGraphPortletKeys.PORTLET_ID,
	        "mvc.command.name=/check_students"
	    },
	    service = MVCResourceCommand.class
	)
public class TestResource implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		System.out.println("jyyyyy");
		
		return true;
	}

}
