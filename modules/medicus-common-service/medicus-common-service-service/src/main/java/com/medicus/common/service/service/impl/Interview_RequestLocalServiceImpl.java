/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.medicus.common.service.service.impl;

import aQute.bnd.annotation.ProviderType;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.medicus.common.service.bean.PartnerBean;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.Interview_Request;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.Interview_RequestLocalServiceUtil;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.common.service.service.base.Interview_RequestLocalServiceBaseImpl;
import com.medicus.common.service.service.persistence.Interview_RequestPK;
import com.medicus.common.service.util.Interview_RequestStatus;
import com.medicus.common.service.util.MedicusConstant;

/**
 * The implementation of the interview_ request local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.medicus.common.service.service.Interview_RequestLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sandip.patel
 * @see Interview_RequestLocalServiceBaseImpl
 * @see com.medicus.common.service.service.Interview_RequestLocalServiceUtil
 */
@ProviderType
public class Interview_RequestLocalServiceImpl
	extends Interview_RequestLocalServiceBaseImpl {
	
	Log _log = LogFactoryUtil.getLog(Interview_RequestLocalServiceImpl.class.getName());
	
	public Interview_Request addInterviewRequest(long partnerId, long studentId, int status, long createdBy) throws PortalException, AddressException, IOException{
		Interview_Request interviewRequest = null;
		if(partnerId>0 && studentId>0){
			// Get School and CampusDetail
			Student student = StudentLocalServiceUtil.getStudent(studentId);
			long schoolId = student.getSchoolId();
			long campusId  = student.getCampusId();
			
			Interview_RequestPK interviewRequestPK = new Interview_RequestPK(partnerId, studentId);
			interviewRequest = Interview_RequestLocalServiceUtil.createInterview_Request(interviewRequestPK);
			interviewRequest.setStatus(status);
			interviewRequest.setSchoolId(schoolId);
			interviewRequest.setCampusId(campusId);
			
			interviewRequest.setCreateDate(new Date());
			interviewRequest.setModifiedDate(new Date());
			interviewRequest.setCreatedBy(createdBy);
			interviewRequest.setModifiedBy(createdBy);
			
			interviewRequest  = Interview_RequestLocalServiceUtil.addInterview_Request(interviewRequest);
			
			boolean isMailSent = sendMail(studentId, partnerId);
			_log.info("Interview Request mail sent ->" + isMailSent);
		}
		return interviewRequest;
	}
	
	public Interview_Request updateInterviewRequest(long studentId, long partnerId, int status, long modifiedBy){
		Interview_RequestPK interviewRequestPK = new Interview_RequestPK(partnerId, studentId);
		Interview_Request interviewRequest = null;
		try {
			 interviewRequest = Interview_RequestLocalServiceUtil.getInterview_Request(interviewRequestPK);
			 if(interviewRequest.getStatus()==Interview_RequestStatus.PENDING.getValue()){
				 interviewRequest.setStatus(status);
				 interviewRequest.setModifiedDate(new Date());
				 interviewRequest.setModifiedBy(modifiedBy);
				 interviewRequest =  Interview_RequestLocalServiceUtil.updateInterview_Request(interviewRequest);
			 }
		} catch (PortalException e) {
			_log.error(e);
		}
		return interviewRequest;
	}
	
	private boolean sendMail(long studentId, long partnerId) throws PortalException, IOException, AddressException{
		boolean isMailSent = false;
		Student student = null;
		Partner partner = null;
		Campus campus = null;
		User campusAdmin = null;
		try {
			student = StudentLocalServiceUtil.getStudent(studentId);
			campus = CampusLocalServiceUtil.getCampus(student.getCampusId());
			campusAdmin = MedicusCommonLocalServiceUtil.getCampusAdminName(campus.getCampusId());
		} catch (PortalException e) {
			_log.error(e);
		}
		
	    partner = PartnerLocalServiceUtil.getPartner(partnerId);
		
		
		if(Validator.isNotNull(partner) && Validator.isNotNull(partner) &&  Validator.isNotNull(campus) && Validator.isNotNull(campusAdmin)){
			    InputStream is = null;
			    UnsyncBufferedReader unsyncBufferedReader = null;
			    ClassLoader classloader = getClass().getClassLoader();
			    PartnerBean partnerBean = new PartnerBean(partner);
				is = classloader.getResourceAsStream("interivew-request-email-body.tmpl");
				StringBundler sb = new StringBundler();
				unsyncBufferedReader = new UnsyncBufferedReader(new InputStreamReader(is));
				String line = null;
				while ((line = unsyncBufferedReader.readLine()) != null) {
					 sb.append(line);
					 sb.append(CharPool.NEW_LINE);
				}
				unsyncBufferedReader.close();
				is.close();
				
				
				String body = sb.toString().trim();
				String[] variables = new String[] { "[$CAMPUS_ADMIN_NAME]","[$STUDENT_NAME]","[$STUDENT_ID]", "[$PARTNER_NAME]", "[$PARTNER_EMAIL]","[$PARTNER_MOBILE]"};
				String[] values = new String[] { campusAdmin.getFirstName()+StringPool.SPACE+campusAdmin.getLastName(),
						student.getFirstName()+StringPool.SPACE+student.getLastName(),
						student.getStundetCampusId(),
						partnerBean.getFirstName()+StringPool.SPACE+partnerBean.getLastName(),
						partnerBean.getEmailAddress(),
						partnerBean.getContactPersonPhoneNumber()};
				
				body = StringUtil.replace(body, variables, values);
				
				String subject = "Student Interview Request from -" + partnerBean.getFirstName()+StringPool.SPACE+partnerBean.getLastName();
				String fromMail = MedicusConstant.FROM_EMAIL;
				InternetAddress from = new InternetAddress(fromMail);
				InternetAddress[] to =new InternetAddress[1];
				to[0] = new InternetAddress(campusAdmin.getEmailAddress());
				
				MailMessage mailMessage = new MailMessage(from, subject, body, true);
				
				mailMessage.setTo(to);
				MailServiceUtil.sendEmail(mailMessage);
				
				isMailSent = true;
			
		}else{
			throw new PortalException();
		}
		return isMailSent;
	}
	
	public List<Interview_Request> getInterviewReqeustsByPartnerId(long partnerId){
		return interview_RequestPersistence.findBypartnerId(partnerId);
	}
	
	public List<Interview_Request> getInterviewRequestsByCampusId(long campusId){
		return interview_RequestPersistence.findBycampusId(campusId);
	}
	
	public List<Interview_Request> getInterviewRequestsByStudentId(long studentId){
		return interview_RequestPersistence.findBystudentId(studentId);
	}
	
}