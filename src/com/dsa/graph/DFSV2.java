
package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Vertex {
    // properties
    private String name;
    private boolean visited;
    private List<Vertex> neighbors;
    // methods
    public Vertex(String name) {
        this.name = name;
        neighbors = new ArrayList<>();
    }
    public void setVisited() {
        visited = true;
    }
    public boolean isVisited() {
        return visited;
    }
    public void addNeighbor(Vertex v) {
        neighbors.add(v);
    }
    public List<Vertex> getNeighbors() {
        return neighbors;
    }
    @Override
    public String toString() {
        return name;
    } 
}
// this class will contain the code for DFS
class DFS { 
    // methods
    // theList contains list of all vertices
    public static void dfs(List<Vertex> theList) {
    
        for (Vertex v : theList) {
            if (!v.isVisited()) {
                v.setVisited();
                System.out.println(v.toString());
                //helper(v);
                rHelper(v);
            }   
        }  
    }
    private static void helper(Vertex v) {
        Stack<Vertex> stack = new Stack<>();
        
        stack.push(v);
        while(!stack.isEmpty())
        {
             Vertex actual = stack.pop();
               
               for (Vertex vertex : actual.getNeighbors()) {
                   if (!vertex.isVisited()) {
                       vertex.setVisited();
                       System.out.println(vertex.toString() + " *");
                       stack.push(vertex);
                   }             
               }          
        }
   }
    // recursive approach
    public static void rHelper(Vertex v) {
       
            v.setVisited();
            for (Vertex vertex : v.getNeighbors()) {
                if (!vertex.isVisited()) {
                    vertex.setVisited();
                    System.out.println(vertex.toString() + " *");
                    rHelper(vertex);
                }
            }
        
    
    }
}
public class DFSV2 {
    
    public static void main(String[] args) {
        Vertex v1 = new Vertex("A");
        Vertex v2 = new Vertex("B");
        Vertex v3 = new Vertex("C");
        Vertex v4 = new Vertex("D");
        
        v1.addNeighbor(v2);
        v1.addNeighbor(v3);
        v4.addNeighbor(v1);
     
     //   v3.addNeighbor(v4);
        
        ArrayList<Vertex> theList = new ArrayList<>();
        theList.add(v1);
        theList.add(v2);
        theList.add(v3);
        theList.add(v4);
        
        DFS.dfs(theList); 
        
        
    }
}