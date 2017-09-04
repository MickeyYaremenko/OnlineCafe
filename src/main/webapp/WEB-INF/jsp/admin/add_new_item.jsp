<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/form.css' type='text/css' media='all'>
    <script src='resources/js/jquery.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <title>Title</title>
</head>
<body class="body-one
<c:set var="page" value="add_new_item" scope="session"/>">
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="container">
    <div class="row">
    <div class="col-md-6 col-md-offset-3">
    <div id="my-panel" class="panel panel-login">
        <div class="panel-heading">
            <h2><fmt:message key="add.new.item"/>:</h2>
            <hr>
        </div>
        <div class="panel-body">
            <div class="row">
            <div class="col-lg-12">
                <form action="Controller" method="post" role="form" style="display: block;">
                    <div class="form-group">
                        <label for="title" class="control-label"><fmt:message key="title"/>:</label>
                        <input type="text" name="title" id="title" tabindex="1" class="form-control"
                               placeholder="<fmt:message key="enter.title"/>">
                    </div>
                    <div class="form-group">
                        <label for="weight" class="control-label"><fmt:message key="weight"/>:</label>
                        <input type="text" name="weight" id="weight" tabindex="2" class="form-control"
                               placeholder="<fmt:message key="enter.weight"/>">
                    </div>
                    <div class="form-group">
                        <label for="price" class="control-label"><fmt:message key="price"/>:</label>
                        <input type="text" name="price" id="price" tabindex="3" class="form-control"
                               placeholder="<fmt:message key="enter.price"/>">
                    </div>
                    <div class="form-group">
                        <label for="category" class="control-label"><fmt:message key="category"/>:</label>
                        <select id="category" class="form-control" name="category" tabindex="4">
                            <option value="salad">
                                <fmt:message key="salads"/></option>
                            <option value="soup">
                                <fmt:message key="soups"/></option>
                            <option value="appetizier">
                                <fmt:message key="appetiziers"/></option>
                            <option value="hot">
                                <fmt:message key="hot"/></option>
                            <option value="dessert">
                                <fmt:message key="desserts"/></option>
                            <option value="drink">
                                <fmt:message key="drinks"/></option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="description" class="control-label"><fmt:message key="description"/>:</label>
                        <textarea rows="2" name="description" id="description" tabindex="5"
                                  class="form-control" placeholder="<fmt:message key="enter.description"/>"></textarea>
                    </div>
                            <div class="col-sm-4 col-sm-push-7">
                                <button type="submit" class="btn btn-md my-btn"
                                        name="command" value="add_new_item">
                                    <span class="glyphicon glyphicon-plus"></span>
                                    <fmt:message key="add.new.item"/></button>
                            </div>
                </form>
                <form action="Controller" method="GET">
                <div class="col-sm-4 col-sm-pull-4 col-sm-offset-1">
                    <button type="submit" class="btn btn-md my-btn-red"
                            name="command" value="manage_menu_items">
                        <span class="glyphicon glyphicon-arrow-left"></span>
                        <fmt:message key="back"/></button>
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
