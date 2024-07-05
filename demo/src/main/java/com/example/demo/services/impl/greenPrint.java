package com.example.demo.services.impl;

import com.example.demo.services.Greencolour;
import org.springframework.stereotype.Component;

@Component
public class greenPrint implements Greencolour {
    public String print(){
        return "green";
    }
}
