package com.cgi.wealth.lib.eight;

import com.cgi.wealth.lib.seven.inheritance.Display;
import com.cgi.wealth.lib.multithreading.entity.AppUser;
import org.jeasy.random.EasyRandom;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class TestCollectors {
    public static void main(String[] args) {
        List<Integer> iList = Arrays.asList(new Integer[]{1,2,3,4});
        int s = 10;
        EasyRandom generator = new EasyRandom();
        var randomDisplays = generator.objects(Display.class, s).collect(Collectors.toList());

        IntSummaryStatistics groupByWidth = randomDisplays.stream().collect(Collectors.summarizingInt(Display::getScreenWidth));
        System.out.println(groupByWidth);

        var randomUsers = generator.objects(AppUser.class, s).collect(Collectors.toList());
        randomUsers.forEach(System.out::println);
    }
}
