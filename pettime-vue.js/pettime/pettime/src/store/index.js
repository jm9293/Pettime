import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    csrf: "",
    isLogin: undefined,
    userName: "",
    noticePage: 1,
    resListPage: 1,
    qnaPage: 1,
    qnaSearchPage: 1,
    baseurl: "http://192.168.1.105:8989",
  },
  mutations: {
    setCsrf(state, val) {
      state.csrf = val;
    },
  },
  actions: {},
  modules: {},
});
