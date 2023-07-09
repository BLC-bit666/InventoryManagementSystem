package com.xpu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.ExpenseRecords;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.mapper
 * @Author: BLC
 * @CreateTime: 2023-07-04  20:07
 * @Description: 费用映射
 * @Version: 1.0
 */
@Mapper
public interface ExpenseRecordsMapper extends BaseMapper<ExpenseRecords> {
}
