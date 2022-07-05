<template>
    <div class="page">
        <Header></Header>

        <div class="page__status" v-if="!show">
            <div class="container">
                <div class="row">
                    <div class="row__content">
                        <p>1158</p>
                        <p>приход</p>
                    </div>
                    <div class="row__content">
                        <p class="main__content">{{ this.$store.getters.parameters.calorie_norm}}</p>
                        <p>ккал осталось</p>
                    </div>
                    <div class="row__content">
                        <p>158</p>
                        <p>расход</p>
                    </div>
                </div>
                <div class="row">
                    <div class="row__content">
                        <p>Углеводы</p>
                        <p>158 г / {{ this.$store.getters.parameters.carbohydrate_norm}} г</p>
                    </div>
                    <div class="row__content">
                        <p>Белки</p>
                        <p>158 г / {{ this.$store.getters.parameters.protein_norm}} г</p>
                    </div>
                    <div class="row__content">
                        <p>Жиры</p>
                        <p>158 г / {{ this.$store.getters.parameters.fat_norm}} г</p>
                    </div>
                </div>
            </div>
        </div>




        <div class="page__control" v-if="!show">
            <div class="container">
                <div class="card">
                    <div class="row">
                        <div class="row__content">
                            <img src="../assets/if-weather-27-2682824_90788.png" alt="">
                        </div>
                        <div class="row__content">
                            <p>Завтрак</p>
                        </div>
                        <!-- <div class="row__content">
                            <p>{{morningCalories}}</p>
                        </div> -->
                        <div class="row__content"><button class="btn__plus" @click="this.k1==0?this.k1=1:this.k1=0">
                                <svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                                    viewBox="0 0 129 129" xmlns:xlink="http://www.w3.org/1999/xlink"
                                    enable-background="new 0 0 129 129">
                                    <g>
                                        <path
                                            d="m121.3,34.6c-1.6-1.6-4.2-1.6-5.8,0l-51,51.1-51.1-51.1c-1.6-1.6-4.2-1.6-5.8,0-1.6,1.6-1.6,4.2 0,5.8l53.9,53.9c0.8,0.8 1.8,1.2 2.9,1.2 1,0 2.1-0.4 2.9-1.2l53.9-53.9c1.7-1.6 1.7-4.2 0.1-5.8z" />
                                    </g>
                                </svg></button></div>
                        <div class="row__content"><button class="btn__plus" @click="AddFood(1)"><svg width="20"
                                    version="1.1" xmlns="http://www.w3.org/2000/svg" height="20" viewBox="0 0 64 64"
                                    xmlns:xlink="http://www.w3.org/1999/xlink" enable-background="new 0 0 64 64">
                                    <g>
                                        <g fill="#1D1D1B">
                                            <path
                                                d="m46.551,30.119h-12.143v-12.142c0-1.104-0.895-2-2-2s-2,0.896-2,2v12.143h-12.142c-1.105,0-2,0.896-2,2s0.895,2 2,2h12.143v12.143c0,1.104 0.895,2 2,2s2-0.896 2-2v-12.144h12.143c1.105,0 2-0.896 2-2s-0.896-2-2.001-2z" />
                                            <path
                                                d="M32,0C14.355,0,0,14.355,0,32s14.355,32,32,32s32-14.355,32-32S49.645,0,32,0z M32,60    C16.561,60,4,47.439,4,32S16.561,4,32,4s28,12.561,28,28S47.439,60,32,60z" />
                                        </g>
                                    </g>
                                </svg></button></div>



                    </div>
                    <div class="col" id="col1" v-for="(recipe,index) in this.$store.getters.recipesToday" :key="index">
                        <li v-if="recipe.meal.id==1&&this.k1==1">{{recipe.recipe.name}} {{recipe.recipe.calories}} </li>
                    </div>
                    <div class="col" v-for="(product,index) in this.$store.getters.productsToday" :key="index">
                        <li v-if="product.meal.id==1&&this.k1==1">{{product.product.name}} {{product.product.calories}}
                        </li>
                    </div>
                </div>

                <div class="card">



                    <div class="row">
                        <div class="row__content">
                            <img src="../assets/if-weather-3-2682848_90785.png" alt="">
                        </div>
                        <div class="row__content">
                            <p>Обед</p>
                        </div>
                        <!-- <div class="row__content">
                            <p>{{morningCalories}}</p>
                        </div> -->
                        <div class="row__content"><button class="btn__plus" @click="this.k2==0?this.k2=2:this.k2=0">
                                <svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                                    viewBox="0 0 129 129" xmlns:xlink="http://www.w3.org/1999/xlink"
                                    enable-background="new 0 0 129 129">
                                    <g>
                                        <path
                                            d="m121.3,34.6c-1.6-1.6-4.2-1.6-5.8,0l-51,51.1-51.1-51.1c-1.6-1.6-4.2-1.6-5.8,0-1.6,1.6-1.6,4.2 0,5.8l53.9,53.9c0.8,0.8 1.8,1.2 2.9,1.2 1,0 2.1-0.4 2.9-1.2l53.9-53.9c1.7-1.6 1.7-4.2 0.1-5.8z" />
                                    </g>
                                </svg></button></div>
                        <div class="row__content"><button class="btn__plus" @click="AddFood(2)"><svg width="20"
                                    version="1.1" xmlns="http://www.w3.org/2000/svg" height="20" viewBox="0 0 64 64"
                                    xmlns:xlink="http://www.w3.org/1999/xlink" enable-background="new 0 0 64 64">
                                    <g>
                                        <g fill="#1D1D1B">
                                            <path
                                                d="m46.551,30.119h-12.143v-12.142c0-1.104-0.895-2-2-2s-2,0.896-2,2v12.143h-12.142c-1.105,0-2,0.896-2,2s0.895,2 2,2h12.143v12.143c0,1.104 0.895,2 2,2s2-0.896 2-2v-12.144h12.143c1.105,0 2-0.896 2-2s-0.896-2-2.001-2z" />
                                            <path
                                                d="M32,0C14.355,0,0,14.355,0,32s14.355,32,32,32s32-14.355,32-32S49.645,0,32,0z M32,60    C16.561,60,4,47.439,4,32S16.561,4,32,4s28,12.561,28,28S47.439,60,32,60z" />
                                        </g>
                                    </g>
                                </svg></button></div>


                    </div>
                    <div class="col" v-for="(recipe,index) in this.$store.getters.recipesToday" :key="index">
                        <li v-if="recipe.meal.id==2&&this.k2==2">{{recipe.recipe.name}} {{recipe.recipe.calories}} </li>
                    </div>
                    <div class="col" v-for="(product,index) in this.$store.getters.productsToday" :key="index">
                        <li v-if="product.meal.id==2&&this.k2==2">{{product.product.name}} {{product.product.calories}}
                        </li>
                    </div>
                </div>

                <div class="card">


                    <div class="row">
                        <div class="row__content">
                            <img src="../assets/if-weather-26-2682825_90789.png" alt="">
                        </div>
                        <div class="row__content">
                            <p>Ужин</p>
                        </div>
                        <!-- <div class="row__content">
                            <p>{{morningCalories}}</p>
                        </div> -->
                        <div class="row__content"><button class="btn__plus" @click="this.k3==0?this.k3=3:this.k3=0">
                                <svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                                    viewBox="0 0 129 129" xmlns:xlink="http://www.w3.org/1999/xlink"
                                    enable-background="new 0 0 129 129">
                                    <g>
                                        <path
                                            d="m121.3,34.6c-1.6-1.6-4.2-1.6-5.8,0l-51,51.1-51.1-51.1c-1.6-1.6-4.2-1.6-5.8,0-1.6,1.6-1.6,4.2 0,5.8l53.9,53.9c0.8,0.8 1.8,1.2 2.9,1.2 1,0 2.1-0.4 2.9-1.2l53.9-53.9c1.7-1.6 1.7-4.2 0.1-5.8z" />
                                    </g>
                                </svg></button></div>
                        <div class="row__content"><button class="btn__plus" @click="AddFood(3)"><svg width="20"
                                    version="1.1" xmlns="http://www.w3.org/2000/svg" height="20" viewBox="0 0 64 64"
                                    xmlns:xlink="http://www.w3.org/1999/xlink" enable-background="new 0 0 64 64">
                                    <g>
                                        <g fill="#1D1D1B">
                                            <path
                                                d="m46.551,30.119h-12.143v-12.142c0-1.104-0.895-2-2-2s-2,0.896-2,2v12.143h-12.142c-1.105,0-2,0.896-2,2s0.895,2 2,2h12.143v12.143c0,1.104 0.895,2 2,2s2-0.896 2-2v-12.144h12.143c1.105,0 2-0.896 2-2s-0.896-2-2.001-2z" />
                                            <path
                                                d="M32,0C14.355,0,0,14.355,0,32s14.355,32,32,32s32-14.355,32-32S49.645,0,32,0z M32,60    C16.561,60,4,47.439,4,32S16.561,4,32,4s28,12.561,28,28S47.439,60,32,60z" />
                                        </g>
                                    </g>
                                </svg></button></div>

                    </div>

                    <div class="col" v-for="(recipe,index) in this.$store.getters.recipesToday" :key="index">
                        <li v-if="recipe.meal.id==3&&this.k3==3">{{recipe.recipe.name}} {{recipe.recipe.calories}} </li>
                    </div>
                    <div class="col" v-for="(product,index) in this.$store.getters.productsToday" :key="index">
                        <li v-if="product.meal.id==3&&this.k3==3">{{product.product.name}} {{product.product.calories}}
                        </li>
                    </div>
                </div>

                <div class="card">


                    <div class="row">
                        <div class="row__content">
                            <img src="../assets/if-weather-4-2682847_90799.png" alt="">
                        </div>
                        <div class="row__content">
                            <p>Перекус</p>
                        </div>
                        <!-- <div class="row__content">
                            <p>{{morningCalories}}</p>
                        </div> -->
                        <div class="row__content"><button class="btn__plus down"
                                @click="this.k4==0?this.k4=4:this.k4=0">
                                <svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                                    viewBox="0 0 129 129" xmlns:xlink="http://www.w3.org/1999/xlink"
                                    enable-background="new 0 0 129 129">
                                    <g>
                                        <path
                                            d="m121.3,34.6c-1.6-1.6-4.2-1.6-5.8,0l-51,51.1-51.1-51.1c-1.6-1.6-4.2-1.6-5.8,0-1.6,1.6-1.6,4.2 0,5.8l53.9,53.9c0.8,0.8 1.8,1.2 2.9,1.2 1,0 2.1-0.4 2.9-1.2l53.9-53.9c1.7-1.6 1.7-4.2 0.1-5.8z" />
                                    </g>
                                </svg></button></div>
                        <div class="row__content"><button class="btn__plus" @click="AddFood(4)"><svg width="20"
                                    version="1.1" xmlns="http://www.w3.org/2000/svg" height="20" viewBox="0 0 64 64"
                                    xmlns:xlink="http://www.w3.org/1999/xlink" enable-background="new 0 0 64 64">
                                    <g>
                                        <g fill="#1D1D1B">
                                            <path
                                                d="m46.551,30.119h-12.143v-12.142c0-1.104-0.895-2-2-2s-2,0.896-2,2v12.143h-12.142c-1.105,0-2,0.896-2,2s0.895,2 2,2h12.143v12.143c0,1.104 0.895,2 2,2s2-0.896 2-2v-12.144h12.143c1.105,0 2-0.896 2-2s-0.896-2-2.001-2z" />
                                            <path
                                                d="M32,0C14.355,0,0,14.355,0,32s14.355,32,32,32s32-14.355,32-32S49.645,0,32,0z M32,60    C16.561,60,4,47.439,4,32S16.561,4,32,4s28,12.561,28,28S47.439,60,32,60z" />
                                        </g>
                                    </g>
                                </svg></button></div>

                    </div>
                    <div class="col" v-for="(recipe,index) in this.$store.getters.recipesToday" :key="index">
                        <li v-if="recipe.meal.id==4&&this.k4==4">{{recipe.recipe.name}} {{recipe.recipe.calories}} </li>
                    </div>
                    <div class="col" v-for="(product,index) in this.$store.getters.productsToday" :key="index">
                        <li v-if="product.meal.id==4&&this.k4==4">{{product.product.name}} {{product.product.calories}}
                            ккал</li>
                    </div>
                </div>
                <!-- <div class="row">
                    <div class="row__content"><img src="" alt="картинка"></div>
                    <div>
                        <p>Трекер воды</p>
                    </div>
                    <div class="row__content"><button class="btn__plus" @click="AddFood()"><svg width="20" version="1.1"
                                xmlns="http://www.w3.org/2000/svg" height="20" viewBox="0 0 64 64"
                                xmlns:xlink="http://www.w3.org/1999/xlink" enable-background="new 0 0 64 64">
                                <g>
                                    <g fill="#1D1D1B">
                                        <path
                                            d="m46.551,30.119h-12.143v-12.142c0-1.104-0.895-2-2-2s-2,0.896-2,2v12.143h-12.142c-1.105,0-2,0.896-2,2s0.895,2 2,2h12.143v12.143c0,1.104 0.895,2 2,2s2-0.896 2-2v-12.144h12.143c1.105,0 2-0.896 2-2s-0.896-2-2.001-2z" />
                                        <path
                                            d="M32,0C14.355,0,0,14.355,0,32s14.355,32,32,32s32-14.355,32-32S49.645,0,32,0z M32,60    C16.561,60,4,47.439,4,32S16.561,4,32,4s28,12.561,28,28S47.439,60,32,60z" />
                                    </g>
                                </g>
                            </svg></button></div>
                </div> -->

            </div>
        </div>

        <div class="page__addingFood" v-if="show">

            <div>
                <button class="btn__back" @click="this.show = false">Назад</button>
            </div>

            <div>
                <input class="search" type="text" placeholder="Поиск" v-model="search">
            </div>

            <div>
                <button class="btn__adding" @click="this.$refs.modalCreateProduct.show = true">Добавить продукт</button>
                <button class="btn__adding" @click="this.$refs.modalCreateRecipe.show = true">Добавить рецепт</button>
            </div>

            <ProductItem v-for="(product, index) in products_search" :key="index" :product="product"></ProductItem>
            <RecipeItem v-for="(recipe, index) in recipes_search" :key="index" :recipe="recipe"></RecipeItem>
            <div>
                <button class="btn__save" @click="SaveFood()">Сохранить</button>
            </div>
        </div>


        <ModalCreateRecipe ref="modalCreateRecipe"></ModalCreateRecipe>
        <ModalCreateProduct ref="modalCreateProduct"></ModalCreateProduct>
    </div>
</template>

<script>
    import router from "../router/index";
    import axios from "axios";
    import Header from "../components/header/header.vue"
    import ProductItem from "../components/addingFood/productItems.vue"
    import RecipeItem from "../components/addingFood/recipeItems.vue"
    import ModalCreateRecipe from "../modalWindows/ModalCreateRecipe.vue"
    import ModalCreateProduct from "../modalWindows/ModalCreateProduct.vue"
    export default {
        name: 'HomePage',
        components: {
            Header,
            ProductItem,
            RecipeItem,
            ModalCreateRecipe,
            ModalCreateProduct
        },
        data() {
            return {
                show: false,
                morningCalories: "0 ккал",
                products: {},
                recipes: {},
                meal_id: -1,
                k1: 0,
                k2: 0,
                k3: 0,
                k4: 0,
                search: "",
                products_search: [],
                recipes_search: []
            }
        },
        methods: {
            AddFood(meal_id) {
                this.meal_id = meal_id;
                this.show = true;
                this.products = this.$store.getters.products;
                this.recipes = this.$store.getters.recipes;
            },
            SaveFood() {
                this.saveFoodRecipes();
                this.saveFoodProducts();
            },
            saveFoodRecipes() {
                var vm = this;
                var axios = require('axios');
                console.log(this.$store.getters.itemsRecipe);
                var data = this.$store.getters.itemsRecipe;
                console.log("data");
                console.log(data);
                var config = {
                    method: 'post',
                    url: 'http://localhost:8888/recipe/addRecipes?userId=' + this.$store.getters.userId +
                        '&mealId=' + this.meal_id,
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    data: data
                };

                axios(config)
                    .then(function (response) {
                        console.log(JSON.stringify(response.data));
                        vm.$store.dispatch("GETRECIPESTODAY");
                        vm.$store.commit("updateItemsRecipe");
                        vm.show = false;
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },
            saveFoodProducts() {
                var vm = this;
                var axios = require('axios');
                console.log(this.$store.getters.itemsProduct);
                var data = this.$store.getters.itemsProduct;
                console.log("data");
                console.log(data);
                var config = {
                    method: 'post',
                    url: 'http://localhost:8888/product/addProducts?userId=' + this.$store.getters.userId +
                        '&mealId=' + this.meal_id,
                    headers: {
                        'Content-Type': 'application/json',
                        'Cookie': 'JSESSIONID=4A126999079A863B53FED9D774DF8FDF'
                    },
                    data: data
                };

                axios(config)
                    .then(function (response) {
                        vm.$store.dispatch("GETPRODUCTSTODAY");
                        vm.$store.commit("updateItemsProduct");
                        console.log(JSON.stringify(response.data));
                        vm.show = false;
                    })
                    .catch(function (error) {
                        console.log(error);
                    });
            },

        },
        mounted() {
            this.$store.dispatch("GETRECIPES");
            this.$store.dispatch("GETPRODUCTS");
            this.$store.dispatch("GETRECIPESTODAY");
            this.$store.dispatch("GETPRODUCTSTODAY");
            this.products = this.$store.getters.products;
            this.recipes = this.$store.getters.recipes;
        },
        computed: {
            recipes_search: function () {
                var search_word = this.search.toLowerCase();
                return this.recipes.filter(
                    (x) =>
                    (x.name.toLowerCase().includes(search_word)));
            },
            products_search: function () {
                var search_word = this.search.toLowerCase();
                return this.products.filter(
                    (x) =>
                    (x.name.toLowerCase().includes(search_word)));
            }
        },
    }
</script>

<style scoped lang="scss">
    .wrap-menu {
        max-width: 400px;
        border: 1px solid #555;
    }

    .item-menu:not(:last-child) {
        border-bottom: 1px solid #555;
    }

    .title-menu {
        font-weight: 700;
        color: #fff;
        padding: 10px 20px;
        cursor: pointer;
        background: #333;
    }

    .menu {
        display: none;
        padding: 10px 0;
    }

    .menu a {
        display: block;
        padding: 5px 20px;
    }

    .item-menu.active .title-menu {
        border-bottom: 1px solid #555;
    }

    .page {
        top: 0;
        left: 0;
        min-height: 100%;
        width: 100%;

        .page__status {
            display: flex;
            width: 100%;
            justify-content: center;
            margin-top: 50px;

            .container {
                background-color: #6AABA3;
                min-width: 500px;
                max-width: 600px;
                padding: 20px;
                display: flex;
                flex-direction: column;
                box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
                border-radius: 45px;

                @media screen and (max-width: 500px) {
                    min-width: 200px;
                    max-width: 300px;
                }

                .row {
                    display: flex;
                    flex-direction: row;
                    justify-content: space-between;
                    padding: 20px;
                    height: auto;

                    @media screen and (max-width: 500px) {
                        flex-direction: column;
                        margin: 10px;
                    }

                    .row__content {
                        align-items: center;
                        margin: 5px;



                        p {
                            font-size: 18px;
                            color: aliceblue;
                        }

                        p.main__content {
                            font-size: 36px;
                        }
                    }
                }
            }
        }

        .page__control {
            display: flex;
            width: 100%;
            justify-content: center;
            margin-top: 20px;

            .card {
                display: flex;
                flex-direction: column;
                margin-bottom: 20px;
                padding: 10px;
                padding-left: 20px;
                background: #f0f0f0;
                border: 1px solid #6AABA3;
                box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
                border-radius: 45px;
                min-width: 500px;
                max-width: 600px;
                height: auto;

                @media screen and (max-width: 500px) {

                    min-width: 200px;
                    max-width: 400px;

                }

                .col {

                    transition: max-height 0.2s ease-out;
                    @extend .flipIn;

                    li {
                        list-style: none;
                        margin: 5px;

                        @extend .flipIn
                    }
                }

                .row {

                    display: grid;
                    grid-template-columns: repeat(4, 1fr);
                    align-items: center;


                    @media screen and (max-width: 500px) {
                        display: flex;
                        min-width: 200px;
                        max-width: 300px;
                        flex-direction: column;
                        height: auto;
                        padding: 10px;
                    }


                    img {
                        width: auto;
                        height: 40px;
                        border: none;
                    }





                    .row__content {
                        align-items: center;
                        text-align: center;
                        display: flex;
                        justify-content: center;

                        @media screen and (max-width: 600px) {
                            justify-content: center;
                        }


                        .btn__plus {
                            border: none;

                        }

                        p {
                            font-size: 16px;


                            @media screen and (max-width: 600px) {
                                padding: 5px;
                                font-size: 16px;
                            }
                        }

                        p.main__content {
                            font-size: 36px;
                        }
                    }
                }
            }
        }

        .page__addingFood {
            display: flex;
            flex-direction: column;
            justify-content: center;
            text-align: center;
            align-items: center;

            .search {
                margin: 20px;
                width: 400px;
                height: 35px;
                background: #cdd6d7b6;
                border-radius: 60px;
                padding: 12px 20px;
                margin: 13px 0;
                color: #2D2D2DA6;
                font-size: 18px;
                border: 1px solid #ccc;
                box-sizing: border-box;

                @media screen and (max-width: 600px) {
                    min-width: 200px;
                    max-width: 300px;
                }
            }

            .btn__save {
                height: 40px;
                width: 90px;
                margin-top: 20px;
                background: rgba(217, 217, 217, 1);
                border-radius: 30px;
                border: none;
                color: rgba(0, 0, 0, 1);
            }

            .btn__adding {
                height: 75px;
                width: 75px;
                margin: 10px;
                background: rgba(217, 217, 217, 1);
                border-radius: 30px;
                color: rgba(0, 0, 0, 1);
                border: none;
            }

            .btn__back {
                height: 30px;
                width: 75px;
                margin: 10px;
                background: rgba(217, 217, 217, 1);
                border-radius: 30px;
                color: rgba(0, 0, 0, 1);
                border: none;
            }
        }
    }

    .flipIn {
        animation: flipdown 0.5s ease both
    }

    @keyframes flipdown {
        0% {
            opacity: 0;
            transform-origin: top center;
            transform: rotateX(-90deg);
        }

        5% {
            opacity: 1
        }



        80% {
            transform: rotateX(8deg)
        }


        83% {
            transform: rotateX(6deg)
        }


        92% {
            transform: rotateX(-3deg)
        }

        100% {
            transform-origin: top center;
            transform: rotateX(0deg)
        }

    }
</style>