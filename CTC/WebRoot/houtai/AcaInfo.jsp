<%@ page language="java"
	import="java.util.*,com.xmlg.ctc.util.*,com.xmlg.ctc.daoimpl.*,com.xmlg.ctc.dao.*,com.xmlg.ctc.entity.*,
	com.xmlg.ctc.service.*,com.xmlg.ctc.servlet.*"
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
									学术资料详情 
								</h6>
							</div>
							
							<%
									request.setCharacterEncoding("utf-8");
									int Ac_id =Integer.parseInt(request.getParameter("Ac_id"));
									AcademicDAO academicDAO = new AcademicDAOImpl();
									Academic academic = academicDAO.findAcademicById(Ac_id);
									UserDAO userDAO = new UserDAOImpl();
									User user = userDAO.findUserById(academic.getAc_no()); 
									String school_name =  (userDAO.SchoolSearchById(user.getUSchool()).get(0)).getSchName();
									String college_name = (userDAO.CollegeSearchById(user.getUCollege()).get(0)).getColName();
									
							 %>
							<div class="body-nest" id="Footable">
								<div class="row" style="margin-bottom: 10px;">
									<div class="col-sm-12">

							<div class="col-xs-12 col-sm-4 text-center" width="300" >

                                    <ul class="list-group">
                                        <li class="list-group-item text-left">
                                             <div class="form-group">
                                            <label >上传者资料</label></div></li>
                                        <li class="list-group-item text-center">
                                            <img src="upload/<%=user.getUPicture()%>"  width="200" height="200" alt="" class="img-circle img-responsive img-profile">

                                        </li>
                                        
                                        <li class="list-group-item text-right">
                                            <span class="pull-left">
                                                <strong>上传者学号</strong>
                                            </span><%=user.getUNo() %></li>
                                        <li class="list-group-item text-right">
                                            <span class="pull-left">
                                                <strong>上传者昵称（真实姓名）</strong>
                                            </span><%=user.getUName() %>(<%=user.getURealname()%>)</li>
                                        <li class="list-group-item text-right">
                                            <span class="pull-left">
                                                <strong>所在院校</strong>
                                            </span><%=school_name %>-<%=college_name%></li>

                                    </ul>

                                </div>
<div class="col-xs-12 col-sm-8 profile-name">
                                    <h3>
                                        <span class="pull-right social-profile">
                                            <i class="entypo-facebook-circled"></i>  <i class="entypo-twitter-circled"></i>  <i class="entypo-linkedin-circled"></i>  <i class="entypo-github-circled"></i>  <i class="entypo-gplus-circled"></i>
                                        </span>
                                    </h3>
                                    <div class="content-wrap">
                <div class="row">
                    <div class="col-sm-12">
                        <div class="nest" id="elementClose">
                           

                            <div class="body-nest" id="element">

                                <div class="panel-body">
                                    <form method="get" class="form-horizontal bucket-form">
                                        <div class="form-group">
                                            <label >学术资料编号</label></div>
                                            <div class="col-sm-6">
                                                <input class="form-control" type="text" disabled="" value="<%=academic.getAc_id() %>">
                                        </div>
                                        <br/><br/>
                                        <div class="form-group">
                                            <label >上传时间</label></div>
                                            <div class="col-sm-6">
                                                <input class="form-control" type="text" disabled="" value="<%=academic.getAcDate() %>">
                                        </div>
                                        <br/><br/>
                                        <div class="form-group">
                                            <label >学术标题</label></div>
                                            <div class="col-sm-6">
                                                <input class="form-control" type="text" disabled="" value="<%=academic.getAcHeadline() %>">
                                        </div>
                                        <br/><br/>
                                        <div class="form-group">
                                            <label >学术资料内容</label></div>	
                                            <div class="col-sm-6">
                                                 <textarea rows="5" cols="40" name="describe" style="resize:none;overflow:scroll;width:400px;height:200px;" 
                                                 disabled="" ><%=academic.getAcContent()%></textarea><br/>
                                        
                                         <%if(!academic.getAcFile().equals("/null")){%>
        <ul class="text" >
        <a href="http://localhost:8080/CTC/upload/<%=academic.getAcFile() %>">
        <%=academic.getAcFile() %>点击查看或下载附件</a>
        
        </ul>
        
        
       <% }%> </div>
                                    </form>
                                </div>

                            </div>

                        </div>
                    </div>
                </div>
            </div>

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
