<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
  <%
if (session.getAttribute("userno") ==null||session.getAttribute("userno")=="")
{	
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%	}	//do nothing	
else
 {
 }
 %>
  </body>
</html>
