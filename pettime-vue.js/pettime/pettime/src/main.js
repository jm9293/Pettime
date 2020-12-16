import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";
import { BootstrapVue, IconsPlugin } from "bootstrap-vue";
import LoadScript from "vue-plugin-load-script";
import axios from "axios";
import vueMoment from "vue-moment";

Vue.prototype.$http = axios;

Vue.use(LoadScript);
// Install BootstrapVue
Vue.use(BootstrapVue);
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin);
Vue.use(vueMoment);

Vue.config.productionTip = false;
const myvue = new Vue({
  router,
  store,

  render: (h) => h(App),
}).$mount("#app");
Vue.loadScript("https://code.jquery.com/jquery-1.12.4.min.js");
Vue.loadScript("https://cdn.iamport.kr/js/iamport.payment-1.1.5.js");
//dapi.kakao.com/v2/maps/sdk.js?appkey=12cf41907ec9dfc03f51fa4ea3287959

window.app = myvue;
