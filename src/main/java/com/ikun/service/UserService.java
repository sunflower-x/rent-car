package com.ikun.service;

import com.ikun.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2022-09-22 08:56:28
 */
public interface UserService {

    /**
     * 登录注册需要查询该用户是否存在
     * @param name
     * @return
     */
    User register(String name,String password);
    //登录所需
    User login(User user);
}
