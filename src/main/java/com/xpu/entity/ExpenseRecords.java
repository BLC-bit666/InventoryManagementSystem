package com.xpu.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.entity
 * @Author: BLC
 * @CreateTime: 2023-07-04  19:57
 * @Description: 消费记录表实体
 * @Version: 1.0
 */
@lombok.Data
public class ExpenseRecords implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Integer type;
    private Integer amount;
    private Long orderId;
    @TableField(fill = FieldFill.INSERT_UPDATE)     //插入和修改时时填充字段
    private LocalDateTime updateTime;
}
