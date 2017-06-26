<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Bree+Serif"
          rel="stylesheet">
    <link rel='stylesheet' href='resources/css/bootstrap.css'
          type='text/css' media='all'>
    <title>Title</title>
    <style>
        .navbar {
            margin-bottom: 0;
        }

    </style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#myNavbar">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">Online Cafe</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${empty sessionScope.client.login}">
                        <li>
                        <form class="navbar-form form-inline pull-right" role="search"
                              action="Controller" method="POST">
                            <input type="hidden" value="sign_in_page" name="command" />
                            <button type="submit" class="btn btn-default">Sign In</button>
                        </form>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="Controller?command=open_client_acc">
                            <c:out value="${fn:toUpperCase(sessionScope.client.login)}"/></a></li>
                    </c:otherwise>
                </c:choose>
                <li><a href="index.html">Home</a></li>
                <li><a href="#places">Places</a></li>
                <li class="dropdown"><a class="dropdown-toggle"
                                        data-toggle="dropdown" href="#">Menu <span class="caret"></span>
                </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Salads</a></li>
                        <li><a href="#">Soups</a></li>
                        <li><a href="#">Appetizers</a></li>
                        <li><a href="#">Hot</a></li>
                        <li><a href="#">Deserts</a></li>
                        <li><a href="#">Drinks</a></li>
                    </ul></li>
            </ul>

        </div>
    </div>
</nav>
</body>
</html>
