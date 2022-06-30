<template>
    <div class="item">
        <div class="item__container">
            <div class="col">
                <div>
                    <img class="item__image" src="" alt="Картинка">
                </div>
                <div class="col__item">
                    <div class="title">
                        Яблоко
                    </div>

                    <div class="description">
                        Яблоко зеленое
                    </div>
                    <div class="composition">

                        <div class="title">
                            100 г
                        </div>

                        <div class="title">
                            57 ккал
                        </div>
                    </div>
                </div>




            </div>
            <div class="col">
                <button class="btn__add">Добавить</button>
            </div>

        </div>




    </div>
</template>

<script>
    import router from "../../router/index";
    import axios from "axios";


    export default {
        name: 'FoodItem',
        components: {

        }
    }
</script>

<style scoped lang="scss">
    .item {
        min-height: 100%;
        width: 400px;
        background: #f4f3f3;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 30px;

        .item__container {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
            margin: 20px;

            .col {

                display: flex;
                align-items: center;
                justify-content: space-between;
                text-align: left;
                margin: 10px;

                .item__image{
                    width: 100px;
                    height: 100px;
                }

                .col__item{
                    width: 170px;
                    .composition{
                        display: flex;
                        flex-direction: row;
                        justify-content: space-between;
                    }
                }

                .btn__add{
                    height: 40px;
                    width: 75px;
                    background: rgba(217, 217, 217, 1);
                    border-radius: 30px;
                    color: rgba(0, 0, 0, 1);
                    border: none;
                }
            }
        }
    }
</style>