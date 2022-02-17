package com.invain.controller.main;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.invain.DataEncapsulation.dto.LoginDto;
import com.invain.DataEncapsulation.Return.Result;
import com.invain.entity.User;
import com.invain.service.UserService;
import com.invain.util.JwtUtils;
import org.apache.coyote.http11.upgrade.UpgradeServletOutputStream;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public Result login(@Validated  LoginDto loginDto, HttpServletResponse response) {

        User user = userService.getOne(new QueryWrapper<User>().eq("nickName", loginDto.getNickName()));
        Assert.notNull(user, "用户不存在");

        if(!user.getPassword().equals(loginDto.getPassword())){
            System.out.println(user.getPassword());
            return Result.err("密码不正确");
        }
        System.out.println("1111");
        String jwt = jwtUtils.generateToken(user.getId());
        System.out.println("2222");
        response.setHeader("Authorization", jwt);
        System.out.println("3333");
        response.setHeader("Access-control-Expose-Headers", "Authorization");
        System.out.println("444");
        return Result.success(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getNickName())
//                .put("avatar", user.getAvatar())
//                .put("email", user.getEmail())
                .map()
        );
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout() {
        SecurityUtils.getSubject().logout();
        return Result.success(null);
    }

}
