import { createRouter, createWebHistory} from 'vue-router'
//import myLogin from './views/login.vue'
//import myAdmin from './views/myAdmin'
//const myLogin=import('./views/login.vue')


const routes=[{
   path:'/',
   redirect:"/login",
},{
    path: '/login',
    name:'myLogin',
     component:()=>import('@/views/login')
},{
    path: '/admin',
    name: 'myAdmin',
    component:()=>import('@/views/myAdmin'),
    children:[{
        path:'welcome',
        name:'myWelcome',
        component:()=>import('@/views/admin/myWelcome')
    },{
        path: 'business/chapter',
        name: 'myChapter',
        component:()=>import('@/views/admin/myChapter')
    }]
}]


const router = createRouter({
 base:process.env.BASE_URL,
  history: createWebHistory(),
   routes//定义的路由
})
//导出router
export default router