package com.invain.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @autor invain
 * @date 2022/1/11
 **/
@Configuration
/**
 * @Configuration用于定义配置类，可替换xml配置文件，
 * 被注解的类内部包含有一个或多个被@Bean注解的方法，
 * 这些方法将会被AnnotationConfigApplicationContext
 * 或AnnotationConfigWebApplicationContext类进行扫描，
 * 并用于构建bean定义，初始化Spring容器。
 * **/
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan("com.invain.mapper")
/**
 * @MapperScan 标注在 springboot 的启动类上面，配置 basePackages 属性，
 * 可以去扫描指定路径下的接口扫描为 Mapper 接口。
 * 指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
 * @Mapper：标注在接口上，表名这是一个 Mapper 接口。
 * **/
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
