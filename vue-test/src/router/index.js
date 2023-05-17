import Vue from 'vue'
import VueRouter from 'vue-router'
import treeView from '@/views/tree/treeView'

Vue.use(VueRouter)

const routes = [
  {
    path: '/treeView',
    component: treeView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
