import Vue from 'vue'
import VueRouter from 'vue-router'
import mapView from '@/views/map/mapView'

Vue.use(VueRouter)

const routes = [
  {
    path: '/view',
    component: mapView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
