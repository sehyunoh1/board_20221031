
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Detail</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
        *{font-family:'Jua', sans-serif;  }
        button{
            width: 100px;
        }
    </style>
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
    <div class="container" name="update">
        <table class="table table-hover">
            <tr>
                <th>글번호</th>
                <td>${board.boardId}</td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${board.boardWriter}</td>
            </tr>
                <tr>
                <th>제목</th>
                <td>${board.boardTitle}</td>
                </tr>
            <tr>
                <th>내용</th>
                <td>${board.boardContents}</td>
            </tr>
            <c:if test="${board.storedFileName != null}">
            <tr>
                <th>file</th>
                <td><img src="${pageContext.request.contextPath}/upload/${board.storedFileName}"
                         alt="" width="100" height="100"> <%-- 상대경로로 경로 찾아가기--%>
                </td>
            </tr>
            </c:if>
            <tr>
                <th>작성시간</th>
                <td>${board.boardCreatedDate}</td>
            </tr>
            <tr>
                <th>조회수</th>
                <td>${board.boardHits}</td>
            </tr>
    </table>
        <button onclick="listFn()" class="btn btn-primary" >목록</button>
        <button onclick="updateFn()" class="btn btn-warning" >수정</button>
        <button onclick="deleteFn()" class="btn btn-danger" >삭제</button>
    </div>
</body>
<script>
    const listFn = () => {
    location.href="/board/";
    }
    const updateFn = () => {
      location.href="/board/update?boardId="+${board.boardId};
    }
    const deleteFn = () => {
       location.href="/board/deleteCheck?boardId="+${board.boardId};
    }
</script>
</html>
