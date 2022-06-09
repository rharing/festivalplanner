import Vue from 'vue'
import Vuex from 'vuex'
import {Festival} from "@/domain/Festival";

let data = require("../domain/bks_parsed.json");

Vue.use(Vuex)
export default new Vuex.Store({
    state: {
        festival: new Festival(data.dagen)
        , events: []
        , filterEvents() {
            this.events = this.festival.filterEvents()
        },
        favs: []
    },
    getters: {
        favs: state => state.favs
        , events: state => state.events
        , podiums: state => state.festival.view.podiums
        , dagen: state => state.festival.view.dagen
    },
    mutations: {
        updatePodiumFestival(state, {id}) {
            console.log("in mutations got id:", id);
            console.log("state.podiums.data[id]=", state.podiums.data[id]);
            state.podiums.data[id].wanted = !state.podiums.data[id].wanted;
            state.filterEvents()
        },
        togglefav(state, payload) {
            payload.event.fav = !payload.event.fav;
            if (payload.event.fav) {
                if (!this.favs.includes(payload.event)) {
                    this.favs.push(payload.event);
                }
            } else {
                this.favs = this.favs.filter((storedevent) => storedevent != payload.event)
            }
        },

        toggleDag(state, {id}) {
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
