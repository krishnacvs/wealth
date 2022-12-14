package com.cgi.wealth.component;

import org.springframework.stereotype.Component;

@Component("Engineering")
public class Engineering implements Qualification{

    @Override
    public String degreeName() {
        return "Engineering";
    }
}
