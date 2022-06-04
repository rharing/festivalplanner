import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
import {podiums} from "./podiums";

export default new Vuex.Store({
    state: {
        festival: undefined
        , events: []
        , days: [
            {id: -2, name: 'Alles', filtered: false},
            {id: 0, name: 'Vrijdag', filtered: false},
            {id: 1, name: 'Zaterdag', filtered: false},
            {id: 2, name: 'Zondag', filtered: false},
            {id: 4, name: 'Favs', filtered: false},
        ]
        , podiums: podiums
        ,
        filterEvents() {
            let wantedPodiums = this.podiums.filter()
            this.festival.dagen
            filterEvent(festivalevent => {
                if (this.festival) {
                    festival.allEvents().filter()
                }
            })
        }
   },
    getters: {
        events: state => state.events
    },
    mutations: {
        updatePodiumFestival(state, {id}) {
            console.log("in mutations got id:", id);
            console.log("state.podiums.data[id]=", state.podiums.data[id]);
            state.podiums.data[id].filtered = !state.podiums.data[id].filtered;
            state.filterEvents()
        },
        toggleDag(state, {id}){
            console.log('toggling dag:', id);
            let allState;
            if (id ==-2){
                //make all just like -2
                state.days[0].filtered = !state.days[0].filtered;
                allState = state.days[0].filtered;
            }
            for (let i=0; i<state.days.length;i++){
                let day = state.days[i];
                console.log("day", day)
                if (id == -2){
                    day.filtered = allState;
                }
                else if(day.id ==id) {
                    day.filtered = !day.filtered;
                }
            }
        },
        setFestival(state, {festival}) {
            state.festival = festival;
            state.filterEvents();
        }
    },
    actions: {},
    modules: {}
})
