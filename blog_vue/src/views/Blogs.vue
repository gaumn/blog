<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-06 09:55:08
 * @LastEditTime: 2022-02-09 21:02:52
 * @LastEditors: gaumn
-->
<template>
  <div class="blogs">
    <NavigationBar></NavigationBar>
    首页
  <div>
    {{blogs}}
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
    data() {
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
          _this.blogs = res
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

  /* .mpage {
    margin: 0 auto;
    text-align: center;
  } */

</style>