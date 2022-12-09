const transition = document.querySelector(".btnTran1");
let employeeNum = document.getElementById("employeeNum");
let password = document.getElementById("password");

transition.addEventListener("click", () => {
  // HTTPリクエストを発行する（form送信みたいなもの）
  fetch("Lesson3Servlet", {
    method: "POST",
    headers: {
      "Content-Type": "application/json;charset=UTF-8",
    },
    body: JSON.stringify({
      employeeNum: employeeNum.value,
      password: password.value,
    }),
  })
    // 非同期処理の結果を取得する
    .then((response) => response.json())
    .then((data) => {
      console.log(data);

      document.getElementById("employeeName").innerHTML = data.employeeName;
      document.getElementById("authority").innerHTML = data.authority;
    })
    // 非同期処理の一連でエラーが発生した場合
    .catch((err) => {
      console.log(err);
    });
});
