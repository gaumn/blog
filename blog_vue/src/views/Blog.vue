<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-08 17:20:15
 * @LastEditTime: 2022-02-17 11:46:07
 * @LastEditors: gaumn
-->
<template>
  <div>
    <NavigationBar></NavigationBar>

    <div class="blogs">
     <div class="panel panel-default"  >
            <div class="panel-heading">
                <div>
                    <h2 class="panel-title"> {{ blog.title }}</h2>
                </div>
            </div>
            <div class="panel-body">
              <v-md-preview :text="blog.content">{{blog}}</v-md-preview>
            </div>    
        </div>
    
     
        <!-- <router-link :to="{name: 'BlogEdit', params: {blogId: blog.id}}" >
        编辑
        </router-link> -->
      <!-- <div class="markdown-body" v-html="blog.content"></div> -->
        
    </div>
    <Footer></Footer>
  </div>
</template>

<script>
  
  import NavigationBar from "../components/NavigationBar.vue";
  import Footer from "../components/Footer.vue";
  import axios from "axios";
  // axios.defaults.baseURL = 'http://localhost:8081'
  export default {
    name: "BlogDetail.vue",
    components: {NavigationBar,Footer},
    data() {
      return {
        blog:{}
        // blog: {
        //   id: "",
        //   title: "",
        //   content: ""
        // },
      }
    },
    beforeMount() {
    // 在页面挂载前就发起请求
        const blogId = this.$route.params.blogId;
        console.log(blogId);
        const _this = this;
        axios.get("/blog/" + blogId).then(res => {
          console.log(res);
          _this.blog =res.data.blogDate;
          // _this.currentPage = res.data.data.current;
          // _this.total = res.data.data.total;
          // _this.pageSize = res.data.data.size;
          // _this.pages = res.data.data.pages;   
      })
    },
    created() {
      //  const blogId = this.$route.params.blogId
      //  console.log(blogId)
      //  const _this = this;
      //  axios.get("/blog/" + blogId).then(res => {
      //     console.log(res);
      //     // _this.blog =res.data.data.records;
      //     // _this.currentPage = res.data.data.current;
      //     // _this.total = res.data.data.total;
      //     // _this.pageSize = res.data.data.size;
      //     // _this.pages = res.data.data.pages;   
      // })
  }
}
</script>

<style scoped>
  @import "../css/Blog.css";


</style>