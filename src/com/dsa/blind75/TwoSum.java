
package com.dsa.blind75;

import java.util.Map;
import java.util.HashMap;


public class TwoSum {
    
    public static int[] twoSum(int[] arr, int target) {
        
        Map<Integer, Integer> map = new HashMap<>(); // <Value, Index>
        int[] outArray = new int[2];
        
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if (map.containsKey(target - x)){
                outArray[0] = map.get(target-x);
                outArray[1] = i;
                return outArray;
            }
            else {
                map.put(x,i);    
            }
        }      
        return outArray;
    }  
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int[] temp = twoSum(arr, 6);
        System.out.println(temp[0] + " " + temp[1]);
    }
}
