<template>
  <div id="app">
    <router-view></router-view>
    <tab></tab>
  </div>
</template>
<script>
import tab from "@/components/TabBar";

export default {
  name: "App",
  components: {
    tab
  }
};
</script>
<style lang="scss">
#app {
  font-family: Helvetica, Arial, "PingFang SC", "Microsoft YaHei",
    "WenQuanYi Micro Hei", "tohoma,sans-serif";
  color: #2c3e50;
  margin: 0;
  -webkit-tap-highlight-color: transparent;
  box-sizing: border-box;
  min-height: calc(100vh - 102px);
}

body {
  margin: 0;
}

@media screen and (min-width: 960px) {
  body {
    width: 420px !important;
    margin: auto;
  }

  body {
    box-shadow: 0 0 30px #ababab;
  }
}
</style>
