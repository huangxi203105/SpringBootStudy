package com.example.test.controller;

import com.example.test.pojo.Result;
import com.example.test.pojo.User;
import com.example.test.service.UserService;
import com.example.test.utils.JwtUtil;
import com.example.test.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author hx on 2025/3/7
 */
@RestController//表示返回json数据
@RequestMapping("/user") //表示请求路径
@Validated // 表示校验
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    // \S表示非空字符 {5，16} 表示数量
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password){
      User user = userService.findByUserName(username);
      if(user==null){
          userService.register(username,password);
          return Result.success();
      }else {
          return Result.error("用户名已经被占用");
      }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$")String password){
        //根据用户名查询用户
        User user = userService.findByUserName(username);
        if(user == null){
            return Result.error("用户名错误");
        }
        if(Md5Util.getMD5String(password).equals(user.getPassword())){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",user.getId());
            claims.put("username",user.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }
        return Result.error("密码错误");
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(@RequestHeader(name="Authorization") String token){
        Map<String,Object> map = JwtUtil.parseToken(token);
        System.out.println(map);
        String username = (String) map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }
}
