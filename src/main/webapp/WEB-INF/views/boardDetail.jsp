
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h2>조회결과</h2>
        <h5>글 번호: ${board.boardId}</h5>
        <h5>작성자 : ${board.boardWriter}</h5>
        <h5>제목 : ${board.boardTitle}</h5>
        <h5>내용 : ${board.boardContents}</h5>
        <h5>작성시간 : ${board.boardCreatedDate}</h5>
        <h5>조회수 : ${board.boardHits}</h5>
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
