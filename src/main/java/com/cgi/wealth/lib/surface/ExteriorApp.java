package com.cgi.wealth.lib.surface;

import java.util.List;
import java.util.stream.IntStream;

public class ExteriorApp {
    public static void main(String[] args) {
        ExteriorApp exteriorApp = new ExteriorApp();
        Interior interior = exteriorApp.new Interior();
        interior.display();

        Nested nested = new Nested();
        nested.display();

        ExteriorApp exteriorApp1 = new ExteriorApp();
        exteriorApp1.method();
        exteriorApp.getPasta();
        exteriorApp.innerInterfaceDemo();
        exteriorApp.threadTest();
    }

    private void innerInterfaceDemo() {
        ExteriorInterface.Interior exteriorInterface = new ExteriorInterface.Interior() {
            @Override
            public void info(int s) {
                System.out.println("Interior Interface info "+s);
            }
        };
        IntStream.range(0, 5).forEach((s) -> exteriorInterface.info(s));
    }

    private void threadTest() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T1 New Runnable anonymous class");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T2 New Runnable anonymous class");
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Pasta getPasta() {
        Pasta pasta = new Pasta() {
            public void prepare(String sauce) {
                System.out.println(sauce + " sauce pasta is prepared");
            }

            @Override
            String append(String sauce) {
                return "Hello ".concat(sauce);
            }
        };
        List<String> sauces = List.of(new String[]{"Red", "White"});
        sauces.forEach((s) -> {
            pasta.prepare(s);
            String app = pasta.append(s);
            System.out.println(app);
        });
        return pasta;
    }

    class Interior {
        void display() {
            System.out.println("Interior display");
        }
    }

    static class Nested {
        void display() {
            System.out.println("Nested display");
        }
    }

    /**
     * Local class can be final and abstract
     */
    public void method() {
        String local_display = "Local display";
        final class Local {
            void display() {
                System.out.println(local_display);
            }
        }
        Local local = new Local();
        local.display();
    }

}

abstract class Pasta {

    abstract void prepare(String sauce);

    abstract String append(String sauce);
}

class Building implements ExteriorInterface.Interior {

    @Override
    public void info(int s) {

    }
}

class ShoppingComplex {
    @FunctionalInterface
    interface Shop {
        void display();
    }
}