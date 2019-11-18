<template>
  <transition name="fade">
    <div class="mask" @click="closeMask" v-show="isShow">
      <img :src="imgUrl" />
      <p class="img_desc">{{ imgDesc }}</p>
    </div>
  </transition>
</template>

<script>
export default {
  name: "preview",
  props: {
    imgUrl: {
      type: String
    },
    imgDesc: {
      type: String
    },
    isShow: {
      type: Boolean,
      default: false
    }
  },
  methods: {
    closeMask() {
      this.$emit("closeMask");
    }
  }
};
</script>

<style lang="scss" scoped>
.mask {
  position: fixed;
  align-items: center;
  z-index: 889;
  display: flex;
  top: 0;
  right: 0;
  left: 0;
  bottom: 0;
  background-color: #000000;
  & > img {
    z-index: 8;
    width: 100%;
    height: auto;
  }
  & > p {
    z-index: 9;
    position: fixed;
    line-height: 20px;
    text-align: left;
    bottom: 10px;
    padding: 10px;
    font-size: 13px;
    color: #ccc;
  }
}

.fade-enter-active,
.fade-leave-active {
  transition: opacity 0.5s;
}
.fade-enter, .fade-leave-to {
  opacity: 0;
}
</style>