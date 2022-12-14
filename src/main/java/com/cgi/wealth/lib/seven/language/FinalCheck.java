package com.cgi.wealth.lib.seven.language;

import com.cgi.wealth.lib.multithreading.entity.AppUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *         final AppUser a = new AppUser("Peter","Parker");
 *         a = new AppUser("John","Snow");
 *         a = new AppUser("John","Snow");
 *         a = new AppUser("John","Snow"); Not valid
 */

public class FinalCheck {
    public static void main(String[] args) {
        final AppUser a;
        a = new AppUser("Peter","Parker");
        a.setLast_name("Snow"); //const is blocked keyword but not in use

        final List<AppUser> aList = new ArrayList<>();
        aList.add(a);
        aList.get(0).setFirst_name("John");

        List<AppUser> uList = Collections.unmodifiableList(aList);
        //uList.add(a); Not valid
        uList.get(0).setFirst_name("John");

        List<AppUser> oList = List.of(new AppUser[]{a});
        //oList.add(a); not valid
        oList.get(0).setFirst_name("John");

        List<AppUser> cList = List.copyOf(aList);
        // cList.add(a); //not valid
        cList.get(0).setFirst_name("John");


        System.out.println("Completed");
    }
}
