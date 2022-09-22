package com.ikun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ikun.entity.Car;
import com.ikun.entity.RentBill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (RentBill)表数据库访问层
 *
 * @author makejava
 * @since 2022-09-22 08:56:10
 */
@Mapper
public interface RentBillDao extends BaseMapper<RentBill> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RentBill queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param rentBill 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<RentBill> queryAllByLimit(RentBill rentBill, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param rentBill 查询条件
     * @return 总行数
     */
    long count(RentBill rentBill);

    /**
     * 新增数据
     *
     * @param rentBill 实例对象
     * @return 影响行数
     */
    int insert(RentBill rentBill);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RentBill> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RentBill> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RentBill> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RentBill> entities);

    /**
     * 修改数据
     *
     * @param rentBill 实例对象
     * @return 影响行数
     */
    int update(RentBill rentBill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

