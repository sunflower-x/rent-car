package com.ikun.service.impl;

import com.ikun.entity.User;
import com.ikun.dao.UserDao;
import com.ikun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-09-22 08:56:28
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User register(String name,String password) {
        Map<String,Object> map = new HashMap<>();
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        map.put("username",name);
        List<User> users = userDao.selectByMap(map);
        if (users.size()==0){
            userDao.insert(user);
            return null;
        }
        return users.get(0);
    }
}
