<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 21.
  Time: 오전 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL 사용하기 준비 단계--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>todoList 목록화면. </h1>
    <a href="/todo/register2">글쓰기</a>




<h3>하나 조회</h3>
  <ul>
    <c:forEach var="dto" items="${list}">
      <li>
        <span>${dto.tno}</span>
        <span><a href="/todo/read2?tno=${dto.tno}">${dto.title}</a></span>
        <span>${dto.dueDate}</span>
        <span>${dto.finished? "완료": "미완료"}</span>
      </li>
    </c:forEach>
  </ul>


</body>
</html>
