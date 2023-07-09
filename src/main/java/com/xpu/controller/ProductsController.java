package com.xpu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xpu.common.R;
import com.xpu.entity.Products;
import com.xpu.entity.Supply;
import com.xpu.service.ProductsService;
import com.xpu.service.SupplyService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.controller
 * @Author: BLC
 * @CreateTime: 2023-07-05  20:04
 * @Description: 产品信息控制
 * @Version: 1.0
 */
@RestController
@RequestMapping("/products")
@Transactional(rollbackFor = Exception.class)
public class ProductsController {
    @Autowired
    private ProductsService productsService;
    @Autowired
    private SupplyService supplyService;
    /**
     * @description: 分页条件查询库存物品
     * @param: [page, pageSize, name]
     * @return: com.xpu.common.R<com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.xpu.entity.Products>>
     * @author: BLC
     */
    @GetMapping("/page")
    public R<Page<Products>> page(int page,int pageSize,String name){
        //构造分页构造器
        Page<Products> pageInfo = new Page<>(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Products> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name),Products::getName,name);
        queryWrapper.orderByDesc(Products::getUpdateTime);
        productsService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }
    /**
     * @description: 新增商品
     * @param: [products]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @PostMapping
    public R<String> save(@RequestBody Products products){
        //添加到Products表
        productsService.save(products);
        //添加供应关系到Supply表
        Supply supply =new Supply();
        supply.setProductId(products.getId());
        supply.setSuppliersId(products.getSupplierId());
        supply.setUpdateTime(LocalDateTime.now());
        supplyService.save(supply);
        return R.success("新增商品成功！");
    }

    /**
     * @description: 修改商品
     * @param: [products]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @PutMapping
    public R<String> update(@RequestBody Products products){
        products.setUpdateTime(LocalDateTime.now());
        productsService.updateById(products);
        return R.success("修改成功！");
    }

    /**
     * @description: 按id查询商品
     * @param: [id]
     * @return: com.xpu.common.R<com.xpu.entity.Products>
     * @author: BLC
     */
    @GetMapping("/{id}")
    public R<Products> getById(@PathVariable Long id){
        Products products = productsService.getById(id);
        if(products!=null){
            return R.success(products);
        }
        return R.error("查询失败！");
    }
    /**
     * @description: 按id删除
     * @param: [id]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable Long id){
        productsService.removeById(id);
        return R.success("删除成功！");
    }
}
