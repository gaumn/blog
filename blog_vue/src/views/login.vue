<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-17 16:15:37
 * @LastEditTime: 2022-02-17 21:17:27
 * @LastEditors: gaumn
-->
<template>
  <div class="blogs">
    <NavigationBar></NavigationBar>
    <div class="container" >
      <div class="formData">
        <input class="input-border" v-model="FormDatas.nickName"/>
        <input class="input-border" v-model="FormDatas.password"/>
        <button class="buttons" @click="submits">提交</button><br> 
      </div>
    </div>
    <Footer></Footer>
  </div>
</template>

<script>
  import NavigationBar from "../components/NavigationBar.vue";
  import Footer from "../components/Footer.vue";
  import axios from "axios";
  axios.defaults.baseURL = 'http://localhost:8081'
  import qs from 'qs';//引入qs将对象转换未json键值对qs.stringify()
  export default {
    name: "Blogs.vue",
    components: {NavigationBar,Footer},
    data:function() {
      return {
       FormDatas: {
          nickName:'gaumn',
          password:"123",
        },
        rules: {
          nickName: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
            { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请选择密码', trigger: 'change' }
          ]
        }
      }
    },
    methods: {
     submits(){
        console.log(this.FormDatas);
        var _this=this;
         axios({ url:"/login",method:'post',data: qs.stringify(this.FormDatas),
                            headers: {
                          'Content-Type':  'application/x-www-form-urlencoded;charset=UTF-8'}
                                  }) 
                          .then(function (response) {
                            console.log(response.data)
                            const jwt = response.headers['authorization']
                            const userInfo = response.data.data

                            // 把数据共享出去
                            _this.$store.commit("SET_TOKEN", jwt)
                            _this.$store.commit("SET_USERINFO", userInfo)  
                            // 获取
                            console.log(_this.$store.getters.getUser)

                            _this.$router.push("/blogs")
                            console.log(response);
                          })
                          .catch(function (error) {
                            console.log(error);
                          });
      }
    },
    mounted(){
        
    }

    }
</script>

<style scoped>
 @import "../css/PageBody.css";

</style>