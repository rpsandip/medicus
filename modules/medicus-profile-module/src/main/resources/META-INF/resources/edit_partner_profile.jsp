<%@ include file="/init.jsp" %>

<portlet:actionURL var="editProfileURL" name="/edit-profile">
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
            <aui:form name="editprofilefm" action="${editProfileURL}" cssClass="form-horizontal form-label-left"  enctype="multipart/form-data">
              <div class="form-group">
               	 <div class="col-md-10 col-sm-6 col-xs-12">
	               	<aui:input name="firstName" label="Name of Company" value="${partnerBean.firstName }" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">60</aui:validator>
					 </aui:input>
				</div>
			  </div>
              <div class="form-group">
              		<div class="col-md-10 col-sm-6 col-xs-12">
		                 <aui:input name="emailAddress" label="emailAddress" value="${partnerBean.emailAddress }"  cssClass="form-control col-md-7 col-xs-12" readonly="true">
					     	<aui:validator name="required" />
					     	<aui:validator name="maxLength">50</aui:validator>
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
                  <aui:input name="profilePic" type="file" label="Profile Picture/Logo (Max Size 1 MB )" cssClass="form-control col-md-7 col-xs-12">
                  		<aui:validator name="acceptFiles">'jpg,png,jpeg'</aui:validator>
                  </aui:input>
                </div>
              </div>
              <div class="form-group">
               	 <div class="col-md-10 col-sm-6 col-xs-12">
	               	<aui:input name="address1" label="address1" value="${partnerBean.address1 }"  cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">60</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  <div class="form-group">
               	 <div class="col-md-10 col-sm-6 col-xs-12">
	               	<aui:input name="zipcode" label="zipcode" value="${partnerBean.zipcode }"  cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">8</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  
			  <div class="form-group">
               	 <div class="col-md-10 col-sm-6 col-xs-12">
	               	<aui:input name="city" label="city"  value="${partnerBean.city }" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="required" />
				     	<aui:validator name="maxLength">50</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  
			  <div class="form-group">
               	 <div class="col-md-10 col-sm-6 col-xs-12">
	               	<aui:select name="state" label="state" cssClass="form-control col-md-7 col-xs-12">
	               		<c:forEach items="${usStateList }" var="state">
	               			<aui:option value="${state }" selected="${partnerBean.state eq state}">${state }</aui:option>
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
	               	<aui:input name="contactPersonName" label="contactPersonName"  value="${partnerBean.contactPersonName }" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="maxLength">60</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  
			  
			  <div class="form-group">
               	 <div class="col-md-10 col-sm-6 col-xs-12">
	               	<aui:input name="contactPersonEmail" label="contactPersonEmail" value="${partnerBean.contactPersonEmail }" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="maxLength">50</aui:validator>
					 	<aui:validator name="email"></aui:validator>
					 </aui:input>
				</div>
			  </div>
			  
			  
			  <div class="form-group">
               	 <div class="col-md-10 col-sm-6 col-xs-12">
	               	<aui:input name="contactPersonPhoneNumber" label="contactPersonPhoneNumber" value="${partnerBean.contactPersonPhoneNumber }" cssClass="form-control col-md-7 col-xs-12" placeholder="xxx-xxx-xxxx">
				     	<aui:validator name="maxLength">14</aui:validator>
					 </aui:input>
				</div>
			  </div>
			  
			  
			  <div class="form-group">
               	 <div class="col-md-10 col-sm-6 col-xs-12">
	               	<aui:input name="websiteLink" label="websiteLink" value="${partnerBean.websiteLink }" cssClass="form-control col-md-7 col-xs-12">
				     	<aui:validator name="maxLength">50</aui:validator>
					 </aui:input>
				</div>
			  </div>
              
              <aui:input type="hidden" name="partnerId" value="${partnerBean.partnerId }"/>
              <div class="ln_solid"></div>
              <div class="form-group">
	                 <div class="col-xs-12" style="    left: 20%;">
                		<aui:button type="button" value="Submit"  cssClass="editProfileBtn btn btn-success"/>
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
	var editProfileBtn= A.one(".editProfileBtn");
	editProfileBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />editprofilefm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />editprofilefm.submit();
		}
	});
	
	new Formatter(document.getElementById('<portlet:namespace/>'+'contactPersonPhoneNumber'), {
		'pattern': '({{999}})-{{999}}-{{9999}}',
		'persistent': false
	});
});
</aui:script>