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
            v-for="link in dagen"
            :key="link.id"
            text
        >
          {{ link.name }}
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
                    v-for="podium in podiums"
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
            ><router-view></router-view>

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
  data: () => ({
  }),
  methods:{
    selectPodium(podium){
      console.log("filtering op ", podium.id);

    }
  }   ,
  computed:  {
    ...mapState({
      podiums : state => state.podiums,
      dagen: state => state.days,
    })
  }
}
</script>

