package com.ikun.controller;

import com.ikun.dao.UserDao;
import com.ikun.entity.User;
import com.ikun.entity.vo.Constant;
import com.ikun.service.UserService;
import com.ikun.util.Jsonuntil;
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
     *url:user/register
     * @param username
     * @param password
     * @return
     */
    @PostMapping(value = "/register")
    public Constant register(@RequestParam String username, @RequestParam String password) {
        Constant constant = new Constant();
        User user = userService.register(username, password);
        if (user == null) {
            constant.setCode("200");
            constant.setMsg("注册成功。");
            return constant;
        }
        constant.setCode("404");
        constant.setMsg("注册失败，该用户已存在。");
        return constant;
    }


    /**
     * 用户登录
     * url:user/login
     * @param user
     * @return
     */
    @PostMapping("/login")
    public Constant login(@RequestBody User user) {
        Constant constant;
        User userdb = userService.login(user);
        if (userdb == null) {
            constant = new Constant("404", "用户名不存在", null);
        } else if (!user.getPassword().equals(userdb.getPassword())) {
            constant = new Constant("500", "密码错误", null);
        } else {
            constant = new Constant("200", "登录成功", userdb);

        }
        return constant;

    }

    /**
     * 用户更改
     * url:user/update
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Constant updateUser(@RequestBody User user){
        Constant constant = new Constant();
        int result = userService.updateUser(user);
        if (result==0){
            constant.setCode("404");
            constant.setMsg("修改失败。");
            return constant;
        }
        constant.setCode("200");
        constant.setMsg("修改成功。");
        return constant;
    }

    /**
     * 用户删除
     * url:user/delete
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public Constant deleteUser(@RequestParam Integer id){
        Constant constant = new Constant();
        int result = userService.deleteUser(id);
        if (result==0){
            constant.setCode("404");
            constant.setMsg("删除失败。");
            return constant;
        }
        constant.setCode("200");
        constant.setMsg("删除成功。");
        return constant;
    }

    /**
     * 用户密码重置
     * url:user/reset
     * @param user
     * @return
     */
    @PostMapping("/reset")
    public Constant resetPassword(@RequestBody User user){
        Constant constant = new Constant();
        int result = userService.resetPassword(user);
        if (result==0){
            constant.setCode("404");
            constant.setMsg("重置失败。");
            return constant;
        }
        constant.setCode("200");
        constant.setMsg("重置成功。");
        return constant;
    }
}

