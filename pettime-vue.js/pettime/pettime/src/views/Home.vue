<template>
  <div class="home">
    <b-jumbotron>
      <template #header>집으로 찾아오는 애견 미용</template>

      <template #lead>
        <br />
        애견 미용때문에 가족같은 반려견 스트레스 받지 않을까 고민하지 마세요.<br />
        Pettime은 출장디자이너들을 직접 찾아가 애견미용을 서비스해드립니다.
      </template>

      <hr class="my-4" />

      <p v-if="!$store.state.isLogin">
        간편한 예약과 결제 시스템으로 지금 바로 회원가입하고 예약해보세요.
      </p>

      <p v-if="$store.state.isLogin">
        간편한 예약과 결제 시스템으로 애견 미용을 예약해보세요.
      </p>

      <b-button variant="light" @click="gologin" v-if="!$store.state.isLogin"
        >로그인</b-button
      >
    </b-jumbotron>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: "Home",
  methods: {
    gologin() {
      this.$router.push("login.vue");
    },
    gosignup() {
      this.$router.push("signup.vue");
    },
  },
  components: {},
};
</script>

<style>
.jumbotron {
  background-color: white;
}
.jumbotron h1 {
  color: rgb(255, 178, 146);
}
</style>
