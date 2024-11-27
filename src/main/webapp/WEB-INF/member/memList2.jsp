<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 27.
  Time: 오후 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>member 목록. </h1>
<a href="/member/register2">member 추가</a>




<h3>하나 조회</h3>
<ul>
  <c:forEach var="dto" items="${list}">
    <li>
      <span>${dto.mno}</span>
      <span><a href="/member/read2?mno=${dto.mno}">${dto.title}</a></span>
      <span>${dto.dueDate}</span>
      <span>${dto.finished? "완료": "미완료"}</span>
    </li>
  </c:forEach>
</ul>
</body>
</html>
