package com.medicus.interview.request.portlet.portlet.actioncommand;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.io.unsync.UnsyncBufferedReader;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
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
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.common.service.service.persistence.Interview_RequestPK;
import com.medicus.common.service.util.Interview_RequestStatus;
import com.medicus.common.service.util.MedicusConstant;
import com.medicus.interview.request.portlet.portlet.util.InterivewRequestPortletConstant;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + InterivewRequestPortletConstant.PORTLET_ID,
	        "mvc.command.name=/approve_reject"
	    },
	    service = MVCActionCommand.class
	)
public class ApproveRejectRequestActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(ApproveRejectRequestActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){
		long studentId = ParamUtil.getLong(actionRequest, "studentId");
		long partnerId = ParamUtil.getLong(actionRequest, "partnerId");
		String action = ParamUtil.getString(actionRequest, "action");
		String comment = ParamUtil.getString(actionRequest, "comment");
		
		Interview_RequestPK interviewRequestPK = new Interview_RequestPK(partnerId, studentId);
		try {
			Interview_Request interviewRequest = Interview_RequestLocalServiceUtil.getInterview_Request(interviewRequestPK);
			if(interviewRequest.getStatus()==Interview_RequestStatus.PENDING.getValue()){
				if(action.equals("approve")){
					
					// Move this code to Studentlocalservice updateStudent method as we are redicting
					// to edit student profile on click of approve button.
					 
					// Update Request to Approve
					//interviewRequest.setStatus(Interview_RequestStatus.APPROVED.getValue());
					//Interview_RequestLocalServiceUtil.updateInterview_Request(interviewRequest);
					
					//Send Mail 
					//sendMail(interviewRequest, action, comment);
					//SessionMessages.add(actionRequest, "request-approve-success");
				}else if(action.equals("reject")){
					// Update Request to Reject
					interviewRequest.setStatus(Interview_RequestStatus.REJECTED.getValue());
					Interview_RequestLocalServiceUtil.updateInterview_Request(interviewRequest);
					
					//Send Mail
					sendRejectMail(interviewRequest, action, comment);
					SessionMessages.add(actionRequest, "request-reject-success");
				}
			}else{
				throw new PortalException();
			}
		} catch (PortalException e) {
			SessionErrors.add(actionRequest, "request-update-error");
			SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			_log.debug(e.getMessage());
		}
	}

	private void sendRejectMail(Interview_Request interviewRequest, String action, String comment){
		if(Validator.isNotNull(interviewRequest)){
			try {
				Student student = StudentLocalServiceUtil.getStudent(interviewRequest.getStudentId());
				Partner partner = PartnerLocalServiceUtil.getPartner(interviewRequest.getPartnerId());
				Campus campus = CampusLocalServiceUtil.getCampus(interviewRequest.getCampusId());
				PartnerBean partnerBean = new PartnerBean(partner);
				
				InputStream is = null;
			    UnsyncBufferedReader unsyncBufferedReader = null;
			    ClassLoader classloader = getClass().getClassLoader();
				is = classloader.getResourceAsStream("reject-request-mail-body.tmpl");
				StringBundler sb = new StringBundler();
				unsyncBufferedReader = new UnsyncBufferedReader(new InputStreamReader(is));
				String line = null;
				while ((line = unsyncBufferedReader.readLine()) != null) {
					 sb.append(line);
					 sb.append(CharPool.NEW_LINE);
				}
				unsyncBufferedReader.close();
				is.close();
				
				String mail_action = "Approved";
				if(action.equals("reject")){
					mail_action = "Rejected";
				}
				
				String body = sb.toString().trim();
				String[] variables = new String[] { "[$PARTNER_NAME]","[$STUDENT_NAME]","[$STUDENT_ID]", "[$ACTION]", "[$COMMENTS]","[$CAMPUS_NAME]"};
				String[] values = new String[] { partnerBean.getFirstName()+StringPool.SPACE+partnerBean.getLastName(),
						student.getFirstName()+StringPool.SPACE+student.getLastName(),
						student.getStundetCampusId(),
						mail_action,
						comment,
						campus.getName()};
				
				body = StringUtil.replace(body, variables, values);
				
				String subject = "Medicus Interview Request Updated";
				String fromMail = MedicusConstant.FROM_EMAIL;
				InternetAddress from = new InternetAddress(fromMail);
				InternetAddress[] to =new InternetAddress[1];
				to[0] = new InternetAddress(partnerBean.getEmailAddress());
				
				MailMessage mailMessage = new MailMessage(from, subject, body, true);
				
				mailMessage.setTo(to);
				MailServiceUtil.sendEmail(mailMessage);
				
				_log.info("Interivew request with action " + action +" has sent mail successfully.");
				
			} catch (PortalException |IOException | AddressException e) {
				_log.error(e.getMessage());
			}
		}
	}
	
}
