package com.cgi.wealth.service;

import com.cgi.wealth.lib.multithreading.entity.AppUser;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    public AppUser addUser(String fname, String sname)
    {
        System.out.println(
                "Add student service method called");
        AppUser appUser = new AppUser();
        appUser.setFirst_name(fname);
        appUser.setLast_name(sname);
        return appUser;
    }
}
