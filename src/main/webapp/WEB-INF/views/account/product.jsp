<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>금융상품 보기</title>
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
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #003366;
            color: white;
        }
        button {
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
    </header><br>
    <section>
        <div align="center">
            <hr>
            <h2>금융상품 보기</h2>
            <hr>
            <table>
                <tr>
                    <th>상품명</th>
                    <th>상품 유형</th>
                    <th>금리</th>
                    <th>상세 정보</th>
                </tr>
                <tr>
                    <td>가자 여행! 모으자 돈!!</td>
                    <td>정기예금</td>
                    <td>0.1%</td>
                    <td>"가자 여행! 모으자 돈!!"은 여행을 꿈꾸는 고객님을 위한 특별한 적금 상품입니다. 매달 일정 금액을 꾸준히 저축하여 여행 자금을 마련할 수 있도록 설계되었습니다. 높은 이자율과 더불어, 여행 경비에 필요한 다양한 혜택을 제공합니다.</td>
                </tr>
                <tr>
                    <td>야 너도 부자될수 있어!</td>
                    <td>정기 예금</td>
                    <td>0.5%</td>
                    <td>"야 너도 부자될 수 있어!"는 자산을 불리고 싶은 고객님을 위한 특별한 적금 및 투자 상품입니다. 이 상품은 체계적인 저축과 함께 다양한 투자 기회를 제공하여, 고객님의 재정적 목표 달성을 돕습니다.</td>
                </tr>
                <tr>
                    <td>막 땡겨</td>
                    <td>대출</td>
                    <td>6%</td>
                    <td>급하게 필요한 자금을 빠르게 지원하는 대출 상품으로, 고객이 긴장되는 순간에도 신속한 대응을 약속합니다. 간단한 절차와 빠른 승인으로 급한 자금 사정을 해결하고자 하는 분들에게 최적의 선택입니다.</td>
                </tr>
            </table>
            <br>
            <a href="${pageContext.request.contextPath}/account/open"><button>계좌 개설하기</button></a>
        </div>
    </section><br>
    <footer>
        <jsp:include page="/WEB-INF/views/include/footer.jsp"/>
    </footer>
</body>
</html>
