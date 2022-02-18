package com.invain.controller.main;



import cn.hutool.core.bean.BeanUtil;
import com.invain.DataEncapsulation.Return.Result;
import com.invain.controller.BlogController;
import com.invain.entity.Blog;
import com.invain.entity.User;
import com.invain.service.BlogService;
import com.invain.util.ShiroUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/**
 * @autor invain
 * @date 2022/1/28
 **/
@RestController
public class UploadController {
//    @RequestMapping(value = "/Register",method = RequestMethod.POST)
//    public Result Register(@ModelAttribute("user") Register_User user){
//        System.out.println("页面\n");
//        System.out.println(user);
//        return Result.success(user);
//    }
    @Autowired
    BlogController blogController;
    @Autowired
    BlogService blogService;
    @RequestMapping(value = "/Register",method = RequestMethod.POST)
    public Result Register(User user){
//        System.out.println("页面\n");
        System.out.println(user);
        return Result.success(user);
    }
    @RequiresAuthentication
    @RequestMapping(value = "/md",method = RequestMethod.POST)
    public Result BlogWrite(Blog blog){
//        System.out.println("页面\n");
//        blogController.
        System.out.println(blog);
        Blog temp = null;
        if(blog.getId() != null) {
            temp = blogService.getById(blog.getId());
            // 只能编辑自己的文章
            System.out.println(ShiroUtil.getProfile().getId());
            Assert.isTrue((int)(temp.getUserId()) == (int)(ShiroUtil.getProfile().getId()) , "没有权限编辑");
        } else {

            temp = new Blog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(1);
        }

        BeanUtil.copyProperties(blog, temp, "id", "userId", "created", "status");
        blogService.saveOrUpdate(temp);
        return Result.success(blog);
    }
    @RequiresAuthentication
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result BlogDelete(Blog blog){
//        System.out.println("页面\n");
//        blogController.
        System.out.println(blog);
        Blog temp = null;
        if(blog.getId() != null) {
            temp = blogService.getById(blog.getId());
            // 只能编辑自己的文章
            System.out.println(ShiroUtil.getProfile().getId());
            Assert.isTrue((int)(temp.getUserId()) == (int)(ShiroUtil.getProfile().getId()) , "没有权限编辑");
        } else {
            return Result.err("错误");
        }
        blogService.removeById(blog.getId());
        return Result.success(blog);
    }


}
