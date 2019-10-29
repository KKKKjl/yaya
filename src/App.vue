<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<style lang="scss">
#app {
  font-family: Helvetica, Arial, "PingFang SC", "Microsoft YaHei",
    "WenQuanYi Micro Hei", "tohoma,sans-serif";
  color: #2c3e50;
  -webkit-tap-highlight-color: transparent;
  overflow: hidden;
}

.icon {
  width: 1.5em;
  height: 1.5em;
  vertical-align: -0.15em;
  fill: currentColor;
  overflow: hidden;
  color: #656565;
  margin-right: 10px;
}

body {
  margin: 0;
}

@media screen and (min-width: 960px) {
  #app,
  body,
  .topbar {
    width: 420px !important;
    margin: auto;
  }

  body {
    box-shadow: 0 0 30px #ababab;
  }
}
</style>
