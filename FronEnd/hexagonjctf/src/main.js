import Vue from 'vue'
import App from './App.vue'
import VueResource from 'vue-resource';
import VueRouter from 'vue-router';
import {routes} from './routes';
import Vuelidate  from 'vuelidate';
import { BootstrapVue, BootstrapVueIcons } from 'bootstrap-vue'
import { NavbarPlugin } from 'bootstrap-vue'
//import msg from './pt_BR';

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.config.productionTip = false

//Colocando o bootstrap
Vue.use(BootstrapVue)
Vue.use(BootstrapVueIcons)
Vue.use(NavbarPlugin)

// Colocando o plugin vue-resource na aplicação
Vue.use(VueResource);
Vue.http.options.root = process.env.API_URL ? process.env.API_URL :'http://localhost:8080'

Vue.use(VueRouter);
const router = new VueRouter({ 
  routes,
  mode:'history'
});


Vue.use(Vuelidate);

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
