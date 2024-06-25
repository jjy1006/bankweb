<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌이체</title>
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
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        max-width: 600px;
    }

    h2 {
        margin-bottom: 20px;
        color: #003366;
    }

    form {
        text-align: left;
    }

    input[type="text"] {
        width: 100%;
        padding: 8px;
        margin: 4px 0;
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
            <h2>계좌이체</h2>
            <hr>
            <br>
            <!-- 이체을 위한 폼 -->
            <form action="${pageContext.request.contextPath}/account/sendMoney" method="post">
                보낼 계좌번호 : <input type="text" name="senderAccNum" required><br><br>
                받을 계좌번호 : <input type="text" name="receiverAccNum" required><br><br>
                이체액 : <input type="text" name="amount" required><br><br>
                이체 비밀번호 : <input type="password" name="PW" required><h6>비밀번호 불일치 시 다시 계좌이체 페이지로 돌아옵니다.</h6><br><br><br>
                <input type="submit" value="이체"><br><br>
            </form>
        </div>
    </section><br>
    <footer>
        <jsp:include page="/WEB-INF/views/include/footer.jsp"/>
    </footer>
</body>
</html>
