package com.cgi.wealth.lib.seven.inheritance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LCD {

    private int screenWidth;
    private int screenHeight;

    String getResolution(){
        System.out.println(String.format("LCD Resolution: %s X %s",screenWidth, screenWidth));
        return String.format("%s X %s",screenWidth, screenWidth);
    }
}
