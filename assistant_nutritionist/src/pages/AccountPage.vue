<template>
    <div class="page">
        <Header></Header>

        <div class="page__account">

            <div class="container">
                <div class="title">Аккаунт</div>
                <input type="text" placeholder="Имя" v-model="firstName" required>
                <input type="text" placeholder="Отчество" v-model="patronymic" required>
                <input type="text" placeholder="Фамилия" v-model="lastName" required>
            </div>

            <div class="container">
                 <div class="title">Личные данные</div>
                <input type="text" placeholder="Рост" v-model="firstName" required>
                <input type="text" placeholder="Вес" v-model="patronymic" required>
                <input type="text" placeholder="Возраст" v-model="lastName" required>
            </div>

            <div class="container">
                 <div class="title">Нормы</div>
                <input type="text" placeholder="Имя" v-model="firstName" required>
                <input type="text" placeholder="Отчество" v-model="patronymic" required>
                <input type="text" placeholder="Фамилия" v-model="lastName" required>
            </div>

            <div>
                <button>Сохранить</button>
            </div>
        </div>
    </div>
</template>

<script>
    import router from "../router/index";
    import axios from "axios";
    import Header from "../components/header/header.vue"

    export default {
        name: 'AccountPage',
        components: {
            Header
        }
    }
</script>

<style scoped lang="scss">
    .page {
        min-height: 100%;
        width: 100%;

        .page__account {
            display: flex;
            width: 100%;
            flex-direction: column;
            justify-content: center;
            text-align: center;
            align-items: center;

            .container {
                background-color: rgb(229, 236, 236);
                min-width: 500px;
                max-width: 600px;
                padding: 20px;
                display: flex;
                margin: 10px;
                flex-direction: column;

                input[type="text"],
                input[type="password"],
                input[type="email"] {
                    width: 300px;
                    height: 40px;
                    background: #c4eaeeb6;
                    border-radius: 60px;
                    padding: 12px 20px;
                    margin: 13px 0;
                    color: #2D2D2DA6;
                    font-size: 20px;
                    border: 1px solid #ccc;
                    box-sizing: border-box;
                }
            }
        }
    }
</style>