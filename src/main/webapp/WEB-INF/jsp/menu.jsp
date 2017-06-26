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
    <title>Menu</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div id="menu-container" class="container text-center">
    <div class="row">
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="choose_category"/>
                    <input type="hidden" name="category" value="salad"/>
                    <input type="image" src="resources/images/Salad-menu.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong>Salads</strong></p>
                <p class="item-hover"><strong>Pick a salad</strong></p>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="choose_category"/>
                    <input type="hidden" name="category" value="soup"/>
                    <input type="image" src="resources/images/Soup-menu.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong>Soups</strong></p>
                <p class="item-hover"><strong>Pick a soup</strong></p>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="choose_category"/>
                    <input type="hidden" name="category" value="appetizer"/>
                    <input type="image" src="resources/images/Sandwich-menu.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong>Appetizer</strong></p>
                <p class="item-hover"><strong>Pick an appetizer</strong></p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="choose_category"/>
                    <input type="hidden" name="category" value="hot"/>
                    <input type="image" src="resources/images/Hot-menu.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong>Hot dishes</strong></p>
                <p class="item-hover"><strong>Pick a hot one</strong></p>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="choose_category"/>
                    <input type="hidden" name="category" value="desert"/>
                    <input type="image" src="resources/images/Cake-menu.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong>Deserts</strong></p>
                <p class="item-hover"><strong>Pick a desert</strong></p>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="box-item">
                <form action="Controller" method="get">
                    <input type="hidden" name="command" value="choose_category"/>
                    <input type="hidden" name="category" value="drink"/>
                    <input type="image" src="resources/images/Drinks-menu.png" class="person" alt="Random Name">
                </form>
                <p class="item-name"><strong>Drinks</strong></p>
                <p class="item-hover"><strong>Pick a drink</strong></p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
