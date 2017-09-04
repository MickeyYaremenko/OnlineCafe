<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="language"/>
<script src='resources/js/navbar.js'></script>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="Controller?command=open_main_page"><fmt:message key="cafe.title"/></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">

                <c:choose>
                    <c:when test="${empty sessionScope.client.login}">
                        <li>
                        <form class="navbar-form form-inline pull-right" role="search"
                              action="Controller" method="GET">
                            <input type="hidden" value="sign_in_page" name="command" />
                            <button type="submit" class="btn btn-default"><fmt:message key="sign.in"/></button>
                        </form>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <c:out value="${fn:toUpperCase(sessionScope.client.login)}"/>
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <c:if test="${sessionScope.client.role eq 'ADMIN'}">
                                    <li><a href="Controller?command=open_admin_page">
                                        <fmt:message key="open.admin.page"/>
                                    </a>
                                    </li>
                                </c:if>
                                <li><a href="Controller?command=open_client_acc">
                                    <fmt:message key="open.account"/>
                                </a></li>
                                <li><a href="Controller?command=sign_out">
                                    <fmt:message key="log.out"/>
                                </a></li>
                            </ul></li>
                    </c:otherwise>
                </c:choose>
                <li><a href="Controller?command=open_order_page"><fmt:message key="order"/>
                    <span class="badge"><c:out value="${sessionScope.order.size()}"/></span>
                </a> </li>
                <li><a href="Controller?command=open_main_page"><fmt:message key="home"/></a></li>
                <li><a href="#places"><fmt:message key="places"/></a></li>
                <li id="dropdown" class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#"><fmt:message key="menu"/>
                        <span class="caret"></span>
                </a>
                    <ul class="dropdown-menu">
                        <li><a href="Controller?command=choose_category&category=salad"><fmt:message key="salads"/></a></li>
                        <li><a href="Controller?command=choose_category&category=soup"><fmt:message key="soups"/></a></li>
                        <li><a href="Controller?command=choose_category&category=appetizier"><fmt:message key="appetiziers"/></a></li>
                        <li><a href="Controller?command=choose_category&category=hot"><fmt:message key="hot"/></a></li>
                        <li><a href="Controller?command=choose_category&category=dessert"><fmt:message key="desserts"/></a></li>
                        <li><a href="Controller?command=choose_category&category=drink"><fmt:message key="drinks"/></a></li>
                    </ul></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <img class="globe-icon" src="resources/images/globe.png"/>
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="Controller?command=choose_language&language=ru_RU">
                            Русский
                        </a></li>
                        <li><a href="Controller?command=choose_language&language=en_EN">
                            English
                        </a></li>
                    </ul></li>
            </ul>
        </div>
    </div>
</nav>

