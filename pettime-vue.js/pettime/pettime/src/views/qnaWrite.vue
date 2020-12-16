<template>
  <div class="qnaWrite">
    <div class="col-12 col-md-8 head"><h2>질문 작성</h2></div>
    <div class="col-12 col-md-8 titlebox">
      <input
        type="text"
        class="form-control col-12"
        v-model="title"
        placeholder="제목을 작성하세요"
      />
    </div>
    <div class="row col-12 col-md-8 contentbox">
      <textarea
        class="col-12 form-control"
        v-model="content"
        placeholder="내용을 작성하세요"
        rows="5"
        maxlength="300"
      ></textarea>
      <input type="checkbox" value="비공개" v-model="open" /> 비공개
    </div>
    <br />
    <div class="col-12 col-md-8 btn-box">
      <button
        type="button"
        id="back"
        class="btn btn-primary btn-md"
        @click="write"
      >
        작성하기
      </button>
    </div>
    <br /><br />
  </div>
</template>

<script>
export default {
  name: "qnaWrite",
  data() {
    return { title: "", content: "", open: false };
  },
  methods: {
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
      form.append("title", this.title);
      form.append("content", this.content);
      var openchar = this.open ? "N" : "Y";
      form.append("open", openchar);
      this.$http
        .post(this.$store.state.baseurl + "/pettime/rest/qna/write", form, con)
        .then((res) => {
          if (res.data.status == "OK") {
            alert("작성완료 되었습니다.");
            this.$router.push("qna.vue");
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

@media (min-width: 767px) {
  .qnaWrite .contentbox {
    font-size: 20px;
  }
}
</style>
