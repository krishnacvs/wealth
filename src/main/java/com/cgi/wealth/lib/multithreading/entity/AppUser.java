package com.cgi.wealth.lib.multithreading.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "USER_TBL")
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    public AppUser(String first_name,String last_name){
        this.setLast_name(first_name);
        this.setLast_name(last_name);
    }

    @Id
    @GeneratedValue
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String ip_address;
}
