<%@ include file="../init.jsp" %>
<div class="page-title">
  <div class="title_left">
	<h2>Student Details</h2>
	<a class="btn btn-primary btn-xs" href="/group/medicus/student">  &lt&ltBack </a>
  </div>
</div>
<div class="clearfix"></div>
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
	  		<div class="x_content">
				<div class="" role="tabpanel" data-example-id="togglable-tabs">
				  <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
					<li role="presentation" class="active"><a href="#personal_details_content" id="personal-details-tab" role="tab" data-toggle="tab" aria-expanded="true">Personal Details</a>
					</li>
					<li role="presentation" class=""><a href="#academin_info_content" role="tab" id="academic-info-tab" data-toggle="tab" aria-expanded="false">Academic Info</a>
					</li>
					<li role="presentation" class=""><a href="#externship_details_content" role="tab" id="externship-details-tab" data-toggle="tab" aria-expanded="false">Externship Details</a>
					</li>
					<li role="presentation" class=""><a href="#graduation_details_content" role="tab" id="graduation-details-tab" data-toggle="tab" aria-expanded="false">Graduation Details</a>
					</li>
				  </ul>
				  <div id="myTabContent" class="tab-content">
					<div role="tabpanel" class="tab-pane fade active in" id="personal_details_content" aria-labelledby="personal-details-tab">
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">Student Id:</label> ${studentBean.stundetCampusId }
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">First Name:</label> ${studentBean.firstName }
						</div>
						<div class="form-group">
							<c:choose>
							<c:when test="${not empty studentBean.middleName}">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Middle Name:</label>${studentBean.middleName}								
							</c:when>
							<c:otherwise>
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Middle Name:</label> -
							</c:otherwise>	
							</c:choose>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">Last Name:</label> ${studentBean.lastName }
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">Profile Picture:</label>
							<c:choose>
							  	<c:when test="${not empty studentBean.profileDoc.documentURL}">
							  		<img src="${studentBean.profileDoc.documentURL }" alt="" class="img-circle img-responsive" width="110px;" height="110px;">
							  	</c:when>
						  		<c:otherwise>
						  			<img src="<%= themeDisplay.getPathThemeImages() %>/default_user.png" class="img-circle img-responsive" width="110px;" height="110px;"/>
						  		</c:otherwise>
						  </c:choose>
						</div>
						<div class="form-group">
							<c:choose>
								<c:when test="${not empty studentBean.dateOfBirth }">
									<fmt:formatDate pattern = "MM/dd/yyyy" value = "${studentBean.dateOfBirth}" var="dob" />
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Date Of Birth:</label>${dob }
								</c:when>
								<c:otherwise>
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Date Of Birth:</label> -
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">Gender:</label>${studentBean.gender}
						</div>
						<c:if test="${!isPartner}">
							<div class="form-group">
								<c:choose>
									<c:when test="${not empty studentBean.contactNumber}">
										<label class="control-label col-md-3 col-sm-3 col-xs-12">Contact No:</label>${studentBean.contactNumber}
									</c:when>
									<c:otherwise>
										<label class="control-label col-md-3 col-sm-3 col-xs-12">Contact No:</label> - 
									</c:otherwise>
								</c:choose>
							</div>
						</c:if>
						<c:if test="${!isPartner}">
							<div class="form-group">
								<c:choose>
								<c:when test="${not empty studentBean.homeNumber}">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Home No:</label>${studentBean.homeNumber}								
								</c:when>
								<c:otherwise>
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Home No:</label> -
								</c:otherwise>	
								</c:choose>
							</div>
						</c:if>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">Email Id:</label>${studentBean.emailAddress}
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">Primary Language:</label>${studentBean.primaryLanguages}
						</div>
						<div class="form-group">
							<c:choose>
							<c:when test="${not empty studentBean.secondaryLanguage}">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Secondary Language:</label>${studentBean.secondaryLanguage}								
							</c:when>
							<c:otherwise>
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Secondary Language:</label> -
							</c:otherwise>	
							</c:choose>
						</div>
						<c:if test="${!isPartner}">
							<div class="form-group">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Address:</label>${studentBean.address}
							</div>
						</c:if>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">City:</label>${studentBean.city}
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">ZipCode:</label>${studentBean.zipcode}
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">State:</label>${studentBean.state}
						</div>
					</div>
					<div role="tabpanel" class="tab-pane fade" id="academin_info_content" aria-labelledby="academic-info-tab">
						 <c:if test="${!isPartner }">
							 <div class="form-group">
								<c:choose>
								<c:when test="${not empty studentBean.pace}">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Pace Of Student:</label>${studentBean.pace}								
								</c:when>
								<c:otherwise>
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Pace Of Student:</label> -
								</c:otherwise>	
								</c:choose>
							</div> 
						</c:if>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">School:</label>${studentBean.schoolName}
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">Campus:</label>${studentBean.campusName}
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">GPA:</label>${studentBean.gpa}
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">Resume:</label>
							<c:choose>
								<c:when test="${not empty studentBean.resumeDoc.documentURL }">
									<a href="${studentBean.resumeDoc.documentURL }"><i class="fa fa-file-word-o"></i> ${studentBean.resumeDoc.fileName }</a>
								</c:when>
								<c:otherwise>
									 -
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">Profession:</label>${studentBean.profession }
						</div>
					</div>
					<div role="tabpanel" class="tab-pane fade" id="externship_details_content" aria-labelledby="externship-details-tab">
						<div class="form-group">
							<c:choose>
							<c:when test="${not empty studentExternshipBean.partnerBean.firstName }">
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Partner Name:</label>${studentExternshipBean.partnerBean.firstName} ${studentExternshipBean.partnerBean.lastName}
							</c:when>
							<c:otherwise>
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Partner Name:</label> - 
							</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
							<c:choose>
								<c:when test="${not empty studentExternshipBean.partnerBean.zipcode }">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Partner Zipcode:</label>${studentExternshipBean.partnerBean.zipcode}
								</c:when>
								<c:otherwise>
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Partner Zipcode:</label> - 
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
							<c:choose>
								<c:when test="${not empty studentExternshipBean.partnerBean.websiteLink}">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Partner Website Link:</label>${studentExternshipBean.partnerBean.websiteLink}
								</c:when>
								<c:otherwise>
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Partner Website Link:</label> - 
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
							<c:choose>
								<c:when test="${not empty  studentExternshipBean.status}">
									<c:set var="status" value="${studentExternshipBean.status}"/>
			               			 <%
			                			String status="";
			                			if(Validator.isNotNull(Student_ExternshipStatus.findByValue((int)pageContext.getAttribute("status")))){
			                				status = Student_ExternshipStatus.findByValue((int)pageContext.getAttribute("status")).getLabel();
			                			}
			               			 %>
			                		<label class="control-label col-md-3 col-sm-3 col-xs-12">Exnternship Status :</label>  <%=status %>
								</c:when>
								<c:otherwise>
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Exnternship Status :</label>  -
								</c:otherwise>
							</c:choose>
							
			              
						</div>
						<div class="form-group">
							<c:choose>
								<c:when test="${not empty studentExternshipBean.startDate }">
									<fmt:formatDate pattern = "MM/dd/yyyy" value = "${studentExternshipBean.startDate}" var="externshipStartDate" />
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Externship Start Date:</label>${externshipStartDate}
								</c:when>
								<c:otherwise>
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Externship Start Date:</label>-
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
							<c:choose>
								<c:when test="${not empty studentExternshipBean.endDate }">
									<fmt:formatDate pattern = "MM/dd/yyyy" value = "${studentExternshipBean.endDate}" var="externshipEndDate" />
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Externship End Date:</label>${externshipEndDate}
								</c:when>
								<c:otherwise>
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Externship End Date:</label>-
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
							
							<c:choose>	
								<c:when test="${ not empty studentExternshipBean.noOfHoursPerWeek}">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">No Of Hrs Per Week:</label>${studentExternshipBean.noOfHoursPerWeek}
								</c:when>
								<c:otherwise>
									<label class="control-label col-md-3 col-sm-3 col-xs-12">No Of Hrs Per Week:</label> -
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
						     <c:choose>
								<c:when test="${not empty studentExternshipBean.midPointReview }">
									<fmt:formatDate pattern = "MM/dd/yyyy" value = "${studentExternshipBean.midPointReview}" var="externshipMidPointReivewDate" />
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Mid Point Review Date:</label>${externshipMidPointReivewDate}
								</c:when>
								<c:otherwise>
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Mid Point Review Date:</label>-
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
						     <c:choose>
								<c:when test="${not empty studentExternshipBean.midPointReviewComment }">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Mid Point Review Comment</label>${studentExternshipBean.midPointReviewComment}
								</c:when>
								<c:otherwise>
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Mid Point Review Comment</label>-
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
							<c:choose>
								<c:when test="${not empty studentExternshipBean.finalReview }">
									<fmt:formatDate pattern = "MM/dd/yyyy" value = "${studentExternshipBean.finalReview}" var="finalReviewDate" />
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Final Review Date:</label>${finalReviewDate}
								</c:when>
								<c:otherwise>
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Final Review Date:</label>-
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
						     <c:choose>
								<c:when test="${not empty studentExternshipBean.finalReviewComment }">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Final Review Comment</label>${studentExternshipBean.finalReviewComment}
								</c:when>
								<c:otherwise>
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Final Review Comment</label>-
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
							<c:choose>
							<c:when test="${fn:length(studentBean.othetAttachments) > 0}">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Attachments:</label>
									<c:forEach items="${studentBean.othetAttachments}" var="document">
										<a href="${document.documentURL }"><i class="fa fa-file-word-o"></i> ${document.fileName }</a><br/>
									</c:forEach>
							</c:when>
							<c:otherwise>
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Attachments:</label> -
							</c:otherwise>
							</c:choose> 
						</div>
						
						<div class="form-group">
							<c:choose>
							<c:when test="${fn:length(studentBean.timeSheets) > 0}">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">TimeSheets:</label>
									<c:forEach items="${studentBean.timeSheets}" var="document">
										<a href="${document.documentURL }"><i class="fa fa-file-word-o"></i> ${document.fileName }</a><br/>
									</c:forEach>
							</c:when>
							<c:otherwise>
								<label class="control-label col-md-3 col-sm-3 col-xs-12">TimeSheets:</label> -
							</c:otherwise>
							</c:choose> 
						</div>
						
						<div class="form-group">
							<c:choose>
							<c:when test="${fn:length(studentBean.agreementDocs) > 0}">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Agreement Details:</label>
									<c:forEach items="${studentBean.agreementDocs}" var="document">
										<a href="${document.documentURL }"><i class="fa fa-file-word-o"></i> ${document.fileName }</a><br/>
									</c:forEach>
							</c:when>
							<c:otherwise>
								<label class="control-label col-md-3 col-sm-3 col-xs-12">Agreement Details:</label> -
							</c:otherwise>
							</c:choose> 
						</div>
						<%-- <div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">Hire:</label> ${studentBean.hired? "YES" : "No"}
						</div> --%>
					</div>
					<div role="tabpanel" class="tab-pane fade" id="graduation_details_content" aria-labelledby="graduation-details-tab">
						<div class="form-group">
							<c:choose>
								<c:when test="${not empty studentBean.graduationDate}">
									<fmt:formatDate pattern = "MM/dd/yyyy" value = "${studentBean.graduationDate}" var="graduationDate" />
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Graduation Date:</label>${graduationDate}
								</c:when>
								<c:otherwise>
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Graduation Date:</label>-
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
							<c:choose>
								<c:when test="${not empty studentExternshipBean.employerBean }">
									<label class="control-label col-md-3 col-sm-3 col-xs-12">Employer :</label>${studentExternshipBean.employerBean.firstName } ${studentExternshipBean.employerBean.lastName }
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="form-group">
							<label class="control-label col-md-3 col-sm-3 col-xs-12">Actively Seeking Employment:</label>${studentBean.activelySeekingEmployment? "YES" : "No"}
						</div>
					</div>
				  </div>
			  </div>
			</div>
		</div>
	</div>
</div>  