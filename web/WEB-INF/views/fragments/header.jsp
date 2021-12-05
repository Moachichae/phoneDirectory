<%--
  Created by IntelliJ IDEA.
  User: rhdid
  Date: 2021-12-05
  Time: 오후 7:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Header -->
<header class="pt-5">
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
            <a class="navbar-brand" href="/">home</a>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <c:if test="${empty memberId}">
                            <a class="nav-link" id="login" href="/login" onload="loading()">로그인</a>
                        </c:if>
                        <c:if test="${not empty memberId}">
                            <a class="nav-link" href="/phones/new">전화번호 입력</a>
                        </c:if>
                    </li>
                    <c:if test="${not empty memberId}">
                        <li class="nav-item">
                            <a class="nav-link" href="/phoneList">전화번호 검색</a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <c:if test="${empty memberId}">
                            <a class="nav-link" href="/members/new">회원가입</a>
                        </c:if>
                        <c:if test="${not empty memberId}">
                            <a class="nav-link" id="logout" href="/logout">로그아웃</a>
                        </c:if>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

</header>

<script>
    var submitAction = function () {
        var memberId = document.getElementById("session").value;
        if (memberId == "") {
            alert("로그인하세요");
            return false;
        }
        return true
    };
</script>
<!-- // Header -->

