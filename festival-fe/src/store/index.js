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
            state.podiums.data[id].wanted = !state.podiums.data[id].wanted;
            state.filterEvents()
        },
        togglefav(state, event) {
            event.fav = !event.fav;
            if (event.fav) {
                if (!this.state.favs.includes(event)) {
                    this.state.favs.push(event);
                    this.state.favs.sort((a, b) => a.start - b.start)
                    localStorage.setItem("bks_favs", JSON.stringify(this.state.favs));
                }
            } else {
                this.state.favs = this.state.favs.filter((storedevent) => storedevent != event)
                this.state.favs.sort((a, b) => a.start - b.start)
                localStorage.setItem("bks_favs", JSON.stringify(this.state.favs));

            }
        },
        setFavs(state, favs){
            state.favs = favs;
            let favElements = state.festival.allEvents().filter((element)=> favs.some((favElement)=> favElement.wie ==element.wie));
            favElements.forEach((element)=>element.fav = true);
        },
        toggleDagMutation(state, payload) {
            let id = payload
            if(payload?.id){
                id = payload.id
            }
            state.festival.view.toggleDag(id);
            if(id ==4){
                state.showingFavs=true
                state.events = this.state.favs;
            }
            else {
                state.events = this.state.festival.filterEvents();
                state.showingFavs=false

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
