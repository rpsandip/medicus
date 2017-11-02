<%@ include file="/init.jsp" %>

<portlet:renderURL var="addStudnetURL">
        <portlet:param name="mvcRenderCommandName" value="/add_student" />
</portlet:renderURL>
<portlet:renderURL var="importStudentURL">
        <portlet:param name="mvcRenderCommandName" value="/import_student" />
</portlet:renderURL>

<liferay-ui:success key="student-add-success" message="student-add-success"/>
<liferay-ui:error key="student-add-error" message="student-add-error"/>
<liferay-ui:error key="student-detail-err" message="student-detail-err"/>

<liferay-ui:success key="student-update-success" message="student-update-success"/>
<liferay-ui:error key="student-update-error" message="student-update-error"/>

<liferay-ui:success key="student-delete-success" message="student-delete-success"/>
<liferay-ui:error key="student-delete-err" message="student-delete-err"/>

<liferay-ui:error key="student-exist" message="student-exist"/>
<liferay-ui:error key="student-update-exist" message="student-update-exist"/>


<div class="page-title">
  <div class="title_left">
	<h2>Students</h2>
		<a href="${addStudnetURL }" class="btn btn-primary">Add New Student</a>
		<a href="${importStudentURL }" class="btn btn-primary">Import Students</a>
  </div>
</div>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12">
	<div class="x_panel">
	  <div class="x_content">
		<div class="row">
		  <div class="col-md-12 col-sm-12 col-xs-12 text-center"></div>
		  <div class="clearfix"></div>
		  <c:forEach items="${studentBeanList }" var="student">
		  <div class="col-md-6 col-sm-12 col-xs-12 profile_details">
			<div class="well profile_view">
			  <div class="col-sm-12">
			  	<div class="col-md-2 profile-pic">
			  		<c:choose>
				  	<c:when test="${not empty student.profileDoc.documentURL}">
				  		<img src="${student.profileDoc.documentURL }" class="img-circle img-responsive"/>
				  	</c:when>
				  	<c:otherwise>
				  		<img src="<%= themeDisplay.getPathThemeImages() %>/default_user.png" class="img-circle img-responsive"/>
				  	</c:otherwise>
				  </c:choose>
			  	</div>
				<div class="left col-xs-7">
				  <h3>${student.firstName }</h3>
				  <p><strong>Profession: </strong> ${student.profession } </p>
				  <ul class="list-unstyled">
					<li><i class="fa fa-child"></i> Gender: ${student.gender }</li>
					<li><i class="fa fa-university"></i> School / Campus: ${student.campusName }</li>
					<li><i class="fa fa-language"></i> Language: ${ student.primaryLanguages}</li>
				  </ul>
				</div>
				<div class="right col-xs-3 pull-right action-btn">
				  <div class="col-xs-12 col-sm-6 col-md-12 text-center student-btn emphasis">
					   <portlet:renderURL var="editStudnetURL">
        				<portlet:param name="mvcRenderCommandName" value="/add_student" />
        				<portlet:param name="studentId" value="${student.studentId }" />
					  </portlet:renderURL>
					  <a href="${editStudnetURL }" class="btn btn-primary btn-xs">
						<i class="fa fa-edit"> </i> Edit Profile
					  </a>
					  <portlet:renderURL var="viewStudentDetailURL">
       					 <portlet:param name="mvcRenderCommandName" value="/student_detail" />
       					 <portlet:param name="studentId" value="${student.studentId }" />
					  </portlet:renderURL>
					  <a href="${viewStudentDetailURL }" class="btn btn-primary btn-xs">
						<i class="fa fa-user"> </i> View Profile
					  </a>
					  <portlet:renderURL var="editExternshipURL">
        				<portlet:param name="mvcRenderCommandName" value="/add_student" />
        				<portlet:param name="studentId" value="${student.studentId }" />
        				<portlet:param name="addExternship" value="true" />
					  </portlet:renderURL>
					  <a href="${editExternshipURL }" class="btn btn-primary btn-xs">
						<i class="fa fa-user"> </i> Add Externship
					  </a>
					   <portlet:actionURL var="deleteStudentURL" name="/delete_student">
					   		<portlet:param name="studentId" value="${student.studentId }" />
					   </portlet:actionURL>
					   <a href="${deleteStudentURL }" class="btn btn-primary btn-xs">
						<i class="fa fa-user"> </i> Delete
					  </a>
				  </div>
				</div>
			  </div>
			</div>
		  </div>
		  </c:forEach>
		  
		</div>
	  </div>
	</div>
  </div>
</div>
