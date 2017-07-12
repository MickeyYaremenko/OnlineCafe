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
    <title>Choose an item</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="wrapper">
    <div class="container-fluid">
        <form action="Controller" method="POST">
            <c:forEach items="${menuItemList}" var="item">
                <div class="row item-box-list">
                    <div class="col-lg-10 col-md-12 item-info-list">
                        <div class="col-lg-12 item-name-list">
                            <input type="hidden" name="item" value="${item.title}">
                            <h2><c:out value="${item.title}" /></h2>
                        </div>
                        <div class="col-lg-12 item-text-list">
                            <p><c:out value="${item.description}" /> </p>
                            <p><i><c:out value="${item.weight}" /></i></p>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-12 item-check-list">
                        <div class="item-price-list">
                            <h3><c:out value="${item.price}"/> $<br>Price</h3>
                            <div class="my-spinner">
                                <div class="input-group number-spinner">
                                <span class="input-group-btn data-dwn">
                                    <button type="button" class="btn btn-default btn-info" data-dir="dwn">
                                    <span class="glyphicon glyphicon-minus"></span>
                                    </button>
                                </span>
                                    <input type="text" class="form-control text-center" name="quant" value="0" min="0" max="40">
                                    <span class="input-group-btn data-up">
                                    <button type="button" class="btn btn-default btn-info" data-dir="up">
                                    <span class="glyphicon glyphicon-plus"></span>
                                    </button>
                                </span>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </c:forEach>

            <input type="hidden" name="command" value="add_to_order" />
            <div class="col-sm-4 col-sm-push-7">
                <button type="submit" class="btn btn-lg btn-block my-btn"
                        name="command" value="add_to_order">
                    <span class="glyphicon glyphicon-shopping-cart"></span>
                    Add to an order!
                </button>
            </div>
        </form>
        <form action="Controller" method="GET">
            <input type="hidden" name="command" value="open_menu" />
            <div class="col-sm-4 col-sm-pull-4 col-sm-offset-1">
            <button type="submit" class="btn btn-lg btn-block my-btn"
                    name="command" value="open_menu">
                <span class="glyphicon glyphicon-arrow-left"></span>
                Back to menu
            </button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
