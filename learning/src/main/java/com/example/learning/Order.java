package com.example.learning;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Order {

    @PostConstruct
    public void hehe(){
        System.out.println("Bean construced");

    }

    @PreDestroy
    public void hi(){
        System.out.println("Bean is about to destroy WOWOWOW");
    }
    public Order(){
        System.out.println("bean created");
    }
}
