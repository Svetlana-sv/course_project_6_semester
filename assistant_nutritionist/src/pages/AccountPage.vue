<template>
    <div class="page">
        <Header></Header>

        <div class="page__account">

            <!-- <div class="container">
                <div class="title">Аккаунт</div>
                <input type="text" placeholder="Имя" v-model="firstName" required>
                <input type="text" placeholder="Отчество" v-model="patronymic" required>
                <input type="text" placeholder="Фамилия" v-model="lastName" required>
            </div> -->

            <div class="container">
                <div class="title">Личные данные</div>
                <input type="text" placeholder="Рост" v-model="parameters.height">
                <input type="text" placeholder="Вес" v-model="parameters.weight">
                <input type="text" placeholder="Возраст" v-model="parameters.age">
                <input type="text" placeholder="Пол (ж,м)" v-model="parameters.gender">
            </div>

            <div class="container">
                <div class="title">Нормы</div>
                <input type="text" placeholder="Норма калорий" v-model="parameters.calorie_norm">
                <input type="text" placeholder="Норма воды" v-model="parameters.water_norm">
                Нормы макронутриентов
                <input type="text" placeholder="Углеводы" v-model="parameters.carbohydrate_norm">
                <input type="text" placeholder="Белки" v-model="parameters.protein_norm">
                <input type="text" placeholder="Жиры" v-model="parameters.fat_norm">
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
        data() {
            return {
                parameters: {
                    height: 0,
                    weight: 0,
                    age: 0,
                    gender: "",
                    calorie_norm: 0,
                    water_norm: 0,
                    carbohydrate_norm: 0,
                    protein_norm: 0,
                    fat_norm: 0,
                }
                // parameters: this.$store.getters.parameters
            }
        },
        methods: {
            SaveData() {
                var axios = require('axios');
                var data = JSON.stringify(this.parameters);
                var vm = this;
                var config = {
                    method: 'post',
                    url: 'http://' + this.$store.getters.ip + '/user/changeParameters?userId=' + this.$store.getters
                        .userId,
                    headers: {
                        'Content-Type': 'application/json',
                        'Cookie': 'JSESSIONID=4A126999079A863B53FED9D774DF8FDF'
                    },
                    data: data
                };

                axios(config)
                    .then(function (response) {
                        console.log(JSON.stringify(response.data));
                        vm.$store.dispatch("GETPARAMETERS"); 
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            getParameters() {
               this.$store.dispatch("GETPARAMETERS"); 
               this.parameters = this.$store.getters.parameters;
               console.log(this.$store.getters.parameters);
                   
            },
            calorieCalculation() {
                if (this.parameters.gender == "ж") {
                    this.parameters.calorie_norm = 10 * this.parameters.weight + 6.25 * this.parameters.height - 5 *
                        this.parameters.age - 161;
                } else if (this.parameters.gender == "м") {
                    this.parameters.calorie_norm = 10 * this.parameters.weight + 6.25 * this.parameters.height - 5 *
                        this.parameters.age + 5;
                }
                this.parameters.carbohydrate_norm = Math.round(((this.parameters.calorie_norm * 0.4) / 4), -1);
                this.parameters.protein_norm = Math.round(((this.parameters.calorie_norm * 0.3) / 4), - 1);
                this.parameters.fat_norm = Math.round(((this.parameters.calorie_norm * 0.3) / 9), - 1)


            }
        },
        created() {
            this.getParameters();


        },
        watch: {
            'parameters.calorie_norm'() {
                if (this.parameters.calorie_norm == 0 || this.parameters.calorie_norm == null || this.parameters
                    .calorie_norm == "") {
                    this.calorieCalculation();
                }
            },
            'parameters.height'() {
                this.calorieCalculation();
            },
            'parameters.weight'() {
                this.calorieCalculation();
            },
            'parameters.age'() {
                this.calorieCalculation();
            },
            'parameters.gender'() {
                this.calorieCalculation();
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

                @media screen and (max-width: 500px) {
                    min-width: 200px;
                    max-width: 400px;


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