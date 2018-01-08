<%@ include file="/init.jsp" %>

<portlet:renderURL var="addUserURL">
        <portlet:param name="mvcRenderCommandName" value="/add_user" />
</portlet:renderURL>

<portlet:actionURL var="deleteUserURL" name="/delete_user">
</portlet:actionURL>

<liferay-ui:success key="user-create-success" message="user-create-success"/>
<liferay-ui:error key="user-create-error" message="user-create-error"/>
<liferay-ui:success key="user-update-success" message="user-update-success"/>
<liferay-ui:error key="user-update-error" message="user-update-error"/>
<liferay-ui:error key="user-exist" message="user-exist"/>
<liferay-ui:success key="user-delete-success" message="user-delete-success"/>
<liferay-ui:error key="user-delete-error" message="user-delete-error"/>


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
			                 <th>Status</th>
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
			                <td>${medicusUserBean.user.status eq 0 ? "Active" : "Inactive" }</td>
			                <portlet:renderURL var="editUserURL">
       							 <portlet:param name="mvcRenderCommandName" value="/edit_user" />
       							 <portlet:param name="userId" value="${ medicusUserBean.user.userId}" />
							</portlet:renderURL>
			                <td>
			                	<a href="${editUserURL }" class="btn btn-block btn-primary">Edit</a>
			                	<a class="btn btn-primary" data-userId="${medicusUserBean.user.userId }" data-userName="${ medicusUserBean.firstName} ${ medicusUserBean.lastName }"  data-toggle="modal" data-target="#delete-user">Delete</a>
			                </td> 
        			    </tr>
           			</c:forEach>
           			</tbody>
				</table>
            </div>
        </div>
     </div>
  </div>
  <div id="delete-user" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Delete User</h4>
        <div class="msg">
        	
        </div>
      </div>
      <div class="modal-body">
       	<div class="form-group">
       	   <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
       	   		Are you sure you want to Delete <span class="user-name"></span> User?
       	   </div>
       	   <br/>
       	   <aui:form name="deleteUser" action="${deleteUserURL}" cssClass="form-horizontal form-label-left">
	       	   <div class="col-md-8 col-sm-6 col-xs-12 col-md-offset-3 approve-request-box">
	       	   		<aui:input type="hidden" name="userId"/>
	       	   		<aui:input type="hidden" name="userName"/>
	       	   </div>
	           <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
	           		<aui:button type="submit" value="Yes"  cssClass="btn btn-success"/>
	                <button type="button" class="btn btn-primary" data-dismiss="modal">No</button>
	           </div>
           </aui:form>
         </div>
      </div>
    </div>
  </div>
</div>
  <script>
 jQuery.noConflict();
    (function($) {
      $(function() {
    	  AUI().use('aui-io-request', 'aui-autocomplete','liferay-portlet-url' ,'aui-base','aui-form-validator','autocomplete-list','autocomplete-filters','autocomplete-highlighters','node-event-simulate', function(A) {
    		  
    		  $('#delete-user').on('show.bs.modal', function(e) {
    			  //get data-id attribute of the clicked element
    			  var userId = $(e.relatedTarget).data('userid');
    			  var userName = $(e.relatedTarget).data('username');

    			  $(e.currentTarget).find('#<portlet:namespace />userId').val(userId);
    			  $(e.currentTarget).find('.user-name').text(userName);
              });
    		    		  
    	  });
       });
   })(jQuery);
</script>
  
