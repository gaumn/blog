/*
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-02 14:51:51
 * @LastEditTime: 2022-02-17 21:03:18
 * @LastEditors: gaumn
 */
// import Vue from 'vue'

import { createApp } from 'vue'
import App from './App.vue'
import store  from './store'
// import Axios from 'axios'
import VMdEditor from '@kangc/v-md-editor';
import '@kangc/v-md-editor/lib/style/base-editor.css';
import githubTheme from '@kangc/v-md-editor/lib/theme/github.js';
import '@kangc/v-md-editor/lib/theme/style/github.css';
import VMdPreview from '@kangc/v-md-editor/lib/preview';

// highlightjs
import hljs from 'highlight.js';
VMdPreview.use(githubTheme, {
  Hljs: hljs,
});
VMdEditor.use(githubTheme, {
  Hljs: hljs,
});

// import axios from 'axios'
import router from './router'
// import "./axios"
// createApp(App).mount('#app')
// createApp(NavigationBar).mount('#ap')
// App.config.productionTip = false
const app = createApp(App);
// new Vue({
//   router,
//   render: h => h(App)
// }).$mount('#app')
// createApp(App).use(router).mount('#app')
app.use(router);
app.use(store);
app.use(VMdPreview);
app.use(VMdEditor);
// app.use(axios)
app.mount('#app')