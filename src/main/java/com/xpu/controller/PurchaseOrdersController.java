package com.xpu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xpu.common.R;
import com.xpu.entity.*;
import com.xpu.service.ExpenseRecordsService;
import com.xpu.service.ProductsService;
import com.xpu.service.PurchaseOrderDetailsService;
import com.xpu.service.PurchaseOrdersService;
import com.xpu.utils.IdGenerator;
import com.xpu.utils.OrderItemDTO;
import com.xpu.utils.OrderRequestDTO;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.controller
 * @Author: BLC
 * @CreateTime: 2023-07-05  20:35
 * @Description: 购买订单控制
 * @Version: 1.0
 */
@RestController
@RequestMapping("/purchaseOrders")
@Transactional(rollbackFor = Exception.class)
public class PurchaseOrdersController {
    @Autowired
    private PurchaseOrdersService purchaseOrdersService;
    @Autowired
    private ProductsService productsService;
    @Autowired
    private PurchaseOrderDetailsService purchaseOrderDetailsService;
    @Autowired
    private IdGenerator idGenerator;
    @Autowired
    private ExpenseRecordsService expenseRecordsService;

    /**
     * @description: 分页条件查询购买订单记录
     * @param: [page, pageSize, id]
     * @return: com.xpu.common.R<com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.xpu.entity.PurchaseOrders>>
     * @author: BLC
     */
    @GetMapping("/page")
    public R<Page<PurchaseOrders>> page(int page, int pageSize, Long id){
        //构造分页构造器
        Page<PurchaseOrders> pageInfo = new Page<>(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<PurchaseOrders> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(id!=null,PurchaseOrders::getId,id);
        queryWrapper.orderByDesc(PurchaseOrders::getUpdateTime);
        purchaseOrdersService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * @description: 根据id更新购买订单记录
     * @param: [purchaseOrders]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @PutMapping
    public R<String> update(@RequestBody PurchaseOrders purchaseOrders){
        purchaseOrders.setUpdateTime(LocalDateTime.now());
        purchaseOrdersService.updateById(purchaseOrders);
        return R.success("操作成功！");
    }

    /**
     * @description: 根据id删除购买订单记录
     * @param: [id]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable Long id){
        purchaseOrdersService.removeById(id);
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
        //创建对象
        PurchaseOrders purchaseOrders = new PurchaseOrders();
        System.out.println(orderRequestDTO.toString());
        for (OrderItemDTO item : orderRequestDTO.getItems()) {
            Products products = new Products();
            //更新Products表中的数据
            products.setId(item.getId());
            products.setQuantity(item.getQuantity());
            productsService.updateById(products);
        }

        //添加PurchaseOrders表中的数据
        long id = idGenerator.generateId();
        purchaseOrders.setId(id);
        purchaseOrders.setTotalAmount(orderRequestDTO.getTotalAmount());
        purchaseOrders.setSupplierId(orderRequestDTO.getSuppliersId());
        purchaseOrders.setUpdateTime(LocalDateTime.now());
        purchaseOrders.setStatus(0);
        purchaseOrdersService.save(purchaseOrders);

        //设置ExpenseRecords表格
        ExpenseRecords expenseRecords = new ExpenseRecords();
        expenseRecords.setOrderId(id);
        expenseRecords.setType(1);
        expenseRecords.setAmount(orderRequestDTO.getTotalAmount());
        expenseRecords.setUpdateTime(LocalDateTime.now());
        expenseRecordsService.save(expenseRecords);

        for (OrderItemDTO item : orderRequestDTO.getItems()) {
            if(item.getQuantity()!=0) {
                PurchaseOrderDetails purchaseOrderDetails = new PurchaseOrderDetails();
                //purchaseOrderDetails添加表中的数据
                purchaseOrderDetails.setOrderId(id);
                purchaseOrderDetails.setProductId(item.getId());
                purchaseOrderDetails.setQuantity(item.getNum());
                purchaseOrderDetails.setUnitPrice(item.getUnitPrice());
                purchaseOrderDetails.setTotalPrice(item.getNum() * item.getUnitPrice());
                purchaseOrderDetails.setUpdateTime(LocalDateTime.now());
                purchaseOrderDetailsService.save(purchaseOrderDetails);
            }
        }
        return R.success("订单添加成功！");
    }

}
