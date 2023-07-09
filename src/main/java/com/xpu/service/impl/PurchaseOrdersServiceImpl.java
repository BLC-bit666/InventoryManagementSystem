package com.xpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.entity.PurchaseOrders;
import com.xpu.mapper.PurchaseOrdersMapper;
import com.xpu.service.PurchaseOrdersService;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.service.impl
 * @Author: BLC
 * @CreateTime: 2023-07-04  20:50
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class PurchaseOrdersServiceImpl extends ServiceImpl<PurchaseOrdersMapper, PurchaseOrders> implements PurchaseOrdersService {
}
