<%@ page language="java"

	pageEncoding="utf-8"%>
<%@page import="com.xmlg.ctc.dao.AdminDAO"%>
<%@page import="com.xmlg.ctc.daoimpl.AdminDAOImpl"%>
<%@page import="com.xmlg.ctc.entity.Admin"%>
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

		<link rel="stylesheet" href="assets/css/style.css">
	
		<link rel="stylesheet" href="assets/css/bootstrap.css">



	</head>

	<body>
		

		


		
		
		<div class="content-wrap">
					<div class="row">
					<div class="col-sm-12">
						<div class="nest" id="validationClose">
							<div class="title-alt">
								<h6>
									管理员信息修改
								</h6>
							</div>
							<div class="body-nest" id="Footable">
								<div class="row" style="margin-bottom: 10px;">
									<div class="col-sm-12">

						<%
						request.setCharacterEncoding("utf-8");
  						int selectid=Integer.parseInt(request.getParameter("adminNo"));	
  						AdminDAO aDao = new AdminDAOImpl();
				
  						Admin admin =aDao.admin_preson(selectid);
            			
						
						
						
						  %>

										
										


										<div class="col-xs-12 col-sm-8 profile-name">
											<form action="houtai/modify_admin2.jsp" method="post" id="contact-form"
												class="form-horizontal" >
												<fieldset>


													<div class="control-group">
														<label class="control-label" for="name">
															编号
														</label>
														<div class="controls">
															<input type="text" style="width: 400px;"
																class="form-control round-input" name="no" id="no" value="<%=admin.getAdId()%>" readonly>
																
														</div>
													</div>
													<div class="control-group">
														<label class="control-label" for="email">
															姓名
														</label>
														<div class="controls">
															<input type="text" style="width: 400px;"
																class="form-control round-input" name="name" id="name" required value="<%=admin.getAdminName()%>" >
														</div>
													</div>
													

													<p style="margin: 10px 0 5px"></p>
												

													<div class="control-group">
														<label class="control-label" for="name">
															密码
														</label>
														<div class="controls">
															<input type="text" style="width: 400px;"
																class="form-control round-input" name="password"
																id="password "  value="<%=admin.getAdminPassword()%>" />
														</div>
													</div>

													
													<p style="margin: 10px 0 5px"></p>
													
													
													<div class="form-actions" style="margin: 20px 0 0 0;">
														<button type="submit" class="btn btn-default" >
															<span class="entypo-pencil"></span>确认修改
														</button>
													
													</div>
												</fieldset>
											</form>
										</div>
									</div>
								</div>

							</div>



						</div>
					</div>
				</div>
				</div>



		<!-- /END OF CONTENT -->



		<!--  END OF PAPER WRAP -->









		
	</body>
</html>
