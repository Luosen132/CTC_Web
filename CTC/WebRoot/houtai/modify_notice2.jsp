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
    
    <title>My JSP 'modify_notice2.jsp' starting page</title>
    
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
    	    int id =Integer.parseInt(request.getParameter("id"));
    	    String title=request.getParameter("title"); 
			String content=request.getParameter("content");
			String time=request.getParameter("time");	
    	
    	    NoticeDAO noticeDAO = new NoticeDAOImpl();
			Notice notice = new  Notice(id,title,content,time);
    	boolean bool =noticeDAO.modifyNotice(notice);
 			if(bool)	
 				{
 				out.print("<script> alert('修改成功'); location.href='houtai/Notice_menu.jsp';</script>"); 
 			}else{
 				out.print("<script> alert('修改失败'); location.href='houtai/Notice_menu.jsp';</script>"); 
			}
    %>
  </body>
</html>
