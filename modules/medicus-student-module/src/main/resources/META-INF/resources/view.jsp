<%@ include file="/init.jsp" %>

<portlet:renderURL var="addStudnetURL">
        <portlet:param name="mvcRenderCommandName" value="/add_student" />
</portlet:renderURL>
<portlet:renderURL var="importStudentURL">
        <portlet:param name="mvcRenderCommandName" value="/import_student" />
</portlet:renderURL>

<liferay-ui:success key="student-add-success" message="student-add-success"/>

<div class="page-title">
  <div class="title_left">
	<h2>Students List</h2>
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
		  <div class="col-md-4 col-sm-4 col-xs-12 profile_details">
			<div class="well profile_view">
			  <div class="col-sm-12">
				<div class="left col-xs-7">
				  <h3>${student.firstName }</h3>
				  <p><strong>Profession: </strong> ${student.profession } </p>
				  <ul class="list-unstyled">
					<li><i class="fa fa-child"></i> Gender: ${student.gender }</li>
					<li><i class="fa fa-university"></i> School / Campus: ${student.campusName }</li>
					<li><i class="fa fa-language"></i> Language: ${ student.primaryLanguages}</li>
				  </ul>
				</div>
				<div class="right col-xs-5 text-center">
				  <img src="${student.profileURL }" alt="" class="img-circle img-responsive">
				  <div class="col-xs-12 col-sm-6 col-md-12 text-center student-btn emphasis">
					  <a href="#" class="btn btn-primary btn-xs">
						<i class="fa fa-user"> </i> View Profile
					  </a>
					  <a href="#" class="btn btn-primary btn-xs">
						<i class="fa fa-user"> </i> Add Externship
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
