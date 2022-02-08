<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-08 17:20:15
 * @LastEditTime: 2022-02-08 17:40:11
 * @LastEditors: gaumn
-->
<template>
  <div>
    <navigation-bar></navigation-bar>

    <div class="blog">
      <h2> {{ blog.title }}</h2>
     
        <router-link :to="{name: 'BlogEdit', params: {blogId: blog.id}}" >
        编辑
        </router-link>
      <div class="markdown-body" v-html="blog.content"></div>

    </div>

  </div>
</template>

<script>
  // import 'github-markdown-css'
  import NavigationBar from "../components/NavigationBar.vue";

  export default {
    name: "BlogDetail.vue",
    components: {NavigationBar},
    data() {
      return {
        blog: {
          id: "",
          title: "",
          content: ""
        },
        ownBlog: false
      }
    },
    created() {
      // const blogId = this.$route.params.blogId
      // console.log(blogId)
      // const _this = this
      // this.$axios.get('/blog/' + blogId).then(res => {
      //   const blog = res.data.data
      //   _this.blog.id = blog.id
      //   _this.blog.title = blog.title

      //   var MardownIt = require("markdown-it")
      //   var md = new MardownIt()

      //   var result = md.render(blog.content)
      //   _this.blog.content = result
      //   _this.ownBlog = (blog.userId === _this.$store.getters.getUser.id)

      // })
    }
  }
</script>

<style scoped>
  .mblog {
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    width: 100%;
    min-height: 700px;
    padding: 20px 15px;
  }

</style>