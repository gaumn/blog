<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-12 19:15:55
 * @LastEditTime: 2022-03-07 22:57:06
 * @LastEditors: gaumn
-->
<template>

    <div id="Footer" class="footer">
      <div class="run-times" >本站已经正常运行{{ runtimes}}天</div>
      <div class="copy-right">
           @2022-{{yy}} By gaumn |
           <a href="http://beian.miit.gov.cn/">蜀ICP备2022004575号-1</a>       
      </div>
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
         yy:String,
         runtimes:String
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
        },
        run_time(){  
          var BirthDay=new Date("02/17/2022 00:00:00");//这个日期是可以修改的  
          var today=new Date();  
          var timeold=(today.getTime()-BirthDay.getTime());  
          // sectimeold=timeold/1000  
          // secondsold=Math.floor(sectimeold);  
          var msPerDay=24*60*60*1000  
          var e_daysold=timeold/msPerDay  
          var daysold=Math.floor(e_daysold);  
          // e_hrsold=(e_daysold-daysold)*24;  
          // hrsold=Math.floor(e_hrsold);  
          // e_minsold=(e_hrsold-hrsold)*60;  
          // minsold=Math.floor((e_hrsold-hrsold)*60);  
          // seconds=Math.floor((e_minsold-minsold)*60); 
          // showtime.innerHTML="您已经陪伴了我："+daysold+"天"+hrsold+"小时"+minsold+"分"+seconds+"秒"; 
          this.runtimes=daysold;
          }
      },
      beforeMount() {
        // 在页面挂载前就发起一次请求
        this.getTime();
        this.run_time();
        },
      mounted(){
          // 添加定时事件
        setInterval(this.getTime,10);
    }
    }

</script>

<style scoped>
.footer {
  height: 3vh;
  width: 100%;
  background-color: rgb(245, 97, 97);
  position: fixed;
  bottom: 0;
}
.footer .footer-time {
  float: right;
  padding-right: 3vw;
}
.copy-right {
  display: inline-block;
  margin: 0 auto;
  padding-left: 20vw;
}
.run-times {
  display: inline-block;
  padding-left: 5vw;
}

  @import "../css/footer.css";
  /* @import url(http://fonts.googleapis.com/css?family=Abel|Satisfy); */
</style>