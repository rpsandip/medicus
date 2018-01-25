<%@ include file="../init.jsp"%>
<portlet:actionURL var="editPartnerURL" name="/edit-partner">
</portlet:actionURL>

<liferay-ui:error key="partner-update-err" message="partner-update-err"/>
<liferay-ui:error key="partner-add-err" message="partner-add-err"/>


<div class="page-title">
	<div class="title_left">
		<h2>Edit Partner</h2>
	</div>
</div>
<div class="clearfix"></div>
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_content">
				<aui:form name="updatePartnerFm" action="${editPartnerURL}"
					cssClass="form-horizontal form-label-left">
					<div class="form-group">
						<div class="col-md-10 col-sm-6 col-xs-12">
							<aui:input name="firstName" label="facility"
								value="${partnerBean.firstName }"
								cssClass="form-control col-md-7 col-xs-12">
								<aui:validator name="required" />
								<aui:validator name="maxLength">60</aui:validator>
							</aui:input>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10 col-sm-6 col-xs-12">
							<c:if test="${partnerId gt 0 }">
								<aui:input name="emailAddress" label="emailAddress"
									value="${partnerBean.emailAddress }"
									cssClass="form-control col-md-7 col-xs-12" readonly="true">
									<aui:validator name="required" />
									<aui:validator name="maxLength">50</aui:validator>
								</aui:input>
							</c:if>
							<c:if test="${partnerId eq 0 }">
								<aui:input name="emailAddress" label="emailAddress"
									value="${partnerBean.emailAddress }"
									cssClass="form-control col-md-7 col-xs-12">
									<aui:validator name="required" />
									<aui:validator name="maxLength">50</aui:validator>
								</aui:input>
							</c:if>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10 col-sm-6 col-xs-12">
							<aui:input name="address1" label="address1"
							    value="${partnerBean.address1 }"
								cssClass="form-control col-md-7 col-xs-12">
								<aui:validator name="required" />
								<aui:validator name="maxLength">60</aui:validator>
							</aui:input>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10 col-sm-6 col-xs-12">
							<aui:input name="zipcode" label="zipcode"
								 value="${partnerBean.zipcode }"
								cssClass="form-control col-md-7 col-xs-12">
								<aui:validator name="required" />
								<aui:validator name="maxLength">6</aui:validator>
							</aui:input>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-10 col-sm-6 col-xs-12">
							<aui:input name="city" label="city"
								 value="${partnerBean.city }"
								cssClass="form-control col-md-7 col-xs-12">
								<aui:validator name="required" />
								<aui:validator name="maxLength">50</aui:validator>
							</aui:input>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-10 col-sm-6 col-xs-12">
							<aui:select name="state" label="state"
								cssClass="form-control col-md-7 col-xs-12">
								<c:forEach items="${usStateList }" var="state">
									<aui:option value="${state }" selected="${state eq partnerBean.state ? true:false }">${state }</aui:option>
								</c:forEach>
							</aui:select>
						</div>
					</div>


					<div class="form-group">
						<div class="col-md-10 col-sm-6 col-xs-12">
							<aui:input name="country" label="country"
								cssClass="form-control col-md-7 col-xs-12" value="US" 
								readonly="true">
								<aui:validator name="required" />
								<aui:validator name="maxLength">50</aui:validator>
							</aui:input>
						</div>
					</div>


					<div class="form-group">
						<div class="col-md-10 col-sm-6 col-xs-12">
							<aui:input name="contactPersonName" label="contactPersonName"
								value="${partnerBean.contactPersonName }"
								cssClass="form-control col-md-7 col-xs-12">
								<aui:validator name="maxLength">60</aui:validator>
							</aui:input>
						</div>
					</div>


					<div class="form-group">
						<div class="col-md-10 col-sm-6 col-xs-12">
							<aui:input name="contactPersonEmail" label="contactPersonEmail"
								value="${partnerBean.contactPersonEmail }"
								cssClass="form-control col-md-7 col-xs-12">
								<aui:validator name="email"></aui:validator>
								<aui:validator name="maxLength">50</aui:validator>
							</aui:input>
						</div>
					</div>


					<div class="form-group">
						<div class="col-md-10 col-sm-6 col-xs-12">
							<aui:input name="contactPersonPhoneNumber"
								value="${partnerBean.contactPersonPhoneNumber }"
								label="contactPersonPhoneNumber"
								cssClass="form-control col-md-7 col-xs-12"
								placeholder="xxx-xxx-xxxx">
								<aui:validator name="maxLength">14</aui:validator>
							</aui:input>
						</div>
					</div>


					<div class="form-group">
						<div class="col-md-10 col-sm-6 col-xs-12">
							<aui:input name="websiteLink" label="websiteLink"
								value="${partnerBean.websiteLink }"
								cssClass="form-control col-md-7 col-xs-12">
								<aui:validator name="maxLength">200</aui:validator>
							</aui:input>
						</div>
					</div>

					<div class="ln_solid"></div>
					<div class="form-group">
						<div class="col-md-10 col-sm-6 col-xs-12 col-md-offset-3">
							<aui:button type="button" value="Submit"
								cssClass="registerUserBtn btn btn-success" />
							<a href="/group/medicus/partners" class="btn btn-primary btn-xs">  Cancel </a>	
						</div>
					</div>
					<aui:input name="partnerId" value="${partnerId }" type="hidden"></aui:input>
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
		var formValidator = Liferay.Form.get('<portlet:namespace />updatePartnerFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />updatePartnerFm.submit();
		}
	});
	
	new Formatter(document.getElementById('<portlet:namespace/>'+'contactPersonPhoneNumber'), {
		'pattern': '({{999}})-{{999}}-{{9999}}',
		'persistent': false
	});
});
</aui:script> 