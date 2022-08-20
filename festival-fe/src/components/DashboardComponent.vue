<template>
  <v-card>
    <v-card-title>Welkom</v-card-title>
    <v-card-text>
      <h2> build: {{build}}</h2>
      <diV>bij het bks overzicht</diV>
      <div>welke pas zichtbaar wordt na een<router-link to="events">klik hier</router-link></div>
      <div>nog te doen maar geen tijd meer:<ul>
        <li> saving of favs in een server zodat je favs overal beschikbaar zijn</li>
        <li> op favs overzicht wat andere in je groepje fav vinden</li>
        <li> ohja groepvorming dus</li>
        <li> op het dag overzicht alleen de events tonen die nog gaan komen</li>
        <li> op de favs section een teruglooptimer naar je eerste fav event</li>
        <li>de dagen balk die meescrolt voor snelle dag en favs schakeling</li>
        <li>bugje bij toevoegen van fav wordt deze niet altijd gesorteerd</li>
      </ul>
      </div>
    </v-card-text>
  </v-card>
</template>

<script>

export default {
  data() {
    return {
      user: '', build:  "4201"
    };
  },
  created() {
  },
  methods: {
  }
};
</script>
