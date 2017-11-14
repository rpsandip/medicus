<%@ include file="/init.jsp" %>

<portlet:renderURL var="addUserURL">
        <portlet:param name="mvcRenderCommandName" value="/add_user" />
</portlet:renderURL>

<liferay-ui:success key="user-create-success" message="user-create-success"/>
<liferay-ui:error key="user-create-error" message="user-create-error"/>
<liferay-ui:success key="user-update-success" message="user-update-success"/>
<liferay-ui:error key="user-update-error" message="user-update-error"/>
<liferay-ui:error key="user-exist" message="user-exist"/>



<div class="page-title">
  <div class="title_left">
    <a href="${addUserURL}" class="btn btn-primary">Add User</a>
  </div>
</div>
<div class="clearfix"></div>
 <div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
      <div class="x_panel">
        <div class="x_content">
		   <table id="datatable" class="table table-striped">
					<thead>
			            <tr>
			                <th>First Name</th>
			                <th>Last Name</th>
			                <th>Email Address</th>
			                <th>Contact Number</th>
			                <th>School</th>
			                <th>Campus</th>
			                <th>Role</th>
			                <th>Actions</th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${medicusUserBeanList }" var="medicusUserBean">
            			<tr>
			                <td>${medicusUserBean.firstName }</td>
			                <td>${medicusUserBean.lastName }</td>
			                <td>${medicusUserBean.emailAddress }</td>
			                <td>${medicusUserBean.contactNum }</td>
			                <td>${medicusUserBean.school }</td>
			                <td>${medicusUserBean.campus }</td>
			                <td>${medicusUserBean.role }</td>
			                <portlet:renderURL var="editUserURL">
       							 <portlet:param name="mvcRenderCommandName" value="/edit_user" />
       							 <portlet:param name="userId" value="${ medicusUserBean.user.userId}" />
							</portlet:renderURL>
			                <td>
			                	<a href="${editUserURL }" class="btn btn-block btn-primary">Edit</a>
			                </td> 
        			    </tr>
           			</c:forEach>
           			</tbody>
				</table>
            </div>
        </div>
     </div>
  </div>
