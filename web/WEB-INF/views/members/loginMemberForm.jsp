<%--
  Created by IntelliJ IDEA.
  User: rhdid
  Date: 2021-11-26
  Time: 오전 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<form action="/login" method="post">
    아이디 : <input type="text" name="id" placeholder="아이디를 입력하세요"> <br>
    비밀번호 : <input type="text" name="password" placeholder="비밀번호를 입력하세요"> <br>
    <button type="submit">로그인</button>
</form>
<div>
    <a href="/members/new">회원가입</a>
</div>
</body>
</html>
