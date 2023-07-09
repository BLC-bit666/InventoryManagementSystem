package com.xpu.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.common
 * @Author: BLC
 * @CreateTime: 2023-07-05  20:14
 * @Description: TODO
 * @Version: 1.0
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("updateTime", LocalDateTime.now());
    }

    /**
     * @description: 更新公共属性时自动填充
     * @param: [metaObject]
     * @return: void
     * @author: BLC
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        metaObject.setValue("updateTime", LocalDateTime.now());
    }
}
