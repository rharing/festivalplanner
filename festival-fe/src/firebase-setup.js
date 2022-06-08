import firebase from 'firebase/compat/app';

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyCjEwtlHRNyzuyTECJXOP9CobT5D1jcmfw",
    authDomain: "bks2022-c2cab.firebaseapp.com",
    databaseURL: "https://bks2022-c2cab-default-rtdb.europe-west1.firebasedatabase.app",
    projectId: "bks2022-c2cab",
    storageBucket: "bks2022-c2cab.appspot.com",
    messagingSenderId: "901197171245",
    appId: "1:901197171245:web:b3024152988bf807f446a4",
    measurementId: "G-6VMQSQZJBV"
};
const firebaseApp = firebase.initializeApp(firebaseConfig);
console.log("firebase.name: ", firebaseApp.name )
