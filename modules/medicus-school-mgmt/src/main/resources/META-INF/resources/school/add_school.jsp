<%@ include file="../init.jsp" %>

<portlet:actionURL var="addSchoolURL" name="/add_school">
</portlet:actionURL>
<div class="page-title">
  <div class="title_left">
    <c:choose>
	<c:when test="${ school.schoolId gt 0}">
		<h2>
    		<liferay-ui:message key="edit.school"/> 
  		</h2>
	</c:when>
	<c:otherwise>
		<h2>
    		<liferay-ui:message key="add.school"/> 
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
       			<aui:form name="addschoolFm" action="${addSchoolURL}" cssClass="form-horizontal form-label-left">
       				<div class="form-group">
       					 <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="name" label="name"  cssClass="form-control col-md-7 col-xs-12" value="${school.name }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						 </div>
					</div>	 
       				<div class="form-group">
       					 <div class="col-md-10 col-sm-6 col-xs-12">
       						 <aui:input name="address1" label="address1" cssClass="form-control col-md-7 col-xs-12" value="${school.address1 }">
					     		<aui:validator name="required" />
					     		<aui:validator name="maxLength">70</aui:validator>
						 	</aui:input>
						</div>
					</div>
       				<div class="form-group">
       					 <div class="col-md-10 col-sm-6 col-xs-12">
       						 <aui:input name="city" label="city" cssClass="form-control col-md-7 col-xs-12" value="${school.city }">
					    	 	<aui:validator name="required" />
					    	 	<aui:validator name="maxLength">50</aui:validator>
						 	</aui:input>
       					</div>
       				</div>	
       				<div class="form-group">
       					 <div class="col-md-10 col-sm-6 col-xs-12">
						 	<aui:select name="state" label="state" cssClass="form-control col-md-7 col-xs-12">
	               				<c:forEach items="${usStateList }" var="state">
	               					<aui:option value="${state }" selected='${state eq school.state ? true : false }'>${state }</aui:option>
	               				</c:forEach>
	               			</aui:select>
       					</div>
       				</div>	
       				<div class="form-group">
       					 <div class="col-md-10 col-sm-6 col-xs-12">
       						 <aui:input name="country" label="country" cssClass="form-control col-md-7 col-xs-12" value="US" readonly="true">
					    	 	<aui:validator name="required" />
					    	 	<aui:validator name="maxLength">50</aui:validator>
						 	</aui:input>
       					</div>
       				</div>	
       				<div class="form-group">
       					 <div class="col-md-10 col-sm-6 col-xs-12">
       						 <aui:input name="contactNumber" label="school.contact.no" cssClass="form-control col-md-7 col-xs-12" value="${school.contactNumber }" placeholder="xxx-xxx-xxxx">
					     		<aui:validator name="required" />
					     		<aui:validator name="maxLength">14</aui:validator>
					     		<aui:script>
								new Formatter(document.getElementById('<portlet:namespace/>'+'contactNumber'), {
									'pattern': '({{999}})-{{999}}-{{9999}}',
									'persistent': false
								});
							</aui:script>
						 	</aui:input>
						</div>
					</div>	
					<div class="form-group">
       					 <div class="col-md-10 col-sm-6 col-xs-12">	
						 	<aui:input name="websiteLink" label="websiteLink" cssClass="form-control col-md-7 col-xs-12" value="${school.websiteLink }">
					     		<aui:validator name="required" />
					     		<aui:validator name="maxLength">70</aui:validator>
						 	</aui:input>
       					</div>
       				</div>	
       				<div class="form-group">
       					 <div class="col-md-10 col-sm-6 col-xs-12">
       						 <aui:input name="contactPersonName" label="contactPersonName" cssClass="form-control col-md-7 col-xs-12" value="${school.contactPersonName }">
					    	 	<aui:validator name="required" />
					    	 	<aui:validator name="maxLength">40</aui:validator>
						 	</aui:input>
       					</div>
       				</div>	
       				<div class="form-group">
       					 <div class="col-md-10 col-sm-6 col-xs-12">
       						 <aui:input name="contactPersonPhoneNumber" label="contactPersonPhoneNumber" cssClass="form-control col-md-7 col-xs-12" value="${school.contactPersonPhoneNumber }" placeholder="xxx-xxx-xxxx">
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
       						 <aui:input name="contactPersonEmail" label="contactPersonEmail" cssClass="form-control col-md-7 col-xs-12" value="${school.contactPersonEmail }">
					    	 	<aui:validator name="required" />
					    	 	<aui:validator name="email" />
					    	 	<aui:validator name="maxLength">30</aui:validator>
						 	</aui:input>
       					</div>
       				</div>
       				<div class="ln_solid"></div>	
    				 <div class="form-group">
				        <div class="col-md-10 col-sm-6 col-xs-12 col-md-offset-3">
							<aui:button type="button" value="Submit"  cssClass="addSchoolBtn btn btn-success"/>
							<a href="/group/medicus/schools" class="btn btn-primary btn-xs">  Cancel </a>
						</div>
					</div>	
					<aui:input type="hidden"  name="schoolId" value="${school.schoolId }"/>
       			</aui:form>
       		</div>
        </div>
   </div>
</div>	
<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';
AUI().use('aui-base','aui-form-validator', function(A) {
	var addSchoolBtn= A.one(".addSchoolBtn");
	addSchoolBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addschoolFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />addschoolFm.submit();
		}
	});
});
</aui:script>