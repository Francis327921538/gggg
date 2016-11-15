<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>注册页面</title>
</head>
<body>
	<s:form action="user_login" method="post">
		<table width="60%" height="76" border="0">
			<s:textfield name="username" label="username"/>
			<s:textfield name="password" label="password"/>
			<s:submit value="提交" align="center"/>
		</table>
	</s:form>
	<table border=1>
	<s:iterator value="list" var="user">
		<tr>
			<td><s:property value="#user.username"/></td>
			<td><s:property value="#user.password"/></td>
		</tr>
	</s:iterator>
	</table>
	<span><s:property value="currPage"/>/<s:property value="totalPage"/></span><br>
	<span><s:property value="totalCount"/></span><br>
	<span>
		<s:if test = "currPage != 1">
			<a href="${pageContext.request.contextPath}/user_findAll.action?currPage=1">first</a>&nbsp;
			<a href="${pageContext.request.contextPath}/user_findAll.action?currPage=<s:property value='currPage-1'/>">pre</a>&nbsp;
		</s:if>
		
		<s:bean name="org.apache.struts2.util.Counter" id="counter">
            <s:param name="first" value="1" />
            <s:param name="last" value="totalPage" />
            <s:iterator status="st">
                <a href="${pageContext.request.contextPath}/user_findAll.action?currPage=<s:property/>"><s:property /> </a>
            </s:iterator>
        </s:bean>
		
		<s:if test = "currPage != totalPage">
			<a href="${pageContext.request.contextPath}/user_findAll.action?currPage=<s:property value='currPage+1'/>">next</a>&nbsp;
			<a href="${pageContext.request.contextPath}/user_findAll.action?currPage=<s:property value='totalPage'/>">last</a>&nbsp;
		</s:if>
	</span>
</body>
</html>