package com.example.test.controller;

import com.example.test.pojo.Result;
import com.example.test.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
/**
 * @author hx on 2025/3/25
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/){
//        //验证token
//        try {
//            Map<String,Object> claims = JwtUtil.parseToken(token);
//            return Result.success("文章数据");
//        } catch (Exception e) {
//            response.setStatus(401);
//            return Result.error("未登录");
//        }
        return Result.success("文章数据");
    }
}
