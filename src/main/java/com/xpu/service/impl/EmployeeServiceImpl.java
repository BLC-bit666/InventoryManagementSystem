package com.xpu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xpu.entity.Employee;
import com.xpu.mapper.EmployeeMapper;
import com.xpu.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.service.impl
 * @Author: BLC
 * @CreateTime: 2023-07-06  14:36
 * @Description:
 * @Version: 1.0
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
