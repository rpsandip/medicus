<%@ include file="/init.jsp" %>
<%
	String imagePath = request.getContextPath()+"/images";
%>
<portlet:resourceURL id="/contact-us" var="contactUSReqeustURL"></portlet:resourceURL>
<!--/banner-section-->
	<div d="demo-1" data-zs-src='["<%=imagePath %>/b1.jpg","<%=imagePath %>/6.jpg","<%=imagePath %>/b2.jpg","<%=imagePath %>/b3.jpg","<%=imagePath %>/b4.jpg"]' data-zs-overlay="dots" style="min-height: 570px;">
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
						<h1><a  onclick="window.location.reload(true);" href="#"><span class="letter">M</span>edicus <span>G</span>roup</a></h1>
					</div>
					<!-- navbar-header -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li class="active"><a href="index.html">Home</a></li>
								<li><a href="#about" class="scroll">About</a></li>
								<li><a href="#agileits-services" class="scroll">Services</a></li>
								<li><a href="#blog" class="scroll">Articles</a></li>
								<li><a href="#team" class="scroll">Team</a></li>
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
				   <h3><span>W</span>elcome To Your Premier <span>H</span>ealth <span>I</span>nternship <span>P</span>ortal</h3><br>
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
				<p>At Medicus Group, providing interns with real work is number one to ensuring our program’s success. Interns do work related to their major, that is challenging, that is recognized by the organization as valuable, and that fills the entire work term.</p><br>
				<p>We work closely with our partner schools and our growing list of healthcare partners to guarantee that hiring managers provide real work assignments by checking job descriptions, emphasizing the importance of real work assignments during a manager/mentor orientation sessions, and communicating with interns frequently throughout the work term to determine who they perceive what they are doing.</p>
			</div>
			<div class="col-md-5 w3ls-row">
				<div class="col-md-6 col-sm-6 wthree-about-left">
					<img src="<%=imagePath %>/about2.jpeg" class="img-responsive" alt=""/>
				</div>
				<div class="col-md-6 col-sm-6 w3ls-row alert wthree-about-right">
					<img src="<%=imagePath %>/about3.jpeg" class="img-responsive" alt=""/>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
			<div class="stats-info agileits-w3layouts">
				<div class="col-sm-3 col-xs-3 stats-grid">
					<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='45' data-delay='.5' data-increment="1">${schoolCount }</div>
					<div class="stats-img stat2">
							<p>Schools</p>
					</div>
				</div>
				<div class="col-sm-3 col-xs-3 stats-grid">
					<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='75' data-delay='.5' data-increment="1">${campusCount }</div>
					<div class="stats-img stat2">
						<p>Campuses</p>
					</div>
				</div>
				<div class="col-sm-3 col-xs-3 stats-grid stat1">
					<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='745' data-delay='.5' data-increment="1">${studentCount }</div>
					<div class="stats-img stat2">
						<p>Students</p>
					</div>
				</div>
				<div class="clearfix"></div>
		 </div>
		 <br>
		 <form id="add-new-school-form" data-parsley-validate="" class="form-horizontal form-label-left" style="text-align:center">
               <div class="form-group" style="margin:0">
                 <div class="col-md-3 col-sm-6 col-xs-12">
                   <select class="form-control">
                      <option>Select School</option>
                      <option>School 1</option>
                      <option>School 2</option>
                      <option>School 3</option>
                    </select>
                 </div>
                 <div class="col-md-3 col-sm-6 col-xs-12">
                   <select class="form-control">
                      <option>Select Campus</option>
                      <option>Campus 1</option>
                      <option>Campus 2</option>
                      <option>Campus 3</option>
                    </select>
                 </div>
                 <div class="col-md-3 col-sm-6 col-xs-12">
                   <select class="form-control">
                      <option>Select Profession</option>
                      <option>Dental Assistant</option>
                      <option>Medical Assistant</option>
                      <option>Medical Administrative Assistance</option>
                      <option>Phlebotomy</option>
                      <option>Pharmacy Technician</option>
                      <option>Patient Care Technician</option>
                      <option>Veterinary Assistant</option>
                      <option>Sonography </option>
                    </select>
                 </div>
                 <div class="col-md-3 col-sm-6 col-xs-12">
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
	                          <th>Sr. No.</th>
	                          <th>Name</th>
	                          <th>Profession</th>
	                          <th>Gender</th>
	                          <th>School</th>
	                          <th>Language</th>
	                        </tr>
	                      </thead>
	                      <tbody>
	                        <tr>
	                          <td>1</td>
	                          <td>Student Name</td>
	                          <td> Web Designer </td>
	                          <td>Male</td>
	                          <td>School 1</td>
	                          <td>English</td>
	                        </tr>
	                        <tr>
	                          <td>2</td>
	                          <td>Student Name</td>
	                          <td> Web Designer </td>
	                          <td>Male</td>
	                          <td>School 2</td>
	                          <td>English</td>
	                        </tr>
	                        <tr>
	                          <td>3</td>
	                          <td>Student Name</td>
	                          <td> Web Designer </td>
	                          <td>Male</td>
	                          <td>School 3</td>
	                          <td>English</td>
	                        </tr>
	                        <tr>
	                          <td>4</td>
	                          <td>Student Name</td>
	                          <td> Web Designer </td>
	                          <td>Male</td>
	                          <td>School 4</td>
	                          <td>English</td>
	                        </tr>
	                        <tr>
	                          <td>5</td>
	                          <td>Student Name</td>
	                          <td> Web Designer </td>
	                          <td>Male</td>
	                          <td>School 5</td>
	                          <td>English</td>
	                        </tr>
	                        <tr>
	                          <td>6</td>
	                          <td>Student Name</td>
	                          <td> Web Designer </td>
	                          <td>Male</td>
	                          <td>School 6</td>
	                          <td>English</td>
	                        </tr>
	                        <tr>
	                          <td>7</td>
	                          <td>Student Name</td>
	                          <td> Web Designer </td>
	                          <td>Male</td>
	                          <td>School 7</td>
	                          <td>English</td>
	                        </tr>
	                        <tr>
	                          <td>8</td>
	                          <td>Student Name</td>
	                          <td> Web Designer </td>
	                          <td>Male</td>
	                          <td>School 8</td>
	                          <td>English</td>
	                        </tr>
	                      </tbody>
	                    </table>
	                  </div>
	                </div>
	              </div>
	           	</div>
		 
		</div>
	</div>
	<!-- //about -->
	<!-- Search Filter -->
	
  <!--services-->
  <div class="agileits-services w3ls-section" id="agileits-services" >
		<div class="container">
			<h3 class="w3ls-title">services </h3>
			<div class="agileits-services-row">
				<div class="col-md-6 col-sm-6 agileits-services-grids">
					<span class="glyphicon glyphicon-stats effect-1" aria-hidden="true"></span>
					<h4>Analytics</h4>
					<p>See sample reports and search functions to customize your internship selection and search.</p>
				</div>
				<div class="col-md-6 col-sm-6 agileits-services-grids">
					<span class="glyphicon glyphicon-user effect-1" aria-hidden="true"></span>
					<h4>Custom Plans</h4>
					<p>We have three flexible plans to meet your every internship need.</p>
					<p>Our plan includes the following advantages:</p><p class="text-left">
-	Real time access to students available to intern<br>
-	Unlimited searches<br>
-	Customization of your search by Zip code, Gender, Language, Profession, just to name a few criteria<br>
-	Selection of Schools and campus nearest to you<br>
-	Ability to work with the school to interview students before acceptance<br>
-	Liability insurance of the student<br>
-	Streamline process to select and obtain interns<br>
-	Your return on investment is at least 300% in financial and positive impact<br>
					</p>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--//agileits-services-->
<!--blog-->
	<div id="blog" class="portfolio w3ls-section">
		<div class="container">
			<h3 class="w3ls-title">Articles</h3>
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
							<ul><li>Prepare patients for examination and treatment</li><li>Take x-ry examinations (Radiography)</li><li>Sterilize and disinfect instruments and equipment</li><li>Prepare tray setups for dental procedures</li><li>Prepare materials for making impressions and restoration</li></ul>">
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
							<a href="<%=imagePath %>/g3.jpg" data-lightbox="example-set" data-title="<h3>Phlebotomy</h3>Our colleges' program provides training in obtaining blood specimens by venipuncture and micro-collection techniques.  Phlebotomy technician classes also teach students to collect and process other clinical specimens, along with Point of Care procedures.">
								<img src="<%=imagePath %>/g3.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Phlebotomy</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g8.jpg" data-lightbox="example-set" data-title="<h3>Patient Care Technician</h3>As Patient Care Technicians, our students learn how to handle daily hands-on experiences with patients by helping them with procedures such as taking vital signs, performing electrocardiography (ECG), blood draws, hemodialysis and other needs.
							<ul><li>Performing catheterizations</li><li>Removing sutures and staples</li>
<li>Managing wound care</li><li>Administering ECGs</li><li>Inserting intravenous saline locks</li></ul>">
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
							</ul>">
								<img src="<%=imagePath %>/g6.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Veterinary Assistant</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g4.jpg" data-lightbox="example-set" data-title="<h3>Sonography</h3>Our Sonographer, student perform and interpret ultrasound scans to help physicians diagnose a range of diseases, assist surgeons with biopsies, and track the health and growth of developing fetuses.  Our program teaches students sophisticated sonographic procedures and technology, as well as the interpersonal skills necessary to work directly with patients in a range of settings, from physician’s offices and OB/GYN clinics, to hospitals and diagnostic laboratories.">
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
										<i class="fa fa-user" aria-hidden="true"></i> 
									</div>
									<p>After obtaining the patient care experience I needed, I was accepted into a Physician Assistance program. I have recently graduated and have secured my first job as a PA in an Emergency Department, where I not only use my skills as a Physician Assistant, but also as a Phlebotomist. Thank you PMI!</p>
									<h5>Christopher Sessions - East Valley Campus Phlebotomy Program</h5>
								</div>
							</li>
							<li>	
								<div class="wthree-testi_grid">
									<div class="testimonial-left">
										<i class="fa fa-user" aria-hidden="true"></i> 
									</div>
									<p>I am so appreciative of my PMI education. It has make a true difference in my life, and I will be forever grateful.</p>
									<h5>Anotella Tartufol - Aurora Campus Dental Assistant Program</h5>
								</div>
							</li>
							<li>	
								<div class="wthree-testi_grid">
									<div class="testimonial-left">
										<i class="fa fa-user" aria-hidden="true"></i> 
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
<!-- team -->
	<div class="testimonials w3ls-section" id="team">
		<div class="container">
			<h3 class="w3ls-title">Our Staff</h3>
		<div class="w3_testimonials_grids w3_testimonials_grids">
			<div id="owl-demo" class="owl-carousel"> 
				<div class="item w3_agileits_testimonials_grid">
					<img src="<%=imagePath %>/t1.jpg" alt=" " class="img-responsive" />
					<h4>J. Hobbs</h4>
					<p>Donec quis turpis pellentesque justo pulvinar sceleris.</p>
				</div>
				<div class="item w3_agileits_testimonials_grid">
					<img src="<%=imagePath %>/t2.jpg" alt=" " class="img-responsive" />
					<h4>Paul</h4>
					<p>Donec quis turpis pellentesque justo pulvinar sceleris.</p>
				</div>
				<div class="item w3_agileits_testimonials_grid">
					<img src="<%=imagePath %>/t3.jpg" alt=" " class="img-responsive" />
					<h4>John</h4>
					<p>Donec quis turpis pellentesque justo pulvinar sceleris.</p>
				</div>
				<div class="item w3_agileits_testimonials_grid">
					<img src="<%=imagePath %>/t1.jpg" alt=" " class="img-responsive" />
					<h4>Michael </h4>
					<p>Donec quis turpis pellentesque justo pulvinar sceleris.</p>
				</div>
				<div class="item w3_agileits_testimonials_grid">
					<img src="<%=imagePath %>/t2.jpg" alt=" " class="img-responsive" />
					<h4>Christopher</h4>
					<p>Donec quis turpis pellentesque justo pulvinar sceleris.</p>
				</div>
			</div>
		</div>
	</div>
	</div>
<!-- //team -->

<!-- Faqs -->

<div class="faqs-section w3ls-section" id="faqs">
		<div class="container">
		<h3 class="w3ls-title">FAQs</h3>
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
			$(".search-data").slideDown();
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
