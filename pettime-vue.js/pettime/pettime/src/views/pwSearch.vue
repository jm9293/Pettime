<template>
  <div class="pwSearch">
    <div class="login-box col-12 col-md-6">
      <div class="title col-12 text-center">
        <h1>비밀번호찾기</h1>
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
              v-model="id"
              required
            />
          </div>

          <div class="input-box col-12 col-md-12">
            <label for="inputPW" class="">이메일</label>
            <input
              type="text"
              class="form-control"
              name="inputPW"
              id="inputPW"
              placeholder=""
              v-model="email"
              required
            />
          </div>

          <div class="input-box col-12 col-md-12">
            <button class="login-btn btn btn-light col-12" type="submit">
              비밀번호 찾기
            </button>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "pwSearch",
  data() {
    return {
      id: "",
      email: "",
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
      form.append("id", this.id);
      form.append("email", this.email);

      this.$http
        .post(this.$store.state.baseurl + "/pettime/rest/pwSearch", form, con)
        .then((res) => {
          if (!res.data.cnt == 0) {
            alert("회원님의 이메일로 임시비밀번호가 발급되었습니다.");

            this.$router.push("login.vue");
          } else {
            alert("해당하는 정보를 찾을수 없습니다.");
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
.pwSearch .login-box {
  margin: 10% auto;
}
.pwSearch .input-box {
  margin: 2% 0;
}

.pwSearch a {
  color: rgb(255, 178, 146);
}

.pwSearch .row {
  padding: 0;
  text-align: center;
}
</style>
