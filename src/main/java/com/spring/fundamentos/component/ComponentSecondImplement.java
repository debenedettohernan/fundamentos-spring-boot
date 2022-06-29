package com.spring.fundamentos.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component @Primary
public class ComponentSecondImplement implements ComponentDependency {

    @Override
    public void saludar() {
        System.out.println("Ahora estoy en el segundo componente");
    }
}
