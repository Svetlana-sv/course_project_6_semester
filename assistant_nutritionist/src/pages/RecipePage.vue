<template>
    <div class="page">
        <Header></Header>



        <!-- <div>
            <input class="search" type="text" placeholder="Поиск" v-model="search">
        </div> -->

        <div>

            <button class="btn__adding" @click="this.$refs.modalCreateProduct.show = true">Добавить продукт</button>
            <button class="btn__adding" @click="this.$refs.modalCreateRecipe.show = true">Добавить рецепт</button>
        </div>

        <div class="page_recipes">
   <RecipeItem v-for="(recipe, index) in recipes" :key="index" :recipe="recipe"></RecipeItem>
        </div>

        <ModalCreateRecipe ref="modalCreateRecipe"></ModalCreateRecipe>
        <ModalCreateProduct ref="modalCreateProduct"></ModalCreateProduct>
    </div>



</template>

<script>
    import router from "../router/index";
    import axios from "axios";
    import Header from "../components/header/header.vue"
    import ModalCreateRecipe from "../modalWindows/ModalCreateRecipe.vue"
    import ModalCreateProduct from "../modalWindows/ModalCreateProduct.vue"
    import RecipeItem from "../components/recipeItem/recipeItem.vue"
    export default {
        name: 'RecipePage',
        components: {
            Header,
            ModalCreateRecipe,
            ModalCreateProduct,
            RecipeItem
        },
        data() {
            return {
                recipes: {},
                search: ""
            }
        },
        methods: {},
        mounted() {
            this.recipes = this.$store.getters.recipes;
           

        },
        // created() {
        //     this.recipes = this.$store.dispatch("GETRECIPES");
        // },
        // computed: {
        //     search_text: function () {
        //         var search_word = this.search.toLowerCase();
        //         return this.recipes.recipe.filter(
        //             (x) =>
        //             (x.name.toLowerCase().includes(search_word)));
        //     }
        // },
    }
</script>

<style scoped lang="scss">
    .page {
        top: 0;
        left: 0;
        min-height: 100%;
        width: 100%;



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

        .page_recipes {
             display: flex;
            flex-direction: column;
            justify-content: center;
            text-align: center;
            align-items: center;

        }
    }
</style>