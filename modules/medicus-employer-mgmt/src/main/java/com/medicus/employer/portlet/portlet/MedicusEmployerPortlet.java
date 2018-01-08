package com.medicus.employer.portlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.IndexSearcherHelperUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchEngineHelper;
import com.liferay.portal.kernel.search.generic.BooleanQueryImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.medicus.common.service.bean.EmployerBean;
import com.medicus.common.service.model.Employer;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.EmployerLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.medicus",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Medicus Employer Portlet",
		"javax.portlet.init-param.template-path=/",
		"com.liferay.portlet.action-url-redirect=true",
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
		
		try{
		///SearchContext searchContext = new SearchContext();
	    //searchContext.setSearchEngineId(SearchEngineHelper.SYSTEM_ENGINE_ID);
	    //searchContext.setLike(true);
	    
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
	    SearchContext searchContext = SearchContextFactory.getInstance(request);
	    
	    
	    BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
	    
	    searchQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, Student.class.getName());
	    

	   
	    BooleanQuery lastNameQuery = new BooleanQueryImpl();
	    
	    lastNameQuery.addTerm("lastName", "Patel");

        BooleanQuery firsNameQuery = new BooleanQueryImpl();
	    
        firsNameQuery.addTerm("firstName", "Patel");
        
        firsNameQuery.add(lastNameQuery, BooleanClauseOccur.SHOULD);

	    searchQuery.add(firsNameQuery, BooleanClauseOccur.MUST);
	    
	    
	    //searchQuery.addRequiredTerm("lastName", "Patel", true);
	    
	    //searchQuery.addRequiredTerm("firstName", "Patel", true);
	    
	    
	    //searchQuery.addTerm(Field.ANY, "Patel");
	    
	    
	    //searchQuery.addRequiredTerm(Field.CONTENT, "Gandhinagar", true);
	    
	    Hits hits = IndexSearcherHelperUtil.search(searchContext, searchQuery);
	   
	    System.out.println("hits lenght ->" + hits.getLength());
	    
	    Document[] documents = hits.getDocs();
	    
	    System.out.println("docuements ->" + documents.length);
	    
	    for(Document document : documents){
	    	System.out.println("firstName ->" + GetterUtil.getString(document.get("firstName")));
	    }
	    
		}catch(Exception e){
			e.printStackTrace();
		}
		
		include(viewTemplate, renderRequest, renderResponse);
	}
}