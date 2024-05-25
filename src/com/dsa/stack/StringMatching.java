
package com.dsa.stack;
import java.util.Stack;

public class StringMatching{
    
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String s = "";
        for (char c : s.toCharArray()) {
            if (c == '(' | c == '[' | c == '{') {
                stack.push(c);            
            }          
            if (!stack.isEmpty()) {       
                   if (c == ')' | c == ']' | c == '}') {
                       stack.pop();     
                    }        
            }          
        }
        if (stack.isEmpty()) 
            System.out.println("Balanced");  
        System.out.println(stack);  
    }   
}
