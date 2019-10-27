<template>
  <div class="home">
    <div class="topbar">
      <a href="/">最热</a>
      <a href="/">最近</a>
    </div>
    <div class="content">
      <post></post>
    </div>
    <tab></tab>
  </div>
</template>

<script>
import tab from "@/components/TabBar";
import post from "@/components/Post";
// import tab from "@/components/TabBar";

export default {
  name: "home",
  components: {
    post,
    tab
  },
  methods: {
  },
  created() {
  }
};
</script>

<style lang="scss" scoped>
.home {
  background: #f8f8f8;
}

.topbar {
  position: fixed;
  top: 0;
  width: 100%;
  padding: 0 10px;
  background-color: #ffffff;
  z-index: 2;
}

.content {
  padding-top: 80px;
}

a {
  padding: 0;
  color: #ff7b8c;
  box-sizing: border-box;
  line-height: 46px;
  position: relative;
  display: inline-block;
  margin-right: 10px;
  text-decoration: none;
  &::after {
    color: #ff7b8c;
    content: "";
    background-color: #ff7b8c;
    width: 100%;
    height: 3px;
    position: absolute;
    bottom: 0;
    left: 0;
  }
}
</style>
