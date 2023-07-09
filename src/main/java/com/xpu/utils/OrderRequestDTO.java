package com.xpu.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.utils
 * @Author: BLC
 * @CreateTime: 2023-07-07  17:08
 * @Description: 前后端特殊数据封装与交互
 * @Version: 1.0
 */
@Data
public class OrderRequestDTO {
    private List<OrderItemDTO> items;
    private Integer totalAmount;
    private String customerName;
    private Long suppliersId;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(List<OrderItemDTO> items, Integer totalAmount, String customerName, Long suppliersId) {
        this.items = items;
        this.totalAmount = totalAmount;
        this.customerName = customerName;
        this.suppliersId = suppliersId;
    }
}
