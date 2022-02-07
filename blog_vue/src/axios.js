/*
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-07 11:35:24
 * @LastEditTime: 2022-02-07 11:36:49
 * @LastEditors: gaumn
 */
import axios from 'axios'
import router from './router'



axios.defaults.baseURL = "http://localhost:8081"

// 前置拦截
axios.interceptors.request.use(config => {
  return config
})

axios.interceptors.response.use(response => {
    let res = response.data;

    console.log("=================")
    console.log(res)
    console.log("=================")

    if (res.code === 200) {
      return response
    } else {

      console.log('错了哦，这是一条错误消息')
      return Promise.reject(response.data.msg)
    }
  },
  error => {
    console.log(error)
    if(error.response.data) {
      error.message = error.response.data.msg
    }

    if(error.response.status === 401) {
      router.push("/")
    }
    return Promise.reject(error)
  }
)