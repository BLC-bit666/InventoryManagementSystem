package com.xpu.common;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.common
 * @Author: BLC
 * @CreateTime: 2023-07-06  14:52
 * @Description: TODO
 * @Version: 1.0
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * @description: 将前登录用户id存入本地本地线程副本
     * @param: [id]
     * @return: void
     * @author: BLC
     */
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }


    /**
     * @description: 从本地本地线程副本获取将前登录用户id
     * @param: []
     * @return: java.lang.Long
     * @author: BLC
     */
    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
