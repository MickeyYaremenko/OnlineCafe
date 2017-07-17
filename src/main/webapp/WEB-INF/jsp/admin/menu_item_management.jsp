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
    <title>Menu items</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="wrapper">
    <div class="container-fluid">
            <c:forEach items="${menuItemList}" var="item">
                <form action="Controller" method="POST">
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
                            <h3><c:out value="${item.price}"/> $<br><fmt:message key="price"/></h3>
                            <button type="submit" class="btn btn-md my-btn"
                                    name="command" value="edit_item"><fmt:message key="edit"/></button>
                        </div>
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
                            name="command" value="add_new_item_page">
                        <span class="glyphicon glyphicon-plus"></span> <fmt:message key="add.new.item"/></button>
                </div>
            </form>
        </div>
    </div>

</div>

</body>
</html>
