package com.ikun.controller;

import com.ikun.entity.RentBill;
import com.ikun.service.RentBillService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (RentBill)表控制层
 *
 * @author makejava
 * @since 2022-09-22 08:56:09
 */
@RestController
@RequestMapping("rentBill")
public class RentBillController {
    /**
     * 服务对象
     */
    @Resource
    private RentBillService rentBillService;

    /**
     * 分页查询
     *
     * @param rentBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<RentBill>> queryByPage(RentBill rentBill, PageRequest pageRequest) {
        return ResponseEntity.ok(this.rentBillService.queryByPage(rentBill, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<RentBill> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.rentBillService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param rentBill 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<RentBill> add(RentBill rentBill) {
        return ResponseEntity.ok(this.rentBillService.insert(rentBill));
    }

    /**
     * 编辑数据
     *
     * @param rentBill 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<RentBill> edit(RentBill rentBill) {
        return ResponseEntity.ok(this.rentBillService.update(rentBill));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.rentBillService.deleteById(id));
    }

}

