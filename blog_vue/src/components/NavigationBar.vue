<!--
 * @Description: 标题栏
 * @Author: gaumn 
 * @Date: 2022-02-05 21:07:14
 * @LastEditTime: 2022-03-07 22:58:53
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
      <div class="d-none d-md-block">
        <ul class="nav nav-pills ">
          <li class="nav-item ">
            <router-link class="navbar" to="/">Gaumn's 成长记录</router-link>
          </li>
          <li class="nav-item">
            <router-link  to="/">首页</router-link>
          </li>
          <li class="nav-item  d-none ">
            <router-link  to="/blog/add">发表博客</router-link>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">工具</a>
            <div class="dropdown-menu">
              <router-link  to="/tools">工具</router-link>
            </div>
          </li>
          <!-- <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled" href="#">Disabled</a>
          </li> -->
        </ul>  
      </div>
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
  #app {
    height: 100%;
    background-image: url(../imgs/2.jpg);
    position: relative;
    background-size: cover;
    background-attachment: fixed;
    min-height: 100vh; /* 没有元素时，也把页面撑开至100% */
    /* height: 100vh; */
    /* height: 100vh; */
    /* overflow: scroll; */
    /* height: 100vh; */
    background-repeat: no-repeat;
  }
  #Navigation {
    height: 40px;
    margin: 0;
    color: #9d9d9d;
    background-color: #333;
  }
  .nav-ul {
    display: inline-block;
    list-style-type: none;
    margin: 0;
    padding: 0;
    background-color: #333;
  }
  .nav-item {
    position: relative;
    /* overflow: hidden; */
  }
  .nav-item a {
    display: block;
    font-family: "Satisfy", cursive;
    color: gainsboro;
    text-align: center;
    font-size: larger;
    padding: 10px 30px;
    text-decoration: none;
  }
  /* .nav-ul li a:hover {
    color: white;
  } */
  .nav-ul li span {
    padding: auto 80px;
  }
  /* .blogName {
    display: block;
    color: white;
    text-align: center;
    padding: 20px 30px;
    text-decoration: none;
  } */

  .nav-item a {
    color: azure;
  }
  /* .nav-right li a:hover {
    color: white;
  } */

  .dropdown .dropdown-menu a {
    color: black;
  }
  /* .dropdown .dropdown-menu a:hover {
    background-color: #333;
  } */
  @import "../css/Navigation.css";
  @import url(https://fonts.googleapis.com/css?family=Abel|Satisfy);
</style>
