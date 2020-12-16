<template>
  <div class="login">
    <div class="login-box col-12 col-md-6">
      <div class="title col-12 text-center">
        <h1>로그인</h1>
        <a href="#">회원이 아니신가요?</a>
      </div>

      <form onSubmit="return false;" @submit="tryLogin">
        <div class="form-group">
          <div class="input-box col-12 col-md-12">
            <label for="inputID" class="">아이디</label>
            <input
              type="text"
              class="form-control"
              id="inputID"
              name="username"
              placeholder=""
              v-model="username"
              required
            />
          </div>

          <div class="input-box col-12 col-md-12">
            <label for="inputPW" class="">비밀번호</label>
            <input
              type="password"
              class="form-control"
              name="inputPW"
              id="inputPW"
              placeholder=""
              v-model="password"
              required
            />
          </div>

          <div class="input-box col-12 col-md-12 row" style="">
            <div class="col-6">
              <router-link to="/idSearch.vue">아이디 찾기</router-link>
            </div>
            <div class="col-6">
              <router-link to="/pwSearch.vue">비밀번호 찾기</router-link>
            </div>
          </div>

          <div class="input-box col-12 col-md-12">
            <button class="login-btn btn btn-light col-12" type="submit">
              로그인
            </button>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      username: "",
      password: "",
    };
  },
  mounted() {
    if (this.$store.state.isLogin) {
      alert("로그인중이면 접근불가!");
      this.$router.push("/");
    }
  },

  methods: {
    tryLogin() {
      var con = {
        headers: {
          "X-CSRF-TOKEN": this.$store.state.csrf,
        },
      };

      var form = new URLSearchParams();
      form.append("username", this.username);
      form.append("password", this.password);

      this.$http
        .post(this.$store.state.baseurl + "/pettime/rest/loginAJAX", form, con)
        .then((res) => {
          if (res.data.islogin) {
            alert("로그인되었습니다.");
            this.$store.state.isLogin = res.data.islogin;
            this.$store.state.userName = res.data.uesrname;
            this.$router.push("/");
          } else {
            alert(res.data.message);
          }
          this.$http
            .get(this.$store.state.baseurl + "/pettime/rest/csrf-token")
            .then((res) => {
              this.$store.commit("setCsrf", res.data);
            });
        });
    },
  },
  created() {},
};
</script>

<style>
.login .login-box {
  margin: 10% auto;
}
.login .input-box {
  margin: 2% 0;
}

.login a {
  color: rgb(255, 178, 146);
}

.login .row {
  padding: 0;
  text-align: center;
}
</style>
