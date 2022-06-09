import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component:() => import('@/components/DashboardComponent.vue')
  },
  {
    path: '/events',
    name: 'eventsView',
    component: () => import('@/components/EventsOverview.vue')
  }
]

const router = new VueRouter({
  base: process.env.BASE_URL,
  routes
})

export default router
