package com.spring.fundamentos.CaseUser;

import com.spring.fundamentos.entity.User;
import com.spring.fundamentos.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User upDate(User newUser, Long id) {
        return userService.upDate(newUser, id);
    }
}
