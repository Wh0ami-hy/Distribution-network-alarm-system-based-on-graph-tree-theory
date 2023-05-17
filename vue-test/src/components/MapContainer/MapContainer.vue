<template>
  <div id="container"></div>
</template>

<script>
import AMapLoader from '@amap/amap-jsapi-loader'
	window._AMapSecurityConfig = {
  		securityJsCode: 'ceb74446c9ecaabe6020720a5bf9a26d'
	}
export default {
  data() {
    return {
      map: null
    }
  },
  methods: {
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
          // 添加固定点标记
          var marker1 = new AMap.Marker({
              content: '网点1',
              position: new AMap.LngLat(121.473667, 31.230525),   // 经纬度对象，也可以是经纬度构成的一维数组[121.473667, 31.230525]
              title: '北京'
          })

          //this.map.add(marker1)

          // 添加圆点标记
          var circleMarker1 = new AMap.CircleMarker({
            map:this.map,
            center: new AMap.LngLat(121.473667, 31.230525),
            radius: 20,   // 半径大小
            fillColor: '#22dc19', // 绿色  //#c80539 红色
          })

          circleMarker1.setMap(this.map)


        })
        .catch(e => {
          console.log(e)
        })
    }
  },
  mounted() {
    //DOM初始化完成进行地图初始化
    this.initMap()
  }
}
</script>

<style lang="less" scoped>
#container {
  padding: 0px;
  margin: 0px;
  width: 100%;
  height: 100%;
}
</style>

