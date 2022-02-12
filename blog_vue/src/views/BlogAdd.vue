<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-08 17:43:22
 * @LastEditTime: 2022-02-12 17:56:17
 * @LastEditors: gaumn
-->
<template>
  <div class="blog">

    <NavigationBar><a></a></NavigationBar>
    <div class="container" >
        <div class="panel panel-default" >
           <div class="panel-body">
              <form class="form-horizontal" role="form">
                <div class="form-group">
                  <label for="firstname" class="col-sm-2 control-label">名字</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="firstname" placeholder="请输入名字">
                  </div>
                </div>
                <div class="form-group">
                  <label for="lastname" class="col-sm-2 control-label">姓</label>
                  <div class="col-sm-10">
                    <input type="text" class="form-control" id="lastname" placeholder="请输入姓">
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                      <label>
                        <input type="checkbox">请记住我
                      </label>
                    </div>
                  </div>
                </div>
                <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">登录</button>
                  </div>
                </div>
              </form>
           </div>
        </div>
    </div>
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
@import "../css/PageBody.css";
</style>