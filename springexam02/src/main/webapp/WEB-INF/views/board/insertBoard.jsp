<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../includes/header.jsp" %>


<div class="container mt-5">
	<h2>Board Write</h2>
	 <form action="insertBoard" method="post" name="frm">
	     <div class="mb-3 mt-3">
	      <label for="userid">User Id:</label>
	      <input type="text" class="form-control" id="userid" placeholder="Enter userid" 
	      name="userid" value="${sessionScope.isPasswordVerified ? sessionScope.verifiedUserId : ''}">
	    </div>
	    
	   <div class="mb-3 mt-3">
	      <label for="subject">Subject:</label>
	      <input type="text" class="form-control" id="subject" placeholder="Enter subject" name="subject">
	    </div>

	    <div class="mb-3">
	     <label for="content">content:</label>
			  <textarea class="form-control" id="content" name="content" 
			   placeholder="Content goes here" rows=5></textarea>
	   </div>

		 <div class="mb-3 mt-3">
			 <label for="password">비밀번호</label>
			 <input type="password" class="form-control" id="password" name="password" required
					value="${sessionScope.isPasswordVerified ? sessionScope.verifiedPassword : ''}"/>
		 </div>
	    
     <div  class="mt-3">
    	<button type="submit" class="btn btn-primary" id="btnSend">글쓰기</button>
    </div>
  </form>
</div>

</body>
</html>