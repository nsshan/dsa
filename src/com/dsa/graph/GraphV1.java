
package com.dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
// graph using adjacency list
public class GraphV1 {
    private HashMap<String, ArrayList<String>> graph = new HashMap<>();
    
    public void addVertex(String vertex) {
        if (graph.get(vertex) == null)
        graph.put(vertex, new ArrayList<String>());
    }
    public void addEdge(String vertex1, String vertex2) {
        if (graph.get(vertex1) != null && graph.get(vertex2) != null) {
        graph.get(vertex1).add(vertex2);
        graph.get(vertex2).add(vertex1);
        }
    }
    public void removeEdge(String vertex1, String vertex2) {
        if (graph.get(vertex1) != null && graph.get(vertex2) != null) {
        graph.get(vertex1).remove(vertex2);
        graph.get(vertex2).remove(vertex1);
        }
    }
    public void removeVertex(String vertex) {
        
        if (graph.get(vertex)!= null) {
        for (String V : graph.get(vertex)) {
            graph.get(V).remove(vertex);
        }
        graph.remove(vertex);
        }
    }   
    public static void main(String[] args) {
        GraphV1 graphv1 = new GraphV1();
        graphv1.addVertex("A");
        graphv1.addVertex("B");
        graphv1.addVertex("C");
        graphv1.addEdge("A", "B");
        graphv1.addEdge("A", "C");
        graphv1.addEdge("B", "C");
        graphv1.removeEdge("A", "B");
     //   graphv1.removeVertex("B");
        System.out.println(graphv1.graph);
    }
    }

