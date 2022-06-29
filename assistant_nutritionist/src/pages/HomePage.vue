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
                        <p>ккал отсалось</p>
                    </div>
                    <div class="row__content">
                        <p>158</p>
                        <p>расход</p>
                    </div>
                </div>
                <div class="row">
                    <div class="row__content">
                        <p>Углеводы</p>
                        <p>158г / 204г</p>
                    </div>
                    <div class="row__content">
                        <p>Белки</p>
                        <p>158г / 204г</p>
                    </div>
                    <div class="row__content">
                        <p>Жиры</p>
                        <p>158г / 204г</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="page__control"  v-if="!show">
            <div class="container">
                <div class="row">
                    <div class="row__content"><img src="" alt="картинка"></div>
                    <div class="row__content">
                        <p>Завтрак</p>
                    </div>
                    <div class="row__content"><button @click="AddFood()">+</button></div>
                </div>
                <div class="row">
                    <div class="row__content"><img src="" alt="картинка"></div>
                    <div class="row__content">
                        <p>Обед</p>
                    </div>
                    <div class="row__content">+</div>
                </div>
                <div class="row">
                    <div class="row__content"><img src="" alt="картинка"></div>
                    <div class="row__content">
                        <p>Ужин</p>
                    </div>
                    <div class="row__content">+</div>
                </div>
                <div class="row">
                    <div class="row__content"><img src="" alt="картинка"></div>
                    <div class="row__content">
                        <p>Перекус</p>
                    </div>
                    <div class="row__content">+</div>
                </div>
                <div class="row">
                    <div class="row__content"><img src="" alt="картинка"></div>
                    <div class="row__content">
                        <p>Трекер воды</p>
                    </div>
                    <div class="row__content">+</div>
                </div>

            </div>
        </div>

         <div class="page__addingFood" v-if="show">

            <div class="container">
                <input type="text" placeholder="Поиск" v-model="search">
            </div>
            <FoodItem></FoodItem>
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
    import FoodItem from "../components/addingFood/foodItem.vue"

    export default {
        name: 'HomePage',
        components: {
            Header,
            FoodItem
        },
        data() {
            return {
                show: false
            }
        },
        methods: {
            AddFood(){
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
        .container {
            background-color: rgb(64, 178, 142);
            min-width: 500px;
            max-width: 600px;
            padding: 20px;
            display: flex;
            flex-direction: column;
            .row {
                display: flex;
                flex-direction: row;
                justify-content: space-between;
                padding: 20px;
                .row__content {
                    align-items: center;
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
        .row {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            margin-bottom: 20px;
            padding: 20px;
            background-color: rgb(203, 216, 216);
            min-width: 500px;
            max-width: 600px;
            .row__content {
                align-items: center;
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
</style>