<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <script src='resources/js/jquery.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <title>Your order</title>
</head>
<body class="body-one">
<c:set var="page" value="view_order" scope="session"/>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="wrapper">
    <div class="container-fluid">
        <form action="Controller" method="GET">
            <c:forEach items="${order.items}" var="entry">
                <div class="row item-box-cart">
                    <div class="col-lg-6 col-sm-6 item-info-cart">
                        <div class="col-lg-12 item-text-cart">
                            <input type="hidden" name="item" value="${entry.key.title}">
                            <p><c:out value="${entry.key.title}" /> </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6 item-info-cart">
                        <div class="col-lg-12 item-text-cart">
                            <p><fmt:message key="price"/>: <c:out value="${entry.key.price*entry.value}"/> $</p></div>
                    </div>
                    <div class="col-lg-3 col-sm-12 item-check-cart">
                        <div class="col-lg-12 item-text-cart">
                            <p><fmt:message key="quantity"/>: <c:out value="${entry.value}"/></p></div>
                    </div>
                </div>
            </c:forEach>

            <div class="col-sm-4 col-sm-push-4">
                <div class="col-sm-8 col-sm-offset-2">
                    <c:choose>
                    <c:when test="${sessionScope.client.role eq 'ADMIN'}">
                        <button type="submit" class="btn my-btn btn-lg btn-block"
                                name="command" value="manage_orders">
                            <span class="glyphicon glyphicon-refresh"></span>
                            <fmt:message key="back"/>!
                    </c:when>
                    <c:otherwise>
                            <button type="submit" class="btn my-btn btn-lg btn-block"
                                    name="command" value="open_client_acc">
                                <span class="glyphicon glyphicon-refresh"></span>
                                <fmt:message key="open.account"/>!
                    </c:otherwise>
                    </c:choose>
                    </button>
                </div>
            </div>
            <div class="col-sm-4 col-sm-push-4">
            </div>
        </form>
            <div class="col-sm-4 col-sm-pull-8">
            </div>
    </div>
</div>
</body>
</html>
