package com.example.demo.services.impl;

import com.example.demo.services.Bluecolour;
import org.springframework.stereotype.Component;

@Component
public class bluePrint implements Bluecolour {
    public String print(){
        return "blue";
    }
}
