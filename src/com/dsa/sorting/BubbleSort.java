package com.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {
       
    public static void bubbleSort(int[] arr) {
            
        for (int i = 0; i < arr.length; i++) { 
            for (int j = 1; j < arr.length - i; j++) {
                   if (arr[j] < arr[j-1]) {
                       // swap happens from here
                       int temp = arr[j];
                       arr[j] = arr[j-1];
                       arr[j-1] = temp;
                   }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args) {
        int[] arr = {8, 3, 2, 2, 1, 2};
        bubbleSort(arr);
    }
}
