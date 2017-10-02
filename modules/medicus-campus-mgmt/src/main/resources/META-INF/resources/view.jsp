<%@ include file="/init.jsp" %>
<portlet:renderURL var="addCampusURL">
        <portlet:param name="mvcRenderCommandName" value="/add_campus" />
</portlet:renderURL>

<liferay-ui:success key="campus-add-success" message="campus-add-success"/>
<liferay-ui:success key="campus-update-success" message="campus-update-success"/>

<div class="page-title">
  <div class="title_left">
    <h2>Campus</h2><a href="${addCampusURL}" class="btn btn-primary">Add New Campus</a>
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
			            	<th>School Name</th>
			                <th>Campus Name</th>
			                <th>Address1</th>
			                <th>City</th>
			                <th>Contact Number</th>
			                <th>Website Link</th>
			                <th>Contact Person Name</th>
			                <th>Contact Person Email</th>
			                <th>Contact Person Phone No.</th>
			                <th>Actions</th>
			            </tr>
     			   </thead>
        		   <tbody>
            	      <c:forEach items="${campusBeanList }" var="campusBean">
            			<tr>
            				<td>${campusBean.schoolName }</td>
			                <td>${campusBean.name }</td>
			                <td>${campusBean.address1 }</td>
			                <td>${campusBean.city }</td>
			                <td>${campusBean.contactNumber }</td>
			                <c:choose>
				                <c:when test='${fn:indexOf(campusBean.websiteLink, "http") lt 0}'>
				               		<td><a href="http://${campusBean.websiteLink }" target="_blank"> ${campusBean.websiteLink }</a></td>
				               	</c:when>
			               	<c:otherwise>
			               		<td><a href="${campusBean.websiteLink }" target="_blank"> ${campusBean.websiteLink }</a></td>
			               	</c:otherwise> 
			               	</c:choose>
			                <td>${campusBean.contactPersonName }</td>
			                <td>${campusBean.contactPersonEmail }</td>
			                <td>${campusBean.contactPersonPhoneNumber }</td>
			                <portlet:renderURL var="editCampusURL">
       							 <portlet:param name="mvcRenderCommandName" value="/add_campus" />
       							 <portlet:param name="campusId" value="${ campusBean.campusId}" />
							</portlet:renderURL>
			                <td>
			                	<a href="${editCampusURL }" class="btn btn-block btn-primary">Edit</a>
			                </td> 
        			    </tr>
           			</c:forEach>
           			</tbody>
				</table>
            </div>
        </div>
     </div>
  </div>
