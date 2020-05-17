<%@ page language="java"
	import="java.util.*,com.xmlg.ctc.dao.*,com.xmlg.ctc.util.*,com.xmlg.ctc.daoimpl.*,com.xmlg.ctc.entity.*,java.util.Date,java.text.SimpleDateFormat"
	pageEncoding="utf-8" session="true"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>添加通知</title>

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
		<>

		<div class="content-wrap">
			<div class="row">
				<div class="col-sm-12">

					<div class="nest" id="FootableClose">
						<div class="title-alt">
							<h6>
								通知信息
							</h6>
						</div>

						<div class="body-nest" id="Footable">
							<div class="row" style="margin-bottom: 10px;">

								<div class="col-sm-12">

									<div class="col-xs-12 col-sm-4 text-center">
										<ul class="list-group">
											<li class="list-group-item text-left">
												<font face="04b_21"><span class="entypo-user"></span>&nbsp;&nbsp;制度信息添加</font>
											</li>

										</ul>
									</div>


									<div class="col-xs-12 col-sm-8 profile-name">
										<form action="houtai/add_notice2.jsp" id="contact-form"
											class="form-horizontal" method="post" >
											<fieldset>

												
												<div class="control-group">
													<label class="control-label" for="no">
														通知标题
													</label>
													<div class="controls">
														<input type="text" class="form-control " name="title"
															style="width:400px;" id="title"  >
													</div>
												</div>
												
												<div class="control-group">
													<label class="control-label" for="describe">内容</label>
													<div class="controls">
														<textarea name="content" id="content"   style="resize:none;overflow:scroll;width:400px;height:100px;" ></textarea>
													</div>
												</div>
												
												<div class="control-group">
													<label class="control-label" for="no">
														发布时间
													</label>
													<div class="controls">
														<input type="text" class="form-control " name="time"
															style="width:400px;" id="time" value="<%Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:MM");
			String time = format.format(date);
			out.println(format.format(new Date()));%>  ">
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
