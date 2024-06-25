<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>선택된 계좌 조회</title>
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
            <h2>선택된 계좌 정보 및 거래 내역</h2>
            <hr>
            <br>
            <h3>계좌 정보</h3>
            <table>
                <tr>
                    <th>계좌 번호</th>
                    <th>계좌 별칭</th>
                    <th>가입 상품</th>
                    <th>잔액</th>
                    <th>계좌 개설일</th>
                </tr>
                <tr>
                    <td>${account.accountNumber}</td>
                    <td>${account.name}</td>
                    <td>${productName}</td>
                    <td>${account.balance}</td>
                    <td>${account.accountOpeningDate}</td>
                </tr>
            </table>

            <h3>거래 내역</h3>
            <table>
                <tr>
                    <th>거래 일자</th>
                    <th>거래 계좌번호</th>
                    <th>금액</th>
                    <th>잔액</th>
                </tr>
                <!-- 거래 내역을 테이블에 표시 -->
                <c:forEach var="transaction" items="${transactionList}">
                    <tr>
                        <td>${transaction.transactionDatetime}</td>
                        <td>
                        	<c:if test="${account.accountNumber eq transaction.senderAccountnumber}">
	                        	<c:if test="${not empty transaction.receiverAccountnumber}">
                        			${transaction.receiverAccountnumber}
                        		</c:if>
	                        	<c:if test="${empty transaction.receiverAccountnumber}">
                        			ATM
                        		</c:if>
                        	</c:if> 
                        	<c:if test="${account.accountNumber eq transaction.receiverAccountnumber}">
	                        	<c:if test="${not empty transaction.senderAccountnumber}">
	                        		${transaction.senderAccountnumber }
                        		</c:if>
	                        	<c:if test="${empty transaction.senderAccountnumber}">
                        			ATM
                        		</c:if>
                        	</c:if> 
                        </td>
                        <td>
                        	<c:if test="${account.accountNumber eq transaction.senderAccountnumber}">
                        	<p style="color: red;">
                        	- ${transaction.transferAmount}
                        	</p>
                        	</c:if>
                        	<c:if test="${account.accountNumber eq transaction.receiverAccountnumber}">
                        	<p style="color: blue;">
                        	${transaction.transferAmount}
                        	</p>
                        	</c:if>
                        </td>
                        <td>${transaction.afterBalance}</td>
                    </tr>
                </c:forEach>
            </table>
            <c:if test="${empty transactionList}">
                <h3>조회된 거래 내역이 없습니다.</h3>
            </c:if>
        </div>
    </section><br><br><br><br><br>
    <footer>
        <jsp:include page="/WEB-INF/views/include/footer.jsp"/>
    </footer>
</body>
</html>
