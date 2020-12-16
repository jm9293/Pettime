<template>
  <div class="resList" v-if="$store.state.isLogin">
    <div class="col-12 col-md-8 head"><h2>예약확인</h2></div>
    <br />
    <div class="menuname menuborder row col-12 col-md-8">
      <div class="col-4 col-md-2 menu">No</div>
      <div class="col-8 col-md-4 menu">주소</div>
      <div class="col-4 col-md-2 menu">펫이름</div>
      <div class="col-8 col-md-4 menu">예약일</div>
    </div>

    <div
      class="menuname row col-12 col-md-8 textlist"
      v-for="listdata in list"
      v-bind:key="listdata.num"
      @click="clickList(listdata.num)"
    >
      <div class="col-4 col-md-2 text" id="text1">{{ listdata.num }}</div>
      <div class="col-8 col-md-4 text" id="text2">{{ listdata.address }}</div>
      <div class="col-4 col-md-2 text" id="text3">
        {{ listdata.petName }}
      </div>
      <div class="col-8 col-md-4 text">
        {{ new Date(listdata.stime) | moment("YYYY-MM-DD HH시") }}
      </div>
    </div>

    <div class="box_ul">
      <ul class="box_li">
        <li class="paging" v-on:click="beforePage"><div>이전</div></li>
        <span v-for="num in maxpage" v-bind:key="num">
          <li class="paging">
            <div
              v-bind:class="{ active: $store.state.resListPage == num }"
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
  name: "resList",
  data() {
    return {
      list: [],

      maxpage: 0,
    };
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
    this.updateList();
  },
  mounted() {
    //this.updateList();
  },
  methods: {
    updateList() {
      this.$http
        .get(
          this.$store.state.baseurl +
            "/pettime/rest/resList/list/" +
            this.$store.state.resListPage
        )
        .then((res) => {
          this.list = res.data.data;
          this.maxpage = res.data.maxpage;
        });
    },
    nextPage() {
      this.$store.state.resListPage++;
      if (this.$store.state.resListPage > this.maxpage) {
        this.$store.state.resListPage = this.maxpage;
      }
      console.log(this.page);
      this.updateList();
    },
    beforePage() {
      this.$store.state.resListPage--;
      if (this.$store.state.resListPage < 1) {
        this.$store.state.resListPage = 1;
      }

      this.updateList();
    },
    selectPage(e) {
      this.$store.state.resListPage = e.target.innerText;
      this.updateList();
    },
    clickList(num) {
      this.$router.push({ name: "resListView", query: { uid: num } });
    },
  },
};
</script>

<style>
.resList .menuname {
  margin: auto;

  padding: 0;
}
.resList {
  margin-top: 5%;
}
.resList .menu {
  text-align: center;
  background-color: rgba(255, 178, 146, 0.8);
  height: 45px;
  line-height: 45px;
  box-sizing: border-box;
  border: 1px solid white;
}
.resList .textlist:hover {
  background: rgb(190, 189, 189);
  opacity: 0.9;
}
.resList .textlist {
  border-bottom: 1px solid rgb(158, 156, 156);
  padding: 0;
}
.resList .menuborder {
  border-radius: 5px 5px 0px 0px;
  padding: 0;
}
.resList .text {
  box-sizing: border-box;
  text-align: center;
  height: 45px;
  line-height: 45px;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.resList a {
  text-decoration: none;
  color: black;
}
.resList a:hover {
  text-decoration: none;
  color: black;
}
.resList #text1 {
  border-right: 1px dotted rgb(190, 189, 189);
  border-bottom: 1px dotted rgb(190, 189, 189);
}
.resList #text2 {
  border-bottom: 1px dotted rgb(190, 189, 189);
}
.resList #text3 {
  border-right: 1px dotted rgb(190, 189, 189);
}
.resList h2 {
  font-weight: bold;
}
.resList .head {
  margin: auto;
}
.resList .box_ul {
  text-align: center;
  margin: 5% auto;
}
.resList .box_li {
  list-style-type: none;
}
.resList .paging {
  display: inline-block;
}
.resList .paging div {
  color: black;
  float: left;
  padding: 4px 8px;
  text-decoration: none;
  transition: background-color 0.3s;
  /* border: 1px solid #ddd; */
  /* margin: 0 4px; */
  margin: 0px;
}
.resList .paging div.active {
  border-radius: 30%;
  background-color: rgba(255, 178, 146, 0.8);
  color: black;
}
.resList .paging div:hover:not(.active) {
  background-color: #ddd;
}

@media (min-width: 767px) {
  .resList #text1 {
    border: 0;
  }
  .resList #text2 {
    border: 0;
  }
  .resList #text3 {
    border: 0;
  }
}
</style>
