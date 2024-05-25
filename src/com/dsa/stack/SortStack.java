
package com.dsa.stack;
import java.util.Stack;
/* Thought process
We will keep a stack to store random numbers. 
A second stack will be used to keep the numbers in sorted order.
Process
Using a while loop(mover/trasport) the first stack will be traversed until it's empty.
While in the loop, an item will be popped from stack 1 and pushed to stack 2 without 
comparison, only if stack 2 is empty. Otherwise, each popped item will be compared against
the top item of stack 2. If the popped item is lower then it will be placed in stack 2 after 
popping and pushing the top item of stack 2 into stack 1. If there are multiple items in 
stack 2 then using a while loop again top items will be popped from stack 2 and placed into stack
1 until the condition is met. If popped item is greater than the top of stack 2 then it will be 
pushed to stack 2. Print stack 2
*/
public class SortStack {
    static Stack<Integer> stack1 = new Stack<>(); // Will be rendered from a static context
    
    public static void main(String[] args) {
        stack1.push(2);
        stack1.push(1);
        stack1.push(5);
        stack1.push(7);
        stack1.push(5);
        stack1.push(7); 
        stack1.push(5);
        stack1.push(7);  
        System.out.println(stack1);
        
        Stack<Integer> stack2 = new Stack<>(); // Temp stack
      
        while (!stack1.isEmpty()) {
            int item = stack1.pop();
            
            while (!stack2.isEmpty() && (stack2.peek() > item)) {
                    int item2 = stack2.pop();
                    stack1.push(item2);                 
            }
               stack2.push(item);
        }      
        System.out.println(stack2);
    }
}
