<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@include file="include/importTags.jsp"%>--%>
<%--<%@include file="include/importLinks.jsp.jsp"%>--%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>${welcome}</title>
</head>
<body>
    <div class="container">
        <div>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/home/login"><span class="fa fa-sign-in">Login</span></a> or
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/home/register"><span class="fa fa-sign-in">SignUp</span></a>
        </div>
    </div>
</body>
</html>