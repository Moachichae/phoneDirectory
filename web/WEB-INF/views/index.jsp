<%--
  Created by IntelliJ IDEA.
  User: rhdid
  Date: 2021-11-24
  Time: 오후 4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <div>
    <h2>전화번호 입력</h2>
      <form action="/phone" method="post">
        이름 : <input type="text" name="name"><br>
        생년월일 : <input type="text" name="birth"><br>
        전화번호 : <input type="text" name="phone"><br>
        <button type="submit">확인</button>
      </form>
  </div>
  <div>
    <a href="sign_in">로그인</a>  <a href="sign_up">회원가입</a>
  </div>
  <div>
    <a href="/list">전화번호 검색</a>
  </div>



  </body>
</html>
