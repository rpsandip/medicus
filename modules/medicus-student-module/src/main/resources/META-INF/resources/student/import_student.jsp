<%@ include file="../init.jsp" %>
<portlet:actionURL var="importStudentURL" name="/import_student">
</portlet:actionURL>
<liferay-ui:success key="student-import-success" message="student-import-success"/>
<liferay-ui:error key="file-format-err" message="file-format-err"/>

<div class="page-title">
  <div class="title_left">
   	<h2><liferay-ui:message key="import.student"/> </h2>
   	<c:if test="${fn:length(import_studnet_file_url) gt 0}">
   		<a href="${import_studnet_file_url }" class="btn btn-primary btn-xs">Download Sample Student Import File</a>
   	</c:if>
  </div>
</div>
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_content">
					<aui:form name="importStudentFm" action="${importStudentURL}" cssClass="form-horizontal form-label-left" enctype="multipart/form-data">
						<div class="form-group">
	                     <label for="importStudent" class="control-label col-md-3 col-sm-3 col-xs-12">Import Students(.Xlsx)</label>
	                     <div class="col-md-6 col-sm-6 col-xs-12">
	                       <input id="middle-name" class="form-control col-md-7 col-xs-12" type="file" name="importStudentFile">
	                     </div>
	                   </div>
	                   <div class="form-group">
				        	<div class="col-md-10 col-sm-6 col-xs-12 col-md-offset-3">
								<aui:button type="button" value="Submit"  cssClass="importStudentBtn btn btn-success"/>
							</div>
						</div>
					</aui:form>
					<c:if test="${isImported eq true }">
						<b>Total Students:: </b> ${totalStudentCount }  <br/>
						<b>Successfull :: </b> ${successImportedStudentCount }  <br/>
						<b>UnSuccessfull :: </b> ${UnsuccessImportedStudentCount }  <br/>
						
						<c:if test="${UnsuccessImportedStudentCount gt 0}">
							<b>UnSuccessfull Import Students :</b> <br/><br/>
							<ul>
								<b>StudentID  &nbsp; &nbsp; &nbsp; &nbsp; Email Address</b>
								<c:forEach items="${unsuccessfullStudentList }" var ="unsuccessfullStudent">
								<c:set var="detail" value="${fn:split(unsuccessfullStudent, ',')}" />
									<c:if test="${fn:length(detail[0]) gt 0}">
										<li>
											${detail[0]} &nbsp; &nbsp; &nbsp; &nbsp;${detail[1]}
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
	var importStudentBtn= A.one(".importStudentBtn");
	importStudentBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />importStudentFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />importStudentFm.submit();
		}
	});
});
</aui:script>			