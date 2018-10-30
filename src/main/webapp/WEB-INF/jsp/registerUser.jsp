<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="include/importTags.jsp"%>
<%@include file="include/importLinks.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>${registration}</title>
</head>
<body>
<div class="container">
    <form:form id="form" method="POST"
               action="/webApp/home/signup" modelAttribute="currentUser">

        <form:label path="name">Name</form:label>
        <form:input path="name"/>
        <form:errors path="name"></form:errors>

        <form:label path="age">Age</form:label>
        <form:input path="age"/>

        <form:radiobutton path="male" value="true"/>Boy
        <form:radiobutton path="male" value="false"/>Girl

        <form:label path="hobby">Hobby</form:label>
        <form:select path="hobby">
            <form:options items="${hobbies}" itemValue="name" itemLabel="name" />
        </form:select>


        <input type="submit" value="send"/>

    </form:form>

    <!--<a href="createBankAccount">Ajouter compte bancaire</a>-->

        <div>
            <p>
                Desirez Vous Ajouter un nouveau compte ? <a  href="${pageContext.request.contextPath}/createBankAccount">Cliquez Içi</a>
            </p>
        </div>



        <div>
            <p>
                Veuillez Ajouter un nouveau role ? <a  href="${pageContext.request.contextPath}/roles">Cliquez Içi</a>
            </p>
        </div>

</div>
</body>
</html>
</div>
</body>
</html>