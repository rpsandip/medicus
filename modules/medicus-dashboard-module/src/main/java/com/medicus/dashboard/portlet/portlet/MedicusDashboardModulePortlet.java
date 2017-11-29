package com.medicus.dashboard.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.medicus.common.service.bean.GrooupByEntityBean;
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
		
	   // TODO : Need to make role base and school/campus specific search.	
		
	   // Gender Chart Detail	
       List<GrooupByEntityBean> genderList = StudentLocalServiceUtil.groupByGender();
	   renderRequest.setAttribute("genderList", genderList);
	   
	   // Profession Chart Detail
	   List<GrooupByEntityBean> professionList = StudentLocalServiceUtil.groupByProfession();
	   renderRequest.setAttribute("professionList", professionList);
	   
	   // Languge Chart Detail
	   List<GrooupByEntityBean> finalLangList = new ArrayList<GrooupByEntityBean>();
	   
	   List<GrooupByEntityBean> englishStudetList = StudentLocalServiceUtil.groupByLanguages("English");
	   List<GrooupByEntityBean> spanishStudetList = StudentLocalServiceUtil.groupByLanguages("Spanish");
	   List<GrooupByEntityBean> frenchStudetList = StudentLocalServiceUtil.groupByLanguages("French");
	   List<GrooupByEntityBean> chineseMStudetList = StudentLocalServiceUtil.groupByLanguages("Chinese - Mandarin");
	   List<GrooupByEntityBean> chineseCStudetList = StudentLocalServiceUtil.groupByLanguages("Chinese -Cantonese");
	   List<GrooupByEntityBean> tagalogStudetList = StudentLocalServiceUtil.groupByLanguages("Tagalog");
	   List<GrooupByEntityBean> vietnamesetudetList = StudentLocalServiceUtil.groupByLanguages("Vietnamese");
	   List<GrooupByEntityBean> koreanStudetList = StudentLocalServiceUtil.groupByLanguages("Korean");
	   List<GrooupByEntityBean> germantudetList = StudentLocalServiceUtil.groupByLanguages("German");
	   List<GrooupByEntityBean> arabicStudetList = StudentLocalServiceUtil.groupByLanguages("Arabic");
	   List<GrooupByEntityBean> russianStudetList = StudentLocalServiceUtil.groupByLanguages("Russian");
	   List<GrooupByEntityBean> italianStudetList = StudentLocalServiceUtil.groupByLanguages("Italian");
	   List<GrooupByEntityBean> portugueseStudetList = StudentLocalServiceUtil.groupByLanguages("Portuguese");
	   List<GrooupByEntityBean> hindiStudetList = StudentLocalServiceUtil.groupByLanguages("Hindi");
	   List<GrooupByEntityBean> polishStudetList = StudentLocalServiceUtil.groupByLanguages("Polish");
	   List<GrooupByEntityBean> japaneseStudetList = StudentLocalServiceUtil.groupByLanguages("Japanese");
	   List<GrooupByEntityBean> urduStudetList = StudentLocalServiceUtil.groupByLanguages("Urdu");
	   List<GrooupByEntityBean> persianStudetList = StudentLocalServiceUtil.groupByLanguages("Persian");
	   List<GrooupByEntityBean> gujaratiStudetList = StudentLocalServiceUtil.groupByLanguages("Gujarati");
	   List<GrooupByEntityBean> greekStudetList = StudentLocalServiceUtil.groupByLanguages("Greek");
	   List<GrooupByEntityBean> bengaliStudetList = StudentLocalServiceUtil.groupByLanguages("Bengali");
	   List<GrooupByEntityBean> panjabiStudetList = StudentLocalServiceUtil.groupByLanguages("Panjabi");
	   List<GrooupByEntityBean> teluguStudetList = StudentLocalServiceUtil.groupByLanguages("Telugu");
	   List<GrooupByEntityBean> armenianStudetList = StudentLocalServiceUtil.groupByLanguages("Armenian");
	   List<GrooupByEntityBean> hmongStudetList = StudentLocalServiceUtil.groupByLanguages("Hmong");
	   
	   
	   
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