package com.spring.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentSimple implements ComponentDependency {
    @Override
    public void saludar() {
        System.out.println("Hola mundo desde componente");

    }
}
