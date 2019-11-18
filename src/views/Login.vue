<template>
  <div class="login">
    <nut-navbar
      @on-click-back="back"
      style="background-color:#fff; height:30px;"
      :leftShow="true"
      :rightShow="false"
    >登录</nut-navbar>

    <form>
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
      <nut-button @click="login" block style="background:#ff7b8c">登录</nut-button>
      <slot name="prompt"></slot>
    </form>

    <div class="prompt-box">
      <a @click="forgetPassword">忘记密码？</a>
      <a @click="register">注册</a>
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
          <nut-button color="#333" style="background:#eee" @click="clearEmail">重置</nut-button>
          <nut-button style="background:#ff7b8c">确定</nut-button>
        </nut-buttongroup>
      </div>
    </nut-actionsheet>
  </div>
</template>

<script>
import Vue from "vue";
import { Navbar, ActionSheet, TextInput, Button } from "@nutui/nutui";
Navbar.install(Vue);
ActionSheet.install(Vue);
TextInput.install(Vue);
Button.install(Vue);

export default {
  name: "login",
  components: {
    [Navbar.name]: Navbar,
    [ActionSheet.name]: ActionSheet,
    [TextInput.name]: TextInput,
    [Button.name]: Button
  },
  data() {
    return {
      isVisible: false,
      email: "",
      username: "",
      password: ""
    };
  },
  methods: {
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
    login() {
      this.$api
        .login({
          nickname: this.username,
          password: this.password
        })
        .then(res => {
          let token = res.headers.authorization;
          if (token) {
            this.$store.commit("setToken", token);
            this.$store.commit("setUserStatus");
            // this.$router.push("/about").catch(e => {console.log(e)});
            // this.$store.commit("setUser", this.username);
          }
        })
        .catch(err => {
          console.log("跳转失败:" + err);
        });
    },
    register() {
      this.$router.push("/register");
    },
    forgetPassword() {
      this.isVisible = !this.isVisible;
    },
    closeActionSheet() {
      this.isVisible = !this.isVisible;
    },
    back() {
      this.$router.go(-1);
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
    }
  }
};
</script>

<style lang="scss" scoped>
.login {
  padding: 0 10px 0 10px;
}

.nut-navbar {
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

.nut-textinput {
  margin-bottom: 10px;
}
</style>