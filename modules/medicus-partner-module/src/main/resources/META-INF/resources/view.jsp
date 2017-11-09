<%@ include file="/init.jsp" %>

<div class="page-title">
  <div class="title_left">
    <h2>Partners</h2>
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
			                <th>Address</th>
			                <th>City</th>
			                <th>Contact Person Name</th>
			                <th>Contact Person Email</th>
			                <th>Contact Person Phone No.</th>
			                 <th>Website Link</th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${partnerBeanList }" var="partnerBean">
            			<tr>
            				<td>${partnerBean.firstName }</td>
			                <td>${partnerBean.lastName }</td>
			                <td>${partnerBean.emailAddress }</td>
			                <td>${partnerBean.address1 }</td>
			                <td>${partnerBean.city }</td>
			                <td>${partnerBean.contactPersonName }</td>
			                <td>${partnerBean.contactPersonEmail }</td>
			                <td>${partnerBean.contactPersonPhoneNumber }</td>
			                <c:choose>
				                <c:when test='${fn:indexOf(partnerBean.websiteLink, "http") lt 0}'>
				               		<td><a href="http://${partnerBean.websiteLink }" target="_blank"> ${partnerBean.websiteLink }</a></td>
				               	</c:when>
			               	<c:otherwise>
			               		<td><a href="${partnerBean.websiteLink }" target="_blank"> ${partnerBean.websiteLink }</a></td>
			               	</c:otherwise> 
			               	</c:choose>
        			    </tr>
           			</c:forEach>
           			</tbody>
				</table>
            </div>
        </div>
     </div>
  </div>
