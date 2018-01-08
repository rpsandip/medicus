<%@ include file="/init.jsp" %>

<portlet:renderURL var="importPartnerURL">
        <portlet:param name="mvcRenderCommandName" value="/import_partner" />
</portlet:renderURL>

<portlet:renderURL var="addPartnerURL">
        <portlet:param name="mvcRenderCommandName" value="/edit_partner" />
</portlet:renderURL>

<portlet:actionURL var="deletePartnerURL" name="/delete_partner">
</portlet:actionURL>

<liferay-ui:success key="partner-update-success" message="partner-update-success"/>
<liferay-ui:success key="partner-delete-success" message="partner-delete-success"/>
<liferay-ui:success key="partner-add-success" message="partner-add-success"/>
<liferay-ui:error key="partner-delete-error" message="partner-delete-error"/>


<div class="page-title">
  <div class="title_left">
    <h2>Partners</h2>
    	<a href="${addPartnerURL}" class="btn btn-primary">Add Partner</a>
    	<a href="${importPartnerURL }" class="btn btn-primary">Import Partners</a>
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
			            	<th>Facility</th>
			                <th>Email Address</th>
			                <th>Address</th>
			                <th>City</th>
			                <th>Contact Person Name</th>
			                <th>Contact Person Email</th>
			                <th>Contact Person Phone No.</th>
			                <th>Website Link</th>
			                <th>Status</th>
			                <th>Action</th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${partnerBeanList }" var="partnerBean">
            			<tr>
            				<td>${partnerBean.firstName }</td>
			                <td>${partnerBean.emailAddress }</td>
			                <td>${partnerBean.address1 }</td>
			                <td>${partnerBean.city }</td>
			                <td>${partnerBean.contactPersonName }</td>
			                <td>${partnerBean.contactPersonEmail }</td>
			                <td>${partnerBean.contactPersonPhoneNumber }</td>
			                <td>${partnerBean.user.status eq 0 ? "Active" : "Inactive" }</td>
			                <c:choose>
				                <c:when test='${fn:indexOf(partnerBean.websiteLink, "http") lt 0}'>
				               		<td><a href="http://${partnerBean.websiteLink }" target="_blank"> ${partnerBean.websiteLink }</a></td>
				               	</c:when>
			               	<c:otherwise>
			               		<td><a href="${partnerBean.websiteLink }" target="_blank"> ${partnerBean.websiteLink }</a></td>
			               	</c:otherwise> 
			               	</c:choose>
			               	
			               	<td>
			               	<portlet:renderURL var="editPartnerURL">
       							 <portlet:param name="mvcRenderCommandName" value="/edit_partner" />
       							 <portlet:param name="partnerId" value="${ partnerBean.partnerId}" />
							</portlet:renderURL>
							<a href="${editPartnerURL }" class="btn btn-block btn-primary">Edit</a>	
							<a class="btn btn-primary" data-partnerId="${partnerBean.partnerId }" data-partnerName="${ partnerBean.firstName}"  data-toggle="modal" data-target="#delete-partner">Delete</a>
			               	</td>
        			    </tr>
           			</c:forEach>
           			</tbody>
				</table>
            </div>
        </div>
     </div>
  </div>
  
  <div id="delete-partner" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Delete Partner</h4>
        <div class="msg">
        	
        </div>
      </div>
      <div class="modal-body">
       	<div class="form-group">
       	   <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
       	   		Are you sure you want to Delete <span class="partner-name"></span> Partner?
       	   </div>
       	   <br/>
       	   <aui:form name="deletePartner" action="${deletePartnerURL}" cssClass="form-horizontal form-label-left">
	       	   <div class="col-md-8 col-sm-6 col-xs-12 col-md-offset-3 approve-request-box">
	       	   		<aui:input type="hidden" name="partnerId"/>
	       	   		<aui:input type="hidden" name="partnerName"/>
	       	   </div>
	           <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
	           		<aui:button type="submit" value="Yes"  cssClass="btn btn-success" onClick="javascript: jQuery('.modal-backdrop').remove()"/>
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
    		  
    		  $('#delete-partner').on('show.bs.modal', function(e) {
    			  //get data-id attribute of the clicked element
    			  var partnerId = $(e.relatedTarget).data('partnerid');
    			  var partnerName = $(e.relatedTarget).data('partnername');

    			  $(e.currentTarget).find('#<portlet:namespace />partnerId').val(partnerId);
    			  $(e.currentTarget).find('.partner-name').text(partnerName);
              });
    		    		  
    	  });
       });
   })(jQuery);
</script>
