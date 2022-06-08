import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component:() => import('@/components/EventsOverview.vue')
  },
  {
    path: '/register-user',
    name: 'register-user',
    component: () => import('@/components/RegisterComponent.vue')
  },
  {
    path: '/signin',
    name: 'signin',
    component: () => import('@/components/LoginComponent.vue')
  },
  {
    path: '/dashboard',
    name: 'dashboard',
    component: () => import('@/components/DashboardComponent.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
