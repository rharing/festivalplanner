<template>
  <v-app id="inspire">
    <v-app-bar
        app
        color="white"
        flat
    >
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
              <template v-if="!loaded">
                <div>loading...</div>
              </template>
              <template v-else>
                <router-view></router-view>
              </template>
            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import {mapState} from 'vuex'
import Vue from "vue";
import {Festival} from "@/domain/Festival";

export default {
  data: () => ({
    loaded: false,
    auth: false, email: ''
  }),
  methods: {
    toggleDag(id) {
      this.$store.commit("toggleDagMutation", id)
    },
  },
  created() {
  },
  mounted() {
      // var fest = new Festival(response.data)
      // this.$store.commit("setFestival", {festival: fest})
      // console.log("done fetching so disable loading");
    console.log("mounted so starting by selecting all");
    this.$store.commit("toggleDagMutation", -2)

    // });
    console.log("app.vue mounted")
    let favs = JSON.parse(localStorage.getItem('bks_favs'));
    console.log(" found favs:", favs);
    this.$store.commit('setFavs',favs);
    this.loaded = true;
  },
  computed: {
    ...mapState({
      dagen: state => state.festival.view.dagen,
    })
  }
}
</script>

