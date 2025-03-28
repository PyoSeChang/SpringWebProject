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
<form action="updatePerson" method="post">

    이름: <input type="text" name="name" value="${person.name}" /><br/>
    아이디: <input type="text" name="id" value="${person.id}" readonly  /><br/>
    패스워드: <input type="password" name="password" value="${person.password}"/><br/>
    성별:
    <select name="gender">
        <option value="남" ${person.gender == '남' ? 'selected' : ''}>남</option>
        <option value="여" ${person.gender == '여' ? 'selected' : ''}>여</option>
    </select><br/>
    직업: <input type="text" name="job" value="${person.job}" /><br/><br/>

    <input type="submit" value="수정하기" />
</form>
</body>
<script>
    //document.querySelector("input[value='${person.gender}']").setAttribute("checked", true)
    document.querySelector("#job").value="${person.job}"
</script>
</html>
