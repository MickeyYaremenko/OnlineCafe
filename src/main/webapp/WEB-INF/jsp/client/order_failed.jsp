<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <script src='resources/js/jquery.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <title>Order failed</title>
</head>
<body>
<c:set var="page" value="order_failed" scope="session"/>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div id="menu-container" class="container text-center">
    <h3>You don't have enough money on your balance.</h3>
    <form action="Controller" method="GET">
        <button class="btn-danger btn-lg" type="submit" name="command" value="open_client_acc">Go to your account</button>
    </form>
</div>
</body>
</html>
