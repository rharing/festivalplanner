import Vue from 'vue'
import Vuex from 'vuex'
import {Festival} from "@/domain/Festival";

Vue.use(Vuex)
export default new Vuex.Store({
    state: {
        festival: new Festival([])
        , events: []
        , filterEvents() {
            this.events = this.festival.filterEvents()
        },
        favs:[]
   },
    getters: {
        favs: state => state.favs
        , events: state => state.events
        ,podiums: state => state.festival.view.podiums
        ,dagen: state => state.festival.view.dagen
    },
    mutations: {
        updatePodiumFestival(state, {id}) {
            console.log("in mutations got id:", id);
            console.log("state.podiums.data[id]=", state.podiums.data[id]);
            state.podiums.data[id].wanted = !state.podiums.data[id].wanted;
            state.filterEvents()
        },

        toggleDag(state, {id}){
            console.log('toggling dag:', id);
                state.festival.view.toggleDag(id);
            this.state.events = this.state.festival.filterEvents();
        },
        setFestival(state, payload) {
            state.festival = payload.festival;
            state.events = state.festival.allEvents();
        }
    },
    actions: {},
    modules: {}
})
