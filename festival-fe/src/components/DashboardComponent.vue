<template>
  <div class="card">
    <h5 class="card-header">Dashboard</h5>
    <div class="card-body">
      <h5 class="card-title">{{user.displayName}}</h5>
      <p class="card-text">{{user.email}}</p>
      <a href="#" class="btn btn-primary" @click="signOut()">Signout</a>
    </div>
  </div>
</template>

<script>
import firebase from 'firebase/compat/app';

export default {
  data() {
    return {
      user: ''
    };
  },
  created() {
    firebase.auth().onAuthStateChanged((user) => {
      if (user) {
        this.user = user;
      } else {
        this.user = '';
      }
    });
  },
  methods: {
    signOut() {
      firebase.auth().signOut().then(() => {
        firebase.auth().onAuthStateChanged(() => {
          this.$router.push('/signin')
        })
      })
    }
  }
};
</script>