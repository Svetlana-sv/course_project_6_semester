import { createRouter, createWebHashHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'LoginPage',
    component: function () {
      return import(/* webpackChunkName: "about" */ '../pages/LoginPage.vue')
    }
  },
  {
    path: '/home',
    name: 'HomePage',
    component: function () {
      return import(/* webpackChunkName: "about" */ '../pages/HomePage.vue')
    }
  },
  {
    path: '/account',
    name: 'AccountPage',
    component: function () {
      return import(/* webpackChunkName: "about" */ '../pages/AccountPage.vue')
    }
  },
  {
    path: '/recipe',
    name: 'RecipePage',
    component: function () {
      return import(/* webpackChunkName: "about" */ '../pages/RecipePage.vue')
    }
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
