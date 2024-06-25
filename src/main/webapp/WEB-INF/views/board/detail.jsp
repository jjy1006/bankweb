<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
	<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/table.css">
</head>
<body>

	<header>
		<jsp:include page="/WEB-INF/views/include/topMenu.jsp"/>
	</header><br>
	<section>

		<div align="center">
			<hr>
			<h2>상세게시글 조회</h2>
			<hr>
			<br>
			<table>
				<tr>
					<th width="25%">번호</th>
					<td>${ board.no }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${ board.title }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${ board.writer }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${ board.content }</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${ board.viewCnt }</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td>${ board.regDate }</td>
				</tr>
			</table>
		</div>
	</section><br>
	<footer>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
	</footer>
</body>
</html>


