package com.xpu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.PurchaseOrders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.mapper
 * @Author: BLC
 * @CreateTime: 2023-07-04  22:07
 * @Description: 购买订单映射
 * @Version: 1.0
 */
@Mapper
public interface PurchaseOrdersMapper extends BaseMapper<PurchaseOrders> {
}
