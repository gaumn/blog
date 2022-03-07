# blog

### 一、数据库（MySQL）部分

### 1.数据库的使用

1.1启动[^1]

` net start mysql`

1.2连接数据库[^1]

`mysql -h 地址 -u 用户名 -p 密码`

`mysql -h localhost -u root -p 123456`

1.3 数据库操作[^1]

`show databases;`

``` sql
use database 数据库名 //使用该数据库
```

1.4 数据表操作

user表

``` sql
create table  `user`( 
 `id` int NOT NULL auto_increment,
`nickName` varchar(50) DEFAULT  NULL ,
`password` varchar(50) DEFAULT  NULL ,
`created` datetime DEFAULT  NULL,
`lastLogin` datetime DEFAULT  NULL,
primary key (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
blog表
```sql
CREATE TABLE `blog` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `content` longtext,
  `created` datetime NOT NULL,
  `lastModification` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '默认取当前时间',
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```

blogcomment表

```sql
CREATE TABLE `blogcomment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
 `blog_id` int NOT NULL,
  `content` longtext,
  `created` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4;
```

### 2.连接数据库

```yml
# DataSource Config
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/blog?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=Asia/Shanghai
    username: root
    password: ****
```

# 二、Mybatis-plus代码生成部分

```java
/ 演示例子，执行 main 方法控制台输入模块表名回车自动生成对应项目目录中
public class CodeGenerator {

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
//        gc.setOutputDir("D:\\test");
        gc.setAuthor("invain");
        gc.setOpen(false);
        // gc.setSwagger2(true); 实体属性 Swagger2 注解
        gc.setServiceName("%sService");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/blog?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("8023");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null);
        pc.setParent("com.invain");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        // String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/"
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("m_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
```

配置mybatis-plus 

com.invain.config.MybatisPlusConfig

```java
@Configuration
@EnableTransactionManagement
@MapperScan("com.invain.mapper")//文档扫描地址
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
```

## 三、前后端分离中解决跨域问题

在Springboot中增加全局过滤器

```
/**
 * 配置跨域访问的过滤器
 * @return
 */
@Bean
public FilterRegistrationBean registerFilter(){
    FilterRegistrationBean bean = new FilterRegistrationBean();
    bean.addUrlPatterns("/*");
    bean.setFilter(new CrosFilter());
    return bean;
}
```

过滤器

```
package com.invain.config.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @autor invain
 * @date 2022/2/9
 **/
public class CrosFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        //*号表示对所有请求都允许跨域访问
        res.addHeader("Access-Control-Allow-Origin", "*");
        res.addHeader("Access-Control-Allow-Methods", "*");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
```

## 四、Mysql随机生成测试数据

```mysql
#设置mysql可自定义函数
SET GLOBAL log_bin_trust_function_creators = 1;
```


```mysql
#随机字符串生成函数
create function rs(n int)
    returns varchar(1024)
begin
    declare chars char(52) default 'abcdefghijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUVWXYZ';
    declare res varchar(1024) default '';
    declare i int default 0;
    repeat
        set i = i + 1;
        set res = concat(res,substring(chars,floor(1+rand()*52),1));
    until i=n end repeat;
    return res;
end
```

MySQL 生成随机时间函数

```mysql
DROP FUNCTION IF EXISTS func_RandomDateTime;
#USAGE:
#SELECT func_RandomDateTime(DATE_FORMAT('2010-12-1 10:10:10','%Y-%m-%d %H:%i:%s'),DATE_FORMAT('2010-12-1 11:10:13','%Y-%m-%d %H:%i:%s')) AS t;
#
CREATE
    FUNCTION func_RandomDateTime(
    sd DATETIME,
    ed DATETIME)
    RETURNS DATETIME
BEGIN
    DECLARE sub INT DEFAULT 0;
    DECLARE ret DATETIME;
    SET sub = ABS(UNIX_TIMESTAMP(ed)-UNIX_TIMESTAMP(sd));
    SET ret = DATE_ADD(sd,INTERVAL FLOOR(1+RAND()*(sub-1)) SECOND);
    RETURN DATE_ADD(sd,INTERVAL FLOOR(1+RAND()*((ABS(UNIX_TIMESTAMP(ed)-UNIX_TIMESTAMP(sd)))-1)) SECOND);
END;
```

Mysql定义并调用存储过程
 ``` mysql
 delimiter //                            #定义标识符为双斜杠
 drop procedure if exists test;          #如果存在test存储过程则删除
 create procedure test(n int)                 #创建无参存储过程,名称为test
 begin
     declare i int;                      #申明变量
     set i = 0;                          #变量赋值
     while i < n do                     #结束循环的条件: 当i大于100时跳出while循环
     insert into blog.blog ( user_id, title, description, content, created, lastModification,status)
      values (i,rs(10),rs(20),rs(50),
              func_RandomDateTime(DATE_FORMAT('2019-12-1 10:10:10','%Y-%m-%d %H:%i:%s'),DATE_FORMAT('2022-12-1 11:10:13','%Y-%m-%d %H:%i:%s')),
              func_RandomDateTime(DATE_FORMAT('2019-12-1 10:10:10','%Y-%m-%d %H:%i:%s'),DATE_FORMAT('2022-12-1 11:10:13','%Y-%m-%d %H:%i:%s')),
              1);    #往test表添加数据
     set i = i + 1;                  #循环一次,i加一
         end while;                          #结束while循环
     select * from blog;                 #查看test表数据
 end
 //                                      #结束定义语句
 call test(1000);                            #调用存储过程
 ```



java打包指令

```
mvn clean package -Dmaven.test.skip=true
```

vue cli打包指令

```
npm run build
```
Docker容器编排
```
docker-compose up -d
```
Docker输出日志
```
docker logs -f cfa513d52b85
```



mysql创建一个用户赋予权限

```
CREATE USER 'blogUser'@'localhost' IDENTIFIED BY 'Mn*7Zs$gHo9bb';
```

赋予权限

```
grant all privileges on blog.* to blogUser@localhost;
```
g

远程访问权限

```
GRANT` `ALL` `PRIVILEGES` `ON` `testDB.* ``TO` `'blogUser'``@``'%'` `IDENTIFIED ``BY` `'Mn*7Zs$gHo9bb'` `WITH` `GRANT` `OPTION``;
```





Docker

````
#Docker查询镜像
docker image ls
#Docker查询运行的容器
docker ps -s
#重启docker
systemctl restart docker
````



查询正在运行的java程序

```
ps -ef | grep java
```
查询特定端口是否在运行
```
netstat -anp|grep 8081

```














































[^1]:sql来源： https://blog.csdn.net/weixin_43042683/article/details/106779060