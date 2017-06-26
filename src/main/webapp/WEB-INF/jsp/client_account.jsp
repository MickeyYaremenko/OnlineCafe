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
    <title>Your Account</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>
<div class="main-field">
    <div class="tab">
        <button class="tablinks active" onclick="openCity(event, 'Account-Settings')">Account Settings</button>
        <button class="tablinks" onclick="openCity(event, 'Inventory')">Inventory</button>
        <button class="tablinks" onclick="openCity(event, 'Order-History')">Order History</button>
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
                                        name="action" value="change_user_password">
                                    Change password
                                </button>
                            </div>
                        </div>
                    </div>
                </form>

            </c:when>
            <c:otherwise>
                <h3><c:out value="${changepass}"></c:out></h3>
                <form action="Controller" method="POST">
                    <input type="hidden" name="action" value="open_user_acc" />
                    <div class="col-sm-4">
                        <button type="submit" id="Button" class="btn btn-default btn-sm btn-block"
                                name="action" value="open_user_acc">
                            Retry
                        </button>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>
    </div>



    <div id="Inventory" class="tabcontent">
        <h3>Inventory.</h3>


    </div>

    <div id="Order-History" class="tabcontent">
        <h3>Order History.</h3>
        <table class="table table-hover table-condensed">
            <thead>
            <tr>
                <th>Bill #</th>
                <th>Sum of a bill</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items = "${history}" var="i" varStatus="commentLoop">

                <tr>

                    <td><c:out value = "${commentLoop.index+1}"/></td>
                    <td>
                        <c:forEach items = "${i.equipList}" var="j">
                            <c:out value = "${j.name}"/><br/>
                        </c:forEach>
                    </td>
                    <td><c:out value = "${i.dateStart}"/></td>
                    <td><c:out value = "${i.dateEnd}"/></td>
                    <td><c:out value = "${i.sum}"/></td>
                </tr>
            </c:forEach>


            </tbody>
        </table>
    </div>
</div>
</body>
</html>
