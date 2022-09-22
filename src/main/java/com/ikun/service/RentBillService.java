package com.ikun.service;

import com.ikun.entity.RentBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (RentBill)表服务接口
 *
 * @author makejava
 * @since 2022-09-22 08:56:11
 */
public interface RentBillService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RentBill queryById(Integer id);

    /**
     * 分页查询
     *
     * @param rentBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<RentBill> queryByPage(RentBill rentBill, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param rentBill 实例对象
     * @return 实例对象
     */
    RentBill insert(RentBill rentBill);

    /**
     * 修改数据
     *
     * @param rentBill 实例对象
     * @return 实例对象
     */
    RentBill update(RentBill rentBill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
