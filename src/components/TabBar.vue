<template>
  <div>
    <nut-tabbar @tab-switch="tabSwitch" :tabbarList="tabList3" :bottom="true"></nut-tabbar>
  </div>
</template>

<script>
import Vue from "vue";
import { tabbar } from "@nutui/nutui";

tabbar.install(Vue);

export default {
  name: "tab",
  components: {
    [tabbar.name]: tabbar
  },
  data() {
    return {
      tabList3: [
        {
          curr: true,
          icon:
            "http://img13.360buyimg.com/uba/jfs/t1/29316/38/1115/3203/5c0f3d61E35d0c7da/9e557f2cb5c9dab6.jpg",
          activeIcon:
            "http://img20.360buyimg.com/uba/jfs/t1/9996/36/8646/4833/5c0f3d61E7c1b7e0f/c98ad61124172e93.jpg"
        },
        {
          curr: false,
          icon:
            "http://img13.360buyimg.com/uba/jfs/t1/10361/35/4713/4643/5c0f3d62E437a3c94/273fd0fb90798f03.jpg",
          activeIcon:
            "http://img14.360buyimg.com/uba/jfs/t1/26604/35/1073/7896/5c0f3d61Eb9f5f184/5f01c938abe4216d.jpg"
        },
        {
          curr: false,
          icon:
            "http://img20.360buyimg.com/uba/jfs/t1/20004/20/1045/3620/5c0f3d61Eaaec1670/9e59db63983b7b9f.jpg",
          activeIcon:
            "http://img14.360buyimg.com/uba/jfs/t1/23967/14/1072/6714/5c0f3d61E0ad8991e/8f741953f6e38f15.jpg"
        }
      ]
    };
  },
  methods: {
    tabSwitch: function(value, index) {
      console.log(index);
      switch (index) {
        case 0:
          this.$router.push("/");
          break;
        case 1:
          this.$router.push("/edit");
          break;
        case 2:
          this.$router.push("/about");
          break;
        default:
          this.$$router.push("/");
          break;
      }
    }
  }
};
</script>

<style lang="scss" scoped>
</style>