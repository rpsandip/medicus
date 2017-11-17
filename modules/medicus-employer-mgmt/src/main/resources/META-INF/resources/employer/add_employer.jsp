<%@ include file="../init.jsp" %>
<portlet:actionURL var="addEmployerURL" name="/add_employer">
</portlet:actionURL>

<liferay-ui:error key="employer-add-error" message="employer-add-error"/>
<liferay-ui:error key="employer-update-error" message="employer-update-error"/>

<div class="page-title">
  <div class="title_left">
    <c:choose>
	<c:when test="${ employer.employerId gt 0}">
		<h2>
    		<liferay-ui:message key="edit.employer"/> 
  		</h2>
	</c:when>
	<c:otherwise>
		<h2>
    		<liferay-ui:message key="add.employer"/> 
  		</h2>
	</c:otherwise>
	</c:choose>
  </div>
</div>
<div class="clearfix"></div>
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_content">
       			<aui:form name="addEmployerFm" action="${addEmployerURL}" cssClass="form-horizontal form-label-left">
       				<div class="form-group">
		               	 <div class="col-md-10 col-sm-6 col-xs-12">
			               	<aui:input name="firstName" label="firstName" cssClass="form-control col-md-7 col-xs-12" value="${employer.firstName }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">60</aui:validator>
							 </aui:input>
						</div>
					  </div>
					  <div class="form-group">
		               	 <div class="col-md-10 col-sm-6 col-xs-12">
			               	<aui:input name="lastName" label="lastName" cssClass="form-control col-md-7 col-xs-12" value="${employer.lastName }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">60</aui:validator>
							 </aui:input>
						</div>
					  </div>
		              <div class="form-group">
		              		<div class="col-md-10 col-sm-6 col-xs-12">
				                 <aui:input name="emailAddress" label="emailAddress" cssClass="form-control col-md-7 col-xs-12" value="${employer.emailAddress }">
							     	<aui:validator name="required" />
							     	<aui:validator name="maxLength">50</aui:validator>
								 </aui:input>
						 </div>
		              </div>
		              <div class="form-group">
		               	 <div class="col-md-10 col-sm-6 col-xs-12">
			               	<aui:input name="address1" label="address1" cssClass="form-control col-md-7 col-xs-12" value="${employer.address1 }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">60</aui:validator>
							 </aui:input>
						</div>
					  </div>
					  <div class="form-group">
		               	 <div class="col-md-10 col-sm-6 col-xs-12">
			               	<aui:input name="zipcode" label="zipcode" cssClass="form-control col-md-7 col-xs-12" value="${employer.zipcode }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">8</aui:validator>
							 </aui:input>
						</div>
					  </div>
					  
					  <div class="form-group">
		               	 <div class="col-md-10 col-sm-6 col-xs-12">
			               	<aui:input name="city" label="city" cssClass="form-control col-md-7 col-xs-12" value="${employer.city }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">20</aui:validator>
							 </aui:input>
						</div>
					  </div>
					  
					  <div class="form-group">
		               	 <div class="col-md-10 col-sm-6 col-xs-12">
			               	<aui:select name="state" label="state" cssClass="form-control col-md-7 col-xs-12" value="${employer.state }">
			               		<c:forEach items="${usStateList }" var="state">
			               			<aui:option value="${state }">${state }</aui:option>
			               		</c:forEach>
			               	</aui:select>
						</div>
					  </div>
					  
					  
					  <div class="form-group">
		               	 <div class="col-md-10 col-sm-6 col-xs-12">
			               	<aui:input name="country" label="country" cssClass="form-control col-md-7 col-xs-12" value="US" readonly="true">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">20</aui:validator>
							 </aui:input>
						</div>
					  </div>
					  
					  
					  <div class="form-group">
		               	 <div class="col-md-10 col-sm-6 col-xs-12">
			               	<aui:input name="contactPersonName" label="contactPersonName" cssClass="form-control col-md-7 col-xs-12" value="${employer.contactPersonName }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">60</aui:validator>
							 </aui:input>
						</div>
					  </div>
					  
					  
					  <div class="form-group">
		               	 <div class="col-md-10 col-sm-6 col-xs-12">
			               	<aui:input name="contactPersonEmail" label="contactPersonEmail" cssClass="form-control col-md-7 col-xs-12" value="${employer.contactPersonEmail }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">20</aui:validator>
							 </aui:input>
						</div>
					  </div>
					  
					  
					  <div class="form-group">
		               	 <div class="col-md-10 col-sm-6 col-xs-12">
			               	<aui:input name="contactPersonPhoneNumber" label="contactPersonPhoneNumber" cssClass="form-control col-md-7 col-xs-12" placeholder="xxx-xxx-xxxx" value="${ employer.contactPersonPhoneNumber}">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">14</aui:validator>
						     	<aui:script>
										new Formatter(document.getElementById('<portlet:namespace/>'+'contactPersonPhoneNumber'), {
											'pattern': '({{999}})-{{999}}-{{9999}}',
											'persistent': false
										});
									</aui:script>
							 </aui:input>
						</div>
					  </div>
					  
					  
					  <div class="form-group">
		               	 <div class="col-md-10 col-sm-6 col-xs-12">
			               	<aui:input name="websiteLink" label="websiteLink" cssClass="form-control col-md-7 col-xs-12" value="${employer.websiteLink }">
						     	<aui:validator name="maxLength">30</aui:validator>
							 </aui:input>
						</div>
					  </div>
		              
		              <div class="ln_solid"></div>
		              <div class="form-group">
			                 <div class="col-md-10 col-sm-6 col-xs-12 col-md-offset-3">
		                		<aui:button type="button" value="Submit"  cssClass="addEmployerBtn btn btn-success"/>
		              		</div>
		              </div>
		              <aui:input type="hidden" name="employerId" value="${ employer.employerId}"/>
       			</aui:form>
       		</div>
        </div>
   </div>
</div>	
<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';
AUI().use('aui-base','aui-form-validator', function(A) {
	var addEmployerBtn= A.one(".addEmployerBtn");
	addEmployerBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addEmployerFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />addEmployerFm.submit();
		}
	});
});
</aui:script>