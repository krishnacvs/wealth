package com.cgi.wealth.lib.seven.inheritance;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
// Constructor used to initiate the member variable
public final class CellPhone extends Display {

    //Example of a tightly encapsulated
    private String one;
    private Integer two;
    private void onInt(){
        log.info("The screen width {} height {}",super.getScreenWidth(),super.getScreenHeight());
        System.out.println("CellPhone class can not be inherited");
    }

    // as it is tightly encapsulated class, Need getters and setters to access the member variables
    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

}
