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
 * @CreateTime: 2023-07-04  20:04
 * @Description: 供求关系表实体
 * @Version: 1.0
 */
@Data
public class Supply implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long productId;
    private Long suppliersId;
    @TableField(fill = FieldFill.INSERT_UPDATE)     //插入和修改时时填充字段
    private LocalDateTime updateTime;

}
