package com.medicus.graph.portlet.portlet.resourcecommand;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.medicus.common.service.bean.GrooupByEntityBean;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.graph.portlet.constants.MedicusGraphPortletKeys;

@Component(
	    property = {
	    	"javax.portlet.name=" + MedicusGraphPortletKeys.PORTLET_ID,
	        "mvc.command.name=/get_graph_detail"
	    },
	    service = MVCResourceCommand.class
	)
public class GetGraphDetailResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(GetGraphDetailResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		String searchByColumnName = ParamUtil.getString(resourceRequest, "searchByColumnName");
		String searchByColumnValue = ParamUtil.getString(resourceRequest, "searchByColumnValue");
		String groupByColumnName = ParamUtil.getString(resourceRequest, "groupByColumnName");
		
		long userSchoolId = ParamUtil.getLong(resourceRequest, "userSchoolId");
		long userCampusId = ParamUtil.getLong(resourceRequest, "userCampusId");
		
		List<Long> countList = new ArrayList<Long>();
		List<String> labelList = new ArrayList<String>();
		List<GrooupByEntityBean> groupEntityBeanList = new ArrayList<GrooupByEntityBean>();
		if(!groupByColumnName.equals("languages")){
			 groupEntityBeanList = StudentLocalServiceUtil.searchByXAxis(groupByColumnName, searchByColumnName, searchByColumnValue, userSchoolId, userCampusId);
		}else{
			groupEntityBeanList =	groupByLanguages(searchByColumnName, searchByColumnValue, userSchoolId, userCampusId);
		}

		for(GrooupByEntityBean groupEntityBean : groupEntityBeanList){
			countList.add(groupEntityBean.getCount());
			labelList.add(groupEntityBean.getFieldName());
		}
		
		responseObj.put("countList", countList);
		responseObj.put("labelList", labelList);
		
		 try {
				resourceResponse.getWriter().write(responseObj.toString());
			} catch (IOException e) {
				_log.error(e.getMessage(), e);
		 }
		 
		 
		return true;
	}
	
	private List<GrooupByEntityBean> groupByLanguages(String searchByColumnName, String searchByColumnValue, long userSchoolId,long  userCampusId){
	   
		List<GrooupByEntityBean> finalLangList = new ArrayList<GrooupByEntityBean>();
		
		List<GrooupByEntityBean> englishStudetList = StudentLocalServiceUtil.groupByLanguages("English", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> spanishStudetList = StudentLocalServiceUtil.groupByLanguages("Spanish", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> frenchStudetList = StudentLocalServiceUtil.groupByLanguages("French", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> chineseMStudetList = StudentLocalServiceUtil.groupByLanguages("Chinese - Mandarin", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> chineseCStudetList = StudentLocalServiceUtil.groupByLanguages("Chinese -Cantonese", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> tagalogStudetList = StudentLocalServiceUtil.groupByLanguages("Tagalog", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> vietnamesetudetList = StudentLocalServiceUtil.groupByLanguages("Vietnamese", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> koreanStudetList = StudentLocalServiceUtil.groupByLanguages("Korean", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> germantudetList = StudentLocalServiceUtil.groupByLanguages("German", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> arabicStudetList = StudentLocalServiceUtil.groupByLanguages("Arabic", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> russianStudetList = StudentLocalServiceUtil.groupByLanguages("Russian", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> italianStudetList = StudentLocalServiceUtil.groupByLanguages("Italian", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> portugueseStudetList = StudentLocalServiceUtil.groupByLanguages("Portuguese", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> hindiStudetList = StudentLocalServiceUtil.groupByLanguages("Hindi", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> polishStudetList = StudentLocalServiceUtil.groupByLanguages("Polish", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> japaneseStudetList = StudentLocalServiceUtil.groupByLanguages("Japanese", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> urduStudetList = StudentLocalServiceUtil.groupByLanguages("Urdu", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> persianStudetList = StudentLocalServiceUtil.groupByLanguages("Persian", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> gujaratiStudetList = StudentLocalServiceUtil.groupByLanguages("Gujarati", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> greekStudetList = StudentLocalServiceUtil.groupByLanguages("Greek", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> bengaliStudetList = StudentLocalServiceUtil.groupByLanguages("Bengali", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> panjabiStudetList = StudentLocalServiceUtil.groupByLanguages("Panjabi", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> teluguStudetList = StudentLocalServiceUtil.groupByLanguages("Telugu", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> armenianStudetList = StudentLocalServiceUtil.groupByLanguages("Armenian", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   List<GrooupByEntityBean> hmongStudetList = StudentLocalServiceUtil.groupByLanguages("Hmong", searchByColumnName, searchByColumnValue,userSchoolId, userCampusId);
	   
	   
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
	   
	   return finalLangList;
	}

}
