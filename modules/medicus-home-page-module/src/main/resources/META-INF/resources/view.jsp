<%@ include file="/init.jsp" %>
<%
	String imagePath = request.getContextPath()+"/images";
%>
<portlet:resourceURL id="/contact-us" var="contactUSReqeustURL"></portlet:resourceURL>
<!--/banner-section-->
	<div d="demo-1" data-zs-src='["<%=imagePath %>/b1.jpg","<%=imagePath %>/6.jpg","<%=imagePath %>/b2.jpg","<%=imagePath %>/b3.jpg","<%=imagePath %>/b4.jpg"]'  style="min-height: 570px;">
		<div class="demo-inner-content">
		<!--/header-w3l-->
			   <div class="header-w3-agileits" id="home">
			     <div class="inner-header-agile">	
				<nav class="navbar navbar-default">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<h1><a  onclick="window.location.reload(true);" href="#">
						<span class="letter">M</span>edicus <span>G</span>roup</a></h1>
					</div>
					<!-- navbar-header -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li class="active"><a href="/">Home</a></li>
								<li><a href="#about" class="scroll">About</a></li>
								<li><a href="#agileits-services" class="scroll">Services</a></li>
								<li><a href="#blog" class="scroll">Professions</a></li>
								<li><a href="#faqs" class="scroll">Faqs</a></li>
								<li><a href="#testimonials" class="scroll" >Testimonials</a></li>
								<li><a href="#contact" class="scroll">contact</a></li>
							</ul>
						</div>
					<div class="clearfix"> </div>	
				</nav>
			</div> 

			   </div>
		<!--//header-w3l-->
			<!--/banner-info-->
			   <div class="baner-info">
			       <h4>The best learning institution</h4>
				   <h3><span>W</span>elcome <span>T</span>o <span>Y</span>our <span>P</span>remier <span>H</span>ealth <span>I</span>nternship <span>P</span>ortal</h3><br>
			   </div>
			<!--/banner-ingo-->		
		</div> 
    </div>
  <!--/banner-section-->
  <!--about -->
	<div id="about" class="wthree-about w3ls-section">
		<div class="container">
			<h2 class="w3ls-title">about us</h2>
			<div class="col-md-7  w3ls-about-left">
				<p>At Medicus Group LLC, our mission is to match non-paid healthcare interns with local healthcare partners. Our portal streamlines the intern process selection by consolidating multiple schools to upload 100s of qualify non-paid interns in one portal. This one-stop-selection portal eliminates the burdening process of contacting various schools, completing mountains of paperwork, and experiencing frustration of receiving non-qualify interns.</p><br>
				<p>By using our proprietary analytics, you can personalize and request your perfect intern. You have the options to filter by gender, zip code, profession, school, preferred language, and campus. You can also view resumes before requesting the candidate for an interview. There is no obligation to hire, there is no limit to your request, and best of all the school carries the student's liability insurance. </p><br/>
				<p>Take action now, start reducing your payroll expenses today to increase your bottom line. We guarantee that your Return On Investment with us will be at least 300%. </p><br/>
				<p>Click on Partner Registration and subscribe to Medicus Group LLC to find your next non-paid intern.</p>
			</div>
			<div class="col-md-5 w3ls-row">
				<div class="col-md-6 col-sm-6 wthree-about-left">
					<img src="<%=imagePath %>/about2.jpeg" class="img-responsive" alt=""/>
				</div>
				<div class="col-md-6 col-sm-6 w3ls-row alert wthree-about-right">
					<img src="<%=imagePath %>/about3.jpeg" class="img-responsive" alt=""/>
				</div>
				<div class="col-md-12 home-yt-vid" >
					<iframe width="460" height="230" src="https://www.youtube.com/embed/hieXFos3zyM?rel=0" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
				</div>
				<div class="clearfix"> </div>
			</div>	
			<div class="clearfix"> </div>
				 <br>
			</div>
	</div>	
	
	<!--services-->
  <div class="agileits-services w3ls-section" id="agileits-services" >
		<div class="container">
			<h3 class="w3ls-title">services </h3>
			<div class="agileits-services-row">
				<div class="col-md-6 col-sm-6 agileits-services-grids">
					<a class="scroll" href="#analytics">
					<span class="glyphicon glyphicon-stats effect-1" aria-hidden="true"></span>
					<h4>Analytics</h4>
					<p>See sample reports and search functions to customize your internship selection and search.</p>
					</a>
				</div>
				<div class="col-md-6 col-sm-6 agileits-services-grids">
					<span class="glyphicon glyphicon-user effect-1" aria-hidden="true"></span>
					<h4>Custom Plan</h4>
					<p>We have one flexible plan to meet your every internship need.</p>
					<p>Our plan includes the following advantages:</p><p class="text-left">
						<ul class="text-left " style="color: #fff;">
							<li>Real time access to students available to intern</li>
							<li>Unlimited searches</li>
							<li>Customization of your search by Zip code, Gender, Language, Profession, just to name a few criteria</li>
							<li>Selection of Schools and campus nearest to you</li>
							<li>Ability to work with the school to interview students before acceptance</li>
							<li>Liability insurance of the student</li>
							<li>treamline process to select and obtain interns</li>
							<li>Your return on investment (ROI) is more than 300% in financial and social impact</li>
						</ul>
					</p>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--//agileits-services-->
	<div id="analytics" class="w3ls-section">
		
		<div class="container">
			<div>
				<h3 class="w3ls-title">Analytics</h3>
			</div>
			<div class="stats-info agileits-w3layouts">
				<div class="col-sm-3 col-xs-3 stats-grid">
					<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='45' data-delay='.5' data-increment="1">15 </div>
					<div class="stats-img stat2">
							<p>Schools</p>
					</div>
				</div>
				<div class="col-sm-3 col-xs-3 stats-grid">
					<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='75' data-delay='.5' data-increment="1">45</div>
					<div class="stats-img stat2">
						<p>Campuses</p>
					</div>
				</div>
				<div class="col-sm-3 col-xs-3 stats-grid stat1">
					<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='745' data-delay='.5' data-increment="1">1745</div>
					<div class="stats-img stat2">
						<p>Students</p>
					</div>
				</div>
				<div class="col-sm-3 col-xs-3 stats-grid stat1">
					<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='745' data-delay='.5' data-increment="1">750</div>
					<div class="stats-img stat2">
						<p>Partners</p>
					</div>
				</div>
				<div class="clearfix"></div>
		 </div><br>
			 <form id="add-new-school-form" data-parsley-validate="" class="form-horizontal form-label-left" style="text-align:center">
               <div class="form-group" style="margin:0">
                 <div class="col-md-2 col-sm-6 col-xs-12">
                   <select id="school" class="form-control">
                      <option value="">Select School</option>
                      <option>School 1</option>
                      <option>School 2</option>
                      <option>School 3</option>
                      <option>School 4</option>
                    </select>
                 </div>
                 <div class="col-md-2 col-sm-6 col-xs-12">
                   <select id="campus" class="form-control">
                      <option value="">Select Campus</option>
                      <option>Main Campus 1</option>
                      <option>Main Campus 2</option>
                      <option>Main Campus 3</option>
                      <option>Main Campus 4</option>
                    </select>
                 </div>
                 <div class="col-md-2 col-sm-6 col-xs-12">
                   <select id="profession" class="form-control">
                      <option value="">Select Profession</option>
                      <option>Dental Assistance</option>
                      <option>Medical Assistance</option>
                      <option>Medical Administrative Assistance</option>
                      <option>Phlebotomy</option>
                      <option>Pharmacy Technician </option>
                      <option>Patient Care Technician </option>
                      <option>Veterinary Assistant</option>
                      <option>Sonography</option>
                    </select>
                 </div>
                 <div class="col-md-2 col-sm-6 col-xs-12">
                   <select id="gender" class="form-control">
                      <option value="">Select Gender</option>
                      <option value=" Male">Male</option>
                      <option>LGBT</option>
                      <option>Female</option>
                    </select>
                 </div>
                 <div class="col-md-2 col-sm-6 col-xs-12">
                   <select id="language" class="form-control">
                      <option value="">Select Language</option>
                      <option>English</option>
                      <option>German</option>
                      <option>Japanese</option>
                      <option>French</option>
                    </select>
                 </div>
                 <div class="col-md-1 col-sm-6 col-xs-12">
                   <input type="text" class="form-control" placeholder="Zipcode" id="zipcode" style="min-width: 75px;">
                 </div>
                 <div class="col-md-1 col-sm-6 col-xs-12">
                   <button type="button" class="btn btn-primary search-student">Submit</button>
                 </div>
               </div>
             </form>
             
             
             <br>
             
             <div class="row search-data">
	              <div class="col-md-12 col-sm-12 col-xs-12">
	                <div class="x_panel">
	                  <div class="x_content">
	                    <table id="datatable" class="table table-striped ">
	                      <thead>
	                        <tr>
	                          <th>St. No.</th>
	                          <th>Name</th>
	                          <th>Profession</th>
	                          <th>Gender</th>
	                          <th>School</th>
	                          <th>Campus</th>
	                          <th>Language</th>
	                          <th>Zipcode</th>
	                        </tr>
	                      </thead>
	                      <tbody>
	                        <tr>
	                          <td>11111</td>
	                          <td>Student 1</td>
	                          <td>Dental Assistance</td>
	                          <td> Female</td>
	                          <td>School 1</td>
	                          <td>Main Campus 1</td>
	                          <td>English</td>
	                          <td>77001</td>
	                        </tr>
	                        <tr>
	                          <td>11112</td>
	                          <td>Student 2</td>
	                          <td> Medical Assistance </td>
	                          <td> Female</td>
	                          <td>School 1</td>
	                          <td>Main Campus 2</td>
	                          <td>English</td>
	                          <td>77002</td>
	                        </tr>
	                        <tr>
	                          <td>11113</td>
	                          <td>Student 3</td>
	                          <td> Medical Administrative Assistance </td>
	                          <td> LGBT</td>
	                          <td>School 1</td>
	                          <td>Main Campus 3</td>
	                          <td>English</td>
	                          <td>77003</td>
	                        </tr>
	                        <tr>
	                          <td>11114</td>
	                          <td>Student 4</td>
	                          <td> Phlebotomy </td>
	                          <td> Female</td>
	                          <td>School 1</td>
	                          <td>Main Campus 4</td>
	                          <td>German</td>
	                          <td>77004</td>
	                        </tr>
	                        <tr>
	                          <td>11115</td>
	                          <td>Student 5</td>
	                          <td> Pharmacy Technician </td>
	                          <td> Male</td>
	                          <td>School 2</td>
	                          <td>Main Campus 1</td>
	                          <td>German</td>
	                          <td>77005</td>
	                        </tr>
	                        <tr>
	                          <td>11116</td>
	                          <td>Student 6</td>
	                          <td> Patient Care Technician </td>
	                          <td> Male</td>
	                          <td>School 2</td>
	                          <td>Main Campus 2</td>
	                          <td>German</td>
	                          <td>77006</td>
	                        </tr>
	                        <tr>
	                          <td>11117</td>
	                          <td>Student 7</td>
	                          <td> Veterinary Assistant </td>
	                          <td> Male</td>
	                          <td>School 2</td>
	                          <td>Main Campus 3</td>
	                          <td>English</td>
	                          <td>77007</td>
	                        </tr>
	                        <tr>
	                          <td>11118</td>
	                          <td>Student 8</td>
	                          <td> Sonography </td>
	                          <td> Female</td>
	                          <td>School 2</td>
	                          <td>Main Campus 4</td>
	                          <td>English</td>
	                          <td>77008</td>
	                        </tr>
	                      
	                      
	                      <tr>
	                          <td>11119</td>
	                          <td>Student 9</td>
	                          <td>Dental Assistance</td>
	                          <td> Female</td>
	                          <td>School 3</td>
	                          <td>Main Campus 1</td>
	                          <td>French</td>
	                          <td>77009</td>
	                        </tr>
	                        <tr>
	                          <td>11120</td>
	                          <td>Student 10</td>
	                          <td> Medical Assistance </td>
	                          <td> LGBT</td>
	                          <td>School 3</td>
	                          <td>Main Campus 2</td>
	                          <td>French</td>
	                          <td>77010</td>
	                        </tr>
	                        <tr>
	                          <td>11121</td>
	                          <td>Student 11</td>
	                          <td> Medical Administrative Assistance </td>
	                          <td> Female</td>
	                          <td>School 3</td>
	                          <td>Main Campus 3</td>
	                          <td>French</td>
	                          <td>77011</td>
	                        </tr>
	                        <tr>
	                          <td>11122</td>
	                          <td>Student 12</td>
	                          <td> Phlebotomy </td>
	                          <td> Female</td>
	                          <td>School 3</td>
	                          <td>Main Campus 4</td>
	                          <td>French</td>
	                          <td>77012</td>
	                        </tr>
	                        <tr>
	                          <td>11123</td>
	                          <td>Student 13</td>
	                          <td> Pharmacy Technician </td>
	                          <td> Male</td>
	                          <td>School 4</td>
	                          <td>Main Campus 1</td>
	                          <td>Japanese</td>
	                          <td>77013</td>
	                        </tr>
	                        <tr>
	                          <td>11124</td>
	                          <td>Student 14</td>
	                          <td> Patient Care Technician </td>
	                          <td> Male</td>
	                          <td>School 4</td>
	                          <td>Main Campus 2</td>
	                          <td>Japanese</td>
	                          <td>77014</td>
	                        </tr>
	                        <tr>
	                          <td>11125</td>
	                          <td>Student 15</td>
	                          <td> Veterinary Assistant </td>
	                          <td> LGBT</td>
	                          <td>School 4</td>
	                          <td>Main Campus 3</td>
	                          <td>Japanese</td>
	                          <td>77015</td>
	                        </tr>
	                        <tr>
	                          <td>11126</td>
	                          <td>Student 16</td>
	                          <td> Sonography </td>
	                          <td> Female</td>
	                          <td>School 4</td>
	                          <td>Main Campus 4</td>
	                          <td>Japanese</td>
	                          <td>77016</td>
	                        </tr>
	                      
	                      </tbody>
	                    </table>
	                  </div>
	                </div>
	              </div>
	           	</div>
		</div>
	</div>
  
<!--blog-->
	<div id="blog" class="portfolio w3ls-section">
		<div class="container">
			<h3 class="w3ls-title">Professions</h3>
		<div class="sap_tabs">			
			<div id="horizontalTab">
				<ul class="resp-tabs-list">
     <li class="resp-tab-item"><span>All</span></li>
    </ul>
				<div class="clearfix"> </div>	
				<div class="resp-tabs-container">
					<div class="tab-1 resp-tab-content">
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g1.jpg" data-lightbox="example-set" data-title="<h3>Dental Assistant</h3>Our colleges teach a wide span of job skills that ensure success in our students career as a dental assistant.  Our colleges' accredited training program offers courses that teach chair-side assisting and help students gain hands on experience.
							<ul><li>Prepare patients for examination and treatment</li><li>Take x-ry examinations (Radiography)</li><li>Sterilize and disinfect instruments and equipment</li><li>Prepare tray setups for dental procedures</li><li>Prepare materials for making impressions and restoration</li></ul>
							">
								<img src="<%=imagePath %>/g1.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Dental Assistant</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g2.jpg" data-lightbox="example-set" 
							data-title="<h3>Medical Assistant</h3>Our colleges' Medical Assistant program teaches our students to assist physicians in the examination and treatment of patients, as well as perform routine office tasks.
							<ul><li>Perform all aspect of front office</li>
							<li>Take Medical Histories and record Vital Signs</li>
							<li>Explain Treatment Procedures to Patients</li>
							<li>Prepare Patients for Examination</li>
							</ul>
							">
								<img src="<%=imagePath %>/g2.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Medical Assistant</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g3.jpg" data-lightbox="example-set" data-title="<h3>Phlebotomy</h3>Our colleges' program provides training in obtaining blood specimens by venipuncture and micro-collection techniques.  Phlebotomy technician classes also teach students to collect and process other clinical specimens, along with Point of Care procedures.
							">
								<img src="<%=imagePath %>/g3.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Phlebotomy</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g8.jpg" data-lightbox="example-set" data-title="<h3>Patient Care Technician</h3>As Patient Care Technicians, our students learn how to handle daily hands-on experiences with patients by helping them with procedures such as taking vital signs, performing electrocardiography (ECG), blood draws, hemodialysis and other needs.
							<ul><li>Performing catheterizations</li><li>Removing sutures and staples</li>
								<li>Managing wound care</li><li>Administering ECGs</li><li>Inserting intravenous saline locks</li></ul>
								">
								<img src="<%=imagePath %>/g8.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Patient Care Technician</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g5.jpg" data-lightbox="example-set" data-title="<h3>Medical Administrative Assistant</h3>Our Medical Administrative Assistant provides a strong background in office skills as well as business communication and customer service.  This combination of and hard skills prepares our students for a career in office administration, both in the health care field and in other industries as well.
							<ul><li>Electronic health records</li><li>Verifying medical insurance</li>
<li>Performing medical billing and coding tasks</li><li>Assisting physicians with reports an articles</li><li>Bookkeeping and banking procedures</li></ul>
							">
								<img src="<%=imagePath %>/g5.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Medical Administrative Assistant</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g6.jpg" data-lightbox="example-set" data-title="<h3>Veterinary Assistant</h3>Our Veterinary Assistant students obtain the necessary skills to work in a variety of practices from animal emergency medicine and lab  procedures to nursing skills and more, with a special emphasis on small animal techniques.
							<ul><li>Sterilize lab and surgical equipment</li>
							<li>Assist in surgeries</li>
							<li>Provide routine post-operative care</li>
							<li>Draw blood and collect other lab specimens</li>
							<li>Prepare samples for lab examination under supervision</li>
							</ul>
							">
								<img src="<%=imagePath %>/g6.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Veterinary Assistant</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g4.jpg" data-lightbox="example-set" data-title="<h3>Sonography</h3>Our Sonographer, student perform and interpret ultrasound scans to help physicians diagnose a range of diseases, assist surgeons with biopsies, and track the health and growth of developing fetuses.  Our program teaches students sophisticated sonographic procedures and technology, as well as the interpersonal skills necessary to work directly with patients in a range of settings, from physician’s offices and OB/GYN clinics, to hospitals and diagnostic laboratories.
							">
								<img src="<%=imagePath %>/g4.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Sonography</h5>
								</div>
							</a>
						</div>
					
						<div class="clearfix"> </div>
					</div>		
				</div>						
			</div>
		</div>
		</div>	
	</div>
	<!--//portfolio-->
	
	<!-- Articles -->
	<div id="articles" class="portfolio w3ls-section">
		<div class="container">
			<h3 class="w3ls-title">Articles</h3>
			<ul class="list-group"style="padding-left:20px">
			<li><a  target="_blank" href="http://slicecommunications.com/roi-of-an-unpaid-internship/">ROI OF AN UNPAID INTERNSHIP</a></li>
			<li><a  target="_blank" href="https://www.ellevatenetwork.com/articles/6617-invest-in-the-unpaid-intern-and-everyone-gets-a-roi">Invest In The Unpaid Intern And Everyone Gets A ROI</a></li>
			<li><a  target="_blank" href="https://www.linkedin.com/pulse/real-roi-internships-daniel-wright/">The Real ROI of Internships</a></li>
			<li><a  target="_blank" href="https://pubsonline.informs.org/doi/abs/10.1287/isre.1110.0382">Editorial Overview—The Role of Information Systems in Healthcare: Current Research and Future Trends</a></li>
			<li><a  target="_blank" href="http://www.sciencedirect.com/science/article/pii/S0148296311000555">Innovation in healthcare: Issues and future trends</a></li>
			<li><a  target="_blank" href="https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3116776/">Ten 10-Year Trends for the Future of Healthcare: Implications for Academic Health Centers</a></li>
			<li><a  target="_blank" href="https://www.healthcatalyst.com/top-healthcare-trends-challenges">Top 7 Healthcare Trends and Challenges from Our Financial Expert</a></li>
			<li><a  target="_blank" href="http://managedhealthcareexecutive.modernmedicine.com/managed-healthcare-executive/news/four-tech-trends-healthcare-2017">Four tech trends in healthcare in 2017</a></li>
			<li><a  target="_blank" href="https://money.usnews.com/money/blogs/outside-voices-careers/2011/04/29/why-you-should-get-a-summer-internship">Why You Should Get a Summer Internship</a></li>
			<li><a  target="_blank" href="https://theundercoverrecruiter.com/7-reasons-take-internship/">7 Reasons You Should Take an Internship</a></li>
			<li><a  target="_blank" href="https://www.collegemagazine.com/why-get-internship/">Why Get An Internship?</a></li>
			<li><a  target="_blank" href="http://hitconsultant.net/2017/12/18/defining-healthcare-trends-to-watch-2018/">12 Defining Healthcare Trends to Watch in 2018</a></li>
			<li><a  target="_blank" href="https://www.pwc.com/us/en/health-industries/health-research-institute/behind-the-numbers.html">Medical cost trend - Behind the numbers 2018</a></li>
			</ul>
			
		</div>
	</div>
	<!--  //Articles -->
	
	
  <!--//main-header-->
	<!-- testimonial -->
	<div class="wthree-testi w3ls-section" id="testimonials">
		<!-- container -->
		<div class="container">
			<h3 class="w3ls-title">Testimonials</h3> 
			<div class="w3_wthree-testi_grids text-center">
				<section class="slider">
					<div class="flexslider">
						<ul class="slides">
							<li>	
								<div class="wthree-testi_grid">
									<div class="testimonial-left">
										<img src="<%=imagePath %>/t1.jpg" />
									</div>
									<p>After obtaining the patient care experience I needed, I was accepted into a Physician Assistance program. I have recently graduated and have secured my first job as a PA in an Emergency Department, where I not only use my skills as a Physician Assistant, but also as a Phlebotomist. Thank you PMI!</p>
									<h5>Christopher Sessions - East Valley Campus Phlebotomy Program</h5>
								</div>
							</li>
							<li>	
								<div class="wthree-testi_grid">
									<div class="testimonial-left">
										<img src="<%=imagePath %>/t2.jpg" /> 
									</div>
									<p>I am so appreciative of my PMI education. It has make a true difference in my life, and I will be forever grateful.</p>
									<h5>Anotella Tartufol - Aurora Campus Dental Assistant Program</h5>
								</div>
							</li>
							<li>	
								<div class="wthree-testi_grid">
									<div class="testimonial-left">
										<img src="<%=imagePath %>/t3.jpg" /> 
									</div>
									<p>PIMA Medical Institute has become a family affair for me and my sisters. It all started when my sister, Miranda, began researching colleges. She was felling discouraged on her visits to some of the larger institutions. But walking into PMI felt like just the right atmosphere. They made her feel like she was important and she signed up for the Medical Assistant program. Upon graduation, she was offered a position working for an ENT specialist.</p>
									<h5>Claudia Silguero Garza - Houston Campus Medical Administrative Program</h5>
								</div>
							</li>
						</ul>
					</div>
				</section>
				
			</div>
		</div>
	</div>
<!-- //testimonial --> 

<!-- Faqs -->

<div class="faqs-section w3ls-section" id="faqs">
		<div class="container">
		<h3 class="w3ls-title">Frequently Asked Questions</h3>
			<div class="col-md-7" style="padding: 0;">
			<div class="panel-group" id="accordion">
			    <div class="panel panel-default">
			      <div class="panel-heading">
			        <h4 class="panel-title">
			          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">What is an internship program?</a>
			        </h4>
			      </div>
			      <div id="collapse1" class="panel-collapse collapse in">
			        <div class="panel-body">An internship is an opportunity offered by an employer to potential employees, called interns, to work at a firm for a fixed, limited period of time. Interns are usually undergraduates or students, and most internships last for any length of time between one week and 12 months.</div>
			      </div>
			    </div>
			    <div class="panel panel-default">
			      <div class="panel-heading">
			        <h4 class="panel-title">
			          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">What is the purpose of doing an internship?</a>
			        </h4>
			      </div>
			      <div id="collapse2" class="panel-collapse collapse">
			        <div class="panel-body">Internships are formal programs within organizations whose primary purpose is to offer practical work experience in a particular occupation to people who are new to that field.</div>
			      </div>
			    </div>
			    <div class="panel panel-default">
			      <div class="panel-heading">
			        <h4 class="panel-title">
			          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Paid and Unpaid interns.</a>
			        </h4>
			      </div>
			      <div id="collapse3" class="panel-collapse collapse">
			        <div class="panel-body">Paid interns are company employees, even if they're trainees. As employees, they're entitled to at least a minimum wage and to overtime pay if they work more than 40 hours a week. Unpaid interns aren't employees. They aren't paid and there are no hour requirements.</div>
			      </div>
			    </div>
			    <div class="panel panel-default">
			      <div class="panel-heading">
			        <h4 class="panel-title">
			          <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">How Many Hours Are Interns Supposed to Work?</a>
			        </h4>
			      </div>
			      <div id="collapse4" class="panel-collapse collapse">
			        <div class="panel-body">The federal government sets rules for interns, but they don't include minimum or maximum hours. If the internship is for college credit, the college may lay down some rules. At California University of Pennsylvania, for example, an internship equal to one course credit should represent 40 hours of work, at about 10 to 12 hours a week. If interns are paid or should be paid, they're protected by the same wage and hour laws as other employees</div>
			      </div>
			    </div>
			  </div> 
			  </div>
			  <div class="col-md-5">
			  	<iframe width="100%" height="280" src="https://www.youtube.com/embed/sz1ndY545ko?rel=0" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen=""></iframe>
			  </div>
		</div>
</div>

<div id="sponsors" class="sponsors w3ls-section">
		<div class="container">
			<h3 class="w3ls-title">Sponsors, Partners, and Schools</h3>
			<div class="col-md-12 first-row">
				<div class="col-md-3">
					<img src="<%=imagePath %>/concentra.png"/>
				</div>
				<div class="col-md-3">
					<img src="<%=imagePath %>/anylabtest.png"/>
				</div>
				<div class="col-md-3">
					<img src="<%=imagePath %>/ushealth.png"/>
				</div>
				<div class="col-md-3">
					<img src="<%=imagePath %>/breeze.png"/>
				</div>
			</div>
			<div class="col-md-12 second-row">
				<div class="col-md-4">
					<img src="<%=imagePath %>/pima.png"/>
				</div>
				<div class="col-md-4">
					<img src="<%=imagePath %>/chiropractic.png"/>
				</div>
				<div class="col-md-4">
					<img src="<%=imagePath %>/memorial.png"/>
				</div>
			</div>
			
		</div>
	</div>

<!--  //faqs -->

	<!-- contact -->
	<div class="contact-bottom w3ls-section" id="contact">
		<div class="container">
			<h3 class="w3ls-title">contact</h3>
			<div class="w3layouts-list">
					<div class="col-md-4 li"><span class="fa fa-map-marker" aria-hidden="true"></span><h6>Houston, TX USA</h6></div>
					<div class="col-md-4 li"><span class="fa fa-phone" aria-hidden="true"></span><h6>(+1) 281 866 1505</h6></div>
					<div class="col-md-4 li"><span class="fa fa-location-arrow" aria-hidden="true"></span><a href="mailto:techsupport@medicusgroupLLC.com">TechSupport@MedicusGroupLLC.com</a></div>
					<div class="clearfix"></div>
			</div>
			<!-- <div class="col-md-6 col-sm-6  col-xs-6 agileits_w3layouts-map">
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d387193.3059353029!2d-74.25986548248684!3d40.697149419326095!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c24fa5d33f083b%3A0xc80b8f06e177fe62!2sNew+York%2C+NY%2C+USA!5e0!3m2!1sen!2sin!4v1510513428790" style="border:0" allowfullscreen></iframe>
			</div>	 -->
			<div class="col-md-12 col-sm-12 col-xs-12 contact-right-w3l">
				<div id="contact-success-msg" style="color: green;"></div>
				<div id="contact-error-msg" style="color: red;"></div>
				<form action="#" method="post">
					<input type="text" id="contact_fName" name="name" placeholder="First Name" required="">
					<input type="text" id="contact_lName" name="name" placeholder="Last Name" required="">
					<input type="email" id="contact_email" name="name" placeholder="Email" required="">
					<input type="text" id="contact_subject" name="name" placeholder="Subject" required="">
					<textarea placeholder="Your Message" required="" id="contact_message"></textarea>
					<input type="submit" value="SEND MESSAGE" class="contact-us-request">
				</form>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>

<script>
jQuery.noConflict();
    (function($) {
      $(function() {
      
		$('#horizontalTab').easyResponsiveTabs({
			type: 'default', //Types: default, vertical, accordion           
			width: 'auto', //auto or any width like 600px
			fit: true   // 100% fit in a container
		});
		
	
			$("#owl-demo").owlCarousel({
			  autoPlay: true, //Set AutoPlay to 3 seconds
			  items :3,
			  itemsDesktop : [640,2],
			  itemsDesktopSmall : [414,1],
			  navigation : true,
			  // THIS IS THE NEW PART
				afterAction: function(el){
					//remove class active
					this
					.$owlItems
					.removeClass('active')
					//add class active
					this
					.$owlItems //owl internal $ object containing items
					.eq(this.currentItem + 1)
					.addClass('active')
					}
			// END NEW PART
		 
			});
			
		
		
		
		//$().UItoTop({ easingType: 'easeOutQuart' });
		
      
		  $('.flexslider').flexslider({
			animation: "slide",
			start: function(slider){
			  $('body').removeClass('loading');
			}
		  });
		
      
      $(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
      
      $(".search-student").click(function(event){	
    	  jQuery(".search-data").slideDown();
			
		  var school, filter, table, tr, td, i, campus, profession, gender, language, zipcode;
		  school = document.getElementById("school");
		  schoolfilter = school.value.toUpperCase();
		  
		  campus = document.getElementById("campus");
		  campusfilter = campus.value.toUpperCase();
		  
		  profession = document.getElementById("profession");
		  professionfilter = profession.value.toUpperCase();
		  
		  gender = document.getElementById("gender");
		  genderfilter = gender.value.toUpperCase();
		  
		  language = document.getElementById("language");
		  languagefilter = language.value.toUpperCase();
		  
		  zipcode = document.getElementById("zipcode");
		  zipcodefilter = zipcode.value.toUpperCase();
		  
		  
		  table = document.getElementById("datatable");
		  tr = table.getElementsByTagName("tr");

		  
		  for (i = 0; i < tr.length; i++) {
		    
			professiontd = tr[i].getElementsByTagName("td")[2];
			gendertd = tr[i].getElementsByTagName("td")[3];
			schooltd = tr[i].getElementsByTagName("td")[4];
		  	campustd = tr[i].getElementsByTagName("td")[5];
		  	languagetd = tr[i].getElementsByTagName("td")[6];
		  	zipcodetd = tr[i].getElementsByTagName("td")[7];
		  	
		  	if (professiontd){
		  		if( professiontd.innerHTML.toUpperCase().indexOf(professionfilter) > -1){
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
		  	}  
		  	if (gendertd){
		  		if( gendertd.innerHTML.toUpperCase().indexOf(genderfilter) > -1){
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
		  	}
		  	if (schooltd){
		  		if( schooltd.innerHTML.toUpperCase().indexOf(schoolfilter) > -1){
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
		  	}
		  	if (campustd){
		  		if( campustd.innerHTML.toUpperCase().indexOf(campusfilter) > -1){
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
		  	}
		  	if (languagetd){
		  		if( languagetd.innerHTML.toUpperCase().indexOf(languagefilter) > -1){
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
		  	}
		  	if (zipcodetd){
		  		if( zipcodetd.innerHTML.toUpperCase().indexOf(zipcodefilter) > -1){
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
		  	}
		  	if (professiontd && gendertd){
		  		if( professiontd.innerHTML.toUpperCase().indexOf(professionfilter) > -1 
		  				&& gendertd.innerHTML.toUpperCase().indexOf(genderfilter) > -1){
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
		  	}
		  	if (professiontd && gendertd && schooltd ){
		  		if( schooltd.innerHTML.toUpperCase().indexOf(schoolfilter) > -1
			  			&& professiontd.innerHTML.toUpperCase().indexOf(professionfilter) > -1
			  			&& gendertd.innerHTML.toUpperCase().indexOf(genderfilter) > -1){
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
		  	}
		  	if (professiontd && gendertd && schooltd && campustd){
		  		if( schooltd.innerHTML.toUpperCase().indexOf(schoolfilter) > -1
			  			&& 	campustd.innerHTML.toUpperCase().indexOf(campusfilter) > -1
			  			&& professiontd.innerHTML.toUpperCase().indexOf(professionfilter) > -1
			  			&& gendertd.innerHTML.toUpperCase().indexOf(genderfilter) > -1){
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
		  	}
		  	if (professiontd && gendertd && schooltd && campustd && languagetd){
		  		if( schooltd.innerHTML.toUpperCase().indexOf(schoolfilter) > -1
			  			&& 	campustd.innerHTML.toUpperCase().indexOf(campusfilter) > -1
			  			&& professiontd.innerHTML.toUpperCase().indexOf(professionfilter) > -1
			  			&& languagetd.innerHTML.toUpperCase().indexOf(languagefilter) > -1
			  			&& gendertd.innerHTML.toUpperCase().indexOf(genderfilter) > -1){
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
		  	}
		  	if (professiontd && gendertd && schooltd && campustd && languagetd && zipcodetd){
		  		if( schooltd.innerHTML.toUpperCase().indexOf(schoolfilter) > -1
			  			&& 	campustd.innerHTML.toUpperCase().indexOf(campusfilter) > -1
			  			&& professiontd.innerHTML.toUpperCase().indexOf(professionfilter) > -1
			  			&& languagetd.innerHTML.toUpperCase().indexOf(languagefilter) > -1
			  			&& gendertd.innerHTML.toUpperCase().indexOf(genderfilter) > -1
			  			&& zipcodetd.innerHTML.toUpperCase().indexOf(zipcodefilter) > -1){
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
		  	}
		  	
		  
		  }
	  });
      
     });
   })(jQuery);
</script>

<aui:script>

AUI().use('aui-io-request', 'aui-autocomplete' ,'aui-base','aui-form-validator','autocomplete-list','autocomplete-filters','autocomplete-highlighters','node-event-simulate', function(A) {
	A.one(".contact-us-request").on('click', function(e) {
		var contactUSReqeustURL = '${contactUSReqeustURL}';
		var firstName=A.one("#contact_fName").val();
		var lastName = A.one("#contact_lName").val();
		var email  = A.one("#contact_email").val();
		var sub = A.one("#contact_subject").val();
		var msg = A.one("#contact_message").val();
		
		if(firstName==''){
			return;
		}
		
		if(lastName==''){
			return;
		}
		
		if(email==''){
			return;		
		}
	
		if(sub==''){
			return;
		}
		
		A.one("#contact-success-msg").text('');
		A.one("#contact-error-msg").text('');
		A.io.request(contactUSReqeustURL.toString(),{
			dataType: 'json',
			method: 'POST',
			data :{
				'<portlet:namespace/>firstName' : A.one("#contact_fName").val(),
				'<portlet:namespace/>lastName' : A.one("#contact_lName").val(),
				'<portlet:namespace/>email' : A.one("#contact_email").val(),
				'<portlet:namespace/>subject' : A.one("#contact_subject").val(),
				'<portlet:namespace/>message' : A.one("#contact_message").val()
			},
			on: {
			success: function() {
				var response=this.get('responseData');
				if(response.success){
					A.one("#contact-success-msg").text("Your resquest sent successfully, our team will contact you soon. Thank You !!");
				}else{
					A.one("#contact-success-msg").text("Error while sending your request, please try again.");
				}
			}
		  }
		});
	});
});
</aui:script>
