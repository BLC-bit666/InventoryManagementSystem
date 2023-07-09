package com.xpu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xpu.common.R;
import com.xpu.entity.*;
import com.xpu.service.*;
import com.xpu.utils.IdGenerator;
import com.xpu.utils.OrderItemDTO;
import com.xpu.utils.OrderRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.controller
 * @Author: BLC
 * @CreateTime: 2023-07-05  21:54
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/salesOrders")
@Transactional(rollbackFor = Exception.class)
public class SalesOrdersController {
    @Autowired
    private SalesOrdersService salesOrdersService;
    @Autowired
    private ProductsService productsService;
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private SalesOrderDetailsService salesOrderDetailsService;
    @Autowired
    private ExpenseRecordsService expenseRecordsService;

    /**
     * @description: 分页条件查询销售订单记录
     * @param: [page, pageSize, id]
     * @return: com.xpu.common.R<com.baomidou.mybatisplus.extension.plugins.pagination.Page < com.xpu.entity.SalesOrders>>
     * @author: BLC
     */
    @GetMapping("/page")
    public R<Page<SalesOrders>> page(int page, int pageSize, Long id) {
        //构造分页构造器
        Page<SalesOrders> pageInfo = new Page<>(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<SalesOrders> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(id != null, SalesOrders::getId, id);
        queryWrapper.orderByDesc(SalesOrders::getUpdateTime);
        salesOrdersService.page(pageInfo, queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * @description: 根据id更新销售订单记录
     * @param: [salesOrders]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @PutMapping
    public R<String> update(@RequestBody SalesOrders salesOrders) {
        salesOrders.setUpdateTime(LocalDateTime.now());
        salesOrdersService.updateById(salesOrders);
        return R.success("操作成功！");
    }

    /**
     * @description: 根据id删除销售订单记录
     * @param: [id]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable Long id) {
        salesOrdersService.removeById(id);
        return R.success("删除成功！");
    }

    /**
     * @description: 订单存储，订单详情存储，产品信息更新，费用记录存储
     * @param: [orderRequestDTO]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @PostMapping
    public R<String> submitOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        System.out.println(orderRequestDTO.toString());
        //更新Products表中的数据
        for (OrderItemDTO item : orderRequestDTO.getItems()) {
            Products products = new Products();
            products.setId(item.getId());
            products.setQuantity(item.getQuantity());
            productsService.updateById(products);
        }
        //添加SalesOrders表中的数据
        long id = idGenerator.generateId();
        SalesOrders salesOrders = new SalesOrders();
        salesOrders.setId(id);
        salesOrders.setCustomerName(orderRequestDTO.getCustomerName());
        salesOrders.setTotalAmount(orderRequestDTO.getTotalAmount());
        salesOrders.setUpdateTime(LocalDateTime.now());
        salesOrders.setStatus(0);
        salesOrdersService.save(salesOrders);

        //设置ExpenseRecords表格
        ExpenseRecords expenseRecords = new ExpenseRecords();
        expenseRecords.setOrderId(id);
        expenseRecords.setType(0);
        expenseRecords.setAmount(orderRequestDTO.getTotalAmount());
        expenseRecords.setUpdateTime(LocalDateTime.now());
        expenseRecordsService.save(expenseRecords);

        for (OrderItemDTO item : orderRequestDTO.getItems()) {
            if (item.getQuantity() != 0) {
                SalesOrderDetails salesOrderDetails = new SalesOrderDetails();
                salesOrderDetails.setOrderId(id);
                salesOrderDetails.setProductId(item.getId());
                salesOrderDetails.setQuantity(item.getNum());
                salesOrderDetails.setUnitPrice(item.getUnitPrice());
                salesOrderDetails.setTotalPrice(item.getNum() * item.getUnitPrice());
                salesOrderDetails.setUpdateTime(LocalDateTime.now());
                salesOrderDetailsService.save(salesOrderDetails);
            }
        }
        return R.success("订单添加成功！");
    }

}
