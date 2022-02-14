```
npm install vue-router --save
```

````vue
import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
const app = createApp(App)
app.use(router)
app.mount('#app')
````

```
npm install axios --save
```

```
this.axios({
    method: "post",
    url: "http://localhost:8081/hello",
    data: {
        username: "admin",
        password: "123"
    }
}).then((res)=>{
    console.log(res.data);
})
//https://blog.csdn.net/qq_44713454/article/details/111085919
```




```
npm install jquery --save
npm install bootstrap --save
```

```
npm install qs//安装引入qs
import qs from 'qs';//引入qs将对象转换未json键值对qs.stringify()
```

