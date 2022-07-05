import router from '@/router';
import {
  createStore
} from 'vuex'

export default createStore({
  state: {
    userId: '',
    ip: 'localhost:8888',
    itemsProduct: [], //выбранные продуты для добавление в сегодняшние продукты
    itemsRecipe: [], //выбранные рецепты для добавление в сегодняшние рецепты
    recipes: [], //все рецепты пользователя
    products: [], //все продукты пользователя
    recipesToday: [],
    productsToday: [],
    parameters: []

  },
  getters: {
    userId: state => {
      return state.userId;
    },
    ip: state => {
      return state.ip;
    },
    itemsProduct: state => {
      return state.itemsProduct;
    },
    itemsRecipe: state => {
      return state.itemsRecipe;
    },
    recipes: state => {
      return state.recipes;
    },
    products: state => {
      return state.products;
    },
    recipesToday: state => {
      return state.recipesToday;
    },
    productsToday: state => {
      return state.productsToday;
    },
    parameters: state => {
      return state.parameters;
    },

  },
  mutations: {
    saveUserId(state, userId) {
      state.userId = userId;
    },
    addItemsProduct(state, item) {
      if (!(state.itemsProduct.includes(item))) {
        state.itemsProduct.push(item);
      }
    },
    addItemsRecipe(state, item) {
      if (!(state.itemsRecipe.includes(item))) {
        state.itemsRecipe.push(item);
      }
    },
    updateItemsProduct(state) {
      state.itemsProduct = new Array;
    },
    updateItemsRecipe(state) {
      state.itemsRecipe = new Array;
    },
    saveRecipes(state, recipes) {
      state.recipes = recipes;
    },
    saveProducts(state, products) {
      state.products = products;
    },
    updateRecipesToday(state, recipes) {
      state.recipesToday = recipes;
    },
    updateProductsToday(state, products) {
      state.productsToday = products;
    },
    updateParameters(state, parameters) {
      state.parameters = parameters;
    }
  },
  actions: {
    AUTHORIZATION(state, login, password) {

      var axios = require('axios');

      var config = {
        method: 'get',
        url: 'http://' + state.getters.ip + '/user/login?login=' + login + '&password=' + password,
        headers: {}
      };

      axios(config)
        .then(function (response) {
          console.log(JSON.stringify(response.data));
          state.commit("saveUserId", response.data);
          state.dispatch("GETPARAMETERS");
          router.replace("home");
        })
        .catch(function (error) {
          console.log(error);
        });

    },
    GETPARAMETERS(state) {
      var axios = require('axios');

      var config = {
        method: 'get',
        url: 'http://' + state.getters.ip + '/user/getParameters?userId=' + state.getters.userId,
        headers: {
          'Cookie': 'JSESSIONID=4A126999079A863B53FED9D774DF8FDF'
        }
      };

      axios(config)
        .then(function (response) {
          console.log(JSON.stringify(response.data));
          state.commit("updateParameters", response.data);
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    GETPRODUCTS(state) {
      var axios = require('axios');


      var config = {
        method: 'get',
        url: 'http://' + state.getters.ip + '/product/getProducts?userId=' + state.getters.userId,
        headers: {}
      };

      axios(config)
        .then(function (response) {
          console.log(JSON.stringify(response.data));
          state.commit("saveProducts", response.data);
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    GETRECIPES(state) {
      var axios = require('axios');

      var config = {
        method: 'get',
        url: 'http://' + state.getters.ip + '/recipe/getRecipes?userId=' + state.getters.userId,
        headers: {}
      };

      axios(config)
        .then(function (response) {
          console.log("GETRECIPES");
          console.log(JSON.stringify(response.data));
          state.commit("saveRecipes", response.data);
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    GETRECIPESTODAY(state) {
      var axios = require('axios');

      var config = {
        method: 'get',
        url: 'http://' + state.getters.ip + '/recipe/getRecipesToday?userId=' + state.getters.userId,
        headers: {
          'Cookie': 'JSESSIONID=4A126999079A863B53FED9D774DF8FDF'
        }
      };

      axios(config)
        .then(function (response) {
          console.log("GETRECIPESTODAY");
          console.log(JSON.stringify(response.data));
          state.commit("updateRecipesToday", response.data);
        })
        .catch(function (error) {
          console.log(error);
        });

    },
    GETPRODUCTSTODAY(state) {
      var axios = require('axios');

      var config = {
        method: 'get',
        url: 'http://' + state.getters.ip + '/product/getProductsToday?userId=' + state.getters.userId,
        headers: {
          'Cookie': 'JSESSIONID=4A126999079A863B53FED9D774DF8FDF'
        }
      };

      axios(config)
        .then(function (response) {
          console.log("GETPRODUCTSTODAY");
          console.log(JSON.stringify(response.data));
          state.commit("updateProductsToday", response.data);
        })
        .catch(function (error) {
          console.log(error);
        });

    }
  },
  modules: {}
})