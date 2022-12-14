package com.cgi.wealth.lib.multithreading.computing;

import com.cgi.wealth.lib.multithreading.entity.AppUser;

import java.util.List;
import java.util.Optional;

public class OptionalApp {

    public static void main(String[] args) {
        List<String> users = null;
        if (Optional.ofNullable(users).isPresent()) {
            System.out.println("Optional ofNullable pass");
        } else {
            System.out.println("Optional ofNullable else");
        }

        if (Optional.of(users).isPresent()) {
            System.out.println("Optional of pass");
        } else {
            System.out.println("Optional of else");
        }
    }
}
