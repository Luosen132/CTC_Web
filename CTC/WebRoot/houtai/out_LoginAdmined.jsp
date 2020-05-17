<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
  <%
session.setAttribute("admin_name",null);

%>
<jsp:forward page="../adminLogin.jsp"></jsp:forward>

  </body>
</html>
