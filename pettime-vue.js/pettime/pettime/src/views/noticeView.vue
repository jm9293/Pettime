<template>
  <div class="noticeView">
    <div class="col-12 col-md-8 head"><h2>공지사항</h2></div>
    <br />

    <div class="col-12 col-md-8 titlebox">
      <h3 class="title">제목 : {{ notice.title }}</h3>
      <br />
      <h6 class="title">조회수 : {{ notice.viewcnt }}</h6>
      <h6 class="title">작성자 : 관리자</h6>
      <h6 class="title">
        작성일 : {{ new Date(notice.wrdate) | moment("YYYY년 MM월 DD일") }}
      </h6>
    </div>
    <div class="row col-12 col-md-8 contentbox">
      <textarea
        class="col-12 form-control"
        readonly
        rows="5"
        v-model="notice.content"
      ></textarea>
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
  name: "noticeView",
  data() {
    return { notice: {} };
  },
  methods: {
    update() {
      this.$http
        .get(
          this.$store.state.baseurl +
            "/pettime/rest/notice/view/" +
            this.$route.query.uid
        )
        .then((res) => {
          this.notice = res.data.data[0];
        });
    },
    backList() {
      this.$router.push("notice.vue");
    },
  },
  created() {
    this.update();
  },
};
</script>

<style>
.noticeView {
  margin-top: 5%;
}
.noticeView .titlebox {
  text-align: left;
  text-overflow: ellipsis;
  white-space: nowrap;
  height: 150px;
  margin: auto;
}
.noticeView h2 {
  font-weight: bold;
}
.noticeView .head {
  margin: auto;
}
.noticeView .title {
  margin: auto;
}
.noticeView .contentbox {
  height: 395px;
  overflow: auto;
  margin: auto;
}
.noticeView #back {
  text-align: center;
  margin: auto;
  display: block;
}

.form-control[readonly] {
  background-color: white;
  opacity: 1;
}
@media (min-width: 767px) {
  .noticeView .contentbox {
    font-size: 20px;
  }
}
</style>
