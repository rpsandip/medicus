<%@ include file="/init.jsp" %>

<portlet:actionURL var="editSchooUserProfileURL" name="edit-school-user-profile">
</portlet:actionURL>

<liferay-ui:error key="profile-update-error" message="profile-update-error"/>
<liferay-ui:success key="profile-update-success" message="profile-update-success"/>

<div class="page-title">
   <div class="title_left">
    	<h2>Edit Profile</h2>
   </div>
 </div>
  <div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_content">
            <aui:form name="addUserFm" action="${editSchooUserProfileURL}" cssClass="form-horizontal form-label-left"  enctype="multipart/form-data">
       			<div class="form-group">
      					 <div class="col-md-10 col-sm-6 col-xs-12">
       					 <aui:input name="firstName" label="firstName"  cssClass="form-control col-md-7 col-xs-12" value="${schoolUserBean.firstName }">
					     	<aui:validator name="required" />
					     	<aui:validator name="maxLength">30</aui:validator>
						 </aui:input>
					 </div>
				</div>	
				<div class="form-group">
      					 <div class="col-md-10 col-sm-6 col-xs-12">
       					 <aui:input name="lastName" label="lastName"  cssClass="form-control col-md-7 col-xs-12" value="${schoolUserBean.lastName }">
					     	<aui:validator name="required" />
					     	<aui:validator name="maxLength">30</aui:validator>
						 </aui:input>
					 </div>
				</div>
				<div class="form-group">
      					 <div class="col-md-10 col-sm-6 col-xs-12">
       					 <aui:input name="emailAddress" label="emailAddress"  cssClass="form-control col-md-7 col-xs-12" value="${schoolUserBean.emailAddress }" readonly="true">
					     	<aui:validator name="required" />
					     	<aui:validator name="maxLength">50</aui:validator>
						 </aui:input>
					 </div>
				</div>	
				<div class="form-group">
      					 <div class="col-md-10 col-sm-6 col-xs-12">
       					 <aui:input name="contactNumber" label="contact.number"  cssClass="form-control col-md-7 col-xs-12" value="${schoolUserBean.contactNum }">
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
		                <aui:input  name="password" type="password" label="new.password" placeholder="Min 8 chars(1 Num 1 UC, 1 LC)">
							<aui:validator name="minLength" errorMessage="err-valid-pw-low-range">8</aui:validator>
							<aui:validator name="custom" errorMessage="err-valid-pw-policy">
									function(val, fieldNode, ruleValue) {
				             			var passwordPattern = new RegExp("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])");
				            			return passwordPattern.test(val);
									}
				         	</aui:validator>
		                  </aui:input>
              	</div>
              </div>
              <div class="form-group">
              		<div class="col-md-10 col-sm-6 col-xs-12">
		              	<aui:input  name="password2" type="password" label="confirm.password" placeholder="Min 8 chars(1 Num 1 UC, 1 LC)">
							<aui:validator name="equalTo" errorMessage="err-valid-confirm-pw">'#<portlet:namespace />password'</aui:validator>
		                 </aui:input>
                 	</div>
              </div>
              <div class="form-group">
                <div class="col-md-10 col-sm-6 col-xs-12">
                  <aui:input name="profilePic" type="file" label="Profile Picture/Logo (Max Size 1 MB)" cssClass="form-control col-md-7 col-xs-12">
                  		<aui:validator name="acceptFiles">'jpg,png,jpeg'</aui:validator>
                  </aui:input>
                </div>
              </div>
			  <div class="ln_solid"></div>	
   				 <div class="form-group">
			        <div class="col-xs-12" style="    left: 20%;">
						<aui:button type="button" value="Submit"  cssClass="addUserBtn btn btn-success"/>
					</div>
				</div>
			</aui:form>	
          </div>
         </div>
       </div>
     </div>     
         
<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';
AUI().use('aui-base','aui-form-validator', function(A) {
	var addUserBtn= A.one(".addUserBtn");
	addUserBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addUserFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />addUserFm.submit();
		}
	});
});
</aui:script>