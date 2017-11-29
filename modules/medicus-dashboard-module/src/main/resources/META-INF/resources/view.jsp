<%@ include file="/init.jsp"%>

<div class="page-title">
	<div class="title_left">
		<h2>Dashboard</h2>
	</div>
</div>
<div class="clearfix"></div>
<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_content">
				 <div class="col-md-6 col-sm-6 col-xs-12">
	                <div class="x_panel">
	                  <div class="x_title">
	                    <h3>Profession By Student Count </h3>
	                    <div class="clearfix"></div>
	                  </div>
	                  <div class="x_content">
                  		<canvas id="professionChart"></canvas>
                  	  </div>
                  	</div>
                  </div>

				<div class="col-md-6 col-sm-6 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h3>Gender By Student Count</h3>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<table class="" style="width: 100%">
								<tr>
									<td>
										<canvas id="genderChart"></canvas>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h3>Language By Student Count</h3>
							<div class="clearfix"></div>
						</div>
						<div class="x_content">
							<table class="" style="width: 100%">
								<tr>
									<td>
										<canvas id="languageChart"></canvas>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</div>

<script>
jQuery.noConflict();
(function($) {
    $(function() {
    		
    	  // Pie chart
		  if ($('#languageChart').length ){
			  
			  var ctx = document.getElementById("genderChart");
			  var countArray=[];
			  var labelArray=[];
			  <c:forEach items="${genderList}" var="genderEntity">
	            countArray.push('${genderEntity.count}');
	            labelArray.push('${genderEntity.fieldName}');
	          </c:forEach>
			  
			  var data = {
				datasets: [{
				  data: countArray,
				  backgroundColor: [
					"#455C73",
					"#9B59B6",
					"#BDC3C7",
					"#26B99A",
					"#3498DB"
				  ],
				  label: 'My dataset' // for legend
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
    	
		  if ($('#professionChart').length ){ 
			  
			  var ctx = document.getElementById("professionChart");
			  
			  var countArray=[];
			  var labelArray=[];
			  <c:forEach items="${professionList}" var="professionEntity">
	            countArray.push('${professionEntity.count}');
	            labelArray.push('${professionEntity.fieldName}');
	          </c:forEach>
			  
			  var mybarChart = new Chart(ctx, {
				type: 'bar',
				data: {
				  labels: labelArray,
				  datasets: [{
					label: 'Profession ',
					backgroundColor: "#26B99A",
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
		  
		  
           if ($('#languageChart').length ){ 
			  
			  var ctx = document.getElementById("languageChart");
			  
			  var countArray=[];
			  var labelArray=[];
			  <c:forEach items="${finalLangList}" var="langEntity">
	            countArray.push('${langEntity.count}');
	            labelArray.push('${langEntity.fieldName}');
	          </c:forEach>
			  
			  var mybarChart = new Chart(ctx, {
				type: 'bar',
				data: {
				  labels: labelArray,
				  datasets: [{
					label: 'Lanugage ',
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
		  	
    
    });
})(jQuery);
</script>