<!--
 * @Description: 标题栏
 * @Author: gaumn 
 * @Date: 2022-02-05 21:07:14
 * @LastEditTime: 2022-02-14 14:37:45
 * @LastEditors: gaumn
-->
<template>

  <div id="Navigation" >
    <nav>
     <ul class="nav-ul">
        <li class="navbar"><router-link  to="/">Gaumn's Blog</router-link></li>
        <li><router-link  to="/blogs">首页</router-link></li>
        <!-- <li><router-link tag="a" target="_blank" to="/blog/add">发表博客</router-link></li> -->
        <li><router-link  to="/blog/add">发表博客</router-link></li>

     </ul>
     <ul class="nav-right">
        <li><router-link  to="#contact">Contact</router-link></li>
        <li><router-link  to="#about">About</router-link></li>
     </ul>
    </nav>
    

    <!-- <div class="login-box"> -->
      
    <!-- </div> -->
      
    </div>
  
  
</template>

<script>
    export default {
      name: 'NavigationBar',
      props: {  
       message: {
         type: String,
         default:'页面加载于 '+ new Date().toLocaleString()
       }
        
      }
    }

</script>

<style scoped>
  @import "../css/Navigation.css";
  @import url(http://fonts.googleapis.com/css?family=Abel|Satisfy);
</style>
