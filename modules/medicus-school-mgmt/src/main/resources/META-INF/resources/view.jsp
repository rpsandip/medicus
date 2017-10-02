<%@ include file="/init.jsp" %>

<portlet:renderURL var="addSchoolURL">
        <portlet:param name="mvcRenderCommandName" value="/add_school" />
</portlet:renderURL>

<liferay-ui:success key="school-add-success" message="school-add-success"/>
<liferay-ui:success key="school-update-success" message="school-update-success"/>

<div class="page-title">
  <div class="title_left">
    <h2>School</h2><a href="${addSchoolURL}" class="btn btn-primary">Add New School</a>
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
			                <th>Name</th>
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
            	      <c:forEach items="${schoolList }" var="school">
            			<tr>
			                <td>${school.name }</td>
			                <td>${school.address1 }</td>
			                <td>${school.city }</td>
			                <td>${school.contactNumber }</td>
			                <c:choose>
				                <c:when test='${fn:indexOf(school.websiteLink, "http") lt 0}'>
				               		<td><a href="http://${school.websiteLink }" target="_blank"> ${school.websiteLink }</a></td>
				               	</c:when>
			               	<c:otherwise>
			               		<td><a href="${school.websiteLink }" target="_blank"> ${school.websiteLink }</a></td>
			               	</c:otherwise> 
			               	</c:choose>
			                <td>${school.contactPersonName }</td>
			                <td>${school.contactPersonEmail }</td>
			                <td>${school.contactPersonPhoneNumber }</td>
			                <portlet:renderURL var="editSchoolURL">
       							 <portlet:param name="mvcRenderCommandName" value="/add_school" />
       							 <portlet:param name="schoolId" value="${ school.schoolId}" />
							</portlet:renderURL>
			                <td>
			                	<a href="${editSchoolURL }" class="btn btn-block btn-primary">Edit</a>
			                </td> 
        			    </tr>
           			</c:forEach>
           			</tbody>
				</table>
            </div>
        </div>
     </div>
  </div>
