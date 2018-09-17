<%@ include file="/init.jsp" %>
<liferay-ui:error key="err-register-user" message="err-register-user"/>
<liferay-ui:success key="user-register-success" message="user-register-success"/>
<%
	String imagePath = themeDisplay.getPathThemeImages(); //request.getContextPath()+"/images";
%>
<portlet:resourceURL id="/contact-us" var="contactUSReqeustURL"></portlet:resourceURL>
<!--/banner-section-->
     <!-- Section: intro -->
    <section id="demo-1" class="intro" data-zs-src='["<%=imagePath %>/b1.jpg","<%=imagePath %>/6.jpg","<%=imagePath %>/b4.jpg"]' data-zs-overlay="dots">
		<div class="intro-content demo-inner-content">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<div class="wow fadeInDown" data-wow-offset="0" data-wow-delay="0.1s">
							<h3 class="h-ultra">YOUR </h3>
							<h2>PREMIER HEALTHCARE </h2>
							<h2>INTERNSHIP PORTAL</h2>
							<hr  align="left">
							<div id="about_us"></div>
						</div>
					</div>
				</div>		
			</div>
		</div>		
    </section>
   <!-- /Section: intro -->
	
	<!-- Section: boxes -->
    <section id="aboutus" class="home-section paddingtop-80">
		<div class="container">
			<div class="row">
				<div class="col-sm-5 col-md-5">
					<!-- <img width="100%" src="img/g8.jpg"> -->
					<iframe width="100%" height="315" src="https://www.youtube.com/embed/sz1ndY545ko?rel=0" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
				</div>
				<div class="col-sm-7 col-md-7" style="height: 450px;overflow-y: scroll;">
					<h2>About Us</h2><hr align="left">
					<p>Looking for a new medical, dental, veterinary, or administrative assistant for your practice? How about a sonographist, phlebotomist, kinesiologist, or patient care technician? Medicus Group LLC may have a solution for you.</p>
					<p>At Medicus Group LLC, our mission is to match non-paid healthcare interns with local healthcare partners. Our portal streamlines the intern selection process by partnering with multiple reputable schools to upload hundreds of qualified non-paid interns. Before these students receive their certification, they are required to complete a non-paid 4- to 8-week internship with a healthcare provider. Both the student and the healthcare partner benefit from this relationship. The student can obtain the internship hours needed to become certified, and the provider can use the internship as an unpaid extended work interview. This unique one-stop-selection portal reduces the burdening process of searching for a new healthcare professional and experiencing the frustration of receiving a non-qualified intern.</p>
					<p>By using our proprietary analytics, you can personalize your search by identifying specific qualities that you want, and request the intern that best fits your needs. During the search, you can filter by gender, zip code, profession, preferred second language, school, and school campus. You can also view resumes before requesting the intern. There is no obligation to hire. There is no limit to the number of interns you may request, and best of all, the school carries the student's liability insurance when the intern is working at your office. </p>
					<p>Act now. Start reducing your payroll expenses today and find your next assistant or technician. We guarantee that your Return on Investment with us will be at least 300%.</p>
					<p>Register as a partner now and receive a FREE 45 days no-risk, 100% money-back guarantee.</p>
				</div>
				<div class="col-sm-7 col-md-7 col-md-offset-5" style="margin-top:30px"><a href="#" class="intern-btn" data-toggle="modal" data-target="#registrationform">Find Your Next Non-Paid Intern Here</a></div>
				
			</div>
		</div>

	</section>	
	
	<!-- /Section: boxes -->
	<section id="services" class="home-section">
	
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-12">
					<h2>Services</h2><hr>
				</div>
				<div class="analytics col-sm-10 col-md-10 col-md-offset-1">
					<div class="service-title"><img src="<%=imagePath %>/analytics_icon.png"><h3>Analytics</h3></div>
					<div class="col-md-3"><h1>15</h1><h4>Schools</h4><div class="vl"></div></div>
					<div class="col-md-3"><h1>45</h1><h4>Campuses</h4><div class="vl"></div></div>
					<div class="col-md-3"><h1>1745</h1><h4>Students</h4><div class="vl"></div></div>
					<div class="col-md-3"><h1>5750</h1><h4>Partners</h4></div>
				</div>
				<div class="custom-plan col-sm-10 col-md-10" style="height:750px;">
					<div class="service-title"><img src="<%=imagePath %>/custom_plan_icon.png"><h3>Custom Plan</h3></div>
					<p class="title-caption">We have one flexible plan to meet your every internship need. Our plan includes the following advantages:</p>
					<ul class="custom-plan-list" style="padding-left:20px"> 
						<li><p>You have real-time 24/7 access to 100s of students that are available to intern</p></li>
						<li><p>You have unlimited searches and inquiry of qualified interns</p></li>
						<li><p>You can filter your search by Zipcode, Gender, Language, Profession, School, and Campus</p></li>
						<li><p>You have direct access to school representatives to coordinate interviews </p></li>
						<li><p>Student liability insurance is covered by the school while working at your office</p></li>
						<li><p>Your return on investment (ROI) is guaranteed to exceed 300%</p></li>
						<li><p>Take advantage of our 45 days Risk-Free money back trial period in annual package</p></li>
					</ul>
					
					<div class="col-md-12 annual-pack">
						<span class="save-annum">Save<br>20%<br>Annually</span>
						<div class="col-md-12 text-center"><h3>Annual Package</h3></div>
						<div class="col-md-4 text-center price"><h4>$41.58</h4></div>
						<div class="col-md-8 text-center request"><h4><a href="##" data-toggle="modal" data-target="#registrationform">REQUEST YOUR INTERN TODAY</a></h4></div>
						<div class="col-md-4 text-center"><h5>Per month, Billed Annually</h5></div>
						<div class="col-md-8"><h5>SIGN UP UNDER A MINUTE</h5></div>
					</div>
					
					<div class="col-md-12 monthly-pack">
						<div class="col-md-12 text-center"><h3>Monthly Package</h3></div>
						<div class="col-md-4 text-center price"><h4>$52.08</h4></div>
						<div class="col-md-8 text-center request"><h4><a href="##" data-toggle="modal" data-target="#registrationform">REQUEST YOUR INTERN TODAY</a></h4></div>
						<div class="col-md-4 text-center"><h5>Per month, Billed Monthly</h5></div>
						<div class="col-md-8"><h5>SIGN UP UNDER A MINUTE</h5></div>
					</div>
				</div>
				<div class="col-sm-12 col-md-12 roi">
					<a class="roi-btn" href="##" data-toggle="modal" data-target="#registrationform">Click Here to Get 300% ROI</a>
				</div>
			</div>
		</div>
	</section>
	
<!--blog-->
    <section id="professions" class="home-section">
	<div class="container">
			<div class="row">
			<div class="col-sm-12 col-md-12">
					<h2>Professions</h2><hr>
			</div>
		<div class="col-sm-12 col-md-12 prof-img" id="horizontalTab">
    			<div class="clearfix"> </div>
    			<div class="resp-tabs-container">
					<div class="tab-1 resp-tab-content">	
				<div class="col-sm-6 col-md-3">				
					<a href="<%=imagePath %>/g1.jpg" data-lightbox="example-set" data-title="<h3>Dental Assistant</h3>Our colleges teach a wide span of job skills that ensure success in our students career as a dental assistant.  Our colleges' accredited training program offers courses that teach chair-side assisting and help students gain hands on experience.
					<ul><li>Prepare patients for examination and treatment</li><li>Take x-ry examinations (Radiography)</li><li>Sterilize and disinfect instruments and equipment</li><li>Prepare tray setups for dental procedures</li><li>Prepare materials for making impressions and restoration</li></ul>
					">
						<img src="<%=imagePath %>/g1.jpg" class="img-responsive zoom-img" alt=""/>
						<div class="b-wrapper">
							<h5>Dental Assistant</h5>
						</div>
					</a>
				</div>
				<div class="col-sm-6 col-md-3">
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
				<div class="col-sm-6 col-md-3">
							<a href="<%=imagePath %>/g3.jpg" data-lightbox="example-set" data-title="<h3>Phlebotomy</h3>Our colleges' program provides training in obtaining blood specimens by venipuncture and micro-collection techniques.  Phlebotomy technician classes also teach students to collect and process other clinical specimens, along with Point of Care procedures.
							">
								<img src="<%=imagePath %>/g3.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Phlebotomy</h5>
								</div>
							</a>
				</div>
				<div class="col-sm-6 col-md-3">
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
				<div class="col-sm-6 col-md-3">
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
				<div class="col-sm-6 col-md-3">
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
				<div class="col-sm-6 col-md-3">
					<a href="<%=imagePath %>/g4.jpg" data-lightbox="example-set" data-title="<h3>Sonography</h3>Our Sonographer, student perform and interpret ultrasound scans to help physicians diagnose a range of diseases, assist surgeons with biopsies, and track the health and growth of developing fetuses.  Our program teaches students sophisticated sonographic procedures and technology, as well as the interpersonal skills necessary to work directly with patients in a range of settings, from physician’s offices and OB/GYN clinics, to hospitals and diagnostic laboratories.
					">
						<img src="<%=imagePath %>/g4.jpg" class="img-responsive zoom-img" alt=""/>
						<div class="b-wrapper">
							<h5>Sonography</h5>
						</div>
					</a>
				</div>
				<div class="col-sm-6 col-md-3">
					<a href="<%=imagePath %>/g9.jpg" data-lightbox="example-set" data-title="<h3>Kinesiology</h3>
					">
						<img src="<%=imagePath %>/g9.jpg" class="zoom-img" alt="" />
						<div class="b-wrapper">
							<h5>Kinesiology</h5>
						</div>
					</a>
				</div>
			</div>
			</div>
			</div>
			
			<div class="col-sm-12 col-md-12 snap">
					<a class="snap-btn" href="##" data-toggle="modal" data-target="#registrationform">Snag Your Ideal Intern Here</a>
			</div>
		</div>	
	</div>
	</section>
	
	<!-- Section: articles -->
    <section id="articles" class="home-section paddingtop-80">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-12">
					<h2>Articles</h2><hr>
				</div>
				<div class="article-content col-sm-12 col-md-12">
					<ul class="list-group" style="padding-left:20px"> 
						<li><a target="_blank" href="http://slicecommunications.com/roi-of-an-unpaid-internship/">ROI OF AN UNPAID INTERNSHIP</a></li>
						<li><a target="_blank" href="https://www.ellevatenetwork.com/articles/6617-invest-in-the-unpaid-intern-and-everyone-gets-a-roi">Invest In The Unpaid Intern And Everyone Gets A ROI</a></li>
						<li><a target="_blank" href="https://www.linkedin.com/pulse/real-roi-internships-daniel-wright/">The Real ROI of Internships</a></li>
						<li><a target="_blank" href="https://pubsonline.informs.org/doi/abs/10.1287/isre.1110.0382">Editorial Overview - The Role of Information Systems in Healthcare: Current Research and Future Trends</a></li>
						<li><a target="_blank" href="http://www.sciencedirect.com/science/article/pii/S0148296311000555">Innovation in healthcare: Issues and future trends</a></li>
						<li><a target="_blank" href="https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3116776/">Ten 10-Year Trends for the Future of Healthcare: Implications for Academic Health Centers</a></li>
						<li><a target="_blank" href="https://www.healthcatalyst.com/top-healthcare-trends-challenges">Top 7 Healthcare Trends and Challenges from Our Financial Expert</a></li>
						<li><a target="_blank" href="http://managedhealthcareexecutive.modernmedicine.com/managed-healthcare-executive/news/four-tech-trends-healthcare-2017">Four tech trends in healthcare in 2017</a></li>
						<li><a target="_blank" href="https://money.usnews.com/money/blogs/outside-voices-careers/2011/04/29/why-you-should-get-a-summer-internship">Why You Should Get a Summer Internship</a></li>
						<li><a target="_blank" href="https://theundercoverrecruiter.com/7-reasons-take-internship/">7 Reasons You Should Take an Internship</a></li>
						<li><a target="_blank" href="https://www.collegemagazine.com/why-get-internship/">Why Get An Internship?</a></li>
						<li><a target="_blank" href="http://hitconsultant.net/2017/12/18/defining-healthcare-trends-to-watch-2018/">12 Defining Healthcare Trends to Watch in 2018</a></li>
						<li><a target="_blank" href="https://www.pwc.com/us/en/health-industries/health-research-institute/behind-the-numbers.html">Medical cost trend - Behind the numbers 2018</a></li> </ul>
				</div>
				<div class="col-sm-12 col-md-12 payroll">
					<a class="payroll-btn" href="##" data-toggle="modal" data-target="#registrationform">Tap Here to Reduce Your Payroll Cost</a>
				</div>
				
			</div>
		</div>
	</section>
	
	<!--  //Articles -->
	
	<section id="testimonials" class="home-section ">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-12">
					<h2>Testimonials</h2><hr>
				</div>
                <div class="col-sm-12 col-md-12 col-lg-12" >
					<div class="wow bounceInUp" data-wow-delay="0.2s">
                    <div id="owl-works" class="owl-carousel">
                        <div class="item">
                        	<div class="col-sm-12 col-md-12 col-lg-12" >
                        		<img width="100" src='<%= imagePath + "/testimonials/t1.jpg" %>'>
                        		<p>After obtaining the patient care experience I needed, I was accepted into a Physician Assistance program. I have recently graduated and have secured my first job as a PA in an Emergency Department, where I not only use my skills as a Physician Assistant, but also as a Phlebotomist. Thank you PMI!</p>
                        		<h4>Christopher Sessions</h4>
                        		<h5>East Valley Campus Phlebotomy Program</h5>
                        	</div>
                        </div>
                        <div class="item">
                        	<div class="col-sm-12 col-md-12 col-lg-12" >
                        		<img width="100" src='<%= imagePath + "/testimonials/t2.jpg" %>'>
                        		<p>I am so appreciative of my PMI education. It has make a true difference in my life, and I will be forever grateful.</p>
                        		<h4>Anotella Tartufol</h4>
                        		<h5>Aurora Campus Dental Assistant Program</h5>
                        	</div>
                        </div>
                        <div class="item">
                        	<div class="col-sm-12 col-md-12 col-lg-12" >
                        		<img width="100" src='<%= imagePath + "/testimonials/t3.jpg" %>'>
                        		<p>PIMA Medical Institute has become a family affair for me and my sisters. It all started when my sister, Miranda, began researching colleges. She was felling discouraged on her visits to some of the larger institutions. But walking into PMI felt like just the right atmosphere. They made her feel like she was important and she signed up for the Medical Assistant program. Upon graduation, she was offered a position working for an ENT specialist.</p>
                        		<h4>Claudia Silguero Garza</h4>
                        		<h5>Houston Campus Medical Administrative Program</h5>
                        	</div>
                        </div>
                    </div>
					</div>
                </div>
                <div class="col-sm-12 col-md-12 profit">
					<a class="profit-btn" href="##" data-toggle="modal" data-target="#registrationform">Opt Here to Improve Your Profit</a>
				</div>
            </div>
		</div>
	</section> 
	
	<section id="faqs" class="home-section">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-12">
					<h2>Frequently Asked Questions</h2><hr>
				</div>
				<div class="col-md-5 col-sm-5">
					<!-- <img src="img/g1.jpg" width="100%"/> -->
					<iframe width="100%" height="315" src="https://www.youtube.com/embed/hieXFos3zyM?rel=0" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
				</div>
				<div class="col-md-7 col-sm-7">
					<div class="panel-group" id="accordion">
					    <div class="panel panel-default">
					      <div class="panel-heading">
					        <h4 class="panel-title">
					          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">What is an in/externship program?</a>
					        </h4>
					      </div>
					      <div id="collapse1" class="panel-collapse collapse in">
					        <div class="panel-body"> Internships and externships are temporary jobs that give students short-term work experience in their chosen career field. When the internship or externship ends, the student returns to finish their healthcare program.</div>
					      </div>
					    </div>
					    <div class="panel panel-default">
					      <div class="panel-heading">
					        <h4 class="panel-title">
					          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">What are unpaid interns?</a>
					        </h4>
					      </div>
					      <div id="collapse2" class="panel-collapse collapse">
					        <div class="panel-body">Unpaid interns are not employees. They are not part of your payroll and their work hour requirements vary by program.  They work to apply in classroom knowledge to gain practical experience.  They bring fresh thinking and latest industry techniques to their healthcare partner. </div>
					      </div>
					    </div>
					    <div class="panel panel-default">
					      <div class="panel-heading">
					        <h4 class="panel-title">
					          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">How many hours are inters suppose to work?.</a>
					        </h4>
					      </div>
					      <div id="collapse3" class="panel-collapse collapse">
					        <div class="panel-body">Non-paid intern work hours vary by profession and school. Depending on the profession, hours may range from 200 to 450 hours. Each student generally works from 30 to 40 hour weeks.</div>
					      </div>
					    </div>
					    <div class="panel panel-default">
					      <div class="panel-heading">
					        <h4 class="panel-title">
					          <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">How much is the subscription?</a>
					        </h4>
					      </div>
					      <div id="collapse4" class="panel-collapse collapse">
					        <div class="panel-body">When you register to be a healthcare partner, you have 45 days to use the service risk-free with 100% money back guaranty. After 45 days, your investment is just $300 per year.</div>
					      </div>
					    </div>
					  </div>
				</div>
				<div class="col-sm-12 col-md-12 intern">
					<a class="intern-btn" href="##" data-toggle="modal" data-target="#registrationform">Find Your Next Non-Paid Intern Here</a>
				</div>
			</div>
		</div>
	</section>	
	
	<section id="videos" class="home-section">
	
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-12">
					<h2>Videos</h2><hr>
				</div>
				<div class="col-sm-12 col-md-12">
					<div class="col-md-4 col-sm-4">
							<span>
								<iframe width="100%" height="315" src="https://www.youtube.com/embed/POTFJG9yTUo?rel=0" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
							</span>
					</div>
					<div class="col-md-4 col-sm-4">
							<span>
								<iframe width="100%" height="315" src="https://www.youtube.com/embed/90gAMCUvQ08?rel=0" frameborder="0" allow="autoplay; encrypted-media" allowfullscreen></iframe>
							</span>
					</div>
				</div>
				<div class="col-sm-12 col-md-12 productivity">
					<a class="productivity-btn" href="##" data-toggle="modal" data-target="#registrationform">Select Here to Increase Productivity</a>
				</div>
			</div>
		</div>
	</section>
	
	<section id="sponsors" class="home-section">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-12">
					<h2>Sponsors, Partners, And Schools</h2><hr>
				</div>
				<div class="col-sm-12 col-md-12">
					<img width="100%" src="<%=imagePath %>/partners.png">
				</div>
				<div class="col-sm-12 col-md-12 joinclub">
					<a class="joinclub-btn" href="##" data-toggle="modal" data-target="#registrationform">Join The Club</a>
				</div>
			</div>
		</div>
	</section>
	
	<!--  //faqs -->
	
	<section id="contact" class="home-section">
		<div class="container">
			<div class="row">
				<div class="col-sm-12 col-md-12">
					<h2>Contact</h2><hr align="left">
				</div>
				<div class="col-sm-12 col-md-12" style="margin-bottom: 20px;">
					<span id="contact-success-msg" style="color: #22cf37;"></span>
					<span id="contact-error-msg" style="color: #cf6522;"></span>
				</div>
				<div class="col-md-8 col-sm-8" style="padding-left: 0;">
					<form>
					  <div class="form-group col-md-6">
					    <input type="text" placeholder="First Name" class="form-control" id="contact_fName">
					  </div>
					  <div class="form-group col-md-6">
					    <input type="text" placeholder="Last Name" class="form-control" id="contact_lName">
					  </div>
					  <div class="form-group col-md-6">
					    <input type="email" placeholder="Email" class="form-control" id="contact_email">
					  </div>
					  <div class="form-group col-md-6">
					    <input type="text" placeholder="Subject" class="form-control" id="contact_subject">
					  </div>
					  <div class="form-group col-md-12">
					  	<textarea class="form-control" type="textarea" id="contact_message" placeholder="Message" maxlength="140" rows="6"></textarea>
					  </div>
					  <div class="form-group col-md-12">
					  	<button type="button" class="btn btn-default contact-us-request">Send Message</button>
					  </div>
					</form>
				</div>
				<div class="col-md-4 col-sm-4 contact-info">
					<div class="col-md-1">
						<img src="<%=imagePath %>/location_icon.png">
					</div>
					<div class="col-md-11">
						<p>Location</p>
						<h5>Houston, TX USA</h5>
					</div>
					<div class="col-md-1">
						<img src="<%=imagePath %>/email_icon.png">
					</div>
					<div class="col-md-11">
						<p>Email Support</p>
						<h5>TechSupport@MedicusGroupLLC.com</h5>
					</div>
					<div class="col-md-1">
						<img src="<%=imagePath %>/contact_icon.png">
					</div>
					<div class="col-md-11">
						<p>Call Support</p>
						<h5>(888) 380-3305</h5>
					</div>
				</div>
			</div>
		</div>
	</section>
	

<script>
jQuery.noConflict();
    (function($) {
      $(function() {
     
		 $('.horizontalTab').easyResponsiveTabs({
			type: 'default', //Types: default, vertical, accordion           
			width: 'auto', //auto or any width like 600px
			fit: true   // 100% fit in a container
		});
		
		//owl carousel
		$('#owl-works').owlCarousel({
	            items : 1,
	            itemsDesktop : [1199,5],
	            itemsDesktopSmall : [980,5],
	            itemsTablet: [768,5],
	            itemsTabletSmall: [550,2],
	            itemsMobile : [480,2],
		});
		
		 $(document).on( "click", ".alert .close", function() {
			$(this).parent().hide();
		});
		
		//$().UItoTop({ easingType: 'easeOutQuart' });
		
      /* 
		  $('.flexslider').flexslider({
			animation: "slide",
			start: function(slider){
			  $('body').removeClass('loading');
			}
		  }); */
		
      
     /*  $(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		}); */
     
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
				if(response && response.success){
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
