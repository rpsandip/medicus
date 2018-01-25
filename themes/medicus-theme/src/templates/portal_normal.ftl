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
  	 <link rel="stylesheet" href="${css_folder}/animate.min.css">
  	 <link rel="stylesheet" href="${css_folder}/dataTables.bootstrap.min.css">
  	 <link rel="stylesheet" href="${css_folder}/flexslider.css">
  	 <link rel="stylesheet" href="${css_folder}/bootstrap-datetimepicker.css">
  	 <link rel="stylesheet" href="${css_folder}/green.css">
  	 <link rel="stylesheet" href="${css_folder}/nprogress.css">
  	 <link rel="stylesheet" href="${css_folder}/medicus_custom.css">
  	 <link rel="stylesheet" href="${css_folder}/newtheme.css">
  	 
  	 
  	     <script>
		   		 define._amd = define.amd;
		    	define.amd = false;
			</script>
		
					<script src="${javascript_folder}/jquery.min.js"></script>
					<script src="${javascript_folder}/bootstrap.min.js"></script>
					<script src="${javascript_folder}/moment.min.js"></script>
					<script src="${javascript_folder}/jquery.dataTables.min.js"></script>
					<script src="${javascript_folder}/jquery.easing.js"></script>
					<script src="${javascript_folder}/jquery.flexslider.js"></script>
					<script src="${javascript_folder}/dataTables.bootstrap.min.js"></script>
					<script src="${javascript_folder}/bootstrap-datetimepicker.min.js"></script>
					<script src="${javascript_folder}/Chart.min.js"></script>
					<script src="${javascript_folder}/icheck.min.js"></script>
					<script src="${javascript_folder}/jquery.smartWizard.js"></script>
					<script src="${javascript_folder}/nprogress.js"></script>
					<script src="${javascript_folder}/jquery.formatter.js"></script>
			<script>
						define.amd = define._amd;
			</script>
  	
</head>
 <#if !is_signed_in>
	 
 <#else>
 	<#assign medicusCommonService = serviceLocator.findService("com.medicus.common.service.service.MedicusCommonLocalService")>
	<#assign userInfo=medicusCommonService.getLoginUserInfo(user_id) >
	
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
		              <a href="/group/medicus" class="site_title"><span>Medicus Group LLC</span></a>
		            </div>
		
		            <div class="clearfix"></div>
		
		            <!-- menu profile quick info -->
		            <div class="profile clearfix">
		              <div class="profile_pic">
		              	<#assign profilePic = user.getPortraitURL(theme_display) />
		                <img src="${profilePic}" alt="..." class="img-circle profile_img">
		              </div>
		              <div class="profile_info">
		                <span>Welcome</span>
		                <h2>${user.getFirstName()} 
		                <#if user.getLastName() != "~">
		                	${user.getLastName()}</h2>
		                </#if>	
		              </div>
		              <div class="profile_info">
		                <h2><a href="/c/portal/logout" style="color:#E7E7E7;">Logout</a></h2>
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
								<a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem">
									<#if nav_item.getLayout().getFriendlyURL()=='/dashboard'>
										<i class="fa fa-fw fa-home"></i> ${nav_item.getName()}
									<#elseif nav_item.getLayout().getFriendlyURL()=='/schools'>
										<i class="fa fa-fw fa-graduation-cap"></i> ${nav_item.getName()}
									<#elseif nav_item.getLayout().getFriendlyURL()=='/campuses'>
										<i class="fa fa-fw fa-institution"></i> ${nav_item.getName()}
									<#elseif nav_item.getLayout().getFriendlyURL()=='/users'>
										<i class="fa fa-fw fa-group"></i> ${nav_item.getName()}
									<#elseif nav_item.getLayout().getFriendlyURL()=='/partners'>
										<i class="fa fa-fw fa-american-sign-language-interpreting"></i> ${nav_item.getName()}
									<#elseif nav_item.getLayout().getFriendlyURL()=='/employer'>
										<i class="fa fa-fw fa-trello"></i> ${nav_item.getName()}
									<#elseif nav_item.getLayout().getFriendlyURL()=='/student'>
										<i class="fa fa-fw fa-group"></i> ${nav_item.getName()}
									<#elseif nav_item.getLayout().getFriendlyURL()=='/interview-request'>
										<i class="fa fa-fw fa-question"></i> ${nav_item.getName()}
									<#elseif nav_item.getLayout().getFriendlyURL()=='/report'>
										<i class="fa fa-fw fa-table"></i> ${nav_item.getName()}
									<#elseif nav_item.getLayout().getFriendlyURL()=='/graph'>
										<i class="fa fa-fw fa-bar-chart"></i> ${nav_item.getName()}
									<#elseif nav_item.getLayout().getFriendlyURL()=='/profile'>
										<i class="fa fa-fw fa-user-md"></i> ${nav_item.getName()}
									<#elseif nav_item.getLayout().getFriendlyURL()=='/subscription'>
										<i class="fa fa-fw fa-object-group"></i> ${nav_item.getName()}
									<#else>	
										${nav_item.getName()}
									</#if>
								</a>
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
			            </nav>
			            <div style="padding-top:5px;">
			            	<h4>${userInfo}</h4>
			            </div>
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
		            		&copy;2018 All Rights Reserved by Medicus
		          		</div>
		          		<div class="clearfix"></div>
		        	</footer>
		
				<@liferay_util["include"] page=body_bottom_include />
				
				<@liferay_util["include"] page=bottom_include />
				
				<script>
		   		   define._amd = define.amd;
		        	define.amd = false;
			    </script>
		
					<script src="${javascript_folder}/jquery.min.js"></script>
					<script src="${javascript_folder}/bootstrap.min.js"></script>
					<script src="${javascript_folder}/moment.min.js"></script>
					<script src="${javascript_folder}/jquery.dataTables.min.js"></script>
					<script src="${javascript_folder}/jquery.easing.js"></script>
					<script src="${javascript_folder}/jquery.flexslider.js"></script>
					<script src="${javascript_folder}/dataTables.bootstrap.min.js"></script>
					<script src="${javascript_folder}/bootstrap-datetimepicker.min.js"></script>
					<script src="${javascript_folder}/common.js"></script>
			<script>
						define.amd = define._amd;
			</script>
				
				<!-- inject:js -->
				<!-- endinject -->
		
			</div>
	</body>
</#if>
</html>