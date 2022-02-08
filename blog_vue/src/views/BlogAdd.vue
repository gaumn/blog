<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-08 17:43:22
 * @LastEditTime: 2022-02-08 19:38:21
 * @LastEditors: gaumn
-->
<template>
  <div class="blog">
    <NavigationBar><a>ssda</a></NavigationBar>
    Blog ADD
 </div>

</template>

<script>
  import NavigationBar from "../components/NavigationBar.vue";
  export default {
    name: "BlogAdd.vue",
    components: {NavigationBar},
    data() {
      return {
        blogs: {},
        currentPage: 1,
        total: 0,
        pageSize: 5
      }
    },
    methods: {
    //   page(currentPage) {
    //     const _this = this
    //     _this.$axios.get("/blogs?currentPage=" + currentPage).then(res => {
    //       console.log(res)
    //       _this.blogs = res.data.data.records
    //       _this.currentPage = res.data.data.current
    //       _this.total = res.data.data.total
    //       _this.pageSize = res.data.data.size
    //     })
    //   }
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

</style>