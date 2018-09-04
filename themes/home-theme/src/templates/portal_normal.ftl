<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
		
	<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-KHGMKR2');</script>
<!-- End Google Tag Manager -->
 
     <link rel="shortcut icon" type="image/x-icon" href="${images_folder}/favicon.ico?v=2">

	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Medicus Group</title>
	<@liferay_util["include"] page=top_head_include />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->    	 
  	<!-- css -->
    <link href="${css_folder}/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${css_folder}/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="${css_folder}/cubeportfolio.min.css">
	<link rel="stylesheet" href="${css_folder}/lightbox.css">
	<link href="${css_folder}/nivo-lightbox.css" rel="stylesheet" />
	<link href="${css_folder}/default.css" rel="stylesheet" type="text/css" />
	<link href="${css_folder}/owl.carousel.css" rel="stylesheet" media="screen" />
    <link href="${css_folder}/owl.theme.css" rel="stylesheet" media="screen" />
	<link href="${css_folder}/animate.css" rel="stylesheet" />
    <link href="${css_folder}/style.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${css_folder}/zoomslider.css" />
    <link rel="stylesheet" href="${css_folder}/custom-home.css">
    <!-- boxed bg -->
	<link id="bodybg" href="${css_folder}/bg1.css" rel="stylesheet" type="text/css" />
	<!-- template skin -->
	<link id="t-colors" href="${css_folder}/color-default.css" rel="stylesheet">
    <link href="//fonts.googleapis.com/css?family=Josefin+Sans:100,100i,300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i" rel="stylesheet"> 	  
  	     <script>
		   		 define._amd = define.amd;
		    	define.amd = false;
		  </script>
			
			<script src="${javascript_folder}/easyResponsiveTabs.js"></script>
			<script src="${javascript_folder}/jquery.flexslider.js"></script>
			<script src="${javascript_folder}/jquery.formatter.js"></script>
			<script src="${javascript_folder}/owl.carousel.min.js"></script>
	
		<script>
				define.amd = define._amd;
		</script>
</head>
<body id="page-top" data-spy="scroll" data-target=".navbar-custom">
<div id="wrapper">
			<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-KHGMKR2"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->
			
	 <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="top-area">
			<div class="container">
				<div class="row">
					<div class="col-sm-9 col-md-9">
						<div class="col-md-1"><img width="40" src="${images_folder}/header_mail_icon.png" /></div>
						<div class="col-md-4">
							<span>Email Support</span>
							<p>
								<a href="#" onclick="javascript:window.location='mailto:techsupport@medicusgroupllc.com'">TechSupport@MedicusGroupLLC.com</a>
							</p>
						</div>
						<div class="col-md-1"><img width="40" src="${images_folder}/header_contact_icon.png" /></div>
						<div class="col-md-3"><span>Call Support</span><p>(888) 380-3305</p></div>
					</div>
					<div class="col-sm-3 col-md-3">
						<p class="bold text-right">
							<a class="login-btn" href="##" data-toggle="modal" data-target="#loginform">LogIn</a>
							<a class="reg-btn" href="##" data-toggle="modal" data-target="#registrationform">Partner Registration</a>
						</p>
					</div>
				</div>
			</div>
		</div>
        <div class="container navigation">
		
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="index.html">
                    <img src="${images_folder}/logo.png" alt="" width="100%"  />
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
			  <ul class="nav navbar-nav">
				<li class="active"><a href="#demo-1">Home</a></li>
				<li><a href="#about_us">About</a></li>
				<li><a href="#services">Services</a></li>
				<li><a href="#professions">Professions</a></li>
				<li><a href="#testimonials">Testimonials</a></li>
				<li><a href="#faqs">FAQs</a></li>
				<li><a href="#videos">Videos</a></li>
				<li><a href="#contact">Contact</a></li>
			  </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
	
	    <div class="right_col col-md-12"  role="main">
	    		<@liferay_ui["quick-access"] contentId="#main-content" />
			    <@liferay_util["include"] page=body_top_include />
        		<div class="">
	        		<#if selectable>
						<@liferay_util["include"] page=content_include />
					<#else>
						${portletDisplay.recycle()}
	
						${portletDisplay.setTitle(the_title)}
	
						<@liferay_theme["wrap-portlet"] page="portlet.ftl">
						<@liferay_util["include"] page=content_include />
						</@>
					</#if>
				</div>
		</div>
		
		<footer>
		 <div class="sub-footer">
			<div class="container">
				<div class="row">
					<div class="col-sm-6 col-md-6 col-lg-6">
						<div class="wow fadeInLeft" data-wow-delay="0.1s">
						<div class="text-left">
						<p>&copy; 2018 Medicus Group. All rights reserved.</p>
						</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-6 col-lg-6">
						<div class="wow fadeInRight" data-wow-delay="0.1s">
							<div class="text-right">
								<p>
									<a href="/web/guest/terms-of-service">Privacy Statement</a>
									<a href="https://twitter.com/MedicusGroupLLC"><img src="${images_folder}/tw_icon.png"></a>
									<a href="https://www.facebook.com/Nonpaidinterns/"><img src="${images_folder}/fb_icon.png"></a>
									<a href="https://www.linkedin.com/company/medicus-group-llc/"><img src="${images_folder}/ln_icon.png"></a>
								</p>
							</div>
						</div>
					</div>
				</div>	
			</div>
		</div>
	</footer>
	
			<div class="agileits_w3layouts-footer">		
			<div id="loginform" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			    <!-- Modal content-->
			    <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h4 class="modal-title">Login</h4>
                    </div>
                    <div class="modal-body">
                          <@liferay_portlet["runtime"]
                              portletName="com_liferay_login_web_portlet_LoginPortlet"
                          />
                    </div>
			    </div>
			  </div>
			</div>
			<@liferay_portlet["runtime"]
								portletName="com_example_portlet_MedicusRegistrationModulemvcportletPortlet"
							/>
			<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
			<a href="##" class="trialdays"><img src="${images_folder}/45days.png"></a>

			<@liferay_util["include"] page=body_bottom_include />
			<@liferay_util["include"] page=bottom_include />
		
		<script>
		   		 define._amd = define.amd;
		    	define.amd = false;
			</script>
		
					<script src="${javascript_folder}/jquery-1.10.2.js"></script>
					<script src="${javascript_folder}/modernizr-2.6.2.min.js"></script>
					<script src="${javascript_folder}/lightbox-plus-jquery.min.js"> </script>
					<script src="${javascript_folder}/jquery.easing.min.js"></script>
					<script src="${javascript_folder}/wow.min.js"></script>
					<script src="${javascript_folder}/jquery.scrollTo.js"></script>
					<script src="${javascript_folder}/jquery.appear.js"></script>
					<script src="${javascript_folder}/stellar.js"></script>
					<script src="${javascript_folder}/jquery.cubeportfolio.min.js"></script>
					<script src="${javascript_folder}/nivo-lightbox.min.js"></script>
					<script src="${javascript_folder}/jquery.formatter.js"></script>
					<script src="${javascript_folder}/jquery.zoomslider.min.js"></script>
				 
							
			<script>
				define.amd = define._amd;
			</script>
		</div>	
	  </body>
</html>