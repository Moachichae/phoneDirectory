<%--
  Created by IntelliJ IDEA.
  User: rhdid
  Date: 2021-12-06
  Time: 오전 6:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
    <h2>전화번호부</h2>
    전화번호 입력
    <form>
        이 름 : <input type="text" name="nameOrKey" required><br>
        생년월일 : <input type="text" name="birth" required><br>
        전화번호 : <input type="text" name="number" required><br>
        <button type="button" id="phone_save">저장</button>
    </form>
</div>

<script>
    //연락처 등록
    $('#phone_save').click(function () {
        const nameOrKey = $('input[name=nameOrKey]').val();
        const birth = $('input[name=birth]').val();
        const number = $('input[name=number]').val();
        const token = localStorage.getItem('token');
        const phone = {
            nameOrKey: nameOrKey,
            birth: birth,
            number: number,
        };
        console.log(token);
        $.ajax({
            url: "/token" ,
            type: "post",
            contentType: "application/json",
            data: JSON.stringify({'token': token}),
            success: function () {
                $.ajax({
                    url: "/phones/new",
                    type: "post",
                    contentType: "application/json",
                    data: JSON.stringify(phone),
                    success: function () {
                        alert('등록성공');
                        $('form').each(function () {
                            this.reset();
                        });
                    }, error: function () {
                        alert('error');
                        location.href = "/"
                    }
                });
            },
            error: function () {
                alert('로그인을 다시하세요');
                localStorage.clear();
                location.href = "/login";
            }
        });

    })
</script>

<jsp:include page="../fragments/footer.jsp"></jsp:include>
</body>
</html>
