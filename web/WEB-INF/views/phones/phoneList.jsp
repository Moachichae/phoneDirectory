<%--
  Created by IntelliJ IDEA.
  User: rhdid
  Date: 2021-11-26
  Time: 오후 7:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>전화번호 리스트</title>
</head>
<script>
    function submit2(frm) {
        frm.action = '';
        frm.submit();
        return true;
    }
</script>
<body>
<a href="/">전화번호부</a>
<div>
    <table>
        <tr>
            <th>name</th>
            <th>birth</th>
            <th>number</th>
            <th></th>
            <th></th>
        </tr>
        <c:forEach items="${phoneMap}" var="phone">
            <tr>
                <td>${phone.value.nameOrKey}</td>
                <td>${phone.value.birth}</td>
                <td>${phone.value.number}</td>
                <td><a href="/phones/${phone.value.nameOrKey}/edit" role="button" onclick=preventClick(event)>수정</a></td>
                <td><a href="/phones/${phone.value.nameOrKey}/delete" role="button" onclick=preventClick(event)>삭제</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

<div>
    <form name="phone" accept-charset="UTF-8">
        <button id="search" type="button">검색</button>
        <input id="name" type="text" name="nameOrKey" placeholder="이름을 입력하세요" required>
    </form>
</div>
<div id="view">

</div>
</body>
<script>
    const preventClick = function (e) {
        let memberId = sessionStorage.getItem("memberId")
        if (memberId == null) {
            alert("로그인하세요");
            e.preventDefault();
        }
        return true
    };


    $("#search").click(function () {
        const nameOrKey = $("#name").val();
        const url = "phones/" + nameOrKey;
        $.ajax(
            {
                url: url,
                type: "get",
                success: function (data) {
                   document.getElementById("view").innerText = data;
                },
                error: function (a, b, c) {
                    alert(c);
                }
            });
    });

</script>
</html>
