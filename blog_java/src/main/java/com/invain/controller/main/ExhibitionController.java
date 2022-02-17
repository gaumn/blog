package com.invain.controller.main;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.invain.DataEncapsulation.Return.BlogExhibitions;
import com.invain.DataEncapsulation.Return.Result;
import com.invain.controller.BlogController;
import com.invain.controller.BlogcommentController;
import com.invain.entity.Blog;
import com.invain.entity.Blogcomment;
import com.invain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;

/**
 * @autor invain
 * @date 2022/1/28
 **/

@RestController
public class ExhibitionController {//展示功能控制器
    @Autowired
    BlogController blogController;
    @Autowired
    BlogcommentController blogcommentController;

    Result result;
    @GetMapping("/{currentPage}")
    public Object Homepage(@PathVariable(name = "currentPage")Integer currentPage){
        result= blogController.blogs(currentPage);
        System.out.println("/"+currentPage);
        return result;
    }
    @GetMapping("/")
    public Object Homepage(){
        result= blogController.blogs(1);
        System.out.println("/");
        return result;
    }
    @GetMapping("/blog/{id}")
    public BlogExhibitions BlogExhibitions(@PathVariable(name = "id") int blog_id) {
        Blog blog = blogController.detail(blog_id);
        IPage blogComment =blogcommentController.blogComment(5, blog_id);
        return BlogExhibitions.returnBlogExhibitions(blog,blogComment);
    }

//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public Result Login(User user){
////        System.out.println("页面\n");
//        System.out.println(user);
//        return Result.success(user);
//    }
}
