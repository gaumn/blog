<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-08 17:43:22
 * @LastEditTime: 2022-02-13 22:36:01
 * @LastEditors: gaumn
-->
<template>
  <div class="blogs">

    <NavigationBar><a></a></NavigationBar>
    <div class="container" >
      <form action="http://localhost:8081/md" method="post">
      <div class="title">
        标题：
        <input type="text" name="title" /><br>
        <!-- <input v-model="title" > -->
        <input type="submit" value="提交">
      </div>
      <!-- <v-md-editor class="vMdEditor" v-model="text" height="80vh"></v-md-editor> -->
      <v-md-editor class="vMdEditor" name="content" height="80vh"></v-md-editor>
      </form>
    </div>
      
    
    <Footer></Footer>
 </div>

</template>

<script>
  import NavigationBar from "../components/NavigationBar.vue";
  import Footer from "../components/Footer.vue";
import axios from 'axios';
  export default {
    name: "BlogEdit.vue",
    components: {NavigationBar,Footer},
    data() {
      return {
        text: '',
        title:''
      }
    },
    methods: {
      submit(){
         axios.post('/md', {
                            title: this.title,
                            content: this.text,
                          })
                          .then(function (response) {
                            console.log(response);
                          })
                          .catch(function (error) {
                            console.log(error);
                          });
      }
    },
    created() {
    //   this.page(1)
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