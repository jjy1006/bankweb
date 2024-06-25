<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>계좌개설</title>
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
        input[type="text"], select, textarea {
            width: 100%;
            padding: 8px;
            margin: 4px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="checkbox"] {
            margin-right: 10px;
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
        textarea {
            resize: none;
        }
        span.notice {
            float: right;
            color: red;
            font-weight: bold;
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
            <h2>계좌 만들기</h2>
            <hr>
            <span class="notice">*약관 참조및, 금융상품 목록을 먼저 확인해주세요!!*</span>
            <br>
            <form method="post" name="openAccountForm" action="${pageContext.request.contextPath}/account/open">
                <table>
                    <tr>
                        <th>거래 비밀번호(숫자)</th>
                        <td><input type="text" name="transferPassword"></td>
                    </tr>
                    <tr>
                        <th>계좌별칭</th>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <th>금융상품</th>
                        <td>
                            <select name="productName">
                                <c:forEach items="${products}" var="pro">
                                    <option value="${pro.productName}">${pro.productName}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>
                <br>
                <input type="checkbox">
                <textarea rows="5" cols="30" disabled>개인정보 수집 이용 동의 : 고객님의 계좌 개설 및 금융 서비스 제공을 위해 은행은 신원 확인, 맞춤형 서비스 제공, 법적 의무 준수 등을 목적으로 이름, 연락처, 주민등록번호 등 필수 정보를 수집합니다. 이러한 정보는 계약 기간 동안 사용되며, 법적 요구에 따라 제3자와 공유될 수 있습니다. 고객님은 언제든지 정보 제공 동의를 철회할 수 있으며, 자신의 정보를 열람 및 수정할 권리를 가지고 있습니다. 은행은 고객님의 개인정보를 안전하게 관리하며, 보호를 위해 적절한 보안 조치를 시행합니다.
                </textarea>
                <br>
                <input type="submit" value="계좌개설">
            </form>
            <a href="${pageContext.request.contextPath}/product/viewproduct"><button>금융상품 보기</button></a>
        </div>
    </section><br>
    <footer>
        <jsp:include page="/WEB-INF/views/include/footer.jsp"/>
    </footer>
</body>
</html>
