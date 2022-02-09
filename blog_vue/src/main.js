/*
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-02 14:51:51
 * @LastEditTime: 2022-02-09 20:56:45
 * @LastEditors: gaumn
 */
// import Vue from 'vue'

import { createApp } from 'vue'
import App from './App.vue'
// import Axios from 'axios'


// import axios from 'axios'
import router from './router'
// import "./axios"
// createApp(App).mount('#app')
// createApp(NavigationBar).mount('#ap')
// App.config.productionTip = false
const app = createApp(App)
// new Vue({
//   router,
//   render: h => h(App)
// }).$mount('#app')
// createApp(App).use(router).mount('#app')
app.use(router)
// app.use(axios)
app.mount('#app')