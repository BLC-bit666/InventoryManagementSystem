package com.xpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.entity.SalesOrders;
import com.xpu.mapper.SalesOrdersMapper;
import com.xpu.service.SalesOrdersService;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.service.impl
 * @Author: BLC
 * @CreateTime: 2023-07-05  21:57
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class SalesOrdersServiceImpl extends ServiceImpl<SalesOrdersMapper, SalesOrders> implements SalesOrdersService {
}
