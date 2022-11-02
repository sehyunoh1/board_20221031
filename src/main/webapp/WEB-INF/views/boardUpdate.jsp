
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  <style>
    *{font-family:'Jua', sans-serif;  }
    #update {
      width: 600px;
      margin-top: 100px;
    }
    #Contents{
      height: 500px;
    }
  </style>
</head>
<body>
  <div class="container" id="update">
    <form action="/board/update" name="updateform" method="post">
      <input type="text" name="BoardId" value="${board.boardId}" class="form-control" readonly>
      <input type="text" name="BoardWriter" value="${board.boardWriter}" class="form-control" readonly>
      <input type="text" name="BoardPass" placeholder="비밀번호" class="form-control" id="Pass" >
      <input type="text" name="BoardTitle" value="${board.boardTitle}" class="form-control" >
      <textarea type="text" name="BoardContents" value="${board.boardContents}" class="form-control" id="Contents"></textarea>
      <input type="text" name="BoardHits" value="${board.boardHits}" class="form-control" readonly>
      <input type="button" class="btn btn-primary" onclick="updateBoard()" value="수정하기">
    </form>

  </div>
</body>
<script>
  const updateBoard = () => {
      const PassDB='${board.boardPass}';
      const Pass = document.getElementById("Pass").value;
    if(Pass==PassDB) {
      document.updateform.submit();
    }else{
      alert("비밀번호가 일치하지 않습니다.")
    }
  }
</script>
</html>
