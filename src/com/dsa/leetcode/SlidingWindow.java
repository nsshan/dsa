
package com.dsa.leetcode;

public class SlidingWindow {
    
    // [1,2,3,4,5,5,6,7]
    // brute-force technique
    public static int findMaxSumOfSequence(int[] arr, int k) {
        
        int max = 0;
        
        for (int i=0; i < arr.length - k; i++) {
            int sum = 0;
            
            for (int j=i; j < k+i; j++) {
                sum += arr[j];
            }
            max = Math.max(max, sum);
        }
    return max;
    }
    public static int findMaxSumOfSequence2(int[] arr, int k) {
        
        int max = 0;
        int sum = 0;
        int start = 0;
        int end = 0;
        
        // capturing the sum of first k elements
        while (end < k) { 
           sum += arr[start];
           end++;
        }
        max = sum;
        // this part is creating the window
        // the idea is to run the loop as many times the
        // the window can be slided
        while (start + k < arr.length) {
            sum = sum + arr[end] - arr[start];
            max = Math.max(max, sum);
            start++;
            end++;
        }      
     
        return max;   
    }
    
    
    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5,6,7,8,9};
        int x = findMaxSumOfSequence(arr, 3);
        int y = findMaxSumOfSequence2(arr, 3);
        System.out.println(x);
        System.out.println(y);
    }
}
