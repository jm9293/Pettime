<template>
  <div class="qnaWrite">
    <div class="col-12 col-md-8 head"><h2>질문 수정</h2></div>
    <div class="col-12 col-md-8 titlebox">
      <input
        type="text"
        class="form-control col-12"
        v-model="title"
        placeholder="제목을 작성하세요"
      />
      <h6 class="title">글번호 : {{ qna.num }}</h6>
      <h6 class="title">조회수 : {{ qna.viewcnt }}</h6>
    </div>
    <div class="row col-12 col-md-8 contentbox">
      <textarea
        class="col-12 form-control"
        v-model="content"
        placeholder="내용을 작성하세요"
        rows="5"
        maxlength="300"
      ></textarea>

      <b-form-checkbox v-model="open" name="checkbox-1">
        비공개
      </b-form-checkbox>
    </div>
    <br />
    <div class="col-12 col-md-8 btn-box">
      <button
        type="button"
        id="back"
        class="btn btn-light btn-md"
        @click="write"
      >
        수정하기
      </button>
    </div>
    <br /><br />
  </div>
</template>

<script>
export default {
  name: "qnaWrite",
  data() {
    return { num: 0, title: "", content: "", open: false, qna: {} };
  },
  created() {
    this.update();
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
          this.title = res.data.data[0].title;
          this.num = res.data.data[0].num;
          this.content = res.data.data[0].content;
          this.open = res.data.data[0].open == "Y" ? false : true;
          if (this.qna.userid != this.$store.state.userName) {
            alert("본인글만 수정가능합니다.");
            this.$router.push("qna.vue");
          }
        });
    },
    write() {
      if (this.title.trim() === "" || this.content.trim() === "") {
        alert("제목과 내용을 필수작성해야합니다.");
        return;
      }

      var con = {
        headers: {
          "X-CSRF-TOKEN": this.$store.state.csrf,
        },
      };

      var form = new URLSearchParams();
      form.append("num", this.num);
      form.append("title", this.title);
      form.append("content", this.content);
      var openchar = this.open ? "N" : "Y";
      form.append("open", openchar);
      this.$http
        .post(this.$store.state.baseurl + "/pettime/rest/qna/update", form, con)
        .then((res) => {
          if (res.data.status == "OK") {
            alert("수정완료 되었습니다.");
            this.$router.push({ name: "qnaView", query: { uid: this.num } });
          } else {
            alert("서버통신오류");
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
.qnaWrite {
  margin-top: 5%;
}
.qnaWrite .titlebox {
  text-align: left;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin: 2% auto;
}

.qnaWrite .anser {
  text-align: left;
  text-overflow: ellipsis;
  white-space: nowrap;
  margin: 2% auto;
}
.qnaWrite h2 {
  font-weight: bold;
}
.qnaWrite .head {
  margin: auto;
}
.qnaWrite .title {
  margin: auto;
}
.qnaWrite .contentbox {
  overflow: auto;
  margin: auto;
}
.qnaWrite #back {
  text-align: center;
  margin: auto;
  display: block;
}
.qnaWrite .btn-box {
  margin: auto;
  text-align: center;
}

@media (min-width: 767px) {
  .qnaWrite .contentbox {
    font-size: 20px;
  }
}
</style>
