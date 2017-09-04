<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/client_account.css' type='text/css' media='all'>
    <script src='resources/js/jquery.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <script src='resources/js/client_account.js'></script>
    <script src='../../../resources/js/pass_validation.js'></script>
    <script src='resources/js/number_validation.js'></script>
    <title>Your Account</title>
</head>
<body class="client-acc-body">
<c:set var="page" value="client_account" scope="session"/>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="main-field">
    <div class="tab">
        <button class="tablinks active" onclick="openTab(event, 'Account-Settings')"><fmt:message key="account.settings"/></button>
        <button class="tablinks" onclick="openTab(event, 'Current-orders')"><fmt:message key="current.orders"/></button>
        <button class="tablinks" onclick="openTab(event, 'Order-History')"><fmt:message key="order.history"/></button>
        <button class="tablinks" onclick="openTab(event, 'Balance')"><fmt:message key="balance"/></button>
    </div>

    <div id="Account-Settings" class="tabcontent">
        <c:choose>
            <c:when test="${empty changepass}">
                <h3><fmt:message key="account.settings"/></h3>
                <h4><fmt:message key="change.password"/>:</h4>
                <form action="Controller" method="POST">
                    <div class="form-group">
                        <div class="col-xs-6">
                            <label for="oldpass"><fmt:message key="old.password"/>:</label>
                            <input type="password" class="input-md form-control" id="oldpass" name="oldpass"
                                   placeholder="<fmt:message key="old.password"/>" autocomplete="off">
                            <br/>
                            <label for="password1"><fmt:message key="new.password"/>:</label>
                            <input type="password" class="input-md form-control" name="newpass1" id="password1"
                                   placeholder="<fmt:message key="new.password"/>" autocomplete="off">
                            <span id="ucase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span>
                            <fmt:message key="one.uppercase.letter"/>
                            <span id="lcase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span>
                            <fmt:message key="one.lowercase.letter"/>
                            <span id="num" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span>
                            <fmt:message key="one.number"/>
                            <br/>
                            <br/>
                            <label for="password2"><fmt:message key="repeat.new.password"/>:</label>
                            <input type="password" class="input-md form-control" name="newpass2" id="password2"
                                   placeholder="<fmt:message key="repeat.new.password"/>" autocomplete="off">
                            <span id="pwmatch" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span>
                            <fmt:message key="passwords.match"/>
                            <br/>
                            <br/>
                            <input type="hidden" name="action" value="change_user_password" />
                            <div class="col-sm-10 col-sm-offset-1">
                                <button type="submit" id="Button" class="btn my-btn btn-sm btn-block"
                                        name="command" value="change_client_pass">
                                    <fmt:message key="change.password"/>
                                </button>
                            </div>
                        </div>
                    </div>
                </form>

            </c:when>
            <c:otherwise>
                <h3><c:out value="${changepass}"/></h3>
                <form action="Controller" method="GET">
                    <input type="hidden" name="command" value="open_client_acc" />
                    <div class="col-sm-4">
                        <button type="submit" id="Button" class="btn my-btn btn-sm btn-block"
                                name="command" value="open_client_acc">
                            <fmt:message key="retry"/>
                        </button>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
    </div>

    <div id="Current-orders" class="tabcontent">
        <h3><fmt:message key="current.orders"/></h3>
        <table class="table table-hover table-condensed">
            <thead>
            <tr>
                <th><fmt:message key="order.#"/></th>
                <th><fmt:message key="date.time"/></th>
                <th><fmt:message key="bill.sum"/></th>
                <th><fmt:message key="status"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${current}" var="i" varStatus="commentLoop">
                <tr>
                    <td><a href="Controller?command=open_view_order_page&orderID=${i.id}">
                        <c:out value = "${commentLoop.index+1}"/></a></td>
                    <td><c:out value = "${i.dateTime}"/></td>
                    <td><c:out value = "${i.sum}"/></td>
                    <td><fmt:message key="${i.status}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

    <div id="Order-History" class="tabcontent">
        <h3><fmt:message key="order.history"/></h3>
        <table class="table table-hover table-condensed">
            <thead>
            <tr>
                <th><fmt:message key="bill.#"/></th>
                <th><fmt:message key="date.time"/></th>
                <th><fmt:message key="bill.sum"/></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${history}" var="i" varStatus="commentLoop">
                <tr>
                    <td><a href="Controller?command=open_view_order_page&orderID=${i.id}">
                        <c:out value = "${commentLoop.index+1}"/></a></td>
                    <td><c:out value = "${i.dateTime}"/></td>
                    <td><c:out value = "${i.sum}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="Balance" class="tabcontent">
        <h3><fmt:message key="balance"/></h3>
        <h4><fmt:message key="current.balance"/>: <c:out value="${fn:toUpperCase(sessionScope.client.balance)}"/></h4>
        <h4><fmt:message key="add.funds"/>:</h4>
        <form action="Controller" method="POST">
            <div class="col-sm-6">
            <input type="text" id="sum" class="input-md form-control" name="sum" placeholder="<fmt:message key="add.funds"/>">
                <span id="sum-input" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> <fmt:message key="number.delimiter"/>
                <br/>
            <button id="Button-balance" type="submit" class="btn my-btn btn-sm"
                    name="command" value="add_funds">
                <fmt:message key="add.funds"/>
            </button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
