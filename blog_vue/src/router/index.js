/*
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-05 22:13:44
 * @LastEditTime: 2022-02-13 17:42:59
 * @LastEditors: gaumn
 */
// import Vue from 'vue'
// import { createApp } from 'vue'
// import VueRouter from 'vue-router'
import { createWebHistory, createRouter } from "vue-router";
import Blogs from '../views/Blogs.vue'
import BlogDetail from '../views/BlogDetail.vue'
import BlogEdit from '../views/BlogEdit.vue'
// Vue.use(VueRouter)
// createApp(Blogs).use(VueRouter)
const routes = [
    {
        path:'/',
        name:'Home',
        component:Blogs
    },
    {
        path: '/blogs',
        name: 'Blogs',
        component: Blogs
  },
  {
      path: '/blog/:blogId',
      name: 'BlogDetail',
      component: BlogDetail
  },
  {
      path: '/blog/add',
      name: 'BlogEdit',
      component: BlogEdit
    },
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