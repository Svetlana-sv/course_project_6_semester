<template>
    <div class="page">
      <Header></Header>
    </div>
</template>

<script>
import router from "../router/index";
import axios from "axios";
import Header from "../components/header/header.vue"

export default {
   name: 'AccountPage',
   components:{
    Header
   }
}
</script>

<style lang="scss">
  .page {
    position: absolute;
    top: 0;
    left: 0;
    min-height: 100%;
    width: 100%;
  }
</style>