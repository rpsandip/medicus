package com.medicus.user.portlet.portlet.rendercommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.medicus.common.service.model.School;
import com.medicus.common.service.service.SchoolLocalServiceUtil;
import com.medicus.user.portlet.portlet.util.UserModuleConstant;

@Component(
	    property = {
	    	"javax.portlet.name="+ UserModuleConstant.PORTLET_ID,
	        "mvc.command.name=/add_user"
	    },
	    service = MVCRenderCommand.class
)
public class AddUserRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		List<School> schoolList = SchoolLocalServiceUtil.getSchools(-1, -1);
		renderRequest.setAttribute("schoolList", schoolList);
		return "/user/add_user.jsp";
	}

}
