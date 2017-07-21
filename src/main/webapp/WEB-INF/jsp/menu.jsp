<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <script src='resources/js/jquery.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <title>Menu</title>
</head>
<body class="body-one">
<c:set var="page" value="menu" scope="session"/>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div id="menu-container" class="container text-center">
    <div class="row">
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="choose_category"/>
                    <input type="hidden" name="category" value="salad"/>
                    <input type="image" src="resources/images/Salad-menu.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong><fmt:message key="salads"/></strong></p>
                <p class="item-hover"><strong><fmt:message key="pick.salads"/></strong></p>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="choose_category"/>
                    <input type="hidden" name="category" value="soup"/>
                    <input type="image" src="resources/images/Soup-menu.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong><fmt:message key="soups"/></strong></p>
                <p class="item-hover"><strong><fmt:message key="pick.soups"/></strong></p>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="choose_category"/>
                    <input type="hidden" name="category" value="appetizer"/>
                    <input type="image" src="resources/images/Sandwich-menu.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong><fmt:message key="appetiziers"/></strong></p>
                <p class="item-hover"><strong><fmt:message key="pick.appetiziers"/></strong></p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="choose_category"/>
                    <input type="hidden" name="category" value="hot"/>
                    <input type="image" src="resources/images/Hot-menu.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong><fmt:message key="hot"/></strong></p>
                <p class="item-hover"><strong><fmt:message key="pick.hot"/></strong></p>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="choose_category"/>
                    <input type="hidden" name="category" value="dessert"/>
                    <input type="image" src="resources/images/Cake-menu.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong><fmt:message key="desserts"/></strong></p>
                <p class="item-hover"><strong><fmt:message key="pick.desserts"/></strong></p>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="choose_category"/>
                    <input type="hidden" name="category" value="drink"/>
                    <input type="image" src="resources/images/Drinks-menu.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong><fmt:message key="drinks"/></strong></p>
                <p class="item-hover"><strong><fmt:message key="pick.drinks"/></strong></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
