package com.invain.controller.main;


import com.invain.DataEncapsulation.Return.Result;
import com.invain.controller.BlogController;
import com.invain.entity.Blog;
import com.invain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    @RequestMapping(value = "/Register",method = RequestMethod.POST)
    public Result Register(User user){
//        System.out.println("页面\n");
        System.out.println(user);
        return Result.success(user);
    }
    @RequestMapping(value = "/md",method = RequestMethod.POST)
    public Result BlogWrite(Blog blog){
//        System.out.println("页面\n");
//        blogController.
        System.out.println(blog);
        return Result.success(blog);
    }


}
