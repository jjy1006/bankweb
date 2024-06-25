<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>출금</title>
   	<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/mainst.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #003366;
            color: white;
            padding: 15px 0;
            text-align: center;
        }
        section {
            padding: 20px;
            margin: 20px auto;
            background-color: white;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 800px;
        }
        h2 {
            margin-bottom: 20px;
        }
        form {
            text-align: left;
            background-color: silver;
            width: 600px;
            padding: 20px;
        }
        label {
            margin-bottom: 10px;
            display: inline-block;
        }
        input[type="number"], input[type="password"] {
            padding: 8px;
            margin-bottom: 10px;
            width: 100%;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #003366;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #001a33;
        }
    </style>
</head>
<body>
    <header>
        <jsp:include page="/WEB-INF/views/include/topMenu.jsp"/>
    </header><br>
    <section>
        <div align="center">
            <hr>
            <h2>출금</h2>
            <hr>
        	<h5 style="color: red; float: right;">잔액 부족, 비밀번호 불일치 시 다시 돌아옵니다</h5>
            <br>
            <br>
            <br>
            <!-- 출금을 위한 폼 -->
            <form action="${pageContext.request.contextPath}/account/withdraw" method="post">
                <label for="accNum">계좌 번호:</label>
                <input type="number" name="accNum"  required><br><br>
                <label for="amount">출금액:</label>
                <input type="number" name="amount" required><br><br>
                <label for="transferPassword">거래 비밀번호:</label>
                <input type="password" name="transferPassword" required><br><br>
                <input type="submit" value="출금">
            </form>
        </div>
    </section><br>
    <footer>
        <jsp:include page="/WEB-INF/views/include/footer.jsp"/>
    </footer>
</body>
</html>
