<html>
<head>
    <link rel='stylesheet' href='resources/css/bootstrap.css' type='text/css' media='all'>
    <link rel='stylesheet' href='resources/css/common.css' type='text/css' media='all'>
    <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script src='resources/js/bootstrap.js'></script>
    <title>Order done!</title>
</head>
<body class="body-one">
<%@include file="/WEB-INF/jsp/parts/navbar.jsp"%>

<div id="menu-container" class="container text-center">
    <h3>Your order will be approved by administrator soon!</h3>
    <form action="Controller" method="post">
        <button class="btn-success btn-lg" type="submit" name="command" value="open_client_acc">Go to your account</button>
    </form>
</div>
</body>
</html>
