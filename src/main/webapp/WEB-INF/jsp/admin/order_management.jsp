<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <script src='resources/js/jquery.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <title>Orders</title>
</head>
<body class="body-one">
<c:set var="page" value="order_management" scope="session"/>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="wrapper">
    <div class="container-fluid">

            <c:forEach items="${order_list}" var="order">
                <form action="Controller" method="POST">
                <div class="row item-box-cart">
                    <div class="col-lg-3 col-sm-6 item-info-cart">
                        <div class="col-lg-12 row-man-ord">
                            <input type="hidden" name="orderID" value="${order.id}">
                            <p><c:out value="${order.id}" /> </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6 item-info-cart">
                        <div class="col-lg-12 row-man-ord">
                            <p><fmt:message key="status"/>: <c:out value="${order.status}"/></p></div>
                    </div>
                    <div class="col-lg-6 col-md-12 item-info-cart">
                        <div class="row row-man-ord">
                        <p><fmt:message key="set.status"/>:
                            <input type="hidden" name="command" value="set_order_status"/>
                            <button type="submit" class="btn btn-md my-btn"
                                    name="status" value="COOKING">
                                <fmt:message key="cooking"/>
                            </button>
                            <button type="submit" class="btn btn-md my-btn"
                                    name="status" value="READY">
                                <fmt:message key="ready"/>
                            </button>
                            <button type="submit" class="btn btn-md my-btn"
                                    name="status" value="SERVED">
                                <fmt:message key="served"/>
                            </button>
                        </p>
                        </div>
                    </div>
                </div>
                </form>
            </c:forEach>

        <form action="Controller" method="GET">

                <div class="col-sm-8 col-sm-offset-2">
                    <button type="submit" class="btn btn-lg btn-block my-btn-red"
                            name="command" value="open_admin_page">
                        <span class="glyphicon glyphicon-arrow-left"></span>
                        <fmt:message key="back"/>
                    </button>
                </div>

        </form>
    </div>
</div>
</body>
</html>
