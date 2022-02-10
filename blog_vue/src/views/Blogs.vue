<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-06 09:55:08
 * @LastEditTime: 2022-02-10 15:00:34
 * @LastEditors: gaumn
-->
<template>

  
  <div class="blogs">
    <NavigationBar></NavigationBar>
    首页
  <div class="container">
    <div class="panel panel-default"  v-for="it in blogs" :key="it.id" >
      
    <div class="panel-body">
      
        {{it.id}}
      
   </div>
</div>
  </div>
  
 </div>

</template>

<script>
  import NavigationBar from "../components/NavigationBar.vue";
  import axios from "axios";
  axios.defaults.baseURL = 'http://localhost:8081'
  export default {
    name: "Blogs.vue",
    components: {NavigationBar},
    data:function() {
      return {
        blogs: {},
        currentPage: 1,
        total: 0,
        pageSize: 5
      }
    },
    mounted:function(){
                this.page(1);
    },
    methods: {
      page(currentPage) {
        const _this = this
        axios.get("/" + currentPage).then(res => {
          console.log(res)
          _this.blogs = res.data.data.records
          _this.currentPage = res.data.data.current
          _this.total = res.data.data.total
          _this.pageSize = res.data.data.size
        })
        
    }
    // created() {
    //   this.page(1)
    // }
  }}
</script>

<style scoped>
 @import "../css/PageBody.css";
  /* .mpage {
    margin: 0 auto;
    text-align: center;
  } */

</style>