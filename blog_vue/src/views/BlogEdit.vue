<!--
 * @Description: 
 * @Author: gaumn 
 * @Date: 2022-02-08 17:43:22
 * @LastEditTime: 2022-03-07 23:02:27
 * @LastEditors: gaumn
-->
<template>
  <div class="blogs">

    <NavigationBar><a></a></NavigationBar>
    
    <div class="container" >
      <div class="formData">
        <div class="border">
          <div class="div-border">
            <input class="input-border" v-model="FormDatas.title"/>
            <!-- <input v-model="title" > -->
            <span class="edge"></span>
            <button class="buttons" @click="submits()">提交</button><br>
          </div>
          <div class="div-border">
            <input class="input-border" v-model="FormDatas.description"/>
          </div>
        </div>
        <!-- <v-md-editor class="vMdEditor" v-model="text" height="80vh"></v-md-editor> -->
        <v-md-editor class="vMdEditor" v-model="FormDatas.content" height="74vh"></v-md-editor>
         
      </div>
    </div>
    
    <Footer></Footer>
 </div>

</template>

<script>
  import NavigationBar from "../components/NavigationBar.vue";
  import Footer from "../components/Footer.vue";
  import qs from 'qs';//引入qs将对象转换未json键值对qs.stringify()
  export default {
    name: "BlogEdit.vue",
    components: {NavigationBar,Footer},
    data() {
      return {
        text:"# sdad",
        FormDatas: {
          id:"",
          title: '我是标题',
          description:"我是描述",
          content: '# 我是内容'
        }
      }
    },
    methods: {
      submits(){
        console.log(this.FormDatas);
        const _this=this;
         this.$axios({ url:"/md",method:'post',data:qs.stringify(this.FormDatas) ,
                            headers: {
                          'Content-Type':  'application/x-www-form-urlencoded;charset=UTF-8',
                          "Authorization": localStorage.getItem("token")
                          }
                                  }) 
                          .then(function (response) {
                            console.log(response)
                            window.alert('操作成功', '提示', {
                              confirmButtonText: '确定'
                            });
                            _this.$router.push("/blogs")
                          })
                          .catch(function (error) {
                            console.log(error);
                          });
      }
    },
    beforeMount(){
      const blogId = this.$route.params.blogId
      console.log(blogId)
      const _this = this
      if(blogId) {
        this.$axios.get('/blog/' + blogId).then(res => {
          const blog = res.data.blogDate
          _this.FormDatas.id = blog.id
          _this.FormDatas.title = blog.title
          _this.FormDatas.description = blog.description
          _this.FormDatas.content = blog.content
        })
      }
    },
    created() {
    // this.page(1)
    // window.addEventListener("beforeunload", function(event) {
    //         event.returnValue = "我在这写点东西...";
    //   });
    }
  }
</script>

<style scoped>
  .blogsEdit {
    width: 100vw;
  }
  .formData {
    width: 100%;
  }
  .formData .border {
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;
    background-color: #fff;
    padding: 20px;
  }
/* .vMdEditor {
  background-color: #fff;
  color: black;
  width: 100vw;
  height: 80vh;
} */
.v-md-editor {
  border-top-left-radius: 0px;
  border-top-right-radius: 0px;
  box-shadow: none;
}
/* v-md-editor {
  background-color: white;
} */
.formData .buttons {
  border-radius: 10px;
  margin-left: 50px;
  background-color: #fff;
  /* padding: 14px 14px; */
}
.formData .buttons:hover {
  background-color: #66afe9;
}
.formData .edge {
  padding-left: auto;
}
.div-border {
  /* width: 50vw; */
  word-wrap: normal; /*宽度若不够换行*/
  padding: 5px;
}
.formData .input-border {
  border-radius: 3px;
  width: 40vw;
  outline-style: none;
  border: 1px solid #ccc;
  padding: 2px 3px;
}
.formData .input-border:focus {
  border-color: #66afe9;
  outline: 0;
  box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075),
    0 0 8px rgba(102, 175, 233, 0.6);
}
  /* .mpage {
    margin: 0 auto;
    text-align: center;
  } */
@import "../css/BlogEdit.css";
</style>