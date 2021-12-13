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
                <tr id="${phone.value.nameOrKey}">
                    <td>${phone.value.nameOrKey}</td>
                    <td>${phone.value.birth}</td>
                    <td>${phone.value.number}</td>
                    <td>
                        <button type="button" id="edit" value="${phone.value.nameOrKey}">수정</button>
                    </td>
                    <td>
                        <button type="button" id="delete" value="${phone.value.nameOrKey}">삭제</button>
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
    <div id="view"></div>
</div>

<jsp:include page="../fragments/footer.jsp"></jsp:include>
</body>
<script>
    //연락처 id로 검색(ajax)
    $("#search").click(function () {
        const nameOrKey = $("#name").val();
        const url = "phones/" + nameOrKey;

        if (nameOrKey != "") {
            $.ajax(
                {
                    url: url,
                    type: "get",
                    success: function (result) {
                        document.getElementById("view").innerText = result;
                    },
                    error: function () {
                        alert('error'); // 실패 시 처리
                    }
                });
        } else {
            alert("값을 입력하세요");
        }

    });
</script>

<script>
    //연락처 삭제
    $(document).on("click", "#delete", function () {
        const nameOrKey = $(this).val();
        const token = localStorage.getItem('token');
        const url = "/phones/delete";

        $.ajax({
            url: "/token",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify({'token': token}),
            success: function () {
                $.ajax(
                    {
                        url: url,
                        type: "post",
                        contentType: "application/json",
                        data: JSON.stringify({nameOrKey: nameOrKey}),
                        success: function () {
                            $("#" + nameOrKey).remove();
                            alert("삭제성공");
                        },
                        error: function () {
                            alert('error');
                        }
                    });
            },
            error: function () {
                alert('로그인을 다시하세요');
                localStorage.clear();
                location.href = "/login";
            }
        });

    });
</script>

<script>
    $(document).on("click", "#edit", function () {
        location.href = "/phones/" + $(this).val() + '/edit';
    });

</script>
</html>
