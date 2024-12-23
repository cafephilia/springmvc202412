<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>Pet.jsp파일입니다~</h1>
  <p id="content"></p>
</body>
<script>
  const $p = document.getElementById("content");
  fetch('/api/v1/books')
  .then(r=>r.json())
  .then(d=>{
    d.forEach(book=>{
      $p.innerHTML+=`
      <div>
      책이름 : \${book.title}
      </div>
      `;
    })
  })
</script>
</html>