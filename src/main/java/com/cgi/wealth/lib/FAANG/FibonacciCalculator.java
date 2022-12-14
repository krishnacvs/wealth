package com.cgi.wealth.lib.FAANG;

public class FibonacciCalculator {


    static void Fibonacci(int N)
    {
        int num1 = 0, num2 = 1;

        int counter = 0;
        int tmp;
        // Iterate till counter is N
        while (counter < N) {

            // Print the number
            System.out.print(num1 + " ");

            // Swap
            tmp = num2 + num1;
            num1 = num2;
            num2 = tmp;
            counter++;
        }
    }

    // Driver Code
    public static void main(String args[])
    {
        // Given Number N
        int N = 10;

        // Function Call
        Fibonacci(N);
    }

}
