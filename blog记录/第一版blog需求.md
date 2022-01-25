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

主页：分表查询blog中展示前十个的blog （status状态为公开类型）的主题(title)，作者(用户名)，描述信息，创建时间等

blog展示页面获得 blog的基本信息：取到blogid，去查询到userid 同时查询到blogConentid

得到的blog数据为一个新的blog对象

| 对象          | 注释                  |
| ------------- | --------------------- |
| user_id       | user表中的id          |
| user_name     | user表中的nickName    |
| blog_id       | blog表中的id          |
| blog_title    | blog表中的标题        |
| blog_contents | blog表中的内容        |
| blog_comments | blogComment表对象数组 |
|               |                       |
|               |                       |
|               |                       |

