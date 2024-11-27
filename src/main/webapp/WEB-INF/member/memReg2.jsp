<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 27.
  Time: 오후 4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>member 등록 화면</h1>
<form action="/member/register2" method="post">
    <div>
        <input type="text" name="title" placeholder="멤버 이름 입력란.">
    </div>
    <div>
        <input type="date" name="dueDate">
    </div>
    <button type="reset">초기화</button>
    <button type="submit">등록</button>
</form>
</body>
</html>
