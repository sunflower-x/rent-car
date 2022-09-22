package com.ikun.controller;

import com.ikun.entity.User;
import com.ikun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
@PostMapping("/login")
    public User login(@RequestBody User user){
    User userdb=userService.login(user);
return userdb;
}

}

