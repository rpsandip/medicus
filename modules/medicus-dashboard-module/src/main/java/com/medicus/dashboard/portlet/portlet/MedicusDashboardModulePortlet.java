package com.medicus.dashboard.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.medicus.common.service.bean.GrooupByEntityBean;
import com.medicus.common.service.model.School;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Medicus Dashboard Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MedicusDashboardModulePortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
	   List<School> schoolListForSchoolAdmin = new ArrayList<School>();
	   MedicusCommonLocalServiceUtil.setUserSchoolIdCampusIdInRequest(renderRequest, schoolListForSchoolAdmin);
		
	   long userCampusId = (Long)renderRequest.getAttribute("userCampusId");
	   long userSchoolId = 	(Long)renderRequest.getAttribute("userSchoolId");
	   
	   // Gender Chart Detail	
       List<GrooupByEntityBean> genderList = StudentLocalServiceUtil.groupByGender(userSchoolId, userCampusId);
	   renderRequest.setAttribute("genderList", genderList);
	   
	   // Profession Chart Detail
	   List<GrooupByEntityBean> professionList = StudentLocalServiceUtil.groupByProfession(userSchoolId, userCampusId);
	   renderRequest.setAttribute("professionList", professionList);
	   
	   // Languge Chart Detail
	   List<GrooupByEntityBean> finalLangList = new ArrayList<GrooupByEntityBean>();
	   
	   List<GrooupByEntityBean> englishStudetList = StudentLocalServiceUtil.groupByLanguages("English", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> spanishStudetList = StudentLocalServiceUtil.groupByLanguages("Spanish", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> frenchStudetList = StudentLocalServiceUtil.groupByLanguages("French", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> chineseMStudetList = StudentLocalServiceUtil.groupByLanguages("Chinese - Mandarin", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> chineseCStudetList = StudentLocalServiceUtil.groupByLanguages("Chinese -Cantonese", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> tagalogStudetList = StudentLocalServiceUtil.groupByLanguages("Tagalog", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> vietnamesetudetList = StudentLocalServiceUtil.groupByLanguages("Vietnamese", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> koreanStudetList = StudentLocalServiceUtil.groupByLanguages("Korean", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> germantudetList = StudentLocalServiceUtil.groupByLanguages("German", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> arabicStudetList = StudentLocalServiceUtil.groupByLanguages("Arabic", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> russianStudetList = StudentLocalServiceUtil.groupByLanguages("Russian", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> italianStudetList = StudentLocalServiceUtil.groupByLanguages("Italian", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> portugueseStudetList = StudentLocalServiceUtil.groupByLanguages("Portuguese", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> hindiStudetList = StudentLocalServiceUtil.groupByLanguages("Hindi", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> polishStudetList = StudentLocalServiceUtil.groupByLanguages("Polish", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> japaneseStudetList = StudentLocalServiceUtil.groupByLanguages("Japanese", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> urduStudetList = StudentLocalServiceUtil.groupByLanguages("Urdu", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> persianStudetList = StudentLocalServiceUtil.groupByLanguages("Persian", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> gujaratiStudetList = StudentLocalServiceUtil.groupByLanguages("Gujarati", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> greekStudetList = StudentLocalServiceUtil.groupByLanguages("Greek", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> bengaliStudetList = StudentLocalServiceUtil.groupByLanguages("Bengali", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> panjabiStudetList = StudentLocalServiceUtil.groupByLanguages("Panjabi", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> teluguStudetList = StudentLocalServiceUtil.groupByLanguages("Telugu", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> armenianStudetList = StudentLocalServiceUtil.groupByLanguages("Armenian", null, null,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> hmongStudetList = StudentLocalServiceUtil.groupByLanguages("Hmong", null, null,userSchoolId, userCampusId);
	   
	   
	   
	   if(englishStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(englishStudetList.get(0).getCount(), englishStudetList.get(0).getFieldName()));
	   }
	   if(spanishStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(spanishStudetList.get(0).getCount(), spanishStudetList.get(0).getFieldName()));
	   }
	   if(koreanStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(koreanStudetList.get(0).getCount(), koreanStudetList.get(0).getFieldName()));
	   }
	   if(frenchStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(frenchStudetList.get(0).getCount(), frenchStudetList.get(0).getFieldName()));
	   }
	   if(chineseMStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(chineseMStudetList.get(0).getCount(), chineseMStudetList.get(0).getFieldName()));
	   }
	   if(chineseCStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(chineseCStudetList.get(0).getCount(), chineseCStudetList.get(0).getFieldName()));
	   }
	   if(tagalogStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(tagalogStudetList.get(0).getCount(), tagalogStudetList.get(0).getFieldName()));
	   }
	   if(vietnamesetudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(vietnamesetudetList.get(0).getCount(), vietnamesetudetList.get(0).getFieldName()));
	   }
	   if(germantudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(germantudetList.get(0).getCount(), germantudetList.get(0).getFieldName()));
	   }
	   if(russianStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(russianStudetList.get(0).getCount(), russianStudetList.get(0).getFieldName()));
	   }
	   if(italianStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(italianStudetList.get(0).getCount(), italianStudetList.get(0).getFieldName()));
	   }
	   if(arabicStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(arabicStudetList.get(0).getCount(), arabicStudetList.get(0).getFieldName()));
	   }
	   if(portugueseStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(portugueseStudetList.get(0).getCount(), portugueseStudetList.get(0).getFieldName()));
	   }
	   if(hindiStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(hindiStudetList.get(0).getCount(), hindiStudetList.get(0).getFieldName()));
	   }
	   if(polishStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(polishStudetList.get(0).getCount(), polishStudetList.get(0).getFieldName()));
	   }
	   if(japaneseStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(japaneseStudetList.get(0).getCount(), japaneseStudetList.get(0).getFieldName()));
	   }
	   if(urduStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(urduStudetList.get(0).getCount(), urduStudetList.get(0).getFieldName()));
	   }
	   if(persianStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(persianStudetList.get(0).getCount(), persianStudetList.get(0).getFieldName()));
	   }
	   if(gujaratiStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(gujaratiStudetList.get(0).getCount(), gujaratiStudetList.get(0).getFieldName()));
	   }
	   if(greekStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(greekStudetList.get(0).getCount(), greekStudetList.get(0).getFieldName()));
	   }
	   if(bengaliStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(bengaliStudetList.get(0).getCount(), bengaliStudetList.get(0).getFieldName()));
	   }
	   if(panjabiStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(panjabiStudetList.get(0).getCount(), panjabiStudetList.get(0).getFieldName()));
	   }
	   if(teluguStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(teluguStudetList.get(0).getCount(), teluguStudetList.get(0).getFieldName()));
	   }
	   if(armenianStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(armenianStudetList.get(0).getCount(), armenianStudetList.get(0).getFieldName()));
	   }
	   if(hmongStudetList.get(0).getCount()>0){
		   finalLangList.add(new GrooupByEntityBean(hmongStudetList.get(0).getCount(), hmongStudetList.get(0).getFieldName()));
	   }
	   
	   renderRequest.setAttribute("finalLangList", finalLangList);
	   include(viewTemplate, renderRequest, renderResponse);
	}
}