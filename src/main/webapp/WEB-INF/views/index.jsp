
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
    <style>
      *{font-family:'Jua', sans-serif;  }
      #main {
        font-size: 60px;
        text-align: center;
        margin-top: 50px;
      }
      button{
        width: 300px;
        height: 200px;
      }
      #list{
        margin-left: 50px;
      }
    </style>
  </head>
  <body>
  <jsp:include page="layout/header.jsp" flush="false"></jsp:include>
  <div class="container" id="main">
   <button class="btn btn-primary" onclick="saveFn()">글 작성</button>
   <button class="btn btn-warning" onclick="listFn()" id="list">글 목록</button>
  </div>
  </body>
  <script>
    const saveFn = () => {
      location.href="/board/save";
    }
    const listFn = () => {
      location.href="/board/";
    }
  </script>
</html>
