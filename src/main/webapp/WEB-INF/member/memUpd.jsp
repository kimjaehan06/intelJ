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
<h1>member 수정화면 </h1>
<form action="/member/update?mno=${dto.mno}" method="post">
    <div>
        <input type="text" name="mno" value="${dto.mno}" readonly>
    </div>
    <div>
        <input type="text" name="title" value="${dto.title}" placeholder="이름을 입력 해주세요." >
    </div>
    <div>
        <input type="date" name="dueDate" value="${dto.dueDate}">
    </div>
    <div>
        <input type="checkbox" name="finished" ${dto.finished ? "checked" : ""} >
    </div>
    <div>
        <button type="submit">수정하기</button>


    </div>
</form>

<form action="/member/delete?mno=${dto.mno}" method="post">
    <button type="submit">삭제하기</button>
</form>
<a href="/member/list2">목록가기</a>
</body>
</html>
