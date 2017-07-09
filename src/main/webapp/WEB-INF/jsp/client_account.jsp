<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Bree+Serif" rel="stylesheet">
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/client_account.css' type='text/css' media='all'>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <script src='resources/js/client_account.js'></script>
    <script src='resources/js/passvalidation.js'></script>
    <script src='resources/js/number_validation.js'></script>
    <title>Your Account</title>
</head>
<body class="client-acc-body">
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>
<div class="main-field">
    <div class="tab">
        <button class="tablinks active" onclick="openCity(event, 'Account-Settings')">Account Settings</button>
        <button class="tablinks" onclick="openCity(event, 'Current-orders')">Current orders</button>
        <button class="tablinks" onclick="openCity(event, 'Order-History')">Order History</button>
        <button class="tablinks" onclick="openCity(event, 'Balance')">Balance</button>
    </div>

    <div id="Account-Settings" class="tabcontent">
        <c:choose>
            <c:when test="${empty changepass}">
                <h3>Account Settings</h3>
                <h4>Change password:</h4>
                <form action="Controller" method="POST">
                    <div class="form-group">
                        <div class="col-xs-6">
                            <label for="oldpass">Old password:</label>
                            <input type="password" class="input-md form-control" id="oldpass" name="oldpass"
                                   placeholder="Old Password" autocomplete="off">
                            <br/>
                            <label for="password1">New password:</label>
                            <input type="password" class="input-md form-control" name="newpass1" id="password1"
                                   placeholder="New Password" autocomplete="off">
                            <span id="ucase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Uppercase Letter
                            <span id="lcase" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Lowercase Letter
                            <span id="num" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> One Number

                            <label for="password2">Repeat new password:</label>
                            <input type="password" class="input-md form-control" name="newpass2" id="password2"
                                   placeholder="Repeat Password" autocomplete="off">
                            <span id="pwmatch" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> Passwords Match

                            <input type="hidden" name="action" value="change_user_password" />
                            <div class="col-sm-10 col-sm-offset-1">
                                <button type="submit" id="Button" class="btn btn-default btn-sm btn-block"
                                        name="command" value="change_client_pass">
                                    Change password
                                </button>
                            </div>
                        </div>
                    </div>
                </form>

            </c:when>
            <c:otherwise>
                <h3><c:out value="${changepass}"/></h3>
                <form action="Controller" method="POST">
                    <input type="hidden" name="command" value="open_client_acc" />
                    <div class="col-sm-4">
                        <button type="submit" id="Button" class="btn btn-default btn-sm btn-block"
                                name="command" value="open_client_acc">
                            Retry
                        </button>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
    </div>

    <div id="Current-orders" class="tabcontent">
        <h3>Current orders.</h3>
        <table class="table table-hover table-condensed">
            <thead>
            <tr>
                <th>Order #</th>
                <th>Date and time</th>
                <th>Sum of a bill</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${current}" var="i" varStatus="commentLoop">
                <tr>
                    <td><c:out value = "${commentLoop.index+1}"/></td>
                    <td><c:out value = "${i.dateTime}"/></td>
                    <td><c:out value = "${i.sum}"/></td>
                    <td><c:out value="${i.status}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>

    <div id="Order-History" class="tabcontent">
        <h3>Order History.</h3>
        <table class="table table-hover table-condensed">
            <thead>
            <tr>
                <th>Bill #</th>
                <th>Date and time</th>
                <th>Sum of a bill</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items = "${history}" var="i" varStatus="commentLoop">
                <tr>
                    <td><c:out value = "${commentLoop.index+1}"/></td>
                    <td><c:out value = "${i.dateTime}"/></td>
                    <td><c:out value = "${i.sum}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div id="Balance" class="tabcontent">
        <h3>Your Balance.</h3>
        <h4>Your current balance: <c:out value="${fn:toUpperCase(sessionScope.client.balance)}"/></h4>
        <h4>Add funds:</h4>
        <form action="Controller" method="POST">
            <div class="col-sm-6">
            <input type="text" id="sum" class="input-md form-control" name="sum" placeholder="Enter sum to add">
                <span id="sum-input" class="glyphicon glyphicon-remove" style="color:#FF0004;"></span> Use only numbers and "." delimiter
                <br/>
            <button id="Button-balance" type="submit" class="btn btn-default btn-sm"
                    name="command" value="add_funds">
                Add funds
            </button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
