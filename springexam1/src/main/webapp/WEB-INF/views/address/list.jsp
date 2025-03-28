<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>주소록 목록</title>
</head>
<body>

<h2>ADDRESS LIST (${count})</h2>

<!-- 🔍 검색 폼 -->
<form action="alist" method="get">
	<select name="field">
		<option value="name" ${field == 'name' ? 'selected' : ''}>이름</option>
		<option value="address" ${field == 'address' ? 'selected' : ''}>주소</option>
		<option value="zipcode" ${field == 'zipcode' ? 'selected' : ''}>우편번호</option>
		<option value="tel" ${field == 'tel' ? 'selected' : ''}>전화번호</option>
	</select>
	<input type="text" name="word" value="${word}" placeholder="검색어 입력" />
	<button type="submit">검색</button>
</form>

<br/>

<table border="1">
	<thead>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>주소</th>
		<th>우편번호</th>
		<th>전화번호</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${alist}" var="address">
		<tr>
			<td>${address.num}</td>
			<td><a href="aview?num=${address.num}">${address.name}</a></td>
			<td>${address.address}</td>
			<td>${address.zipcode}</td>
			<td>${address.tel}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>