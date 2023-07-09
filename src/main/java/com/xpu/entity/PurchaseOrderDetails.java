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
 * @CreateTime: 2023-07-04  19:43
 * @Description: 购买订单详情表实体
 * @Version: 1.0
 */
@Data
public class PurchaseOrderDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long orderId;
    private Long productId;
    private Integer  quantity;
    private Integer unitPrice;
    private Integer totalPrice;
    @TableField(fill = FieldFill.INSERT_UPDATE)     //插入和修改时时填充字段
    private LocalDateTime updateTime;
}
