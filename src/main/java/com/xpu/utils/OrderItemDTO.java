package com.xpu.utils;

import lombok.Data;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.utils
 * @Author: BLC
 * @CreateTime: 2023-07-07  17:06
 * @Description: 前后端特殊数据封装
 * @Version: 1.0
 */
@Data
public class OrderItemDTO {
    private Long id;
    private Integer quantity;
    private Integer num;
    private Integer unitPrice;


    public OrderItemDTO() {
    }

    public OrderItemDTO(Long id, Integer quantity, Integer num, Integer unitPrice) {
        this.id = id;
        this.quantity = quantity;
        this.num = num;
        this.unitPrice = unitPrice;
    }
}