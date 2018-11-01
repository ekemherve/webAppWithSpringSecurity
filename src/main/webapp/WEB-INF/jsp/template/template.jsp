<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ include file="../include/importTags.jsp"%>
<%@ include file="../include/importLinks.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
    <title>Template</title>
    <link type="text/css" href="<spring:url value='/css/webApp.css'/>" rel="stylesheet" />
</head>
<body>
<div class="header">
    <a href="#default" class="logo">CompanyLogo</a>
    <div class="header-right">
        <a class="active" href="${pageContext.request.contextPath}/home">Home</a>
        <!--<a  href="$"{pageContext.request.contextPath}/home">Home</a>-->
        <a href="#contact">Contact</a>
        <a href="#about">About</a>
    </div>
</div>
<div>
    <tiles:insertAttribute name="main-content"/>
</div>
<div>
    <img src="<spring:url value="/images/squallMini.png"/>"/>
</div>
<div class="footer">
    <p class="copyright">Copyright @ 2018-2020 Web Application. All rights reserved.</p>
    <p class="site">Website developped by Herve</p>
</div>

</body>
</html>