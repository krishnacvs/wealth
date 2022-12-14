package com.cgi.wealth.lib;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeExcercise {
    public static void main(String[] args) {
        ZonedDateTime nowInParis = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        System.out.println("nowInParis "+nowInParis);
    }
}
