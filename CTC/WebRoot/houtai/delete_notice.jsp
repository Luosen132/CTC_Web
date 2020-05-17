<%@ page language="java" import="java.util.*,java.sql.Connection.*" pageEncoding="utf-8"%>
<%@ page import="com.xmlg.ctc.entity.Notice" %>
<%@ page import="com.xmlg.ctc.dao.NoticeDAO"%> 
<%@ page import="com.xmlg.ctc.daoimpl.NoticeDAOImpl"%>  
<%@ page import="com.xmlg.ctc.util.*"%>
<%@page import="java.sql.Connection"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'delete_notice.jsp' starting page</title>
    
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
			int id=Integer.parseInt(request.getParameter("not_id"));
			NoticeDAO noticeDAO = new NoticeDAOImpl();			
			boolean bool =  noticeDAO.delete(id);
			if(bool)
      	{
				out.print("<script> alert('删除成功！！'); location.href='houtai/Notice_menu.jsp';</script>"); 
         
 		}
      	else{
      		out.print("<script> alert('删除失败！！'); location.href='houtai/Notice_menu.jsp';</script>"); 
      	
      	}
 
  
  %>

  </body>
</html>
