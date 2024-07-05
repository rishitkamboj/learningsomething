package com.example.demo.services.impl;

import com.example.demo.services.Bluecolour;
import com.example.demo.services.ColourPrint;
import com.example.demo.services.Greencolour;
import com.example.demo.services.Redcolour;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ColourPrinter  implements ColourPrint {
    private Bluecolour blue;
    private Greencolour green;
    private Redcolour red;

    public ColourPrinter(Bluecolour blue, Greencolour green, Redcolour red) {
        this.blue = new bluePrint();
        this.green = new greenPrint();
        this.red = new redPrint();

    }
    public String print() {
        return String.join(", ", blue.print(), green.print(), red.print());
    }

}
