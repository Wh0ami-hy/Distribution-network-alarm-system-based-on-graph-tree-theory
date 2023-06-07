<template>
  <div class="dashboard-container">
    <div class="dashboard-text">欢迎 {{ name }} 使用配电网报警系统</div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    height: 93vh;
    
    background-image: url('../../assets/404_images/background.jpg');
    background-size: cover;
    background-position: center;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
    color: rgb(243, 42, 42);
  }
}
</style>
