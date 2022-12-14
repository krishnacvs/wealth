package com.cgi.wealth.lib;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Mobile extends Cloak implements Calculator, Camera{

    public static final String STRING_A_IS_S_AND_STRING_B_IS_S = "String A is %s and String B is %s";
    public static final String STRING_LIST[] = new String[]{"Ani", "Sam", " Joe"};
    public static final String[][] STRING_MATRIX = new String[3][]; // Jagged Array

    @Override
    public String showTime(){
        super.amIDefault();
        log.info("We can override a public or protected method in child class. But not a static method");
        return LocalDateTime.now().format(DateTimeFormatter.ISO_INSTANT);
    }

    @Override
    public final void onInt() {
        Calculator.super.onInt();
    }

    @Override
    public <T> List<T> genericsList() {
        Calculator.super.onInt();
        List<String> unmodifiableList = new ArrayList<>();
        try {
            final List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
            unmodifiableList = List.of(list.toArray(new String[]{}));
            unmodifiableList.add("four");
        } catch (Exception e) {
            log.info("It is immutable list");
        }
        return (List<T>) unmodifiableList;
    }

    @Override
    public boolean isEqual(String a, String b) {
        var str = String.format(STRING_A_IS_S_AND_STRING_B_IS_S,a, b);
        System.out.println(str);
        boolean boolFlag = false;
        if(a == b){
            System.out.println("String address are equal");
            boolFlag = true;
        }
        if(a != b){
            System.out.println("String address are not equal");
            boolFlag = false;
        }
        if(a.equals(b)){
            System.out.println("String contents are equal");
            boolFlag = true;
        }
        if(!a.equals(b)){
            System.out.println("String contents are not equal");
            boolFlag = false;
        }
        return  boolFlag;
    }

    @Override
    public String add(String a, String b) {
        try {
            var strBld = new StringBuilder();
            strBld.append(a);
            strBld.append(b);
            return strBld.toString();
        } catch (Exception e) {
            throw new RuntimeException(e); // Exception handling is process to address runtime errors
        } finally {
            System.out.println("finally is executed, used to close file | Database connection | Resource");
            System.out.println("finalize is called after is as part of garbage collector ha ha ha");
        }
    }

    @Override
    public Integer add(Integer a, Integer b) {
        //data type defines the type of the value that can be hold by the variable
        Long a1 = Long.valueOf(1);
        BigDecimal d1 = BigDecimal.valueOf(1);
        Double d2 = Double.valueOf(1);
        float f1 = 1;
        return a+b;
    }

    @Override
    public int zeroDividedBy(int a) {
        try {
            return a/0;
        } catch (Exception e) {
            log.info("Can not divide by 0");
            //This is not checked by the compiler so it is unchecked exception
        }
        return a;
    }

    @Override
    public int incrementByOne(int a) {
        a++;
        return a;
    }

}
