<template>
  <div class="corpo">
    <div>
      <h1 class="centralizado">{{titulo}}</h1>
    </div>
    <meu-menu :rotas="routes" />
    <transition name="pagina">
      <router-view></router-view>
    </transition>
  </div>
</template>

<script>
import { routes } from "./routes";
import Menu from "./components/shared/menu/Menu.vue";

export default {
  components: {
    "meu-menu": Menu
  },
  data() {
    return {
      titulo: "Hexagon Java/Cloud Teste",
      routes: routes.filter(route => route.menu)
    };
  }
};
</script>

<style>

.centralizado {
  text-align: center;
}

.corpo {
  font-family: Helvetica, sans-serif;
  width: 96%;
  margin: 0 auto;
}

.pagina-enter,
.pagina-leave-active {
  opacity: 0;
}

.pagina-enter-active,
.paagina-leave-active {
  transition: opacity 0.4s;
}
</style>
