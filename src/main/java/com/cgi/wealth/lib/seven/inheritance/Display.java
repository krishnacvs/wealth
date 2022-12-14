package com.cgi.wealth.lib.seven.inheritance;

import lombok.Data;
import lombok.NoArgsConstructor;

//Display class is common parent for Cloak and CellPhone it is called Hierarchical inheritance
@Data
@NoArgsConstructor
public class Display extends LCD{
    private int screenWidth;
    private int screenHeight;

    Display(int screenWidth,int screenHeight){
        super(screenWidth,screenHeight);
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
    }

    @Override
    String getResolution(){
        super.getResolution();
        System.out.println(String.format("Display Resolution: %s X %s",screenWidth, screenWidth));
        return String.format("%s X %s",screenWidth, screenWidth);
    }
}
