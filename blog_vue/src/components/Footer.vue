<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-12 19:15:55
 * @LastEditTime: 2022-02-14 17:43:53
 * @LastEditors: gaumn
-->
<template>

    <div id="Footer" class="footer">
      <div class="copy-right">@2022-{{yy}} By gaumn invain</div>
      <div class="footer-time" :title="days">{{time}}</div>      
    </div>
  
  
</template>

<script>
    export default {
      name: 'Footer',
      data:function() {
      return {
         time:String,
         weeks:["日", "一", "二", "三", "四", "五", "六"],
         days:String,
         yy:String
        }
      },
      
      methods: {
        getTime(){
          var date=new Date();
          this.yy= date.getFullYear();
          var mm= date.getMonth();
          var dd=date.getDate();
          var h=date.getHours();
          var i=date.getMinutes();
          this.time=this.yy+"-"+mm+"-"+dd+" "+h+":"+i;
          this.days="星期"+this.weeks[date.getDay()];
        }
      },
      beforeMount() {
        // 在页面挂载前就发起一次请求
        this.getTime();
        },
      mounted(){
          // 添加定时事件
        setInterval(this.getTime,10);
    }
    }

</script>

<style scoped>
  @import "../css/footer.css";
  /* @import url(http://fonts.googleapis.com/css?family=Abel|Satisfy); */
</style>