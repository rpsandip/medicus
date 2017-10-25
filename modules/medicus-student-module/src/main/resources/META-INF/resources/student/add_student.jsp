<%@ include file="../init.jsp" %>

<portlet:actionURL var="addStudentURL" name="/add_student">
</portlet:actionURL>
<portlet:resourceURL id="/getSchoolDetail" var="getSchoolDetailURL"></portlet:resourceURL>
<portlet:resourceURL id="/getEmployerDetail" var="getEmployerDetailURL"></portlet:resourceURL>
<div class="page-title">
	<div class="title_left">
     	 <h2>Add New Student</h2>
    </div>
</div>

<div class="clearfix"></div>
		
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
   		<div class="x_panel">
    		<div class="x_content">
        		<br />
        		<!-- Smart Wizard -->
	            <div id="wizard" class="form_wizard wizard_horizontal">
	              <ul class="wizard_steps">
	                <li>
	                  <a href="#step-1">
	                    <span class="step_no">1</span>
	                    <span class="step_descr"> Personal Details</span>
	                  </a>
	                </li>
	                <li>
	                  <a href="#step-2">
	                    <span class="step_no">2</span>
	                    <span class="step_descr"> Academic Info</span>
	                  </a>
	                </li>
	                <li>
	                  <a href="#step-3">
	                    <span class="step_no">3</span>
	                    <span class="step_descr">Externship details</span>
	                  </a>
	                </li>
	                <li>
	                  <a href="#step-4">
	                    <span class="step_no">4</span>
	                    <span class="step_descr">Graduation details</span>
	                  </a>
	                </li>
	              </ul>
	              <aui:form name="addStudentFm" action="${addStudentURL}" cssClass="form-horizontal form-label-left" enctype="multipart/form-data">
	              	<div id="step-1">
	                   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="campusStudentId" label="studentId"  cssClass="form-control col-md-7 col-xs-12">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">20</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="firstName" label="firstName"  cssClass="form-control col-md-7 col-xs-12">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">30</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="middleName" label="middleName"  cssClass="form-control col-md-7 col-xs-12">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">30</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="lastName" label="lastName"  cssClass="form-control col-md-7 col-xs-12">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">30</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>	
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="emailAddress" label="emailAddress"  cssClass="form-control col-md-7 col-xs-12">
						     	<aui:validator name="required" />
						     	<aui:validator name="email" />
						     	<aui:validator name="maxLength">30</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>	  
	                   <div class="form-group">
	                     <label for="profilePic" class="control-label col-md-3 col-sm-3 col-xs-12">Profile Picture</label>
	                     <div class="col-md-6 col-sm-6 col-xs-12">
	                       <input id="middle-name" class="form-control col-md-7 col-xs-12" type="file" name="profilePic">
	                     </div>
	                   </div>
	                   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12 date ">
	       					 <aui:input name="dob" label="dob"  cssClass="form-control col-md-7 col-xs-12 myDatepicker">
						     	<aui:validator name="required" />
							 </aui:input>
							 <span class="input-group-addon">
                               <span class="glyphicon glyphicon-calendar"></span>
                             </span>
					   	  </div>
					   </div>	 
	                   <div class="form-group">
	                     <label class="control-label col-md-3 col-sm-3 col-xs-12">Gender</label>
	                     <div class="col-md-6 col-sm-6 col-xs-12 gender-select">
	                     	<aui:input id="male"  type="radio" name="gender" value="Male" label="">
	                     		 <aui:validator name="required" />
	                     	</aui:input>
                       		<label for="<portlet:namespace/>male">Male</label>
                       		
                       		<aui:input id="female"  type="radio" name="gender" value="Female" label="">
                       			<aui:validator name="required" />
                       		</aui:input>
                       		<label for="<portlet:namespace/>male">Female</label>
                       		
                       		<aui:input id="LGBT"  type="radio" name="gender" value="LGBT" label="">
                       			<aui:validator name="required" />
                       		</aui:input>
                       		<label for="<portlet:namespace/>LGBT">LGBT</label>
	                     </div>
	                   </div>
	                   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="contactNo" label="contactNo"  cssClass="form-control col-md-7 col-xs-12">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">12</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="homePhoneNumber" label="homePhoneNumber"  cssClass="form-control col-md-7 col-xs-12">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">12</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:select name="primaryLanguage" label="primaryLanguage"  cssClass="form-control col-md-7 col-xs-12" multiple="true">
								<aui:option value="English">English</aui:option>
								<aui:option value="French">French</aui:option>
								<aui:option value="Spanish">Spanish</aui:option>
								<aui:option value="Chinese - Mandarin">Chinese - Mandarin</aui:option>
								<aui:option value="Chinese -Cantonese">Chinese -Cantonese</aui:option>
								<aui:option value="Tagalog">Tagalog</aui:option>
								<aui:option value="Vietnamese">Vietnamese</aui:option>
								<aui:option value="Korean">Korean</aui:option>
								<aui:option value="German">German</aui:option>
								<aui:option value="Arabic">Arabic</aui:option>
								<aui:option value="Russian">Russian</aui:option>
								<aui:option value="Italian">Italian</aui:option>
								<aui:option value="Portuguese">Portuguese</aui:option>
								<aui:option value="Hindi">Hindi</aui:option>
								<aui:option value="Polish">Polish</aui:option>
								<aui:option value="Japanese">Japanese</aui:option>
								<aui:option value="Urdu">Urdu</aui:option>
								<aui:option value="Persian">Persian</aui:option>
								<aui:option value="Gujarati">Gujarati</aui:option>
								<aui:option value="Greek">Greek</aui:option>
								<aui:option value="Bengali">Bengali</aui:option>
								<aui:option value="Panjabi">Panjabi</aui:option>
								<aui:option value="Telugu">Telugu</aui:option>
								<aui:option value="Armenian">Armenian</aui:option>
								<aui:option value="Hmong">Hmong</aui:option>
								<aui:option value="Hebrew">Hebrew</aui:option>
							 </aui:select>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:select name="secondaryLanguage" label="secondaryLanguage"  cssClass="form-control col-md-7 col-xs-12" multiple="true">
								<aui:option value="English">English</aui:option>
								<aui:option value="French">French</aui:option>
								<aui:option value="Spanish">Spanish</aui:option>
								<aui:option value="Chinese - Mandarin">Chinese - Mandarin</aui:option>
								<aui:option value="Chinese -Cantonese">Chinese -Cantonese</aui:option>
								<aui:option value="Tagalog">Tagalog</aui:option>
								<aui:option value="Vietnamese">Vietnamese</aui:option>
								<aui:option value="Korean">Korean</aui:option>
								<aui:option value="German">German</aui:option>
								<aui:option value="Arabic">Arabic</aui:option>
								<aui:option value="Russian">Russian</aui:option>
								<aui:option value="Italian">Italian</aui:option>
								<aui:option value="Portuguese">Portuguese</aui:option>
								<aui:option value="Hindi">Hindi</aui:option>
								<aui:option value="Polish">Polish</aui:option>
								<aui:option value="Japanese">Japanese</aui:option>
								<aui:option value="Urdu">Urdu</aui:option>
								<aui:option value="Persian">Persian</aui:option>
								<aui:option value="Gujarati">Gujarati</aui:option>
								<aui:option value="Greek">Greek</aui:option>
								<aui:option value="Bengali">Bengali</aui:option>
								<aui:option value="Panjabi">Panjabi</aui:option>
								<aui:option value="Telugu">Telugu</aui:option>
								<aui:option value="Armenian">Armenian</aui:option>
								<aui:option value="Hmong">Hmong</aui:option>
								<aui:option value="Hebrew">Hebrew</aui:option>
							 </aui:select>
					   	  </div>
					   </div>
	                    <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="address" label="address"  cssClass="form-control col-md-7 col-xs-12">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">100</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="city" label="city"  cssClass="form-control col-md-7 col-xs-12">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">50</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
	                   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="zipcode" label="zipcode"  cssClass="form-control col-md-7 col-xs-12">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">6</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
	                   <div class="form-group">
               		   	 	<div class="col-md-10 col-sm-6 col-xs-12">
	               				<aui:select name="state" label="state" cssClass="form-control col-md-7 col-xs-12">
	               					<c:forEach items="${usStateList }" var="state">
	               						<aui:option value="${state }">${state }</aui:option>
	               					</c:forEach>
	               				</aui:select>
							</div>
			  			</div>
	               </div>
	               <div id="step-2">
	                 <h2 class="StepTitle">Academic Info</h2>
	                    <div class="form-group">
               		   	 	<div class="col-md-10 col-sm-6 col-xs-12">
               		   	 		<aui:select name="pace" label="pace">
               		   	 			<aui:option value="Slow">Slow</aui:option>
               		   	 			<aui:option value="Mid">Mid</aui:option>
               		   	 			<aui:option value="Quick">Quick</aui:option>
               		   	 		</aui:select>
               		   	 	</div>
               		   	 </div>
               		   	 <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="gpa" label="gpa"  cssClass="form-control col-md-7 col-xs-12">
						     	<aui:validator name="required" />
						     	<aui:validator name="custom" errorMessage="err-valid-task-price">
									function(val, fieldNode, ruleValue) {
				             			var filterValue=val.substring(1,val.length);
				             			if(isNaN(filterValue) || filterValue.length==0){
				             				return false;
				             			}
				             			if(parseFloat(filterValue)>4.0 || parseFloat(filterValue) < 0.0){
				            				return false;
				            			}else{
				            				return true;
				            			}
									}
		         		</aui:validator>
							 </aui:input>
					   	  </div>	
	                   <div class="form-group">
   					 		<div class="col-md-10 col-sm-6 col-xs-12">
   					 			<aui:select name="school" label="school">
   					 				<aui:option value=""> Please Select School</aui:option>
   					 				<c:forEach items="${schoolList }" var="school">
   					 					<aui:option value="${school.schoolId }"> ${school.name }</aui:option>
   					 				</c:forEach>
   					 			</aui:select>
   					 		</div>
      					</div>
	               		<div class="form-group">
   					 		<div class="col-md-10 col-sm-6 col-xs-12">
   					 			<aui:select name="campus" label="campus">
   					 				<aui:option value=""> Please Select Campus</aui:option>
   					 			</aui:select>
   					 		</div>
      					</div>
	                   <div class="form-group">
	                     <label for="profilePic" class="control-label col-md-3 col-sm-3 col-xs-12">Resume</label>
	                     <div class="col-md-6 col-sm-6 col-xs-12">
	                       <input id="middle-name" class="form-control col-md-7 col-xs-12" type="file" name="resume">
	                     </div>
	                   </div>
	                   <div class="form-group">
               		   	 	<div class="col-md-10 col-sm-6 col-xs-12">
               		   	 		<aui:select name="profession" label="profession">
               		   	 			<aui:option value="">Select Profession</aui:option>
               		   	 			<aui:option value="Dental Assistant">Dental Assistant</aui:option>
               		   	 			<aui:option value="Medical Assistant">Medical Assistant</aui:option>
               		   	 			<aui:option value="Medical Administrative Assistance">Medical Administrative Assistance</aui:option>
               		   	 			<aui:option value="Phlebotomy">Phlebotomy</aui:option>
               		   	 			<aui:option value="Pharmacy Technician">Pharmacy Technician</aui:option>
               		   	 			<aui:option value="Patient Care Technician">Patient Care Technician</aui:option>
               		   	 			<aui:option value="Veterinary Assistant">Veterinary Assistant</aui:option>
               		   	 			<aui:option value="Sonography">Sonography</aui:option>
               		   	 		</aui:select>
               		   	 	</div>
               		   	 </div>	
               		   	 <div class="form-group">
               		   	 	<div class="col-md-10 col-sm-6 col-xs-12">
               		   	 		<aui:select name="practices" label="practice">
               		   	 			<aui:option value="">Select Practices</aui:option>
               		   	 			<aui:option value="Athletic trainer">Athletic trainer</aui:option>
               		   	 			<aui:option value="Audiologist">Audiologist</aui:option>
               		   	 			<aui:option value="Chiropractor">Chiropractor</aui:option>
               		   	 			<aui:option value="Clinical coder">Clinical coder</aui:option>
               		   	 			<aui:option value="Clinical nurse specialist">Clinical nurse specialist</aui:option>
               		   	 			<aui:option value="Clinical officer">Clinical officer</aui:option>
               		   	 			<aui:option value="Community health worker">Community health worker</aui:option>
               		   	 			<aui:option value="Dentist">Dentist</aui:option>
               		   	 			<aui:option value="Dietitian and nutritionist">Dietitian and nutritionist</aui:option>
               		   	 			<aui:option value="Emergency medical technician">Emergency medical technician</aui:option>
               		   	 			<aui:option value="Feldsher">Feldsher</aui:option>
               		   	 			<aui:option value="Health administrator">Health administrator</aui:option>
               		   	 			<aui:option value="Medical assistant">Medical assistant</aui:option>
               		   	 			<aui:option value="Medical laboratory scientist">Medical laboratory scientist</aui:option>
               		   	 			<aui:option value="Medical transcriptionist">Medical transcriptionist</aui:option>
               		   	 			<aui:option value="Nurse anesthetist">Nurse anesthetist</aui:option>
               		   	 			<aui:option value="Nurse practitioner">Nurse practitioner</aui:option>
               		   	 			<aui:option value="Nurse midwives">Nurse midwives</aui:option>
               		   	 			<aui:option value="Nurse">Nurse</aui:option>
               		   	 			<aui:option value="Occupational Therapist">Occupational Therapist</aui:option>
               		   	 			<aui:option value="Optometrist">Optometrist</aui:option>
               		   	 			<aui:option value="Paramedic">Paramedic</aui:option>
               		   	 			<aui:option value="Pharmacist">Pharmacist</aui:option>
               		   	 			<aui:option value="Pharmaconomist">Pharmaconomist</aui:option>
               		   	 			<aui:option value="Pharmacy technician">Pharmacy technician</aui:option>
               		   	 			<aui:option value="Phlebotomist">Phlebotomist</aui:option>
               		   	 			<aui:option value="Physician">Physician</aui:option>
               		   	 			<aui:option value="Podiatrist">Podiatrist</aui:option>
               		   	 			<aui:option value="Physician assistant">Physician assistant</aui:option>
               		   	 			<aui:option value="Psychologist">Psychologist</aui:option>
               		   	 			<aui:option value="Physical therapist">Physical therapist</aui:option>
               		   	 			<aui:option value="Psychotherapist">Psychotherapist</aui:option>
               		   	 			<aui:option value="Radiographer">Radiographer</aui:option>
               		   	 			<aui:option value="Radiotherapist">Radiotherapist</aui:option>
               		   	 			<aui:option value="Respiratory therapist">Respiratory therapist</aui:option>
               		   	 			<aui:option value="Speech-language pathologist">Speech-language pathologist</aui:option>
               		   	 			<aui:option value="Surgeon">Surgeon</aui:option>
               		   	 			<aui:option value="Surgeon's assistant">Surgeon's assistant</aui:option>
               		   	 			<aui:option value="Surgical technologist">Surgical technologist</aui:option>
               		   	 		</aui:select>
               		   	 	</div>
               		   	 </div>	
	               </div>
	               <div id="step-3">
	                 <h2 class="StepTitle">Externship details</h2>
	                 <div class="form-group">
	                     <label class="control-label col-md-3 col-sm-3 col-xs-12">Do you want to add Externship Detail?</label>
	                     <div class="col-md-6 col-sm-6 col-xs-12 gender-select">
	                     	<aui:input id="yes"  type="radio" name="haveExternship" value="true" label="" />
                       		<label for="<portlet:namespace/>yes">Yes</label>
                       		
                       		<aui:input id="no"  type="radio" name="haveExternship" value="false" label="" checked="true"/>
                       		<label for="<portlet:namespace/>no">No</label>
	                     </div>
	                   </div>
	                   <div class="externship-data">
	                   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
							 <aui:select name="employerName" label="employer.name">
							 <aui:option value="">Please Select Partner</aui:option>
							 	<c:forEach items="${employerBeanList }" var="employerBean">
							 		<aui:option value="${employerBean.employerId }">${employerBean.firstName } ${employerBean.lastName }</aui:option>
							 	</c:forEach>
							 </aui:select>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="employerZipCode" label="employer.zipcode"  cssClass="form-control col-md-7 col-xs-12" readonly="true">
						     	<aui:validator name="maxLength">6</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="employerWebSiteLink" label="employer.websitelink"  cssClass="form-control col-md-7 col-xs-12" readonly="true">
						     	<aui:validator name="maxLength">50</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
	                   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12 date ">
	       					 <aui:input name="externshipStartDate" label="externship.start.date"  cssClass="form-control col-md-7 col-xs-12 myDatepicker">
							 </aui:input>
							  <span class="input-group-addon">
                               <span class="glyphicon glyphicon-calendar"></span>
                             </span>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12 date">
	       					 <aui:input name="externshipEndDate" label="externship.end.date"  cssClass="form-control col-md-7 col-xs-12 myDatepicker">
							 </aui:input>
							  <span class="input-group-addon">
                               <span class="glyphicon glyphicon-calendar"></span>
                             </span>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="noOfHoursPerWeek" label="no.of.hours"  cssClass="form-control col-md-7 col-xs-12">
						     	<aui:validator name="number" />
						     	<aui:validator name="maxLength">2</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12 date">
	       					 <aui:input name="midPointReviewDate" label="mid.point.review.date"  cssClass="form-control col-md-7 col-xs-12 myDatepicker">
							 </aui:input>
							  <span class="input-group-addon">
                               <span class="glyphicon glyphicon-calendar"></span>
                             </span>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="midPointReviewComment" type="textarea" label="mid.point.review.comment"  cssClass="form-control col-md-7 col-xs-12">
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12 date">
	       					 <aui:input name="finalReviewDate" label="final.point.review.date"  cssClass="form-control col-md-7 col-xs-12 myDatepicker">
							 </aui:input>
							  <span class="input-group-addon">
                               <span class="glyphicon glyphicon-calendar"></span>
                             </span>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="finalPointReviewComment" type="textarea" label="final.point.review.comment"  cssClass="form-control col-md-7 col-xs-12">
							 </aui:input>
					   	  </div>
					   </div>
	                   <div class="form-group">
	                     <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Attachments <span class="required">*</span>
	                     </label>
	                     <div class="col-md-6 col-sm-6 col-xs-12">
	                       <input type="file" id="attachment" name="others" required="required" class="form-control col-md-7 col-xs-12" multiple="multiple">
	                     </div>
	                   </div>
	                   <div class="form-group">
	                     <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Agreement Details <span class="required">*</span>
	                     </label>
	                     <div class="col-md-6 col-sm-6 col-xs-12">
	                       <input type="file" id="agreeements" name="agreements" required="required" class="form-control col-md-7 col-xs-12">
	                     </div>
	                   </div>
	                   <div class="form-group">
	                     <label class="control-label col-md-3 col-sm-3 col-xs-12">Hire</label>
	                     <div class="col-md-6 col-sm-6 col-xs-12 gender-select">
	                     	<aui:input id="yes"  type="radio" name="hired" value="true" label="" />
                       		<label for="<portlet:namespace/>yes">Yes</label>
                       		
                       		<aui:input id="no"  type="radio" name="hired" value="false" label="" />
                       		<label for="<portlet:namespace/>no">No</label>
	                     </div>
	                   </div>
	                   </div>
	               </div>
	               <div id="step-4">
	                 <h2 class="StepTitle">Graduation details</h2>
	                 <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12 date ">
	       					 <aui:input name="graduationDate" label="graduationDate"  cssClass="form-control col-md-7 col-xs-12 myDatepicker">
							 </aui:input>
							  <span class="input-group-addon">
                               <span class="glyphicon glyphicon-calendar"></span>
                             </span>
					   	  </div>
					   </div>
					   <div class="form-group">
	                     <label class="control-label col-md-3 col-sm-3 col-xs-12">Actively Seeking Employment</label>
	                     <div class="col-md-6 col-sm-6 col-xs-12 gender-select">
	                     	<aui:input id="yes"  type="radio" name="activelySeekingEmployment" value="Yes" label="" />
                       		<label for="<portlet:namespace/>yes">Yes</label>
                       		
                       		<aui:input id="no"  type="radio" name="activelySeekingEmployment" value="No" label="" />
                       		<label for="<portlet:namespace/>no">No</label>
	                     </div>
	                   </div>
	                   <div class="ln_solid"></div>	
    				 	<div class="form-group">
				        	<div class="col-md-10 col-sm-6 col-xs-12 col-md-offset-3">
								<aui:button type="button" value="Submit"  cssClass="addUserBtn btn btn-success"/>
							</div>
						</div>	
	               </div>
	              </aui:form>
	            </div>
	            <!-- End SmartWizard Content -->
        	</div>
		</div>
	</div>
</div>


            
<script>
jQuery.noConflict();
(function($) {
    $(function() {
    	 jQuery('.myDatepicker').datetimepicker({
		        format: 'MM/DD/YYYY'
		    });
    });
})(jQuery);
</script>      		
            
<aui:script>

AUI().use('aui-io-request', 'aui-autocomplete' ,'aui-base','aui-form-validator','autocomplete-list','autocomplete-filters','autocomplete-highlighters', function(A) {
	
	var pns='<portlet:namespace/>';
	var addUserBtn= A.one(".addUserBtn");
	addUserBtn.on('click', function(e) {
		var formValidator = Liferay.Form.get('<portlet:namespace />addStudentFm').formValidator;
		formValidator.validate();
		if(!formValidator.hasErrors()){
			document.<portlet:namespace />addStudentFm.submit();
		}
	});
   
	var schoolSelect = A.one("#<portlet:namespace />school");
	
	schoolSelect.on('change', function(e) {
		
		console.log("schoolId->" + this.get('value'));
		var getSchoolDetailURL = '${getSchoolDetailURL}';
		
		A.io.request(getSchoolDetailURL.toString(),{
			dataType: 'json',
			method: 'GET',
			data :{
				'<portlet:namespace/>schoolId' : this.get('value')
			},
			on: {
			success: function() {
				A.one('#<portlet:namespace/>campus').all('option').remove();
				var schoolDetail=this.get('responseData');
				A.one('#'+pns+'campus').append("<option  value='' >Please Select Campus</option> ");
				for(var i in schoolDetail.campuses){
					  if(i==0){
					  	A.one('#'+pns+'campus').append("<option selected='selected' value='"+ schoolDetail.campuses[i].campusId +"' >"+ schoolDetail.campuses[i].name +"</option> ");
					  }else{
						  A.one('#'+pns+'campus').append("<option  value='"+ schoolDetail.campuses[i].campusId +"' >"+ schoolDetail.campuses[i].name +"</option> ");
					  }
				}
			}
		  }
		
		});
	});
	
	// Add externship radio button
	var externshipDetailRadioBtns = A.all("input[name=<portlet:namespace/>haveExternship]");
	console.log("externshipDetailRadioBtns ->" + externshipDetailRadioBtns._nodes.length);
	for(var i = 0; i < externshipDetailRadioBtns._nodes.length; i++) {
		externshipDetailRadioBtns._nodes[i].onclick = function() {
			if(this.value==='true'){
				A.one(".externship-data").show();
			}else if(this.value==='false'){
				A.one(".externship-data").hide();
			}
    	};
	}
	
	A.one(".externship-data").hide();
	
	var employerName = A.one("#<portlet:namespace/>employerName");
	console.log("employerName->" + employerName);
	var getEmployerDetailURL = '${getEmployerDetailURL}';
	employerName.on('change', function(e) {
		var employerId = this.get('value');
		if(employerId.trim() !==''){

			A.io.request(getEmployerDetailURL.toString(),{
			dataType: 'json',
			method: 'GET',
			data :{
				'<portlet:namespace/>employerId' : this.get('value')
			},
			on: {
			success: function() {
				var employerDetail=this.get('responseData');
				A.one("#<portlet:namespace/>employerZipCode").val(employerDetail.zipcode);
				A.one("#<portlet:namespace/>employerWebSiteLink").val(employerDetail.websitelink);
			}
		  }
		});
	   }else{
		   A.one("#<portlet:namespace/>employerZipCode").val('');
		   A.one("#<portlet:namespace/>employerWebSiteLink").val('');
	   }
	});
	
});
</aui:script>              