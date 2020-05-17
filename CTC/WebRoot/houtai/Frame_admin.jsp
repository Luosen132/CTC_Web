<%@ page language="java"
	import="java.util.*,com.xmlg.ctc.util.*,com.xmlg.ctc.daoimpl.*,com.xmlg.ctc.dao.*,com.xmlg.ctc.entity.*,
	com.xmlg.ctc.service.*,com.xmlg.ctc.servlet.*"
	pageEncoding="utf-8"%>
	<%@ include file ="../LoginAdmined.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>管理员专区</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<link rel="stylesheet" href="assets/css/stylehome1.css">
		<link rel="stylesheet" href="assets/css/loader-style.css">
		<link rel="stylesheet" href="assets/css/bootstrap.css">

		<link rel="shortcut icon" href="assets/ico/minus.png">

		<style type="text/css">
canvas#canvas4 {
	position: relative;
	top: 20px;
}
</style>

		<script src="js/jquery.js"></script>

	</head>

	<body>
	
	<% String admin_name1 = (String)session.getAttribute("admin_name"); %>
		<!-- Preloader -->
		<div id="preloader">
			<div id="status">
				&nbsp;
			</div>
		</div>
		<!-- TOP NAVBAR -->
		<nav role="navigation" class="navbar navbar-static-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->


			<!-- Collect the nav links, forms, and other content for toggling -->
			<div id="bs-example-navbar-collapse-1"
				class="collapse navbar-collapse">

				<div id="nt-title-container"
					class="navbar-left running-text visible-lg">
					<ul class="date-top">
						<li class="entypo-calendar" style="margin-right: 5px"></li>
						<li id="Date"></li>


					</ul>

					<ul id="digital-clock" class="digital">
						<li class="entypo-clock" style="margin-right: 5px"></li>
						<li class="hour"></li>
						<li>
							:
						</li>
						<li class="min"></li>
						<li>
							:
						</li>
						<li class="sec"></li>
						<li class="meridiem"></li>
					</ul>
					<ul id="nt-title">
						<li>
							<i class="wi-day-lightning"></i>&#160;&#160;Berlin&#160;
							<b> </b><i class="wi-fahrenheit"></i>&#160;; 皇家理工
						</li>
						<li>
							<i class="wi-day-lightning"></i>&#160;&#160;Yogya&#160;
							<b></b><i class="wi-fahrenheit"></i>&#160;; 明理精工
						</li>


						<li>
							<i class="wi-day-lightning"></i>&#160;&#160;Frankurt&#160;
							<b> </b><i class="wi-fahrenheit"></i>&#160;; 与时偕行
						</li>

					</ul>
				</div>
				<!--用户头像-->
				<ul style="margin-right: 0;" class="nav navbar-nav navbar-right">
					<li>
						<a data-toggle="dropdown" class="dropdown-toggle" href="#"> Hi,
							<%=admin_name1%> <b class="caret"></b> </a>
						<ul style="margin-top: 14px;" role="menu"
							class="dropdown-setting dropdown-menu">
							
							<li>
								<a href="houtai/out_LoginAdmined.jsp">
									<span class="entypo-basket"></span>&#160;&#160; 退出登录</a>
							</li>
						</ul>
					</li>



				</ul>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
		</nav>

		<!-- /END OF TOP NAVBAR -->


		<div id="skin-select">
			<div id="logo">
				<h1>
					Admin
					<span>：<%=admin_name1 %></span>
				</h1>
			</div>

			<a id="toggle"> <span class="entypo-menu"></span> </a>
			<div class="search-hover">
				<form id="demo-2">
				</form>
			</div>



			<!-- SIDE MENU 菜单-->
			<div class="skin-part">
				<div id="tree-wrap">
					<div class="side-bar">



						<ul id="menu-showhide" class="topnav menu-left-nest">
							<li>
								<a href="#" style="border-left: 0px solid !important;"
									class="title-menu-left"> <span>信息管理区</span> <i
									data-toggle="tooltip" class="entypo-cog pull-right config-wrap"></i>

								</a>
							</li>


							<li>
								<a class="tooltip-tip" href="#" title="用户管理"> <i
									class="icon-monitor"></i> <span>用户管理</span> </a>
								<ul>
									<li>
										<a class="tooltip-tip2 ajax-load" href="houtai/user_menu.jsp" target="right"
											title="所有用户"><i class="icon-attachment"></i><span>所有用户</span>
										</a>
									</li>
									
									<li>
										<a class="tooltip-tip2 ajax-load" href="houtai/black_menu.jsp" target="right"
											title="黑名单"><i class="icon-menu"></i><span>黑名单</span> </a>
									</li>

								</ul>
							</li>
							<li>
								<a class="tooltip-tip" href="#" title="学术资料管理"> <i
									class="icon-document"></i> <span>学术资料管理</span> </a>
								<ul>
									<li>
										<a class="tooltip-tip2 ajax-load" href="houtai/Academic_no.jsp" target="right"
											title="Form Elements"><i class="icon-document-edit"></i><span>未审核的学术资料</span>
										</a>
									</li>
									<li>
										<a class="tooltip-tip2 ajax-load" href="houtai/Academic_yes.jsp" target="right"
											title="Andvance Form"><i class="icon-map"></i><span>已审核通过的学术资料</span>
										</a>
									</li>

								</ul>
							</li>
							<li>
								<a class="tooltip-tip" href="#" title="学生类"> <i
									class="icon-view-thumb"></i> <span>活动管理</span> </a>
								<ul>
									<li>
										<a class="tooltip-tip2 ajax-load" href="houtai/Activity_no.jsp" target="right"
											title="已审核通过的活动"><i class="entypo-layout"></i><span>未审核的活动</span>
										</a>
									</li>
									<li>
										<a class="tooltip-tip2 ajax-load" href="houtai/Activity_yes.jsp" target="right"
											title="未审核的活动"><i class="entypo-menu"></i><span>已审核通过的活动</span>
										</a>
									</li>
									
								</ul>
							</li>

							<li>
								<a class="tooltip-tip ajax-load" target="right" href="houtai/Notice_menu.jsp" title="通知"> <i
									class="icon-attachment"></i> <span>通知</span> </a>
							
							</li>
							<li>
								<a class="tooltip-tip2 ajax-load" href="#" title="管理员类"> <i
									class="icon-menu"></i> <span>管理员类</span> </a>
								<ul>
									<li>
										<a class="tooltip-tip2 ajax-load" target="right" href="houtai/Admin_menu.jsp"
											title="管理员基本信息"><i class="entypo-layout"></i><span>修改密码</span>
										</a>
									</li>
								</ul>
							</li>
						</ul>



					</div>
				</div>
			</div>
		</div>
		<!-- END OF SIDE MENU -->



		<!--  PAPER WRAP -->
		<div class="wrap-fluid">
			<div class="container-fluid paper-wrap bevel tlbr">





				<!-- CONTENT -->
				<!--TITLE标签 -->
				<div class="row">
					<div id="paper-top">
						<div class="col-lg-3">
							<h2 class="tittle-content-header">
								<i class="icon-window"></i>
								<span>Information </span>
							</h2>

						</div>

						<div class="col-lg-7">
							<div class="devider-vertical visible-lg"></div>
							<div class="tittle-middle-header">

								<div class="alert">
									<button type="button" class="close" data-dismiss="alert">
										×
									</button>
									<span class="tittle-alert entypo-info-circled"></span> Welcome
									back,&nbsp;
									<strong><% %>!</strong>&nbsp;&nbsp;Your last sig in at
									Yesterday, 16:54 PM
								</div>


							</div>

						</div>
						<div class="col-lg-2">
							<div class="devider-vertical visible-lg"></div>



						</div>
					</div>
				</div>
				<!--/ TITLE -->
<script type="text/javascript">
$(function(){
  $(".leftnav h2").click(function(){
	  $(this).next().slideToggle(200);	
	  $(this).toggleClass("on"); 
  })
  $(".leftnav ul li a").click(function(){
	    $("#a_leader_txt").text($(this).text());
  		$(".leftnav ul li a").removeClass("on");
		$(this).addClass("on");
  })
});
</script>

				<!-- BREADCRUMB 路径 -->
				
				<div class="admin">
  <iframe scrolling="auto" rameborder="0" name="right" width="100%" height="100%"></iframe>
	</div>

				
				
				
			</div>
		</div>






		<!-- /END OF CONTENT -->



		<!--  END OF PAPER WRAP -->

		<!--  天气 -->
		<script type="text/javascript" src="assets/js/jquery.js">
</script>
		<script src="assets/js/progress-bar/src/jquery.velocity.min.js">
</script>
		<script src="assets/js/progress-bar/number-pb.js">
</script>
		<script src="assets/js/progress-bar/progress-app.js">
</script>



		<!-- MAIN EFFECT -->
		<script type="text/javascript" src="assets/js/preloader.js">
</script>
		<script type="text/javascript" src="assets/js/bootstrap.js">
</script>
		<script type="text/javascript" src="assets/js/app.js">
</script>
		<script type="text/javascript" src="assets/js/load.js">
</script>
		<script type="text/javascript" src="assets/js/main.js">
</script>








		<div style="text-align: center;">
			<p>
				More Templates
				<a href="http://www.cssmoban.com/" target="_blank" title="模板之家">皇家理工</a>
				- Collect from
				<a href="http://www.cssmoban.com/" title="网页模板" target="_blank">班级管理</a>
			</p>

			<div id="placeholder" style="width: 1%; height: 1px;"></div>
		</div>
	</body>
</html>
