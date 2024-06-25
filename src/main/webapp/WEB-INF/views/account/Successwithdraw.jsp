<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출금 완료</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/form.css">
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
    <header>
        <jsp:include page="/WEB-INF/views/include/topMenu.jsp"/>
    </header><br><br><br><br><br>
    <section>
        <div align="center">
            <hr>
            
            <h2>출금 완료</h2>
            <hr>
            <br>
            <p>출금이 성공적으로 완료되었습니다.</p>
            <p>계좌 번호: ${accNum}</p>
            <p>출금 금액: ${amount}</p>
            <p>현재 잔액: ${newBalance}</p>
            <br>
            <a href="${pageContext.request.contextPath}/account">계좌 목록으로 돌아가기</a>
        </div>
    </section><br>
    <footer>
        <jsp:include page="/WEB-INF/views/include/footer.jsp"/>
    </footer>
</body>
</html>
