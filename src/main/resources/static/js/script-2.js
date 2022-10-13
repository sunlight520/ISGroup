"use strict";
const header = document.querySelector("header");
const adBoard = document.querySelector(".adBoard-wrapper");
const toMain = document.querySelector(".repassword-container img");
const repassword = document.querySelector(".repassword-container");
const repasswordBtn = document.querySelector(".nav__item:nth-child(3)");
const blur = document.querySelector(".blur");
repasswordBtn.addEventListener("click", function () {
  repassword.classList.remove("hidden");
  adBoard.classList.add("blur");
  header.classList.add("blur");
});

toMain.addEventListener("click", function () {
  repassword.classList.add("hidden");
  adBoard.classList.remove("blur");
  header.classList.remove("blur");
});
