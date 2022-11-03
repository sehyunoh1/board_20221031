<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
@@ -15,27 +16,46 @@--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<header class="p-3 text-bg-dark">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                    <use xlink:href="#bootstrap"/>
                </svg>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="/" class="nav-link px-2 text-secondary">Home</a></li>
                <li><a href="/board/save" class="nav-link px-2 text-white">글작성</a></li>
                <li><a href="/board/" class="nav-link px-2 text-white">글목록</a></li>
<%--                <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>--%>
<%--                <li><a href="#" class="nav-link px-2 text-white">About</a></li>--%>
<%--                <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>--%>
<%--                <li><a href="#" class="nav-link px-2 text-white">About</a></li>--%>
</ul>

<form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
  <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..."
         aria-label="Search">
</form>

<div class="text-end">

  <c:choose>
    <c:when test="${sessionScope.loginEmail != null}">
      <span>${sessionScope.loginEmail}님</span>
      <button type="button" onclick="logout()" class="btn btn-outline-light me-2">Logout</button>
    </c:when>
    <c:otherwise>
      <button type="button" onclick="login()" class="btn btn-outline-light me-2">Login</button>
      <button type="button" class="btn btn-warning">Sign-up</button>
    </c:otherwise>
  </c:choose>
</div>
</div>
</div>
</header>
</body>
<script>
  const login = () => {
    location.href = "/login";
  }
  const logout = () => {
    location.href = "/logout";
  }
</script>
</html>