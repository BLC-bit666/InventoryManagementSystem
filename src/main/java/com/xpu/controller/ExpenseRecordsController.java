package com.xpu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xpu.common.R;
import com.xpu.entity.ExpenseRecords;
import com.xpu.service.ExpenseRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.controller
 * @Author: BLC
 * @CreateTime: 2023-07-06  10:11
 * @Description: 费用信息控制
 * @Version: 1.0
 */
@RestController
@RequestMapping("/expenseRecords")
@Transactional(rollbackFor = Exception.class)
public class ExpenseRecordsController {
    @Autowired
    private ExpenseRecordsService expenseRecordsService;

    /**
     * @description: 分页条件查询消费记录
     * @param: [page, pageSize, id]
     * @return: com.xpu.common.R<com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.xpu.entity.ExpenseRecords>>
     * @author: BLC
     */
    @GetMapping("/page")
    public R<Page<ExpenseRecords>> page(int page, int pageSize, Integer type){
        //构造分页构造器
        Page<ExpenseRecords> pageInfo = new Page<>(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<ExpenseRecords> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(type!=null,ExpenseRecords::getType,type);
        queryWrapper.orderByDesc(ExpenseRecords::getUpdateTime);
        expenseRecordsService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * @description: 修改费用信息
     * @param: [expenseRecords]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @PutMapping
    public R<String> update(@RequestBody ExpenseRecords expenseRecords){
        expenseRecords.setUpdateTime(LocalDateTime.now());
        expenseRecordsService.updateById(expenseRecords);
        return R.success("修改成功！");
    }

    /**
     * @description: 按id删除费用记录
     * @param: [id]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable Long id){
        expenseRecordsService.removeById(id);
        return R.success("删除成功！");
    }
}
