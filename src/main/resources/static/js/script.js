"use strict";
const backToLogin = document.querySelector(".back img");
const toRegister = document.querySelector(".to-register");
const login = document.querySelector(".login-container");
const register = document.querySelector(".register-container");

toRegister.addEventListener("click", function () {
  login.classList.add("register-container");
  register.classList.remove("register-container");
});
backToLogin.addEventListener("click", function () {
  login.classList.remove("register-container");
  register.classList.add("register-container");
});
