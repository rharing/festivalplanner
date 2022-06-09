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
            <div class="green --text ms-3">{{ event.start |tijd(showingFavs) }} {{ event.end|tijd(showingFavs) }}</div>
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
    return {}
  },
   mounted(){
     console.log("mounted events");
   },
  computed: {
    events() {
      let events = this.$store.getters.events;
      console.log("events", events);
      return events;
    } ,
    favs() {
      return this.$store.getters.favs;
    }
    ,
    showingFavs(){
      return this.$store.state.showingFavs;
    }
  },
  methods: {
    fav: function (event) {
      this.$store.commit("togglefav", event);
    }
  },
  filters: {
    tijd: function (value, showingfavs) {
      if (showingfavs)
        return moment(value).format('dddd HH:mm'
      )
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
