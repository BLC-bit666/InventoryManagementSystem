package com.xpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.entity.ExpenseRecords;
import com.xpu.mapper.ExpenseRecordsMapper;
import com.xpu.service.ExpenseRecordsService;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.service.impl
 * @Author: BLC
 * @CreateTime: 2023-07-04  20:10
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class ExpenseRecordsServiceImpl extends ServiceImpl<ExpenseRecordsMapper, ExpenseRecords> implements ExpenseRecordsService {
}
