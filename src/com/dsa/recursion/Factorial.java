
package com.dsa.recursion;

public class Factorial {
    
    public static int factorial(int number) {
        
        if (number == 1) return 1; // base case
        return (number * factorial(number - 1));
    }
    
    public static void main(String[] args) {
        int fact = factorial(4);

    }
    
    
}
