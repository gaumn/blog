<!--
 * @Description: 标题栏
 * @Author: gaumn 
 * @Date: 2022-02-05 21:07:14
 * @LastEditTime: 2022-02-06 14:07:53
 * @LastEditors: gaumn
-->
<template>
<div class="login-box">
  <div id="Navigation" >
    
    <div id="header" :title="message">欢迎来我的Blog</div>
    
      www
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

<style>
  @import "../css/Navigation.css";
</style>
