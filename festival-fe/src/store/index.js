import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
import {podiums} from "/podiums";

export default new Vuex.Store({
  state: {
      festival
      ,events: []
      , days:[
          {id:-2, name: 'Alles', filtered:false},
          {id:0, name: 'Vrijdag', filtered:false},
          {id:1, name: 'Zaterdag', filtered:false},
          {id:2, name: 'Zondag', filtered:false},
          {id:4, name: 'Favs', filtered:false},
      ]
      , podiums: podiums
      ,
      filterEvents(){
          wantedPodiums = this.podiums.filter({})
          filterEvent(festivalevent){

          }
          if (this.festival){
              festival.allEvents().filter()
          }
      }

  },
  getters: {
      events: state=> state.events
  },
  mutations: {
      updatePodiumFestival(state, {id}){
          console.log(" got id:", id);
         console.log(state.podiums[id]);
        state.podiums[id].filtered = !state.podiums[id].filtered;
        state.filterEvents()
     }                                                           ,
      setFestival(state, {festival}) {
          state.festival = festival;
          state.filterEvents();
      }
  },
  actions: {
  },
  modules: {
  }
})
