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
    <title>Orders</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="wrapper">
    <div class="container-fluid">

            <c:forEach items="${order_list}" var="order">
                <form action="Controller" method="POST">
                <div class="row item-box-cart">
                    <div class="col-lg-4 col-sm-6 item-info-cart">
                        <div class="col-lg-12 row-man-ord">
                            <input type="hidden" name="orderID" value="${order.id}">
                            <p><c:out value="${order.id}" /> </p>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6 item-info-cart">
                        <div class="col-lg-12 row-man-ord">
                            <p>Status: <c:out value="${order.status}"/></p></div>
                    </div>
                    <div class="col-lg-4 col-md-12 item-info-cart">
                        <div class="row row-man-ord">
                        <p>Set status:
                            <input type="hidden" name="command" value="set_order_status"/>
                            <button type="submit" class="btn btn-md my-btn"
                                    name="status" value="COOKING">
                                Cooking
                            </button>
                            <button type="submit" class="btn btn-md my-btn"
                                    name="status" value="READY">
                                Ready
                            </button>
                            <button type="submit" class="btn btn-md my-btn"
                                    name="status" value="SERVED">
                                Served
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
                        Back to menu
                    </button>
                </div>

        </form>
    </div>
</div>
</body>
</html>
