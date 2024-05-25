
package com.dsa.leetcode.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoPointer {
    public static boolean isPalindromeBF(String s) {
       StringBuilder sb = new StringBuilder(s);
       if (s.equals(sb.reverse().toString())) 
           return true;
       return false;    
    }
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
           if (s.charAt(left) != s.charAt(right))
               return false;
           left++;
           right--;
        
        }
        return true;
    }
    // Given array will be sorted
    public static boolean hasPairWithSumBF(int[] arr, int target) {
        
        for (int i = 0; i < arr.length - 1; i++) { // arr.length-1 because we have to match pair with second last and last item
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target){ 
                    System.out.println(j);
                    return true;           
                }
            }
        }      
        return false;   
    }
    public static int[] hasPairWithSumHashMap(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;    
        while (i < arr.length) {
            int key = target - arr[i];    
            if (map.containsKey(key)){ 
                System.out.println("True");
                return new int[] {map.get(key), i};      
            }
            else {
                map.put(arr[i], i);
            }
            i++;
        }
        System.out.println("False");
        return new int[] {};
    }
    public static boolean hasPairWithSumTP(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) return true;
            if ( sum > target)
                right--;
            else  
                left++;   
        }       
        return false;
    } 
    // The following will return a sorted array after joining two sorted arrays
    public static int[] joinTwoSortedArraysTP(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        int z = 0;
        
        int[] arr3= new int[arr1.length + arr2.length];
        
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]){
                arr3[z] = arr1[i];
                i++;
            }
            else {
                arr3[z] = arr2[j];
                j++;
            }    
            z++;
        }
        // If there are any remaining elements in arr1
        while (i < arr1.length) { // i has not reached the end of the arr1
            arr3[z] = arr1[i];
            i++;
            z++;
        }
         // If there are any remaining elements in arr2
        while (j < arr2.length) { // i has not reached the end of the arr1
            arr3[z] = arr2[j];
            j++;
            z++;
        }            
      return arr3;       
    }
    public static void main(String[] args) {
        int[] arr = joinTwoSortedArraysTP(new int[]{5,6,7,8}, new int[] {1,2,3,9});
       
         System.out.println(Arrays.toString(arr));
    }
}
