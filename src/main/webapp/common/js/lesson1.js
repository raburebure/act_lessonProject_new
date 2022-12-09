// 指定したセレクタに一致する要素を取得
const transition = document.querySelector(".btnTran1");
// 指定したIDに一致する要素を取得
const formDOM = document.getElementById("form-section");

// ボタンがクリックされた場合、form情報をサーブレットに送る。
transition.addEventListener("click", () => {
  // フォーム送信処理を実行する関数を呼び出す。
  sendForm(formDOM, "Lesson1Servlet", "post");
});

// フォームの送信処理
let sendForm = (form, action, method) => {
  form.action = action;
  form.method = method;
  form.submit();
};
