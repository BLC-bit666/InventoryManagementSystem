package com.xpu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xpu.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.mapper
 * @Author: BLC
 * @CreateTime: 2023-07-06  14:35
 * @Description: 员工映射
 * @Version: 1.0
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
