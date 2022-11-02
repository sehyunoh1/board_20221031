
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      margin: auto

    ;

    }
</style>
<html>
<head>
    <title>비밀번호 확인</title>
</head>
<body>
<div id="main">
    <form action="/board/delete" method="get" name="passck">
        <input type="text" placeholder="비밀번호 입력" name="PasswordCk" id="PasswordCk" class="form-control">
        <input type="button" value="삭제" onclick="deleteck(${board.boardPass})" class="btn btn-danger">
    </form>
</div>

</body>
<script>
    const deleteck = () => {
      const PassDB='${board.boardPass}';
      const Pass=document.getElementById("PasswordCk").value;
      console.log(PassDB)
        console.log('${board.boardId}');
      if(Pass==PassDB){
          location.href="/board/delete?boardId="+'${board.boardId}';
      }else{
          alert("비밀번호가 일치하지 않습니다.")
      }
    }
</script>
</html>
