package com.cgi.wealth.lib.seven.datatypes;


public class EnumExercise {

    /**
     * Private enum
     */
    private enum MyColors {

        RED("red"),
        YELLOW("yellow"),
        GREEN("green");
        private String s;
        MyColors(String s){
            this.s = s;
        }

        String getColor(){
          return s;
        }
    };

    public static void main(String[] args) {
        System.out.println("toString "+ PizzaStatus.QUALITY_CHECK.toString());
        System.out.println("Delivered "+PizzaStatus.valueOf("DELIVERED"));

        System.out.println("Delivered "+PizzaStatus.DELIVERED);

        PizzaStatus[] pizzaStatuses = PizzaStatus.values();

        for (PizzaStatus p:  pizzaStatuses) {
            System.out.println(p);
        }

        MyColors[] Colors = MyColors.values();

        for (MyColors c:  Colors) {
            System.out.println(c + " - "+c.getColor()+" - "+c.toString()+" - "+c.ordinal());
        }

        var red = MyColors.RED;
        System.out.println("Red "+red.getColor());
    }
}
