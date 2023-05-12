<template>
  <div id="index_container">
      <div id="map_wrap">
          <map-container></map-container>
      </div>
  </div>
</template>

<script>
import MapContainer from '@/components/MapContainer/MapContainer.vue'
export default {
  components: { MapContainer },

}
</script>

<style lang="less" scoped>
#index_container{
    height: 100%;
    width: 100%;
    position: relative;
}
#map_wrap{
    height: 60%;
    width: 60%;
}
</style>