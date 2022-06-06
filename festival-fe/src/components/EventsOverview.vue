<template>
  <div>
    <v-card v-for="(event, index) in events" :key=index>
      <v-card-title>{{ event.wie }}</v-card-title>
      <v-card-text>
        <v-row align="center" class="mx-0">
          <div>
            <div class ="grey--text ms-4">{{ event.podium }}</div>
            <div class ="green --text ms-3">{{ event.start | moment("HH:mm") }} {{ event.end| moment("dddd, MMMM Do YYYY") }}</div>
          </div>
        </v-row>
      </v-card-text>
    </v-card>
  </div>
</template>
<script>
import Vue from 'vue'
import {mapState, mapGetters} from 'vuex'

export default {
  data() {
    return {}
  },

  computed: {
    events() {
      return this.$store.getters.events;
    }
  }

}
</script>
