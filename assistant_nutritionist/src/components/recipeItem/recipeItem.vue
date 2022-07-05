<template>
    <div class="item">
        <div class="item__container">
            <div class="col">
                <div>
                    <img class="item__image" :src="recipe.recipe_image" alt="Картинка">
                </div>
                <div class="col__item">
                    <div class="title">
                        {{recipe.name}}
                    </div>

                    <div class="composition">

                        <div class="info">
                            {{recipe.weight}} {{recipe.measure_unit}}
                        </div>

                        <div class="info">
                            {{recipe.calories}} ккал
                        </div>
                    </div>
                </div>

            </div>

            <div class="col">
                <button class="btn__delete" @click="deleteRecipe()">Удалить</button>
            </div>


        </div>

    </div>
</template>

<script>
    import router from "../../router/index";
    import axios from "axios";


    export default {
        name: 'RecipeItem',
        props: {
            recipe: Array
        },
        components: {

        },
        methods: {
            deleteRecipe() {
                var axios = require('axios');
                var vm = this;
                var config = {
                    method: 'delete',
                    url: 'http://localhost:8888/recipe/recipeDelete?recipeId='+this.recipe.id+'&userId='+this.$store.getters.userId,
                    headers: {}
                };

                axios(config)
                    .then(function (response) {
                        console.log(JSON.stringify(response.data));
                        vm.$store.dispatch("GETRECIPES");
                    })
                    .catch(function (error) {
                        console.log(error);
                    });

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
                flex-direction: row;
                align-items: center;
                justify-content: space-between;
                text-align: left;
                margin: 10px;

                @media screen and (max-width: 400px) {
                    flex-direction: column;
                    margin: 5px;
                }

                .item__image {
                    display: flex;
                    align-items: center;
                    max-width: 100px;
                    max-height: 100px;
                    border: 1px solid rgb(196, 196, 196)
                }

                .col__item {
                    max-width: 170px;
                    margin: 5px;

                    .title {
                        font-weight: bold;
                    }

                    @media screen and (max-width: 400px) {
                        max-width: 140px;
                        margin: 5px;
                    }


                    .composition {
                        display: flex;
                        flex-direction: column;
                        justify-content: space-between;
                        margin-top: 3px;

                        .info {
                            display: flex;
                            align-items: center;
                            font-size: 16px;
                        }
                    }
                }

                .btn__delete {
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