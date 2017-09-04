<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <script src='resources/js/jquery.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <title>Title</title>
</head>
<body class="body-one">
<c:set var="page" value="menu_management" scope="session"/>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="wrapper">
    <div class="container-fluid">
        <c:forEach items="${menuList}" var="menu">
            <form action="Controller" method="GET">
            <div class="row item-box-cart">
                <div class="col-lg-1 col-md-1 item-info-cart">
                    <div class="col-lg-12 item-text-cart">
                        <input type="hidden" name="menu_id" value="${menu.id}">
                        <p><c:out value="${menu.id}" /></p>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 item-info-cart">
                    <div class="col-lg-12 item-text-cart">
                        <p><c:out value="${menu.creationTime}"/></p></div>
                </div>
                <div class="col-lg-3 col-md-5 item-info-cart">
                    <div class="col-lg-12 item-text-cart">
                        <p><fmt:message key="language"/>: <fmt:message key="${menu.menuLanguage}"/></p></div>
                </div>
                <div class="col-lg-3 col-md-6 item-info-cart">
                    <div class="col-lg-12 item-text-cart">
                        <p><fmt:message key="status"/>: <fmt:message key="${menu.menuStatus}"/></p></div>
                </div>
                <div class="col-lg-2 col-md-6 item-info-cart">
                        <button type="submit" class="btn btn-md my-btn"
                                name="command" value="edit_menu_page"><fmt:message key="edit"/></button>
                </div>
            </div>
            </form>
        </c:forEach>



        <div class="row" style="margin-bottom: auto">
            <form action="Controller" method="GET">
                <div class="col-sm-3 col-sm-offset-2">
                    <button type="submit" class="btn btn-lg btn-block my-btn"
                            name="command" value="open_admin_page">
                        <span class="glyphicon glyphicon-arrow-left"></span> <fmt:message key="back"/></button>
                </div>
                <div class="col-sm-3 col-sm-offset-2">
                    <button type="submit" class="btn btn-lg btn-block my-btn"
                            name="command" value="add_new_menu_page">
                        <span class="glyphicon glyphicon-plus"></span> <fmt:message key="add.new.menu"/></button>
                </div>
            </form>
        </div>
    </div>

</div>
</body>
</html>
