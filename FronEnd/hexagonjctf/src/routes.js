import Cadastro from './components/vehicle_form/VehicleForm.vue'
import Home from './components/home/Home.vue'

export const routes = [
    { path: '', name: 'home', component: Home, titulo: 'Home', menu: true, id:1 },
    { path: '/cadastro', name: 'cadastro', component: Cadastro, titulo: 'Cadastro', menu: true, id:2 },
    { path: '/cadastro/:id', name: 'altera', component: Cadastro, titulo: 'Cadastro', menu: false, id:3  },
    { path: '*', component: Home, menu: false }
];