package com.cgi.wealth.lib.FAANG;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FindVowels {
    public static void main(String[] args) {
        String first = "Hello";
        FindVowels findVowels = new FindVowels();
        System.out.println(findVowels.stringContainsVowel(first));
        Predicate<String> p = Pattern.compile(".*[aeiou].*").asPredicate();
        List<String> supplierNames = Arrays.asList("Ttt","sup1", "sup2", "sup3");
        List<String> listOfStr = supplierNames.stream().filter(k->!p.test(k)).collect(Collectors.toList());
        System.out.println(listOfStr);
    }

    private boolean stringContainsVowel(String input){
        Predicate<String> p = Pattern.compile(".*[aeiou].*").asPredicate();
        return p.test(input);
    }
}
