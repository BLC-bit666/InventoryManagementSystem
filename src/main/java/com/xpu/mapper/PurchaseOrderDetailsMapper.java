package com.xpu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.PurchaseOrderDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.mapper
 * @Author: BLC
 * @CreateTime: 2023-07-04  21:07
 * @Description: 购买订单详情映射
 * @Version: 1.0
 */
@Mapper
public interface PurchaseOrderDetailsMapper extends BaseMapper<PurchaseOrderDetails> {
}
