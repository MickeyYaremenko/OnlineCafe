<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Bree+Serif" rel="stylesheet">
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <title>Choose an item</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>
<form action="Controller" method="POST">
    <div class="container">
        <ul class="list-group">
            <c:forEach items="${menuItemList}" var="item">
                <li class="list-group-item">
                    <h4 class="list-group-item-heading">
                        <b><c:out value="${item.title}" /></b>
                    </h4>
                    <p class="list-group-item-text">
                            <c:out value="${item.description}" />
                    </p>
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name="items"	value="${item.title}">
                            I want this!
                        </label>
                    </div>
                </li>
            </c:forEach>

        </ul>

        <div class="row">

            <input type="hidden" name="action" value="add_items" />
            <div class="col-sm-10 col-sm-offset-1">
                <button type="submit" class="btn btn-default btn-lg btn-block"
                        name="action" value="add_items">
                    <span class="glyphicon glyphicon-shopping-cart"></span> Continue
                    to a cart!
                </button>
            </div>

        </div>

    </div>
</form>
</body>
</html>
