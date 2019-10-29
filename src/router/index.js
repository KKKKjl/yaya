import Vue from "vue";
import VueRouter from "vue-router";
// import store from "../store/index.js";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const router = new VueRouter({
  routes: [
    {
      path: "/",
      name: "home",
      component: Home
    },
    {
      path: "/edit",
      name: "edit",
      component: () =>
        import("../views/Editor.vue")
    },
    {
      path: "/about",
      name: "about",
      // meta: {
      //   requireAuth: true
      // },
      component: () =>
        import("../views/About.vue")

    },
    {
      path: "/login",
      name: "login",
      component: () =>
        import("../views/Login.vue")
    }
  ]
})

// const token = window.localStorage.getItem("token");
// if (token) {
//   store.commit("setUserStatus");
// }

// router.beforeEach((to, from, next) => {
//   if (to.matched.some(record => record.meta.requireAuth)) {
//     if (!store.state.isLogin) {
//       next({
//         name: "login",
//         query: { redirect: to.fullPath }
//       });
//     } else {
//       next();
//     }
//   } else {
//     next();
//   }
// });

export default router;
