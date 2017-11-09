<%@ include file="/init.jsp" %>

<portlet:renderURL var="addEmployerURL">
        <portlet:param name="mvcRenderCommandName" value="/add_employer" />
</portlet:renderURL>

<liferay-ui:success key="employer-add-success" message="employer-add-success"/>
<liferay-ui:success key="employer-update-success" message="employer-update-success"/>

<div class="page-title">
  <div class="title_left">
    <h2>Employers</h2> <a href="${addEmployerURL}" class="btn btn-primary">Add Employer</a>
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
			                <th>Action</th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${employerBeanList }" var="employerBean">
            			<tr>
            				<td>${employerBean.firstName }</td>
			                <td>${employerBean.lastName }</td>
			                <td>${employerBean.emailAddress }</td>
			                <td>${employerBean.address1 }</td>
			                <td>${employerBean.city }</td>
			                <td>${employerBean.contactPersonName }</td>
			                <td>${employerBean.contactPersonEmail }</td>
			                <td>${employerBean.contactPersonPhoneNumber }</td>
			                <c:choose>
				                <c:when test='${fn:indexOf(employerBean.websiteLink, "http") lt 0}'>
				               		<td><a href="http://${employerBean.websiteLink }" target="_blank"> ${employerBean.websiteLink }</a></td>
				               	</c:when>
			               	<c:otherwise>
			               		<td><a href="${employerBean.websiteLink }" target="_blank"> ${employerBean.websiteLink }</a></td>
			               	</c:otherwise> 
			               	</c:choose>
			               	<td>
			               		<portlet:renderURL var="editEmployerURL">
       								 <portlet:param name="mvcRenderCommandName" value="/add_employer" />
       								 <portlet:param name="employerId" value="${employerBean.employerId }" />
								</portlet:renderURL>
			               		<a href="${editEmployerURL }" class="btn btn-block btn-primary">Edit</a>
			               	</td>
        			    </tr>
           			</c:forEach>
           			</tbody>
				</table>
            </div>
        </div>
     </div>
  </div>
