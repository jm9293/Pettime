<template>
  <div class="qnaView" v-if="isview">
    <div class="col-12 col-md-8 head"><h2>묻고 답하기</h2></div>
    <div class="col-12 col-md-8 titlebox">
      <h3 class="title">{{ qna.title }}</h3>
      <h6 class="title">조회수 : {{ qna.viewcnt }}</h6>
      <h6 class="title">작성자 : {{ qna.userid }}</h6>
      <h6 class="title">
        공개여부 : {{ qna.open == "Y" ? "공개" : "비공개" }}
      </h6>
      <h6 class="title">
        작성일 : {{ new Date(qna.wrdate) | moment("YYYY년 MM월 DD일") }}
      </h6>
    </div>
    <div class="row col-12 col-md-8 contentbox">
      <textarea
        class="col-12 form-control"
        readonly
        rows="5"
        v-model="qna.content"
      ></textarea>
    </div>
    <div class="col-12 col-md-8 anser" v-if="qna.anser != null">
      <h3 class="title">답변</h3>
      <h6 class="title">작성자 : 관리자</h6>
      <h6 class="title">
        작성일 : {{ new Date(qna.andate) | moment("YYYY년 MM월 DD일") }}
      </h6>
    </div>

    <div class="row col-12 col-md-8 contentbox" v-if="qna.anser != null">
      <textarea
        class="col-12 form-control"
        readonly
        rows="5"
        v-model="qna.anser"
      ></textarea>
    </div>

    <br />
    <div class="row col-12 col-md-8 titlebox btn-box">
      <div class="col-4 ">
        <button
          type="button"
          class="btn btn-light btn-md"
          v-if="qna.userid == $store.state.userName && qna.anser == null"
          @click="goUpdate"
        >
          수정
        </button>
      </div>
      <div class="col-4">
        <button
          type="button"
          id="back"
          class="btn btn-light btn-md"
          @click="backList"
        >
          목록으로
        </button>
      </div>
      <div class="col-4">
        <button
          type="button"
          class="btn btn-light btn-md"
          v-if="qna.userid == $store.state.userName"
          @click="goDelete"
        >
          삭제
        </button>
      </div>
    </div>

    <br /><br />
  </div>
</template>

<script>
export default {
  name: "qnaView",
  data() {
    return { qna: {}, isview: false };
  },
  methods: {
    update() {
      this.$http
        .get(
          this.$store.state.baseurl +
            "/pettime/rest/qna/view/" +
            this.$route.query.uid
        )
        .then((res) => {
          this.qna = res.data.data[0];
          if (
            this.qna.userid != this.$store.state.userName &&
            this.qna.open == "N"
          ) {
            this.$router.push("qna.vue");
            alert("비공개글입니다.");
            this.isview = false;
          } else {
            this.isview = true;
          }
        });
    },
    backList() {
      this.$router.push("qna.vue");
    },

    goUpdate() {
      this.$router.push({ name: "qnaUpdate", query: { uid: this.qna.num } });
    },
    goDelete() {
      var con = {
        headers: {
          "X-CSRF-TOKEN": this.$store.state.csrf,
        },
      };
      var form = new URLSearchParams();
      form.append("num", this.qna.num);

      this.$http
        .post(this.$store.state.baseurl + "/pettime/rest/qna/delete", form, con)
        .then((res) => {
          if (res.data.status == "OK") {
            alert("삭제완료되었습니다.");
            this.$router.push("qna.vue");
          } else {
            alert("서버통신문제");
          }
          this.$http
            .get(this.$store.state.baseurl + "/pettime/rest/csrf-token")
            .then((res) => {
              this.$store.commit("setCsrf", res.data);
            });
        });
    },
  },
  created() {
    this.update();
  },
};
</script>

<style>
.qnaView {
  margin-top: 5%;
}
.qnaView .titlebox {
  text-align: left;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin: 2% auto;
}

.qnaView .anser {
  text-align: left;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin: 2% auto;
}
.qnaView h2 {
  font-weight: bold;
}
.qnaView .head {
  margin: auto;
}
.qnaView .title {
  margin: auto;
}
.qnaView .contentbox {
  overflow: auto;
  margin: auto;
}
.qnaView #back {
  text-align: center;
  margin: auto;
  display: block;
}

.form-control[readonly] {
  background-color: white;
  opacity: 1;
}

.btn-box {
  text-align: center;
}
@media (min-width: 767px) {
  .qnaView .contentbox {
    font-size: 20px;
  }
}
</style>
