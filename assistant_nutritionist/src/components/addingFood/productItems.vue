<template>
    <div class="item">
        <div class="item__container">
            <div class="col">
                <div>
                    <img class="item__image" :src="product.product_image" alt="">
                </div>
                <div class="col__item">
                    <div class="title">
                        {{product.name}}
                    </div>

                    <div class="description">
                        {{product.description}}
                    </div>
                    <div class="composition">

                        <div class="info">
                           {{product.count}} {{product.measure_unit}}
                        </div>

                        <div class="info">
                            {{product.calories}} ккал
                        </div>
                    </div>
                </div>




            </div>
            <div class="col">
                <button class="btn__add" @click="AddFood()">Добавить</button>
            </div>

        </div>




    </div>
</template>

<script>
    import router from "../../router/index";
    import axios from "axios";


    export default {
        name: 'ProductItems',
        props:{
            meal_id : Number,
            product: Array
        },
        components: {

        },
        methods: {
            AddFood(){
                this.$store.commit("addItemsProduct", this.product)
            }
        },
    }
</script>

<style scoped lang="scss">
    .item {
        min-height: 100%;
        width: 400px;
        margin: 5px;
        background: #f4f3f3;
        box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
        border-radius: 30px;

        @media screen and (max-width: 400px) {
            min-width: 200px;
            max-width: 300px;
        }

        .item__container {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
            margin: 10px;

            @media screen and (max-width: 400px) {
                flex-direction: column;
                margin: 10px;
            }

            .col {

                display: flex;
                align-items: center;
                justify-content: space-between;
                text-align: left;
                margin: 10px;

                @media screen and (max-width: 400px) {
                margin: 5px;
            }

                .item__image {
                    width: 70px;
                    height: 70px;
                    border: 1px solid rgb(196, 196, 196)
                }

                .col__item {
                    width: 170px;
                     margin: 5px;

                     .title{
                        font-weight: bold;
                    }

                     @media screen and (max-width: 400px) {
                margin: 5px;
            }


                    .composition {
                        display: flex;
                        flex-direction: row;
                        justify-content: space-between;
                    }
                }

                .btn__add {
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