<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-06 09:55:08
 * @LastEditTime: 2022-02-16 17:05:43
 * @LastEditors: gaumn
-->
<template>

  
  <div class="blogs">
    <NavigationBar></NavigationBar>
    <div class="container" >
      <div v-for="array in shows" :key="array">
        <div class="panel panel-default" v-for="it in array" :key="it" >
          <div class="panel-heading">
            <div>
              标题：
              <h3 class="panel-title">
              {{it.title}}
              </h3>
            </div>
           </div>
           <div class="panel-body">
             <div class="blogs-descrip">相关描述：</div>
             <div class="blogs-descrip">{{it.description}}</div>
           </div>
            <div class="panel-footer">
              作者ID：<div>{{it.userId}}</div>
              创建时间：<div> {{it.created}}</div>
            </div>
        </div>
      </div>
      <div v-show="isLoading&&!noPage">isLoading</div>
      <div class="noPage" v-show="noPage" >noPage</div>
    </div>
    <Footer></Footer>
  </div>
</template>

<script>
  import NavigationBar from "../components/NavigationBar.vue";
  import Footer from "../components/Footer.vue";
  import axios from "axios";
  axios.defaults.baseURL = 'http://localhost:8081'
  export default {
    name: "Blogs.vue",
    components: {NavigationBar,Footer},
    data:function() {
      return {
        shows:[], //存放滚动区域要显示的数据
        isLoading:false ,//默认没有在加载数据
        blogs: {},
        currentPage: 1,
        total: 0,
        pageSize: 0,
        pages:0 ,
        noPage:false
      }
    },
    beforeMount() {
      // 在页面挂载前就发起请求
      this.page(1);
    },
    methods: {
      page(currentPage) {
        const _this = this;
        axios.get("/" + currentPage).then(res => {
          console.log(currentPage);
          _this.blogs =res.data.data.records;
          _this.currentPage = res.data.data.current;
          _this.total = res.data.data.total;
          _this.pageSize = res.data.data.size;
          _this.pages = res.data.data.pages;
          _this.shows.push(_this.blogs);
          console.log(_this.shows);
           //数据请求完成
          _this.isLoading=false;
        })
      },
      
      getScrollBottomHeight () {
        // 获取整个网页的高的
        let getPageHeight = document.querySelector('html').scrollHeight
        // console.log("getPageHeight="+getPageHeight);
        // 获取滚动条卷去的高度
        let getScrollTop = window.pageYOffset ||
                          document.documentElement.scrollTop ||
                          document.body.scrollTop
        // 获取可视区域高度
        let getWindowHeight = window.innerHeight ||
                            document.documentElement.clientHeight
        // console.log("getWindowHeight="+getWindowHeight);
        // 滚动条到底部的距离
        //  console.log("getScrollTop="+getScrollTop);
        return getPageHeight - getScrollTop - getWindowHeight
      },
      handleScrollsss () {
        // console.log(this.getScrollBottomHeight());
        if (this.getScrollBottomHeight() <= 20) {
          if(this.currentPage<=this.pages){
            this.currentPage++;
            this.isLoading=true;
            this.page(this.currentPage);
          }else{
            this.isLoading=false;
            this.noPage=true;
          }
        }
      }
    },
    mounted(){
          // 添加滚动事件
          window.addEventListener('scroll', this.handleScrollsss,true)
    }
    // created() {
    //   this.page(1)
    // }
    }
</script>

<style scoped>
 @import "../css/PageBody.css";
  /* .mpage {
    margin: 0 auto;
    text-align: center;
  } */

</style>