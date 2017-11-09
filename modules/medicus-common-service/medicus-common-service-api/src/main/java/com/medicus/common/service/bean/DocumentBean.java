package com.medicus.common.service.bean;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.medicus.common.service.service.MedicusCommonLocalServiceUtil;

public class DocumentBean {
	private String documentURL;
	private String fileName;
	
	public DocumentBean(DLFileEntry fileEntry){
		this.documentURL = MedicusCommonLocalServiceUtil.getDLFileURL(fileEntry);
		this.fileName = fileEntry.getFileName();
	}
	
	public DocumentBean(FileEntry fileEntry){
		this.documentURL = MedicusCommonLocalServiceUtil.getDLFileURL(fileEntry);
		this.fileName = fileEntry.getFileName();
	}
	
	public String getDocumentURL() {
		return documentURL;
	}
	public void setDocumentURL(String documentURL) {
		this.documentURL = documentURL;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
