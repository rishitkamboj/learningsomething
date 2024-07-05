package com.example.demo.services.impl;

import com.example.demo.services.Redcolour;
import org.springframework.stereotype.Component;

@Component
public class redPrint implements Redcolour {
    public String print(){
        return "red";
    }}
