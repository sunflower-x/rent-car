package com.ikun.service;

import com.ikun.entity.InspectBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (InspectBill)表服务接口
 *
 * @author makejava
 * @since 2022-09-22 08:54:56
 */
public interface InspectBillService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    InspectBill queryById(Integer id);

    /**
     * 分页查询
     *
     * @param inspectBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<InspectBill> queryByPage(InspectBill inspectBill, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param inspectBill 实例对象
     * @return 实例对象
     */
    InspectBill insert(InspectBill inspectBill);

    /**
     * 修改数据
     *
     * @param inspectBill 实例对象
     * @return 实例对象
     */
    InspectBill update(InspectBill inspectBill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
