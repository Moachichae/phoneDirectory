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
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <title>$Title$</title>
  </head>
  <body>

  <div>
    <h2>전화번호부</h2>
    전화번호 입력
      <form id="phone" name ="phone" action="/phones/new" method="post" accept-charset="UTF-8" onsubmit="submitAction()">
        이름 : <input type="text" name="nameOrKey" required><br>
        생년월일 : <input type="text" name="birth" required><br>
        전화번호 : <input type="text" name="number" required><br>
        <button type="submit" id="save">저장</button>
      </form>
  </div>
  <div>
    <a href="/login">로그인</a>  <a href="/members/new">회원가입</a>
  </div>
  <div>
    <a href ="/phoneList">전화번호 검색</a>
  </div>

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
