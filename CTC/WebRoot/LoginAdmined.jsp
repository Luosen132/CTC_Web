<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
  <%
if (session.getAttribute("admin_name") ==null||session.getAttribute("admin_name")=="")
{	
%>
<jsp:forward page="../adminLogin.jsp"></jsp:forward>
<%	}	//do nothing	
else
 {
 }
 %>
  </body>
</html>
