import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    token: window.localStorage.getItem('token'),
    auth: false,
    user: ''
  },
  mutations: {
    setToken(state, token) {
      state.token = token
      window.localStorage.setItem('token', token)
    },
    clearToken(state) {
      state.token = ''
      window.localStorage.removeItem('token')
      state.user = null
    },
    setUser(state, user) {
      state.user = user
    },
    setUserStatus(state) {
      state.auth = true
    }
  },
  actions: {

  }
})