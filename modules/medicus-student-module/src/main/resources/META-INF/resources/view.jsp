<%@ include file="/init.jsp" %>

<portlet:renderURL var="addStudnetURL">
        <portlet:param name="mvcRenderCommandName" value="/add_student" />
</portlet:renderURL>
<portlet:renderURL var="importStudentURL">
        <portlet:param name="mvcRenderCommandName" value="/import_student" />
</portlet:renderURL>

<portlet:actionURL var="deleteStudentURL" name="/delete_student">
</portlet:actionURL>

<portlet:resourceURL id="/getSchoolDetail" var="getSchoolDetailURL"></portlet:resourceURL>

<portlet:resourceURL id="/search_studetns" var="searchStudentURL"></portlet:resourceURL>

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
		<c:if test="${hasStudentAddPermission }">
			<a href="${addStudnetURL }" class="btn btn-primary">Add New Student</a>
		</c:if>
		<c:if test="${hasStudentImportPermission }">
			<a href="${importStudentURL }" class="btn btn-primary">Import Students</a>
		</c:if>
  </div>
</div>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12">
	<div class="x_panel">
	  <div class="x_content">
		<c:choose>
			<c:when test="${isPartner and ! isPartnerSubscried}">
				<h3>You have not eligible to view students detail as you not subscribed plan. Please  subscribe <a href="/group/medicus/subscription">here</a>  </h3>
			</c:when>
			<c:otherwise>
				<div class="row student-list">
				  <div class="col-md-12 col-sm-12 col-xs-12 text-center">
				  	<form id="search-user-form" data-parsley-validate class="form-horizontal form-label-left">
		                  <div class="col-md-3 col-sm-3 col-xs-12">
		                    <input type="text" id="keyword" placeholder="Search keyword..." class="form-control col-md-7 col-xs-12">
		                  </div>
		                  <div class="col-md-2 col-sm-2 col-xs-12">
		                    <input type="text" id="zipcode" placeholder="Zipcode"  class="form-control col-md-7 col-xs-12">
		                  </div>
		                  <div class="col-md-2 col-sm-2 col-xs-12">
		                    <select class="form-control" name="schoolName"  id="gender">
		                      <option value="">Select Gender</option>
		                      <option value="Male">Male</option>
		                      <option value="Female">Female</option>
		                      <option value="LBGT">LGBT</option>
		                    </select>
		                  </div>
		                  <div class="col-md-3 col-sm-3 col-xs-12">
		                    <select class="form-control" name="profession" id="profession">
		                      <option value="">Select Profession</option>
		                      <option value="Dental Assistant">Dental Assistant</option>
		                      <option value="Medical Assistant">Medical Assistant</option>
		                      <option value="Medical Administrative Assistance">Medical Administrative Assistance</option>
		                      <option value="Phlebotomy">Phlebotomy</option>
		                      <option value="Pharmacy Technician">Pharmacy Technician</option>
		                      <option value="Patient Care Technician">Patient Care Technician</option>
		                      <option value="Veterinary Assistant">Veterinary Assistant</option>
		                      <option value="Sonography">Sonography </option>
		                    </select>
		                  </div>
		                  <div>
		                  <select name="language" id = "language"  cssClass="form-control col-md-7 col-xs-12" multiple="true">
								<option value="">Select Language</option>
								<option value="English">English</option>
								<option value="French" >French</option>
								<option value="Spanish" >Spanish</option>
								<option value="Chinese - Mandarin" >Chinese - Mandarin</option>
								<option value="Chinese -Cantonese" >Chinese -Cantonese</option>
								<option value="Tagalog" >Tagalog</option>
								<option value="Vietnamese" >Vietnamese</option>
								<option value="Korean" >Korean</option>
								<option value="German" >German</option>
								<option value="Arabic" >Arabic</option>
								<option value="Russian" >Russian</option>
								<option value="Italian" >Italian</option>
								<option value="Portuguese">Portuguese</option>
								<option value="Hindi" >Hindi</option>
								<option value="Polish" >Polish</option>
								<option value="Japanese" >Japanese</option>
								<option value="Urdu" >Urdu</option>
								<option value="Persian" >Persian</option>
								<option value="Gujarati" >Gujarati</option>
								<option value="Greek" >Greek</option>
								<option value="Bengali" >Bengali</option>
								<option value="Panjabi" >Panjabi</option>
								<option value="Telugu" >Telugu</option>
								<option value="Armenian" >Armenian</option>
								<option value="Hmong" >Hmong</option>
						      </select>
		                  </div>
		                  <div class="col-md-3 col-sm-3 col-xs-12">
		                  	   <select class="form-control" name="schoolId" id="schoolId">
		                			<option value=""> Select School</option>
		                			<c:forEach items="${schoolList }" var="school">
		 					 			<option value="${school.schoolId }"> ${school.name }</option>
		 					 		</c:forEach>
		 					 	</select>
		 				  </div>
		 				  <div class="col-md-3 col-sm-3 col-xs-12">
		                  	   <select class="form-control" name="campusId" id="campusId">
		                  	   		<option value=""> Select Campus</option>
		                  	   </select>
		                 </div> 	   	 				
		                  <div class="col-md-2 col-sm-2 col-xs-12 text-left">
		                    <button type="button" class="btn btn-success search-student">Submit</button>
		                  </div>
		                  <input type="hidden" id="userSchoolId" name="userSchoolId" value="${ userSchoolId}"/>
		                  <input type="hidden" id="userCampusId" name="userCampusId" value="${userCampusId }"/>
		         		</form>
		             	<br>
				  </div>
				  <div class="clearfix"></div>
				  <div class="studentList"></div>
				  <div class="clearfix"></div>
				  <div class="col-m-12 text-center load-more">
					<button class="btn btn-primary load-more-students" >Load More</button>
				  </div>
				</div>
		</c:otherwise>
		</c:choose>
	  </div>
	</div>
  </div>
</div>
<div id="interivew-request-modal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Interview Request</h4>
        <div class="msg">
        	
        </div>
      </div>
      <div class="modal-body">
       	<div class="form-group">
       	   <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
       	   		Are you sure you want to sent Interview Request?
       	   </div>
              <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                <button type="button" class="btn btn-primary sent-interview-request" onClick="javascript: jQuery('.modal-backdrop').remove()">Yes</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">No</button>
              </div>
         </div>
         <aui:input type="hidden" name="studentId"/>
      </div>
    </div>
  </div>
</div>

<div id="delete-student-modal" class="modal fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Delete Student</h4>
        <div class="msg">
        	
        </div>
      </div>
      <div class="modal-body">
       	<div class="form-group">
       	   <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
       	   		Are you sure you want to delete student?
       	   </div>
              <aui:form name="deletePartner" action="${deleteStudentURL}" cssClass="form-horizontal form-label-left">
	       	   <div class="col-md-8 col-sm-6 col-xs-12 col-md-offset-3 approve-request-box">
	       	   		<aui:input type="hidden" name="deletestudentId"/>
	       	   </div>
	           <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
	           		<aui:button type="submit" value="Yes"  cssClass="btn btn-success" onClick="javascript: jQuery('.modal-backdrop').remove()"/>
	                <button type="button" class="btn btn-primary" data-dismiss="modal">No</button>
	           </div>
           </aui:form>
         </div>
      </div>
    </div>
  </div>
</div>

<script>
 var studentFn={};
</script>

<aui:script>

AUI().use('aui-io-request', 'aui-autocomplete','liferay-portlet-url' ,'aui-base','aui-form-validator','autocomplete-list','autocomplete-filters','autocomplete-highlighters','node-event-simulate', function(A) {
	var searchStudentURL = '${searchStudentURL}';
	var pagetIndex=0;
	
	A.one(".load-more-students").on('click', function(){
		pagetIndex++;
		loadStudents(pagetIndex,true);
	});
	
	A.one(".search-student").on('click', function(){
		pagetIndex =0;
		loadStudents(pagetIndex,false);
	});
	
	A.one(".load-more").hide();
	
	 function loadStudents(pageIndex, loadmore){
		 
		 var resourceURL= Liferay.PortletURL.createResourceURL();
		 resourceURL.setPortletId('com_medicus_student_portlet_portlet_StudentModulePortlet');
		 resourceURL.setResourceId('/search_studetns');
		 resourceURL.setParameter("keyword",A.one("#keyword").val());
		 resourceURL.setParameter("zipcode",A.one("#zipcode").val());
		 resourceURL.setParameter("gender",A.one("#gender").val());
		 resourceURL.setParameter("profession",A.one("#profession").val());
		 resourceURL.setParameter("schoolId",A.one("#schoolId").val());
		 resourceURL.setParameter("campusId",A.one("#campusId").val());
		 resourceURL.setParameter("userSchoolId",userSchoolId);
		 resourceURL.setParameter("userCampusId", userCampusId);

		 
		 var languages = "";
		 var langNodes = A.all('#language option')._nodes;
		 for(var i=0;i<langNodes.length;i++){
			 console.log(langNodes[i].selected + " " + langNodes[i].value);
			 if(langNodes[i].selected && langNodes[i].value != ""){
			    	languages = languages + langNodes[i].value + ",";
			 }
		 }

		console.log("languages ->" + languages); 
		languages = languages.substring(0,languages.lastIndexOf(",")); 
		resourceURL.setParameter("languages",languages); 
		 
		A.io.request(resourceURL.toString(),{
			dataType: 'html',
			method: 'POST',
			data :{
				'<portlet:namespace/>pagetIndex' : pagetIndex
			},
			on: {
			success: function() {
				var students=this.get('responseData');
				console.log("loadmore->" + loadmore);
				if(loadmore){
					A.all(".show-load-more").remove();
					A.one(".studentList").append(students);
					var loadMore = A.one(".show-load-more").get('text');
					console.log("loadMore->" + loadMore==='true');
					if(loadMore==='true'){
						A.one(".load-more").show();
					}else{
						A.one(".load-more").hide();
					}
				}else{
					A.all(".show-load-more").remove();
					A.one(".studentList").html("");
					A.one(".studentList").append(students);
					var loadMore = A.one(".show-load-more").get('text');
					console.log("loadMore->" + loadMore==='true');
					if(loadMore==='true'){
						A.one(".load-more").show();
					}else{
						A.one(".load-more").hide();
					}
				}
				
			}
		  }
		});
	}
	 
	 var searchSchoolId = A.one("#schoolId");
		var  getSchoolDetailURL = '${getSchoolDetailURL}';
		searchSchoolId.on('change', function(e) {
			A.io.request(getSchoolDetailURL.toString(),{
				dataType: 'json',
				method: 'GET',
				data :{
					'<portlet:namespace/>schoolId' : this.get('value')
				},
				on: {
				success: function() {
					A.one('#campusId').all('option').remove();
					var schoolDetail=this.get('responseData');
					A.one('#campusId').append("<option  value='' >Select Campus</option> ");
					for(var i in schoolDetail.campuses){
					    A.one('#campusId').append("<option  value='"+ schoolDetail.campuses[i].campusId +"' >"+ schoolDetail.campuses[i].name +"</option> ");
					}
					if(parseInt(userCampusId)>0){
						A.one("#campusId").val(userCampusId);
					}
					
					loadStudents(pagetIndex,false);
				}
			  }
			
			});
		});
		
		var userSchoolId= A.one("#userSchoolId").get('value');
		var userCampusId = A.one("#userCampusId").get('value');
		if(parseInt(userSchoolId)>0){
			console.log("simulate");
			A.one("#schoolId").val(userSchoolId);
			A.one("#schoolId").simulate('change');
		}else{
			A.one("#schoolId").val("");
			loadStudents(pagetIndex,false);
		}
});
</aui:script>              

<script>
 jQuery.noConflict();
    (function($) {
      $(function() {
    	  AUI().use('aui-io-request', 'aui-autocomplete','liferay-portlet-url' ,'aui-base','aui-form-validator','autocomplete-list','autocomplete-filters','autocomplete-highlighters','node-event-simulate', function(A) {
    		  
    		  
    		  $('#interivew-request-modal').on('show.bs.modal', function(e) {
    			  $(".msg").html("");
                  //get data-id attribute of the clicked element
                  var studentId = $(e.relatedTarget).data('studentid');
                  //populate the textbox
                  $(e.currentTarget).find('#<portlet:namespace />studentId').val(studentId);
              });
    		  
    		  
    		  $('#delete-student-modal').on('show.bs.modal', function(e) {
                  //get data-id attribute of the clicked element
                  var studentId = $(e.relatedTarget).data('studentid');
                  //populate the textbox
                  $(e.currentTarget).find('#<portlet:namespace />deletestudentId').val(studentId);
              });
    		  
    		  A.one(".sent-interview-request").on('click', function(){
    				
    			  var studentId = A.one("#<portlet:namespace />studentId").get('value');
    				
    			  var resourceURL= Liferay.PortletURL.createResourceURL();
       			  resourceURL.setPortletId('com_medicus_student_portlet_portlet_StudentModulePortlet');
       			  resourceURL.setResourceId('/interview_request');
       			 
    				A.io.request(resourceURL.toString(),{
    					dataType: 'json',
    					method: 'GET',
    					data :{
    						'<portlet:namespace/>studentId' : studentId
    					},
    					on: {
    					success: function() {
    						var response=this.get('responseData');
    						//console.log('Response -> ' + response.status);
    						$(".msg").html("").removeClass("red").removeClass("green");
    						var status = response.status;
    						$(".msg").text(response.msg);
    						if(status==='err'){
    							$(".msg").addClass('red');
    						}else{
    							$(".msg").addClass('green');
    						}
    					}
    				  }
    				
    				});
    		  });
    		  
    	  });
      });
   })(jQuery);
</script>