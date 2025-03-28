<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>상세보기</h3>
<form action="aupdate" method="post">
<%-- <input type="hidden" name="num" value="<%=address.getNum() %>"> --%>
	<table>
		<tr>
			<th>번호</th>
		<%-- 	<td><%=address.getNum() %></td>  --%>
		<td><input type="text" name="num" value="${addr.num}"  readonly="readonly"> </td>
		</tr>	
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" value="${addr.name}" ></td>
		</tr>	
		<tr>
			<th>우편번호</th>
			<td><input type="text" name="zipcode"  id="zipcode" value="${addr.zipcode }"   size=7 >
			<button type="button" onclick="zipfinder()">검색</button>
			</td>
		</tr>	
		<tr>
			<th>주소</th>
			<td><input type="text" name="address" id="address"  value="${addr.address}" size=50></td>
		</tr>	
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="tel"  value="${addr.tel}" ></td>
		</tr>	
		<tr>
			<td colspan="2">
			<button>수정</button>
			<input type="reset" value="수정취소">
			<button type="button" onclick="location.href='adelete?num=${address.num}'">삭제</button>
			<button type="button" onclick="location.href='alist'">전체보기</button>
				<button type="button" onclick="location.href='atoUser?name=${address.name}'">유저보기</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>







