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

	<title>Medicus Group</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
     <title>Medicus </title>
     
     <!-- Bootstrap 3.3.6 -->
  	 <link rel="stylesheet" href="${css_folder}/bootstrap.css">
  	 <link rel="stylesheet" href="${css_folder}/style.css">
  	 <link rel="stylesheet" href="${css_folder}/zoomslider.css">
  	 <link rel="stylesheet" href="${css_folder}/lightbox.css">
  	 <link rel="stylesheet" href="${css_folder}/owl.carousel.css">
  	 <link rel="stylesheet" href="${css_folder}/font-awesome.css">
  	 <link rel="stylesheet" href="${css_folder}/flexslider.css" type="text/css" media="screen" property="" />
  	 <link rel="stylesheet" href="${css_folder}/custom-home.css">
  	 <link href="//fonts.googleapis.com/css?family=Josefin+Sans:100,100i,300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
	 <link href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i" rel="stylesheet">
  	 
  	     <script>
		   		 define._amd = define.amd;
		    	define.amd = false;
		  </script>
			
			<script src="${javascript_folder}/easyResponsiveTabs.js"></script>
			<script src="${javascript_folder}/owl.carousel.js"></script> 
			<script src="${javascript_folder}/jquery.flexslider.js"></script>
			<script src="${javascript_folder}/jquery.formatter.js"></script>
	
		<script>
				define.amd = define._amd;
		</script>
</head>
<body>

			<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-KHGMKR2"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

	    	<div class="w3_agilits_banner_bootm"  data-spy="affix" data-offset-top="150">
			     <div class="w3_agilits_inner_bottom">
			            <div class="wthree_agile_login pull-left">
						     <ul>
								<li><i class="fa fa-phone" aria-hidden="true"></i> (888) 380-3305 </li>
								<li><i class="fa fa-envelope-o list-icon" aria-hidden="true"></i><a href="mailto:techsupport@medicusgroupllc.com">TechSupport@MedicusGroupLLC.com</a></li>
							</ul>
						</div>
			 			<div class="wthree_agile_login">
						  <nav class="login-signup-btn">
						     <ul>
									<@liferay_portlet["runtime"]
								portletName="com_example_portlet_MedicusRegistrationModulemvcportletPortlet"
								/>
								<div class="portlet-boundary">
		                 			<a class="hvr-rectangle-out w3_play_icon1" href="##" data-toggle="modal" data-target="#loginform">LogIn</a>
		               			</div>
							</ul>
						   </nav>	
						</div>
				</div>
			</div>
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
			
	        	<!-- footer -->
			<div class="agileits_w3layouts-footer">
			<div class="col-md-6 col-sm-8 agileinfo-copyright">
				<p>&copy; 2018 Medicus Group. All rights reserved  
				<a href="/web/guest/terms-of-service" target="_blank">Terms Of Service</a>
				</p>
			</div>
			<div class="col-md-6 col-sm-4 agileinfo-icons">
				<ul>
					<li><a class="icon fb" target="_blank" href="https://www.facebook.com/Medicus-Group-LLC-195275977717837/"><i class="fa fa-facebook"></i></a></li>
					<li><a class="icon tw" target="_blank" href="https://twitter.com/MedicusGroupLLC"><i class="fa fa-twitter"></i></a></li>
					<li><a class="icon gp" href="#"><i class="fa fa-google-plus"></i></a></li>
				</ul>
			</div>
			<div class="clearfix"></div>
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
		
			<@liferay_util["include"] page=body_bottom_include />
			<@liferay_util["include"] page=bottom_include />
		
		<script>
		   		 define._amd = define.amd;
		    	define.amd = false;
			</script>
		
					<script src="${javascript_folder}/jquery-2.2.3.min.js"></script>
					<script src="${javascript_folder}/modernizr-2.6.2.min.js"></script>
					<script src="${javascript_folder}/lightbox-plus-jquery.min.js"> </script>
					
		     		<script src="${javascript_folder}/owl.carousel.js"></script> 
					<script src="${javascript_folder}/easing.js"></script>
					
					<script src="${javascript_folder}/SmoothScroll.min.js"></script>
					<script src="${javascript_folder}/jquery.flexslider.js"></script>
					<script src="${javascript_folder}/jquery.formatter.js"></script>
					<script src="${javascript_folder}/jquery.zoomslider.min.js"></script>
				
			<script>
				define.amd = define._amd;
			</script>
	  </body>
</html>