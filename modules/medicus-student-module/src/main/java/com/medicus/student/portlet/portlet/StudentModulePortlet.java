package com.medicus.student.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.medicus.common.service.bean.StudentBean;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.StudentLocalServiceUtil;

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
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=medicus-student-module Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"com.liferay.portlet.action-url-redirect=true",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class StudentModulePortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		//TODO : Need to remove this logic and make ajaxable
		List<Student> studentList = StudentLocalServiceUtil.getStudents(-1, -1);
		List<StudentBean> studentBeanList = new ArrayList<StudentBean>();
		for(Student student : studentList){
			StudentBean studentBean = new StudentBean(student);
			studentBeanList.add(studentBean);
		}
		renderRequest.setAttribute("studentBeanList", studentBeanList);
		include(viewTemplate, renderRequest, renderResponse);
	}
}