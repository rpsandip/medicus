package com.medicus.partner.portlet.portlet.actioncommand;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.medicus.common.service.model.Partner;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;
import com.medicus.common.service.service.RegistrationLocalServiceUtil;
import com.medicus.common.service.util.MedicusConstant;
import com.medicus.partner.portlet.portlet.util.PartnerModuleContstant;

@Component(
	    property = {
	    	"javax.portlet.name=" + PartnerModuleContstant.PORTLET_ID,
	        "mvc.command.name=/import_partner"
	    },
	    service = MVCActionCommand.class
	)
public class ImportPartnerActionComman extends BaseMVCActionCommand{

	Log _log = LogFactoryUtil.getLog(ImportPartnerActionComman.class.getName());
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadRequest.getFile("importPartnerFile");
		String sourceFileName =uploadRequest.getFileName("importPartnerFile");
		String fileExtension = sourceFileName.substring(sourceFileName.lastIndexOf(".") + 1);
		if(Validator.isNotNull(file)){
			if(fileExtension.equals("xlsx")|| fileExtension.equals("xls")){
				uploadPartners(actionRequest, actionResponse,file);
			}
		}else{
			SessionErrors.add(actionRequest, "not-valid-file");
		}
		
	}

	private void uploadPartners(ActionRequest request, ActionResponse response, File file) throws IOException{
		
		 ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		 FileInputStream inputStream = new FileInputStream(file);
		 SimpleDateFormat df = new SimpleDateFormat("MM/DD/YYYY");
		 XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	     Sheet firstSheet = workbook.getSheetAt(0);
	     Iterator<Row> iterator = firstSheet.iterator();
	     List<String> unsuccessfullPartnerList = new ArrayList<String>();
	     if(iterator.hasNext()){
	    	  	Row row = iterator.next(); 
	        	boolean isValidFile = validateFile(row);
	        	if(!isValidFile){
	        		SessionErrors.add(request, "file-format-err");
	        		response.setRenderParameter("mvcRenderCommandName", "/import_partner");
	        		return;
	        	}
	      }
	     int totalPartnerCount = 0;
	     int successImportedPartnerCount = 0;
	     
	     while (iterator.hasNext()) {
	    	 totalPartnerCount++;
	    	 Row nextRow = iterator.next();
	    	 
	    	 if(nextRow.getRowNum()!=0){
	    		 
	    		 boolean isEmptyRow = checkIfRowIsEmpty(nextRow);
	    		 
	    		 if(!isEmptyRow){
	    		 
	    		 boolean validRow = validateRow(nextRow);
	    		 
	    		 if(validRow){
	    			 User partnerUser = MedicusCommonLocalServiceUtil.isUserExist(nextRow.getCell(1).toString());
	    			 if(Validator.isNull(partnerUser)){
	    				 try {
	    					 RegistrationLocalServiceUtil.registerPartner(
	    							      nextRow.getCell(0).toString(),
	    							      MedicusConstant.PARTNER_DEFAULT_LAST_NAME,
	    							      nextRow.getCell(1).toString(),
	    							      StringPool.BLANK, 
	    							      StringPool.BLANK,
	    							      nextRow.getCell(2).toString(),
	    							      nextRow.getCell(5).toString(), 
	    								  nextRow.getCell(3).toString(),
	    								  nextRow.getCell(5).toString(), 
	    								  MedicusConstant.MEDICUST_DEFAULT_COUNTRY, 
	    								  nextRow.getCell(6).toString(),
	    								  nextRow.getCell(7).toString(),
	    								  nextRow.getCell(8).toString(),
	    								  nextRow.getCell(9).toString(),
	    								  themeDisplay.getUserId(),
	    								  themeDisplay.getScopeGroupId());
	    					 successImportedPartnerCount++;
	    					} catch (PortalException e) {
	    						_log.error(e);
	    						unsuccessfullPartnerList.add(nextRow.getCell(1).toString());
	    					}
	    			 }else{
	    				 unsuccessfullPartnerList.add(nextRow.getCell(1).toString());
	    			 }
	    		 }else{
	    			 unsuccessfullPartnerList.add(nextRow.getCell(1).toString());
	    		 }
	    	   }else{
	    		   totalPartnerCount--;
	    	   }
	    	 }
	     }
	     
	     response.setRenderParameter("totalPartnerCount", String.valueOf(totalPartnerCount));
	     response.setRenderParameter("successImportedPartnerCount", String.valueOf(successImportedPartnerCount));
	     response.setRenderParameter("UnsuccessImportedPartnerCount", String.valueOf(totalPartnerCount-successImportedPartnerCount));
	     response.setRenderParameter("isImported",String.valueOf(true));
	     SessionMessages.add(request, "partner-import-success");
	     PortalCache portalCache =   MultiVMPoolUtil.getCache(Partner.class.getName());
    	 portalCache.put("unsuccessfullPartnerList", unsuccessfullPartnerList);
	     
	     response.setRenderParameter("mvcRenderCommandName", "/import_partner");
	}
	
	public boolean validateFile(Row firstRow){
		 if(!firstRow.getCell(0).toString().trim().equalsIgnoreCase("Facility")){
			 return false;
		 }else if(!firstRow.getCell(1).toString().trim().equalsIgnoreCase("Email Address")){
			 return false;
		 }else if(!firstRow.getCell(2).toString().trim().equalsIgnoreCase("Address")){
			 return false;
		 }else if(!firstRow.getCell(3).toString().trim().equalsIgnoreCase("Zipcode")){
			 return false;
		 }else if(!firstRow.getCell(4).toString().trim().equalsIgnoreCase("City")){
			 return false;
		 }else if(!firstRow.getCell(5).toString().trim().equalsIgnoreCase("State")){
			 return false;
		 }else if(!firstRow.getCell(6).toString().trim().equalsIgnoreCase("Contact Person Name")){
			 return false;
		 }else if(!firstRow.getCell(7).toString().trim().equalsIgnoreCase("Contact Person Email")){
			 return false;
		 }else if(!firstRow.getCell(8).toString().trim().equalsIgnoreCase("Contact Person Phone Number")){
			 return false;
		 }else if(!firstRow.getCell(9).toString().trim().equalsIgnoreCase("Website Link")){
			 return false;
		 }else{
			 return true;
		 }
	 }
	
	private boolean validateRow(Row row){
		if(Validator.isNull(row.getCell(0).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(1).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(2).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(3).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(4).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(5).toString().trim())){
			 return false;
		 }else if(Validator.isNull(row.getCell(6).toString().trim())){
			 return false;
		 }else{
			 return true;
		 }
	}
	
	 
	 public boolean checkIfRowIsEmpty(Row row) {
		    if (row == null) {
		        return true;
		    }
		    if (row.getLastCellNum() <= 0) {
		        return true;
		    }
		    for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
		        Cell cell = row.getCell(cellNum);
		        if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK && Validator.isNotNull(cell.toString())) {
		            return false;
		        }
		    }
		    return true;
		}
}
