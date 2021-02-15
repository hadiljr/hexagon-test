<template>
  <b-button @click="action()"  :variant="estiloDoBotao" :type="type">{{rotulo}} <slot></slot></b-button>
</template>
<script>
export default {
  props: {
    rotulo: {
      required: false,
      type: String
    },
    type:{
      required:false,
      type:String
    },
    confirmacao: Boolean,
    variant: String
  },
  methods: {
    action() {
      if (this.confirmacao) {
        if (confirm("Confirma operação?")) {
          this.$emit("botaoAtivado");
        }
        return;
      }
      this.$emit("botaoAtivado");
    }
  },
  computed: {
    estiloDoBotao(){
      if (!this.variant) {
        return "secondary";
      }
      else  return this.variant;
    }
  }
};
</script>
<style scoped>

</style>