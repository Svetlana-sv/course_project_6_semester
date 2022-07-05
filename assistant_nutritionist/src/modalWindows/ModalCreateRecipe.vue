<template>
    <div v-if="show" class="modal-shadow" @click.self="closeModal">
        <div class="modal">
            <div class="modal-close" @click="closeModal">
                <svg width="36" height="36" viewBox="0 0 36 36" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path
                        d="M24.8236 18L35.0581 7.76557C36.314 6.50966 36.314 4.47341 35.0581 3.21648L32.7835 0.941932C31.5276 -0.313977 29.4914 -0.313977 28.2344 0.941932L18 11.1764L7.76557 0.941932C6.50966 -0.313977 4.47341 -0.313977 3.21648 0.941932L0.941932 3.21648C-0.313977 4.47239 -0.313977 6.50864 0.941932 7.76557L11.1764 18L0.941932 28.2344C-0.313977 29.4903 -0.313977 31.5266 0.941932 32.7835L3.21648 35.0581C4.47239 36.314 6.50966 36.314 7.76557 35.0581L18 24.8236L28.2344 35.0581C29.4903 36.314 31.5276 36.314 32.7835 35.0581L35.0581 32.7835C36.314 31.5276 36.314 29.4914 35.0581 28.2344L24.8236 18Z"
                        fill="black" />
                </svg>
            </div>
            <slot name="title">
                <h3 class="modal-title">Добавить новый рецепт</h3>
            </slot>
            <slot name="body">
                <div class="modal-content">
                    <input type="text" placeholder="Название" v-model="recipe.name">
                    <input type="text" placeholder="Картинка" v-model="recipe.recipe_image">
                    <input type="text" placeholder="Поиск" v-model="search">
                    <h3>Ингредиенты</h3>
                    <div class="search">

                        <ul v-for="(s, index) in search_text" :key="index">
                            <li>{{s.name}} - {{s.count}} {{s.measure_unit}} <label for="">
                                    <input type="checkbox" v-bind:value="s" v-model="checkedProducts"
                                        class="custom-checkbox">
                                </label></li>


                        </ul>
                    </div>


                    <input type="text" placeholder="Масса готового блюда" v-model="recipe.weight">
                    <div class="container">
                        <input type="text" placeholder="Калорийность" v-model="recipe.calories">
                        <input type="text" placeholder="Углеводы" v-model="recipe.carbohydrates">
                        <input type="text" placeholder="Белки" v-model="recipe.proteins">
                        <input type="text" placeholder="Жиры" v-model="recipe.fats">
                    </div>

                </div>
            </slot>
            <slot name="footer">
                <div class="modal-content">
                    <button class="modal-footer__button" @click="SaveRecipe()">Сохранить</button>
                </div>
            </slot>
        </div>

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
    import ModalWindow from "../modalWindows/ModalInformation.vue"
    export default {
        name: "ModalCreateRecipe",
        components: {
            ModalWindow
        },
        data: function () {
            return {
                show: false,
                recipe: {
                    name: "",
                    weight: 0,
                    calories: 0,
                    carbohydrates: 0,
                    proteins: 0,
                    fats: 0,
                    recipe_image: null
                },
                search: "",
                products: {},
                checkedProducts: [],
                recipeId: "",
                meassege: ""
            }
        },
        methods: {
            closeModal: function () {
                this.show = false
            },
            SaveRecipe() {
                 if(this.recipe.recipe_image==null){
                    this.recipe.recipe_image=="https://серебро.рф/img/placeholder.png";
                }
                var axios = require('axios');

                var data = JSON.stringify(this.recipe);
                var vm = this;
                console.log(this.recipe);

                var config = {
                    method: 'post',
                    url: 'http://' + this.$store.getters.ip + '/recipe/create?userId=' + this.$store.getters.userId,
                    headers: {
                        'Content-Type': 'application/json',
                        // 'Cookie': 'JSESSIONID=4A126999079A863B53FED9D774DF8FDF'
                    },
                    data: data
                };
                axios.defaults.withCredentials = false;

                console.log(this.checkedProducts);
                axios(config)
                    .then(function (response) {
                        console.log(JSON.stringify(response.data));
                        vm.recipeId = response.data;
                        vm.addProducts();
                    })
                    .catch(function (error) {
                        console.log(error);
                        vm.message = "Ошибка! Повторите попытку.";
                        vm.ShowModalWindow();
                    });
            },
            addProducts() {
                var axios = require('axios');
                var data = JSON.stringify(this.checkedProducts);
                console.log(this.checkedProducts);
                var config = {
                    method: 'post',
                    url: 'http://' + this.$store.getters.ip + '/recipe/add-products?recipeId=' + this.recipeId,
                    headers: {
                        'Content-Type': 'application/json',
                        'Cookie': 'JSESSIONID=4A126999079A863B53FED9D774DF8FDF'
                    },
                    data: data
                };

                axios(config)
                    .then(function (response) {
                        console.log(JSON.stringify(response.data));
                        
                        vm.closeModal();
                        vm.message = "Рецепт сохранен!";
                        vm.ShowModalWindow();
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            ShowModalWindow() {
                this.$refs.modalWindow.show = true;
            },
            CloseModalWindow() {
                this.$refs.modalWindow.show = false;
            },

        },
        computed: {
            search_text: function () {
                var search_word = this.search.toLowerCase();
                return this.products.filter(
                    (x) =>
                    (x.name.toLowerCase().includes(search_word)));
            }
        },
        mounted() {
            var axios = require('axios');
            var vm = this;

            var config = {
                method: 'get',
                url: 'http://localhost:8888/product/getProducts?userId=' + this.$store.getters.userId,
                headers: {
                    'Cookie': 'JSESSIONID=4A126999079A863B53FED9D774DF8FDF'
                }
            };

            axios(config)
                .then(function (response) {
                    console.log(JSON.stringify(response.data));
                    vm.products = response.data;

                })
                .catch(function (error) {
                    console.log(error);
                });

        },
    }
</script>

<style lang="scss" scoped>
    .modal-shadow {
        position: absolute;
        top: 0;
        left: 0;
        min-height: 100%;
        width: 100%;
        background: rgba(0, 0, 0, 0.39);

        .modal {
            background: #fff;
            border-radius: 67px;
            padding: 50px;
            min-width: 420px;
            max-width: 480px;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);

            @media screen and (max-width: 400px) {
                min-width: 300px;
                max-width: 300px;
                padding: 20px;
                padding-top: 40px;

            }
        }
    }

    .modal-title {
        font-family: 'Inter';
        font-weight: 400;
        color: #383838;
        font-size: 28px;
        margin-bottom: 26px;

        @media screen and (max-width: 400px) {

            margin-bottom: 5px;
            font-size: 20px;

        }
    }

    .modal-content {
        margin-bottom: 5px;
        margin-top: 5px;

        .search {
            height: 120px;
            overflow: auto;

            @media screen and (max-width: 400px) {

                height: 80px;
            }

            ul {

                padding: 0;
                margin: 0;
                list-style: none;

                li {
                    text-align: left;
                    padding: 5px;
                    border-radius: 25px;
                    margin: 5px;
                    border: 0.5px solid #bababa;
                    background-color: #ebebeb;


                    input {
                        width: auto;
                        height: auto;
                    }

                    .custom-checkbox+label {
                        display: inline-flex;
                        align-items: center;
                        user-select: none;
                    }

                    .custom-checkbox+label::before {
                        content: '';
                        display: inline-block;
                        width: 3em;
                        height: 3em;
                        flex-shrink: 0;
                        flex-grow: 0;
                        border: 1px solid #adb5bd;
                        border-radius: 0.25em;
                        margin-right: 0.5em;
                        background-repeat: no-repeat;
                        background-position: center center;
                        background-size: 50% 50%;
                    }
                }
            }
        }

    }

    .container {
        display: grid;
        grid-auto-flow: column;
        grid-auto-columns: 1fr 1fr 1fr;
        grid-template-columns: 1fr 1fr;
        grid-template-rows: 1fr 1fr;
        gap: 0px 0px;


        input {
            width: 135px;
            align-self: center;
            justify-self: center;
            font-size: 16px;
        }
    }

    input {
        width: 300px;
        height: 35px;
        background: #D9D9D9;
        border-radius: 60px;
        padding: 5px 10px;
        margin: 13px 0;
        color: #2D2D2DA6;
        font-size: 18px;
        border: 1px solid #ccc;
        box-sizing: border-box;

        @media screen and (max-width: 400px) {
            max-width: 220px;
            margin: 3px 0;
            font-size: 16px;
        }
    }

    .modal-footer__button {
        height: 40px;
        width: 90px;
        margin-top: 5px;
        margin-bottom: 5px;
        border: none;
        background: rgba(217, 217, 217, 1);
        border-radius: 30px;
        color: rgba(0, 0, 0, 1);
    }

    .modal-close {
        display: flex;
        align-items: center;
        justify-content: center;
        position: absolute;
        top: 27px;
        right: 27px;
        width: 30px;
        height: 30px;
        cursor: pointer;

        @media screen and (max-width: 400px) {
            top: 17px;
            width: 20px;
            height: 20px;
        }
    }

    .modal-enter-active,
    .modal-leave-active {
        transition: opacity 2s
    }

    .modal-enter,
    .modal-leave-to {
        opacity: 0
    }
</style>