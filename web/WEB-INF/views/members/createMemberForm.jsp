<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

<div>
    <h2>회원 가입</h2>
    <form action="/members/new" method="post">
        아이디 : <input type="text" name="id" placeholder="아이디를 입력하세요"><br>
        비밀번호 : <input type="text" name="password" placeholder="비밀번호를 입력하세요"><br>
        <button type="submit">확인</button>
    </form>
</div>

</body>
</html>