package com.medicus.student.portlet.portlet.resourcecommand;

import java.io.IOException;

import javax.mail.internet.AddressException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.exception.NoSuchPartnerException;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.Interview_Request;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.model.Student;
import com.medicus.common.service.service.CampusLocalServiceUtil;
import com.medicus.common.service.service.Interview_RequestLocalServiceUtil;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.common.service.service.StudentLocalServiceUtil;
import com.medicus.common.service.service.persistence.Interview_RequestPK;
import com.medicus.common.service.util.Interview_RequestStatus;
import com.medicus.student.portlet.portlet.StudentPortletConstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + StudentPortletConstant.PORTLET_ID,
	        "mvc.command.name=/interview_request"
	    },
	    service = MVCResourceCommand.class
	)
public class InterviewRequestResourceCommand implements MVCResourceCommand{

	Log _log = LogFactoryUtil.getLog(InterviewRequestResourceCommand.class.getName());
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		
		long studentId = ParamUtil.getLong(resourceRequest, "studentId");
		Partner partner = null;
		
		boolean isPartner = MedicusCommonLocalServiceUtil.isPartner(themeDisplay.getUserId());
		boolean isCampusSuperAdminExist = checkCampusSuerAdminExist(studentId);		
		
		if(!isCampusSuperAdminExist){
			responseObj.put("status", "err");
			 responseObj.put("msg", "Campus Super Admin User does not exist, Please contact to Administrator");
		} else if(isPartner){
			
			long partnerId = 0;
			try{
				partner= PartnerLocalServiceUtil.getPartnerByUserId(themeDisplay.getUserId());
				partnerId = partner.getPartnerId();
			}catch(NoSuchPartnerException e){
				_log.error(e);
			}
			
			// Check already sent interview request or not 
			Interview_Request interviewRequest = null;
			Interview_RequestPK interviewRequestPK = new Interview_RequestPK(partnerId, studentId);
			try {
				 interviewRequest = Interview_RequestLocalServiceUtil.getInterview_Request(interviewRequestPK);
				 responseObj.put("status", "err");
				 responseObj.put("msg", "You have already sent interview request to this student.");
			} catch (PortalException e1) {
				_log.debug(e1.getMessage());
			}
			
			if(Validator.isNull(interviewRequest)){
				try {
					interviewRequest = Interview_RequestLocalServiceUtil.addInterviewRequest(partnerId, studentId, Interview_RequestStatus.PENDING.getValue(), themeDisplay.getUserId());
					responseObj.put("status", "success");
					responseObj.put("msg", "Successfully sent interview request.");
				} catch (PortalException | AddressException | IOException e) {
					responseObj.put("status", "err");
					responseObj.put("msg", "Error while sending interview request.");
					_log.error(e);
				}
			}
		}else{
			responseObj.put("status", "err");
			responseObj.put("msg", "You don't have Permission to send interivew reqest.");
		}
		
		try {
			resourceResponse.getWriter().write(responseObj.toString());
		} catch (IOException e) {
			_log.error(e);
		}
		return true;
	}
	
	private boolean checkCampusSuerAdminExist(long studentId){
		boolean isCampusSuperAdminExist  = false;
		Student student = null;
		Partner partner = null;
		Campus campus = null;
		User campusAdmin = null;
		try {
			student = StudentLocalServiceUtil.getStudent(studentId);
			campus = CampusLocalServiceUtil.getCampus(student.getCampusId());
			campusAdmin = MedicusCommonLocalServiceUtil.getCampusAdminName(campus.getCampusId());
			if(Validator.isNotNull(campusAdmin)){
				isCampusSuperAdminExist =true;
			}
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}
		
		return isCampusSuperAdminExist;
	}

}
