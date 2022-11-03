<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        *{font-family:'Jua', sans-serif;  }
        #list {
            width: 800px;
            font-size: 30px;
            text-align: center;
            margin: auto;
            margin-top: 50px;
        }

    </style>
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
<div id="list" class="container">
    <table class="table table-striped table-hover text-center">
        <tr>
            <th>글 번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>작성 시간</th>
            <th>조회수</th>
        </tr>
        <c:forEach items="${boardList}" var="board">
            <tr>
                <td>
                    ${board.boardId}
                </td>
                <td>${board.boardWriter}</td>
                <td><a href="/board?boardId=${board.boardId}">${board.boardTitle}</a></td>
                <td>
                    <fmt:formatDate value="${board.boardCreatedDate}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                </td>
                <td >${board.boardHits}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
