import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import axios from 'axios'
import VueAxios from 'vue-axios'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import firebase from 'firebase/compat/app';
import {_} from './firebase-setup'
Vue.config.productionTip = false
Vue.use(VueAxios, axios)

// Database connection

// Import the functions you need from the SDKs you need

// import { initializeApp } from "firebase/app";
// import { getAnalytics } from "firebase/analytics";

// https://firebase.google.com/docs/web/setup#available-libraries
new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
