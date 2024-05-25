package com.dsa.stack;

import java.util.Stack;
/* Thought Process
Declare and initialize two stacks with empty members.

Create add method to push items into main stack.

While an item will be added into the main stack for the first time,
we will check if the second stack is empty. If empty, stack 2
will be updated with that item as well.

As more items will be pushed, stack two will be peeked each time
to see if the item inserted to main stack is less than the top
element in the second stack. If so, that item will be pushed to 
the second stack as well on comparing with the current top element
of the second stack. If not, no item will be pushed into the second 
stack.
*/

public class StackMinimum {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
        
    void add(int i) {
        if (stack2.isEmpty()) {
            stack1.push(i);
            stack2.push(i);
            return;
        }
        else if (i < stack2.peek()) {
            stack1.push(i);
            stack2.push(i);
        }
        else {
            stack1.push(i);
        }          
    }  
    void min() {
        System.out.println(stack2.peek());
    }
    void remove() { 
        if (stack1.peek() == stack2.peek()) {
            stack1.pop();
            stack2.pop();
        }
        else 
        {
            stack1.pop();
        }   
    }
    public static void main(String[] args) {
        StackMinimum sm = new StackMinimum();
        
        sm.add(8);
        sm.add(7);
        sm.add(1);
        sm.remove();
        sm.add(3);
        sm.add(2);
        sm.remove();
        sm.remove();
       
        sm.min();
    }
}
