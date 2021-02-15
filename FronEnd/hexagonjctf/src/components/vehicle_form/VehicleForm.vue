<template>
    <div>
        <h1 class="centralizado">Cadastro Veiculo</h1>
        <h2 class="centralizado">{{vehicle.name}}</h2>

        <h2 v-if="vehicle._id" class="centralizado">Alterando</h2>
        <h2 v-else class="centralizado">Incluindo</h2>

    <b-form @submit.prevent="save()">

    <b-form-group
        id="input-group-1"
        label="Veiculo:"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="vehicle.name"
          placeholder="Veiculo"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group
        id="input-group-1"
        label="Placa:"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="vehicle.plate"
          placeholder="Placa"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-3" label="Tipo:" label-for="input-3">
        <b-form-select
          id="input-3"
          v-model="vehicle.vehicleTypeId"
          required
        >
          <b-form-select-option v-for="val in vehicleTypes" :key="val._id"  v-bind:value="val.id">{{val.name}}</b-form-select-option>
        </b-form-select>
      </b-form-group>
      <m-button variant="primary" type="submit">Salvar</m-button>
    </b-form>


    </div>
</template>
<script>

import CreateVehicle from "../../domain/vehicle/CreateVehicle"
import UpdateVehicle from "../../domain/vehicle/UpdateVehicle"
import Vehicle from "../../domain/vehicle/Vehicle"
import VehicleService from "../../domain/vehicle/VehicleService";
import Button from "../shared/button/Button"
//import VehicleType from "../../domain/vehicle_type/VehicleType"
import VehicleTypeService from "../../domain/vehicle_type/VehicleTypeService";


export default {   
    components: {
    "m-button": Button
  }, 
    data(){
        return {
            vehicle: new Vehicle(),
            id:this.$route.params.id,
            vehicleTypes:[]
        }
    },
    methods: {
        save() {
          var register;
          if(this.vehicle._id){
            register = new UpdateVehicle(this.vehicle.id,this.vehicle.name,this.vehicle.desc,this.vehicle.plate,this.vehicle.vehicleTypeId);
          }
          else{
            register = new CreateVehicle(this.vehicle.name,this.vehicle.desc,this.vehicle.plate,this.vehicle.vehicleTypeId);
          }

           this.service.save(register).then(
                 () => {
                if (this.id) this.$router.push({ name: "home" });
                this.vehicle = new Vehicle();
                },
                err => console.log(err)
            )
       
        }
    },
    created(){
        this.service = new VehicleService(this.$resource);
         if (this.id) {
            this.service.recoverById(this.id).then(vehicle => (this.vehicle = vehicle));
        }

         this.serviceType = new VehicleTypeService(this.$resource);

    this.serviceType
      .recoverAll()
      .then(
        vehicleTypes => (this.vehicleTypes = vehicleTypes),
        err => (this.mensagem = err.message)
      );
    }
}
</script>

<style scoped>
.centralizado {
  text-align: center;
}
.controle {
  font-size: 1.2em;
  margin-bottom: 20px;
}
.controle label {
  display: block;
  font-weight: bold;
}

.controle label + input,
.controle textarea {
  width: 100%;
  font-size: inherit;
  border-radius: 5px;
}

.centralizado {
  text-align: center;
}

.error {
  color: red;
}
</style>