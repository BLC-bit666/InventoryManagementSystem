package com.xpu.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @BelongsProject: InventoryManagementSystem
 * @BelongsPackage: com.xpu.common
 * @Author: BLC
 * @CreateTime: 2023-07-06  14:27
 * @Description: 全局异常处理器
 * @Version: 1.0
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * @description: sql异常处理
     * @param: [ex]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> ExceptionHandle(SQLIntegrityConstraintViolationException ex) {
        if (ex.getMessage().contains("Duplicate entry")) {
            String[] split = ex.getMessage().split(" ");
            String msg = split[2] + "已存在！";
            return R.error(msg);
        }
        return R.error("操作失败");

    }

    /**
     * @description: 其他异常处理
     * @param: [ex]
     * @return: com.xpu.common.R<java.lang.String>
     * @author: BLC
     */
    @ExceptionHandler(Exception.class)
    public R<String> CommonExceptionHandle(Exception ex) {
        ex.printStackTrace();
        return R.error("操作失败");

    }
}
