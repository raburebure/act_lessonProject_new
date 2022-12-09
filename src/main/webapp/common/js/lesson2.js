const transition = document.querySelector(".btnTran1");
const formDOM = document.getElementById("form-section");

//console.log(transition);
//console.log(formDOM);

// ボタンが押下された時の挙動
transition.addEventListener("click", () => {
  sendForm(formDOM, "Lesson2Servlet", "post");
});

// フォーム送信
let sendForm = (form, action, method) => {
  form.action = action;
  form.method = method;
  form.submit();
};
