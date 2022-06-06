<template>
  <v-app id="inspire">
    <v-app-bar
        app
        color="white"
        flat
    >
      <v-container class="py-0 fill-height">
        <v-avatar
            class="mr-10"
            color="grey darken-1"
            size="32"
        ></v-avatar>

      
        <v-spacer></v-spacer>

        <v-responsive max-width="260">

        </v-responsive>
      </v-container>
    </v-app-bar>

    <v-main class="grey lighten-3">
      <v-container>
        <v-row>
          <v-col cols="2">
            <v-sheet rounded="lg">
              <v-list color="transparent">
                <v-btn
                    v-for="dag in dagen"
                    :key="dag.id"
                    rounded depressed alert green
                    @click="toggleDag(dag.id)"
                    :class="{'lime white--text':dag.wanted}"
                >
                  {{ dag.name }}
                </v-btn>

                <v-divider class="my-2"></v-divider>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet
                min-height="70vh"
                rounded="lg"
            >
              <template v-if="!loaded"><div>loading...</div></template>
              <template v-else><router-view></router-view></template>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import { mapState} from 'vuex'
import Vue from "vue";
import {festival} from "@/domain/Festival";

let myfestival = new festival([])
export default {
  data: () => ({loaded: false}),
  methods: {
    selectPodium(podium) {
      console.log("filtering op ", podium.id);
      this.$store.commit('updatePodiumFestival', {id: podium.id});
    },
    toggleDag(id) {
      this.$store.commit('toggleDag', {id: id});
    }
  },
  mounted() {
    const endpoint = "http://localhost:3000/dagen"
    Vue.axios.get(endpoint).then(response => {

      var fest = new festival(response.data)
      this.$store.commit("setFestival", {festival:fest})
      console.log("done fetching so disable loading");
      this.loaded = true;
    });
  },
  computed: {
    ...mapState({
      dagen: state => state.festival.view.dagen,
    })
  }
}
</script>

