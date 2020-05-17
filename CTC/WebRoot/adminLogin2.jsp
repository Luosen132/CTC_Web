<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>My JSP 'adminLogin2.jsp' starting page</title>
    
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
    	
    	String adname=request.getParameter("admin_name");
    	String adpassword=request.getParameter("admin_password");
    	
    	AdminDAO adminDAO=new AdminDAOImpl();
    	Admin admin=adminDAO.getAdmins(adname,adpassword);
    	
    	if(admin.getAdminName()!=null){
    		session.setAttribute("admin_name",adname);
    		session.setAttribute("admin_password",adpassword);
    		response.sendRedirect("houtai/Frame_admin.jsp");
    	}else{%>
    		管理员姓名或密码错误，导致登录失败，等待3秒后重新登录。
    	<%
  			response.setHeader("Refresh","3;URL=adminLogin.jsp");
   		%>
    	<%
    	}
    %>
  </body>
</html>
