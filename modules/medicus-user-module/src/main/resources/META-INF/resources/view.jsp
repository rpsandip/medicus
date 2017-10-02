<%@ include file="/init.jsp" %>

<portlet:renderURL var="addUserURL">
        <portlet:param name="mvcRenderCommandName" value="/add_user" />
</portlet:renderURL>

<liferay-ui:success key="user-create-success" message="user-create-success"/>
<liferay-ui:error key="user-create-error" message="user-create-error"/>

<div class="page-title">
  <div class="title_left">
    <a href="${addUserURL}" class="btn btn-primary">Add User</a>
  </div>
</div>