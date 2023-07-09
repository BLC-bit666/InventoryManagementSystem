package com.xpu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xpu.common.R;
import com.xpu.entity.PurchaseOrderDetails;
import com.xpu.entity.SalesOrderDetails;
import com.xpu.service.PurchaseOrderDetailsService;
import com.xpu.service.SalesOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.controller
 * @Author: BLC
 * @CreateTime: 2023-07-08  15:33
 * @Description: 销售订单详情控制
 * @Version: 1.0
 */
@RestController
@RequestMapping("/salesOrderDetails")
@Transactional(rollbackFor = Exception.class)
public class SalesOrderDetailsController {
    @Autowired
    private SalesOrderDetailsService salesOrderDetailsService;

    /**
     * @description: 分页条件查询
     * @param: [page, pageSize, id]
     * @return: com.xpu.common.R<com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.xpu.entity.SalesOrderDetails>>
     * @author: BLC
     */
    @GetMapping("/page")
    public R<Page<SalesOrderDetails>> page(int page, int pageSize, Long id){
        //构造分页构造器
        Page<SalesOrderDetails> pageInfo = new Page<>(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<SalesOrderDetails> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .like(SalesOrderDetails::getOrderId,id)
                .ne(SalesOrderDetails::getQuantity,0);;
        queryWrapper.orderByDesc(SalesOrderDetails::getUpdateTime);
        salesOrderDetailsService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }
}
