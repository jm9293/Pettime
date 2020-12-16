<template>
  <div class="userUpdate">
    <div class="userUpdate-box col-12 col-md-6">
      <div class="title col-12 text-center">
        <h1>회원정보변경</h1>
        <b>변경하고 싶은 정보를 선택하세요</b>
      </div>

      <div class="form-group">
        <div class="input-box" role="group">
          <label>비밀번호</label>
          <b-input-group>
            <b-input-group-prepend is-text>
              <b-form-checkbox switch class="mr-n2" v-model="upPw">
              </b-form-checkbox>
            </b-input-group-prepend>
            <b-form-input
              v-model="password"
              :class="pwvalid ? '' : 'is-invalid'"
              :disabled="!upPw"
              type="password"
              max="8"
              aria-describedby="pw-feedback"
              placeholder="비밀번호는 영문 4~8자"
              trim
            ></b-form-input>
          </b-input-group>
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
            :disabled="!upPw"
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
          <label>전화번호</label>
          <b-input-group>
            <b-input-group-prepend is-text>
              <b-form-checkbox switch class="mr-n2" v-model="upPhone">
              </b-form-checkbox>
            </b-input-group-prepend>
            <b-form-input
              v-model="phone"
              :class="phonevalid ? '' : 'is-invalid'"
              :disabled="!upPhone"
              max="11"
              aria-describedby="phone-feedback"
              placeholder="'-' 없이 숫자만 입력하세요"
              trim
            ></b-form-input>
          </b-input-group>
          <b-form-invalid-feedback id="phone-feedback">
            숫자 10~11자만 입력할수 있습니다.
          </b-form-invalid-feedback>
        </div>

        <div class="input-box" role="group">
          <label>이메일</label>
          <b-input-group>
            <b-input-group-prepend is-text>
              <b-form-checkbox switch class="mr-n2" v-model="upEmail">
              </b-form-checkbox>
            </b-input-group-prepend>
            <b-form-input
              v-model="email"
              :class="emailvalid ? '' : 'is-invalid'"
              max="30"
              :disabled="emailuq || !upEmail"
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
          </b-input-group>
          <b-form-invalid-feedback id="email-feedback">
            이메일 형식이 아닙니다.
          </b-form-invalid-feedback>
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
            @click="userUpdateOk"
            :disabled="!signbtn"
          >
            정보변경
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "userUpdate",
  data() {
    return {
      password: "",
      passwordchk: "",
      email: "",
      phone: "",
      emailuq: false,
      emailuqtry: false,
      upPw: false,
      upPhone: false,
      upEmail: false,
    };
  },
  mounted() {
    if (!this.$store.state.isLogin) {
      alert("로그인중이아니면 접근불가!");
      this.$router.push("/");
    }
  },
  created() {
    this.update();
  },
  computed: {
    pwvalid() {
      return (
        /(?=.*[a-zA-Z])(?=.*\d).{6,8}/.test(this.password) ||
        this.password == ""
      );
    },
    pwchkvalid() {
      return this.password === this.passwordchk || this.passwordchk == "";
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
      var pwbool = true;
      var emailbool = true;
      var phonebool = true;
      var trybool = this.upPw || this.upPhone || this.upEmail;
      if (this.upPw) {
        pwbool =
          this.pwvalid &&
          this.pwchkvalid &&
          this.password != "" &&
          this.passwordchk != "";
      }

      if (this.upPhone) {
        phonebool = this.phonevalid && this.phone != "";
      }

      if (this.upEmail) {
        emailbool = this.email != "" && this.emailvalid && this.emailuq;
      }

      return pwbool && emailbool && phonebool && trybool;
    },
  },
  methods: {
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

    update() {
      var con = {
        headers: {
          "X-CSRF-TOKEN": this.$store.state.csrf,
        },
      };

      var form = new URLSearchParams();

      this.$http
        .post(this.$store.state.baseurl + "/pettime/rest/userinfo", form, con)
        .then((res) => {
          if (res.data.cnt == 1) {
            var user = res.data.data[0];
            this.phone = user.phone;
            this.email = user.email;
            this.emailuq = false;
            this.emailuqtry = false;
            this.upPw = false;
            this.upPhone = false;
            this.upEmail = false;
          } else {
            alert("서버 통신오류");
          }
          this.$http
            .get(this.$store.state.baseurl + "/pettime/rest/csrf-token")
            .then((res) => {
              this.$store.commit("setCsrf", res.data);
            });
        });
    },

    userUpdateOk() {
      var con = {
        headers: {
          "X-CSRF-TOKEN": this.$store.state.csrf,
        },
      };

      var form = new URLSearchParams();
      if (this.upPw && this.pwvalid && this.pwchkvalid) {
        form.append("password", this.password);
      }
      if (this.upPhone && this.phonevalid) {
        form.append("phone", this.phone);
      }
      if (this.upEmail && this.emailvalid && this.emailuq) {
        form.append("email", this.email);
      }
      form.append("name", "update");

      this.$http
        .post(this.$store.state.baseurl + "/pettime/rest/userUpdate", form, con)
        .then((res) => {
          if (res.data.cnt == 1) {
            alert("수정되었습니다.");
            this.update();
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
};
</script>

<style>
.userUpdate .title b {
  font-weight: 300;
  color: rgb(52, 152, 219);
}
.userUpdate .userUpdate-box {
  margin: 5% auto;
}

.userUpdate .input-box {
  margin-top: 1%;
}
</style>
