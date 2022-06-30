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
                <input type="text" placeholder="Рост" v-model="firstName">
                <input type="text" placeholder="Вес" v-model="patronymic">
                <input type="text" placeholder="Возраст" v-model="lastName">
            </div>

            <div class="container">
                <div class="title">Нормы</div>
                <input type="text" placeholder="Норма калорий" v-model="firstName">
                <input type="text" placeholder="Норма воды" v-model="patronymic">
                Нормы макронутриентов
                <input type="text" placeholder="Углеводы" v-model="lastName">
                <input type="text" placeholder="Белки" v-model="lastName">
                <input type="text" placeholder="Жиры" v-model="lastName">
            </div>

            <div>
                <button class="btn__save" @click="SaveData()">Сохранить</button>
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
        },
        methods: {
            SaveData(){
                
            }
        },
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
                background: linear-gradient(0deg, #EDF1F1, #EDF1F1), linear-gradient(0deg, #EDF1F1, #EDF1F1), linear-gradient(0deg, #EDF1F1, #EDF1F1), #EDF1F1;
                box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
                border-radius: 45px;
                min-width: 500px;
                max-width: 600px;
                padding: 20px;
                display: flex;
                margin: 15px;
                flex-direction: column;

                 @media screen and (max-width: 400px) {
            min-width: 200px;
            max-width: 300px;


    }

                input[type="text"],
                input[type="password"],
                input[type="email"] {
                    // width: 300px;
                    height: 35px;
                    background: #D9D9D9;
                    border-radius: 60px;
                    padding: 5px 10px;
                    margin: 13px 0;
                    color: #2D2D2DA6;
                    font-size: 16px;
                    border: 1px solid #ccc;
                    box-sizing: border-box;
                }

                
            }

            .btn__save {
                    height: 40px;
                    width: 90px;
                    margin-top: 10px;
                    margin-bottom: 20px;
                    border: none;
                    background: rgba(217, 217, 217, 1);
                    border-radius: 30px;
                    color: rgba(0, 0, 0, 1);
                }
        }
    }
</style>