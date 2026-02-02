<template>
  <div>
    <h2 class="alert alert-info">4번째 페이지_이미지</h2>
    <img :src="imgname" width="200" />
    <h4>버튼으로 이미지 변경하기</h4>
    <button type="button" class="btn btn-danger" @click="change1">
      이미지1
    </button>
    <button type="button" class="btn btn-danger" @click="change2">
      이미지2
    </button>
    <button type="button" class="btn btn-danger" @click="change3">
      이미지3
    </button>

    <h4>v-model로 이미지 변경하기</h4>
    <input
      type="text"
      v-model="imgname"
      class="form-control"
      style="width: 300px"
      placeholder="이미지 경로"
    />
  </div>
</template>

<script setup>
import { ref } from "vue";
import img01 from "../image/Food/1.jpg";
import img02 from "../image/Food/11.jpg";
import img03 from "../image/Food/2.jpg";
import img04 from "../image/Food/5.jpg";
const imgname = ref(img01);

const change1 = () => {
  imgname.value = img02;
};
const change2 = () => {
  imgname.value = img03;
};
const change3 = () => {
  imgname.value = img04;
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
