import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import api from './api/api';
import "./registerServiceWorker";
import "./icon/iconfont.js";
import VueTimeago from 'vue-timeago'

Vue.use(VueTimeago, {
  name: 'Timeago',
  locale: 'zh-CN',
  locales: {
    'zh-CN': require('date-fns/locale/zh_cn'),
    'ja': require('date-fns/locale/ja'),
  }
})

Vue.config.productionTip = false;
Vue.prototype.$api = api;

new Vue({
  router,
  store,

  render: h => h(App)
}).$mount("#app");
