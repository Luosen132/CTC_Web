<%@ page language="java"
	pageEncoding="utf-8"%>
<%@page import="com.xmlg.ctc.entity.Admin"%>
<%@page import="com.xmlg.ctc.dao.AdminDAO"%>
<%@page import="com.xmlg.ctc.daoimpl.AdminDAOImpl"%>
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
		

		


	<%  
    	request.setCharacterEncoding("utf-8");
    	int admin_no=Integer.parseInt(request.getParameter("adminNo"));
    	AdminDAO adminDAO =new AdminDAOImpl();
      	boolean bool = adminDAO.deleteadmin(admin_no);
      	if(bool)
      	{
 			response.sendRedirect("Admin_menu.jsp");
 		}
      

 %>




		
	</body>
</html>
