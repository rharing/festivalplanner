<template>
  <div>
    events:
    <v-card v-for="(event, index) in events" :key=index>
      <v-card-title>{{ event.wie }}
        <v-card-actions>
          <v-btn icon @click="fav(event)">
            <v-icon v-if="event.fav">mdi-heart</v-icon>
            <v-icon v-if="!event.fav">mdi-heart-outline</v-icon>
          </v-btn>
        </v-card-actions>
      </v-card-title>
      <v-card-text>
        <v-row align="center" class="mx-0">
          <div>
            <div class="grey--text ms-4">{{ event.podium }}</div>
            <div class="green --text ms-3">{{ event.start |tijd }} {{ event.end|tijd }}</div>
          </div>
        </v-row>
      </v-card-text>
    </v-card>
  </div>
</template>
<script>
import moment from 'moment'

export default {
  data() {
    return {favs: []}
  },

  computed: {
    events() {
      return this.$store.getters.events;
    }
  },
  methods: {
    fav: function (event) {
      event.fav = !event.fav;
      if (event.fav) {
        if (!this.favs.includes(event)) {
          this.favs.push(event);
        }
      } else {
        this.favs = this.favs.filter((storedevent) => storedevent != event)
      }
    }
  },
  filters: {
    tijd: function (value) {
      return moment(value).format('HH:mm');
    },
    favSign: function (value) {
      if (this.favs.includes(value)) {
        return "mdi-heart"
      }
      return "mdi-heart-outline";
    }
  }

}
</script>
