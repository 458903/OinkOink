import { createApp } from 'vue'
import App from './App'
import 'jquery'
import router from './router.js'
import VueAppend from 'vue-append'
import axios from "axios";
const app=createApp(App)
app.config.globalProperties.$ajax=axios
app.use(router).use(VueAppend)
    .mount('#app')
