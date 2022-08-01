import { createApp } from 'vue'
import App from './App'
import 'jquery'
import routers from './router'

createApp(App).use(routers).mount('#app')
