package com.example.portlet.resourcecommand;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
	    property = {
	    	"javax.portlet.name=" + "com_example_portlet_MedicusRegistrationModulemvcportletPortlet",
	        "mvc.command.name=/login-user"
	    },
	    service = MVCResourceCommand.class
	)
public class RegisterUserResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(RegisterUserResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		String uName = ParamUtil.getString(resourceRequest, "usernName");
		String password = ParamUtil.getString(resourceRequest, "pwd");
		
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
	            WebKeys.THEME_DISPLAY);

	        HttpServletRequest request = PortalUtil.getOriginalServletRequest(
	            PortalUtil.getHttpServletRequest(resourceRequest));

	        HttpServletResponse response = PortalUtil.getHttpServletResponse(
	            resourceResponse);

	        String authType = CompanyConstants.AUTH_TYPE_EA;
	        
	        request = PortalUtil.getOriginalServletRequest(request);

	        try {
				AuthenticatedSessionManagerUtil.login(
				    request, response, uName, password, false, authType);
				
				responseObj.put("login", true);
				
			} catch (Exception e) {
				responseObj.put("login", false);
				responseObj.put("message", "Authentication failed. Please enter valid email Address and password");
				_log.error(e);
			}
		
	        try {
				resourceResponse.getWriter().write(responseObj.toString());
			} catch (IOException e) {
				_log.error(e);
			}
			return true;
	}

}
