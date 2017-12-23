package com.medicus.partner.portlet.portlet.actioncommand;

import java.awt.Label;
import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.service.PartnerLocalServiceUtil;
import com.medicus.partner.portlet.portlet.util.PartnerModuleContstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + PartnerModuleContstant.PORTLET_ID,
	        "mvc.command.name=/edit-partner"
	    },
	    service = MVCActionCommand.class
	)
public class EditPartnerActionCommand extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(EditPartnerActionCommand.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse){
		
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long partnerId = ParamUtil.getLong(actionRequest, "partnerId");
		String firstName = ParamUtil.getString(actionRequest, "firstName");
		String address1 = ParamUtil.getString(actionRequest, "address1");
		String zipcode = ParamUtil.getString(actionRequest, "zipcode");
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		String country = ParamUtil.getString(actionRequest, "country");
		String contactPersonName = ParamUtil.getString(actionRequest, "contactPersonName");
		String contactPersonEmail = ParamUtil.getString(actionRequest, "contactPersonEmail");
		String contactPersonPhoneNumber = ParamUtil.getString(actionRequest, "contactPersonPhoneNumber");
		String websiteLink = ParamUtil.getString(actionRequest, "websiteLink");
		
		try {
			Partner partner = PartnerLocalServiceUtil.editPartner(partnerId, firstName,
					address1, city, zipcode, state, country, contactPersonName, contactPersonEmail, 
					contactPersonPhoneNumber, websiteLink, StringPool.BLANK , StringPool.BLANK, null , null,themeDisplay.getUserId());
			
			SessionMessages.add(actionRequest, "partner-update-success");
		} catch (PortalException | IOException e) {
			SessionErrors.add(actionRequest, "partner-update-err");
			actionResponse.setRenderParameter("mvcRenderCommandName", "/edit_partner");
			actionResponse.setRenderParameter("partnerId", String.valueOf(partnerId));
			_log.error(e);
		}
	}

}
