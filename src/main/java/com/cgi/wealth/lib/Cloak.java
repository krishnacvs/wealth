package com.cgi.wealth.lib;

import com.cgi.wealth.lib.seven.inheritance.Display;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class Cloak extends Display {

    protected String showTime(){
        log.info("It will be accessed within the child class. Single level of inheritance");
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    String amIDefault(){
        return "Yes I am a default method";
    }
}
