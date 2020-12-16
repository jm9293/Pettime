import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import notice from "../views/notice.vue";
import noticeView from "../views/noticeView.vue";
import qna from "../views/qna.vue";
import qnaView from "../views/qnaView.vue";
import qnaSearch from "../views/qnaSearch.vue";
import login from "../views/login.vue";
import qnaWrite from "../views/qnaWrite.vue";
import qnaUpdate from "../views/qnaUpdate.vue";
import signup from "../views/signup.vue";
import userUpdate from "../views/userUpdate.vue";
import res from "../views/res.vue";
import resList from "../views/resList.vue";
import resListView from "../views/resListView.vue";
import idSearch from "../views/idSearch.vue";
import pwSearch from "../views/pwSearch.vue";
import map from "../views/map.vue";
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/home.vue",
    name: "Home2",
    component: Home,
  },
  {
    path: "/notice.vue",
    name: "notice",
    component: notice,
  },
  {
    path: "/noticeView.vue",
    name: "noticeView",
    component: noticeView,
  },
  {
    path: "/qna.vue",
    name: "qna",
    component: qna,
  },
  {
    path: "/qnaView.vue",
    name: "qnaView",
    component: qnaView,
  },
  {
    path: "/qnaSearch.vue",
    name: "qnaSearch",
    component: qnaSearch,
  },
  {
    path: "/login.vue",
    name: "login",
    component: login,
  },

  {
    path: "/qnaWrite.vue",
    name: "qnaWrite",
    component: qnaWrite,
  },

  {
    path: "/qnaUpdate.vue",
    name: "qnaUpdate",
    component: qnaUpdate,
  },

  {
    path: "/signup.vue",
    name: "signup",
    component: signup,
  },

  {
    path: "/userUpdate.vue",
    name: "userUpdate",
    component: userUpdate,
  },

  {
    path: "/res.vue",
    name: "res",
    component: res,
  },

  {
    path: "/resList.vue",
    name: "resList",
    component: resList,
  },
  {
    path: "/resListView.vue",
    name: "resListView",
    component: resListView,
  },
  {
    path: "/idSearch.vue",
    name: "idSearch",
    component: idSearch,
  },

  {
    path: "/pwSearch.vue",
    name: "pwSearch",
    component: pwSearch,
  },
  {
    path: "/map.vue",
    name: "map",
    component: map,
  },

  {
    path: "/about.vue",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
