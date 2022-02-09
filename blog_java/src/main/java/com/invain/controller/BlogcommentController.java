package com.invain.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.invain.DataEncapsulation.Return.Result;
import com.invain.entity.Blog;
import com.invain.entity.Blogcomment;
import com.invain.service.BlogService;
import com.invain.service.BlogcommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author invain
 * @since 2022-01-26
 */
@RestController
//@RequestMapping("/blogcomment")
public class BlogcommentController {
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

}
