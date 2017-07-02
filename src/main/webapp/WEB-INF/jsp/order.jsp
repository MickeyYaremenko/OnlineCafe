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
    <title>Your order</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="wrapper">
    <div class="container-fluid">
        <form action="Controller" method="POST">
            <c:forEach items="${order}" var="entry">
                <div class="row item-box-cart">
                    <div class="col-lg-4 col-sm-6 item-info-cart">
                        <div class="col-lg-12 item-text-cart">
                            <input type="hidden" name="item" value="${entry.key.title}">
                            <p><c:out value="${entry.key.title}" /> </p>
                        </div>
                    </div>
                    <div class="col-lg-4 col-sm-6 item-info-cart">
                    <div class="col-lg-12 item-text-cart">
                        <p>Price: <c:out value="${entry.key.price*entry.value}"/> $</p></div>
                    </div>
                    <div class="col-lg-4 col-sm-12 item-check-cart">

                        <div class="my-spinner">
                            <div class="input-group number-spinner">
                        <span class="input-group-btn data-dwn">
                            <button type="button" class="btn btn-default btn-info" data-dir="dwn">
                            <span class="glyphicon glyphicon-minus"></span>
                            </button>
                        </span>
                                <input type="text" class="form-control text-center" name="quant" value="${entry.value}" min="0" max="40">
                                <span class="input-group-btn data-up">
                            <button type="button" class="btn btn-default btn-info" data-dir="up">
                            <span class="glyphicon glyphicon-plus"></span>
                            </button>
                        </span>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

            <div class="col-sm-4 col-sm-push-4">
                <div class="col-sm-8 col-sm-offset-2">
                <button type="submit" class="btn btn-default btn-lg btn-block"
                        name="command" value="update_order">
                    <span class="glyphicon glyphicon-refresh"></span>
                    Update an order!
                </button>
            </div>
            </div>
            <div class="col-sm-4 col-sm-push-4">
                <div class="col-sm-8 col-sm-offset-2">
                <button type="submit" class="btn btn-default btn-lg btn-block"
                        name="command" value="make_order">
                    <span class="glyphicon glyphicon-ok"></span>
                    Make an order!
                </button>
            </div>
            </div>
        </form>
        <form action="Controller" method="GET">
            <input type="hidden" name="command" value="open_menu" />
            <div class="col-sm-4 col-sm-pull-8">
                <div class="col-sm-8 col-sm-offset-2">
                <button type="submit" class="btn btn-default btn-lg btn-block"
                        name="command" value="open_menu">
                    <span class="glyphicon glyphicon-arrow-left"></span>
                    Back to menu
                </button>
            </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
