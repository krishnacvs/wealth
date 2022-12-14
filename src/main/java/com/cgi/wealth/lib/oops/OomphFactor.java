package com.cgi.wealth.lib.oops;

import lombok.Data;

public class OomphFactor {

    /**
     * Inner class can be private, protected
     */
    private class Emptiness{
        private boolean meaningless;

        boolean isItMeaningless(){
            return meaningless;
        }
    }

    public static void main(String[] args) {
        var aColony = new Colony(1);
        var bColony = new Colony(2);
        var cColony = new Colony(3);
        aColony.isPrivateFlag();

        var oomphFactor = new OomphFactor();

        var emptiness = oomphFactor.new Emptiness();
        emptiness.meaningless = true;
        System.out.println("Meaning "+emptiness.isItMeaningless());
        main(args, true);
    }

    /**
     * Though it main method it works as a normal method
     * @param args
     * @param doItNow
     */
    public static void main(String[] args, boolean doItNow) {
        System.out.println(args);
        System.out.println(doItNow);
        System.out.println("But it is never been called from outside");
    }
}

