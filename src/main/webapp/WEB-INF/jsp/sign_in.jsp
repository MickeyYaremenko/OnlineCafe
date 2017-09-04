<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/form.css' type='text/css' media='all'>
    <script src='resources/js/jquery.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <script src='resources/js/sign_in.js'></script>
    <title>Sign In</title>
</head>
<body class="body-one">
<c:set var="page" value="sign_in" scope="session"/>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div id="my-panel" class="panel panel-login">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-6">
                            <a href="#" class="active" id="login-form-link"><fmt:message key="sign.in"/></a>
                        </div>
                        <div class="col-xs-6">
                            <a href="#" id="register-form-link"><fmt:message key="register"/></a>
                        </div>
                    </div>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form id="login-form" action="Controller" method="post" role="form" style="display: block;">
                                <input type="hidden" value="sign_in" name="command">
                                <div class="form-group">
                                    <input type="text" name="login" id="login" tabindex="1" class="form-control"
                                           placeholder="<fmt:message key="login"/>" value="">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" tabindex="2"
                                           class="form-control" placeholder="<fmt:message key="password"/>">
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="login-submit" id="login-submit" tabindex="4"
                                                   class="form-control btn btn-login" value="<fmt:message key="sign.in"/>">
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <form id="register-form" action="Controller" method="post" role="form" style="display: none;">
                                <input type="hidden" value="register" name="command">
                                <div class="form-group">
                                    <input type="text" name="login" id="login" tabindex="1"
                                           class="form-control" placeholder="<fmt:message key="login"/>"
                                           pattern="[A-z0-9_-]{3,10}" title="<fmt:message key="login.rules"/>">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="password" id="password" tabindex="2"
                                           class="form-control" placeholder="<fmt:message key="password"/>"
                                           pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{3,}$" title="<fmt:message key="password.rules"/>">
                                </div>
                                <div class="form-group">
                                    <input type="password" name="confirm_password" id="confirm_password"
                                           tabindex="2" class="form-control" placeholder="<fmt:message key="confirm.password"/>"
                                           pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{3,}$" title="<fmt:message key="password.rules"/>">
                                </div>
                                <div class="form-group">
                                    <input type="text" name="first_name" id="first_name" tabindex="1"
                                           class="form-control" placeholder="<fmt:message key="first.name"/>"
                                           pattern=".+{1, }" title="<fmt:message key="name.rules"/>">
                                </div>
                                <div class="form-group">
                                    <input type="text" name="last_name" id="last_name" tabindex="1"
                                           class="form-control" placeholder="<fmt:message key="last.name"/>"
                                           pattern=".+{1, }" title="<fmt:message key="name.rules"/>">
                                </div>
                                <div class="form-group">
                                    <input type="email" name="email" id="email" tabindex="1"
                                           class="form-control" placeholder="<fmt:message key="email"/>"
                                           pattern="[A-z0-9_\.-]+@[A-z0-9.-]+\.[a-z]{2,6}" title="<fmt:message key="email.rules"/>">
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-6 col-sm-offset-3">
                                            <input type="submit" name="register-submit" id="register-submit" tabindex="4"
                                                   class="form-control btn btn-register" value="<fmt:message key="register"/>">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
