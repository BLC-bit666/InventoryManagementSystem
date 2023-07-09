package com.xpu.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xpu.common.R;
import com.xpu.entity.Employee;
import com.xpu.service.EmployeeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.controller
 * @Author: BLC
 * @CreateTime: 2023-07-06  14:37
 * @Description: 员工管理控制
 * @Version: 1.0
 */
@RestController
@RequestMapping("/employee")
@Transactional(rollbackFor = Exception.class)
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * @description: 用户登录功能
     * @param: [request, employee]
     * @return: com.xpu.common.R<com.xpu.entity.Employee>
     * @author: BLC
     */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee){
        //1、将提交的密码进行md5加密处理
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        //2、封装查询条件，查询数据
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);
        //3、登录条件的判断
        if(emp == null){
            return R.error("用户名不存在！");
        }
        if(!emp.getPassword().equals(password)){
            return R.error("密码错误");
        }

        if(emp.getStatus() == 0){
            return R.error("账号已禁用！");
        }
        //4、登录成功，将员工id存入session、
        request.getSession().setAttribute("employee",emp.getId());
        return R.success(emp);
    }

    /**
     * @description: 员工退出功能
     * @param: [request]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @PostMapping("/logout")
    public R<String> log0ut(HttpServletRequest request){
        //清理session中保存的员工id
        request.getSession().removeAttribute("employee");
        return R.success("退出成功！");
    }

    /**
     * @description: 添加员工
     * @param: [employee]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @PostMapping
    public R<String> save(@RequestBody Employee employee){
        //设置初始密码，进行md5加密
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        employee.setStatus(1);
        //存入数据库
        employeeService.save(employee);
        return R.success("新增员工成功！");
    }


    /**
     * @description: 分页查询
     * @param: [page, pageSize, name]
     * @return: com.xpu.common.R<com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.xpu.entity.Employee>>
     * @author: BLC
     */
    @GetMapping("/page")
    public R<Page<Employee>> page(int page, int pageSize, String name){
        //构造分页构造器
        Page<Employee> pageInfo = new Page<>(page, pageSize);

        //构造条件构造器
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name),Employee::getName,name);
        queryWrapper.orderByDesc(Employee::getUpdateTime);
        employeeService.page(pageInfo,queryWrapper);
        return R.success(pageInfo);
    }

    /**
     * @description: 用户信息更新操作
     * @param: [employee]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @PutMapping
    public R<String> update(@RequestBody Employee employee){
        employee.setUpdateTime(LocalDateTime.now());
        employeeService.updateById(employee);
        return R.success("操作成功！");
    }

    /**
     * @description: 按id查询员工信息，用于编辑员工信息时回显数据
     * @param: [id]
     * @return: com.xpu.common.R<com.xpu.entity.Employee>
     * @author: BLC
     */
    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        if(employee!=null){
            return R.success(employee);
        }
        return R.error("查询失败！");
    }
}
