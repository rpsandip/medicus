<%@ include file="/init.jsp" %>

<portlet:actionURL var="registerEmployerURL" name="/register-user">
</portlet:actionURL>

<liferay-ui:error key="err-register-user" message="err-register-user"/>
<liferay-ui:error key="user-exist" message="user-exist"/>
<liferay-ui:success key="user-register-success" message="user-register-success"/>
<liferay-ui:error key="medicus-organization-not-exist" message="medicus-organization-not-exist"/>

<ul class="nav navbar-nav navbar-right">
    <li class="">
     	<button class="btn btn-success" type="button" data-toggle="modal" data-target="#registrationform">Sign Up</button>
    </li>
  </ul>

<div id="registrationform" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">Sign Up</h4>
		      </div>
		      <div class="modal-body">

            <aui:form name="addEmployeeFm" action="${registerEmployerURL}" cssClass="form-horizontal form-label-left">
              <div class="form-group">
               	 <div class="col-md-6 col-sm-6 col-xs-12">
	               	<aui:input name="firstName" label="firstName" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">60</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  <div class="form-group">
               	 <div class="col-md-6 col-sm-6 col-xs-12">
	               	<aui:input name="lastName" label="lastName" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">60</aui:validator>
					 </aui:input>
				</div>
			  </div>
              <div class="form-group">
              		<div class="col-md-6 col-sm-6 col-xs-12">
		                 <aui:input name="emailAddress" label="emailAddress" cssClass="form-control col-md-7 col-xs-12">
					     	<aui:validator name="required" />
					     	<aui:validator name="maxLength">20</aui:validator>
						 </aui:input>
				 </div>
              </div>
               <div class="form-group">
              		<div class="col-md-6 col-sm-6 col-xs-12">
		                <aui:input  name="password" type="password" label="new.password">
		                  	<aui:validator name="required"></aui:validator>
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
              		<div class="col-md-6 col-sm-6 col-xs-12">
		              	<aui:input  name="password2" type="password" label="confirm.password">
		                 	<aui:validator name="required"></aui:validator>
							<aui:validator name="equalTo" errorMessage="err-valid-confirm-pw">'#<portlet:namespace />password'</aui:validator>
		                 </aui:input>
                 	</div>
              </div>
              <div class="form-group">
               	 <div class="col-md-6 col-sm-6 col-xs-12">
	               	<aui:input name="address1" label="address1" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">60</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  <div class="form-group">
               	 <div class="col-md-6 col-sm-6 col-xs-12">
	               	<aui:input name="address2" label="address2" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">60</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  
			  <div class="form-group">
               	 <div class="col-md-6 col-sm-6 col-xs-12">
	               	<aui:input name="zipcode" label="zipcode" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">8</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  
			  <div class="form-group">
               	 <div class="col-md-6 col-sm-6 col-xs-12">
	               	<aui:input name="city" label="city" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">20</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  
			  <div class="form-group">
               	 <div class="col-md-6 col-sm-6 col-xs-12">
	               	<aui:input name="state" label="state" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">20</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  
			  
			  <div class="form-group">
               	 <div class="col-md-6 col-sm-6 col-xs-12">
	               	<aui:input name="country" label="country" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">20</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  
			  
			  <div class="form-group">
               	 <div class="col-md-6 col-sm-6 col-xs-12">
	               	<aui:input name="contactPersonName" label="contactPersonName" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">60</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  
			  
			  <div class="form-group">
               	 <div class="col-md-6 col-sm-6 col-xs-12">
	               	<aui:input name="contactPersonEmail" label="contactPersonEmail" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">20</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  
			  
			  <div class="form-group">
               	 <div class="col-md-6 col-sm-6 col-xs-12">
	               	<aui:input name="contactPersonPhoneNumber" label="contactPersonPhoneNumber" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">12</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  
			  
			  <div class="form-group">
               	 <div class="col-md-6 col-sm-6 col-xs-12">
	               	<aui:input name="websiteLink" label="websiteLink" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="maxLength">30</aui:validator>
					 </aui:input>
				</div>
			  </div>
              
              <div class="ln_solid"></div>
              <div class="form-group">
	                 <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                		<aui:button type="button" value="Submit"  cssClass="registerUserBtn btn btn-success"/>
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
	var registerUserBtn= A.one(".registerUserBtn");
	registerUserBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addEmployeeFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />addEmployeeFm.submit();
		}
	});
});
</aui:script>      