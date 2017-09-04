<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <script src='resources/js/jquery.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <title>Admin page</title>
</head>
<body class="body-one">
<c:set var="page" value="admin_page" scope="session"/>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div id="menu-container" class="container text-center">
    <div class="row">
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="manage_orders"/>
                    <input type="image" src="resources/images/order.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong><fmt:message key="orders"/></strong></p>
                <p class="item-hover"><strong><fmt:message key="view.orders"/></strong></p>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="manage_menu"/>
                    <input type="image" src="resources/images/menu.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong><fmt:message key="menu"/></strong></p>
                <p class="item-hover"><strong><fmt:message key="manage.menu"/></strong></p>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="manage_menu_items"/>
                    <input type="image" src="resources/images/Food-dish2.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong><fmt:message key="menu.items"/></strong></p>
                <p class="item-hover"><strong><fmt:message key="manage.menu.items"/></strong></p>
            </div>
        </div>
    </div>
</div>

</body>
</html>
