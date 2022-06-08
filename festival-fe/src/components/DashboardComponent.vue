<template>
  <v-card>
    <v-card-title>Welkom</v-card-title>
    <v-card-text>
      <diV>bij het bks overzicht</diV>
      <div> welke pas zichtbaar wordt na een login of register</div>
    </v-card-text>
  </v-card>
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