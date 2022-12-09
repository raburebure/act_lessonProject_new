const buttonClose = document.querySelector(".modalClose");
const overlay = document.querySelector(".overlay");
const modal = document.querySelector(".modal");

// オーバーレイとモーダルを表示
const modalOpen = () => {
  overlay.style.display = "block";
  modal.style.display = "block";
};

// 「×」ボタン押下時、モーダルを閉じる
buttonClose.addEventListener("click", ()=>{
	overlay.style.display = "none";
	modal.style.display = "none";
});

// 「モーダル」以外の箇所がクリックされた場合、モーダルを閉じる
document.addEventListener("click", (e) => {
  if (e.target == overlay) {
  	overlay.style.display = "none";
    modal.style.display = "none";
  }
});
