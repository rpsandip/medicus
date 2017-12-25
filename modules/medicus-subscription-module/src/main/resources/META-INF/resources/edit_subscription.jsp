<%@ include file="/init.jsp" %>

<portlet:actionURL var="editSubscriptionURL" name="/edit_subscription">
</portlet:actionURL>

<div class="page-title">
   <div class="title_left">
     <h2>Edit Subscription</h2>
   </div>
 </div>
 <div class="clearfix"></div>
 
 <liferay-ui:error key="subscription-update-error" message="subscription-update-error"/>
 
 
 <div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_content">
	   			<br />
       			<aui:form name="editSubscriptionFm" action="${editSubscriptionURL}" cssClass="form-horizontal form-label-left">
	       			<div class="form-group">	
	       				 <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="name" label="Name" cssClass="form-control col-md-7 col-xs-12" value="${subscription.name }" readonly="true">
							 </aui:input>
						</div>	 
					</div>	
       				<div class="form-group">	
	       				 <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="price" label="Price" cssClass="form-control col-md-7 col-xs-12" value="${subscription.price }">
						     	<aui:validator name="required" />
						     	<aui:validator name="number" />
							 </aui:input>
						</div>	 
       				</div>
       				<div class="form-group">	
	       				 <div class="col-md-10 col-sm-6 col-xs-12">
       						 <aui:input name="noOfStudents" label="No. Of Students" cssClass="form-control col-md-7 col-xs-12" value="${subscription.noOfStudents }">
					     		<aui:validator name="required" />
					     		<aui:validator name="number" />
						 	</aui:input>
						</div>
					</div>
       				<div class="ln_solid"></div>
					 <div class="form-group">
				         <div class="col-md-10 col-sm-6 col-xs-12 col-md-offset-3">
							<aui:button type="button" value="Submit"  cssClass="editSubscriptionBtn btn btn-success"/>
						</div>
					</div>
					<aui:input type="hidden"  name="subscriptionId" value="${subscription.subscriptionId }"/>
       			</aui:form>
       		</div>
        </div>
   </div>
</div>	
<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';
AUI().use('aui-base','aui-form-validator', function(A) {
	var editSubscriptionBtn= A.one(".editSubscriptionBtn");
	editSubscriptionBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />editSubscriptionFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />editSubscriptionFm.submit();
		}
	});
});
</aui:script>