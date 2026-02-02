<template>
  <div>
    <h2 class="alert alert-info">2번째 페이지_v-if, v-for구문연습</h2>
    <h4 v-if="flag">{{ msg }}</h4>

    <ul>
      <li v-for="sys in system" :key="sys">{{ sys }}</li>
      <li v-for="(sys, index) in system" :key="index">{{ index }}-{{ sys }}</li>
    </ul>

    <h5>클릭 이벤트 연습</h5>
    <button type="button" class="btn btn-info" @click="popupAlert">
      경고창
    </button>
  </div>
</template>

<script setup>
import { ref } from "vue";

const flag = ref(true);
const msg = ref("재밌는 수업중");
const system = ["android", "ios", "window"];
const popupAlert = () => {
  alert("경고창입니다");
};
</script>

<style lang="scss" scoped>
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
