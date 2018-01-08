package com.medicus.interview.request.portlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.UserGroupRole;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupLocalServiceUtil;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.bean.Interview_RequestBean;
import com.medicus.common.service.bean.PartnerBean;
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
import com.medicus.common.service.util.MedicusConstant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.medicus",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Medicus Interview Request Portlet",
		"javax.portlet.init-param.template-path=/",
		"com.liferay.portlet.action-url-redirect=true",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class InterviewRequestModulePortlet extends MVCPortlet {
	
	Log _log = LogFactoryUtil.getLog(InterviewRequestModulePortlet.class.getName());
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay =(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<Interview_RequestBean> interviewRequestBeanList = new ArrayList<Interview_RequestBean>();
		
		
		// Check User has Partner Role or not
		long medicusOrgId = MedicusCommonLocalServiceUtil.getMedicusOrganizationId();
		long medicusOrgGroupId = MedicusCommonLocalServiceUtil.getOrganizationGroupIdFromOrgId(medicusOrgId);
		long partnerRoleId = MedicusCommonLocalServiceUtil.getPartnerOrgRoleId();
		long campusAdminRoleId = MedicusCommonLocalServiceUtil.getRoleIdFromName(MedicusConstant.CAMPUS_ADMIN_ROLE);
		long campusSuperAdminRoleId = MedicusCommonLocalServiceUtil.getRoleIdFromName(MedicusConstant.CAMPUS_SUPER_ADMIN_ROLE);
		boolean hasPartnerRole = UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), medicusOrgGroupId, partnerRoleId);
		boolean hasCampusAdminRoleId = UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), medicusOrgGroupId, campusAdminRoleId);
		boolean hasCampusSuperAdminRoleId = UserGroupRoleLocalServiceUtil.hasUserGroupRole(themeDisplay.getUserId(), medicusOrgGroupId, campusSuperAdminRoleId);
		
		if(hasPartnerRole){
			long partnerId = 0;
			try{
				Partner partner= PartnerLocalServiceUtil.getPartnerByUserId(themeDisplay.getUserId());
				partnerId = partner.getPartnerId();
			
				List<Interview_Request> interviewRequestList = Interview_RequestLocalServiceUtil.getInterviewReqeustsByPartnerId(partnerId);
				interviewRequestBeanList = getInterivew_RequestBeanList(interviewRequestList);
			}catch(NoSuchPartnerException e){
				_log.error(e);
			}
		}else if(hasCampusAdminRoleId || hasCampusSuperAdminRoleId){
			long campusId = MedicusCommonLocalServiceUtil.getCampusOrgIdFromRoleIdAndUserId(themeDisplay.getUserId(), campusAdminRoleId);
			if(campusId>0){
				List<Interview_Request> interviewRequestList = Interview_RequestLocalServiceUtil.getInterviewRequestsByCampusId(campusId);
				interviewRequestBeanList = getInterivew_RequestBeanList(interviewRequestList);
			}
		}
		
		PermissionChecker pc = themeDisplay.getPermissionChecker();
	    boolean hasStudentInterviewRequestUpdatePermission  = pc.hasPermission(MedicusCommonLocalServiceUtil.getOrganizationGroupIdFromOrgId(MedicusCommonLocalServiceUtil.getMedicusOrganizationId()),
	    		Student.class.getName(), Student.class.getName(), "UPDATE_STUDENT_INTERVIEW_REQUEST");
	    renderRequest.setAttribute("hasStudentInterviewRequestUpdatePermission", hasStudentInterviewRequestUpdatePermission);
	    
	    // Student Page layout plid
	    Layout layout;
		try {
			layout = LayoutLocalServiceUtil.getFriendlyURLLayout(MedicusCommonLocalServiceUtil.getMedicusGroupId(),
			        true, MedicusConstant.STUDENT_PAGE_URL);
			long plid = layout.getPlid();
			renderRequest.setAttribute("student_layout_plid", plid);
		} catch (PortalException e) {
			_log.error(e);
		}

		renderRequest.setAttribute("interviewRequestBeanList", interviewRequestBeanList);
		include(viewTemplate, renderRequest, renderResponse);
	}
	
	private List<Interview_RequestBean> getInterivew_RequestBeanList(List<Interview_Request> interviewRequestList){
		List<Interview_RequestBean> interviewRequestBeanList = new ArrayList<Interview_RequestBean>();
		
		Map<Long,Campus> campusMap = new HashMap<Long,Campus>();
		Map<Long,PartnerBean> partnerMap = new HashMap<Long,PartnerBean>();
		Map<Long,Student> studentMap = new HashMap<Long,Student>();
		
		
		for(Interview_Request interviewRequest : interviewRequestList){
			Interview_RequestBean interviewRequestBean = new Interview_RequestBean();
			interviewRequestBean.setCampusId(interviewRequest.getCampusId());
			interviewRequestBean.setStudentId(interviewRequest.getStudentId());
			interviewRequestBean.setPartnerId(interviewRequest.getPartnerId());
			interviewRequestBean.setStatus(interviewRequest.getStatus());
			interviewRequestBean.setCreateDate(interviewRequest.getCreateDate());
			interviewRequestBean.setModifiedDate(interviewRequest.getModifiedDate());
			
			if(interviewRequest.getStudentId()>0){
				try {
					Student student = null;
					Campus campus = null;
					PartnerBean partnerBean = null;
					
					if(Validator.isNotNull(campusMap.get(interviewRequest.getStudentId()))){
						campus = campusMap.get(interviewRequest.getStudentId());
					}else{
						campus = CampusLocalServiceUtil.getCampus(interviewRequest.getCampusId());
						campusMap.put(interviewRequest.getCampusId(), campus);
					}
					
					if(Validator.isNotNull(studentMap.get(interviewRequest.getStudentId()))){
						student = studentMap.get(interviewRequest.getStudentId());
					}else{
						student = StudentLocalServiceUtil.getStudent(interviewRequest.getStudentId());
						studentMap.put(interviewRequest.getStudentId(), student);
					}
					
					if(Validator.isNotNull(partnerMap.get(interviewRequest.getPartnerId()))){
						partnerBean = partnerMap.get(interviewRequest.getPartnerId());
					}else{
						Partner partner = PartnerLocalServiceUtil.getPartner(interviewRequest.getPartnerId());
						partnerBean = new PartnerBean(partner);
						partnerMap.put(interviewRequest.getPartnerId(), partnerBean);
					}
					
					if(Validator.isNotNull(student) && Validator.isNotNull(partnerBean) && Validator.isNotNull(campus)){
					
					interviewRequestBean.setStudent(student);
					interviewRequestBean.setCampus(campus);
					interviewRequestBean.setPartnerBean(partnerBean);
					
					interviewRequestBeanList.add(interviewRequestBean);
					
					}
				} catch (PortalException e) {
					_log.error(e.getMessage());
				}
			}
		}
		
		return interviewRequestBeanList;
	}
}