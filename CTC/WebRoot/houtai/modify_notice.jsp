<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.xmlg.ctc.entity.Notice" %>
<%@ page import="com.xmlg.ctc.dao.NoticeDAO"%> 
<%@ page import="com.xmlg.ctc.daoimpl.NoticeDAOImpl"%>  
<%@ page import="com.xmlg.ctc.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'modify_notice.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
									通知信息修改
								</h6>
							</div>
							<div class="body-nest" id="Footable">
								<div class="row" style="margin-bottom: 10px;">
									<div class="col-sm-12">

						<%
						request.setCharacterEncoding("utf-8");
  						int selectid=Integer.parseInt(request.getParameter("not_id"));	
							 NoticeDAOImpl noticeDAO1=new NoticeDAOImpl();
											List<Notice> list=noticeDAO1.getAllItems(selectid);
											 if(list!=null&&list.size()>0)
            {
	        	for(int i=0;i<list.size();i++)
	        	{
	            	Notice item = list.get(i);
										
						  %>

										

										<div class="col-xs-12 col-sm-8 profile-name">
											<form action="houtai/modify_notice2.jsp" method="post" id="contact-form"
												class="form-horizontal" >
												<fieldset>


													<div class="control-group">
														<label class="control-label" for="name">
															编号
														</label>
														<div class="controls">
															<input type="text" style="width: 400px;"
																class="form-control round-input" name="id" id="id" value="<%=item.getNot_id()%>" readonly>
																
														</div>
													</div>
													<div class="control-group">
														<label class="control-label" for="email">
															通知标题
														</label>
														<div class="controls">
															<input type="text" style="width: 400px;"
																class="form-control round-input" name="title" id="title" required value="<%=item.getNot_title()%>" >
														</div>
													</div>

													<div class="control-group">
														<label class="control-label" for="name">
															通知内容
														</label>
														<div class="controls">
															<input type="text" style="width: 400px;"
																class="form-control round-input" name="content"
																id="password "  value="<%=item.getNot_content()%>" />
														</div>
													</div>

													<div class="control-group">
														<label class="control-label" for="name">
															通知时间
														</label>
														<div class="controls">
															<input type="text" style="width: 400px;"
																required class="form-control round-input" name="time" id="time"  value="<%=item.getNot_time()%>" onchange="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}" >
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
											
												<%
              } 
              }
          	%>
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
