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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
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
<jsp:include page="../fragments/header.jsp"></jsp:include>
<div class="container pt-3">
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
                    <td><a href="/phones/${phone.value.nameOrKey}/edit" role="button" onclick=preventClick(event)>수정</a>
                    </td>
                    <td><a href="/phones/${phone.value.nameOrKey}/delete" role="button"
                           onclick=preventClick(event)>삭제</a>
                    </td>
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
    <input type="hidden" value="${memberId}" id="session">
</div>

<jsp:include page="../fragments/footer.jsp"></jsp:include>
</body>
<script>
    const preventClick = function (e) {
        var memberId = document.getElementById("session").value;
        if (memberId == "") {
            alert("로그인하세요");
            e.preventDefault();
        }
        return true
    };


    $("#search").click(function () {
        const nameOrKey = $("#name").val();
        const url = "phones/" + nameOrKey;
        if (nameOrKey != "") {
            $.ajax(
                {
                    url: url,
                    type: "get",
                    success: function (data) {
                        document.getElementById("view").innerText = data;
                    },
                    error: function (request, status, error) {
                        alert("code = " + request.status +
                            " message = " + request.responseText +
                            " error = " + error); // 실패 시 처리
                    }
                });
        } else {
            alert("값을 입력하세요");
        }

    });

</script>
</html>
