
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
    </style>
</head>
<body>
    <div class="container">
        <h2>조회결과</h2>
        <h5>글 번호: ${board.boardId}</h5>
        <h5>작성자 : ${board.boardWriter}</h5>
        <h5>제목 : ${board.boardTitle}</h5>
        <h5>내용 : ${board.boardContents}</h5>
        <h5>작성시간 : ${board.boardCreatedDate}</h5>
        <h5>조회수 : ${board.boardHits}</h5>

    </div>
</body>
</html>
