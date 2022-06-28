<template>
    <div class="page">
      <!-- <Header></Header> -->
        <div class="container">
      <label class="label"><b>Авторизация</b></label>
      <span>
        <input type="text" placeholder="Логин" v-model="login" required>
      </span>
      <span>
        <input type="password" placeholder="Пароль" v-model="password" required>
      </span>
      <span>
        <button @click="Login()">Авторизироваться</button>
      </span>

      <span>
        <!-- <button @click="showModal" class="button__text">Нет аккаунта?</button> -->
        <a @click="ShowModalRegistration()">Нет аккаунта?</a>
      </span>
    </div>
    <!-- </form> -->
    <!-- <ModalWindowInformation ref="modalInformation" :message="this.message">
    </ModalWindowInformation> -->

    <ModalRegistration ref="modalRegistration">
            <template v-slot:body>
        <input type="text" placeholder="Логин" v-model="login" required>
        <input type="email" placeholder="Почта" v-model="email" required>
        <input type="text" placeholder="Имя" v-model="firstName" required>
         <input type="text" placeholder="Отчество" v-model="patronymic" required>
          <input type="text" placeholder="Фамилия" v-model="lastName" required>
           <input type="password" placeholder="Пароль" v-model="password" required>
      </template>
      <template v-slot:footer>
        <button type="submit" @click="Registration()">Зарегистрироваться</button>
      </template>
    </ModalRegistration>
    </div>
</template>

<script>
import router from "../router/index";
import axios from "axios";
import ModalRegistration from "../modalWindows/ModalRegistration.vue"
// import Header from "../components/header/header.vue"

export default {
   name: 'LoginPage',
   components:{
    ModalRegistration
   },
   data() {
      return {
        login: "",
        password: "",
        email: "",
        firstName: "",
        patronymic: "",
        lastName: "",
        message: ""
      }
    },
   methods: {
    Login(){
      //
      router.replace("/home");
    },
    Registration(){
      //
    },
    ShowModalRegistration(){
      this.password = "";
      this.$refs.modalRegistration.show = true;
    },
    CloseModalRegistration() {
        this.$refs.modalRegistration.show = false;
      },
   },
}
</script>

<style lang="scss">
  .page {
    position: absolute;
    top: 0;
    left: 0;
    min-height: 100%;
    width: 100%;
  }
  .container {
    min-width: 420px;
    max-width: 480px;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  }
  /* Full-width inputs */
  input[type="text"],
  input[type="password"],
  input[type="email"] {
    width: 350px;
    height: 48px;
    background: #b5f8ffb6;
    border-radius: 60px;
    padding: 12px 20px;
    margin: 13px 0;
    color: #2D2D2DA6;
    font-size: 20px;
    border: 1px solid #ccc;
    box-sizing: border-box;
  }
  .label {
    font-family: 'Inter';
    font-style: normal;
    font-weight: 400;
    font-size: 32px;
    line-height: 39px;
    text-align: center;
    margin: 26px;
  }
  a {
    text-decoration: underline;
    font-size: 18px;
    cursor: pointer;
  }
  button {
    background: #7df0fd;
    border-radius: 60px;
    color: #323232;
    font-size: 20px;
    padding: 14px 20px;
    margin: 13px 0;
    border: none;
    cursor: pointer;
    width: 250px;
    height: 52px;
  }
  button:hover {
    opacity: 0.8;
  }
  .container {
    padding: 16px;
    display: flex;
    flex-direction: column;
  }
  @media screen and (max-width: 400px) {
    input[type="text"],
    input[type="password"],
    input[type="email"] {
      width: 230px;
      margin: 5px;
    }
    button {
      font-size: 18px;
      width: 230px;
    }
  }
</style>