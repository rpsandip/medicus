<%@ include file="/init.jsp" %>
<portlet:resourceURL id="/getSchoolDetail" var="getSchoolDetailURL"></portlet:resourceURL>
<div class="page-title">
  <div class="title_left">
	<h2>Reports</h2>
  </div>
</div>
<div class="clearfix"></div>
<div class="row">
  <div class="col-md-12">
	<div class="x_panel">
	  <div class="x_content">
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
                  <div class="col-md-2 col-sm-2 col-xs-12 text-left">
                    <button type="button" class="btn btn-success export-report">Export</button>
                  </div>
                  <input type="hidden" id="userSchoolId" name="userSchoolId" value="${ userSchoolId}"/>
                  <input type="hidden" id="userCampusId" name="userCampusId" value="${userCampusId }"/>
         		</form>
             	<br>
		  </div>
		  <div class="col-md-12 col-sm-12 col-xs-12 text-center">
		  	<table id="students" class="table table-striped" cellspacing="0" width="100%">
            		<tbody></tbody>
            </table>
          </div>  	
		  <div class="clearfix"></div>
		</div>
	  </div>
	</div>
  </div>
</div>
<aui:script>

AUI().use('aui-io-request', 'aui-autocomplete','liferay-portlet-url' ,'aui-base','aui-form-validator','autocomplete-list','autocomplete-filters','autocomplete-highlighters','node-event-simulate', function(A) {
	var searchStudentURL = '${searchStudentURL}';
	var pagetIndex=0;
	
	function createResourceURL(resourceCommandName){

		 var resourceURL= Liferay.PortletURL.createResourceURL();
		 resourceURL.setPortletId('com_medicus_report_portlet_portlet_MedicusReportModulePortlet');
		 resourceURL.setResourceId(resourceCommandName);
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
			 console.log(langNodes[i].selected + " " + langNodes[i].text);
			 if(langNodes[i].selected){
			    	languages = languages + langNodes[i].text + ",";
			 }
		 }
		 
		languages = languages.substring(0,languages.lastIndexOf(",")); 
		resourceURL.setParameter("languages",languages); 
		
		return resourceURL.toString();
	}
	
	A.one(".search-student").on('click', function(){
		searchStudents();
	});
	
	A.one(".export-report").on('click', function(){
		exportStudents();
	});
	
	function searchStudents(){
		stuentsDataTables.ajax.url(createResourceURL('/search_studetns')).load();
	}
	
	function exportStudents(){
		window.location.href=createResourceURL('/export_students');
	}
	 
	 
	 var resourceURL= createResourceURL('/search_studetns');

	 var stuentsDataTables =  $('#students').DataTable({
		 "processing": true,
	     "serverSide": true,
	     "searching": false,
	     "pageLength": '${itemPerPage}',
	     "ajax": resourceURL.toString(),
		 "order": [],
		 "columns": [
		           		{ "data": "name", "name" : "name" , "title" : "Name"},
	                    { "data": "studentId", "name" : "studentId", "title" : "Student Id"  },
	                    { "data": "gender", "name" : "gender", "title" : "Gender"  },
	                    { "data": "zipcode", "name" : "zipcode", "title" : "Zipcode"  },
	                    { "data": "profession", "name" : "profession", "title" : "Profession"  },
	                    { "data": "language", "name" : "language", "title" : "Languages"  },
	                    { "data": "school", "name" : "school", "title" : "School"  },
	                    { "data": "campus", "name" : "campus", "title" : "Campus"  }
	                   
	                ]
	 });
	 
	 
	 
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
					
					searchStudents();
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
			searchStudents();
		}
   });
</aui:script>              