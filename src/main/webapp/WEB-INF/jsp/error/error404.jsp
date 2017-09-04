<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/homepage.css' type='text/css' media='all'>
    <script src='resources/js/jquery.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <script src='resources/js/homepage.js'></script>
    <meta charset="UTF-8">
    <title>Error 404</title>
</head>
<body class="body-home">
<c:set var="page" value="error404" scope="session"/>

<div class="homepage-hero-module">
    <div class="video-container">
        <div class="title-container">
            <div class="headline">
                <img src="resources/images/Error%20404.png">
                <h1><fmt:message key="error.404.message"/>
                    <a href="Controller?command=open_main_page" class="my-a"> <fmt:message key="go.to.main.page"/></a>
                    <fmt:message key="or"/>
                    <a href="Controller?command=open_menu" class="my-a"> <fmt:message key="view.menu"/></a>.
                </h1>
            </div>
        </div>
        <div class="filter"></div>
        <video autoplay loop class="fillWidth">
            <source src="resources/video/Night-BBQ.mp4" type="video/mp4" />Your browser does not support the video tag. I suggest you upgrade your browser.
            <source src="resources/video/Night-BBQ.webm" type="video/webm" />Your browser does not support the video tag. I suggest you upgrade your browser.
        </video>
        <div class="poster hidden">
            <img src="resources/images/Night-BBQ.jpg" alt="">
        </div>
    </div>
</div>
</body>
</html>
