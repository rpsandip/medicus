package com.medicus.employer.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.medicus.common.service.bean.EmployerBean;
import com.medicus.common.service.model.Employer;
import com.medicus.common.service.service.EmployerLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.medicus",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Medicus Employer Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MedicusEmployerPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		List<Employer> employerList = EmployerLocalServiceUtil.getEmployers(-1, -1);
		List<EmployerBean> employerBeanList = new ArrayList<EmployerBean>();
		for(Employer employer : employerList){
			EmployerBean employerBean = new EmployerBean(employer);
			employerBeanList.add(employerBean);
		}
		renderRequest.setAttribute("employerBeanList", employerBeanList);
		include(viewTemplate, renderRequest, renderResponse);
	}
}