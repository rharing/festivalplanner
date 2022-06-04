import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
      festival:{}
      , days:[
          {id:-2, name: 'Alles', filtered:false},
          {id:0, name: 'Vrijdag', filtered:false},
          {id:1, name: 'Zaterdag', filtered:false},
          {id:2, name: 'Zondag', filtered:false},
          {id:4, name: 'Favs', filtered:false},
      ]
      , podiums: [
          {id:0, name: 'ONE', filtered:false}
          ,{id:1, name: 'TWO', filtered:false}
          ,{id:2, name: 'SECRET', filtered:false}
          ,{id:3, name: 'CASBAH', filtered:false}
          ,{id:4, name: 'FLOOR', filtered:false}
      ],
  },
  getters: {
  },
  mutations: {
     setPodium(state, id){
         console.log(state.podiums[id]);
        state.podiums[id].filtered = !state.podiums[id].filtered;
     }
  },
  actions: {
  },
  modules: {
  }
})
