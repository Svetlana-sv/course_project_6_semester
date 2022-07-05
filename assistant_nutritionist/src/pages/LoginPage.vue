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
        <input type="text" placeholder="Логин" v-model="user.login" required>
        <input type="email" placeholder="Почта" v-model="user.email" required>
        <input type="text" placeholder="Имя" v-model="user.first_name" required>
        <input type="text" placeholder="Отчество" v-model="user.patronymic" required>
        <input type="text" placeholder="Фамилия" v-model="user.last_name" required>
        <input type="password" placeholder="Пароль" v-model="user.password" required>
      </template>
      <template v-slot:footer>
        <button type="submit" @click="Registration()">Зарегистрироваться</button>
      </template>
    </ModalRegistration>

    <ModalWindow ref="modalWindow">
        <template v-slot:title>
        <h3>Информация!</h3>
      </template>
      <template v-slot:body>
        <p>{{message}}</p>
      </template>
    </ModalWindow>


  </div>
</template>

<script>
  import router from "../router/index";
  import axios from "axios";
  import ModalRegistration from "../modalWindows/ModalRegistration.vue"
  import ModalWindow from "../modalWindows/ModalInformation.vue"

  export default {
    name: 'LoginPage',
    components: {
      ModalRegistration,
      ModalWindow
    },
    data() {
      return {
        login: "",
        password: "",
        user: {
          login: "",
          email: "",
          password: "",
          first_name: "",
          patronymic: "",
          last_name: "",
        },
        message: ""
      }
    },
    methods: {
      Login() {
        this.$store.dispatch("AUTHORIZATION", this.login, this.password);
        //при регистрации надо создать строку в Parameters
        this.login = "";
        this.password = "";
      },
      Registration() {
        var axios = require('axios');
        var data = JSON.stringify(this.user);
        var vm = this;
        console.log(data);

        var config = {
          method: 'post',
          url: 'http://' + this.$store.getters.ip + '/user/register',
          headers: {
            'Content-Type': 'application/json'
          },
          data: data
        };

        axios(config)
          .then(function (response) {
            console.log(JSON.stringify(response.data));
            vm.CloseModalRegistration();
            vm.message = "Регистрация успешно завершена!"
            vm.ShowModalWindow();
          })
          .catch(function (error) {
            console.log(error);
            vm.CloseModalRegistration();
            vm.message = "Ошибка! Повторите попытку."
            vm.ShowModalWindow();
          });
      },
      ShowModalRegistration() {
        this.password = "";
        this.$refs.modalRegistration.show = true;
      },
      CloseModalRegistration() {
        this.$refs.modalRegistration.show = false;
      },
      ShowModalWindow() {
        this.$refs.modalWindow.show = true;
      },
      CloseModalWindow() {
        this.$refs.modalWindow.show = false;
      },
    },
  }
</script>

<style scoped lang="scss">
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
    background-color: #6aaba579;
    border-radius: 60px;
    padding: 12px 20px;
    margin: 13px 0;
    color: #2D2D2DA6;
    font-size: 20px;
    border: 1px solid #ccc;
    box-sizing: border-box;

    @media screen and (max-width: 400px) {
      min-width: 200px;
      max-width: 220px;

    }
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
    background: rgba(217, 217, 217, 1);
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