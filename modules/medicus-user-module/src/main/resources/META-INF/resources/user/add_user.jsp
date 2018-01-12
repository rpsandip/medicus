<%@ include file="../init.jsp" %>
<portlet:resourceURL id="/getCampusDetail" var="getCampusDetailURL"></portlet:resourceURL>
<portlet:resourceURL id="/getSchoolDetail" var="getSchoolDetailURL"></portlet:resourceURL>
<portlet:actionURL var="createUserURL" name="/create_user">
</portlet:actionURL>


<div class="page-title">
  <div class="title_left">
    		<h2><liferay-ui:message key="add.user"/></h2> 
  </div>
</div>
<div class="clearfix"></div>
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_content">
       			<aui:form name="addUserFm" action="${createUserURL}" cssClass="form-horizontal form-label-left">
       			<div class="form-group">
      					 <div class="col-md-10 col-sm-6 col-xs-12">
       					 <aui:input name="firstName" label="firstName"  cssClass="form-control col-md-7 col-xs-12">
					     	<aui:validator name="required" />
					     	<aui:validator name="maxLength">30</aui:validator>
						 </aui:input>
					 </div>
				</div>	
				<div class="form-group">
      					 <div class="col-md-10 col-sm-6 col-xs-12">
       					 <aui:input name="lastName" label="lastName"  cssClass="form-control col-md-7 col-xs-12">
					     	<aui:validator name="maxLength">30</aui:validator>
						 </aui:input>
					 </div>
				</div>
				<div class="form-group">
      					 <div class="col-md-10 col-sm-6 col-xs-12">
       					 <aui:input name="emailAddress" label="emailAddress"  cssClass="form-control col-md-7 col-xs-12">
					     	<aui:validator name="required" />
					     	<aui:validator name="maxLength">30</aui:validator>
						 </aui:input>
					 </div>
				</div>	
				<div class="form-group">
      					 <div class="col-md-10 col-sm-6 col-xs-12">
       					 <aui:input name="contactNumber" label="contact.number"  cssClass="form-control col-md-7 col-xs-12" placeholder="xxx-xxx-xxxx">
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
   					 	<aui:select name="school" label="school *">
   					 		<aui:option value=""> Please Select School</aui:option>
   					 		<c:forEach items="${schoolList }" var="school">
   					 			<aui:option value="${school.schoolId }"> ${school.name }</aui:option>
   					 		</c:forEach>
   					 	</aui:select>
   					 </div>
      			</div>
      			<div class="form-group">
   					 <div class="col-md-10 col-sm-6 col-xs-12">
   					 	<aui:select name="campus" label="campus *">
   					 		<aui:option value=""> Please Select Campus</aui:option>
   					 	</aui:select>
   					 </div>
      			</div>
      			
      			<div class="form-group">
   					 <div class="col-md-10 col-sm-6 col-xs-12">
   					 	<aui:select name="role" label="role">
   					 		<aui:option value=""> Please Select Role</aui:option>
   					 	</aui:select>
   					 </div>
      			</div>		 
				 	 
       			<div class="ln_solid"></div>	
    				 <div class="form-group">
				        <div class="col-md-10 col-sm-6 col-xs-12 col-md-offset-3">
							<aui:button type="button" value="Submit"  cssClass="addUserBtn btn btn-success"/>
							<a href="/group/medicus/users" class="btn btn-primary btn-xs">  Cancel </a>
						</div>
					</div>
       			</aui:form>
       		</div>
        </div>
   </div>
</div>

<aui:script>

var pns =  '<portlet:namespace/>';
AUI().use('aui-io-request', 'aui-autocomplete' ,'aui-base','aui-form-validator','autocomplete-list','autocomplete-filters','autocomplete-highlighters', function(A) {
	
	
	var selectDropDownValidator = new A.FormValidator({
		boundingBox: document.<portlet:namespace/>addUserFm,
		rules: {
			<portlet:namespace/>school: {
				required: true
			},
			<portlet:namespace/>role: {
				required: true
			}
		},
		fieldStrings: {
			<portlet:namespace/>school: {
				required: 'Please select School'
				},
				<portlet:namespace/>role: {
				required: 'Please select Role'
			}
		}
	});
	
	var addUserBtn= A.one(".addUserBtn");
	addUserBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addUserFm').formValidator;
		formValidator.validate();
		selectDropDownValidator.validate();
		if(!formValidator.hasErrors() && !selectDropDownValidator.hasErrors()){
			document.<portlet:namespace />addUserFm.submit();
		}
	});
	
	
	
	var schoolSelect = A.one("#"+pns+"school");
	
	schoolSelect.on('change', function(e) {
		
		console.log("schoolId->" + this.get('value'));
		var getSchoolDetailURL = '${getSchoolDetailURL}';
		
		A.io.request(getSchoolDetailURL.toString(),{
			dataType: 'json',
			method: 'GET',
			data :{
				'<portlet:namespace/>schoolId' : this.get('value')
			},
			on: {
			success: function() {
				A.one('#'+pns+'campus').all('option').remove();
				A.one('#'+pns+'role').all('option').remove();
				var schoolDetail=this.get('responseData');
				console.log("school cusssss");
				A.one('#'+pns+'campus').append("<option  value='' >Please Select Campus</option> ");
				for(var i in schoolDetail.campuses){
					  if(i==0){
					  	A.one('#'+pns+'campus').append("<option selected='selected' value='"+ schoolDetail.campuses[i].campusId +"' >"+ schoolDetail.campuses[i].name +"</option> ");
					  }else{
						  A.one('#'+pns+'campus').append("<option  value='"+ schoolDetail.campuses[i].campusId +"' >"+ schoolDetail.campuses[i].name +"</option> ");
					  }
				}
				A.one('#'+pns+'role').append("<option  value='' >Please Select Role</option> ");
				for(var i in schoolDetail.roles){
					if(i==0){  
						A.one('#'+pns+'role').append("<option selected='selected' value='"+ schoolDetail.roles[i].roleId +"' >"+ schoolDetail.roles[i].name +"</option> ");
					}else{
						A.one('#'+pns+'role').append("<option  value='"+ schoolDetail.roles[i].roleId +"' >"+ schoolDetail.roles[i].name +"</option> ");
					}
				}
			}
		  }
		
		});
	});
	
	var campusSelect = A.one("#"+pns+"campus");
	var getCampusDetailURL = '${getCampusDetailURL}';
	campusSelect.on('change', function(e) {
		A.io.request(getCampusDetailURL.toString(),{
			dataType: 'json',
			method: 'GET',
			data :{
				'<portlet:namespace/>campusId' : this.get('value')
			},
			on: {
			success: function() {
				A.one('#'+pns+'role').all('option').remove();
				var campusDetail=this.get('responseData');
				console.log("campus cusssss" + campusDetail.roles.length);
				A.one('#'+pns+'role').append("<option  value='' >Please Select Role</option> ");
				for(var i in campusDetail.roles){
					if(i==0){  
					   A.one('#'+pns+'role').append("<option  selected='selected' value='"+ campusDetail.roles[i].roleId +"' >"+ campusDetail.roles[i].name +"</option> ");
					}else{
						A.one('#'+pns+'role').append("<option  value='"+ campusDetail.roles[i].roleId +"' >"+ campusDetail.roles[i].name +"</option> ");
					}
				}
			}
		  }
		
		});
	});
});
</aui:script>  