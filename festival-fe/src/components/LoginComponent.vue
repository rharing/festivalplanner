<template>
  <v-card widtg="400" class="mx-auto mt-5">
    <v-card-title>
      <h1 class="display-1">Login</h1>
    </v-card-title>
    <v-card-text>
      <v-form>
        <v-text-field
            prepend-icon="mdi-account-circle"
            label="email" v-model="email"/>
        <v-text-field
            prepend-icon="mdi-lock"
            :append-icon="showPassword? 'mdi-eye': 'mdi-eye-off'"
            :type="showPassword ? 'text' : 'password'" label="password" v-model="password"
            @click:append="showPassword = !showPassword"/>
      </v-form>
    </v-card-text>
    <v-divider/>
    <v-card-actions>
      <v-btn @click="onSubmit" color="success">Login</v-btn>
      <v-spacer/>
      <v-btn color="info">Register</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import firebase from 'firebase/compat/app';
import 'firebase/compat/auth';

export default {
  data() {
    return {

      email: '',
      password: '',

      showPassword: false
    };
  },
  methods: {
    onSubmit() {
      firebase.auth()
          .signInWithEmailAndPassword(this.email, this.password).then(() => {
        this.$router.push('/events')
      })
          .catch((err) => {
            console.log(err);
          });
    }
  }
};
</script>
