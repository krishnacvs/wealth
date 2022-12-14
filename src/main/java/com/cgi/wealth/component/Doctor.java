package com.cgi.wealth.component;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("Doctor")
@Lazy
public class Doctor implements Qualification{
    @Override
    public String degreeName() {
        return "Doctor";
    }
}
