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
            this.events = this.festival.allEvents()
            console.log(" this.events", this.events);
        },
        favs: [],
        showingFavs: false
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
        togglefav(state, event) {
            event.fav = !event.fav;
            if (event.fav) {
                if (!this.state.favs.includes(event)) {
                    this.state.favs.push(event);
                    localStorage.setItem("bks_favs", JSON.stringify(this.state.favs));
                }
            } else {
                this.state.favs = this.state.favs.filter((storedevent) => storedevent != event)
            }
        },

        toggleDag(state, {id}) {
            state.festival.view.toggleDag(id);
            if(id ==4){
                this.state.showingFavs=true
                this.state.events = this.state.favs;
            }
            else {
                this.state.events = this.state.festival.filterEvents();
                this.state.showingFavs=false

            }
        },
        setFestival(state, payload) {
            state.festival = payload.festival;
            state.events = state.festival.allEvents();
        }
    },
    actions: {},
    modules: {}
})
