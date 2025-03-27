package com.example.test.service;

import com.example.test.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @author hx on 2025/3/7
 */

public interface UserService {
    User findByUserName(String username);

    void register(String username, String password);
}
