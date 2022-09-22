package com.ikun.controller;

import com.ikun.entity.User;
import com.ikun.entity.vo.Constant;
import com.ikun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-09-22 08:56:28
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param name
     * @param password
     * @return
     */
    @PostMapping(value="/register")
    public Constant register(@RequestParam String name, @RequestParam String password){
        Constant constant = new Constant();
        User user = userService.register(name,password);
        if (user==null){
            constant.setCode("200");
            constant.setMsg("注册成功。");
            return constant;
        }
        constant.setCode("404");
        constant.setMsg("注册失败，该用户已存在。");
        return constant;
    }


@PostMapping("/login")
    public User login(@RequestBody User user){
    User userdb=userService.login(user);
return userdb;
}

}

