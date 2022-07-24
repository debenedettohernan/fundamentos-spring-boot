package com.spring.fundamentos.configuration;

import com.spring.fundamentos.CaseUser.GetUser;
import com.spring.fundamentos.CaseUser.GetUserImplement;
import com.spring.fundamentos.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CaseUseConfiguration {
    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);

    }
}
