<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>계좌 조회</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mainst.css">
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
            max-width: 1200px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: center;
        }
        th {
            background-color: #003366;
            color: white;
        }
        h2 {
            margin-bottom: 20px;
        }
        h3 {
            text-align: center;
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
            <h2>계좌 조회</h2>
            <hr>
            <br>
            <!-- 사용자의 모든 계좌를 조회하는 폼 -->
            <table>
                <tr>
                    <th>계좌 번호</th>
                    <th>계좌 별칭</th>
                    <th>가입 상품</th>
                    <th>잔액</th>
                    <th>계좌 개설일</th>
                </tr>
                <!-- 사용자의 각 계좌 정보를 테이블에 표시 -->
	            <c:if test="${not empty accountList}">
	                <c:forEach var="i" begin="0" end="${accountList.size()-1}">
	                    <tr>
	                        <td><a href="${pageContext.request.contextPath}/account/${accountList[i].accountNumber}">${accountList[i].accountNumber}</a></td>
	                        <td>${accountList[i].name}</td>
	                        <td>${productList[i]}</td>
	                        <td>${accountList[i].balance}</td>
	                        <td>${accountList[i].accountOpeningDate}</td>
	                    </tr>
	                </c:forEach>
                </c:if>
            </table>
            <c:if test="${empty accountList}">
                <h3>조회된 계좌가 없습니다.</h3>
            </c:if>
        </div>
    </section><br>
    <footer>
        <jsp:include page="/WEB-INF/views/include/footer.jsp"/>
    </footer>
</body>
</html>
