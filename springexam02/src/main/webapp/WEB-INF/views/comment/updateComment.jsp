<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<html>
<head>
    <title>댓글 수정</title>
</head>
<body>
<h3>댓글 수정</h3>
<form action="/comment/updateComment" method="post">
    <input type="hidden" name="cnum" value="${comment.cnum}" />
    <input type="hidden" name="bnum" value="${comment.bnum}" />

    <div class="mb-3">
        <label for="userid">작성자</label>
        <input type="text" id="userid" name="userid" class="form-control"
               value="${comment.userid}" />
    </div>

    <div class="mb-3">
        <label for="message">내용</label>
        <textarea id="message" name="message" class="form-control" rows="5">${comment.message}</textarea>
    </div>

    <button type="submit" class="btn btn-primary">댓글 수정</button>
</form>
</body>
</html>
