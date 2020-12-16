<template>
  <div class="qna">
    <div class="col-12 col-md-8 head"><h2>묻고 답하기</h2></div>
    <br />
    <div class="menuname menuborder row col-12 col-md-8">
      <div class="col-2 col-md-1 menu">No</div>
      <div class="col-6 col-md-3 menu">제목</div>
      <div class="col-4 col-md-2 menu">작성자</div>
      <div class="col-2 col-md-2 menu">조회</div>
      <div class="col-6 col-md-2 menu">작성일</div>
      <div class="col-4 col-md-2 menu">공개여부</div>
    </div>

    <div
      class="menuname row col-12 col-md-8 textlist"
      v-for="listdata in list"
      v-bind:key="listdata.num"
      @click="clickList(listdata.num)"
    >
      <div class="col-2 col-md-1 text" id="text1">{{ listdata.num }}</div>
      <div class="col-6 col-md-3 text" id="text2">
        {{ listdata.title }}&nbsp;
        <b-badge variant="success" v-if="listdata.anser != null">답변</b-badge>
      </div>
      <div class="col-4 col-md-2 text" id="text3">
        {{ listdata.userid }}
      </div>
      <div class="col-2 col-md-2 text" id="text4">
        {{ listdata.viewcnt }}
      </div>
      <div class="col-6 col-md-2 text" id="text5">
        {{ new Date(listdata.wrdate) | moment("YYYY-MM-DD") }}
      </div>
      <div class="col-4 col-md-2 text">
        {{ listdata.open == "Y" ? "공개" : "비공개" }}
      </div>
    </div>
    <div class="btnbox col-12 col-md-8 row">
      <div class="btnchild col-8 col-md-10 row">
        <div class="col-11 col-md-8 row search-box">
          <input
            type="text"
            class="col-6 form-control"
            placeholder="검색어를 입력해주세요"
            v-model="searchVal"
          /><button
            type="button"
            class="col-3 btn btn-primary btn-sm form-control"
            @click="searchList"
          >
            검색
          </button>
        </div>
      </div>

      <button
        type="button"
        id="write"
        class="col-4 col-md-2 btn btn-primary btn-sm form-control"
        @click="goWrite"
      >
        글쓰기
      </button>
    </div>

    <div class="box_ul">
      <ul class="box_li">
        <li class="paging" v-on:click="beforePage"><div>이전</div></li>
        <span v-for="num in maxpage" v-bind:key="num">
          <li class="paging">
            <div
              v-bind:class="{ active: $store.state.qnaPage == num }"
              v-on:click="selectPage"
            >
              {{ num }}
            </div>
          </li>
        </span>
        <li class="paging" v-on:click="nextPage"><div>다음</div></li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "qna",
  data() {
    return {
      list: [],
      searchVal: "",
      maxpage: 0,
    };
  },
  created() {
    this.updateList();
  },
  mounted() {
    this.updateList();
  },
  methods: {
    updateList() {
      this.$http
        .get(
          this.$store.state.baseurl +
            "/pettime/rest/qna/list/" +
            this.$store.state.qnaPage
        )
        .then((res) => {
          this.list = res.data.data;
          this.maxpage = res.data.maxpage;
        });
    },
    nextPage() {
      this.$store.state.qnaPage++;
      if (this.$store.state.qnaPage > this.maxpage) {
        this.$store.state.qnaPage = this.maxpage;
      }

      this.updateList();
    },
    beforePage() {
      this.$store.state.qnaPage--;
      if (this.$store.state.qnaPage < 1) {
        this.$store.state.qnaPage = 1;
      }

      this.updateList();
    },
    selectPage(e) {
      this.$store.state.qnaPage = e.target.innerText;
      this.updateList();
    },
    clickList(num) {
      this.$router.push({ name: "qnaView", query: { uid: num } });
    },
    goWrite() {
      if (this.$store.state.isLogin) {
        this.$router.push("qnaWrite.vue");
      } else {
        alert("회원만 게시글 작성할수 있습니다.");
        this.$router.push("login.vue");
      }
    },
    searchList() {
      if (this.searchVal == "") {
        alert("검색어를 입력해주세요.");
      } else {
        this.$router.push({
          name: "qnaSearch",
          query: { val: this.searchVal },
        });
        this.$store.state.qnaSearchPage = 1;
      }
    },
  },
};
</script>

<style>
.qna #write {
  text-align: center;
  margin: 1% auto;
}

.qna .menuname {
  margin: auto;

  padding: 0;
}
.qna {
  margin-top: 5%;
}
.qna .btnbox {
  margin: auto;
  padding: 0;
}
.qna .menu {
  text-align: center;
  background-color: rgba(255, 178, 146, 0.8);
  height: 45px;
  line-height: 45px;
  box-sizing: border-box;
  border: 1px solid white;
}
.qna .textlist:hover {
  background: rgb(190, 189, 189);
  opacity: 0.9;
}
.qna .textlist {
  border-bottom: 1px solid rgb(158, 156, 156);
  padding: 0;
}
.qna .menuborder {
  border-radius: 5px 5px 0px 0px;
  padding: 0;
}
.qna .text {
  box-sizing: border-box;
  text-align: center;
  height: 45px;
  line-height: 45px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.qna a {
  text-decoration: none;
  color: black;
}
.qna a:hover {
  text-decoration: none;
  color: black;
}
.qna #text1 {
  border-right: 1px dotted rgb(190, 189, 189);
  border-bottom: 1px dotted rgb(190, 189, 189);
}
.qna #text2 {
  border-right: 1px dotted rgb(190, 189, 189);
  border-bottom: 1px dotted rgb(190, 189, 189);
}
.qna #text3 {
  border-bottom: 1px dotted rgb(190, 189, 189);
}
.qna #text4 {
  border-right: 1px dotted rgb(190, 189, 189);
}
.qna #text5 {
  border-right: 1px dotted rgb(190, 189, 189);
}
.qna h2 {
  font-weight: bold;
}
.qna .head {
  margin: auto;
}

.qna .btnchild {
  margin: 1% auto;
}

.qna .search-box {
  margin: 0;
  padding: 0;
}
.qna .search-box input {
  margin: 0;
}

.qna .search-box button {
  margin: 0;
  margin-left: 2%;
}

.qna .box_ul {
  text-align: center;
  margin: 2% auto;
}
.qna .box_li {
  list-style-type: none;
}
.qna .paging {
  display: inline-block;
}
.qna .paging div {
  color: black;
  float: left;
  padding: 4px 8px;
  text-decoration: none;
  transition: background-color 0.3s;
  /* border: 1px solid #ddd; */
  /* margin: 0 4px; */
  margin: 0px;
}
.qna .paging div.active {
  border-radius: 30%;
  background-color: rgba(255, 178, 146, 0.8);
  color: black;
}
.qna .paging div:hover:not(.active) {
  background-color: #ddd;
}
.qna .badge {
  font-weight: 300;
}

@media (min-width: 767px) {
  .qna #text1 {
    border: 0;
  }
  .qna #text2 {
    border: 0;
  }
  .qna #text3 {
    border: 0;
  }
  .qna #text4 {
    border: 0;
  }
  .qna #text5 {
    border: 0;
  }
}
</style>
