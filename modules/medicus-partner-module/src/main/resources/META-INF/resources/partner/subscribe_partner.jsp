<%@ include file="../init.jsp"%>
<portlet:actionURL var="subsctibePartnerURL" name="/subscribe_partner">
</portlet:actionURL>
<div class="page-title">
  <div class="title_left">
    <h2>Unsubscribe Partners</h2>
  </div>
</div>
<div class="clearfix"></div>

<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
      <div class="x_panel">
        <div class="x_content">
			<aui:form action="${subsctibePartnerURL }" name="subcribeFm">
            <table id="datatable" class="table table-striped">
					<thead>
			            <tr>
			                <th>
			                	<aui:input type="checkbox" name="allPartner" id="allPartnerSelect" label=""/>
			                </th>
			            	<th>Facility</th>
			                <th>Email Address</th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${unsubscribePartnerBeanList }" var="partnerBean">
            			<tr>
            				<td>
            					<aui:input type="checkbox" name="subscribePartner" value="${partnerBean.userId }" label=""/>
            				</td>
            				<td>${partnerBean.firstName }</td>
			                <td>${partnerBean.emailAddress }</td>
        			    </tr>
           			</c:forEach>
           			</tbody>
				</table>
				<div class="form-group">
	        		<div class="col-md-10 col-sm-6 col-xs-12 col-md-offset-3">
						<aui:button type="submit" value="Submit" name="Submit"></aui:button>
					</div>
				</div>
				</aui:form>
            </div>
        </div>
     </div>
  </div>
  
  <script>
 jQuery.noConflict();
    (function($) {
      $(function() {
    	  AUI().use('aui-io-request', 'aui-autocomplete','liferay-portlet-url' ,'aui-base','aui-form-validator','autocomplete-list','autocomplete-filters','autocomplete-highlighters','node-event-simulate', function(A) {
    		  
    		  var selectAllPartnerCheckbox = A.one("#<portlet:namespace/>allPartnerSelect");
    		  selectAllPartnerCheckbox.on('click',function(){
    			 	if(this._node.checked){
    			 		
    			 		var allCheckboxNodes = A.all('#<portlet:namespace/>subscribePartner')._nodes;
    			 		for(var i=0;i<allCheckboxNodes.length;i++){
    			 			allCheckboxNodes[i].checked=true;
    			 		}
    			 	}else{
    			 		var allCheckboxNodes = A.all('#<portlet:namespace/>subscribePartner')._nodes;
    			 		for(var i=0;i<allCheckboxNodes.length;i++){
    			 			allCheckboxNodes[i].checked=false;
    			 		}
    			 	}
    		  });
    		   		  
    	  });
       });
   })(jQuery);
</script>