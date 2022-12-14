package com.cgi.wealth.lib.FAANG;

public class CharCount {
    public static void main(String[] args) {
        String sentence = "I am a disco dancer";
        char[] sentenceToChar = sentence.toCharArray();
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (!Character.isWhitespace(sentenceToChar[i])) {
                System.out.println(sentenceToChar[i]);
                count++;
            }
        }
        System.out.println("Total character count: "+count);
    }
}
