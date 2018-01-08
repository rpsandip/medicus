package com.medicus.common.service.util;

public enum Interview_RequestStatus {
	PENDING(0,"Pending"),APPROVED(1,"Approved"),REJECTED(2,"Rejected");
	private int value;
	private String label;
	
	private Interview_RequestStatus(int value, String label){
		this.value = value;
		this.label = label;
	}
	
	public  static Interview_RequestStatus findByValue(int value){
		Interview_RequestStatus interviewRequest=null;
		for(Interview_RequestStatus interviewRequestStatus : Interview_RequestStatus.values()){
			if(interviewRequestStatus.value==value){
				return interviewRequestStatus;
			}
		}
		return interviewRequest;
	}
	
	
	public void setValue(int value) {
        this.value = value;
    }
	public int getValue() {
        return value;
    }

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
