<template>
  <div class="home">
    <div class="topbar">
      <!-- <a href="/">最热</a> -->
      <a href="/">最近</a>
      <!-- <div class="edit">
        <svg class="icon" aria-hidden="true">
          <use xlink:href="#icon-fabu" />
        </svg>
      </div> -->
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
  methods: {},
  created() {}
};
</script>

<style lang="scss" scoped>
.home {
  background: #f8f8f8;
}

.topbar {
  justify-content: space-between;
  align-items: center;
  position: fixed;
  top: 0;
  display: flex;
  width: 100%;
  background-color: #ffffff;
  z-index: 2;
  padding: 0 10px;
}

.edit {
  padding: 5px;
  border-radius: 50px;
  background: #ff7b8c;
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
