
package com.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void selectionSort(int[] arr) {
    
     //   int index;
        for (int i = 0; i < arr.length; i++) {
            int index = i; // to keep the track of the left most index at each pass
            for (int j = i; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    // swap happens from here
                    int temp = arr[index];
                    arr[index] = arr[j];
                    arr[j] = temp;
                }
        }
            }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 7, 9};
        selectionSort(arr);
    }
}