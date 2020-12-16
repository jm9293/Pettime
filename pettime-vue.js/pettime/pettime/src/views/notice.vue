<template>
  <div class="notice">
    <div class="col-12 col-md-8 head"><h2>공지사항</h2></div>
    <br />
    <div class="menuname menuborder row col-12 col-md-8">
      <div class="col-4 col-md-2 menu">No</div>
      <div class="col-8 col-md-4 menu">제목</div>
      <div class="col-4 col-md-2 menu">조회</div>
      <div class="col-8 col-md-4 menu">작성일</div>
    </div>

    <div
      class="menuname row col-12 col-md-8 textlist"
      v-for="listdata in list"
      v-bind:key="listdata.num"
      @click="clickList(listdata.num)"
    >
      <div class="col-4 col-md-2 text" id="text1">{{ listdata.num }}</div>
      <div class="col-8 col-md-4 text" id="text2">{{ listdata.title }}</div>
      <div class="col-4 col-md-2 text" id="text3">
        {{ listdata.viewcnt }}
      </div>
      <div class="col-8 col-md-4 text">
        {{ new Date(listdata.wrdate) | moment("YYYY-MM-DD") }}
      </div>
    </div>

    <div class="box_ul">
      <ul class="box_li">
        <li class="paging" v-on:click="beforePage"><div>이전</div></li>
        <span v-for="num in maxpage" v-bind:key="num">
          <li class="paging">
            <div
              v-bind:class="{ active: $store.state.noticePage == num }"
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
  name: "notice",
  data() {
    return {
      list: [],

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
            "/pettime/rest/notice/list/" +
            this.$store.state.noticePage
        )
        .then((res) => {
          this.list = res.data.data;
          this.maxpage = res.data.maxpage;
        });
    },
    nextPage() {
      this.$store.state.noticePage++;
      if (this.$store.state.noticePage > this.maxpage) {
        this.$store.state.noticePage = this.maxpage;
      }
      console.log(this.page);
      this.updateList();
    },
    beforePage() {
      this.$store.state.noticePage--;
      if (this.$store.state.noticePage < 1) {
        this.$store.state.noticePage = 1;
      }

      this.updateList();
    },
    selectPage(e) {
      this.$store.state.noticePage = e.target.innerText;
      this.updateList();
    },
    clickList(num) {
      this.$router.push({ name: "noticeView", query: { uid: num } });
    },
  },
};
</script>

<style>
.notice .menuname {
  margin: auto;

  padding: 0;
}
.notice {
  margin-top: 5%;
}
.notice .menu {
  text-align: center;
  background-color: rgba(255, 178, 146, 0.8);
  height: 45px;
  line-height: 45px;
  box-sizing: border-box;
  border: 1px solid white;
}
.notice .textlist:hover {
  background: rgb(190, 189, 189);
  opacity: 0.9;
}
.notice .textlist {
  border-bottom: 1px solid rgb(158, 156, 156);
  padding: 0;
}
.notice .menuborder {
  border-radius: 5px 5px 0px 0px;
  padding: 0;
}
.notice .text {
  box-sizing: border-box;
  text-align: center;
  height: 45px;
  line-height: 45px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.notice a {
  text-decoration: none;
  color: black;
}
.notice a:hover {
  text-decoration: none;
  color: black;
}
.notice #text1 {
  border-right: 1px dotted rgb(190, 189, 189);
  border-bottom: 1px dotted rgb(190, 189, 189);
}
.notice #text2 {
  border-bottom: 1px dotted rgb(190, 189, 189);
}
.notice #text3 {
  border-right: 1px dotted rgb(190, 189, 189);
}
.notice h2 {
  font-weight: bold;
}
.notice .head {
  margin: auto;
}
.notice .box_ul {
  text-align: center;
  margin: 5% auto;
}
.notice .box_li {
  list-style-type: none;
}
.notice .paging {
  display: inline-block;
}
.notice .paging div {
  color: black;
  float: left;
  padding: 4px 8px;
  text-decoration: none;
  transition: background-color 0.3s;
  /* border: 1px solid #ddd; */
  /* margin: 0 4px; */
  margin: 0px;
}
.notice .paging div.active {
  border-radius: 30%;
  background-color: rgba(255, 178, 146, 0.8);
  color: black;
}
.notice .paging div:hover:not(.active) {
  background-color: #ddd;
}

@media (min-width: 767px) {
  .notice #text1 {
    border: 0;
  }
  .notice #text2 {
    border: 0;
  }
  .notice #text3 {
    border: 0;
  }
}
</style>
