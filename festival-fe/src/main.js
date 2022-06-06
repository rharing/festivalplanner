import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import axios from 'axios'
import VueAxios from 'vue-axios'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import vueMoment from 'vue-moment'
// Vue.use(require("vue-moment"));
Vue.config.productionTip = false
Vue.use(VueAxios, axios, vueMoment)
new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
