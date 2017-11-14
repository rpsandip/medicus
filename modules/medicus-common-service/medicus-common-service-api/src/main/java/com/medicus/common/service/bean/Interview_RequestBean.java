package com.medicus.common.service.bean;

import java.util.Date;

import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.model.Student;

public class Interview_RequestBean {
	private long partnerId;
	private long studentId;
	private long campusId;
	private Date createDate; 
	private PartnerBean partnerBean;
	private Student student;
	private Campus campus;
	private int status;

	
	public long getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(long partnerId) {
		this.partnerId = partnerId;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public long getCampusId() {
		return campusId;
	}
	public void setCampusId(long campusId) {
		this.campusId = campusId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Campus getCampus() {
		return campus;
	}
	public void setCampus(Campus campus) {
		this.campus = campus;
	}
	public PartnerBean getPartnerBean() {
		return partnerBean;
	}
	public void setPartnerBean(PartnerBean partnerBean) {
		this.partnerBean = partnerBean;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
