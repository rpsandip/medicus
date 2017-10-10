package com.medicus.user.portlet.portlet.rendercommand;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactory;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.medicus.common.service.bean.SchoolUserBean;
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

	Log _log =  LogFactoryUtil.getLog(AddUserRenderCommand.class.getName());
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		List<School> schoolList = SchoolLocalServiceUtil.getSchools(-1, -1);
		renderRequest.setAttribute("schoolList", schoolList);
		return "/user/add_user.jsp";
	}

}
