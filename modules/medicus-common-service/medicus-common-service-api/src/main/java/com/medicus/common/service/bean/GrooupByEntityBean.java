package com.medicus.common.service.bean;

public class GrooupByEntityBean {
	private long count;
	private String fieldName;
	
	public GrooupByEntityBean(long count, String fieldName){
		this.count = count;
		this.fieldName = fieldName;
	}
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	
	
}
