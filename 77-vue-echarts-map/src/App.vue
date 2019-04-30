<template>
    <div id="app">
        <!--<img src="./assets/logo.png">-->
        <div id="beijing_map" style="width:1000px;height:999px"></div>
    </div>
</template>
<script>
  import echarts from "echarts"
  import "../node_modules/echarts/map/js/province/beijing";

  export default {
    mounted() {
      let myChart = echarts.init(document.getElementById('beijing_map'));
      let option = {
        series: [
          {
            name: "北京",
            type: 'map',
            mapType: "北京",
            label: {
              normal: {
                show: true,//显示省份标签
              },
              emphasis: {
                show: true,//对应的鼠标悬浮效果
              }
            },
          }
        ]
      };
      myChart.setOption(option);
      console.log(111)
    },
  }
</script>

