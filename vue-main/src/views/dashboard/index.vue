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
    
    background-image: url('https://th.bing.com/th/id/R.355a077ecfeda012588d1307ac9a7800?rik=W3KqcYV2K6Wsrg&riu=http%3a%2f%2fup.iosdesk.com%2fpic_source%2f35%2f5a%2f07%2f355a077ecfeda012588d1307ac9a7800.jpg&ehk=3ZU%2b%2bAFCoH7iSioblUWR4l0xC6998LvC0so4L%2b6cPLY%3d&risl=&pid=ImgRaw&r=0');
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
