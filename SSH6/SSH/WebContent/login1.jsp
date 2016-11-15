<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<link href="${pageContext.request.contextPath}/css/login.css" type="text/css" rel="stylesheet"> 
</head>
<body>
<div class="login">
    <div class="message">管理登录</div>
    <div id="darkbannerwrap"></div>
    <form action="admin_login" method="post">
		<!-- <input name="action" value="login" type="hidden"> -->
		<input name="admin.username" placeholder="username..." required="" type="text">
		<hr class="hr15">
		<input name="admin.password" placeholder="password..." required="" type="password">
		<hr class="hr15">
		<input value="登录" style="width:100%;" type="submit" />
		<hr class="hr20">
		<!-- 帮助 <a onClick="alert('请联系管理员')">忘记密码</a> -->
	</form>

	
</div>

<!-- <div class="copyright">© 2016品牌名称 by <a href="http://www.mycodes.net/" target="_blank">源码之家</a></div> -->

</body>
</html>