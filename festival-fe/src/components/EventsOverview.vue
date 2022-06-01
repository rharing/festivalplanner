<template>
  <div>
    events...

  </div>
</template>
<script>
import Vue from 'vue'

function dag(data) {
  this.dag = new Date(data.dag)
  this.when = data.when
  this.podiums = [];
  for (let i = 0; i < data.podiums.length; i++) {
    const mypodium = data.podiums[i];
      let podium1 = new podium(mypodium);
      this.podiums.push(podium1)
    }
}
function festivalEvent(data){
  this.start = new Date(data.start);
  this.end = new Date(data.end);
  this.startWhen = data.startWhen
  this.endWhen = data.endWhen
  this.wie = data.wie
}

function podium(data) {
  this.name = data.name;
  this.events =[];
  for (let i = 0; i < data.events.length; i++) {
    const myevent = data.events[i];
    let festivalEvent1 = new festivalEvent(myevent);
    this.events.push(festivalEvent1);
  }
  console.log("events:", this.events);
}

function festival(data) {
  this.dagen = [];
  for (let i = 0; i < data.length; i++) {
    const mydag = data[i];
    this.dagen.push(new dag(mydag))

  }
}

export default {
  data() {
    return {
      events: []
    }
  },
  mounted() {
    const endpoint = "http://localhost:3000/dagen"
    Vue.axios.get(endpoint).then(response => {

      var fest = new festival(response.data)
      console.log("response.data", fest)
    });
  }
}
</script>
