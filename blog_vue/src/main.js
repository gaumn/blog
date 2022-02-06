/*
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-02 14:51:51
 * @LastEditTime: 2022-02-06 10:42:50
 * @LastEditors: gaumn
 */
// import Vue from 'vue'
import { createApp } from 'vue'
import App from './App.vue'

// import axios from 'axios'
import router from './router'
// createApp(App).mount('#app')
// createApp(NavigationBar).mount('#ap')
// Vue.config.productionTip = false
// Vue.prototype.$axios = axios
// new Vue({
//   router,
//   render: h => h(App)
// }).$mount('#app')
createApp(App).use(router).mount('#app')