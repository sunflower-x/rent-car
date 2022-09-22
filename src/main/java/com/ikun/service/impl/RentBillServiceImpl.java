package com.ikun.service.impl;

import com.ikun.entity.RentBill;
import com.ikun.dao.RentBillDao;
import com.ikun.service.RentBillService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (RentBill)表服务实现类
 *
 * @author makejava
 * @since 2022-09-22 08:56:12
 */
@Service("rentBillService")
@Transactional
public class RentBillServiceImpl implements RentBillService {

}
