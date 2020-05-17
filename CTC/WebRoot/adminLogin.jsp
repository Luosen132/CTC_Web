<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminLogin.jsp' starting page</title>
    
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
   	 		dotColor: '#ff9800',
    		lineColor: '#ff9800'
  			});
		});
	</script>
  </head>
  
  <body style="background-color: #ff980024;">
	<form action="AdminCheckYan" method="get">
	<dl class="admin_login">
	<dd>
 	</dd>
	
	<dt>
  		<strong>管理员登录</strong>
  		
	</dt>
 	<dd class="user_icon" >
  		<input type="text" required placeholder="管理员账号" class="login_txtbx" name="admin_name"/>
 	</dd>
 	<dd class="pwd_icon">
  		<input type="password" required placeholder="密码" class="login_txtbx" name="admin_password"/>
 	</dd>
 	<dd class="val_icon">
 	<div class="checkcode" style="width: 300px;">
    	<input type="text" placeholder="验证码" required maxlength="4" class="login_txtbx" name="check" style="height: 42px;width: 225px;"><img title="点击刷新" src="image.jsp" onclick="src='image.jsp?id='+Math.random();" style="height: 42px;width: 75px;">
    </div>
 	</dd>
 	<dd>
 		<input type="submit" value="登陆" class="submit_btn"/>
 	</dd>
 
	</dl>
	</form>
  </body>
</html>
