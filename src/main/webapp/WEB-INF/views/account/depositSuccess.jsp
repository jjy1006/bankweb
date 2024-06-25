<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }

    h1 {
        text-align: center;
        color: #003366;
        margin-top: 100px;
    }

    button {
        display: block;
        margin: 20px auto;
        padding: 10px 20px;
        background-color: #003366;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background-color: #001a33;
    }
</style>
</head>
<body>
	<h1>입금 되었습니다.</h1>
	<a href="${pageContext.request.contextPath}"><button>홈으로 돌아가기</button></a>
</body>
</html>