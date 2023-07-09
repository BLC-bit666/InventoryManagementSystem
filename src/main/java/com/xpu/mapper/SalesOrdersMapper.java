package com.xpu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.SalesOrders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.mapper
 * @Author: BLC
 * @CreateTime: 2023-07-04  21:03
 * @Description: 销售订单映射
 * @Version: 1.0
 */
@Mapper
public interface SalesOrdersMapper extends BaseMapper<SalesOrders> {
}
