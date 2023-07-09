package com.xpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.entity.PurchaseOrderDetails;
import com.xpu.mapper.PurchaseOrderDetailsMapper;
import com.xpu.service.PurchaseOrderDetailsService;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.service.impl
 * @Author: BLC
 * @CreateTime: 2023-07-04  20:46
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class PurchaseOrderDetailsServiceImpl extends ServiceImpl<PurchaseOrderDetailsMapper, PurchaseOrderDetails> implements PurchaseOrderDetailsService {
}
