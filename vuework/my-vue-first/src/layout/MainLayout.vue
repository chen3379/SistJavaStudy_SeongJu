<template>
  <div>
    <button type="button" class="btn btn-warning" @click="page = 'hello'">
      Hello
    </button>
    <button type="button" class="btn btn-danger" @click="page = 'second'">
      Second
    </button>
    <button type="button" class="btn btn-success" @click="page = 'third'">
      Third
    </button>
    <button type="button" class="btn btn-primary" @click="page = 'fourth'">
      Fourth
    </button>

    <HelloWorld v-if="page === 'hello'" />
    <SecondApp v-if="page === 'second'" />
    <ThirdApp v-if="page === 'third'" />
    <FourthApp v-if="page === 'fourth'" />
  </div>
</template>

<script setup>
import { ref } from "vue";
import HelloWorld from "../components/HelloWorld.vue";
import SecondApp from "../components/SecondApp.vue";
import ThirdApp from "../components/ThirdApp.vue";
import FourthApp from "../components/FourthApp.vue";

const page = ref("fourth");
</script>

<style scoped>
button {
  margin-right: 20px;
}
</style>
