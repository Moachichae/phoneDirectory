<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rhdid
  Date: 2021-11-27
  Time: 오후 8:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<jsp:include page="../fragments/header.jsp"></jsp:include>
<div class="container pt-3">
    <c:set var="phone" value="${phone}"/>
    <form name="phone" action="/phones/${phone.nameOrKey}/edit" method="post" accept-charset="UTF-8"
          onsubmit="return submitAction()">
        이름 : <input type="text" name="nameOrKey" value="${phone.nameOrKey}" required><br>
        생년월일 : <input type="text" name="birth" value="${phone.birth}" required><br>
        전화번호 : <input type="text" name="number" value="${phone.number}" required><br>
        <button type="submit">수정</button>
    </form>

    <input type="hidden" value="${memberId}" id="session">
</div>
<input type="hidden" value="${memberId}" id="session">
<jsp:include page="../fragments/footer.jsp"></jsp:include>
</body>

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
</html>
