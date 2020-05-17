<%@ page language="java"
	pageEncoding="utf-8"%>
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
									管理员信息添加
								</h6>
							</div>
							<div class="body-nest" id="Footable">
								<div class="row" style="margin-bottom: 10px;">
									<div class="col-sm-12">



										<div class="col-xs-12 col-sm-4 text-center">
											
										</div>


										<div class="col-xs-12 col-sm-8 profile-name">
											<form id="contact-form" method="post" action="houtai/add_admin2.jsp"
												class="form-horizontal" >
												<fieldset>


													
													<div class="control-group">
														<label class="control-label" for="email">
															姓名
														</label>
														<div class="controls">
															<input type="text" style="width: 400px;"
																class="form-control round-input" name="name" id="name" required/>
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
																id="password" required />
														</div>
													</div>


												
													
													<div class="form-actions" style="margin: 20px 0 0 0;">
														<button type="submit" class="btn btn-default" >
															<span class="entypo-pencil"></span>添加
														</button>
														 &nbsp; &nbsp; &nbsp; &nbsp;
														<button type="reset" class="btn btn-default">
															<span class="entypo-pencil"></span>重置
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
