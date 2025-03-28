<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp" %>
<div class="container mt-5">
	<h2>Board VIEW</h2>
	<input type="hidden" name="num" id="num" value="${board.num }">
	<table class="table table-hover">
		<tr>
			<th>글번호</th>
			<td>${board.num }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${board.userid }</td>
			<th>작성일</th>
			<td>${board.regdate }</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td colspan="3">${board.subject }</td>
		</tr>
		<tr>
			<th>내용</th>
		<td colspan="3">${board.content }</td>
		</tr>
	</table>
		<button type="button" class="btn btn-primary"
		 onclick="location.href='updateBoard?num=${board.num}'">수정</button>
		<button type="button" class="btn btn-secondary" id="btnDelete" onclick="location.href='deleteBoard?num${board.num}'">삭제</button>

</div>

<div class = "container mt-3">
   <label for="msg">msg:</label>
  <textarea class="form-control" id="msg" name="msg" 
			   placeholder="Content goes here" rows=5></textarea>
<button class="btn btn-success btn-sm mt-3" id="btnComment">Comment Write</button>

<div class="mt-3">Comment()</div>
<div id="result"></div>
</div>
<script>
const init = function(){
	$.getJSON("cList.do",
			{bnum : $("#num").val()},
			function(resp){
				let str="<table class='table table-hover'>"
				
				$.each(resp.jarr, function(key, val){
					str += "<tr>"
					str += "<td>"+val.msg+"</td>"
					str += "<td>"+val.userid
					str += "<td>"+val.regdate+"</td>"
					str += "</tr>"
				})
				
				str +="</table>"
				$(".cntSpan").html(resp.count);
				$("#result").html(str);
			} //콜백함수
	); //getJSON
	
}
$("#btnDelete").click(function(){
	if(confirm("정말 삭제할까요?")){  //확인버튼 클릭
		location.href="deleteBoard?num="+${board.num};
	}
})//btnDelete
$("#btnComment").click(function(){
	if($("#msg").val() == ""){
		alert("메세지를 입력하세요");
		return;
	}
	$.ajax({
		type:"post",
		url : "insertComment",
		data : {
			msg :$("#msg").val(),
			bnum : $("#num").val()
		}
	}) //ajax
	.done(function(resp){
		if(resp.trim() ==1){
			alert("로그인하세요")
			location.href="/member/login.do";
		}else{
			alert("성공")
			$("#msg").val("")
			init()
		}
	})
	.fail(function(e){
		alert("error : "+e);
	})
})

init()
</script>

</body>
</html>




