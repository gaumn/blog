/*
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-17 20:38:53
 * @LastEditTime: 2022-02-17 21:03:15
 * @LastEditors: gaumn
 */
// import { createApp } from 'vue'
import { createStore } from 'vuex'

// 创建一个新的 store 实例
const store = createStore({
  state () {
    return {
      count: 0,
      token: '',
      userInfo: JSON.parse(sessionStorage.getItem("userInfo"))
    }
  },
  mutations: {
    increment (state) {
      state.count++
    },
    // set
    SET_TOKEN: (state, token) => {
      state.token = token
      localStorage.setItem("token", token)
    },
    SET_USERINFO: (state, userInfo) => {
      state.userInfo = userInfo
      sessionStorage.setItem("userInfo", JSON.stringify(userInfo))
    },
    REMOVE_INFO: (state) => {
      state.token = ''
      state.userInfo = {}
      localStorage.setItem("token", '')
      sessionStorage.setItem("userInfo", JSON.stringify(''))
    }
  },
  getters: {
    // get
    getUser: state => {
      return state.userInfo
    }

  }
})
export default store
// const app = createApp({ /* 根组件 */ })

// // 将 store 实例作为插件安装
// app.use(store)

// Vue.use(Vuex)


