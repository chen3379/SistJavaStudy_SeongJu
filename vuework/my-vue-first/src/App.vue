<script setup>
import HelloWorld from "./components/HelloWorld.vue";
import SecondApp from "./components/SecondApp.vue";
import ThirdApp from "./components/ThirdApp.vue";
import MainLayout from "./layout/MainLayout.vue";
</script>

<template>
  <div>
    <MainLayout />
  </div>
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
