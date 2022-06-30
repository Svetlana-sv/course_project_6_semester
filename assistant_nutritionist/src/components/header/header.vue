<template>
    <div class="header">
  <nav>
    <router-link to="/home">Главная </router-link>
    <router-link to="#">Рецепты </router-link>
    <router-link to="#">Измерения </router-link>
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
.header{
  display: flex;
  text-align: center;
  align-items: center;
  justify-content: center;
  min-width: 100%;
  background-color: rgb(17, 165, 143);

nav {
  border-bottom: 0px;// Добавить тень
  height: 60px;
  display: flex;
  align-items: center;

  a {
    color: #2a2c2e;
    text-decoration: none;
    font-size: 18px;
    margin: 20px;

    &.router-link-exact-active {
      color: #fcfcfc;
    }
  }
}}
</style>