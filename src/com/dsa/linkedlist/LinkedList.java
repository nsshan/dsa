package com.dsa.linkedlist;

public class LinkedList {
    Node head = null;
    Node tail = null;
    private class Node {
        private int val;
        private Node next;
        
        public Node(int val) {
            this.val = val;
        }      
    }
    void addEndNode(Node node) { // For creating links only
        if (head == null && tail == null) {
            head = node; tail = node; 
        }
        else {
            Node current = tail;
            current.next = node;
            tail = node;
            node.next =null;
        }    
    }
    void printNodes(Node node) {
        Node current = node;
        while(current != null)
        {
            System.out.println(current.val);   
            current = current.next; 
        }
    }
    void deleteEndNode() { 
        Node current = head;
        while (current.next.next != null) { // Mover
            current = current.next;
        }
        current.next = null;
        tail = current;      
    }
    void deleteFirstNode() {
        head = head.next;
    }
    void addFrontNode(Node node) {
        node.next = head;
        head = node;
    }
    /*
    Suppose the node to add is at index 2. 
    We will keep a counter with starting value = 1.
    Now as we move through the list we stop at the node just before 2.
    We update the node we stopped at and link it to the new node.
    */
    void addNodeAtIndex(int index, Node newNode) {
        int count = 1;
        Node current = head;
        if (index == 1) {
            addFrontNode(newNode);
            return;
        } 
        while(current != null && count != index-1)
        {
            if (current.next == null) break;
            current = current.next;
            count++;
        }
        newNode.next = current.next;
        current.next = newNode;
    }   
    /*
    Let's write the thought process.
    We will start at the head node.
    Keep a temporary node variable to hold the current.next node.
    Create a while loop that will loop through until the end.
    Link the current.next to the current node.
    Set current  = current.next
    
    */
    void reverseList() {
     Node nextNode = null;
     Node current = head;
     Node prev = null;
     int count = 0;
     tail = head;
     while (current != null) {
         
        
         nextNode = current.next;
         current.next = prev;
         prev = current;
       
         current = nextNode; 
           
     }
     
     head = prev;
     printNodes(prev);
    }
    
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addEndNode(ll.new Node(1));
        ll.addEndNode(ll.new Node(2));
        ll.addEndNode(ll.new Node(3));
        ll.addFrontNode(ll.new Node(7));
        ll.addEndNode(ll.new Node(4));  
   //     ll.deleteEndNode();
        ll.addEndNode(ll.new Node(5));
        ll.addNodeAtIndex(1, ll.new Node(8));
        ll.addNodeAtIndex(4, ll.new Node(10));
        
        ll.printNodes(ll.head);
  //      ll.deleteFirstNode();
        System.out.println("Head is " + ll.head.val);
        System.out.println("Tail is " + ll.tail.val);
        System.out.println("Tail is pointing "
                + "to " + ll.tail.next);
        ll.reverseList();
         System.out.println("Head is " + ll.head.val);
         System.out.println("Tail is " + ll.tail.val);
     
        
     
    }
}
