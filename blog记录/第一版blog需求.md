# blog需求_后端

## 1.实现blog功能

需实现blog

主页（主要给人展示自己的blog）与后台页面（写自己的blog）(后序会将登录注册系统开放出来)

#####  blogMySQL设计

user表

|  字段名   |       注释       |    类型     |
| :-------: | :--------------: | :---------: |
|    id     |      用户id      |     int     |
| nickName  |      用户名      | varchar(50) |
| password  |     用户密码     | varchar(50) |
|  created  |     注册时间     |  datetime   |
| lastLogin | 最后一次登录时间 |  datetime   |

blog表

| 字段名 | 注释 | 类型 |
| :----: |:-----: | :----: |
| id | 每一个blog均匀一个id，主键 | int |
| user_id | 绑定于该用户下的id | int |
| description | 对该blog进行描述 | varchar |
|      title       |         该blog标题         | varchar  |
|     contents     |       该blog中的内容       | longtext |
|     created      |          创建时间          | datetime |
| lastModification |        最后一次修改        | datetime |
| status | 该blog的状态(包括草稿等) | tinyint |
| blogContentId(该字段未写入数据库中) | blogContent对应的id号（后序可通过此字段提高MySQL查询效率） | json |

blogComment表

| 字段名      |              注释              | 类型     |
| :---------: | :----------------------------: | :-------: |
| id          | 每一个blog评论均匀一个id，主键 | int      |
| blog_id     |      该评论对于的blog的id      | int      |
| user_id     |       绑定于该用户下的id       | int      |
| contents |        对该blog进行评论内容        | longtext |
| created | 创建时间 | datetime |



### blog从后端获取的数据部分（均以明文形式）

#### 读功能：

##### 主页：

分表查询blog中展示前十个的blog （status状态为公开类型）的主题(title)，作者(用户名)，描述信息，创建时间等

##### blog展示页面

获得 blog的基本信息：取到blogid，去查询到userid 同时查询到blogComment_id

得到的blog数据为一个新的blog对象(json数据)

| 对象          | 注释                  |
| ------------- | --------------------- |
| user_id       | user表中的id          |
| user_name     | user表中的nickName    |
| blog_id       | blog表中的id          |
| blog_title    | blog表中的标题        |
| blog_contents | blog表中的内容        |
| blog_comments | blogComment表对象数组 |

#### 写功能
##### 注册用户表/登录用户表

将数据向服务器传入登录信息/注册信息user

##### 发表blog功能

将数据向服务器传入blog表信息

##### 发表评论功能

将数据向服务器传入blogComment表

## 2.具体实现

### 读功能

##### 主页：

```
    @Autowired
    BlogController blogController;
    Result result;
    @GetMapping("/")
    public Object homepage(){
        result= blogController.blogs(1);
        System.out.println("index");
        return result;
    }
```

##### blog展示页面：

```java
@GetMapping("/blog/{id}")
public BlogExhibitions BlogExhibitions(Integer currentPage, @PathVariable(name = "id") int blog_id) {
    Blog blog = blogController.detail(blog_id);
    IPage blogComment =blogcommentController.blogComment(currentPage, blog_id);
    return BlogExhibitions.returnBlogExhibitions(blog,blogComment);
}
```
内部封装
```java
@Data
public class BlogExhibitions {

    private Blog blogDate;
    private IPage blogCommentPage;
    static BlogExhibitions blogExhibitions =new BlogExhibitions();
    public static BlogExhibitions returnBlogExhibitions(Blog blogDate, IPage blogCommentPage){
        blogExhibitions.setBlogDate(blogDate);
        blogExhibitions.setBlogCommentPage(blogCommentPage);
        return blogExhibitions;
    }
    public static BlogExhibitions returnBlogComments ( IPage blogCommentPage){
        blogExhibitions.setBlogCommentPage(blogCommentPage);
        return blogExhibitions;
    }
}
```

控制器

```java
    @Autowired
    BlogcommentService blogcommentService;
//    @GetMapping("/blog/{id}")  @PathVariable(name = "id")
    public IPage blogComment(Integer currentPage,int blog_id) {

        if(currentPage == null || currentPage < 1) currentPage = 1;
        Page page = new Page(currentPage, 20);
        IPage pageData = blogcommentService.page(page, new QueryWrapper<Blogcomment>()
                                            .eq("id", blog_id)
                                            .orderByDesc("created"));
        return pageData;
    }
```



### 写功能

##### 注册用户表/登录用户表

##### 发表blog功能

##### 发表评论功能





















