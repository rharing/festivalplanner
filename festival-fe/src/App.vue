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

        <v-btn
            v-for="dag in dagen"
            :key="dag.id"
            rounded depressed alert green
            @click="toggleDag(dag.id)"
            :class="{'lime white--text':dag.filtered}"
        >
   {{dag.name}}
        </v-btn>

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
                <v-list-item
                    v-for="podium in podiums.data"
                    :key="podium.id"

                >
                  <v-list-item-content>
                    <v-list-item-title>
                      <v-checkbox @click="selectPodium(podium)" :label="podium.name"/>
                    </v-list-item-title>
                  </v-list-item-content>
                </v-list-item>

                <v-divider class="my-2"></v-divider>
              </v-list>
            </v-sheet>
          </v-col>

          <v-col>
            <v-sheet
                min-height="70vh"
                rounded="lg"
            >
              <router-view></router-view>

            </v-sheet>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import {mapState, mapMutations} from 'vuex'

export default {
  data: () => ({}),
  methods: {
    selectPodium(podium) {
      console.log("filtering op ", podium.id);
      this.$store.commit('updatePodiumFestival', {id: podium.id});
    },
    toggleDag(id) {
      this.$store.commit('toggleDag', {id: id});
    }
  },
  computed: {
    ...mapState({
      podiums: state => state.podiums,
      dagen: state => state.days,
    })
  }
}
</script>

