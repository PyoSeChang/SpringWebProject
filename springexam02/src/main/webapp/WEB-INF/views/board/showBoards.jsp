<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file ="../includes/header.jsp" %>

<script>
	$(function(){
		$("#btnWrite").click(function(){
			if (${empty sessionScope.suser}) {
				alert("로그인하세요");
				location.href = "/member/login.do";
				return false;
			}
			location.href = "/board/insertBoard";
		});
	});
</script>

<div class="container mt-5">
	<h2>Board LIST (${count})</h2>

	<div class="mt-5 mb-3">
		<button class="btn btn-secondary" id="btnWrite">글쓰기</button>
	</div>

	<table class="table table-hover">
		<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>댓글</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${boardList}" var="board" varStatus="st">
			<tr>
				<!-- 번호: offset + index + 1 -->
				<td>${(page - 1) * 10 + st.index + 1}</td>
				<td>
					<a href="showBoardDetail?num=${board.num}">
							${board.subject}
					</a>
				</td>
				<td>${board.userid}</td>
				<td>
					<c:choose>
						<c:when test="${not empty board.updatedate}">
							${board.updatedate} <span class="text-muted">(수정됨)</span>
						</c:when>
						<c:otherwise>
							${board.regdate}
						</c:otherwise>
					</c:choose>
				</td>
				<td>${board.readcount}</td>
				<td>${board.commentcount}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="mb-3">
		<form action="/board/resetAllBoardSession" method="get">
			<button type="submit">🧹 전체 세션 초기화</button>
		</form>
	</div>

	<!-- ✅ 페이징 영역 -->
	<div class="d-flex justify-content-between mt-3">
		<ul class="pagination">
			<!-- 이전 -->
			<c:if test="${page > 1}">
				<li class="page-item">
					<a class="page-link"
					   href="showBoards?category=${category}&page=${page - 1}&searchField=${searchField}&searchWord=${searchWord}">Previous</a>
				</li>
			</c:if>

			<!-- 페이지 번호 -->
			<c:forEach begin="1" end="${totalPages}" var="i">
				<li class="page-item ${page == i ? 'active' : ''}">
					<a class="page-link"
					   href="showBoards?category=${category}&page=${i}&searchField=${searchField}&searchWord=${searchWord}">
							${i}
					</a>
				</li>
			</c:forEach>

			<!-- 다음 -->
			<c:if test="${page < totalPages}">
				<li class="page-item">
					<a class="page-link"
					   href="showBoards?category=${category}&page=${page + 1}&searchField=${searchField}&searchWord=${searchWord}">Next</a>
				</li>
			</c:if>
		</ul>

		<!-- 검색 폼 -->
		<form class="d-inline-flex" action="showBoards" method="get">
			<input type="hidden" name="category" value="${category}" />
			<select class="form-select" name="searchField">
				<option value="title" ${searchField == 'title' ? 'selected' : ''}>제목</option>
				<option value="content" ${searchField == 'content' ? 'selected' : ''}>내용</option>
				<option value="userid" ${searchField == 'userid' ? 'selected' : ''}>작성자</option>
			</select>
			<input type="text" class="form-control" name="searchWord" value="${searchWord}">
			<button type="submit" class="btn btn-success btn-sm">Search</button>
		</form>
	</div>
</div>

</body>
</html>
