import { createApp } from 'vue'
import App from './App'
import 'jquery/dist/jquery.min'
import router from './router.js'
import VueAppend from 'vue-append'
import axios from "axios";
//import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'
const app=createApp(App)
app.config.globalProperties.$ajax=axios
app.use(router).use(VueAppend)
    .mount('#app')
