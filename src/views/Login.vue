<template>
  <div class="login">
    <nut-navbar
      @on-click-back="back"
      style="background-color:#fff; height:30px;"
      :leftShow="true"
      :rightShow="false"
    >登录</nut-navbar>
    <div class="form">
      <nut-textinput
        v-model="username"
        placeholder="请输入用户名或邮箱"
        maxlength="20"
        :clearBtn="true"
        @blur="onBlur"
        :disabled="false"
      />
      <nut-textinput
        @blur="checkPassword"
        placeholder="请输入密码"
        maxlength="10"
        v-model="password"
        type="password"
      />
      <nut-button @click="login" block type="gray" color="#2c3e50">登录</nut-button>
      <div class="prompt-box">
        <a @click="forgetPassword">忘记密码？</a>
        <a href>注册</a>
      </div>
    </div>
    <nut-actionsheet :is-visible="isVisible" @close="closeActionSheet">
      <div slot="custom" class="custom-wrap">
        <h3 style="padding: 0 5px;">找回密码</h3>
        <nut-textinput
          v-model="email"
          @blur="checkEmail"
          placeholder="请输入你的邮箱地址"
          :clearBtn="false"
          :disabled="false"
        />
        <nut-buttongroup shape="circle">
          <nut-button type="light" @click="clearEmail">重置</nut-button>
          <nut-button>确定</nut-button>
        </nut-buttongroup>
      </div>
    </nut-actionsheet>
  </div>
</template>

<script>
import Vue from "vue";
import {
  Navbar,
  TextInput,
  Button,
  Toast,
  ActionSheet,
  ButtonGroup
} from "@nutui/nutui";

Navbar.install(Vue);
Button.install(Vue);
TextInput.install(Vue);
Toast.install(Vue);
ActionSheet.install(Vue);
ButtonGroup.install(Vue);

export default {
  name: "login",
  components: {
    [Navbar.name]: Navbar,
    [TextInput.name]: TextInput,
    [Button.name]: Button,
    [Toast.name]: Toast,
    [ActionSheet.name]: ActionSheet,
    [ButtonGroup.name]: ButtonGroup
  },
  data() {
    return {
      username: "",
      password: "",
      isVisible: false,
      email: ""
    };
  },
  methods: {
    back() {
      alert("header头部， 点击返回");
    },
    onBlur() {
      if (this.username == "") {
        this.$toast.text("用户名不能为空！");
      }
    },
    checkPassword() {
      if (this.password == "") {
        this.$toast.text("密码不能为空！");
      }
    },
    forgetPassword() {
      this.isVisible = !this.isVisible;
    },
    closeActionSheet() {
      this.isVisible = !this.isVisible;
    },
    clearEmail() {
      this.email = "";
    },
    checkEmail() {
      const regEmail = /^[A-Za-zd]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/;
      if (this.email == "") {
        this.$toast.text("邮箱地址不能为空！");
      } else if (!regEmail.test(this.email)) {
        this.$toast.text("邮箱格式错误！");
      }
    },
    login() {}
  }
};
</script>

<style lang="scss" scoped>
.login {
  overflow: hidden;
  padding: 10px;
}
.form {
  margin-top: 20px;
}
.nut-textinput {
  margin-bottom: 10px;
}
.prompt-box {
  margin-top: 10px;
  font-size: 0.7em;
  display: flex;
  justify-content: space-between;
  & > a {
    text-decoration: none;
    color: #2c3e50;
  }
}

.custom-wrap {
  padding: 0 10px 30px 10px;
}
</style>