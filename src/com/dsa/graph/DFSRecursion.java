package com.dsa.graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;
class Graph {

    private int v; // Total number of vertices
    private  ArrayList<Integer>[] graph; // List to hold vertices
    private boolean visited[]; // All visited vertices

 public Graph(int vertices) {
     v = vertices;
     graph = new ArrayList[v];
     visited = new boolean[v];
     
     for (int i = 0; i < v; i++) {
         
         graph[i] = new ArrayList();
     }
 }
 void showVisited() {
        for (boolean b : visited) 
            System.out.print(b + ", ");
 }
 
    void addEdge(int src, int dst) {  // Edge connecting two vertices
     graph[src].add(dst); 
 }
     
    void dfs(int vertex) {
    
     visited[vertex] = true;  // Whether it's been visited or not
     System.out.print(vertex + " ");
     
     // Using loop extension
     if (!graph[vertex].isEmpty()){
    
         for (Integer i : graph[vertex]) { 
            
         if (!visited[i]) {
                   dfs(i);        
       }
     }
            
     }
     // Using iterator approach
     
//     Iterator<Integer> it = graph[vertex].listIterator();
//     while (it.hasNext())
//     {  
//         int adj = it.next(); // Returns error if no element is presnent
//         if (!visited[adj]) {
//         dfs(adj);
//         }
//     }
 
                       
 } 
      void dfsitr(int v) { // DFS using iteration
          
          Arrays.fill(visited, false); // Array values reset to default
                
                visited[v] = true;
                System.out.print(v + " "); 
                
                while (v != graph.length) {       
                    if (graph[v].isEmpty() & visited[v]) break; // To stop prinitng unassigned v
                    if (!visited[v]) {
                            System.out.print(v + " ");
                            visited[v] = true;
                    
                     if (!graph[v].isEmpty()) {
                    for (Integer i : graph[v]) {
                       
                          System.out.print(i + " ");
                          visited[i] = true;              
                }
                     }
                    }
                    v++;
                }       
               for (boolean b : visited) 
                   System.out.print(b + ", ");  
            //   System.out.println(graph[9]); // Prints empty list
            System.out.println("Value of v " + v);
    }
          void dfsitrStack(int v) {
          Arrays.fill(visited, false);
          Stack<Integer> stack = new Stack<>();
          stack.push(v);
          
          while (!stack.isEmpty()) {
              int i = stack.pop();
              if (!visited[i]) {
                  System.out.print(i + " ");
                  visited[i] = true;
              }
              Iterator<Integer> it = graph[i].listIterator();
              while (it.hasNext()) {
                  int adj = it.next();
                  if (!visited[adj]) {
                      stack.push(adj);
                  }
              }
          }
          
            
      }
}
public class DFSRecursion {  
    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);
        g.addEdge(3, 7);
        g.addEdge(7, 8);
        g.addEdge(5, 9);
        
        System.out.println("Coming from Recursion"); g.dfs(3);
        g.showVisited();
        System.out.println("\nComing from Recursion"); g.dfsitr(3);
        System.out.println("\nComing from Recursion"); g.dfsitrStack(3);
         g.showVisited();
        
    }
}