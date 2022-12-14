package com.cgi.wealth.lib.seven.language;

import com.cgi.wealth.lib.multithreading.entity.AppUser;

import java.util.ArrayList;

public class PassVars {
    public static void main(String[] args) {
        var iList = new ArrayList<>();
        iList.add(1);
        iList.add(2);
        PassVars p = new PassVars();
        System.out.println(iList);
        p.passByReference(iList);
        System.out.println(iList);
        var st = "John";
        System.out.println(st);
        p.passByReference(st);
        System.out.println(st);

        var appUser = new AppUser();
        appUser.setFirst_name("John");
        System.out.println(appUser);
        p.passByReference(appUser);
        System.out.println(appUser);
    }

    private void passByReference(AppUser appUser) {
        appUser.setLast_name("Snow");
    }

    private void passByReference(ArrayList<Object> iList) {
        iList.add(30);
    }

    private void passByReference(String fName) {
        new StringBuilder(fName).append("Snow");
    }
}
