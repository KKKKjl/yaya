<template>
  <div class="about">
    <div class="bg">
      <p>{{ nickName }}</p>
      <input id="file" @change="uploadImage" name="smfile" type="file" />
      <label for="file">
        <img :src="avatarImageUrl" />
      </label>
      <div class="wave">
        <div class="circle"></div>
        <div class="circle"></div>
        <div class="circle"></div>
      </div>
    </div>
    <div class="menu">
      <nut-cell title="个人信息" :showIcon="true"></nut-cell>
      <div class="cell">
        <span>夜间模式</span>
        <nut-switch :active="false" size="small"></nut-switch>
      </div>

      <nut-cell title="推荐朋友" :showIcon="true"></nut-cell>
      <nut-cell title="关于我们" :showIcon="true"></nut-cell>
    </div>
    <tab></tab>
  </div>
</template>

<script>
import Vue from "vue";
import { Switch, Cell } from "@nutui/nutui";
import tab from "@/components/TabBar";

Switch.install(Vue);
Cell.install(Vue);

export default {
  name: "about",
  components: {
    [Switch.name]: Switch,
    [Cell.name]: Cell,
    tab
  },
  data() {
    return {
      swActive: true,
      avatarImageUrl: "",
      nickName: ""
    };
  },
  mounted() {
    this.getUserInfo();
  },
  methods: {
    uploadImage(val) {
      let file = val.target.files[0];
      let formData = new FormData();
      formData.append("smfile", file);
      this.$api
        .uploadImage(formData)
        .then(res => {
          console.log(res.data);
        })
        .catch(err => {
          throw new Error(err);
        });
    },
    getUserInfo() {
      this.$api
        .getUserInfo({})
        .then(res => {
          this.nickName = res.data.data.nickname;
          this.avatarImageUrl = res.data.data.avatar_url;
        })
        .catch(err => {
          console.log(err);
        });
    }
  }
};
</script>

<style lang="scss" scoped>
.bg {
  width: 100%;
  height: 170px;
  background: #ff7b8c;
  position: absolute;
  overflow: hidden;
  top: 0;
  color: #fff;
  left: 0;
  z-index: 1;
  & > p {
    font-size: 1.5em;
    position: absolute;
    top: 50px;
    left: 70px;
  }
  & > input {
    opacity: 0;
    width: 0;
    height: 0;
    position: absolute;
  }
  // & > img {
  //   width: 90px;
  //   height: 90px;
  //   background: #fff;
  //   border-radius: 50%;
  //   position: absolute;
  //   right: 50px;
  //   bottom: 17px;
  //   box-shadow: 0 1px 5px rgba(0, 0, 0, 0.1);
  //   z-index: 5;
  // }
  &::after {
    content: "";
    left: 0;
    right: 0;
    bottom: -1px;
    height: 80px;
    z-index: 1;
    position: absolute;
    -webkit-clip-path: polygon(0 100%, 100% 0, 100% 100%);
    clip-path: polygon(0 100%, 100% 0, 100% 100%);
    background: #fff;
    z-index: -1;
  }
}

.wave {
  position: absolute;
  width: 120px;
  height: 120px;
  text-align: center;
  right: 35px;
  bottom: 5px;
}

.wave .circle {
  width: 100%;
  height: 100%;
  position: absolute;
  border-radius: 50%;
  opacity: 0;
  background: #ffffff;
  border: 2px solid #ffffff;
}
.wave .circle:first-child {
  animation: circle-opacity 5s infinite;
}

.wave .circle:nth-child(2) {
  animation: circle-opacity 5s infinite;
  animation-delay: 2s;
}

.wave .circle:nth-child(3) {
  animation: circle-opacity 5s infinite;
  animation-delay: 2.6s;
}

@keyframes circle-opacity {
  from {
    opacity: 1;
    transform: scale(1);
  }
  to {
    opacity: 0;
    transform: scale(2);
  }
}

.menu {
  margin-top: 200px;
  padding: 0 10px;
}

.cell {
  display: flex;
  justify-content: space-between;
  border-top: 1px solid #eee;
  margin-left: 10px;
  padding: 13px 10px 13px 0;
  font-size: 14px;
}

img {
  width: 90px;
  height: 90px;
  background: #fff;
  border-radius: 50%;
  position: absolute;
  right: 50px;
  bottom: 17px;
  box-shadow: 0 1px 5px rgba(0, 0, 0, 0.1);
  z-index: 5;
}
</style>
