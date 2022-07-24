package com.spring.fundamentos.CaseUser;


import com.spring.fundamentos.entity.User;
import com.spring.fundamentos.service.UserService;
import org.springframework.stereotype.Component;


@Component
public class CreateUser {
    private UserService userService;

    public CreateUser(UserService userService) {
        this.userService = userService;
    }

    public User save(User newUser) {
        return userService.save(newUser);
    }
}
