<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>DB通信_非同期処理</title>
    <link
      href="https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="common/css/lesson3.css" />
  </head>
  <body>
    <h1>DB接続</h1>
    <main>
      <section class="req-section">
        <form id="form-section">
          <h2>リクエスト</h2>
          <div>
            <input
              type="text"
              placeholder="社員番号"
              name="employeeNum"
              id="employeeNum"
            />
          </div>
          <div>
            <input
              type="password"
              placeholder="パスワード"
              name="password"
              id="password"
            />
          </div>
          <button type="button" class="btnTran1">次の画面へ</button>
        </form>
      </section>
      <div class="vertical-border"></div>
      <section class="res-section">
        <h2>レスポンス</h2>
        <div>
          <span class="opTitle">名前：</span>
          <span class="opValue" id="employeeName"
            ><%= request.getAttribute("employeeName") == null ? "値がありません"
            : request.getAttribute("employeeName") %></span
          >
        </div>
        <div>
          <span class="opTitle">権限：</span>
          <span class="opValue" id="authority"
            ><%= request.getAttribute("authority") == null ? "値がありません" :
            request.getAttribute("authority") %></span
          >
        </div>
      </section>
    </main>
    <script src="common/js/lesson3.js"></script>
  </body>
</html>
