package com.xpu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.Products;
import org.apache.ibatis.annotations.Mapper;
/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.mapper
 * @Author: BLC
 * @CreateTime: 2023-07-04  20:45
 * @Description: 产品映射
 * @Version: 1.0
 */
@Mapper
public interface ProductsMapper extends BaseMapper<Products> {
}
