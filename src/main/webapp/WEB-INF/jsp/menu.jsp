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
    <style>

        .container {
            width: 80%;
            height: 90%;
            margin: 10px auto;
            text-align: center;
        }
        .container h3 {
            font-size: 55px;
            font-weight: bold;
            color: #5F5F5F;
            letter-spacing: 10px;
            text-shadow: 2px 2px 0px #d5d5d5,
            2px 2px 0px rgba(0, 0, 0, 0.2);
            -webkit-animation:colorchange 25s infinite alternate;
        }

        .person {
            margin-bottom: 20px;
            width: 80%;
            height: 80%;
            opacity: 0.7;
        }
        .person:hover {

        }
        .box-item {
            border: 1px solid #BFBFBF;
            border-radius: 5%;
            margin: 15px;
            width: 100%;
            -webkit-filter: grayscale(10%); /* Safari 6.0 - 9.0 */
            filter: grayscale(10%);
            background: #F8F8F8;
            box-shadow: 1px 0px 1px #ccc, 0px 1px 1px #eee,
            2px 1px 1px #ccc, 1px 2px 1px #eee;

        }
        .box-item:hover {
            filter: grayscale(0%);
            -webkit-filter: grayscale(0%);
            filter: none;
            -webkit-box-shadow: 5px 5px 5px 0px rgba(122,122,122,0.5);
            -moz-box-shadow: 5px 5px 5px 0px rgba(122,122,122,0.5);
            box-shadow: 5px 5px 5px 0px rgba(122,122,122,0.5);
            transition: 1.5s all;
            background: white;
            cursor: pointer;
            border-color: #9A9A9A;
            transform: scale(1.03);
        }
        .box-item:hover .item-name {
            display: none;
            transition: 1s all;
        }
        .box-item:hover .item-hover {
            display: block;
            transition: 1s all;
            color: #FF6666;
            letter-spacing: 3px;
        }
        .box-item p {
            font-size: 20px;
            letter-spacing: 3px;
            color: #4A4A4A;
        }
        form {
            margin: 0;
            padding: 0;
        }
        input {
            margin: 0;
            padding: 0;
        }
        .row {
            margin: 0 auto;
            text-align: center;
            position: relative;
        }
        .row img {
            width: 89%;
            margin-top: 10px;
        }
        .row input[type="image"] {
            margin-top: 10px;
        }
        .item-name {
            display: block;
            transition: 1s all;
        }
        .item-hover {
            display: none;
        }
    </style>
    <title>Menu</title>
</head>
<body>
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div class="container text-center">
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
                    <input type="image" src="resources/images/Сake-menu.png" class="person" alt="Random Name">
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
