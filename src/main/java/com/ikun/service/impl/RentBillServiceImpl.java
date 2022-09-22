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
    @Resource
    private RentBillDao rentBillDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RentBill queryById(Integer id) {
        return this.rentBillDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param rentBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<RentBill> queryByPage(RentBill rentBill, PageRequest pageRequest) {
        long total = this.rentBillDao.count(rentBill);
        return new PageImpl<>(this.rentBillDao.queryAllByLimit(rentBill, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param rentBill 实例对象
     * @return 实例对象
     */
    @Override
    public RentBill insert(RentBill rentBill) {
        this.rentBillDao.insert(rentBill);
        return rentBill;
    }

    /**
     * 修改数据
     *
     * @param rentBill 实例对象
     * @return 实例对象
     */
    @Override
    public RentBill update(RentBill rentBill) {
        this.rentBillDao.update(rentBill);
        return this.queryById(rentBill.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.rentBillDao.deleteById(id) > 0;
    }
}
