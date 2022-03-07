<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-08 17:20:15
 * @LastEditTime: 2022-03-07 23:25:50
 * @LastEditors: gaumn
-->
<template>
  <div >
    <NavigationBar></NavigationBar>
    <div class="container">
      <div class="card" style="min-height: 80vh;" >
        <div class="card-header" >
          <div>
            <h2 class="panel-title" style="text-align: center;"> {{ blog.title }}</h2>
            <!-- <h3 class="panel-title" style="text-align: right;">
              <router-link  v-if="ownBlog" :to="{name: 'BlogEdit', params: {blogId: blog.id}}" >
              编辑
              </router-link> 
              <button v-if="ownBlog" @click="submitDelete()"> 删除</button>
            </h3> -->
          </div>
        </div>
        <div class="card-body">
          <v-md-preview :text="blog.content">{{blog}}</v-md-preview>
        </div> 
        <!-- <div class="card-footer">底部</div> -->
      </div>
    </div>
    
     
        
      <!-- <div class="markdown-body" v-html="blog.content"></div> -->
        
    <Footer></Footer>
  </div>
</template>

<script>
  
  import NavigationBar from "../components/NavigationBar.vue";
  import Footer from "../components/Footer.vue";
  import qs from 'qs';//引入qs将对象转换未json键值对qs.stringify()
  export default {
    name: "BlogDetail.vue",
    components: {NavigationBar,Footer},
    data() {
      return {
        blog:{},
        Dates:{
          id:"",
          title: 's',
          description:"m",
          content: 'q'
        },
        ownBlog: false,
        timeout: null//防抖
      }
    },
    beforeMount() {
    // 在页面挂载前就发起请求
        const blogId = this.$route.params.blogId;
        console.log(blogId);
        const _this = this;
        this.$axios.get("/blog/" + blogId).then(res => {
          console.log(res);
          _this.blog =res.data.blogDate;
          _this.Dates.id=_this.blog.id;
          _this.ownBlog = (_this.blog.userId === _this.$store.getters.getUser.id);
          // console.log("_this.blog.userId="+_this.blog.userId
          //             +"_this.$store.getters.getUser.id="+_this.$store.getters.getUser.id);
          // _this.currentPage = res.data.data.current;
          // _this.total = res.data.data.total;
          // _this.pageSize = res.data.data.size;
          // _this.pages = res.data.data.pages;   
      })
    },
    methods: {
      submitDelete(){
        console.log( qs.stringify(this.Dates));
        const _this=this;
        if(this.timeout){
                    clearTimeout(this.timeout)
                }
                this.timeout = setTimeout(() => {
                    this.$axios({ url:"/delete",method:'post',data: qs.stringify(this.Dates),
                            headers: {
                          'Content-Type':  'application/x-www-form-urlencoded;charset=UTF-8',
                          "Authorization": localStorage.getItem("token")
                          }
                                  }) 
                          .then(function (response) {
                            console.log(response)
                            _this.$router.push("/blogs")
                          })
                          .catch(function (error) {
                            console.log(error);
                          });
                }, 500);
        
        // this.id=this.blog.id;
         
      }
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
  .blog-title {
    text-align: center;
  }
  .card {
    /* text-align: center; */
    display: flex;
    /* 没有元素时，也把页面撑开至90%*/
  }

  @import "../css/Blog.css";
  .mblog {
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
    width: 100%;
    min-height: 700px;
    padding: 20px 15px;
  }

</style>