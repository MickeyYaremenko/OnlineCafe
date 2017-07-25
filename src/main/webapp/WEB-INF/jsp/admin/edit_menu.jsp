<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <script src='resources/js/jquery.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <script src='resources/js/client_account.js'></script>
    <title>Edit menu</title>
</head>
<body class="body-one">
<c:set var="page" value="edit_menu" scope="session"/>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="wrapper">
    <div class="container-fluid">
        <form action="Controller" method="POST">
                <div class="row item-box-cart">
                    <div class="col-lg-1 col-md-2 item-info-cart">
                        <div class="col-lg-12 item-text-cart">
                            <input type="hidden" name="menu_id" value="${menu.id}">
                            <p><c:out value="${menu.id}" /></p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-10 item-info-cart">
                        <div class="col-lg-12 item-text-cart">
                            <p><c:out value="${menu.creationTime}"/></p></div>
                    </div>
                    <div class="col-lg-4 col-md-6 item-info-cart">
                        <div class="col-lg-12 item-text-cart">
                            <select class="form-control" name="menu_language">
                                <option value="RU_RU" ${menu.menuLanguage.toString().equals("RU_RU")?"selected":""}>
                                    RU_RU</option>
                                <option value="EN_EN" ${menu.menuLanguage.toString().equals("EN_EN")?"selected":""}>
                                    EN_EN</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6 item-info-cart">
                        <div class="col-lg-12 item-text-cart">
                            <select class="form-control" name="menu_status">
                                <option value="IDLE" ${menu.menuStatus.toString().equals("IDLE")?"selected":""}>
                                    IDLE</option>
                                <option value="ACTIVE" ${menu.menuStatus.toString().equals("ACTIVE")?"selected":""}>
                                    ACTIVE</option>
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
                            <label><input type="checkbox" name="item_id" value="${item.id}" ${menu.menuItemList.contains(item)?"checked":""}>
                                <c:out value="${item.title}"/></label>
                        </div>
                    </c:forEach>
                </div>
                <div id="Soup" class="table table-hover tabcontent">
                    <c:forEach items="${soup}" var="item">
                        <div class="checkbox">
                            <label><input type="checkbox" name="item_id" value="${item.id}" ${menu.menuItemList.contains(item)?"checked":""}>
                                <c:out value="${item.title}"/></label>
                        </div>
                    </c:forEach>
                </div>
                <div id="Appetizier" class="tabcontent table table-hover">
                    <c:forEach items="${appetizier}" var="item">
                        <div class="checkbox">
                            <label><input type="checkbox" name="item_id" value="${item.id}" ${menu.menuItemList.contains(item)?"checked":""}>
                                <c:out value="${item.title}"/></label>
                        </div>
                    </c:forEach>
                </div>
                <div id="Hot" class="tabcontent table table-hover">
                    <c:forEach items="${hot}" var="item">
                        <div class="checkbox">
                            <label><input type="checkbox" name="item_id" value="${item.id}" ${menu.menuItemList.contains(item)?"checked":""}>
                                <c:out value="${item.title}"/></label>
                        </div>
                    </c:forEach>
                </div>
                <div id="Dessert" class="tabcontent table table-hover">
                    <c:forEach items="${dessert}" var="item">
                        <div class="checkbox">
                            <label><input type="checkbox" name="item_id" value="${item.id}" ${menu.menuItemList.contains(item)?"checked":""}>
                                <c:out value="${item.title}"/></label>
                        </div>
                    </c:forEach>
                </div>
                <div id="Drink" class="tabcontent table table-hover">
                    <c:forEach items="${drink}" var="item">
                        <div class="checkbox">
                            <label><input type="checkbox" name="item_id" value="${item.id}" ${menu.menuItemList.contains(item)?"checked":""}>
                                <c:out value="${item.title}"/></label>
                        </div>
                    </c:forEach>
                </div>
            </div>

                <div class="col-sm-4 col-sm-push-7">
                    <button type="submit" class="btn btn-lg btn-block my-btn"
                            name="command" value="edit_menu">
                        <span class="glyphicon glyphicon-plus"></span> <fmt:message key="save.changes"/></button>
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
