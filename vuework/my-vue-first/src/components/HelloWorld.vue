<template>
  <div>
    <h1>1번째 페이지</h1>
    <button class="btn btn-info btn-sm" @click="countIncre++">
      증가 {{ countIncre }}
    </button>
    <button class="btn btn-info btn-sm" @click="countDecre--">
      감소 {{ countDecre }}
    </button>

    <p>결과값(computed): {{ total }}</p>
  </div>
</template>

<script setup>
import { computed, ref } from "vue";

const countIncre = ref(0);
const countDecre = ref(0);
const total = computed(() => {
  return countIncre.value + countDecre.value;
});
</script>

<style scoped>
div {
  text-align: center;
  margin-top: 50px;
}
h1 {
  margin-bottom: 50px;
}

button {
  padding: 10px 10px;
  margin: 0 10px;
}
</style>
