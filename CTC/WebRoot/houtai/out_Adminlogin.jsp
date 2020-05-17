<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
		<meta charset="utf-8"/>
	<meta name="author" content="DeathGhost" />
		<link rel="stylesheet" type="text/css" href="css/style.css" tppabs="css/style.css" />
	<style>
		body{height:100%;background:#16a085;overflow:hidden;}
		canvas{z-index:-1;position:absolute;}
	</style>
	
<script src="js/jquery1.js"></script>
	<script src="js/verificationNumbers.js" tppabs="js/verificationNumbers.js"></script>
	<script src="js/Particleground.js" tppabs="js/Particleground.js"></script>
	<script>
		$(document).ready(function() {
			//粒子背景特效
  			$('body').particleground({
   	 		dotColor: '#f1d653cc',
    		lineColor: '#f1d653cc'
  			});
  	
  			//验证码
  			createCode();
  		
  			//测试提交，对接程序删除即可
  			$(".submit_btn").click(function(){
			  	location.href="index.jsp"/*tpa=http://***index.html*/;
			});
		});
	</script>
	
  </head>
  
  <body style="
    background-color: #000000f2;
">
    
    <dl class="admin_login">
    <dt>
  		<strong>请选择登录方式</strong>
  		
	</dt>

	<dd><br></dd>
	
  	<dd>
  		<form action="userLogin.jsp">
 			<input type="submit" value="用户" class="submit_btn"/>
 		</form>
 	</dd>
 	
 	<dd><br></dd>
 	
  	<dd>
  		<form action="adminLogin.jsp">
 			<input type="submit" value="管理员" class="submit_btn"/>
 		</form>
 	</dd>
 	</dl>
 	
	
  </body>
</html>
