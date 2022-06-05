<template>
  <div>
    <v-card v-for="(event, index) in events" :key=index>
      <v-card-title>{{ event.wie }}</v-card-title>
      <v-card-text>
        <v-row align="center" class="mx-0">
          <div class="grey--text ms-4">
            <div>{{ event.podium }}</div>
            <div>{{ event.start }} {{ event.end }}</div>
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
