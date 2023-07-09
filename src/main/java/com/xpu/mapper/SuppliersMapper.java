package com.xpu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.Suppliers;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.mapper
 * @Author: BLC
 * @CreateTime: 2023-07-04  28:07
 * @Description: 供应商映射
 * @Version: 1.0
 */
@Mapper
public interface SuppliersMapper extends BaseMapper<Suppliers> {
}
