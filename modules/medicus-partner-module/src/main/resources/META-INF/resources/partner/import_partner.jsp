<%@ include file="../init.jsp" %>
<portlet:actionURL var="importPartnerURL" name="/import_partner">
</portlet:actionURL>
<liferay-ui:success key="partner-import-success" message="partner-import-success"/>
<liferay-ui:error key="file-format-err" message="file-format-err"/>
<div class="page-title">
  <div class="title_left">
   	<h2><liferay-ui:message key="import.partner"/> </h2>
   	<c:if test="${fn:length(import_partner_file_url) gt 0}">
   		<a href="${import_partner_file_url }" class="btn btn-primary btn-xs">Download Sample Partner Import File</a>
   	</c:if>
  </div>
</div>
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_content">
					<aui:form name="importPartnerFm" action="${importPartnerURL}" cssClass="form-horizontal form-label-left" enctype="multipart/form-data">
						<div class="form-group">
	                     <label for="importStudent" class="control-label col-md-3 col-sm-3 col-xs-12">Import Partners(.Xlsx)</label>
	                     <div class="col-md-6 col-sm-6 col-xs-12">
	                       <input id="middle-name" class="form-control col-md-7 col-xs-12" type="file" name="importPartnerFile">
	                     </div>
	                   </div>
	                   <div class="form-group">
				        	<div class="col-md-10 col-sm-6 col-xs-12 col-md-offset-3">
								<aui:button type="button" value="Submit"  cssClass="importPartnerBtn btn btn-success"/>
							</div>
						</div>
					</aui:form>
					<c:if test="${isImported eq true }">
						<b>Total Students:: </b> ${totalPartnerCount }  <br/>
						<b>Successfull :: </b> ${successImportedPartnerCount }  <br/>
						<b>UnSuccessfull :: </b> ${UnsuccessImportedPartnerCount }  <br/>
						
						<c:if test="${UnsuccessImportedPartnerCount gt 0}">
							<b>UnSuccessfull Import Partners :</b> <br/><br/>
							<ul>
								<b>Email Address</b>
								<c:forEach items="${unsuccessfullPartnerList }" var ="unsuccessfullPartner">
									<c:if test="${fn:length(unsuccessfullPartner) gt 0}">
										<li>
											${unsuccessfullPartner }
										</li>
									</c:if>
								</c:forEach>
							</ul>
						</c:if>	
					</c:if>
				</div>
			</div>
	</div>
</div>
<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';
AUI().use('aui-base','aui-form-validator', function(A) {
	var importPartnerBtn= A.one(".importPartnerBtn");
	importPartnerBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />importPartnerFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />importPartnerFm.submit();
		}
	});
});
</aui:script>			