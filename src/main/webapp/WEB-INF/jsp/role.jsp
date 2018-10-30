<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<%@include file="include/importLinks.jsp"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>${roleData}</title>
</head>
<body>
<form:form id="form" method="POST"
           action="/webApp/roles/send" modelAttribute="currentUserRoles">

    <form:label path="roleEnum">Role</form:label>
    <form:select path="roleEnum">
        <form:options items="${roles}" itemValue="name" id="name"></form:options>
    </form:select>
    <input type="submit" value="send"/>
</form:form>
<p><a href="${pageContext.request.contextPath}/roles">Voir tous les utilisateurs</a></p>
</body>
</html>