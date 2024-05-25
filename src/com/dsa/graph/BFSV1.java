package com.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

 class Vertex { 
    private String name;
    private boolean visited;
    private List<Vertex> neighbors;
    
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
    public List<Vertex> getList() {
 
        return neighbors;
    }
    public void addNeighbor(Vertex v) {
        neighbors.add(v);
    }
    @Override
    public String toString() {
        return name;
    }
}
public class BFSV1 {
    // first a graph is needed
    public void bfs(Vertex vertex) { // suppose you're passing A
        Queue<Vertex> queue = new LinkedList<>();
        vertex.setVisited();
        queue.add(vertex);
        
        while(!queue.isEmpty()) {
            Vertex v = queue.remove(); 
            // do something with the vertex here if needed
            System.out.println(v); // need to override the toString()
            
            for (Vertex item : v.getList()) {
                if (!item.isVisited()) {
                    item.setVisited();
                    queue.add(item);
                }
            }
        }   
    }   

public static void main(String[] args) {

  BFSV1 bfs = new BFSV1();
    
  Vertex A = new Vertex("A");
  Vertex B = new Vertex("B"); 
  Vertex C = new Vertex("C"); 
  Vertex D = new Vertex("D"); 
  
  A.addNeighbor(B);
  A.addNeighbor(D);
  C.addNeighbor(A);
  D.addNeighbor(C);
  
  bfs.bfs(A);

}
}