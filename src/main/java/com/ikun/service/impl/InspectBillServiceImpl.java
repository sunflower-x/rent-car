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
    @Resource
    private InspectBillDao inspectBillDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public InspectBill queryById(Integer id) {
        return this.inspectBillDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param inspectBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<InspectBill> queryByPage(InspectBill inspectBill, PageRequest pageRequest) {
        long total = this.inspectBillDao.count(inspectBill);
        return new PageImpl<>(this.inspectBillDao.queryAllByLimit(inspectBill, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param inspectBill 实例对象
     * @return 实例对象
     */
    @Override
    public InspectBill insert(InspectBill inspectBill) {
        this.inspectBillDao.insert(inspectBill);
        return inspectBill;
    }

    /**
     * 修改数据
     *
     * @param inspectBill 实例对象
     * @return 实例对象
     */
    @Override
    public InspectBill update(InspectBill inspectBill) {
        this.inspectBillDao.update(inspectBill);
        return this.queryById(inspectBill.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.inspectBillDao.deleteById(id) > 0;
    }
}
