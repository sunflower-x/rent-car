package com.ikun.service.impl;



import com.ikun.entity.Customer;
import com.ikun.dao.CustomerDao;
import com.ikun.service.CustomerService;
import com.ikun.dao.CustomerDao;
import com.ikun.entity.Customer;
import com.ikun.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (Customer)表服务实现类
 *
 * @author makejava
 * @since 2022-09-22 08:47:44
 */
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

}
