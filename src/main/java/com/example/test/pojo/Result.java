package com.example.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hx on 2025/3/7
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code;//业务状态码
    private String message;//提示信息
    private T data;//响应数据
    public static <E> Result<E> success(E data){
        return new Result<>(0,"操作成功",data);
    };
    public static Result success(){
        return new Result<>(0,"操作成功",null);
    };
    public static Result error(String message){
        return new Result<>(1,message,null);
    };
}
