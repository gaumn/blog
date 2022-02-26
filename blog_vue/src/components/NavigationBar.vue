<!--
 * @Description: 标题栏
 * @Author: gaumn 
 * @Date: 2022-02-05 21:07:14
 * @LastEditTime: 2022-02-26 10:59:00
 * @LastEditors: gaumn
-->
<template>

  <div id="Navigation" >
    <!-- <nav>
     <ul class="nav-ul">
        <li class="navbar"><router-link  to="/">Gaumn's 成长记录</router-link></li>
        <li><router-link  to="/blogs">首页</router-link></li>
        <li><router-link  to="/tools">工具</router-link></li> -->
        
        <!-- <li><router-link tag="a" target="_blank" to="/blog/add">发表博客</router-link></li> -->
        <!-- <li><router-link  to="/blog/add">发表博客</router-link></li> -->

     <!-- </ul>
     <ul class="nav-right">
        <li><a tag="a" target="_blank" href="https://github.com/gaumn">Contact</a></li>
        <li><router-link  to="#about">About</router-link></li>
     </ul>
    </nav> -->
    <ul class="nav nav-pills">
      <li class="nav-item">
        <router-link  to="/">Gaumn's 成长记录</router-link>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Dropdown</a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">Link 1</a>
          <a class="dropdown-item" href="#">Link 2</a>
          <a class="dropdown-item" href="#">Link 3</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <!-- <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li> -->
    </ul>

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
  @import url(https://fonts.googleapis.com/css?family=Abel|Satisfy);
</style>
