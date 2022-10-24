const header = document.querySelector("header");
const adBoard = document.querySelector(".adBoard-wrapper");
const toMain = document.querySelector(".repassword-container img");
const repassword = document.querySelector(".repassword-container");
const editBtn = document.querySelector(".edit");
const blur = document.querySelector(".blur");
editBtn.addEventListener("click", function () {

    repassword.classList.remove("hidden");
    adBoard.classList.add("blur");
    header.classList.add("blur");
});

editBtn.addEventListener("click", function () {
    repassword.classList.add("hidden");
    adBoard.classList.remove("blur");
    header.classList.remove("blur");
});
