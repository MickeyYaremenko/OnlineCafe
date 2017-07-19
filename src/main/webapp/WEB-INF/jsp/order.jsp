<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/spinner.css' type='text/css' media='all'>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <script src='resources/js/spinner.js'></script>
    <title>Your order</title>
</head>
<body class="body-one">
<c:set var="page" value="order" scope="session"/>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="wrapper">
    <div class="container-fluid">
        <form action="Controller" method="POST">
            <c:forEach items="${order}" var="entry">
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
                <button type="submit" class="btn my-btn btn-lg btn-block"
                        name="command" value="update_order">
                    <span class="glyphicon glyphicon-refresh"></span>
                    <fmt:message key="update.order"/>!
                </button>
            </div>
            </div>
            <div class="col-sm-4 col-sm-push-4">
                <div class="col-sm-8 col-sm-offset-2">
                <button type="submit" class="btn my-btn btn-lg btn-block"
                        name="command" value="make_order">
                    <span class="glyphicon glyphicon-ok"></span>
                    <fmt:message key="make.order"/>
                </button>
            </div>
            </div>
        </form>
        <form action="Controller" method="GET">
            <input type="hidden" name="command" value="open_menu" />
            <div class="col-sm-4 col-sm-pull-8">
                <div class="col-sm-8 col-sm-offset-2">
                <button type="submit" class="btn my-btn btn-lg btn-block"
                        name="command" value="open_menu">
                    <span class="glyphicon glyphicon-arrow-left"></span>
                    <fmt:message key="back.to.menu"/>
                </button>
            </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
