<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

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
  	 <link rel="stylesheet" href="${css_folder}/font-awesome.min.css">
  	 <link rel="stylesheet" href="${css_folder}/custom.css">
  	 <link rel="stylesheet" href="${css_folder}/animate.min.css">
  	 <link rel="stylesheet" href="${css_folder}/dataTables.bootstrap.min.css">
  	 <link rel="stylesheet" href="${css_folder}/flexslider.css">
  	 
  	 <style>
   	.portlet-title-default, .portlet-title-text {
		display: none;
	}
	</style>
	
</head>
 <#if !is_signed_in>
	 <body class="nav-md">
	  <div class="welcomepage">
      	<div class="main_container">
	    	<!-- top navigation -->
	        <div class="top_nav col-md-12">
	          <div class="nav_menu">
	          	<div class="welcome-logo"><a href="welcome.html" class="site_title"><i class="fa fa-paw"></i> <span>Medicus</span></a></div>
	            <nav>
	              <ul class="nav navbar-nav navbar-right">
	                <li class="">
	                 	<button class="btn btn-primary" type="button" data-toggle="modal" data-target="#loginform">LogIn</button>
	                </li>
	                <@liferay_portlet["runtime"]
							portletName="com_example_portlet_MedicusRegistrationModulemvcportletPortlet"
						/>
	              </ul>
	              
	            </nav>
	          </div>
	        </div>
	    	
	    	<div class="right_col col-md-12" role="main">
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
			<!-- footer content -->
        	   <footer>
          		<div class="pull-right">
            		&copy;2017 All Rights Reserved by Medicus
          		</div>
          		<div class="clearfix"></div>
        	</footer>
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
		
		<div id="forgotpassform" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">Forgot Password</h4>
		      </div>
		      <div class="modal-body">
		        <form id="add-new-school-form" data-parsley-validate class="form-horizontal form-label-left">
	               <div class="form-group">
	                 <label class="control-label col-md-3 col-sm-3 col-xs-12" for="emailId">Email Id <span class="required">*</span></label>
	                 <div class="col-md-6 col-sm-6 col-xs-12">
	                   <input type="text" id="emailId" required="required" class="form-control col-md-7 col-xs-12">
	                 </div>
	               </div>
	               <div class="ln_solid"></div>
	               <div class="form-group">
	                 <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
	                   <button type="submit" class="btn btn-primary">Submit</button>
	                 </div>
	               </div>
	             </form>
		      </div>
		    </div>
		  </div>
		</div>
		
		<@liferay_util["include"] page=body_bottom_include />
		<@liferay_util["include"] page=bottom_include />
	  </body>
 <#else>
	<body class="nav-md">
		<div class="container body">
			<@liferay_ui["quick-access"] contentId="#main-content" />
			<@liferay_util["include"] page=body_top_include />
	
			<#if is_omni_admin>
				<@liferay.control_menu />
				<br/>
				<br/>
				<br/>
			</#if>
			<div class="main_container">
		  		<div class="col-md-3 left_col">
		          <div class="left_col scroll-view">
		            <div class="navbar nav_title" style="border: 0;">
		              <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Medicus</span></a>
		            </div>
		
		            <div class="clearfix"></div>
		
		            <!-- menu profile quick info -->
		            <div class="profile clearfix">
		              <div class="profile_pic">
		                <img src="${images_folder}/img.jpg" alt="..." class="img-circle profile_img">
		              </div>
		              <div class="profile_info">
		                <span>Welcome</span>
		                <h2>${user.getFullName()} ${user.getLastName()}</h2>
		              </div>
		            </div>
		            <!-- /menu profile quick info -->
		
		            <br />
		
		            <!-- sidebar menu -->
		            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
		              <div class="menu_section">
		                <ul class="nav side-menu">
		                  <#list nav_items as nav_item>
		                  <#assign
								nav_item_attr_has_popup = ""
								nav_item_attr_selected = ""
								nav_item_css_class = ""
								nav_item_layout = nav_item.getLayout()
							/>
							<#if nav_item.isSelected()>
								<#assign
									nav_item_attr_has_popup = "aria-haspopup='true'"
									nav_item_attr_selected = "aria-selected='true'"
									nav_item_css_class = "selected"
								/>
							</#if>
							<li ${nav_item_attr_selected} class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation">
								<a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem"><span><@liferay_theme["layout-icon"] layout=nav_item_layout /><i class="fa fa-graduation-cap"></i> ${nav_item.getName()}</span></a>
							</li>
		                  </#list>
		                </ul>
		              </div>
		            </div>
		            <!-- /sidebar menu -->
		          </div>
		        </div>
			
				<!-- top navigation -->
			        <div class="top_nav">
			          <div class="nav_menu">
			            <nav>
			              <div class="nav toggle">
			                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
			              </div>
			
			              <ul class="nav navbar-nav navbar-right">
			                <li class="medicus-profile-menu">
			                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
			                    <img src="images/img.jpg" alt="">${user.getFirstName()} ${user.getLastName()}
			                    <span class=" fa fa-angle-down"></span>
			                  </a>
			                  <ul class="dropdown-menu dropdown-usermenu pull-right">
			                    <li><a href="javascript:;"> Profile</a></li>
			                    <li><a href="/c/portal/logout"><i class="fa fa-sign-out pull-right"></i><> Log Out</a></li>
			                  </ul>
			                </li>
			              </ul>
			              
			            </nav>
			          </div>
			        </div>
			        
			        <div class="right_col" role="main">
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
			        
				    	<!-- footer content -->
		        	<footer>
		          		<div class="pull-right">
		            		&copy;2017 All Rights Reserved by Medicus
		          		</div>
		          		<div class="clearfix"></div>
		        	</footer>
		
				<@liferay_util["include"] page=body_bottom_include />
				
				<@liferay_util["include"] page=bottom_include />
				
				<!-- inject:js -->
				<!-- endinject -->
		
				 <script>
					    define._amd = define.amd;
					    define.amd = false;
				</script>
					
					<script src="${javascript_folder}/jquery.min.js"></script>
					<script src="${javascript_folder}/bootstrap.min.js"></script>
					<script src="${javascript_folder}/custom.js"></script>
					<script src="${javascript_folder}/dataTables.bootstrap.min.js"></script>
					<script src="${javascript_folder}/jquery.dataTables.min.js"></script>
					<script src="${javascript_folder}/jquery.easing.js"></script>
					<script src="${javascript_folder}/jquery.flexslider.js"></script>
					
					<script>
						define.amd = define._amd;
					</script>
			</div>
	</body>
</#if>
</html>