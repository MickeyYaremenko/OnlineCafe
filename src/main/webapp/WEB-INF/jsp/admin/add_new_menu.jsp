<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <script src='resources/js/jquery.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <script src='resources/js/client_account.js'></script>
    <title>Add new menu</title>
</head>
<body class="body-one">
<c:set var="page" value="add_menu" scope="session"/>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="wrapper">
    <div class="container-fluid">
        <form action="Controller" method="POST">

            <div class="row item-box-cart">

                <div class="col-lg-6 col-sm-12 item-info-cart">
                    <div class="col-lg-12 item-text-cart">
                        <select class="form-control" name="menu_language">
                            <option value="RU_RU"><fmt:message key="RU_RU"/></option>
                            <option value="EN_EN"><fmt:message key="EN_EN"/></option>
                        </select>
                    </div>
                </div>
                <div class="col-lg-6 col-sm-12 item-info-cart">
                    <div class="col-lg-12 item-text-cart">
                        <select class="form-control" name="menu_status">
                            <option value="IDLE"><fmt:message key="IDLE"/></option>
                            <option value="ACTIVE"><fmt:message key="ACTIVE"/></option>
                        </select>
                    </div>
                </div>
            </div>


            <div class="row">
                <button type="button" class="tablinks btn btn-md my-btn" onclick="openTab(event, 'Salad')">
                    <fmt:message key="salads"/></button>
                <button type="button" class="tablinks btn btn-md my-btn" onclick="openTab(event, 'Soup')">
                    <fmt:message key="soups"/></button>
                <button type="button" class="tablinks btn btn-md my-btn" onclick="openTab(event, 'Appetizier')">
                    <fmt:message key="appetiziers"/></button>
                <button type="button" class="tablinks btn btn-md my-btn" onclick="openTab(event, 'Hot')">
                    <fmt:message key="hot"/></button>
                <button type="button" class="tablinks btn btn-md my-btn" onclick="openTab(event, 'Dessert')">
                    <fmt:message key="desserts"/></button>
                <button type="button" class="tablinks btn btn-md my-btn" onclick="openTab(event, 'Drink')">
                    <fmt:message key="drinks"/></button>
            </div>
            <div class="my-row">
                <div id="Salad" class="tabcontent">
                    <c:forEach items="${salad}" var="item">
                        <div class="checkbox">
                            <label><input type="checkbox" name="item_id" value="${item.id}">
                                <c:out value="${item.title}"/></label>
                        </div>
                    </c:forEach>
                </div>
                <div id="Soup" class="table table-hover tabcontent">
                    <c:forEach items="${soup}" var="item">
                        <div class="checkbox">
                            <label><input type="checkbox" name="item_id" value="${item.id}">
                                <c:out value="${item.title}"/></label>
                        </div>
                    </c:forEach>
                </div>
                <div id="Appetizier" class="tabcontent table table-hover">
                    <c:forEach items="${appetizier}" var="item">
                        <div class="checkbox">
                            <label><input type="checkbox" name="item_id" value="${item.id}">
                                <c:out value="${item.title}"/></label>
                        </div>
                    </c:forEach>
                </div>
                <div id="Hot" class="tabcontent table table-hover">
                    <c:forEach items="${hot}" var="item">
                        <div class="checkbox">
                            <label><input type="checkbox" name="item_id" value="${item.id}">
                                <c:out value="${item.title}"/></label>
                        </div>
                    </c:forEach>
                </div>
                <div id="Dessert" class="tabcontent table table-hover">
                    <c:forEach items="${dessert}" var="item">
                        <div class="checkbox">
                            <label><input type="checkbox" name="item_id" value="${item.id}">
                                <c:out value="${item.title}"/></label>
                        </div>
                    </c:forEach>
                </div>
                <div id="Drink" class="tabcontent table table-hover">
                    <c:forEach items="${drink}" var="item">
                        <div class="checkbox">
                            <label><input type="checkbox" name="item_id" value="${item.id}">
                                <c:out value="${item.title}"/></label>
                        </div>
                    </c:forEach>
                </div>
            </div>

                <div class="col-sm-4 col-sm-push-7">
                    <button type="submit" class="btn btn-lg btn-block my-btn"
                            name="command" value="add_new_menu">
                        <span class="glyphicon glyphicon-plus"></span> <fmt:message key="add.new.menu"/></button>
                </div>

        </form>

        <form action="Controller" method="GET">
            <div class="col-sm-4 col-sm-pull-4 col-sm-offset-1">
                <button type="submit" class="btn btn-lg btn-block my-btn"
                        name="command" value="manage_menu">
                    <span class="glyphicon glyphicon-arrow-left"></span> <fmt:message key="back"/></button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
