<template>
  <div class="login">
    <nut-navbar
      @on-click-back="back"
      style="background-color:#fff; height:30px;"
      :leftShow="true"
      :rightShow="false"
    >注册</nut-navbar>
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
      <nut-button @click="register" block style="background:#ff7b8c">注册</nut-button>
      <slot name="prompt"></slot>
    </form>
  </div>
</template>

<script>
import Vue from "vue";
import { Navbar, TextInput } from "@nutui/nutui";

Navbar.install(Vue);
TextInput.install(Vue);
export default {
  name: "login",
  components: {
    [Navbar.name]: Navbar,
    [TextInput.name]: TextInput
  },
  data() {
    return {
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
    register() {
      this.$api
        .register({
          nickname: this.username,
          password: this.password
        })
        .then(res => {
          console.log(res.data);
          this.$router.push("/login");
        })
        .catch(err => {
          throw new Error(err);
        });
    },
    back() {
      this.$router.go(-1);
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

.nut-textinput {
  margin-bottom: 10px;
}
</style>