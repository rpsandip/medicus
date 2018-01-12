<%@ include file="../init.jsp" %>

<portlet:actionURL var="addCampusURL" name="/add_campus">
</portlet:actionURL>
 
<liferay-ui:error key="campus-add-error" message="campus-add-error"/>
<liferay-ui:error key="campus-update-error" message="campus-update-error"/>
 
 
<div class="page-title">
   <div class="title_left">
     <c:choose>
	<c:when test="${ campus.campusId gt 0}">
		<h2>
    		Edit Campus
  		</h2>
	</c:when>
	<c:otherwise>
		<h2>
    		Add Campus
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
	   				<br />
       			<aui:form name="addcampusFm" action="${addCampusURL}" cssClass="form-horizontal form-label-left">
	       			<div class="form-group">	
	       				 <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:select name="schoolId" label="Select School" cssClass="form-control">
						     	<c:forEach items="${schoolList }" var="school">
						     		<aui:option value="${school.schoolId }" selected='${school.schoolId eq campus.schoolId ? true : false }'> ${school.name }</aui:option>
						     	</c:forEach>
							 </aui:select>
						</div>	 
					</div>	
       				<div class="form-group">	
	       				 <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="name" label="name" cssClass="form-control col-md-7 col-xs-12" value="${campus.name }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>	 
       				</div>
       				<div class="form-group">	
	       				 <div class="col-md-10 col-sm-6 col-xs-12">
       						 <aui:input name="address1" label="address1" cssClass="form-control col-md-7 col-xs-12" value="${campus.address1 }">
					     		<aui:validator name="required" />
					     		<aui:validator name="maxLength">70</aui:validator>
						 	</aui:input>
						</div>
					</div>
       				<div class="form-group">	
	       				 <div class="col-md-10 col-sm-6 col-xs-12">
       						 <aui:input name="city" label="city" cssClass="form-control col-md-7 col-xs-12" value="${campus.city }">
					    	 	<aui:validator name="required" />
					    	 	<aui:validator name="maxLength">20</aui:validator>
						 	</aui:input>
       					</div>
       				</div>	
       				<div class="form-group">	
	       				 <div class="col-md-10 col-sm-6 col-xs-12">
						 	<aui:select name="state" label="state" cssClass="form-control col-md-7 col-xs-12">
	               				<c:forEach items="${usStateList }" var="state">
	               					<aui:option value="${state }" selected='${state eq campus.state ? true : false }'>${state }</aui:option>
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
       						 <aui:input name="contactNumber" label="Campus Contact Number" cssClass="form-control col-md-7 col-xs-12" value="${campus.contactNumber }">
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
						 	<aui:input name="websiteLink" label="Web site Link" cssClass="form-control col-md-7 col-xs-12" value="${campus.websiteLink }">
					     		<aui:validator name="required" />
					     		<aui:validator name="maxLength">70</aui:validator>
						 	</aui:input>
       					</div>
       				</div>
       				<div class="form-group">	
	       				 <div class="col-md-10 col-sm-6 col-xs-12">
       						 <aui:input name="contactPersonName" label="Contact Person Name" cssClass="form-control col-md-7 col-xs-12" value="${campus.contactPersonName }">
					    	 	<aui:validator name="required" />
					    	 	<aui:validator name="maxLength">40</aui:validator>
						 	</aui:input>
       					</div>
       				</div>
       				<div class="form-group">	
	       				 <div class="col-md-10 col-sm-6 col-xs-12">
       						 <aui:input name="contactPersonPhoneNumber" label="Contact Person Phone Number" cssClass="form-control col-md-7 col-xs-12" value="${campus.contactPersonPhoneNumber }" placeholder="xxx-xxx-xxxx">
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
       						 <aui:input name="contactPersonEmail" label="Contact Person Email" cssClass="form-control col-md-7 col-xs-12" value="${campus.contactPersonEmail }">
					    	 	<aui:validator name="required" />
					    	 	<aui:validator name="email" />
					    	 	<aui:validator name="maxLength">30</aui:validator>
						 	</aui:input>
       					</div>
       				</div>
       				<div class="ln_solid"></div>
					 <div class="form-group">
				         <div class="col-md-10 col-sm-6 col-xs-12 col-md-offset-3">
							<aui:button type="button" value="Submit"  cssClass="addCampusBtn btn btn-success"/>
							<a href="/group/medicus/campuses" class="btn btn-primary btn-xs">  Cancel </a>
						</div>
					</div>
					<aui:input type="hidden"  name="campusId" value="${campus.campusId }"/>
       			</aui:form>
       		</div>
        </div>
   </div>
</div>	
<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';
AUI().use('aui-base','aui-form-validator', function(A) {
	var addCampusBtn= A.one(".addCampusBtn");
	addCampusBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addcampusFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />addcampusFm.submit();
		}
	});
});
</aui:script>