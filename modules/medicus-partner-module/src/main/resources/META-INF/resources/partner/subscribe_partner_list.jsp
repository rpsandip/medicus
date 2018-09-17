<%@ include file="../init.jsp"%>
<portlet:actionURL var="subsctibePartnerURL" name="/subscribe_partner">
</portlet:actionURL>
<div class="page-title">
  <div class="title_left">
    <h2>Subscribe Partners</h2>
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
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${subscribePartnerBeanList }" var="partnerBean">
            			<tr>
            				<td>${partnerBean.firstName }</td>
			                <td>${partnerBean.emailAddress }</td>
        			    </tr>
           			</c:forEach>
           			</tbody>
				</table>
            </div>
        </div>
     </div>
  </div>