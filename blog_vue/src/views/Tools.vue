<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-23 11:30:25
 * @LastEditTime: 2022-03-07 22:56:13
 * @LastEditors: gaumn
-->
<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-08 17:20:15
 * @LastEditTime: 2022-02-21 23:21:50
 * @LastEditors: gaumn
-->
<template>
  <div>
    <NavigationBar></NavigationBar>

    <div class="blogs">
     <div class="panel panel-default"  >
            <div class="panel-heading" >
                <textarea class="textborder" v-model="Datas"></textarea>
                
                <button @click="splitspace">转换</button>
            </div>    
        </div>       
    </div>
    <Footer></Footer>
  </div>
</template>

<script>
  
  import NavigationBar from "../components/NavigationBar.vue";
  import Footer from "../components/Footer.vue";
  export default {
    name: "BlogDetail.vue",
    components: {NavigationBar,Footer},
    data() {
      return {
        Datas:"输入框",
        ownBlog: false,
        timeout: null//防抖
      }
    },
    beforeMount() {
    // 在页面挂载前就发起请求
        
    },
    methods: {
        splitspace(){
            var result = this.Datas.replace(/\s+/g, "");
            this.Datas=result;
            console.log(this.Datas);
        }
        

    },
    mounted() {
        

  }
}
</script>

<style scoped>
  .textborder {
    width: 60vw;
    height: 80vh;
    text-align: left;
  }

  @import "../css/Tools.css";
</style>