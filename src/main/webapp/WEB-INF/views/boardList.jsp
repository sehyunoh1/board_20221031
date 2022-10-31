<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        #main {
            width: 300px;
            font-size: 30px;
            text-align: center;
            margin: auto;
            margin-top: 50px;
        }
        td,th{
            border: 1px solid black;
            border-collapse: collapse;
            height: auto;
            width:350px;
            margin: auto;
            padding: 10px;
        }
    </style>
</head>
<body>
<div id="main" class="container">
    <table>
        <tr>
            <th>제목</th>
            <th>작성자</th>
            <th>작성 시간</th>
            <th>삭제</th>
            <th>조회</th>
        </tr>
        <c:forEach items="${boardList}" var="board">
            <tr>
                <td>
                    <a href="/board?boardId=${board.boardId}">${board.boardId}</a>
                </td>
                <td>${board.boardWriter}</td>
                <td>${board.boardCreatedDate}</td>
               <td>
                    <button class="btn btn-danger" onclick="deleteBoard('${board.boardId}')">삭제</button>
                </td>
<%--                <td>--%>
<%--                    <button class="btn btn-primary" onclick="findMember('${board.boardId}')">조회</button>--%>
<%--                </td>--%>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
<script>
    const deleteBoard = (clickedId) => {
      location.href="/delete?boardId=" + clickedId;
      alert("삭제가 완료되었습니다.")
    }
</script>
</html>
