package com.spring.fundamentos.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "user")
@Getter
@Setter
public class UserPojo {
    private String email;
    private String pass;
    private int edad;

    public UserPojo() {
    }

    public UserPojo(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public UserPojo(String email, String pass, int edad) {
        this.email = email;
        this.pass = pass;
        this.edad = edad;
    }

}
