<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Bree+Serif" rel="stylesheet">
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <meta charset="UTF-8">
    <title>Online Cafe</title>
</head>

<body>
<c:set var="page" value="index" scope="session"/>
<%@ include file="WEB-INF/jsp/parts/navbar.jsp" %>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="resources/images/salad2.jpg" alt="Bike">
            <div class="carousel-caption">
                <h3>Bikes</h3>
                <p>We exactly know, you like mountain rides or calm cityrides</p>
            </div>
        </div>

        <div class="item">
            <img src="resources/images/kebab.jpg" alt="Board">
            <div class="carousel-caption">
                <h3>Boards</h3>
                <p>Or may be you prefer balancing? Then boards are your choice!</p>
            </div>
        </div>

        <div class="item">
            <img src="resources/images/meat.jpg" alt="Rollers">
            <div class="carousel-caption">
                <h3>Rollers</h3>
                <p>IDK</p>
            </div>
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button"
       data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
                                aria-hidden="true"></span> <span class="sr-only">Previous</span>
    </a> <a class="right carousel-control" href="#myCarousel" role="button"
            data-slide="next"> <span
        class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
</a>
</div>

</body>
</html>
