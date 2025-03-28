<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 25. 3. 24.
  Time: 오전 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>회원 상세 보기</h2>

<p><strong>이름:</strong> ${person.name}</p>
<p><strong>아이디:</strong> ${person.id}</p>
<p><strong>성별:</strong> ${person.gender}</p>
<p><strong>직업:</strong> ${person.job}</p>

<br/>

<form action="deletePerson" method="post" onsubmit="return confirm('정말 삭제하시겠습니까?');">
    <input type="hidden" name="id" value="${person.id}" />
    <input type="submit" value="삭제하기" />
</form>
<a href="updatePersonForm?id=${person.id}">
    <button type="button">수정하기</button>
</a>
<button type="button" onclick="location.href='nametoAddr?name=${person.name}'">주소 보기</button>
</body>
</html>
