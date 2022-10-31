
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
  <style>
    *{font-family:'Jua', sans-serif;  }
    #main {
      width: 300px;
      font-size: 30px;
      text-align: center;
      margin: auto;
      margin-top: 50px;
    }
  </style>
</head>
<body>
  <div class="container" id="main">
    <form action="/board/save" method="post" name="saveform">
      <input type="text" id="Writer" name="boardWriter" class="form-control" placeholder="작성자 이름">
      <input type="text" id="Pass" name="boardPass" class="form-control" placeholder="비밀번호">
      <input type="text" id="Title" name="boardTitle" class="form-control" placeholder="글 제목">
      <input type="text" id="Contents" name="boardContents" class="form-control" placeholder="글 내용">
      <input type="button" value="제출하기" onclick="save()" class="btn btn-primary">
    </form>
  </div>
</body>
<script>
  const save = () => {
    if (document.saveform.boardWriter.value == ""){
    alert("작성자를 입력해주세요.")
      return false;
    }else if(document.saveform.boardPass.value == ""){
      alert("비밀번호를 입력해주세요")
      return false;
    }
    alert("글 작성이 완료되었습니다.")
  document.saveform.submit();
  }
</script>
</html>
