<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 25. 3. 21.
  Time: 오전 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>전체 보기${count}</title>
</head>
<body>
<h2>전체 보기(${count})</h2>

<!-- 🔍 검색 폼 -->
<form action="plist" method="get">
    <select name="field">
        <option value="name" ${field == 'name' ? 'selected' : ''}>이름</option>
        <option value="job" ${field == 'job' ? 'selected' : ''}>직업</option>
        <option value="id" ${field == 'id' ? 'selected' : ''}>아이디</option>
    </select>
    <input type="text" name="word" value="${word}" placeholder="검색어 입력" />
    <button type="submit">검색</button>
</form>
<hr/>

<!-- 👤 전체 목록 출력 -->
<c:forEach items="${personList}" var="person">
    이름: <a href="pDetail?id=${person.id}">${person.name}</a><br/>
    아이디: ${person.id}<br/>
    성별: ${person.gender}<br/>
    직업: ${person.job}<br/>
    <hr/>
</c:forEach>

</body>
</html>

