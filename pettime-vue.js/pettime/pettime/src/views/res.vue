<template>
  <div class="res" v-if="$store.state.isLogin">
    <div class="res-box col-12 col-md-6">
      <div class="title col-12 text-center">
        <h1>애견 미용 예약</h1>
        <b>편안하게 애견미용서비스를 받으세요.</b>
      </div>

      <div class="form-group">
        <div class="input-box" role="group">
          <label>예약일</label>
          <b-input-group>
            <b-form-datepicker
              id="example-datepicker"
              v-model="date"
              placeholder="날짜를 입력해주세요."
              :min="mindate"
              :max="maxdate"
            ></b-form-datepicker>
          </b-input-group>
          <b-form-invalid-feedback id="pw-feedback">
            비밀번호는 6~8자 영문숫자여야 합니다.
          </b-form-invalid-feedback>
          <b-form-text>예약은 1일~7후만 가능합니다. </b-form-text>
        </div>

        <div class="input-box" role="group">
          <label>예약시간</label>
          <b-form-select v-model="time">
            <!-- This slot appears above the options from 'options' prop -->

            <b-form-select-option value="" disabled>
              시간을 선택해주세요.
            </b-form-select-option>

            <!-- These options will appear after the ones from 'options' prop -->
            <b-form-select-option value="time1"
              >오전 9시~11시</b-form-select-option
            >
            <b-form-select-option value="time2"
              >오후 1시~3시</b-form-select-option
            >
            <b-form-select-option value="time3"
              >오후 4시~6시</b-form-select-option
            >
          </b-form-select>
          <b-form-text>3TIME 운영제입니다.</b-form-text>
        </div>

        <div class="input-box" role="group">
          <label>방문주소</label>
          <b-input-group>
            <b-input-group-prepend is-text>
              <b-form-checkbox switch class="mr-n2" v-model="adchk">
              </b-form-checkbox>
            </b-input-group-prepend>
            <b-form-input
              :disabled="!adchk"
              v-model="address"
              @click="goPopup"
              :class="addclass"
              readonly
            ></b-form-input>
            <b-form-invalid-feedback id="email-feedback">
              서울시만 서비스중입니다.
            </b-form-invalid-feedback>
          </b-input-group>
          <b-form-text v-if="!adchk"
            >방문 미용을 예약하시려면 체크해주세요. (서울시한정)</b-form-text
          >
        </div>
        <div class="input-box" role="group">
          <button
            class="login-btn btn btn-primary col-12"
            :disabled="!calldesignboll"
            v-if="!calleddesign"
            @click="calldesigner"
          >
            다음단계로
          </button>
        </div>
        <!--디자이너 선택 단계 -->
        <div class="input-box" role="group" v-if="!selected && calleddesign">
          <label>디자이너 선택</label>
          <div v-for="(designer, index) in desiners" :key="index">
            <b-card no-body class="overflow-hidden">
              <b-row no-gutters>
                <b-col md="5">
                  <div class="img-box">
                    <b-card-img
                      thumbnail
                      class=""
                      :src="'/pettime/designerimg/' + designer.id + '.jpg'"
                      alt="Image"
                    ></b-card-img>
                  </div>
                </b-col>
                <b-col md="7">
                  <b-card-body :title="designer.name + ' 디자이너'">
                    <b-card-text>
                      {{ designer.intro }}
                    </b-card-text>
                    <b-button @click="select(index)" variant="primary"
                      >선택하기</b-button
                    >
                  </b-card-body>
                </b-col>
              </b-row>
            </b-card>
          </div>
        </div>

        <div class="input-box" role="group" v-if="selected">
          <label>디자이너</label>
          <b-card no-body class="overflow-hidden">
            <b-row no-gutters>
              <b-col md="5">
                <div class="img-box">
                  <b-card-img
                    thumbnail
                    class=""
                    :src="'/pettime/designerimg/' + selectdesigner.id + '.jpg'"
                    alt="Image"
                  ></b-card-img>
                </div>
              </b-col>
              <b-col md="7">
                <b-card-body :title="selectdesigner.name + ' 디자이너'">
                  <b-card-text>
                    {{ selectdesigner.intro }}
                  </b-card-text>
                </b-card-body>
              </b-col>
            </b-row>
          </b-card>
        </div>

        <div class="input-box" role="group" v-if="selected">
          <label>펫사진</label>
          <div class="img-box" v-if="photo != null">
            <b-img-lazy
              :src="photourl"
              alt="photo"
              rounded="circle"
              class="col-12"
            ></b-img-lazy>
          </div>

          <b-form-file
            v-model="photo"
            @change="onChangeImages"
            placeholder="펫의 사진을 넣어주세요."
            v-if="photo == null"
          ></b-form-file>
        </div>

        <div class="input-box" role="group" v-if="selected">
          <label>펫이름</label>
          <b-form-input
            v-model="petname"
            max="11"
            placeholder="펫의이름을 입력해주세요."
            trim
          ></b-form-input>
        </div>

        <div class="input-box" role="group" v-if="selected">
          <label>견종</label>
          <b-form-input
            v-model="pettype"
            max="11"
            placeholder="견종을 입력하세요."
            trim
          ></b-form-input
          ><b-form-text>견종을모르시면 '모름' 이라고 적어주세요.</b-form-text>
        </div>

        <div class="input-box" role="group" v-if="selected">
          <label>상세설명</label>
          <b-form-textarea
            id="textarea"
            v-model="petmemo"
            placeholder="반려견에 대한 설명을 써주세요."
            max="300"
            rows="3"
            max-rows="6"
          ></b-form-textarea>
        </div>
        <div class="input-box" role="group" v-if="selected">
          <label>메뉴선택</label>
          <b-form-checkbox-group v-model="selectedMenu">
            <div>
              <b-card title="출장비용" v-if="adchk">
                <b-card-text> 가격 : 30000원 </b-card-text>
              </b-card>
            </div>
            <div v-for="(menu, index) in menus" :key="index">
              <div>
                <b-card :title="menu.subject">
                  <b-card-text> 가격 : {{ menu.price }}원 </b-card-text>
                  <b-form-checkbox :value="menu">선택하기</b-form-checkbox>
                </b-card>
              </div>
            </div>
          </b-form-checkbox-group>
          <br />
          <h3>예상결제 금액 : {{ selectedMenuPrice }}원</h3>
        </div>
        <br />
        <div class="input-box" role="group">
          <button
            class="login-btn btn btn-primary col-12"
            v-if="selected"
            :disabled="!complateRes"
            @click="payforkakao"
          >
            결제
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "res",
  data() {
    const max = new Date();
    max.setDate(max.getDate() + 7);
    const min = new Date();
    min.setDate(min.getDate() + 1);
    return {
      photo: null,
      date: "",
      maxdate: max,
      mindate: min,
      pettype: "",
      petname: "",
      petmemo: "",
      addclass: "",
      time: "",
      address: "",
      adchk: false,
      badadd: false,
      calleddesign: false,
      selected: false,
      sggNm: "",
      totprice: 0,
      userdata: {},
      desiners: [],
      menus: [],
      selectedMenu: [],
      photourl: "",
    };
  },
  mounted() {},
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
  },
  watch: {
    adchk: "adchkInit",
  },
  computed: {
    calldesignboll() {
      return (
        this.date != "" &&
        this.time != "" &&
        ((this.adchk && this.address != "") ||
          (!this.adchk && this.address == ""))
      );
    },
    selectedMenuPrice() {
      this.totpriceInit();
      this.selectedMenu.forEach((e) => {
        this.totprice += e.price;
      });

      return this.totprice;
    },
    complateRes() {
      return (
        this.petname != "" &&
        this.pettype != "" &&
        this.petmemo != "" &&
        this.selectedMenu.length != 0 &&
        this.photo != null
      );
    },
  },
  methods: {
    goPopup() {
      window.open(
        this.$store.state.baseurl + "/pettime/jusoPopup",
        "pop",
        "width=570,height=420, scrollbars=yes, resizable=yes"
      );
    },

    jusoCallBack(roadFullAddr, siNm, sggNm) {
      if (siNm != "서울특별시") {
        this.badadd = true;
        this.addclass = "is-invalid";
        return;
      } else {
        this.badadd = false;
        this.addclass = "";
      }
      this.address = roadFullAddr;
      this.sggNm = sggNm;
    },

    adchkInit() {
      this.address = "";
    },

    onChangeImages(e) {
      const file = e.target.files[0];
      this.photourl = URL.createObjectURL(file);
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
            this.userdata = res.data.data[0];
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

    select(index) {
      this.selectdesigner = this.desiners[index];
      this.selected = true;
    },

    menuchk(index) {
      console.log(index);
    },

    totpriceInit() {
      if (this.adchk) {
        this.totprice = 30000;
      } else {
        this.totprice = 0;
      }
    },

    payforkakao() {
      window.IMP.init("imp88185101");
      window.IMP.request_pay(
        {
          pg: "inicis",
          pay_method: "card",
          merchant_uid: "ResList_" + new Date().getTime(),
          name: "PETIME 예약결제",
          amount: 100,
          buyer_email: this.userdata.email,
          buyer_name: this.userdata.name,
          buyer_tel: this.userdata.phone,
        },
        function(rsp) {
          var kmsg = "";
          if (rsp.success) {
            kmsg = "예약 완료되었습니다.";
            kmsg += "\n결제 금액 : " + rsp.paid_amount + "원";
            window.app.$route.matched[0].instances.default.setRes();
          } else {
            kmsg = "결제에 실패하였습니다.";
            kmsg += "에러내용 : " + rsp.error_msg;
          }

          alert(kmsg);
        }
      );
    },

    setRes() {
      const reslist = {
        stime: new Date(),
        address: this.address,
        userId: "",
        degId: this.selectdesigner.id,
        petName: this.petname,
        petKind: this.pettype,
        petMemo: this.petmemo,
        tPrice: this.totprice,
      };

      switch (this.time) {
        case "time1":
          reslist.stime = new Date(this.date + " 09:00:00");
          break;
        case "time2":
          reslist.stime = new Date(this.date + " 13:00:00");
          break;
        case "time3":
          reslist.stime = new Date(this.date + " 16:00:00");
          break;
      }

      var con = {
        headers: {
          "X-CSRF-TOKEN": this.$store.state.csrf,
          "Content-Type": "multipart/form-data",
        },
      };

      var form = new FormData();
      this.selectedMenu.forEach((e) => {
        form.append("menu", e.subject + "/" + e.price);
      });
      form.append("stimeLong", reslist.stime.getTime());
      form.append("address", this.address);
      form.append("userId", "");
      form.append("degId", this.selectdesigner.id);
      form.append("petName", this.petname);
      form.append("petKind", this.pettype);
      form.append("petMemo", this.petmemo);
      form.append("tPrice", this.totprice);
      form.append("time", this.time);
      form.append("photo", this.photo);
      console.log(reslist.stime);
      this.$http
        .post(this.$store.state.baseurl + "/pettime/rest/setResList", form, con)
        .then((res) => {
          if (res.data.cnt == 0) {
            alert("서버 문제.");
          } else {
            this.$router.push("/");
          }

          this.$http
            .get(this.$store.state.baseurl + "/pettime/rest/csrf-token")
            .then((res) => {
              this.$store.commit("setCsrf", res.data);
            });
        });
    },

    calldesigner() {
      this.update();
      if (!this.adchk) {
        this.sggNm = "center";
      }

      var con = {
        headers: {
          "X-CSRF-TOKEN": this.$store.state.csrf,
        },
      };

      var form = new URLSearchParams();
      form.append("date", this.date);
      form.append("time", this.time);

      this.$http
        .post(
          this.$store.state.baseurl + "/pettime/rest/calldesigners",
          form,
          con
        )
        .then((res) => {
          if (res.data.cnt > 0) {
            this.desiners = res.data.data;
            this.menus = res.data.data2;
            this.calleddesign = true;
          } else {
            alert("예약가능한 디자이너가 없습니다.");
          }
          this.$http
            .get(this.$store.state.baseurl + "/pettime/rest/csrf-token")
            .then((res) => {
              this.$store.commit("setCsrf", res.data);
            });
        });
    },
  },
};
</script>

<style>
.res {
  min-height: 700px;
}

.res .title b {
  font-weight: 300;
  color: rgb(52, 152, 219);
}
.res .res-box {
  margin: 5% auto;
}

.res .input-box {
  margin-top: 1%;
}

.res .cardimg {
  display: block;
  height: 100%;
  width: 100%;
  max-height: 250px;
}

.card {
  margin: 10px 0;
}

.res .img-box {
  padding-bottom: 100%;
  object-fit: cover;
  position: relative;
  height: 0;
}

.img-box img {
  position: absolute;
  top: 10%;
  left: 10%;
  right: 0;
  bottom: 0;
  max-width: 80%;
  height: 80%;
}

.res .cardbody {
  text-align: center;
}
</style>
