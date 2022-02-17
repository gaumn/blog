<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-08 17:43:22
 * @LastEditTime: 2022-02-17 21:38:39
 * @LastEditors: gaumn
-->
<template>
  <div class="blogs">

    <NavigationBar><a></a></NavigationBar>
    
    <div class="container" >
      <div class="formData">
        <div class="border">
          <div class="div-border">
            <input class="input-border" v-model="FormDatas.title"/>
            <!-- <input v-model="title" > -->
            <span class="edge"></span>
            <button class="buttons" @click="submits()">提交</button><br>
          </div>
          <div class="div-border">
            <input class="input-border" v-model="FormDatas.description"/>
          </div>
        </div>
        <!-- <v-md-editor class="vMdEditor" v-model="text" height="80vh"></v-md-editor> -->
        <v-md-editor class="vMdEditor" v-model="FormDatas.content" height="74vh"></v-md-editor>
         
      </div>
    </div>
    
    <Footer></Footer>
 </div>

</template>

<script>
  import NavigationBar from "../components/NavigationBar.vue";
  import Footer from "../components/Footer.vue";
  import axios from 'axios';
  axios.defaults.baseURL = 'http://localhost:8081'
  import qs from 'qs';//引入qs将对象转换未json键值对qs.stringify()
  export default {
    name: "BlogEdit.vue",
    components: {NavigationBar,Footer},
    data() {
      return {
        text:"# sdad",
        FormDatas: {
          id:"",
          title: '我是标题',
          description:"我是描述",
          content: '# 我是内容'
        }
      }
    },
    methods: {
      submits(){
        console.log(this.FormDatas);
         axios({ url:"/md",method:'post',data: qs.stringify(this.FormDatas),
                            headers: {
                          'Content-Type':  'application/x-www-form-urlencoded;charset=UTF-8'}
                                  }) 
                          .then(function (response) {
                            console.log(response);
                          })
                          .catch(function (error) {
                            console.log(error);
                          });
      }
    },
    beforeMount(){
      const blogId = this.$route.params.blogId
      console.log(blogId)
      const _this = this
      if(blogId) {
        axios.get('/blog/' + blogId).then(res => {
          const blog = res.data.blogDate
          _this.FormDatas.id = blog.id
          _this.FormDatas.title = blog.title
          _this.FormDatas.description = blog.description
          _this.FormDatas.content = blog.content
        })
      }
    },
    created() {
    // this.page(1)
    // window.addEventListener("beforeunload", function(event) {
    //         event.returnValue = "我在这写点东西...";
    //   });
    }
  }
</script>

<style scoped>

  /* .mpage {
    margin: 0 auto;
    text-align: center;
  } */
@import "../css/BlogEdit.css";
</style>