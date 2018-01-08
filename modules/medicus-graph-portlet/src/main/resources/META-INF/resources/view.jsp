<%@ include file="/init.jsp" %>

<div class="page-title">
  <div class="title_left">
	<h2>Graphs</h2>
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
		  		<div class="row">
		  		<div class="col-md-6 col-sm-6 col-xs-12" >
		  			<aui:select name="searchby"  label="Search By">
		  				<aui:option value="">Select Option</aui:option>
		  				<aui:option value="gender">Gender</aui:option>
		  				<aui:option value="primaryLanguage">Languages</aui:option>
		  				<aui:option value="zipcode">Zipcode</aui:option>
		  				<aui:option value="profession">Professions</aui:option>
		  			</aui:select>
		  		</div>
		  		<div class="col-md-6 col-sm-6 col-xs-12 gender-search">
		  			<aui:select name="gender" label="Gender">
		  				<aui:option value="Male">Male</aui:option>
		  				<aui:option value="Female">Female</aui:option>
		  				<aui:option value="LBGT">LBGT</aui:option>
		  			</aui:select>
		  		</div>
		  		<div class="col-md-6 col-sm-6 col-xs-12 languages-search">
		  			<aui:select name="languages" label="Languge">
  				        <aui:option value="English">English</aui:option>
						<aui:option value="French" >French</aui:option>
						<aui:option value="Spanish">Spanish</aui:option>
						<aui:option value="Chinese - Mandarin" >Chinese - Mandarin</aui:option>
						<aui:option value="Chinese -Cantonese">Chinese -Cantonese</aui:option>
						<aui:option value="Tagalog">Tagalog</aui:option>
						<aui:option value="Vietnamese">Vietnamese</aui:option>
						<aui:option value="Korean">Korean</aui:option>
						<aui:option value="German" >German</aui:option>
						<aui:option value="Arabic" >Arabic</aui:option>
						<aui:option value="Russian">Russian</aui:option>
						<aui:option value="Italian" >Italian</aui:option>
						<aui:option value="Portuguese" >Portuguese</aui:option>
						<aui:option value="Hindi" >Hindi</aui:option>
						<aui:option value="Polish" >Polish</aui:option>
						<aui:option value="Japanese" >Japanese</aui:option>
						<aui:option value="Urdu" >Urdu</aui:option>
						<aui:option value="Persian" >Persian</aui:option>
						<aui:option value="Gujarati">Gujarati</aui:option>
						<aui:option value="Greek">Greek</aui:option>
						<aui:option value="Bengali" >Bengali</aui:option>
						<aui:option value="Panjabi">Panjabi</aui:option>
						<aui:option value="Telugu">Telugu</aui:option>
						<aui:option value="Armenian" >Armenian</aui:option>
						<aui:option value="Hmong">Hmong</aui:option>
		  			</aui:select>
		  		</div>
		  		<div class="col-md-6 col-sm-6 col-xs-12 zip-search">
		  			<aui:input type="text" name="zipcode" label="Zipcode"/>
		  		</div>
		  		<div class="col-md-6 col-sm-6 col-xs-12 profession-search">
		  			<aui:select name="profession" label="Profession">
		  			<aui:option value="">Select Profession</aui:option>
	   	 			<aui:option value="Dental Assistant" >Dental Assistant</aui:option>
	   	 			<aui:option value="Medical Assistant">Medical Assistant</aui:option>
	   	 			<aui:option value="Medical Administrative Assistance" >Medical Administrative Assistance</aui:option>
	   	 			<aui:option value="Phlebotomy" selected='${studentBean.profession eq "Phlebotomy" ? true : false }'>Phlebotomy</aui:option>
	   	 			<aui:option value="Pharmacy Technician" >Pharmacy Technician</aui:option>
	   	 			<aui:option value="Patient Care Technician">Patient Care Technician</aui:option>
	   	 			<aui:option value="Veterinary Assistant">Veterinary Assistant</aui:option>
	   	 			<aui:option value="Sonography">Sonography</aui:option>
	   	 			</aui:select>
		  		</div>
		  		</div>
		  		<br/>
		  		<div class="row">
			  		<div class="col-md-6 col-sm-6 col-xs-12" >
			  			<aui:select name="groupBy"  label="Select X-axis">
			  				<aui:option value="gender">Gender</aui:option>
			  				<aui:option value="zipcode">Zipcode</aui:option>
			  				<aui:option value="profession">Professions</aui:option>
			  				<aui:option value="languages">Languages</aui:option>
			  			</aui:select>
			  		</div>
		  		</div>
		  		<div class="col-md-2 col-sm-2 col-xs-12 text-left">
                    <button type="button" class="btn btn-success search-student">Submit</button>
                </div>
                <div class="col-md-2 col-sm-2 col-xs-12 text-left">
           			<button type="button" class="btn btn-success export-report">Export</button>
    			 </div>
            </form>
          </div>
          <div >
          	<h3 class="graph-search-detail"></h3>
          </div>
          <div class="col-md-6 col-sm-6 col-xs-12">
					<div class="x_content">
						<table class="" style="width: 100%">
							<tr>
								<td class="graph-detail">
									<canvas id="student-graph"></canvas>
								</td>
							</tr>
						</table>
					</div>
			</div>
			<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="x_panel">
						<div class="x_content">
							<table class="" style="width: 100%">
								<tr>
									<td class="pi-chart-detail">
										<canvas id="stident-pi-chart"></canvas>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
          <div class="col-md-12 col-sm-12 col-xs-12 text-center">
		  	<table id="students" class="table table-striped" cellspacing="0" width="100%">
            		<tbody></tbody>
            </table>
          </div>  	
        </div>
      </div>
    </div>
  </div>
</div>
<script>
 var ss='';
</script>
<aui:script>

AUI().use('aui-io-request', 'aui-autocomplete','liferay-portlet-url' ,'aui-base','aui-form-validator','autocomplete-list','autocomplete-filters','autocomplete-highlighters','node-event-simulate', function(A) {
	
	A.one(".gender-search").hide();
	A.one(".languages-search").hide();
	A.one(".zip-search").hide();
	A.one(".profession-search").hide();
	  
    var searchbySelect = A.one("#<portlet:namespace />searchby");
    var stuentsDataTables;
	
    searchbySelect.on('change', function(e) {
		var searchBy= this.get('value');
		console.log("searchBy->" + searchBy);
		
		if(searchBy=="gender"){
			A.one(".gender-search").show();
			A.one(".languages-search").hide();
			A.one(".zip-search").hide();
			A.one(".profession-search").hide();
		}
		
		if(searchBy=="primaryLanguage"){
			A.one(".languages-search").show();
			A.one(".gender-search").hide();
			A.one(".zip-search").hide();
			A.one(".profession-search").hide();
			
		}
		
		if(searchBy=="zipcode"){
			A.one(".zip-search").show();
			A.one(".gender-search").hide();
			A.one(".languages-search").hide();
			A.one(".profession-search").hide();
		}
		if(searchBy=="profession"){
			A.one(".profession-search").show();
			A.one(".gender-search").hide();
			A.one(".languages-search").hide();
			A.one(".zip-search").hide();
		}
		
		if(searchBy==""){
			A.one(".profession-search").hide();
			A.one(".gender-search").hide();
			A.one(".languages-search").hide();
			A.one(".zip-search").hide();
		}
	});
    
    A.one(".search-student").on('click', function(){
		searchStudents();
	});
    
    function createGraphResourceURL(){

		 var resourceURL= Liferay.PortletURL.createResourceURL();
		 resourceURL.setPortletId('com_medicus_graph_portlet_portlet_MedicusGraphPortlet');
		 resourceURL.setResourceId('/get_graph_detail');
		 
		 var searchbySelect = A.one("#<portlet:namespace />searchby");
		 var searchByColumnName = searchbySelect.get('value');
		 var searchByColumnValue = '';
		 var groupByColumnName = A.one("#<portlet:namespace />groupBy").get('value');
		 
		 A.one(".graph-search-detail").html('');
		 var search_info='This graph shows students who ';
		 
		 if(searchByColumnName=="gender"){
			 searchByColumnValue = A.one("#<portlet:namespace/>gender").get('value');
			 search_info += "has Gender as " + A.one("#<portlet:namespace/>gender").get('value');
		 }
		 if(searchByColumnName=="primaryLanguage"){
			 searchByColumnValue = A.one("#<portlet:namespace/>languages").get('value');
			 search_info += "speaks Language as " + A.one("#<portlet:namespace/>languages").get('value');
		 }
		 if(searchByColumnName=="zipcode"){
			 searchByColumnValue = A.one("#<portlet:namespace/>zipcode").get('value');
			 search_info += "has Zipcode as " + A.one("#<portlet:namespace/>zipcode").get('value');
		 }
		 if(searchByColumnName=="profession"){
			 searchByColumnValue = A.one("#<portlet:namespace/>profession").get('value');
			 search_info += "has Profession as " + A.one("#<portlet:namespace/>profession").get('value');
		 }
		
		resourceURL.setParameter("searchByColumnName",searchByColumnName); 
		resourceURL.setParameter("searchByColumnValue",searchByColumnValue); 
		resourceURL.setParameter("groupByColumnName",groupByColumnName); 
		resourceURL.setParameter('userSchoolId','${userSchoolId}');
		resourceURL.setParameter('userCampusId','${userCampusId}');
		
		search_info += " and group by "+ uppercaseFirstLetter(groupByColumnName);
		
		A.one(".graph-search-detail").html(search_info);
		
		return resourceURL.toString();
	}
    
    
    function createSearchStudentResourceURL(resourceName){
    	
    	var resourceURL= Liferay.PortletURL.createResourceURL();
		 resourceURL.setPortletId('com_medicus_report_portlet_portlet_MedicusReportModulePortlet');
		 resourceURL.setResourceId(resourceName);
	     var plid = '${report_page_plid}';
	     resourceURL.setPlid(plid);
	     
	     var searchbySelect = A.one("#<portlet:namespace />searchby");
		 var searchByColumnName = searchbySelect.get('value');
		 
	     if(searchByColumnName=="gender"){
			 resourceURL.setParameter("gender", A.one("#<portlet:namespace/>gender").get('value'));
		 }
		 if(searchByColumnName=="primaryLanguage"){
			 resourceURL.setParameter("languages", A.one("#<portlet:namespace/>languages").get('value'));
		 }
		 if(searchByColumnName=="zipcode"){
			 resourceURL.setParameter("zipcode", A.one("#<portlet:namespace/>zipcode").get('value'));
		 }
		 if(searchByColumnName=="profession"){
			 resourceURL.setParameter("profession", A.one("#<portlet:namespace/>profession").get('value'));
		 }
		 
		 resourceURL.setParameter('userSchoolId','${userSchoolId}');
		 resourceURL.setParameter('userCampusId','${userCampusId}');
	     
		 return resourceURL.toString();
    }
    
    function searchStudents(){
    	
    	var searchStudentResourceURL= createSearchStudentResourceURL('/search_studetns');

    	console.log("searchStudentResourceURL->" + searchStudentResourceURL);
    	
    	if(typeof stuentsDataTables == 'undefined'){
	    	// List Students
	    	stuentsDataTables =  $('#students').DataTable({
	    		 "processing": true,
	    	     "serverSide": true,
	    	     "searching": false,
	    	     "pageLength": '50',
	    	     "ajax": searchStudentResourceURL.toString(),
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
    	}else{
    		stuentsDataTables.ajax.url(createSearchStudentResourceURL('/search_studetns')).load();
    	}
    	
    	
    	// Generate Graph
    	var graphResourceURL= createGraphResourceURL();
    	
    	console.log("graphResourceURL->" + graphResourceURL);
    	
    	A.io.request(graphResourceURL.toString(),{
			dataType: 'json',
			method: 'GET',
			on: {
			success: function() {
				var graphResponse=this.get('responseData');
				ss = graphResponse;
				prepareBarChart(graphResponse,A.one("#<portlet:namespace />groupBy").get('value'));
				preparePieChart(graphResponse,A.one("#<portlet:namespace />groupBy").get('value'));
			}
		  }
		});  
    	  
    	
	}
    
    function prepareBarChart(graphResponse, groupByColumnName){
    	
    	if(A.one(".graph-detail iframe")){
    		A.one(".graph-detail iframe").remove();
    		A.one(".graph-detail canvas").remove();
    		A.one(".graph-detail").append('<canvas id="student-graph"></canvas>');
    	}
    	
    	var ctx = document.getElementById("student-graph");
		  
    	
		  var countArray=[];
		  var labelArray=[];
		  
		  countArray = graphResponse.countList;
		  labelArray = graphResponse.labelList;
			  
		  var mybarChart = new Chart(ctx, {
			type: 'bar',
			data: {
			  labels: labelArray,
			  datasets: [{
				label: groupByColumnName,
				backgroundColor: "#03586A",
				data: countArray
			  }]
			},

			options: {
			  scales: {
				yAxes: [{
				  ticks: {
					beginAtZero: true
				  }
				}]
			  }
			}
		  });
    }
    
    function preparePieChart(graphResponse, groupByColumnName){
    	
    	if(A.one(".pi-chart-detail iframe")){
    		A.one(".pi-chart-detail iframe").remove();
    		A.one(".pi-chart-detail canvas").remove();
    		A.one(".pi-chart-detail").append('<canvas id="stident-pi-chart"></canvas>');
    	}
    	
    	var ctx = document.getElementById("stident-pi-chart");
		  var countArray=[];
		  var labelArray=[];
		  
		  countArray = graphResponse.countList;
		  labelArray = graphResponse.labelList;
		  
		  var data = {
			datasets: [{
			  data: countArray,
			  backgroundColor: [
				"#455C73",
				"#9B59B6",
				"#BDC3C7",
				"#26B99A",
				"#3498DB",
				"#55c3a0",
				"#c38d55",
				"#5c55c3",
				"#ad55c3",
				"#c35597c4",
				"#8f55c3",
				"#5568c3",
				"#55c3b4",
				"#adc355",
				"#c35555",
				"#455C73",
				"#9B59B6",
				"#BDC3C7"
			  ],
			  label: '' // for legend
			}],
			labels: labelArray
		  };

		  var pieChart = new Chart(ctx, {
			data: data,
			type: 'pie',
			otpions: {
			  legend: false
			}
		  });
    	
    }
    
    function uppercaseFirstLetter(string) 
    {
    	if(string.length>0){
        	return string.charAt(0).toUpperCase() + string.slice(1);
    	}else{
    		return '';
    	}
    }
    
    A.one(".export-report").on('click', function(){
		exportStudents();
	});
    
    function exportStudents(){
		window.location.href=createSearchStudentResourceURL('/export_students');
	}
    
});
</aui:script> 
                 