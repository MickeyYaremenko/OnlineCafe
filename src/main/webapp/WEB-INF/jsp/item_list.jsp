<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Bree+Serif" rel="stylesheet">
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/spinner.css' type='text/css' media='all'>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <script src='resources/js/spinner.js'></script>
    <title>Choose an item</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

    <div class="container" id="item-list-container">
        <form action="Controller" method="POST">
        <ul class="list-group">
            <c:forEach items="${menuItemList}" var="item">
                <input type="hidden" name="item" value="${item.title}">
                <li class="list-group-item">
                    <h4 class="list-group-item-heading">
                        <b><c:out value="${item.title}" /></b>
                    </h4>
                    <p class="list-group-item-text">
                            <c:out value="${item.description}" />
                    </p>
                    <div class="input-group number-spinner">
                        <span class="input-group-btn data-dwn">
                            <button type="button" class="btn btn-default btn-info" data-dir="dwn">
                            <span class="glyphicon glyphicon-minus"></span>
                            </button>
                        </span>
                        <input type="text" class="form-control text-center" name="quant" value="0" min="0" max="40">
                        <span class="input-group-btn data-up">
                            <button type="button" class="btn btn-default btn-info" data-dir="up">
                            <span class="glyphicon glyphicon-plus"></span>
                            </button>
                        </span>
                    </div>
                </li>
            </c:forEach>

        </ul>

            <input type="hidden" name="command" value="add_to_order" />
            <div class="col-sm-4 col-sm-push-7">
                <button type="submit" class="btn btn-default btn-lg btn-block"
                        name="command" value="add_to_order">
                    <span class="glyphicon glyphicon-shopping-cart"></span>
                    Add to an order!
                </button>
            </div>
        </form>
        <form action="Controller" method="GET">
            <input type="hidden" name="command" value="open_menu" />
            <div class="col-sm-4 col-sm-pull-4 col-sm-offset-1">
            <button type="submit" class="btn btn-default btn-lg btn-block"
                    name="command" value="open_menu">
                <span class="glyphicon glyphicon-arrow-left"></span>
                Back to menu
            </button>
            </div>
        </form>
    </div>

</body>
</html>
