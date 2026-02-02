<template>
  <div>
    <h2 class="alert alert-info">3번째 페이지_양방향바인딩(v-model)</h2>
    <b>메세지 출력</b>
    <br />
    <p>글자수: {{ msgLength }}</p>

    {{ message }}<br />

    <input type="text" v-model="message" />
    <button type="button" class="btn btn-info" @click="clearMsg">초기화</button>
  </div>
</template>

<script setup>
import { computed, ref, watch } from "vue";

const message = ref("오늘은 즐거운 금요일");

//computed-자동계산값
const msgLength = computed(() => message.value.length);

//watch-변경감지
watch(message, (newval, oldval) => {
  console.log("변경: ", oldval, "==>", newval);
});

const clearMsg = () => {
  message.value = "";
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
