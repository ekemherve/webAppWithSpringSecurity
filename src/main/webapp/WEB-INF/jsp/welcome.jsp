<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<%--<%@include file="include/importLinks.jsp.jsp"%>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>${welcome}</title>
</head>
<body>
    <div class="container">
        <div>
            <a href="${pageContext.request.contextPath}/home/login">Login</a> or
            <a href="${pageContext.request.contextPath}/home/register">SignUp</a>
        </div>
    </div>
</body>
</html>