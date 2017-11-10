<%@ include file="../init.jsp" %>

<portlet:actionURL var="addStudentURL" name="/add_student">
</portlet:actionURL>
<portlet:resourceURL id="/getSchoolDetail" var="getSchoolDetailURL"></portlet:resourceURL>
<portlet:resourceURL id="/getPartnerDetail" var="getPartnerDetailURL"></portlet:resourceURL>
<div class="page-title">
	<div class="title_left">
     	 <c:choose>
     	 	<c:when test="${studentId eq 0 }">
     	 		<h2>Add New Student</h2>
     	 	</c:when>
     	 	<c:otherwise>
     	 		<h2>Edit Student</h2>
     	 	</c:otherwise>	
     	 </c:choose>
    </div>
</div>

<div class="clearfix"></div>
		
<div class="row add-student-fm">
	<div class="col-md-12 col-sm-12 col-xs-12">
   		<div class="x_panel">
    		<div class="x_content">
        		<br />
        		<!-- Smart Wizard -->
	            <div id="wizard" class="form_wizard wizard_horizontal">
	              <ul class="wizard_steps">
	                <li>
                         <a href="#step-1" id="step1btn">
                           <span class="step_no">1</span>
                           <span class="step_descr"> Personal Details</span>
                         </a>
                       </li>
                       <li>
                         <a href="#step-2" id="step2btn" >
                           <span class="step_no">2</span>
                           <span class="step_descr"> Academic Info</span>
                         </a>
                       </li>
                       <li>
                         <a href="#step-3" id="step3btn">
                           <span class="step_no">3</span>
                           <span class="step_descr">Externship details</span>
                         </a>
                       </li>
                       <li>
                         <a href="#step-4" id="step4btn">
                           <span class="step_no">4</span>
                           <span class="step_descr">Graduation details</span>
                         </a>
                       </li>
	              </ul>
	              <aui:form name="addStudentFm" action="${addStudentURL}" cssClass="form-horizontal form-label-left" enctype="multipart/form-data">
	              	<div id="step-1" class="stepContent">
	                   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="campusStudentId" label="studentId"  cssClass="form-control col-md-7 col-xs-12" value="${studentBean.stundetCampusId }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">20</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="firstName" label="firstName"  cssClass="form-control col-md-7 col-xs-12" value="${studentBean.firstName}">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">30</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="middleName" label="middleName"  cssClass="form-control col-md-7 col-xs-12" value="${studentBean.middleName }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">30</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="lastName" label="lastName"  cssClass="form-control col-md-7 col-xs-12" value="${studentBean.lastName }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">30</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>	
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="emailAddress" label="emailAddress"  cssClass="form-control col-md-7 col-xs-12" value="${studentBean.emailAddress }">
						     	<aui:validator name="required" />
						     	<aui:validator name="email" />
						     	<aui:validator name="maxLength">30</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>	  
	                   <div class="form-group">
	                     <div class="col-md-10 col-sm-6 col-xs-12">
	                       <aui:input name="profilePic" type="file" label="Profile Picture" cssClass="form-control col-md-7 col-xs-12">
	                       		<aui:validator name="acceptFiles">'jpg,png,jpeg'</aui:validator>
	                       </aui:input>
	                     </div>
	                   </div>
	                   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12 date ">
	                   	  	 <fmt:formatDate pattern = "MM/dd/yyyy" value = "${studentBean.dateOfBirth}" var="dob" />
	       					 <aui:input name="dob" label="dob"  cssClass="form-control col-md-7 col-xs-12 myDatepicker" value="${ dob}">
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
	                     	<aui:input id="male"  type="radio" name="gender" value="Male" label=""  checked='${studentBean.gender eq "Male"}'>
	                     		 <aui:validator name="required" />
	                     	</aui:input>
                       		<label for="<portlet:namespace/>male">Male</label>
                       		
                       		<aui:input id="female"  type="radio" name="gender" value="Female" label="" checked='${studentBean.gender eq "Female"}'>
                       			<aui:validator name="required" />
                       		</aui:input>
                       		<label for="<portlet:namespace/>male">Female</label>
                       		
                       		<aui:input id="LGBT"  type="radio" name="gender" value="LGBT" label="" checked='${studentBean.gender eq "LGBT"}'>
                       			<aui:validator name="required" />
                       		</aui:input>
                       		<label for="<portlet:namespace/>LGBT">LGBT</label>
	                     </div>
	                   </div>
	                   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="contactNo" label="contactNo"  cssClass="form-control col-md-7 col-xs-12" value="${studentBean.contactNumber }" placeholder="xxx-xxx-xxxx">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">14</aui:validator>
							 </aui:input>
							 <aui:script>
								new Formatter(document.getElementById('<portlet:namespace/>'+'contactNo'), {
									'pattern': '({{999}})-{{999}}-{{9999}}',
									'persistent': false
								});
							</aui:script>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="homePhoneNumber" label="homePhoneNumber"  cssClass="form-control col-md-7 col-xs-12" value="${studentBean.homeNumber }" placeholder="xxx-xxx-xxxx">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">14</aui:validator>
							 </aui:input>
							 <aui:script>
								new Formatter(document.getElementById('<portlet:namespace/>'+'homePhoneNumber'), {
									'pattern': '({{999}})-{{999}}-{{9999}}',
									'persistent': false
								});
							</aui:script>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:select name="primaryLanguage" label="primaryLanguage"  cssClass="form-control col-md-7 col-xs-12" multiple="true">
								<aui:option value="English" selected='${fn:indexOf(studentBean.primaryLanguages, "English") ge 0}'>English</aui:option>
								<aui:option value="French" selected='${fn:indexOf(studentBean.primaryLanguages, "French") ge 0}'>French</aui:option>
								<aui:option value="Spanish" selected='${fn:indexOf(studentBean.primaryLanguages, "Spanish") ge 0}'>Spanish</aui:option>
								<aui:option value="Chinese - Mandarin" selected='${fn:indexOf(studentBean.primaryLanguages, "Chinese - Mandarin") ge 0}'>Chinese - Mandarin</aui:option>
								<aui:option value="Chinese -Cantonese" selected='${fn:indexOf(studentBean.primaryLanguages, "Chinese -Cantonese") ge 0}'>Chinese -Cantonese</aui:option>
								<aui:option value="Tagalog" selected='${fn:indexOf(studentBean.primaryLanguages, "Tagalog") ge 0}'>Tagalog</aui:option>
								<aui:option value="Vietnamese" selected='${fn:indexOf(studentBean.primaryLanguages, "Vietnamese") ge 0}'>Vietnamese</aui:option>
								<aui:option value="Korean" selected='${fn:indexOf(studentBean.primaryLanguages, "Korean") ge 0}'>Korean</aui:option>
								<aui:option value="German" selected='${fn:indexOf(studentBean.primaryLanguages, "German") ge 0}'>German</aui:option>
								<aui:option value="Arabic" selected='${fn:indexOf(studentBean.primaryLanguages, "Arabic") ge 0}'>Arabic</aui:option>
								<aui:option value="Russian" selected='${fn:indexOf(studentBean.primaryLanguages, "Russian") ge 0}'>Russian</aui:option>
								<aui:option value="Italian" selected='${fn:indexOf(studentBean.primaryLanguages, "Italian") ge 0}'>Italian</aui:option>
								<aui:option value="Portuguese" selected='${fn:indexOf(studentBean.primaryLanguages, "Portuguese") ge 0}'>Portuguese</aui:option>
								<aui:option value="Hindi" selected='${fn:indexOf(studentBean.primaryLanguages, "Hindi") ge 0}'>Hindi</aui:option>
								<aui:option value="Polish" selected='${fn:indexOf(studentBean.primaryLanguages, "Polish") ge 0}'>Polish</aui:option>
								<aui:option value="Japanese" selected='${fn:indexOf(studentBean.primaryLanguages, "Japanese") ge 0}'>Japanese</aui:option>
								<aui:option value="Urdu" selected='${fn:indexOf(studentBean.primaryLanguages, "Urdu") ge 0}'>Urdu</aui:option>
								<aui:option value="Persian" selected='${fn:indexOf(studentBean.primaryLanguages, "Persian") ge 0}'>Persian</aui:option>
								<aui:option value="Gujarati" selected='${fn:indexOf(studentBean.primaryLanguages, "Gujarati") ge 0}'>Gujarati</aui:option>
								<aui:option value="Greek" selected='${fn:indexOf(studentBean.primaryLanguages, "Greek") ge 0}'>Greek</aui:option>
								<aui:option value="Bengali" selected='${fn:indexOf(studentBean.primaryLanguages, "Bengali") ge 0}'>Bengali</aui:option>
								<aui:option value="Panjabi" selected='${fn:indexOf(studentBean.primaryLanguages, "Panjabi") ge 0}'>Panjabi</aui:option>
								<aui:option value="Telugu" selected='${fn:indexOf(studentBean.primaryLanguages, "Telugu") ge 0}'>Telugu</aui:option>
								<aui:option value="Armenian" selected='${fn:indexOf(studentBean.primaryLanguages, "Armenian") ge 0}'>Armenian</aui:option>
								<aui:option value="Hmong" selected='${fn:indexOf(studentBean.primaryLanguages, "Hmong") ge 0}'>Hmong</aui:option>
							 </aui:select>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:select name="secondaryLanguage" label="secondaryLanguage"  cssClass="form-control col-md-7 col-xs-12" multiple="true">
								<aui:option value="English" selected='${fn:indexOf(studentBean.secondaryLanguage, "English") ge 0}'>English</aui:option>
								<aui:option value="French" selected='${fn:indexOf(studentBean.secondaryLanguage, "French") ge 0}'>French</aui:option>
								<aui:option value="Spanish" selected='${fn:indexOf(studentBean.secondaryLanguage, "Spanish") ge 0}'>Spanish</aui:option>
								<aui:option value="Chinese - Mandarin" selected='${fn:indexOf(studentBean.secondaryLanguage, "Chinese - Mandarin") ge 0}'>Chinese - Mandarin</aui:option>
								<aui:option value="Chinese -Cantonese" selected='${fn:indexOf(studentBean.secondaryLanguage, "Chinese -Cantonese") ge 0}'>Chinese -Cantonese</aui:option>
								<aui:option value="Tagalog" selected='${fn:indexOf(studentBean.secondaryLanguage, "Tagalog") ge 0}'>Tagalog</aui:option>
								<aui:option value="Vietnamese" selected='${fn:indexOf(studentBean.secondaryLanguage, "Vietnamese") ge 0}'>Vietnamese</aui:option>
								<aui:option value="Korean" selected='${fn:indexOf(studentBean.secondaryLanguage, "Korean") ge 0}'>Korean</aui:option>
								<aui:option value="German" selected='${fn:indexOf(studentBean.secondaryLanguage, "German") ge 0}'>German</aui:option>
								<aui:option value="Arabic" selected='${fn:indexOf(studentBean.secondaryLanguage, "Arabic") ge 0}'>Arabic</aui:option>
								<aui:option value="Russian" selected='${fn:indexOf(studentBean.secondaryLanguage, "Russian") ge 0}'>Russian</aui:option>
								<aui:option value="Italian" selected='${fn:indexOf(studentBean.secondaryLanguage, "Italian") ge 0}'>Italian</aui:option>
								<aui:option value="Portuguese" selected='${fn:indexOf(studentBean.secondaryLanguage, "Portuguese") ge 0}'>Portuguese</aui:option>
								<aui:option value="Hindi" selected='${fn:indexOf(studentBean.secondaryLanguage, "Hindi") ge 0}'>Hindi</aui:option>
								<aui:option value="Polish" selected='${fn:indexOf(studentBean.secondaryLanguage, "Polish") ge 0}'>Polish</aui:option>
								<aui:option value="Japanese" selected='${fn:indexOf(studentBean.secondaryLanguage, "Japanese") ge 0}'>Japanese</aui:option>
								<aui:option value="Urdu" selected='${fn:indexOf(studentBean.secondaryLanguage, "Urdu") ge 0}'>Urdu</aui:option>
								<aui:option value="Persian" selected='${fn:indexOf(studentBean.secondaryLanguage, "Persian") ge 0}'>Persian</aui:option>
								<aui:option value="Gujarati" selected='${fn:indexOf(studentBean.secondaryLanguage, "Gujarati") ge 0}'>Gujarati</aui:option>
								<aui:option value="Greek" selected='${fn:indexOf(studentBean.secondaryLanguage, "Greek") ge 0}'>Greek</aui:option>
								<aui:option value="Bengali" selected='${fn:indexOf(studentBean.secondaryLanguage, "Bengali") ge 0}'>Bengali</aui:option>
								<aui:option value="Panjabi" selected='${fn:indexOf(studentBean.secondaryLanguage, "Panjabi") ge 0}'>Panjabi</aui:option>
								<aui:option value="Telugu" selected='${fn:indexOf(studentBean.secondaryLanguage, "Telugu") ge 0}'>Telugu</aui:option>
								<aui:option value="Armenian" selected='${fn:indexOf(studentBean.secondaryLanguage, "Armenian") ge 0}'>Armenian</aui:option>
								<aui:option value="Hmong" selected='${fn:indexOf(studentBean.primaryLanguages, "Hmong") ge 0}'>Hmong</aui:option>
							 </aui:select>
					   	  </div>
					   </div>
	                    <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="address" label="address"  cssClass="form-control col-md-7 col-xs-12" value="${studentBean.address }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">100</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="city" label="city"  cssClass="form-control col-md-7 col-xs-12" value="${studentBean.city }">
						     	<aui:validator name="required" />
						     	<aui:validator name="maxLength">50</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
	                   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="zipcode" label="zipcode"  cssClass="form-control col-md-7 col-xs-12" value="${studentBean.zipcode }">
						     	<aui:validator name="required" />
						     	<aui:validator name="number" />
						     	<aui:validator name="maxLength">6</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
	                   <div class="form-group">
               		   	 	<div class="col-md-10 col-sm-6 col-xs-12">
	               				<aui:select name="state" label="state" cssClass="form-control col-md-7 col-xs-12" value="${studentBean.state }">
	               					<c:forEach items="${usStateList }" var="state">
	               						<aui:option value="${state }" selected="${studentBean.state eq state? true:false }">${state }</aui:option>
	               					</c:forEach>
	               				</aui:select>
							</div>
			  			</div>
	               </div>
	               <div id="step-2" class="stepContent">
	                 <h2 class="StepTitle">Academic Info</h2>
	                    <div class="form-group">
               		   	 	<div class="col-md-10 col-sm-6 col-xs-12">
               		   	 		<aui:select name="pace" label="pace">
               		   	 			<aui:option value="Slow" selected='${studentBean.pace eq "Slow"? true : false }'>Slow</aui:option>
               		   	 			<aui:option value="Mid" selected='${studentBean.pace eq "Mid"? true : false }'>Mid</aui:option>
               		   	 			<aui:option value="Quick" selected='${studentBean.pace eq "Quick"? true : false }'>Quick</aui:option>
               		   	 		</aui:select>
               		   	 	</div>
               		   	 </div>
               		   	 <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="gpa" label="gpa"  cssClass="form-control col-md-7 col-xs-12" value="${studentBean.gpa }">
						     	<aui:validator name="required" />
						     	<aui:validator name="custom" errorMessage="err-valid-task-price">
									function(val, fieldNode, ruleValue) {
				             			if(isNaN(val) || val.length==0){
				             				return false;
				             			}
				             			console.log(parseFloat(val));
				             			if(parseFloat(val)>4.0 || parseFloat(val) < 0.0){
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
   					 					<aui:option value="${school.schoolId }" selected="${studentBean.schoolId eq  school.schoolId ? true : false}"> ${school.name }</aui:option>
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
               		   	 			<aui:option value="Dental Assistant" selected='${studentBean.profession eq "Dental Assistant" ? true : false }'>Dental Assistant</aui:option>
               		   	 			<aui:option value="Medical Assistant" selected='${studentBean.profession eq "Medical Assistant" ? true : false }'>Medical Assistant</aui:option>
               		   	 			<aui:option value="Medical Administrative Assistance" selected='${studentBean.profession eq "Medical Administrative Assistance" ? true : false }'>Medical Administrative Assistance</aui:option>
               		   	 			<aui:option value="Phlebotomy" selected='${studentBean.profession eq "Phlebotomy" ? true : false }'>Phlebotomy</aui:option>
               		   	 			<aui:option value="Pharmacy Technician" selected='${studentBean.profession eq "Pharmacy Technician" ? true : false }'>Pharmacy Technician</aui:option>
               		   	 			<aui:option value="Patient Care Technician" selected='${studentBean.profession eq "Patient Care Technician" ? true : false }'>Patient Care Technician</aui:option>
               		   	 			<aui:option value="Veterinary Assistant" selected='${studentBean.profession eq "Veterinary Assistant" ? true : false }'>Veterinary Assistant</aui:option>
               		   	 			<aui:option value="Sonography" selected='${studentBean.profession eq "Sonography" ? true : false }'>Sonography</aui:option>
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
	               <div id="step-3" class="stepContent">
	                 <h2 class="StepTitle">Externship details</h2>
	                 <div class="form-group">
	                     <label class="control-label col-md-3 col-sm-3 col-xs-12">Do you want to add Externship Detail?</label>
	                     <div class="col-md-6 col-sm-6 col-xs-12 gender-select">
	                     	<aui:input id="yes"  type="radio" name="haveExternship" value="true" label="" checked="${studentBean.haveExternship}"/>
                       		<label for="<portlet:namespace/>yes">Yes</label>
                       		
                       		<aui:input id="no"  type="radio" name="haveExternship" value="false" label="" checked="${!studentBean.haveExternship }"/>
                       		<label for="<portlet:namespace/>no">No</label>
	                     </div>
	                   </div>
	                   <div class="externship-data">
	                   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
							 <aui:select name="partnerName" label="partner.name">
							 <aui:option value="">Please Select Partner</aui:option>
							 	<c:forEach items="${partnerBeanList }" var="partnerBean">
							 		<aui:option value="${partnerBean.partnerId }" selected="${studentExternShipBean.partnerId eq partnerBean.partnerId ? true : false }">${partnerBean.firstName } ${partnerBean.lastName }</aui:option>
							 	</c:forEach>
							 </aui:select>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="partnerZipCode" label="partner.zipcode"  cssClass="form-control col-md-7 col-xs-12" readonly="true" value="${studentExternShipBean.partnerBean.zipcode }">
						     	<aui:validator name="maxLength">6</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="partnerWebSiteLink" label="partner.websitelink"  cssClass="form-control col-md-7 col-xs-12" readonly="true" value="${studentExternShipBean.partnerBean.websiteLink }">
						     	<aui:validator name="maxLength">50</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
	                   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12 date ">
	                   	  	 <fmt:formatDate pattern = "MM/dd/yyyy" value = "${studentExternShipBean.startDate}" var="extershipStartDate" />
	       					 <aui:input name="externshipStartDate" label="externship.start.date"  cssClass="form-control col-md-7 col-xs-12" value="${extershipStartDate }">
							 </aui:input>
							  <span class="input-group-addon">
                               <span class="glyphicon glyphicon-calendar"></span>
                             </span>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12 date">
	                   	  	<fmt:formatDate pattern = "MM/dd/yyyy" value = "${studentExternShipBean.endDate}" var="extershipEndDate" />
	       					 <aui:input name="externshipEndDate" label="externship.end.date"  cssClass="form-control col-md-7 col-xs-12" value="${extershipEndDate }">
							 </aui:input>
							  <span class="input-group-addon">
                               <span class="glyphicon glyphicon-calendar"></span>
                             </span>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="noOfHoursPerWeek" label="no.of.hours"  cssClass="form-control col-md-7 col-xs-12" value="${studentExternShipBean.noOfHoursPerWeek }">
						     	<aui:validator name="number" />
						     	<aui:validator name="maxLength">2</aui:validator>
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12 date">
	                   	  	<fmt:formatDate pattern = "MM/dd/yyyy" value = "${studentExternShipBean.midPointReview}" var="midPointReviewDate" />
	       					 <aui:input name="midPointReviewDate" label="mid.point.review.date"  cssClass="form-control col-md-7 col-xs-12" value="${midPointReviewDate }">
							 </aui:input>
							  <span class="input-group-addon">
                               <span class="glyphicon glyphicon-calendar"></span>
                             </span>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="midPointReviewComment" type="textarea" label="mid.point.review.comment"  cssClass="form-control col-md-7 col-xs-12" value="${studentExternShipBean.midPointReviewComment }">
							 </aui:input>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12 date">
	       					 <fmt:formatDate pattern = "MM/dd/yyyy" value = "${studentExternShipBean.finalReview}" var="finalReviewDate" />
	       					 <aui:input name="finalReviewDate" label="final.point.review.date"  cssClass="form-control col-md-7 col-xs-12 myDatepicker" value="${finalReviewDate }">
							 </aui:input>
							  <span class="input-group-addon">
                               <span class="glyphicon glyphicon-calendar"></span>
                             </span>
					   	  </div>
					   </div>
					   <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12">
	       					 <aui:input name="finalPointReviewComment" type="textarea" label="final.point.review.comment"  cssClass="form-control col-md-7 col-xs-12" value="${ studentExternShipBean.finalReviewComment}">
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
	                       <input type="file" id="agreeements" name="agreements" required="required" class="form-control col-md-7 col-xs-12" multiple="multiple">
	                     </div>
	                   </div>
	                   <div class="form-group">
	                     <label class="control-label col-md-3 col-sm-3 col-xs-12">Hire</label>
	                     <div class="col-md-6 col-sm-6 col-xs-12 gender-select">
	                     	<aui:input id="yes"  type="radio" name="hired" value="true" label="" checked="${studentBean.hired}"/>
                       		<label for="<portlet:namespace/>yes">Yes</label>
                       		
                       		<aui:input id="no"  type="radio" name="hired" value="false" label=""  checked="${!studentBean.hired}"/>
                       		<label for="<portlet:namespace/>no">No</label>
	                     </div>
	                   </div>
	                   </div>
	               </div>
	               <div id="step-4" class="stepContent">
	                 <h2 class="StepTitle">Graduation details</h2>
	                 <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12 date ">
	       					 <fmt:formatDate pattern = "MM/dd/yyyy" value = "${studentBean.graduationDate}" var="graduationDate" />
	       					 <aui:input name="graduationDate" label="graduationDate"  cssClass="form-control col-md-7 col-xs-12 myDatepicker" value="${graduationDate }">
							 </aui:input>
							  <span class="input-group-addon">
                               <span class="glyphicon glyphicon-calendar"></span>
                             </span>
					   	  </div>
					  </div>
					  <div class="form-group">
	                   	  <div class="col-md-10 col-sm-6 col-xs-12 date ">
	                   	  		<aui:select name="employer" label="employer">
	                   	  			<aui:option value="">Please select Employer</aui:option>
	                   	  			<c:forEach items="${ employerList}" var="employer">
	                   	  				<aui:option value="${employer.employerId }" selected="${employer.employerId eq  studentExternShipBean.employerId? true : false}">${employer.firstName } ${employer.lastName }</aui:option>
	                   	  			</c:forEach>
	                   	  		</aui:select>
	                   	  </div>
	                  </div> 	  
					  <div class="form-group">
	                     <label class="control-label col-md-3 col-sm-3 col-xs-12">Actively Seeking Employment</label>
	                     <div class="col-md-6 col-sm-6 col-xs-12 gender-select">
	                     	<aui:input id="yes"  type="radio" name="activelySeekingEmployment" value="true" label=""  checked="${studentBean.activelySeekingEmployment }">
	                     		 <aui:validator name="required" />
	                     	</aui:input>
                       		<label for="<portlet:namespace/>yes">Yes</label>
                       		
                       		<aui:input id="no"  type="radio" name="activelySeekingEmployment" value="false" label="" checked="${!studentBean.activelySeekingEmployment }">
                       			<aui:validator name="required" />
                       		</aui:input>
                       		<label for="<portlet:namespace/>no">No</label>
	                     </div>
	                   </div>
	                   <aui:input type="hidden" value="${studentId }" name="studentId"/>
	                   <div class="ln_solid"></div>	
    				 	<div class="form-group">
				        	<div class="col-md-10 col-sm-6 col-xs-12 col-md-offset-3">
								<aui:button type="button" value="Submit"  cssClass="addUserBtn btn btn-success"/>
							</div>
						</div>	
	               </div>
	              </aui:form>
	              <div class="actionBar">
                   	<a class="buttonPrevious btn btn-primary">Previous</a>
                   	<a  class="buttonNext btn btn-success">Next</a>
                   </div>
	            </div>
	            <!-- End SmartWizard Content -->
        	</div>
		</div>
	</div>
</div>


            
<script>
var studentId='${studentId}';
jQuery.noConflict();
(function($) {
    $(function() {
    	 jQuery('.myDatepicker').datetimepicker({
		        format: 'MM/DD/YYYY'
		 });
    	 
    	    $('#<portlet:namespace/>externshipStartDate').datetimepicker({
		        format: 'MM/DD/YYYY'
   		    });
	        $('#<portlet:namespace/>externshipEndDate').datetimepicker({
	            useCurrent: false,
	            format: 'MM/DD/YYYY' 
	        });
	        $('#<portlet:namespace/>midPointReviewDate').datetimepicker({
	            useCurrent: false,
	            format: 'MM/DD/YYYY'
	        });
	        
	        $('#<portlet:namespace/>finalReviewDate').datetimepicker({
		        format: 'MM/DD/YYYY',
		        useCurrent: false
   		    });
	        
	        $("#<portlet:namespace/>externshipStartDate").on("dp.change", function (e) {
	            $('#<portlet:namespace/>externshipEndDate').data("DateTimePicker").minDate(e.date);
	            $("#<portlet:namespace/>midPointReviewDate").data("DateTimePicker").minDate(e.date);
	            $("#<portlet:namespace/>finalReviewDate").data("DateTimePicker").minDate(e.date);
	        });
	        $("#<portlet:namespace/>externshipEndDate").on("dp.change", function (e) {
	            $('#<portlet:namespace/>externshipStartDate').data("DateTimePicker").maxDate(e.date);
	            $("#<portlet:namespace/>midPointReviewDate").data("DateTimePicker").maxDate(e.date);
	            $("#<portlet:namespace/>finalReviewDate").data("DateTimePicker").maxDate(e.date);
	        });
    	 
     AUI().use('aui-io-request','aui-base','aui-form-validator', function(A) { 
    	
    	 var step1Validator = new A.FormValidator({
				boundingBox: document.<portlet:namespace/>addStudentFm,
				rules: {
					<portlet:namespace/>campusStudentId: {
						required: true
					},
					<portlet:namespace/>firstName: {
						required: true
					},
					<portlet:namespace/>lastName: {
						required: true
					},
					<portlet:namespace/>middleName: {
						required: true
					},
					<portlet:namespace/>emailAddress: {
						required: true
					},
					<portlet:namespace/>dob: {
						required: true
					},
					<portlet:namespace/>gender: {
						required: true
					},
					<portlet:namespace/>contactNo: {
						required: true
					},
					<portlet:namespace/>homePhoneNumber: {
						required: true
					},
					<portlet:namespace/>primaryLanguage: {
						required: true
					},
					<portlet:namespace/>secondaryLanguage: {
						required: true
					},
					<portlet:namespace/>address: {
						required: true
					},
					<portlet:namespace/>city: {
						required: true
					},
					<portlet:namespace/>zipcode: {
						required: true
					},
					<portlet:namespace/>state: {
						required: true
					}
				}
			});
			
			var step2Validator = new A.FormValidator({
				boundingBox: document.<portlet:namespace/>addStudentFm,
				rules: {
					<portlet:namespace/>pace: {
						required: true
					},
					<portlet:namespace/>gpa: {
						required: true
					},
					<portlet:namespace/>school: {
						required: true
					},
					<portlet:namespace/>campus: {
						required: true
					},
					<portlet:namespace/>profession: {
						required: true
					}
				}
			});
			
			var step3Validator = new A.FormValidator({
				boundingBox: document.<portlet:namespace/>addStudentFm,
				rules: {
					<portlet:namespace/>partnerName: {
						required: true
					},
					<portlet:namespace/>externshipStartDate: {
						required: true
					},
					<portlet:namespace/>externshipEndDate: {
						required: true
					},
					<portlet:namespace/>noOfHoursPerWeek: {
						required: true
					},
					<portlet:namespace/>midPointReviewDate: {
						required: true
					},
					<portlet:namespace/>finalReviewDate: {
						required: true
					}
				}
			});
			
    	jQuery("#step1btn").addClass("selected");
 		jQuery("#step2btn, #step3btn, #step4btn").addClass("disabled");
 		jQuery("#step-2, #step-3, #step-4").addClass("deActive");
 		jQuery(".buttonPrevious").addClass("buttonDisabled");
    	 
 		$(".buttonNext").on('click',function(){
 			console.log("next clicked");
 			
 			/* On Step 1 Completed Go To Step 2 */
     		if(jQuery("#step1btn").hasClass("selected")){
     			
     			step1Validator.validate();
     			if(step1Validator.hasErrors()){
     				return false;
     			}
     			
     			jQuery("#step1btn").addClass("done").removeClass("selected");
     			jQuery("#step2btn").addClass("selected").removeClass("disabled");
     			jQuery("#step3btn, #step4btn").addClass("disabled");
     			jQuery(".buttonPrevious").removeClass("buttonDisabled")
     			jQuery(".stepContent").removeClass("Active").addClass("deActive");
     			jQuery("#step-2").addClass("Active").removeClass("deActive");
     		}
     		/* On Step 2 Completed Go To Step 3 */
     		else if(jQuery("#step2btn").hasClass("selected")){
     			
     			step2Validator.validate();
     			if(step2Validator.hasErrors()){
     				return false;
     			}
     			
     			
     			jQuery("#step2btn").addClass("done").removeClass("selected");
     			jQuery("#step3btn").addClass("selected").removeClass("disabled");
     			jQuery("#step4btn").addClass("disabled");
     			jQuery(".buttonPrevious").removeClass("buttonDisabled")
     			jQuery(".stepContent").removeClass("Active").addClass("deActive");
     			jQuery("#step-3").addClass("Active").removeClass("deActive");
     		}
     		/* On Step 3 Completed Go To Step 4 */
     		else if(jQuery("#step3btn").hasClass("selected")){
     			
     			// Check haveExternship radio is checked or not
     			var haveExternship = $("#<portlet:namespace />yes").is(":checked");
     			if(haveExternship){
     				step3Validator.validate();
         			if(step3Validator.hasErrors()){
         				return false;
         			}
     			}
     			
     			jQuery("#step3btn").addClass("done").removeClass("selected");
     			jQuery("#step4btn").addClass("selected").removeClass("disabled");
     			jQuery(".buttonPrevious").removeClass("buttonDisabled")
     			jQuery(".stepContent").removeClass("Active").addClass("deActive");
     			jQuery("#step-4").addClass("Active").removeClass("deActive");
     		}
 		});
     	
    	 $(".buttonPrevious").on('click',function(){
    		 console.log("previous clicked");
    		 
    		 
    		 /* From Step 2 TO Step 1 Transmit */
      		if(jQuery("#step2btn").hasClass("selected")){
      			jQuery("#step1btn").addClass("selected").removeClass("done");
      			jQuery("#step2btn").removeClass("selected")
      			jQuery("#step2btn, #step3btn, #step4btn").addClass("disabled");
      			jQuery(".buttonPrevious").addClass("buttonDisabled")
      			jQuery(".stepContent").removeClass("Active").addClass("deActive");
      			jQuery("#step-1").addClass("Active").removeClass("deActive");
      		}
      		/* From Step 3 TO Step 2 Transmit */
      		 else if(jQuery("#step3btn").hasClass("selected")){
      			jQuery("#step2btn").addClass("selected").removeClass("done");
       			jQuery("#step3btn").removeClass("selected")
       			jQuery("#step3btn, #step4btn").addClass("disabled");
       			jQuery(".buttonPrevious").removeClass("buttonDisabled")
       			jQuery(".stepContent").removeClass("Active").addClass("deActive");
       			jQuery("#step-2").addClass("Active").removeClass("deActive");
      		} 
      		/* From Step 4 TO Step 3 Transmit */
      		 else if(jQuery("#step4btn").hasClass("selected")){
      			jQuery("#step3btn").addClass("selected").removeClass("done");
        			jQuery("#step4btn").removeClass("selected")
        			jQuery("#step4btn").addClass("disabled");
        			jQuery(".buttonPrevious").removeClass("buttonDisabled")
        			jQuery(".stepContent").removeClass("Active").addClass("deActive");
        			jQuery("#step-3").addClass("Active").removeClass("deActive");
      		} 
    	 });
    	 
    	 // EDIT Student : Start
    	 if(parseInt(studentId)>0){
    		 var addingExternship = '${addExternship}';
    		 console.log("addingExternship->" + addingExternship);
    	        if(addingExternship=='true'){
    	        	console.log("in if addingExternship");
    	        	jQuery("#step1btn").addClass("done").removeClass("selected");;
    	        	jQuery("#step2btn").addClass("done");
         			jQuery("#step3btn").addClass("selected").removeClass("disabled");
         			jQuery("#step4btn").addClass("disabled");
         			jQuery(".buttonPrevious").removeClass("buttonDisabled")
         			jQuery(".stepContent").removeClass("Active").addClass("deActive");
         			jQuery("#step-3").addClass("Active").removeClass("deActive")	
    	     	}
    	 }
    	 // EDIT Student : End
    	 
    	 
       }); 
    });
})(jQuery);
</script>      		
            
<aui:script>

AUI().use('aui-io-request', 'aui-autocomplete' ,'aui-base','aui-form-validator','autocomplete-list','autocomplete-filters','autocomplete-highlighters','node-event-simulate', function(A) {
	
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
				if(studentId>0){
					A.one("#<portlet:namespace/>campus").val('${studentBean.campusId}');
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
	
	var partnerName = A.one("#<portlet:namespace/>partnerName");
	console.log("partnerName->" + partnerName);
	var getPartnerDetailURL = '${getPartnerDetailURL}';
	partnerName.on('change', function(e) {
		var partnerId = this.get('value');
		if(partnerId.trim() !==''){

			A.io.request(getPartnerDetailURL.toString(),{
			dataType: 'json',
			method: 'GET',
			data :{
				'<portlet:namespace/>partnerId' : this.get('value')
			},
			on: {
			success: function() {
				var partnerDetail=this.get('responseData');
				A.one("#<portlet:namespace/>partnerZipCode").val(partnerDetail.zipcode);
				A.one("#<portlet:namespace/>partnerWebSiteLink").val(partnerDetail.websitelink);
			}
		  }
		});
	   }else{
		   A.one("#<portlet:namespace/>partnerZipCode").val('');
		   A.one("#<portlet:namespace/>partnerWebSiteLink").val('');
	   }
	});
	
	// EDIT : Start
	if(parseInt(studentId)>0){
		//Simulate school
		A.one("#<portlet:namespace/>school").simulate('change');
		A.one("#<portlet:namespace/>partnerName").simulate('change');
        var haveExternship = '${studentBean.haveExternship}';
		console.log("haveExternship->" + haveExternship);
        if(haveExternship=='true' || haveExternship==true){
			A.one(".externship-data").show();
		}
	}
	// EDIT : End
});
</aui:script>              