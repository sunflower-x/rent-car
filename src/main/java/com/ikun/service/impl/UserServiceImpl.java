package com.ikun.service.impl;

import com.ikun.entity.User;
import com.ikun.dao.UserDao;
import com.ikun.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-09-22 08:56:28
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

}
