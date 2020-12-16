<template>
  <div class="map">
    <div class="col-12 col-md-8 map-box">
      <h2>오시는길</h2>
      <br />
      <div id="map">ss</div>
      <br />
      <h5>서울특별시 강남구 역삼역 3번출구</h5>
    </div>
  </div>
</template>
<script>
export default {
  mounted() {
    window.kakao && window.kakao.maps ? this.initMap() : this.addScript();
  },
  methods: {
    initMap() {
      console.log("a");
      var container = document.getElementById("map");
      var options = {
        center: new kakao.maps.LatLng(37.50040798580193, 127.0356008059151),
        level: 3,
      };
      var map = new kakao.maps.Map(container, options); //마커추가하려면 객체를 아래와 같이 하나 만든다.
      var marker = new kakao.maps.Marker({ position: map.getCenter() });
      marker.setMap(map);
    },
    addScript() {
      console.log("b");
      const script = document.createElement("script");
      /* global kakao */ script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=12cf41907ec9dfc03f51fa4ea3287959";
      document.head.appendChild(script);
    },
  },
};
</script>
<style>
#map {
  min-height: 500px;
  border-radius: 20px;
}

.map-box {
  margin: auto;
}
</style>
