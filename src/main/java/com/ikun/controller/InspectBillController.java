package com.ikun.controller;

import com.ikun.entity.InspectBill;
import com.ikun.service.InspectBillService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (InspectBill)表控制层
 *
 * @author makejava
 * @since 2022-09-22 08:54:56
 */
@RestController
@RequestMapping("inspectBill")
public class InspectBillController {
    /**
     * 服务对象
     */
    @Resource
    private InspectBillService inspectBillService;

    /**
     * 分页查询
     *
     * @param inspectBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<InspectBill>> queryByPage(InspectBill inspectBill, PageRequest pageRequest) {
        return ResponseEntity.ok(this.inspectBillService.queryByPage(inspectBill, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<InspectBill> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.inspectBillService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param inspectBill 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<InspectBill> add(InspectBill inspectBill) {
        return ResponseEntity.ok(this.inspectBillService.insert(inspectBill));
    }

    /**
     * 编辑数据
     *
     * @param inspectBill 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<InspectBill> edit(InspectBill inspectBill) {
        return ResponseEntity.ok(this.inspectBillService.update(inspectBill));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.inspectBillService.deleteById(id));
    }

}

