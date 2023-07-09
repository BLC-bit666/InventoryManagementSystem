package com.xpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.entity.SalesOrderDetails;
import com.xpu.mapper.SalesOrderDetailsMapper;
import com.xpu.service.SalesOrderDetailsService;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.service.impl
 * @Author: BLC
 * @CreateTime: 2023-07-04  21:01
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class SalesOrderDetailsServiceImpl extends ServiceImpl<SalesOrderDetailsMapper, SalesOrderDetails> implements SalesOrderDetailsService {
}
