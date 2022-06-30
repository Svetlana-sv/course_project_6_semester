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
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: function () {
      return import(/* webpackChunkName: "about" */ '../pages/HomePage.vue')
    }
  },
  {
    path: '/account',
    name: 'AccountPage',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: function () {
      return import(/* webpackChunkName: "about" */ '../pages/AccountPage.vue')
    }
  },
  {
    path: '/recipe',
    name: 'RecipePage',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
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
