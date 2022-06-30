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
                        <p class="main__content">1000</p>
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
                        <p>158 г / 204 г</p>
                    </div>
                    <div class="row__content">
                        <p>Белки</p>
                        <p>158 г / 204 г</p>
                    </div>
                    <div class="row__content">
                        <p>Жиры</p>
                        <p>158 г / 204 г</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="page__control" v-if="!show">
            <div class="container">
                <div class="row">
                    <div class="row__content">
                        <img src="../assets/if-weather-27-2682824_90788.png" alt="">
                    </div>
                    <div class="row__content">
                        <p>Завтрак</p>
                    </div>
                    <div class="row__content">
                        <p>{{morningCalories}}</p>
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

                  
                </div>
                <div class="row">
                   <div class="row__content">
                        <img src="../assets/if-weather-3-2682848_90785.png" alt="">
                    </div>
                    <div class="row__content">
                        <p>Обед</p>
                    </div>
                    <div class="row__content">
                        <p>{{morningCalories}}</p>
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
                </div>
                <div class="row">
                    <div class="row__content">
                        <img src="../assets/if-weather-26-2682825_90789.png" alt="">
                    </div>
                    <div class="row__content">
                        <p>Ужин</p>
                    </div>
                    <div class="row__content">
                        <p>{{morningCalories}}</p>
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
                </div>
                <div class="row">
                    <div class="row__content">
                        <img src="../assets/if-weather-4-2682847_90799.png" alt="">
                    </div>
                    <div class="row__content">
                        <p>Перекус</p>
                    </div>
                    <div class="row__content">
                        <p>{{morningCalories}}</p>
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
                <input class="search" type="text" placeholder="Поиск" v-model="search">
            </div>

            <div>

                <button class="btn__adding" @click="this.$refs.modalCreateProduct.show = true">Добавить продукт</button>
                <button class="btn__adding" @click="this.$refs.modalCreateRecipe.show = true">Добавить рецепт</button>
            </div>

            <FoodItem></FoodItem>
            <div>
                <button class="btn__save">Сохранить</button>
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
    import FoodItem from "../components/addingFood/foodItem.vue"
    import ModalCreateRecipe from "../modalWindows/ModalCreateRecipe.vue"
import ModalCreateProduct from "../modalWindows/ModalCreateProduct.vue"
    export default {
        name: 'HomePage',
        components: {
            Header,
            FoodItem,
            ModalCreateRecipe,
            ModalCreateProduct
        },
        data() {
            return {
                show: false,
                morningCalories: "57 ккал"
            }
        },
        methods: {
            AddFood() {
                this.show = true;
            }
        },
    }
</script>

<style scoped lang="scss">
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

                @media screen and (max-width: 600px) {
                    min-width: 200px;
                    max-width: 300px;
                }

                .row {
                    display: flex;
                    flex-direction: row;
                    justify-content: space-between;
                    padding: 20px;
                    height: auto;

                 @media screen and (max-width: 600px) {
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

            .row {
                display: flex;
                flex-direction: row;
                justify-content: space-between;
                margin-bottom: 20px;
                padding: 10px;
                padding-left: 20px;
                background: #EFF8F6;
                border: 1px solid #6AABA3;
                box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
                border-radius: 45px;
                min-width: 500px;
                max-width: 600px;
                height: auto;

                img{
                    width:auto;
                    height: 40px;
                    border: none;
                }

                @media screen and (max-width: 600px) {
                    min-width: 200px;
                    max-width: 300px;
                    flex-direction: column;
                     height: auto;
                     padding: 10px;
                }

                .row__content {
                    align-items: center;
                    display: flex;

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
        }
    }
</style>