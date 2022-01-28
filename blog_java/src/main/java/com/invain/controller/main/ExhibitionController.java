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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/")
    public Object Homepage(){
        result= blogController.blogs(1);
        System.out.println("index");
        return result;
    }
    @GetMapping("/blog/{id}")
    public BlogExhibitions BlogExhibitions(Integer currentPage, @PathVariable(name = "id") int blog_id) {
        Blog blog = blogController.detail(blog_id);
        IPage blogComment =blogcommentController.blogComment(currentPage, blog_id);
        return BlogExhibitions.returnBlogExhibitions(blog,blogComment);
    }

}