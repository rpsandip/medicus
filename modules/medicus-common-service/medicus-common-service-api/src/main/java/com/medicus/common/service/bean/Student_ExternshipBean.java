package com.medicus.common.service.bean;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.medicus.common.service.model.Employer;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.model.Student_Externship;
import com.medicus.common.service.service.EmployerLocalServiceUtil;
import com.medicus.common.service.service.PartnerLocalServiceUtil;

public class Student_ExternshipBean {
	
	Log _log = LogFactoryUtil.getLog(Student_ExternshipBean.class.getName());
	
	private long studentExternshipId;
	private long studentId;
	private long employerId;
	private long partnerId;
	private Date startDate;
	private Date endDate;
	private int noOfHoursPerWeek;
	private Date midPointReview;
	private String midPointReviewComment;
	private Date finalReview;
	private String finalReviewComment;
	private PartnerBean partnerBean;
	private EmployerBean employerBean;
	private int status;
	private String shiftDesc;
	
	public Student_ExternshipBean(Student_Externship studentExternship){
		if(Validator.isNotNull(studentExternship)){
			this.studentExternshipId = studentExternship.getStudentExternshipId();
			this.studentId =  studentExternship.getStudentId();
			this.partnerId = studentExternship.getPartnerId();
			this.employerId = studentExternship.getEmployerId();
			this.startDate = studentExternship.getStartDate();
			this.endDate = studentExternship.getEndDate();
			this.noOfHoursPerWeek = studentExternship.getNoOfHoursPerWeek();
			this.midPointReview = studentExternship.getMidPointReview();
			this.midPointReviewComment = studentExternship.getFinalReviewComment();
			this.finalReview = studentExternship.getFinalReview();
			this.finalReviewComment = studentExternship.getFinalReviewComment();
			this.status = studentExternship.getStatus();
			this.shiftDesc = studentExternship.getShiftDesc();
			
			if(this.partnerId>0){
				try {
					Partner partner = PartnerLocalServiceUtil.getPartner(this.partnerId);
					PartnerBean partnerBean = new PartnerBean(partner);
					this.partnerBean = partnerBean;
				} catch (PortalException e) {
					_log.error(e.getMessage());
				}
				
			}
			if(this.employerId>0){
				try {
					Employer employer = EmployerLocalServiceUtil.getEmployer(this.employerId);
					EmployerBean employerBean = new EmployerBean(employer);
					this.employerBean = employerBean;
				} catch (PortalException e) {
					_log.error(e.getMessage());
				}
			}
		}
	}
	
	
	public long getStudentExternshipId() {
		return studentExternshipId;
	}
	public void setStudentExternshipId(long studentExternshipId) {
		this.studentExternshipId = studentExternshipId;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getNoOfHoursPerWeek() {
		return noOfHoursPerWeek;
	}
	public void setNoOfHoursPerWeek(int noOfHoursPerWeek) {
		this.noOfHoursPerWeek = noOfHoursPerWeek;
	}
	public Date getMidPointReview() {
		return midPointReview;
	}
	public void setMidPointReview(Date midPointReview) {
		this.midPointReview = midPointReview;
	}
	public String getMidPointReviewComment() {
		return midPointReviewComment;
	}
	public void setMidPointReviewComment(String midPointReviewComment) {
		this.midPointReviewComment = midPointReviewComment;
	}
	public Date getFinalReview() {
		return finalReview;
	}
	public void setFinalReview(Date finalReview) {
		this.finalReview = finalReview;
	}
	public String getFinalReviewComment() {
		return finalReviewComment;
	}
	public void setFinalReviewComment(String finalReviewComment) {
		this.finalReviewComment = finalReviewComment;
	}
	public long getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(long partnerId) {
		this.partnerId = partnerId;
	}
	public PartnerBean getPartnerBean() {
		return partnerBean;
	}
	public void setPartnerBean(PartnerBean partnerBean) {
		this.partnerBean = partnerBean;
	}
	public long getEmployerId() {
		return employerId;
	}
	public void setEmployerId(long employerId) {
		this.employerId = employerId;
	}
	public EmployerBean getEmployerBean() {
		return employerBean;
	}
	public void setEmployerBean(EmployerBean employerBean) {
		this.employerBean = employerBean;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}


	public String getShiftDesc() {
		return shiftDesc;
	}


	public void setShiftDesc(String shiftDesc) {
		this.shiftDesc = shiftDesc;
	}
	
	
	
}
