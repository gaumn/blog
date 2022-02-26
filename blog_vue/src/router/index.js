/*
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-05 22:13:44
 * @LastEditTime: 2022-02-23 12:01:34
 * @LastEditors: gaumn
 */
// import Vue from 'vue'
// import { createApp } from 'vue'
// import VueRouter from 'vue-router'
import { createWebHistory, createRouter } from "vue-router";
import Blogs from '../views/Blogs.vue'
import Blog from '../views/Blog.vue'
import BlogEdit from '../views/BlogEdit.vue'
import Login from '../views/login.vue'
import Tools from '../views/Tools.vue'
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
      name: 'Blog',
      component: Blog
  },
  {
      path: '/blog/add',
      name: 'BlogEdit',
      component: BlogEdit
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/tools',
    name: 'tools',
    component: Tools
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