<template>
 <div class="page">

            <div class="title">
               Яблоко
            </div>

            <div class="description">
               Яблоко зеленое
            </div>

            <div class="title">
               100 г
            </div>

            <div class="title">
               57 ккал
            </div>

                <button>Добавить</button>
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
    .page {
        min-height: 100%;
        width: 100%;

        .page__addingFood {
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