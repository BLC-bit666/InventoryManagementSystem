package com.xpu.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.entity
 * @Author: BLC
 * @CreateTime: 2023-07-04  19:50
 * @Description: 销售历史订单表实体
 * @Version: 1.0
 */
@Data
public class SalesOrders implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String customerName;
    private Integer status;
    private Integer totalAmount;
    @TableField(fill = FieldFill.INSERT_UPDATE)     //插入和修改时时填充字段
    private LocalDateTime updateTime;
}
