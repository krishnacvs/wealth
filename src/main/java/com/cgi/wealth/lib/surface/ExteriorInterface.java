package com.cgi.wealth.lib.surface;

/**
 * Interface inside a class is always static
 */
public interface ExteriorInterface {
    void display();
    @FunctionalInterface
    interface Interior{
        void info(int s);
    }

    /**
     * Default implementation
     */
    class DefaultImplementation implements ExteriorInterface{
        @Override
        public void display() {
            System.out.println("This is called DefaultImplementation");
        }
    }
}
