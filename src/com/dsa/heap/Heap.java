package com.dsa.heap;
import java.util.Arrays;

public class Heap {
     private final int CAPACITY = 10;
     private int[] heap;
     private int heapSize; //act as a pointer
     
     public Heap() { // empty constructor
         heap = new int[CAPACITY];
     } 
     public boolean isFull() {
         return heapSize == CAPACITY;
     }
     public void insert(int data) {
         if (isFull()) throw new RuntimeException("Heap is full");
         
         heap[heapSize] = data;
         heapSize++;
         
         fixMyHeapUp(heapSize - 1);          
     }
    private void fixMyHeapUp(int index) {
        int parent = (index - 1)/2;
        
        if (index > 0 && heap[index] > heap[parent]) {
            swap(index, parent);
            fixMyHeapUp(parent);
        }
    }
    public int getMax() {
        return heap[0];
    }
    public int poll() {
        int max = getMax();
        swap(0, heapSize - 1);
        heapSize--;
        fixMyHeapDown(0);
        return max;
    }
    private void fixMyHeapDown(int i) {
       int topValueIndex = i;
       int leftChildIndex = 2*i+1;
       int rightChildIndex = 2*i+2;
       
       if (leftChildIndex < heapSize && heap[i] < heap[leftChildIndex])
           topValueIndex = leftChildIndex;
       if (rightChildIndex < heapSize && heap[i] < heap[rightChildIndex])
           topValueIndex = rightChildIndex;
       
       if (i != topValueIndex) {
        swap(i, topValueIndex);
        fixMyHeapDown(i);
       }     
    }
    private void swap(int index, int parent) {
       int temp1 = heap[index];
       heap[index] = heap[parent];
       heap[parent] = temp1;
    }  
    public void heapSort() {
    int n = heapSize;
    for (int i = 0; i<n; i++) {
        int max = poll();
        System.out.println(max);
    }
    
    }
  //  public void 
    public void printHeap(){
        System.out.println(Arrays.toString(heap));
    }
    public static void main(String[] args) {
        Heap heap = new Heap();
        
       
          heap.insert(1);
          heap.insert(2);
          heap.insert(3);
          heap.insert(4);
          heap.insert(5);
          heap.insert(6);
        
    
        heap.heapSort();
        
        heap.printHeap();
   
    }   
}
