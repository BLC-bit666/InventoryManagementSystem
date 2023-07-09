package com.xpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.entity.Supply;
import com.xpu.mapper.SupplyMapper;
import com.xpu.service.SupplyService;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.service.impl
 * @Author: BLC
 * @CreateTime: 2023-07-05  16:11
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class SupplyServiceImpl extends ServiceImpl<SupplyMapper, Supply> implements SupplyService {
}
