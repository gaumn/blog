<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-12 19:15:55
 * @LastEditTime: 2022-02-12 19:33:14
 * @LastEditors: gaumn
-->
<template>

    <div id="Footer" class="footer">
            底部
    </div>
  
  
</template>

<script>
    export default {
      name: 'Footer',
      props: {  
       message: {
         type: String,
         default:'页面加载于 '+ new Date().toLocaleString()
       }
        
      }
    }

</script>

<style scoped>
  @import "../css/footer.css";
  /* @import url(http://fonts.googleapis.com/css?family=Abel|Satisfy); */
</style>