<%@ include file="/init.jsp" %>
<%
	String imagePath = request.getContextPath()+"/images";
%>

<!--/banner-section-->
	<div id="demo-1" data-zs-src='["<%=imagePath %>/b1.jpg","<%=imagePath %>/6.jpg","<%=imagePath %>/b2.jpg","<%=imagePath %>/b3.jpg","<%=imagePath %>/b4.jpg"]' data-zs-overlay="dots">
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
						<h1><a  href="index.html"><span class="letter">M</span>edicus <span>G</span>roup</a></h1>
					</div>
					<!-- navbar-header -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li class="active"><a href="index.html">Home</a></li>
								<li><a href="#about" class="scroll">About</a></li>
								<li><a href="#agileits-services" class="scroll">Services</a></li>
								<li><a href="#blog" class="scroll">Blog</a></li>
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
				   <h3><span>w</span>elcome to our <span>u</span>niversity</h3>
				  <p>Itaque earum rerum hic tenetur a sapiente delectus </p>
				  <a class="hvr-rectangle-out w3_play_icon1" href="#" data-toggle="modal" data-target="#myModal"> read more</a>
			   </div>
			<!--/banner-ingo-->		
		</div> 
    </div>
  <!--/banner-section-->
  <!--about -->
	<div id="about" class="wthree-about w3ls-section">
		<div class="container">
			<div class="agileits-banner-grids text-center">
				<div class="banner-bottom-girds">
					<div class="agileits-banner-grid bg-w3ls-active">
						<span class="fa fa-university banner-icon" aria-hidden="true"></span>
						<h4>Academics</h4>
						<p>Itaque earum rerum hic tenetur a sapiente delectus 
							reiciendis maiores alias consequatur aut.</p>
						<a class="hvr-rectangle-out w3_play_icon1" href="#" data-toggle="modal" data-target="#myModal"> read more</a>
					</div>
					<div class="agileits-banner-grid">
						<span class="fa fa-tags banner-icon" aria-hidden="true"></span>
						<h4>Admission</h4>
						<p>Itaque earum rerum hic tenetur a sapiente delectus 
							reiciendis maiores alias consequatur aut.</p>
							<a class="hvr-rectangle-out w3_play_icon1" href="#" data-toggle="modal" data-target="#myModal"> read more</a>
					</div>
					<div class="clearfix"></div>
			    </div>		
			</div>	
			<h2 class="w3ls-title">about us</h2>
			<h5>Lorem Ipsum is simply dummy text of the printing industry.</h5>
			<div class="col-md-7  w3ls-about-left">
				<p>Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. </p>
				<p class="about-bottom">Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages.</p>
			</div>
			<div class="col-md-5 w3ls-row">
				<div class="col-md-6 col-sm-6 wthree-about-left">
					<img src="<%=imagePath %>/about2.jpg" class="img-responsive" alt=""/>
				</div>
				<div class="col-md-6 col-sm-6 w3ls-row alert wthree-about-right">
					<img src="<%=imagePath %>/about3.jpg" class="img-responsive" alt=""/>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="clearfix"> </div>
			<div class="stats-info agileits-w3layouts">
				<div class="col-sm-3 col-xs-3 stats-grid">
					<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='45' data-delay='.5' data-increment="1">45</div>
					<div class="stats-img stat2">
							<p>Schools</p>
					</div>
				</div>
				<div class="col-sm-3 col-xs-3 stats-grid">
					<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='75' data-delay='.5' data-increment="1">75</div>
					<div class="stats-img stat2">
						<p>Campuses</p>
					</div>
				</div>
				<div class="col-sm-3 col-xs-3 stats-grid stat1">
					<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='745' data-delay='.5' data-increment="1">745</div>
					<div class="stats-img stat2">
						<p>Students</p>
					</div>
				</div>
				<div class="col-sm-3 col-xs-3 stats-grid stat1">
					<div class='numscroller numscroller-big-bottom' data-slno='1' data-min='0' data-max='156' data-delay='.5' data-increment="1">156</div>
					<div class="stats-img stat2">
						<p>Branchs</p>
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
                   <button type="button" class="btn btn-primary" onclick="searchData();">Submit</button>
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
				<div class="col-md-3 col-sm-6 agileits-services-grids">
					<span class="glyphicon glyphicon-stats effect-1" aria-hidden="true"></span>
					<h4>Analytics</h4>
					<p>Itaque earum rerum hic tenetur a sapiente delectus 
						reiciendis maiores alias consequatur aut</p>
				</div>
				<div class="col-md-3 col-sm-6 agileits-services-grids">
					<span class="glyphicon glyphicon-user effect-1" aria-hidden="true"></span>
					<h4>Custom Plans</h4>
					<p>Itaque earum rerum hic tenetur a sapiente delectus 
						reiciendis maiores alias consequatur aut</p>
				</div>
				<div class="col-md-3 col-sm-6 agileits-services-grids">
					<span class="glyphicon glyphicon-list-alt effect-1" aria-hidden="true"></span>
					<h4>Monitoring</h4>
					<p>Itaque earum rerum hic tenetur a sapiente delectus 
						reiciendis maiores alias consequatur aut</p>
				</div>
				<div class="col-md-3 col-sm-6 agileits-services-grids">
					<span class="glyphicon glyphicon-check effect-1" aria-hidden="true"></span>
					<h4>Skip Tracing</h4>
					<p>Itaque earum rerum hic tenetur a sapiente delectus 
						reiciendis maiores alias consequatur aut</p>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--//agileits-services-->
<!--blog-->
	<div id="blog" class="portfolio w3ls-section">
		<div class="container">
			<h3 class="w3ls-title">Blog</h3>
		<div class="sap_tabs">			
			<div id="horizontalTab">
				<ul class="resp-tabs-list">
					<li class="resp-tab-item"><span>All</span></li>
					<li class="resp-tab-item"><span>Category1</span></li>
					<li class="resp-tab-item"><span>Category2</span></li>
					<li class="resp-tab-item"><span>Category3</span></li>
					<li class="resp-tab-item"><span>Category4</span></li>					
				</ul>	
				<div class="clearfix"> </div>	
				<div class="resp-tabs-container">
					<div class="tab-1 resp-tab-content">
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g1.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g1.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Dental Assistant</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g2.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g2.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Medical Assistant</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g3.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g3.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Phlebotomy</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g8.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g8.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Patient Care Technician</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g5.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g5.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Medical Administrative Assistant</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g6.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g6.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Veterinary Assistant</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g4.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g4.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>Sonography</h5>
								</div>
							</a>
						</div>
					
						<div class="clearfix"> </div>
					</div>		
					<div class="tab-1 resp-tab-content">
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g8.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g8.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>TechEdu</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g4.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g4.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>TechEdu</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g5.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g5.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>TechEdu</h5>
								</div>
							</a>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="tab-1 resp-tab-content">
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g3.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g3.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>TechEdu</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g1.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g1.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>TechEdu</h5>
								</div>
							</a>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="tab-1 resp-tab-content">
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g5.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g5.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>TechEdu</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g6.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g6.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>TechEdu</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g4.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g4.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>TechEdu</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g7.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g7.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>TechEdu</h5>
								</div>
							</a>
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="tab-1 resp-tab-content">
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g2.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g2.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>TechEdu</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g5.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g5.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>TechEdu</h5>
								</div>
							</a>
						</div>
						<div class="col-md-3 portfolio-grids">
							<a href="<%=imagePath %>/g6.jpg" data-lightbox="example-set" data-title="Lorem Ipsum is simply dummy the when an unknown galley of type and scrambled it to make a type specimen.">
								<img src="<%=imagePath %>/g6.jpg" class="img-responsive zoom-img" alt=""/>
								<div class="b-wrapper">
									<h5>TechEdu</h5>
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
									<p>Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil 
										impedit quo minus id quod possimus, omnis voluptas.</p>
									<h5>John Frank</h5>
								</div>
							</li>
							<li>	
								<div class="wthree-testi_grid">
									<div class="testimonial-left">
										<i class="fa fa-user" aria-hidden="true"></i> 
									</div>
									<p>Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil 
										impedit quo minus id quod possimus, omnis voluptas.</p>
									<h5>Michael Doe</h5>
								</div>
							</li>
							<li>	
								<div class="wthree-testi_grid">
									<div class="testimonial-left">
										<i class="fa fa-user" aria-hidden="true"></i> 
									</div>
									<p>Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil 
										impedit quo minus id quod possimus, omnis voluptas.</p>
									<h5>Thomas Carl</h5>
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
	<!-- contact -->
	<div class="contact-bottom w3ls-section" id="contact">
		<div class="container">
			<h3 class="w3ls-title">contact</h3>
			<p>Lorem ipsum dolor sit amet consec tetuer adi piscing eLorem ipsum dolor sit amet consec tetuer adi piscing.</p>
			<div class="w3layouts-list">
					<div class="col-md-4 li"><span class="fa fa-map-marker" aria-hidden="true"></span><h6>New York, USA</h6></div>
					<div class="col-md-4 li"><span class="fa fa-phone" aria-hidden="true"></span><h6>012 345 678</h6></div>
					<div class="col-md-4 li"><span class="fa fa-location-arrow" aria-hidden="true"></span><a href="mailto:medicusgroup@info.com">medicusgroup@info.com</a></div>
					<div class="clearfix"></div>
			</div>
			<div class="col-md-6 col-sm-6  col-xs-6 agileits_w3layouts-map">
				<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d387193.3059353029!2d-74.25986548248684!3d40.697149419326095!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c24fa5d33f083b%3A0xc80b8f06e177fe62!2sNew+York%2C+NY%2C+USA!5e0!3m2!1sen!2sin!4v1510513428790" style="border:0" allowfullscreen></iframe>
			</div>	
			<div class="col-md-6 col-sm-6 col-xs-6 contact-right-w3l">
				<form action="#" method="post">
					<input type="text" class="name" name="name" placeholder="First Name" required="">
					<input type="text" class="name" name="name" placeholder="Last Name" required="">
					<input type="email" class="name" name="name" placeholder="Email" required="">
					<input type="text" class="name" name="name" placeholder="Subject" required="">
					<textarea placeholder="Your Message" required=""></textarea>
					<input type="submit" value="SEND MESSAGE">
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
      
      function searchData(){
			jQuery(".search-data").slideDown();
		}
      
     });
   })(jQuery);
</script>
