package com.example.test.exception;

import com.example.test.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author hx on 2025/3/23
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        e.printStackTrace();//输出到控制台
        return  Result.error(StringUtils.hasLength(e.getMessage())?e.getMessage():"操作失败");
    };
}
