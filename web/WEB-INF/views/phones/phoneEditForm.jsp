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
    <form>
        이름 : <input type="text" name="nameOrKey" value="${phone.nameOrKey}" required><br>
        생년월일 : <input type="text" name="birth" value="${phone.birth}" required><br>
        전화번호 : <input type="text" name="number" value="${phone.number}" required><br>
        <button id="edit" type="button">수정</button>
    </form>
</div>
<script>
    const previousNameOrKey = '${phone.nameOrKey}';
    $(document).on("click","#edit",function (){
        const nameOrKey = $('input[name=nameOrKey]').val();
        const birth = $('input[name=birth]').val();
        const number = $('input[name=number]').val();
        const token = localStorage.getItem('token');
        const phone = {
            nameOrKey : nameOrKey,
            birth : birth,
            number : number,
        };
        $.ajax({
            url: "/token",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify({'token': token}),
            success: function () {
                $.ajax(
                    {
                        url: '/phones/'+ previousNameOrKey +'/edit',
                        type: "post",
                        contentType: "application/json",
                        data:  JSON.stringify(phone),
                        success: function () {
                            $("#" + nameOrKey).remove();
                            alert("수정 성공");
                            location.href = '/phones'
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

<jsp:include page="../fragments/footer.jsp"></jsp:include>
</body>

</html>
