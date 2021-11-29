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
    <title>Title</title>

</head>
<body>
<c:set var="phone" value="${phone}"/>
<form name="phone" action="/phones/${phone.nameOrKey}/edit" method="post" accept-charset="UTF-8" onsubmit="submitAction()">
    이름 : <input type="text" name="nameOrKey" value="${phone.nameOrKey}" required><br>
    생년월일 : <input type="text" name="birth" value="${phone.birth}" required><br>
    전화번호 : <input type="text" name="number" value="${phone.number}" required><br>
    <button type="submit">수정</button>
</form>
</body>

<script>
    const submitAction = function () {
        let memberId = sessionStorage.getItem("memberId")
        if (memberId == null) {
            alert("로그인하세요");
            return false;
        }
        return true
    };

</script>
</html>
