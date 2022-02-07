/*
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-02 14:51:51
 * @LastEditTime: 2022-02-07 11:59:34
 * @LastEditors: gaumn
 */
// import Vue from 'vue'
import { createApp } from 'vue'
import App from './App.vue'
// import axios from 'axios'


// import axios from 'axios'
import router from './router'
// import "./axios"
// createApp(App).mount('#app')
// createApp(NavigationBar).mount('#ap')
// Vue.config.productionTip = false
// App.prototype.$axios = axios
// new Vue({
//   router,
//   render: h => h(App)
// }).$mount('#app')
createApp(App).use(router).mount('#app')