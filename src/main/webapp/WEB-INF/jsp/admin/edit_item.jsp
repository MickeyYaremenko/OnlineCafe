<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Bree+Serif" rel="stylesheet">
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/form.css' type='text/css' media='all'>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <title>Edit menu item</title>
</head>
<body>
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
                            <form id="register-form" action="Controller" method="post" role="form" style="display: block;">
                                <input type="hidden" name="item_id" value="${item.id}">
                                <div class="form-group">
                                    <label for="title" class="control-label">Title:</label>
                                    <input type="text" name="title" id="title" tabindex="1" class="form-control"
                                           value="${item.title}">
                                </div>
                                <div class="form-group">
                                    <label for="weight" class="control-label">Weight:</label>
                                    <input type="text" name="weight" id="weight" tabindex="2" class="form-control"
                                           value="${item.weight}">
                                </div>
                                <div class="form-group">
                                    <label for="price" class="control-label">Price:</label>
                                    <input type="text" name="price" id="price" tabindex="2" class="form-control"
                                           value="${item.price}">
                                </div>
                                <div class="form-group">
                                    <label for="category" class="control-label">Category:</label>
                                    <input type="text" name="category" id="category" tabindex="1" class="form-control"
                                           value="${item.category}">
                                </div>
                                <div class="form-group">
                                    <label for="description" class="control-label">Description:</label>
                                    <textarea rows="2" name="description" id="description" tabindex="1"
                                              class="form-control"><c:out value="${item.description}" /></textarea>
                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-4 col-sm-offset-1">
                                            <button type="submit" class="btn btn-md my-btn"
                                                    name="command" value="save_item_changes">Save changes</button>
                                        </div>
                                        <div class="col-sm4 col-sm-offset-2">
                                            <button type="submit" class="btn btn-md my-btn-red"
                                                    name="command" value="delete_item">Delete item</button>
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
