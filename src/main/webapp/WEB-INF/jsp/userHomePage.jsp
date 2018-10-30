<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<%@include file="include/importLinks.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>${myHome}</title>
</head>
<body>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Male</th>
            <th>Hobby</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${currentUser!=null}">
            <tr>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.male  ? "Boy" : "Girl"}</td>
                <td>${user.hobby}</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
</body>
</html>