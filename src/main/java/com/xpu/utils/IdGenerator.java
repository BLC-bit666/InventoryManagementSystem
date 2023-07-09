package com.xpu.utils;

import com.fasterxml.uuid.Generators;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.utils
 * @Author: BLC
 * @CreateTime: 2023-07-06  16:54
 * @Description: 雪花算法，id生成
 * @Version: 1.0
 */
@Component
public class IdGenerator {
    /**
     * @description: 雪花算法，id生成
     * @param: []
     * @return: long
     * @author: BLC
     */
    public long generateId() {
        return Generators.timeBasedGenerator().generate().timestamp();
    }
}