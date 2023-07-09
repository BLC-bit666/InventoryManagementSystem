package com.xpu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xpu.common.R;
import com.xpu.entity.Suppliers;
import com.xpu.service.SuppliersService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.controller
 * @Author: BLC
 * @CreateTime: 2023-07-06  10:03
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/suppliers")
@Transactional(rollbackFor = Exception.class)
public class SuppliersController {
    @Autowired
    private SuppliersService suppliersService;

    /**
     * @description: 分页条件查询供应商
     * @param: [page, pageSize, name]
     * @return: com.xpu.common.R<com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.xpu.entity.Suppliers>>
     * @author: BLC
     */
    @GetMapping("/page")
    public R<Page<Suppliers>> page(int page1, int pageSize1, String name){
        //构造分页构造器
        Page<Suppliers> pageInfo = new Page<>(page1, pageSize1);

        //构造条件构造器
        LambdaQueryWrapper<Suppliers> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name),Suppliers::getName,name);
        queryWrapper.orderByDesc(Suppliers::getUpdateTime);
        suppliersService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }
    @GetMapping("/option")
    public R<List<Suppliers>> option(){
        return R.success(suppliersService.list());
    }

    /**
     * @description: 新增供应商
     * @param: [suppliers]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @PostMapping
    public R<String> save(@RequestBody Suppliers suppliers){
        suppliersService.save(suppliers);
        return R.success("新增供应商成功！");
    }

    /**
     * @description: 根据id修改供应商信息
     * @param: [suppliers]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @PutMapping
    public R<String> update(@RequestBody Suppliers suppliers){
        suppliers.setUpdateTime(LocalDateTime.now());
        suppliersService.updateById(suppliers);
        return R.success("操作成功！");
    }

    /**
     * @description: 根据id删除供应商信息
     * @param: [id]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable Long id){
        suppliersService.removeById(id);
        return R.success("删除成功！");
    }

    /**
     * @description: 根据id查询供应商信息
     * @param: [id]
     * @return: com.xpu.common.R<com.xpu.entity.Suppliers>
     * @author: BLC
     */
    @GetMapping("/{id}")
    public R<Suppliers> getById(@PathVariable Long id){
        Suppliers suppliers = suppliersService.getById(id);
        if(suppliers!=null){
            return R.success(suppliers);
        }
        return R.error("查询失败！");
    }
}
