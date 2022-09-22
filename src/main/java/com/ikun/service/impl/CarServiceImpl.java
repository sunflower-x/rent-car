package com.ikun.service.impl;

import com.ikun.entity.Car;
import com.ikun.dao.CarDao;
import com.ikun.service.CarService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (Car)表服务实现类
 *
 * @author makejava
 * @since 2022-09-22 08:41:00
 */
@Service("carService")
@Transactional
public class CarServiceImpl implements CarService {

}
