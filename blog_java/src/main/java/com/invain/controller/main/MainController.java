package com.invain.controller.main;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.invain.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autor invain
 * @date 2022/1/22
 **/

@RequestMapping
@RestController("/")
public class MainController {

    @GetMapping("/")
    public Object index(){
        System.out.println("index");
        return "inGex";
    }

}
