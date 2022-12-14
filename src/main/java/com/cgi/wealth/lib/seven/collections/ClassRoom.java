package com.cgi.wealth.lib.seven.collections;

import org.junit.Test;

import java.util.PriorityQueue;

public class ClassRoom {

    @Test
    public void sessesionPriorityQueue(){
        PriorityQueue toDo = new PriorityQueue();
                 toDo.add("dishes");
                 toDo.add("laundry");
                 toDo.offer("bills");
                 System.out.print(toDo.size() + " " + toDo.poll());
                 System.out.print(" " + toDo.peek() + " " + toDo.poll());
                 System.out.println(" " + toDo.poll() + " " + toDo.poll());
    }
}
