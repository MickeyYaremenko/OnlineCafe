<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/form.css' type='text/css' media='all'>
    <script src='resources/js/jquery.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <title>Edit menu item</title>
</head>
<body class="body-one">
<c:set var="page" value="edit_item" scope="session"/>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div id="my-panel" class="panel panel-login">
                <div class="panel-heading">
                    <h2><c:out value="${item.title}" /></h2>
                    <hr>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <form action="Controller" method="post" role="form" style="display: block;">
                                <input type="hidden" name="item_id" value="${item.id}">
                                <div class="form-group">
                                    <label for="title" class="control-label"><fmt:message key="title"/>:</label>
                                    <input type="text" name="title" id="title" tabindex="1" class="form-control"
                                           value="${item.title}">
                                </div>
                                <div class="form-group">
                                    <label for="weight" class="control-label"><fmt:message key="weight"/>:</label>
                                    <input type="text" name="weight" id="weight" tabindex="2" class="form-control"
                                           value="${item.weight}">
                                </div>
                                <div class="form-group">
                                    <label for="price" class="control-label"><fmt:message key="price"/>:</label>
                                    <input type="text" name="price" id="price" tabindex="3" class="form-control"
                                           value="${item.price}">
                                </div>
                                <div class="form-group">
                                    <label for="category" class="control-label"><fmt:message key="category"/>:</label>
                                    <input type="text" name="category" id="category" tabindex="4" class="form-control"
                                           value="${item.category}">
                                </div>
                                <div class="form-group">
                                    <label for="description" class="control-label"><fmt:message key="description"/>:</label>
                                    <textarea rows="2" name="description" id="description" tabindex="5"
                                              class="form-control"><c:out value="${item.description}" /></textarea>
                                </div>



                                        <div class="col-sm-4 col-sm-push-4">
                                            <button type="submit" class="btn btn-block btn-md my-btn"
                                                    name="command" value="save_item_changes">
                                                <span class="glyphicon glyphicon-floppy-disk"></span>
                                                <fmt:message key="save.changes"/></button>
                                        </div>
                                        <div class="col-sm-4 col-sm-push-4">
                                            <button type="submit" class="btn btn-block btn-md my-btn-red"
                                                    name="command" value="delete_item">
                                                <span class="glyphicon glyphicon-remove"></span>
                                                <fmt:message key="delete.item"/></button>
                                        </div>


                            </form>
                            <form action="Controller" method="GET">
                            <div class="col-sm-4 col-sm-pull-8">
                                <button type="submit" class="btn btn-block btn-md my-btn"
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
