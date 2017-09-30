<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/init.jsp" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages" %>

<%
SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		 HttpServletRequest httpRequest =
			        PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		
		 String customMessage = httpRequest.getParameter("message");
		 
		 if(null !=customMessage  && customMessage.equals("user-registration")){
			 SessionMessages.add(renderRequest, "user.registration.success");		
		 }
%>
<liferay-ui:success key="user.registration.success" message="Registration Done Successfully, Please login"/>
<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">

		<%
		String signedInAs = HtmlUtil.escape(user.getFullName());

		if (themeDisplay.isShowMyAccountIcon() && (themeDisplay.getURLMyAccount() != null)) {
			String myAccountURL = String.valueOf(themeDisplay.getURLMyAccount());

			signedInAs = "<a class=\"signed-in\" href=\"" + HtmlUtil.escape(myAccountURL) + "\">" + signedInAs + "</a>";
		}
		%>

		<liferay-ui:message arguments="<%= signedInAs %>" key="you-are-signed-in-as-x" translateArguments="<%= false %>" />
	</c:when>
	<c:otherwise>

		<%
		String formName = "loginForm";

		if (windowState.equals(LiferayWindowState.EXCLUSIVE)) {
			formName += "Modal";
		}

		String redirect = ParamUtil.getString(request, "redirect");

		String login = LoginUtil.getLogin(request, "login", company);
		String password = StringPool.BLANK;
		boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");

		if (Validator.isNull(authType)) {
			authType = company.getAuthType();
		}
		%>

		<portlet:actionURL name="/login/login" secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="loginURL">
			<portlet:param name="mvcRenderCommandName" value="/login/login" />
		</portlet:actionURL>
		
			<aui:form action="<%= loginURL %>" autocomplete='<%= PropsValues.COMPANY_SECURITY_LOGIN_FORM_AUTOCOMPLETE ? "on" : "off" %>' cssClass="form-horizontal form-label-left" method="post" name="<%= formName %>" onSubmit="event.preventDefault();">
			<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
			<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
			<aui:input name="doActionAfterLogin" type="hidden" value="<%= portletName.equals(PortletKeys.FAST_LOGIN) ? true : false %>" />

			<div class="inline-alert-container lfr-alert-container"></div>

			<c:choose>
				<c:when test='<%= SessionMessages.contains(request, "passwordSent") %>'>

					<div class="alert alert-success">
						<liferay-ui:message key="your-password-was-sent-to-the-provided-email-address" />
					</div>
				</c:when>
				<c:when test='<%= SessionMessages.contains(request, "userAdded") %>'>

					<%
					String userEmailAddress = (String)SessionMessages.get(request, "userAdded");
					String userPassword = (String)SessionMessages.get(request, "userAddedPassword");
					%>

					<div class="alert alert-success">
						<c:choose>
							<c:when test="<%= company.isStrangersVerify() || Validator.isNull(userPassword) %>">
								<liferay-ui:message key="thank-you-for-creating-an-account" />

								<c:if test="<%= company.isStrangersVerify() %>">
									<liferay-ui:message arguments="<%= userEmailAddress %>" key="your-email-verification-code-was-sent-to-x" translateArguments="<%= false %>" />
								</c:if>
							</c:when>
							<c:otherwise>
								<liferay-ui:message arguments="<%= userPassword %>" key="thank-you-for-creating-an-account.-your-password-is-x" translateArguments="<%= false %>" />
							</c:otherwise>
						</c:choose>

						<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED) %>">
							<liferay-ui:message arguments="<%= userEmailAddress %>" key="your-password-was-sent-to-x" translateArguments="<%= false %>" />
						</c:if>
					</div>
				</c:when>
				<c:when test='<%= SessionMessages.contains(request, "userPending") %>'>

					<%
					String userEmailAddress = (String)SessionMessages.get(request, "userPending");
					%>

					<div class="alert alert-success">
						<liferay-ui:message arguments="<%= userEmailAddress %>" key="thank-you-for-creating-an-account.-you-will-be-notified-via-email-at-x-when-your-account-has-been-approved" translateArguments="<%= false %>" />
					</div>
				</c:when>
			</c:choose>

			<liferay-ui:error exception="<%= AuthException.class %>" message="authentication-failed" />
			<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-log-in-because-the-maximum-number-of-users-has-been-reached" />
			<liferay-ui:error exception="<%= CookieNotSupportedException.class %>" message="authentication-failed-please-enable-browser-cookies" />
			<liferay-ui:error exception="<%= NoSuchUserException.class %>" message="authentication-failed" />
			<liferay-ui:error exception="<%= PasswordExpiredException.class %>" message="your-password-has-expired" />
			<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
			<liferay-ui:error exception="<%= UserLockoutException.LDAPLockout.class %>" message="this-account-is-locked" />

			<liferay-ui:error exception="<%= UserLockoutException.PasswordPolicyLockout.class %>">

				<%
				UserLockoutException.PasswordPolicyLockout ule = (UserLockoutException.PasswordPolicyLockout)errorException;
				%>

				<liferay-ui:message arguments="<%= ule.user.getUnlockDate() %>" key="this-account-is-locked-until-x" translateArguments="<%= false %>" />
			</liferay-ui:error>

			<liferay-ui:error exception="<%= UserPasswordException.class %>" message="authentication-failed" />
			<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" message="the-screen-name-cannot-be-blank" />

			<aui:fieldset>

				<%
				String loginLabel = null;

				if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
					loginLabel = "email-address";
				}
				else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
					loginLabel = "screen-name";
				}
				else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
					loginLabel = "id";
				}
				%>
				<div class="form-group">
				 <div class="col-md-6 col-sm-6 col-xs-12">
					<aui:input   cssClass="clearable form-control col-md-7 col-xs-12" label="<%= loginLabel %>" name="login" showRequiredLabel="<%= false %>" type="text" value="<%= login %>">
						<aui:validator name="required" />
					</aui:input>
				</div>
				</div>
				<div class="form-group">
					 <div class="col-md-6 col-sm-6 col-xs-12">
						<aui:input cssClass="form-control"  name="password" showRequiredLabel="<%= false %>" type="password" value="<%= password %>">
							<aui:validator name="required" />
						</aui:input>
					</div>
				</div>		
				 <div class="ln_solid"></div>

				<span id="<portlet:namespace />passwordCapsLockSpan" style="display: none;"><liferay-ui:message key="caps-lock-is-on" /></span>

				<%-- <c:if test="<%= company.isAutoLogin() && !PropsValues.SESSION_DISABLED %>">
					<aui:input checked="<%= rememberMe %>" name="rememberMe" type="checkbox" />
				</c:if> --%>
			</aui:fieldset>
			 <div class="form-group">
	                 <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
						<aui:button-row>
							<aui:button cssClass="btn-lg btn btn-default submit" type="submit" value="sign-in" />
						</aui:button-row>
					</div>
			</div>			
			</aui:form>

	<%-- <liferay-util:include page="/navigation.jsp" servletContext="<%= application %>" /> --%>

		<aui:script sandbox="<%= true %>">
			var form = AUI.$(document.<portlet:namespace /><%= formName %>);

			form.on(
				'submit',
				function(event) {
					<c:if test="<%= Validator.isNotNull(redirect) %>">
						var redirect = form.fm('redirect');

						if (redirect) {
							var redirectVal = redirect.val();

							redirect.val(redirectVal + window.location.hash);
						}
					</c:if>

					submitForm(form);
				}
			);

			form.fm('password').on(
				'keypress',
				function(event) {
					Liferay.Util.showCapsLock(event, '<portlet:namespace />passwordCapsLockSpan');
				}
			);
		</aui:script>
	</c:otherwise>
</c:choose>

<script>
jQuery.noConflict();
(function($) {
    $(function() {
    	$(".input-container").removeAttr("disabled");
    	$("#register-user").hide();
    	$("#new-account").on('click',function(){
    		console.log("sign up cliked");
    		$("#register-user").show();
    	});
    	
    	$(".portlet-decorate").removeClass("portlet-decorate");
    });
})(jQuery);
</script>

<!--  
<aui:script>
var userModuleNameSpace =  '<portlet:namespace/>';

console.log("before aja");

AUI().use('aui-io-request','liferay-portlet-url' ,'aui-base', function(A) {
	 var resourceURL = Liferay.PortletURL.createResourceURL();
	     resourceURL.setPortletId('com_example_portlet_MedicusRegistrationModulemvcportletPortlet');
	     resourceURL.setResourceId('/register-user');
	     resourceURL.setParameter('imagepath',"test");

	     console.log("url ->" + resourceURL.toString());
	     
	     A.io.request("/c/portal/layout?p_l_id=20146&p_p_cacheability=cacheLevelPage&p_p_id=com_example_portlet_MedicusRegistrationModulemvcportletPortlet&p_p_lifecycle=2&p_p_resource_id=%2Fregister-user&_com_example_portlet_MedicusRegistrationModulemvcportletPortlet_imagepath=test",{
				dataType: 'json',
				method: 'GET',
				on: {
				success: function() {
					console.log("jyy response");
				}
				}
			});    
});
</aui:script>

-->	