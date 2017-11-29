package com.medicus.common.service.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.medicus.common.service.bean.GrooupByEntityBean;
import com.medicus.common.service.service.persistence.StudentFinder;

public class StudentFinderImpl extends StudentFinderBaseImpl implements StudentFinder{
	public static final String GROUP_BY_STUDENT_GENDER =
			StudentFinder.class.getName() +
		        ".groupByStudentGender";
	
	public static final String GROUP_BY_STUDENT_PROFFESSIONS =
			StudentFinder.class.getName() +
		        ".groupByStudentProfession";
	
	public static final String GROUP_BY_STUDENT_LANGUAGES =
			StudentFinder.class.getName() +
		        ".groupByStudentLanguages";
	
	Log _log = LogFactoryUtil.getLog(StudentFinderImpl.class.getName());
	
	public List<GrooupByEntityBean> groupByStudentGender(){
		List<GrooupByEntityBean> groupByEntityBeanList = new ArrayList<GrooupByEntityBean>();
		
		 Session session = null;
		    try {
		        session = openSession();
		        
		        String sql = "select count(gender), gender from Medicus_Student group by gender";
		        
		        SQLQuery q = session.createSQLQuery(sql);
		        
		        List<Object> result = (List<Object>) QueryUtil.list(q, getDialect(), -1, -1);
		        
		        result.forEach(row -> {
		        	
		        	Object[] columns = (Object[]) row;
		        	long count = 0;
		        	String fieldName = StringPool.BLANK;
		        	for(int i=0;i<columns.length;i++){
		        		count  = GetterUtil.getLong(columns[0],0);
		        		fieldName = GetterUtil.getString(columns[1], StringPool.BLANK);
		        	}
	        		GrooupByEntityBean groupByentityBean = new GrooupByEntityBean(count, fieldName);
	        		groupByEntityBeanList.add(groupByentityBean);
		        	
		        });
		        
		    }catch (Exception e) {
		        try {
		            throw new SystemException(e);
		        }
		        catch (SystemException se) {
		        	_log.error(se);
		        }
		    }
		    finally {
		        closeSession(session);
		    }
		  return groupByEntityBeanList;  
	}
	
	public List<GrooupByEntityBean> groupByStudentProfession(){
		List<GrooupByEntityBean> groupByEntityBeanList = new ArrayList<GrooupByEntityBean>();
		
		 Session session = null;
		    try {
		        session = openSession();
		        
		        String sql = "select count(profession), profession from Medicus_Student group by profession";
		        
		        SQLQuery q = session.createSQLQuery(sql);
		        
		        List<Object> result = (List<Object>) QueryUtil.list(q, getDialect(), -1, -1);
		        
		        result.forEach(row -> {
		        	
		        	Object[] columns = (Object[]) row;
		        	long count = 0;
		        	String fieldName = StringPool.BLANK;
		        	
		        	for(int i=0;i<columns.length;i++){
		        		count = GetterUtil.getLong(columns[0],0);
		        		fieldName = GetterUtil.getString(columns[1], StringPool.BLANK);
		        	}

		        	GrooupByEntityBean groupByentityBean = new GrooupByEntityBean(count, fieldName);
	        		groupByEntityBeanList.add(groupByentityBean);
		        });
		        
		    }catch (Exception e) {
		        try {
		            throw new SystemException(e);
		        }
		        catch (SystemException se) {
		        	_log.error(se);
		        }
		    }
		    finally {
		        closeSession(session);
		    }
		  return groupByEntityBeanList;  
	}
	
	public List<GrooupByEntityBean> groupByStudentLanguages(String language){
		List<GrooupByEntityBean> groupByEntityBeanList = new ArrayList<GrooupByEntityBean>();
		
		 Session session = null;
		    try {
		        session = openSession();
		        
		        String sql = "select count(stundetCampusId) from Medicus_Student  "
		        		+ "where primaryLanguage like '%"+language+"%';";
		        
		        SQLQuery q = session.createSQLQuery(sql);
		        
		        List<Object> result = (List<Object>) QueryUtil.list(q, getDialect(), -1, -1);
		        
		        for(Object row : result){
		        	long count = GetterUtil.getLong(row,0);
		        	
		        	GrooupByEntityBean groupByentityBean = new GrooupByEntityBean(count, language);
	        		groupByEntityBeanList.add(groupByentityBean);
		        }
		       
		        
		    }catch (Exception e) {
		        try {
		            throw new SystemException(e);
		        }
		        catch (SystemException se) {
		        	_log.error(se);
		        }
		    }
		    finally {
		        closeSession(session);
		    }
		  return groupByEntityBeanList;  
	}
}
