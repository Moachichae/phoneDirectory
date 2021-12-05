<%--
  Created by IntelliJ IDEA.
  User: rhdid
  Date: 2021-12-06
  Time: 오전 4:21
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
    <title>$Title$</title>
</head>
<body>
<jsp:include page="fragments/header.jsp"></jsp:include>


<div class="container pt-3">
    <div class="row">

        <div class="col-lg-3">

            <h3 class="my-4 text-center">Category</h3>
            <div class="list-group mb-4">
                <a class="list-group-item list-group-item-info text-center font-weight-bold">게시판</a>
            </div>

        </div>
    </div>
</div>


<jsp:include page="fragments/footer.jsp"></jsp:include>
</body>

</html>
