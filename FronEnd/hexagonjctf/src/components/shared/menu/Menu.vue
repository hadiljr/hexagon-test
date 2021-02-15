<template>
  <b-nav align="center">
    <b-nav-item v-for="route in rotas" :key="route.id">
      <router-link :to="route.path?route.path:'/'">{{route.titulo}}</router-link>
    </b-nav-item>
  </b-nav>
 
</template>

<script>
export default {
  props: {
    rotas: {
      type: Array,
      required: true
    }
  }
};
</script>
<style scoped>
</style>