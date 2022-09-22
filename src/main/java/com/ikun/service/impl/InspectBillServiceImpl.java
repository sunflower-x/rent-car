package com.ikun.service.impl;

import com.ikun.entity.InspectBill;
import com.ikun.dao.InspectBillDao;
import com.ikun.service.InspectBillService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (InspectBill)表服务实现类
 *
 * @author makejava
 * @since 2022-09-22 08:54:56
 */
@Service("inspectBillService")
@Transactional
public class InspectBillServiceImpl implements InspectBillService {

}
