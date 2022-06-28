<template>
    <div>
  <nav>
    <router-link to="/account">Главная </router-link>
    <router-link to="/">Рецепты </router-link>
    <router-link to="/account">Измерения </router-link>
    <router-link to="/account">Личный кабинет</router-link>
    <!-- <router-link to="/about">About</router-link> -->
  </nav>
 
</div>
</template>
<script>
export default {
    name: 'Header'
}
</script>

<style lang="scss" scoped>
nav {
  padding: 30px;
  background-color: rgb(126, 237, 220);
  border-bottom: 0px;// Добавить тень
  

  a {
    font-weight: bold;
    color: #2a2c2e;
    text-decoration: none;
    font-size: 20px;

    &.router-link-exact-active {
      color: #fcfcfc;
    }
  }
}
</style>