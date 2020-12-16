<template>
  <div class="resListView" v-if="createOk">
    <div class="col-12 col-md-6 head"><h2>예약신청서 보기</h2></div>
    <br />

    <div class="col-12 col-md-6 titlebox">
      <h6>신청정보</h6>
      <label class="title">신청번호 : {{ resList.num }}</label
      ><br />
      <label class="title">
        신청일시 :
        {{ new Date(resList.stime) | moment("YYYY-MM-DD HH시") }} </label
      ><br />
      <label class="title">출장주소 : {{ resList.address }}</label
      ><br />
      <label class="title">디자이너 : {{ resList.degId }}</label
      ><br />
      <label class="title">결제금액 : {{ resList.tprice }}원</label><br />
      <label class="title">예약상태 : {{ resList.state }}</label
      ><br />
    </div>
    <br />
    <div class="col-12 col-md-6 titlebox">
      <h6>애견정보</h6>
      <b-card no-body class="overflow-hidden">
        <b-row no-gutters>
          <b-col md="3">
            <div class="img-box">
              <b-card-img
                thumbnail
                class=""
                :src="'/pettime/petimg/' + resList.num + '.jpg'"
                alt="Image"
              ></b-card-img>
            </div>
          </b-col>
          <b-col md="9">
            <b-card-body :title="resList.petName + ' / ' + resList.petKind">
              <b-card-text>
                {{ resList.petMemo }}
              </b-card-text>
            </b-card-body>
          </b-col>
        </b-row>
      </b-card>
      <h6>상세정보</h6>
      <div v-for="resdetail in resdetails" v-bind:key="resdetail.num">
        <b-card :title="resdetail.content">
          <b-card-text> 가격 : {{ resdetail.price }}원 </b-card-text>
        </b-card>
      </div>
    </div>

    <br />
    <button
      type="button"
      id="back"
      class="btn btn-primary btn-md"
      @click="backList"
    >
      목록으로
    </button>
    <br /><br />
  </div>
</template>

<script>
export default {
  name: "resListView",
  data() {
    return { resList: {}, resdetails: {}, createOk: false };
  },
  methods: {
    update() {
      this.$http
        .get(
          this.$store.state.baseurl +
            "/pettime/rest/resList/view/" +
            this.$route.query.uid
        )
        .then((res) => {
          if (!res.data.cnt == 0) {
            this.resList = res.data.data[0];
            this.resdetails = res.data.data2;
            this.createOk = true;
          } else {
            alert("예약내역을 찾을수 없습니다.");
          }
        });
    },
    backList() {
      this.$router.push("resList.vue");
    },
  },
  created() {
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

        if (!this.$store.state.isLogin) {
          console.log(this.$store.state.isLogin);
          alert("로그인중이아니면 접근불가!");
          this.$router.push("/");
        }
      });

    this.update();
  },
};
</script>

<style>
.resListView {
  margin-top: 5%;
}
.resListView .titlebox {
  text-align: left;
  text-overflow: ellipsis;
  white-space: nowrap;
  height: auto;
  margin: auto;
}
.resListView h2 {
  font-weight: bold;
}
.resListView .head {
  margin: auto;
}
.resListView .title {
  margin: auto;
}
.resListView .contentbox {
  height: 395px;
  overflow: auto;
  margin: auto;
}
.resListView #back {
  text-align: center;
  margin: auto;
  display: block;
}

.resListView .img-box {
  padding-bottom: 100%;
  object-fit: cover;
  position: relative;
  height: 0;
}

.resListView .img-box img {
  position: absolute;
  top: 10%;
  left: 10%;
  right: 0;
  bottom: 0;
  max-width: 80%;
  height: 80%;
}

.form-control[readonly] {
  background-color: white;
  opacity: 1;
}
@media (min-width: 767px) {
  .resListView .contentbox {
    font-size: 20px;
  }
}
</style>
