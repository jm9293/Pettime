<template>
  <div id="app">
    <div>
      <b-navbar toggleable="md" type="light" variant="white">
        <b-navbar-brand class="logo" to="/">Pettime</b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <!-- Right aligned nav items -->
          <b-navbar-nav class="ml-auto">
            <b-nav-item-dropdown no-caret text="미용예약" right>
              <b-dropdown-item to="/res.vue">미용예약</b-dropdown-item>
              <b-dropdown-item to="/resList.vue" @click="resListInit"
                >예약확인</b-dropdown-item
              >
            </b-nav-item-dropdown>

            <b-nav-item-dropdown no-caret text="회사소개" right>
              <b-dropdown-item to="/about.vue">Pettime 소개</b-dropdown-item>
              <b-dropdown-item to="/map.vue">오시는길</b-dropdown-item>
            </b-nav-item-dropdown>

            <b-nav-item-dropdown no-caret text="고객센터" right>
              <b-dropdown-item to="/notice.vue" @click="noitceInit"
                >공지사항</b-dropdown-item
              >
              <b-dropdown-item to="/qna.vue">묻고답하기</b-dropdown-item>
            </b-nav-item-dropdown>

            <b-nav-item-dropdown
              no-caret
              v-if="!$store.state.isLogin"
              text="로그인"
              right
            >
              <b-dropdown-item to="/login.vue">로그인</b-dropdown-item>
              <b-dropdown-item to="/signup.vue">회원가입</b-dropdown-item>
            </b-nav-item-dropdown>

            <b-nav-item-dropdown
              no-caret
              v-if="$store.state.isLogin"
              text="회원정보"
              right
            >
              <b-dropdown-item to="/userUpdate.vue"
                >회원정보 변경</b-dropdown-item
              >
              <b-dropdown-item @click="logout">로그아웃</b-dropdown-item>
            </b-nav-item-dropdown>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>

    <div class="main">
      <router-view :key="$route.fullPath" />
    </div>
    <footer>
      <div>
        <b-navbar-brand to="/">Pettime</b-navbar-brand>
        <p>
          © 2020. 통신판매업. Pettime, Inc. All Rights Reserved.<br />
          사업자등록번호 : 777-77-7777 | 인허가번호 : 2020-8312391-34-67-9882 |
          대표이사 : Gang H.Y | 전화 : 1588-0000 | 주소 : 서울특별시 역삼역 3번
          출구
        </p>
      </div>
    </footer>
  </div>
</template>
<script>
export default {
  created() {
    this.$http
      .get(this.$store.state.baseurl + "/pettime/rest/csrf-token")
      .then((res) => {
        this.$store.commit("setCsrf", res.data);
      });
    this.islogin();
    const script = document.createElement("script");
    script.onload = () => kakao.maps.load(this.initMap);
    script.src =
      "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=12cf41907ec9dfc03f51fa4ea3287959";
    document.head.appendChild(script);
  },
  watch: {
    // 라우터 객체를 감시하고 있다가 islogin() 함수를 호출한다
    $route: "islogin",
  },
  methods: {
    islogin() {
      this.$http
        .get(this.$store.state.baseurl + "/pettime/rest/isLogin")
        .then((res) => {
          if (res.data.islogin) {
            this.$store.state.isLogin = res.data.islogin;
            this.$store.state.userName = res.data.username;
          } else {
            this.$store.state.isLogin = false;
            this.$store.state.userName = "";
          }
        });
    },

    noitceInit() {
      this.$store.state.noticePage = 1;
      this.$route.matched[0].instances.default.updateList();
    },
    addScript() {
      const script = document.createElement("script");
      /* global kakao */ script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=12cf41907ec9dfc03f51fa4ea3287959";
      document.head.appendChild(script);
    },
    resListInit() {
      this.$store.state.resListPage = 1;
      this.$route.matched[0].instances.default.updateList();
    },
    logout() {
      var con = {
        headers: {
          "X-CSRF-TOKEN": this.$store.state.csrf,
        },
      };
      var form = new URLSearchParams();
      this.$http.post("/pettime/rest/logout", form, con).then(() => {
        alert("로그아웃 되었습니다.");
        this.$store.state.isLogin = false;
        this.$store.state.userName = "";
        this.$http
          .get(this.$store.state.baseurl + "/pettime/rest/csrf-token")
          .then((res) => {
            this.$store.commit("setCsrf", res.data);
            this.$router.push("/");
          });
      });
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;900&display=swap");

#app {
  font-family: "Noto Sans KR", sans-serif;
}

body {
  background-image: url("../img/back.png");
  background-size: cover;
}
.main {
  min-height: 750px;
}

#app .navbar-light .navbar-brand {
  color: rgb(255, 178, 146);
  font-size: 30px;
  font-weight: 600;
}

#app .navbar-nav > li {
  margin-right: 12.5px;
}

#app .navbar-nav > li > a {
  padding: 15px 15px;
}

#app .navbar-light .navbar-toggler {
  color: rgba(0, 0, 0, 0.5);
  border-color: white;
}

#app .navbar-light .navbar-toggler:focus {
  border-color: white;
  outline: none;
}

#app footer {
  display: block;
  position: relative;
  height: 150px;
  width: 100%;
  bottom: 0;
}

#app footer a {
  color: rgb(255, 178, 146);
  font-size: 30px;
  font-weight: 600;
}
#app footer p {
  font-size: 0.7rem;
}

#app footer > div {
  position: absolute;
  top: 10%;
  left: 1%;
  width: 80%;
}
</style>
