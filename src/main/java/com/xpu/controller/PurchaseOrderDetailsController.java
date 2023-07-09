package com.xpu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xpu.common.R;
import com.xpu.entity.PurchaseOrderDetails;
import com.xpu.service.PurchaseOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.controller
 * @Author: BLC
 * @CreateTime: 2023-07-08  14:20
 * @Description: 购买订单详情控制
 * @Version: 1.0
 */
@RestController
@RequestMapping("/purchaseOrderDetails")
@Transactional(rollbackFor = Exception.class)
public class PurchaseOrderDetailsController {
    @Autowired
    private PurchaseOrderDetailsService purchaseOrderDetailsService;

    /**
     * @description: 分页条件查询
     * @param: [page, pageSize, id]
     * @return: com.xpu.common.R<com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.xpu.entity.PurchaseOrderDetails>>
     * @author: BLC
     */
    @GetMapping("/page")
    public R<Page<PurchaseOrderDetails>> page(int page, int pageSize, Long id){
        //构造分页构造器
        Page<PurchaseOrderDetails> pageInfo = new Page<>(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<PurchaseOrderDetails> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .like(PurchaseOrderDetails::getOrderId,id)
                .ne(PurchaseOrderDetails::getQuantity,0);
        queryWrapper.orderByDesc(PurchaseOrderDetails::getUpdateTime);
        purchaseOrderDetailsService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * @description: 按id查询
     * @param: [id]
     * @return: com.xpu.common.R<com.xpu.entity.PurchaseOrderDetails>
     * @author: BLC
     */
    @GetMapping("/{id}")
    public R<PurchaseOrderDetails> getById(@PathVariable Long id){
        PurchaseOrderDetails purchaseOrderDetails = purchaseOrderDetailsService.getById(id);
        if(purchaseOrderDetails!=null){
            return R.success(purchaseOrderDetails);
        }
        return R.error("查询失败！");
    }
}
