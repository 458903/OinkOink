import { createRouter, createWebHistory } from 'vue-router'
import myLogin from './views/login.vue'

const routers = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path:'*',
            redirect:"/login",
        },
        {
            path: '/login',
            component: myLogin,
        },
    ]
});

export default routers;