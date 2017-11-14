<%@ include file="../init.jsp" %>
<c:choose>
	<c:when test="${fn:length(studentBeanList) gt 0}">
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
				  <c:choose>
				  	<c:when test="${not empty student.middleName }">
				  		<c:set var = "middleName" value = "${fn:substring(student.middleName, 0, 1)}" />
				  		<c:set var = "middleName" value = "${fn:toUpperCase(middleName)}." />		
				  	</c:when>
				  	<c:otherwise>
				  		<c:set var = "middleName" value = "" />
				  	</c:otherwise>
				  </c:choose>
				  <h3>${student.lastName } ${middleName } ${student.firstName } </h3>
				  <p><strong>Profession: </strong> ${student.profession } </p>
				  <ul class="list-unstyled">
					<li><i class="fa fa-child"></i> Gender: ${student.gender }</li>
					<li><i class="fa fa-university"></i> School / Campus: ${student.campusName }</li>
					<li><i class="fa fa-language"></i> Language: ${ student.primaryLanguages}</li>
				  </ul>
				</div>
				<div class="right col-xs-3 pull-right action-btn">
				  <div class="col-xs-12 col-sm-6 col-md-12 text-center student-btn emphasis">
					  <c:if test="${hasUpdateStudentPermission }">
						  <portlet:renderURL var="editStudnetURL">
			      				<portlet:param name="mvcRenderCommandName" value="/add_student" />
			      				<portlet:param name="studentId" value="${student.studentId }" />
						  </portlet:renderURL>
						  <a href="${editStudnetURL }" class="btn btn-primary btn-xs">
							<i class="fa fa-edit"> </i> Edit Profile
						  </a>
					  </c:if>
					  <c:if test="${hasViewStudentProfilePermission }">
						  <portlet:renderURL var="viewStudentDetailURL">
			     					 <portlet:param name="mvcRenderCommandName" value="/student_detail" />
			     					 <portlet:param name="studentId" value="${student.studentId }" />
						  </portlet:renderURL>
						  <a href="${viewStudentDetailURL }" class="btn btn-primary btn-xs">
							<i class="fa fa-user"> </i> View Profile
						  </a>
					  </c:if>
					  <c:if test="${hasUpdateStudentPermission }">
						  <portlet:renderURL var="editExternshipURL">
			      				<portlet:param name="mvcRenderCommandName" value="/add_student" />
			      				<portlet:param name="studentId" value="${student.studentId }" />
			      				<portlet:param name="addExternship" value="true" />
						  </portlet:renderURL>
						  <a href="${editExternshipURL }" class="btn btn-primary btn-xs">
							<i class="fa fa-user"> </i> Add Externship
						  </a>
					  </c:if>
					   <c:if test="${hasDeleteStudentPermission }">
						   <portlet:actionURL var="deleteStudentURL" name="/delete_student">
						   		<portlet:param name="studentId" value="${student.studentId }" />
						   </portlet:actionURL>
						   <a href="${deleteStudentURL }" class="btn btn-primary btn-xs">
							<i class="fa fa-user"> </i> Delete
						   </a>
					   </c:if>
					   <c:if test="${hasStudentInterviewRequestPermission }">
						   <a class="btn btn-primary btn-xs inter-view-request" data-studentId="${ student.studentId}" data-toggle="modal" data-target="#interivew-request-modal">
							<i class="fa fa-user"> </i> Interview Request
						   </a>
					   </c:if>
				  </div>
				</div>
			  </div>
			</div>
		  </div>
		</c:forEach>
		<div class="show-load-more" hidden>${showLoadMore }</div>
	</c:when>
	<c:otherwise>
		<div>
			<div class="col-md-6 col-sm-12 col-xs-12 profile_details">
			<div class="well profile_view">
			  <div class="col-sm-12">
				<h2>No Students Found.</h2>
			  </div>
			 </div>
			</div>  	
		</div>
	</c:otherwise>
</c:choose>