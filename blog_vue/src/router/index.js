/*
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-05 22:13:44
 * @LastEditTime: 2022-02-06 10:51:41
 * @LastEditors: gaumn
 */
// import Vue from 'vue'
// import { createApp } from 'vue'
// import VueRouter from 'vue-router'
import { createWebHistory, createRouter } from "vue-router";
import Blogs from '../views/Blogs.vue'
// Vue.use(VueRouter)
// createApp(Blogs).use(VueRouter)
const routes = [
    {
        path:'/',
        name:'Home',
        redirect: {name: "Blogs"}
    },
    {
        path: '/blogs',
        name: 'Blogs',
        component: Blogs
    }
]

// const router = new VueRouter({
//     mode: 'history',
//     base: process.env.BASE_URL,
//     routes
//   })
  const router = createRouter({
    history: createWebHistory(),
    routes,
  });
export default router