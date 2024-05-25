package com.dsa.recursion;

public class RecursionExample1 {
    
    private static int[] numArray = {1,2,3,4,5}; //16
    public static int SumOfRestOfTheNums(int n) {
     
        if (n==1)  // This will stop the recursion proc
           return numArray[0];
        
        return numArray[n-1] + SumOfRestOfTheNums(--n);
        
    }
    public static void main(String[] args) {
        System.out.println(SumOfRestOfTheNums(numArray.length));
    }
}
/*
[4]5 
    [3]4
        [2]3
            [1]2
                [0]1
    

*/