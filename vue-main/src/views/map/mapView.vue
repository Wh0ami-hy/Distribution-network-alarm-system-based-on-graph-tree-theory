<template>
  <div id="container"></div>
</template>

<script>
import AMapLoader from '@amap/amap-jsapi-loader'
import {createMap} from "@/api/node.js";

window._AMapSecurityConfig = {
  securityJsCode: 'ceb74446c9ecaabe6020720a5bf9a26d'
}

export default {
  data() {
    return {
      map: null,
      mapData : []
    }
  },
  methods: {
    loadData() {
      createMap().then((response)=>{
        this.mapData = response.data.data;
      })
    },
    initMap() {
      AMapLoader.load({
        key: '5625def45684788ad4cd785a05538cdf', // 申请好的Web端开发者Key，首次调用 load 时必填
        version: '2.0', // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
        plugins: [''] // 需要使用的的插件列表，如比例尺'AMap.Scale'等
      })
        .then(AMap => {
          this.map = new AMap.Map('container', {
            //设置地图容器id
            viewMode: '3D', //是否为3D地图模式
            zoom: 10, //初始化地图级别
            center: [121.473667, 31.230525] //初始化地图中心点位置
          })

          // 批量添加圆点标记  绿色：#22dc19 、红色：#c80539
          const circleMarkers = this.mapData
          circleMarkers.forEach(marker => { 
            marker.radius = 20
            const circleMarker = new AMap.CircleMarker(
              { 
              map: this.map,
              center: new AMap.LngLat(marker.center[0], marker.center[1]), radius: marker.radius, fillColor: marker.fillColor }) 
              circleMarker.setMap(this.map) 
          }) 
        })
        .catch(e => { console.log(e) }) 
    }, 
  }, 
  created() {
    this.loadData()
  },
  mounted() { //DOM初始化完成进行地图初始化 
    this.initMap() 
  } 
} 
</script>

<style lang="less" scoped>
#container {
  padding: 0px;
  margin: 0px;
  width: 100vmax;
  height: 100vmax;
}
</style>