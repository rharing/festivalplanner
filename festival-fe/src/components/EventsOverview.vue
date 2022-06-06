<template>
  <div>
    <v-card v-for="(event, index) in events" :key=index>
      <v-card-title>{{ event.wie }}</v-card-title>
      <v-card-text>
        <v-row align="center" class="mx-0">
          <div>
            <div class ="grey--text ms-4">{{ event.podium }}</div>
            <div class ="green --text ms-3">{{ event.start |tijd }} {{ event.end|tijd }}</div>
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

  computed: {
    events() {
      return this.$store.getters.events;
    }
  },
  filters:{
    tijd: function(value){
      console.log("value", value);
      return moment(value).format('HH:mm');
    }
  }

}
</script>
