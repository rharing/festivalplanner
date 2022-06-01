<template>
  <div>
    events...

  </div>
</template>
<script>
import Vue from 'vue'

export default {
  data(){
    return{
      events:[]
    }
  },
  mounted(){
    function dag(data){
      this.dag = new Date(data.dag)
      this.when = data.when
      for (podium in data.podiums)
        this.podiums.concat(podium(podium))
    }


    function podium(data) {
    }
    function dagen(data) {
      this.podiums = []
    }
    function festival(data){
    this.dagen =[]
  for (dag in data.dagen){
    this.dagen.concat(dag(dag))
      this.dagen = dagen(data.dagen)
    }
    const endpoint ="http://localhost:3000/dagen"
    Vue.axios.get(endpoint).then(response =>{
      Festival festival = festival(data)
      console.log("response.data", response.data)
    });
  }
}
</script>