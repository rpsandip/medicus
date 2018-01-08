package com.medicus.common.service.service.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
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
	
	public static final String SEARCH_BY_X_AXIS =
			StudentFinder.class.getName() +
		        ".searchByXAxis";

	Log _log = LogFactoryUtil.getLog(StudentFinderImpl.class.getName());
	
	public List<GrooupByEntityBean> groupByStudentGender(long schoolId, long campusId){
		List<GrooupByEntityBean> groupByEntityBeanList = new ArrayList<GrooupByEntityBean>();
		
		 Session session = null;
		    try {
		        session = openSession();
		        
		        String sql = StringPool.BLANK;
		        
		        sql = "select count(gender), gender from Medicus_Student";
		        
		        if(schoolId>0){
		        	sql += " where schoolId="+schoolId;
		        	if(campusId>0){
		        		sql+=StringPool.SPACE+" and campusId="+campusId;
		        	}
		        }
		        
		        sql += " group by gender";
		        
		        _log.info("groupByStudentGender query ->:: " + sql);
		        
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
	
	public List<GrooupByEntityBean> groupByStudentProfession(long schoolId, long campusId){
		List<GrooupByEntityBean> groupByEntityBeanList = new ArrayList<GrooupByEntityBean>();
		
		 Session session = null;
		    try {
		        session = openSession();
		        
		        String sql = "select count(profession), profession from Medicus_Student ";
		        
		        if(schoolId>0){
		        	sql += " where schoolId="+schoolId;
		        	if(campusId>0){
		        		sql+=StringPool.SPACE+"and campusId="+campusId;
		        	}
		        }
		        
		        sql+=" group by profession";
		        
		        _log.info("groupByStudentProfession query ->:: " + sql);
		        
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
	
	public List<GrooupByEntityBean> groupByStudentLanguages(String language, String searchByColumnName, String searchByColumnValue,long schoolId, long campusId){
		List<GrooupByEntityBean> groupByEntityBeanList = new ArrayList<GrooupByEntityBean>();
		
		 Session session = null;
		    try {
		        session = openSession();
		        
		        String sql = StringPool.BLANK;
		        
		        if(Validator.isNotNull(searchByColumnName) && Validator.isNotNull(searchByColumnValue)){
		        	if(!searchByColumnName.equals("primaryLanguage")){
		        		sql = "select count(stundetCampusId) from Medicus_Student  "+
			        		 "where primaryLanguage like '%"+language+"%' and "+
			        		 searchByColumnName + StringPool.EQUAL + StringPool.QUOTE+searchByColumnValue+StringPool.QUOTE;
		        	}else{
		        		sql = "select count(stundetCampusId) from Medicus_Student  "+
				        		 "where primaryLanguage like '%"+language+"%' and "+
				        		 "primaryLanguage like '%"+searchByColumnValue+"%'";
		        	}
		        }else{
		        	sql = "select count(stundetCampusId) from Medicus_Student  "
			        		+ "where primaryLanguage like '%"+language+"%'";
		        }
		        
		        if(schoolId>0){
		        	sql += " and schoolId="+schoolId;
		        	if(campusId>0){
		        		sql+=" and " + StringPool.SPACE+"campusId="+campusId;
		        	}
		        }
		        
		        _log.info("groupByStudentLanguages :: " + sql);
		        
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
	
	
	public List<GrooupByEntityBean> searchByXAxis(String groupByColumnName, String searchColumnName, String searchColumnValue,long schoolId, long campusId){
		List<GrooupByEntityBean> groupByEntityBeanList = new ArrayList<GrooupByEntityBean>();
		
		 Session session = null;
		    try {
		        session = openSession();
		        
		        String sql = StringPool.BLANK;
		        
		        if(!searchColumnName.equals("primaryLanguage")){
			        if(Validator.isNotNull(searchColumnName) && Validator.isNotNull(searchColumnValue)){
			        	sql = "select count("+groupByColumnName+"), "+groupByColumnName+" from Medicus_Student where "+
				        		 searchColumnName + StringPool.EQUAL + StringPool.QUOTE+searchColumnValue+StringPool.QUOTE;
			        	
			        	if(schoolId>0){
				        	sql += " and schoolId="+schoolId;
				        	if(campusId>0){
				        		sql+=" and " + StringPool.SPACE+"campusId="+campusId;
				        	}
				        }
				        	
			        	sql += " group by "+ groupByColumnName;
			        	
			        }else{
			        	sql = "select count("+groupByColumnName+"), "+groupByColumnName+" from Medicus_Student ";
			        
						if(schoolId>0){
							sql += " where schoolId="+schoolId;
							if(campusId>0){
								sql+=" and " + StringPool.SPACE+"campusId="+campusId;
							}
						}
						sql+=	" group by "+ groupByColumnName;
			        }
		        }else{
		        	sql = "select count("+groupByColumnName+"), "+groupByColumnName+" from Medicus_Student where primaryLanguage"
		        			+ " like '%"+searchColumnValue+"%'";
		        	
		        	if(schoolId>0){
			        	sql += " and schoolId="+schoolId;
			        	if(campusId>0){
			        		sql+=" and " + StringPool.SPACE+"campusId="+campusId;
			        	}
			        }
		        	
		        	sql+=  "group by "+groupByColumnName;
		        }
		        
		        _log.info("searchByXAxis :: " + sql);
		        
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
}
