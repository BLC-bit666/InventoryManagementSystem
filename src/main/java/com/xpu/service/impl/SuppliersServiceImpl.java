package com.xpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.entity.Suppliers;
import com.xpu.mapper.SuppliersMapper;
import com.xpu.service.SuppliersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.service.impl
 * @Author: BLC
 * @CreateTime: 2023-07-05  16:07
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class SuppliersServiceImpl extends ServiceImpl<SuppliersMapper, Suppliers> implements SuppliersService {
}
