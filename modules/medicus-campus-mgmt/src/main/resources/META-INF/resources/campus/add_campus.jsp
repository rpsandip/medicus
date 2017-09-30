<%@ include file="../init.jsp" %>

<portlet:actionURL var="addCampusURL" name="/add_campus">
</portlet:actionURL>
 
<div class="page-title">
   <div class="title_left">
     <c:choose>
	<c:when test="${ campus.campusId gt 0}">
		<h2>
    		<liferay-ui:message key="edit.campus"/> 
  		</h2>
	</c:when>
	<c:otherwise>
		<h2>
    		<liferay-ui:message key="add.campus"/> 
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
	       				 <div class="col-md-6 col-sm-6 col-xs-12">
	       					 <aui:select name="schoolId" label="Select School" cssClass="form-control">
						     	<c:forEach items="${schoolList }" var="school">
						     		<aui:option value="${school.schoolId }" selected='${school.schoolId eq campus.schoolId ? true : false }'> ${school.name }</aui:option>
						     	</c:forEach>
							 </aui:select>
						</div>	 
					</div>	
       				<div class="form-group">	
	       				 <div class="col-md-6 col-sm-6 col-xs-12">
	       					 <aui:input name="name" label="name" cssClass="form-control col-md-7 col-xs-12" value="${campus.name }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">70</aui:validator>
							 </aui:input>
						</div>	 
       				</div>
       				<div class="form-group">	
	       				 <div class="col-md-6 col-sm-6 col-xs-12">
       						 <aui:input name="address1" label="address1" cssClass="form-control col-md-7 col-xs-12" value="${campus.address1 }">
					     		<aui:validator name="required" />
					     		<aui:validator name="maxLength">70</aui:validator>
						 	</aui:input>
						</div>
					</div>
					<div class="form-group">	
	       				 <div class="col-md-6 col-sm-6 col-xs-12">
	       				 	 <aui:input name="address2" label="address2" cssClass="form-control col-md-7 col-xs-12" value="${campus.address2 }">
					     		<aui:validator name="required" />
					     		<aui:validator name="maxLength">70</aui:validator>
						 	</aui:input>
       					</div>
       				</div>
       				<div class="form-group">	
	       				 <div class="col-md-6 col-sm-6 col-xs-12">
       						 <aui:input name="city" label="city" cssClass="form-control col-md-7 col-xs-12" value="${campus.city }">
					    	 	<aui:validator name="required" />
					    	 	<aui:validator name="maxLength">20</aui:validator>
						 	</aui:input>
       					</div>
       				</div>	
       				<div class="form-group">	
	       				 <div class="col-md-6 col-sm-6 col-xs-12">
	       				 	<aui:input name="state" label="state" cssClass="form-control col-md-7 col-xs-12" value="${campus.state }">
					    	 	<aui:validator name="required" />
					    	 	<aui:validator name="maxLength">20</aui:validator>
						 	</aui:input>
       					</div>
       				</div>	
       				<div class="form-group">	
	       				 <div class="col-md-6 col-sm-6 col-xs-12">
       						 <aui:input name="country" label="country" cssClass="form-control col-md-7 col-xs-12" value="${campus.country }">
					    	 	<aui:validator name="required" />
					    	 	<aui:validator name="maxLength">20</aui:validator>
						 	</aui:input>
       					</div>
       				</div>
       				<div class="form-group">	
	       				 <div class="col-md-6 col-sm-6 col-xs-12">
       						 <aui:input name="contactNumber" label="campus.contact.no" cssClass="form-control col-md-7 col-xs-12" value="${campus.contactNumber }">
					     		<aui:validator name="required" />
                               <aui:validator name="maxLength">12</aui:validator>
						 	</aui:input>
						</div>
					</div>	
					<div class="form-group">	
	       				 <div class="col-md-6 col-sm-6 col-xs-12">
						 	<aui:input name="websiteLink" label="websiteLink" cssClass="form-control col-md-7 col-xs-12" value="${campus.websiteLink }">
					     		<aui:validator name="required" />
					     		<aui:validator name="maxLength">70</aui:validator>
						 	</aui:input>
       					</div>
       				</div>
       				<div class="form-group">	
	       				 <div class="col-md-6 col-sm-6 col-xs-12">
       						 <aui:input name="contactPersonName" label="contactPersonName" cssClass="form-control col-md-7 col-xs-12" value="${campus.contactPersonName }">
					    	 	<aui:validator name="required" />
					    	 	<aui:validator name="maxLength">40</aui:validator>
						 	</aui:input>
       					</div>
       				</div>
       				<div class="form-group">	
	       				 <div class="col-md-6 col-sm-6 col-xs-12">
       						 <aui:input name="contactPersonPhoneNumber" label="contactPersonPhoneNumber" cssClass="form-control col-md-7 col-xs-12" value="${campus.contactPersonPhoneNumber }" placeholder="xxx-xxx-xxxx">
					    	 	<aui:validator name="required" />
					    	 	<aui:validator name="maxLength">12</aui:validator>
						 	</aui:input>
       					</div>
       				</div>	
       				<div class="form-group">	
	       				 <div class="col-md-6 col-sm-6 col-xs-12">
       						 <aui:input name="contactPersonEmail" label="contactPersonEmail" cssClass="form-control col-md-7 col-xs-12" value="${campus.contactPersonEmail }">
					    	 	<aui:validator name="required" />
					    	 	<aui:validator name="email" />
					    	 	<aui:validator name="maxLength">30</aui:validator>
						 	</aui:input>
       					</div>
       				</div>
       				<div class="ln_solid"></div>
					 <div class="form-group">
				         <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
							<aui:button type="button" value="Submit"  cssClass="addCampusBtn btn btn-success"/>
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