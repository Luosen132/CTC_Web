<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.xmlg.ctc.util.JDBCUtil"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'recoverUser.jsp' starting page</title>
    
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
     String u_no=request.getParameter("u_no");
     JDBCUtil util = new JDBCUtil();
   
      int result=util.update("update user set u_state='1' where u_no=?",u_no);//执行SQL语句
      if(result!=0){ 
      response.sendRedirect("black_menu.jsp");//执行插入成功跳转
 }

    %>
   
  </body>
</html>
