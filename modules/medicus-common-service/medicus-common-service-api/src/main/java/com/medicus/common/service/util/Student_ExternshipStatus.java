package com.medicus.common.service.util;

public enum Student_ExternshipStatus {
	
	AVAILABLE(0,"Available"),IN_PROGRESS(1,"In Progress"),COMPLETED(2,"Completed");
	
	private int value;
	private String label;
	
	private Student_ExternshipStatus(int value,String label){
		this.value = value;
		this.label = label;
	}

	public  static Student_ExternshipStatus findByValue(int value){
		Student_ExternshipStatus externshipStatus=null;
		for(Student_ExternshipStatus status : Student_ExternshipStatus.values()){
			if(status.value==value){
				return status;
			}
		}
		return externshipStatus;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
