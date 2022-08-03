import { createApp } from 'vue'
import App from './App'
import 'jquery'
import router from './router.js'
import VueAppend from 'vue-append'
createApp(App).use(router).use(VueAppend)
    .mount('#app')
