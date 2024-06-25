<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" 
	href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" 
	href="${ pageContext.request.contextPath }/resources/css/table.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#addBtn').click(function() {
			location.href = "${ pageContext.request.contextPath }/board/write"
		})
	})

/*
	window.onload = function() {
		let addBtn = document.getElementById("addBtn")
		addBtn.addEventListener('click', function() {
			alert('click...')
		})
	}
*/	
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/views/include/topMenu.jsp"/>
	</header><br>
	<section>
		<div align="center">
			<hr>
			<h1>전체 게시판</h1>
			<hr>
			<br>
			<table class="list">
				<tr>
					<th width="7%">번호</th>
					<th>제목</th>
					<th width="21%">작성자</th>
					<th width="25%">등록일</th>
				</tr>
				<c:forEach items="${ list }" var="board">
					<tr>
						<td>${ board.no }</td>
						<td>
							<a href="${ pageContext.request.contextPath }/board/${ board.no }">
								${ board.title }
							</a>
						</td>					
						<td>${ board.writer }</td>
						<td>${ board.regDate }</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<button type="button" id="addBtn">새글등록</button>
			
		</div>
	</section><br>
	<footer>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
	</footer>
</body>
</html>








