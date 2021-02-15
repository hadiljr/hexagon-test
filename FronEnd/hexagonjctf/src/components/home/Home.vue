<template>
  <div>    
    <b-alert class="centralizado" v-show="mensagem">{{mensagem}}</b-alert>
    <h2>Veículos</h2>
    <b-table striped hover :items="vehicles" :fields="fields">

      <template #cell(actions)="data">
        <b-button-group>
           <router-link :to="{name:'altera', params:{id:data.id}}">
              <m-button variant="primary"> 
                <b-icon icon="pencil"></b-icon>
              </m-button>
          </router-link>

          <m-button variant="danger" @botaoAtivado="remove(data)"
            :confirmacao="true"> <b-icon icon="trash" ></b-icon></m-button>
        </b-button-group>
      </template>
    </b-table>
  </div>
</template>

<script>
//import Item from "../shared/item/Item.vue";
import Button from "../shared/button/Button.vue";
import VehicleService from "../../domain/vehicle/VehicleService";

export default {
  components: {
    "m-button": Button
  },

  data() {
    return {
      titulo: "Hexagon Java/Cloud Teste",
      vehicles: [],
      fields:['name','plate','vehicleTypeName','actions'],
      mensagem: ""
    };
  },
  methods: {
    remove(vehicle) {
      this.service.delete(vehicle._id).then(
        () => {
          this.mensagem = "Veiculo removida com sucesso";
          let indice = this.vehicles.indexOf(vehicle);
          this.fotos.splice(indice, 1);
        },
        err => (this.mensagem = err.message)
      );
    }
  },
  computed: {
    filterVehicles() {
      if (this.filtro) {
        let exp = new RegExp(this.filtro.trim(), "i");
        return this.vehicles.filter(vehicle => exp.test(vehicle.name));
      } else {
        return this.vehicles;
      }
    }
  },
  created() {
    this.service = new VehicleService(this.$resource);

    this.service
      .recoverAll()
      .then(
        vehicles => (this.vehicles = vehicles),
        err => (this.mensagem = err.message)
      );
  }
};
</script>

<style scoped>
.centralizado {
  text-align: center;
}

.lista {
  list-style: none;
}

.lista .lista-item {
  display: inline-block;
}

.filtro {
  display: block;
  width: 100%;
}
</style>
