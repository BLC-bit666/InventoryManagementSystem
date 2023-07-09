package com.xpu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.Supply;
import org.apache.ibatis.annotations.Mapper;
/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.mapper
 * @Author: BLC
 * @CreateTime: 2023-07-04  30:07
 * @Description: 供需关系映射
 * @Version: 1.0
 */
@Mapper
public interface SupplyMapper extends BaseMapper<Supply> {
}
