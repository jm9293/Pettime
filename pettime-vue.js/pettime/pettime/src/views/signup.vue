<template>
  <div class="signup">
    <div class="signup-box col-12 col-md-6">
      <div class="title col-12 text-center">
        <h1>회원가입</h1>
        <b>고객님의 개인정보는 소중히 보관됩니다.</b>
      </div>

      <div class="form-group">
        <div class="input-box" role="group">
          <label>아이디</label>
          <b-input-group>
            <b-form-input
              v-model="id"
              :class="idvalid ? '' : 'is-invalid'"
              aria-describedby="id-feedback"
              max="8"
              :disabled="iduq"
              placeholder="아이디는 영문 4~8자"
              trim
            ></b-form-input>
            <b-input-group-append>
              <b-button
                @click="iduqchk"
                variant="light"
                :disabled="!(idvalid && id != '')"
                >중복확인</b-button
              >
            </b-input-group-append>
            <b-form-invalid-feedback id="id-feedback">
              아이디는 4~8자 영문숫자여야 합니다.
            </b-form-invalid-feedback>
          </b-input-group>
          <b-form-text v-if="iduqtry">{{
            iduq == true
              ? "아이디 중복체크 되었습니다."
              : "아이디가 중복입니다."
          }}</b-form-text>
        </div>

        <div class="input-box" role="group">
          <label>비밀번호</label>
          <b-form-input
            v-model="password"
            :class="pwvalid ? '' : 'is-invalid'"
            type="password"
            max="8"
            aria-describedby="pw-feedback"
            placeholder="비밀번호는 영문 4~8자"
            trim
          ></b-form-input>

          <b-form-invalid-feedback id="pw-feedback">
            비밀번호는 6~8자 영문숫자여야 합니다.
          </b-form-invalid-feedback>
        </div>

        <div class="input-box" role="group">
          <label>비밀번호 확인</label>
          <b-form-input
            v-model="passwordchk"
            :class="pwchkvalid ? '' : 'is-invalid'"
            type="password"
            max="8"
            aria-describedby="pwchk-feedback"
            placeholder="비밀번호는 영문 4~8자"
            trim
          ></b-form-input>

          <b-form-invalid-feedback id="pwchk-feedback">
            비밀번호와 맞지 않습니다.
          </b-form-invalid-feedback>
        </div>

        <div class="input-box" role="group">
          <label>이름</label>
          <b-form-input
            v-model="inputname"
            :class="namevalid ? '' : 'is-invalid'"
            max="11"
            aria-describedby="name-feedback"
            placeholder="한글만 입력하세요"
            trim
          ></b-form-input>

          <b-form-invalid-feedback id="name-feedback">
            한글로 2~11글자만 입력할수 있습니다.
          </b-form-invalid-feedback>
        </div>

        <div class="input-box" role="group">
          <label>전화번호</label>
          <b-form-input
            v-model="phone"
            :class="phonevalid ? '' : 'is-invalid'"
            max="11"
            aria-describedby="phone-feedback"
            placeholder="'-' 없이 숫자만 입력하세요"
            trim
          ></b-form-input>

          <b-form-invalid-feedback id="phone-feedback">
            숫자 10~11자만 입력할수 있습니다.
          </b-form-invalid-feedback>
        </div>

        <div class="input-box" role="group">
          <label>이메일</label>
          <b-input-group>
            <b-form-input
              v-model="email"
              :class="emailvalid ? '' : 'is-invalid'"
              max="30"
              :disabled="emailuq"
              aria-describedby="email-feedback"
              placeholder="이메일을 입력해주세요."
              trim
            ></b-form-input>
            <b-input-group-append>
              <b-button
                @click="emailuqchk"
                variant="light"
                :disabled="!(emailvalid && email != '')"
                >중복확인</b-button
              >
            </b-input-group-append>
            <b-form-invalid-feedback id="email-feedback">
              이메일 형식이 아닙니다.
            </b-form-invalid-feedback>
          </b-input-group>
          <b-form-text v-if="emailuqtry">{{
            emailuq == true
              ? "이메일 중복체크 되었습니다."
              : "이메일 중복입니다."
          }}</b-form-text>
        </div>

        <br />
        <div class="input-box" role="group">
          <button
            class="login-btn btn btn-light col-12"
            @click="signupOk"
            :disabled="!signbtn"
          >
            회원가입
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "signup",
  data() {
    return {
      id: "",
      password: "",
      passwordchk: "",
      email: "",
      phone: "",
      inputname: "",
      iduq: false,
      emailuq: false,
      iduqtry: false,
      emailuqtry: false,
    };
  },
  mounted() {
    if (this.$store.state.isLogin) {
      alert("로그인중이면 접근불가!");
      this.$router.push("/");
    }
  },
  computed: {
    idvalid() {
      return (
        (/[a-z0-9]{4,6}/.test(this.id) &&
          /[a-z]/.test(this.id) &&
          /[0-9]/.test(this.id)) ||
        this.id == ""
      );
    },
    pwvalid() {
      return (
        /(?=.*[a-zA-Z])(?=.*\d).{6,8}/.test(this.password) ||
        this.password == ""
      );
    },
    pwchkvalid() {
      return this.password === this.passwordchk || this.passwordchk == "";
    },
    namevalid() {
      return /[가-힣]{2,11}/.test(this.inputname) || this.inputname == "";
    },
    phonevalid() {
      return /[0-9]{10,11}/.test(this.phone) || this.phone == "";
    },
    emailvalid() {
      return (
        /[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}/.test(this.email) ||
        this.email == ""
      );
    },

    signbtn() {
      return (
        this.idvalid &&
        this.pwvalid &&
        this.pwchkvalid &&
        this.namevalid &&
        this.phonevalid &&
        this.emailvalid &&
        this.id != "" &&
        this.passwordchk != "" &&
        this.password != "" &&
        this.inputname != "" &&
        this.phone != "" &&
        this.email != "" &&
        this.iduq &&
        this.emailuq
      );
    },
  },
  methods: {
    iduqchk() {
      this.iduqtry = true;
      var con = {
        headers: {
          "X-CSRF-TOKEN": this.$store.state.csrf,
        },
      };

      var form = new URLSearchParams();
      form.append("id", this.id);
      this.$http
        .post(this.$store.state.baseurl + "/pettime/rest/idchk", form, con)
        .then((res) => {
          if (res.data.cnt == 0) {
            this.iduq = true;
          } else {
            this.iduq = false;
          }
          this.$http
            .get(this.$store.state.baseurl + "/pettime/rest/csrf-token")
            .then((res) => {
              this.$store.commit("setCsrf", res.data);
            });
        });
    },

    emailuqchk() {
      this.emailuqtry = true;
      var con = {
        headers: {
          "X-CSRF-TOKEN": this.$store.state.csrf,
        },
      };

      var form = new URLSearchParams();
      form.append("email", this.email);
      this.$http
        .post(this.$store.state.baseurl + "/pettime/rest/emailchk", form, con)
        .then((res) => {
          if (res.data.cnt == 0) {
            this.emailuq = true;
          } else {
            this.emailuq = false;
          }
          this.$http
            .get(this.$store.state.baseurl + "/pettime/rest/csrf-token")
            .then((res) => {
              this.$store.commit("setCsrf", res.data);
            });
        });
    },

    signupOk() {
      var con = {
        headers: {
          "X-CSRF-TOKEN": this.$store.state.csrf,
        },
      };

      var form = new URLSearchParams();
      form.append("id", this.id);
      form.append("password", this.password);
      form.append("name", this.inputname);
      form.append("phone", this.phone);
      form.append("email", this.email);

      this.$http
        .post(this.$store.state.baseurl + "/pettime/rest/signup", form, con)
        .then((res) => {
          if (res.data.cnt == 1) {
            alert("감사합니다!\n회원가입 완료되었습니다.");
            this.$router.push("login.vue");
          } else {
            alert("서버 통신 오류");
          }
          this.$http
            .get(this.$store.state.baseurl + "/pettime/rest/csrf-token")
            .then((res) => {
              this.$store.commit("setCsrf", res.data);
            });
        });
    },

    // tryLogin() {
    //   alert("로그인 시도!");
    //   var con = {
    //     headers: {
    //       "X-CSRF-TOKEN": this.$store.state.csrf,
    //     },
    //   };
    //   var form = new URLSearchParams();
    //   form.append("username", this.username);
    //   form.append("password", this.password);
    //   this.$http.post(this.$store.state.baseurl+"/pettime/rest/loginAJAX", form, con).then((res) => {
    //     if (res.data.islogin) {
    //       alert("로그인되었습니다.");
    //       this.$store.state.isLogin = res.data.islogin;
    //       this.$store.state.userName = res.data.uesrname;
    //       this.$router.push("/");
    //     } else {
    //       alert(res.data.message);
    //     }
    //     this.$http.get(this.$store.state.baseurl+"/pettime/rest/csrf-token").then((res) => {
    //       this.$store.commit("setCsrf", res.data);
    //     });
    //   });
    // },
  },
  created() {},
};
</script>

<style>
.signup .title b {
  font-weight: 300;
  color: rgb(255, 178, 146);
}
.signup .signup-box {
  margin: 5% auto;
}

.signup .input-box {
  margin-top: 1%;
}
</style>
