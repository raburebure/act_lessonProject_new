<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>画面遷移</title>
<link rel="stylesheet" href="common/css/lesson1.css" />
</head>
<body>
  <form action="post">
    <h1>画面1_遷移後</h1>
    <h2>画面遷移しました。あなたが入力した値は</h2>
    <p><%=request.getAttribute("output1")%></p>
  </form>
</body>
</html>