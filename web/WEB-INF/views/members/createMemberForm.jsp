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
    <title>$Title$</title>
</head>
<body>
<jsp:include page="../fragments/header.jsp"></jsp:include>
<div class="container pt-3">
    <h2>회원 가입</h2>
    <form>
        아이디 : <input type="text" name="id" placeholder="아이디를 입력하세요"><br>
        비밀번호 : <input type="text" name="password" placeholder="비밀번호를 입력하세요"><br>
        <button type="button" id="create_member_button">확인</button>
    </form>
</div>
<script>
    $('#create_member_button').click(function (){
        const id = $('input[name=id]').val();
        const password = $('input[name=password]').val();
        const createMember = {
            id : id,
            password : password
        };
        console.log(JSON.stringify(createMember));
        $.ajax({
            url: "/members/new",
            type: "post",
            contentType : "application/json",
            data: JSON.stringify(createMember),
            success : function(){
                location.href = '/';
            },error:function(){
                alert('error');}
        });
    })
</script>
<jsp:include page="../fragments/footer.jsp"></jsp:include>
</body>
</html>