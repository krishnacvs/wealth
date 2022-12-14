package com.cgi.wealth.lib.seven.datatypes;

import java.io.Serializable;

/**
 * It is a special data type
 * It is introduced in 1.5
 * Used to define collection of constants
 * It can be outside or inside a class. But not in a method
 * As it is implicitly final.We can't declare it as final
 * toString is already overridden
 * Enum are typesafe
 */
public enum PizzaStatus implements Serializable {
    ORDERED(1),
    PREP(2),
    BAKE(3),
    QUALITY_CHECK(4),
    OUT_FOR_DELIVERY(5),
    DELIVERED(6);


    PizzaStatus(int i) {
    }
}
