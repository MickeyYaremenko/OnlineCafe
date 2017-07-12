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
    <title>Title</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="container">
    <div class="row">
    <div class="col-md-6 col-md-offset-3">
    <div id="my-panel" class="panel panel-login">
        <div class="panel-heading">
            <h2>Add new item:</h2>
            <hr>
        </div>
        <div class="panel-body">
            <div class="row">
            <div class="col-lg-12">
                <form action="Controller" method="post" role="form" style="display: block;">
                    <div class="form-group">
                        <label for="title" class="control-label">Title:</label>
                        <input type="text" name="title" id="title" tabindex="1" class="form-control"
                               placeholder="Enter title">
                    </div>
                    <div class="form-group">
                        <label for="weight" class="control-label">Weight:</label>
                        <input type="text" name="weight" id="weight" tabindex="2" class="form-control"
                               placeholder="Enter weight">
                    </div>
                    <div class="form-group">
                        <label for="price" class="control-label">Price:</label>
                        <input type="text" name="price" id="price" tabindex="3" class="form-control"
                               placeholder="Enter price">
                    </div>
                    <div class="form-group">
                        <label for="category" class="control-label">Category:</label>
                        <input type="text" name="category" id="category" tabindex="4" class="form-control"
                               placeholder="Enter category">
                    </div>
                    <div class="form-group">
                        <label for="description" class="control-label">Description:</label>
                        <textarea rows="2" name="description" id="description" tabindex="5"
                                  class="form-control" placeholder="Enter description"></textarea>
                    </div>
                    <div class="form-group">
                        <div class="row">
                            <div class="col-sm-4 col-sm-offset-1">
                                <button type="submit" class="btn btn-md my-btn"
                                        name="command" value="add_new_item">
                                    <span class="glyphicon glyphicon-plus"></span>
                                    Add item</button>
                            </div>
                            <div class="col-sm4 col-sm-offset-2">
                                <button type="submit" class="btn btn-md my-btn-red"
                                        name="command" value="manage_menu_items">
                                    <span class="glyphicon glyphicon-arrow-left"></span>
                                    Go back</button>
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
