<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.xmlg.ctc.dao.ActivityDAO"%>
<%@page import="com.xmlg.ctc.daoimpl.ActivityDAOImpl"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>删除活动</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     
     <%
          	request.setCharacterEncoding("utf-8");
                                   String act_id=request.getParameter("act_id");
                                   ActivityDAO dao = new ActivityDAOImpl(); 
                                 
                                    int result=dao.deleteActivity(act_id);
                                    if(result!=0){ 
                                    response.sendRedirect("Activity_no.jsp");
                               }
          %>
   
  </body>
</html>
