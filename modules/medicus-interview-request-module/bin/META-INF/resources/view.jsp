<%@page import="com.medicus.common.service.util.Interview_RequestStatus"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ include file="/init.jsp" %>

<portlet:actionURL var="approveRejectRequestURL" name="/approve_reject">
</portlet:actionURL>

<liferay-ui:error key="request-update-error" message="request-update-error"/>
<liferay-ui:success key="request-approve-success" message="request-approve-success"/>
<liferay-ui:success key="request-reject-success" message="request-reject-success"/>

 <liferay-ui:error key="error" message="Sorry, an error prevented savinyour greeting" />

<div class="page-title">
  <div class="title_left">
    <h2>Interview Request</h2>
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
			            	<th>Campus Name</th>
			            	<th>Student Name</th>
			                <th>Student Id</th>
			                <th>Partner</th>
			                <th>Requested Date</th>
			                <th>Action Date</th>
			                <th>Status</th>
			                <c:if test="${hasStudentInterviewRequestUpdatePermission }">
			               <th style="width: 20%;">Action</th>
			                </c:if>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${interviewRequestBeanList }" var="interviewRequestBean">
            			<tr>
            			    <td>${interviewRequestBean.campus.name}</td>
            				<td>${interviewRequestBean.student.firstName } ${interviewRequestBean.student.lastName }</td>
			                <td>${interviewRequestBean.student.stundetCampusId}</td>
			                <td>${interviewRequestBean.partnerBean.firstName} ${interviewRequestBean.partnerBean.lastName}</td>
			                <td>
			                <c:set var="status" value="${interviewRequestBean.status}"/>
			                <%
			                	String stauts="";
			                	if(Validator.isNotNull(Interview_RequestStatus.findByValue((int)pageContext.getAttribute("status")))){
			                		stauts = Interview_RequestStatus.findByValue((int)pageContext.getAttribute("status")).getLabel();
			                	}
			                %>
			                <%=stauts %>
			                </td>
			                <td>
			                 <fmt:formatDate pattern = "MM/dd/YYYY" value = "${interviewRequestBean.createDate}" var="requestDate" />
			                 ${requestDate }
			                </td>
			                <td>
			                <fmt:formatDate pattern = "MM/dd/YYYY" value = "${interviewRequestBean.modifiedDate}" var="actionDate" />
			                ${actionDate }
			                </td>
			                <c:if test="${hasStudentInterviewRequestUpdatePermission }">
				                <td style="width: 20%">
				                	<c:if test="<%=stauts.equals(Interview_RequestStatus.PENDING.getLabel()) %>">
				                			<a href="${editCampusURL }" class="btn btn-primary" data-partnerId="${interviewRequestBean.partnerId }"  data-studentId="${ interviewRequestBean.studentId}" data-toggle="modal" data-target="#approve-request-modal">Approve</a>
				                			<a href="${editCampusURL }" class="btn btn-primary" data-partnerId="${interviewRequestBean.partnerId }"  data-studentId="${ interviewRequestBean.studentId}" data-toggle="modal" data-target="#reject-request-modal">Reject</a>
				               		</c:if>
				                </td>
			                </c:if>
        			    </tr>
           			</c:forEach>
           			</tbody>
				</table>
            </div>
        </div>
     </div>
  </div>

<div id="approve-request-modal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Approve Interview Request</h4>
        <div class="msg">
        	
        </div>
      </div>
      <div class="modal-body">
       	<div class="form-group">
       	   <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
       	   		Are you sure you want to Approve Interview Request?
       	   </div>
       	   <br/>
	       <div class="col-md-8 col-sm-6 col-xs-12 col-md-offset-3 approve-request-box">
	       	   		<aui:input type="hidden" name="studentId"/>
       			    <aui:input type="hidden" name="partnerId"/>
       			     <aui:input type="hidden" name="action" value="approve"/>
	       </div>
	       <br/>
	       <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
           		<aui:button type="button" value="Yes"  cssClass="btn btn-success approve-btn"/>
                <button type="button" class="btn btn-primary" data-dismiss="modal">No</button>
	       </div>
         </div>
      </div>
    </div>
  </div>
</div>

<div id="reject-request-modal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Reject Interview Request</h4>
        <div class="msg">
        	
        </div>
      </div>
      <div class="modal-body">
       	<div class="form-group">
       	   <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
       	   		Are you sure you want to Reject Interview Request?
       	   </div>
       	   <br/>
       	   <aui:form name="approve-request" action="${approveRejectRequestURL}" cssClass="form-horizontal form-label-left">
	       	   <div class="col-md-8 col-sm-6 col-xs-12 col-md-offset-3 approve-request-box">
	       	   		<aui:input type="textarea" name="comment" />
	       	   		<aui:input type="hidden" name="studentId"/>
       			    <aui:input type="hidden" name="partnerId"/>
       			    <aui:input type="hidden" name="action" value="reject"/>
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
    		  
    		  $('#approve-request-modal').on('show.bs.modal', function(e) {
    			  //get data-id attribute of the clicked element
                  var studentId = $(e.relatedTarget).data('studentid');
    			  var partnerId = $(e.relatedTarget).data('partnerid');
    			  
                  //populate the textbox
                  $(e.currentTarget).find('#<portlet:namespace />studentId').val(studentId);
                  $(e.currentTarget).find('#<portlet:namespace />partnerId').val(partnerId);
              });
    		  
    		  $('#reject-request-modal').on('show.bs.modal', function(e) {
    			  //get data-id attribute of the clicked element
                  var studentId = $(e.relatedTarget).data('studentid');
    			  var partnerId = $(e.relatedTarget).data('partnerid');
    			  
                  //populate the textbox
                  $(e.currentTarget).find('#<portlet:namespace />studentId').val(studentId);
                  $(e.currentTarget).find('#<portlet:namespace />partnerId').val(partnerId);
              });

    		  $('.btn-success').on('click', function(e) {
    			  $('#approve-request-modal').modal('hide');
    			  $('#reject-request-modal').modal('hide');
    		  });
    		  
    		  
    		  A.one(".approve-btn").on('click', function(){
    			  var  renderURL = Liferay.PortletURL.createRenderURL();
    			  var plid = '${student_layout_plid}';
    			  renderURL.setParameter("mvcRenderCommandName","/add_student");
    			  renderURL.setParameter("studentId",A.one("#<portlet:namespace />studentId").get('value'));
    			  renderURL.setParameter("addExternship", true);
    			  renderURL.setParameter("approveInterviewRequest", true);
    			  renderURL.setParameter("inteviewRequestPartnerId", A.one("#<portlet:namespace />partnerId").get('value'));
    			  renderURL.setPlid(plid);
    			  renderURL.setPortletId('com_medicus_student_portlet_portlet_StudentModulePortlet');
    			  window.location.href=renderURL.toString();
    		  });
    		  
    	  });
       });
   })(jQuery);
</script>