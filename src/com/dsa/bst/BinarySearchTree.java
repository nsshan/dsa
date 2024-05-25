package com.dsa.bst;
public class BinarySearchTree {
     
    private Node root;
    class Node {
        private int value;
        private Node left;
        private Node right;
        
        public Node(int value) { // constructor 
            this.value = value;
        }   
    }
    public boolean insert(int value) {
        if (contains(value)) return false;
        Node node = new Node(value);
        
        if (root == null) {
            root = node;
            return true;
        }       
        Node temp = root;
        
        while (true) {
            if (node.value < temp.value) {
                if (temp.left == null) {
                    temp.left = node;
                    return true;
                }
                temp = temp.left;
            }
            else if (node.value > temp.value) {
                if (temp.right == null) {
                    temp.right = node;
                    return true;
                }
                temp = temp.right;
            }           
        }
             
    }
    public boolean contains(int key) {
        Node temp = root;
        if (temp == null) return false;
        
        while (temp != null) {
            if (temp.value == key) return true;
            
            if (key < temp.value) 
                temp = temp.left;
            else if (key > temp.value) 
                temp = temp.right;
        }   
        return false;
    }
    private boolean rContains(Node node, int value) {
        if (node == null) return false;
        if (node.value == value) return true;
        
        if (value < node.value )
            return rContains(node.left, value);
        else 
            return rContains(node.right, value);
    }
    public boolean rContains(int value){
    return rContains(root, value);
    }
    
    private Node rInsert(Node currentNode, int value) {
        
        if (currentNode == null) return new Node(value);
        
        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        }
        else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }    
        
        return currentNode;
    }
    
    public void rInsert(int value) {
        rInsert(root, value);
    }
    
    public int minimum(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }
    
    public Node delete(Node currentNode, int value) {
         
        if (currentNode == null) return null;
         
        else if (value < currentNode.value) {
            currentNode.left = delete(currentNode.left, value);        
        } 
        else if (value > currentNode.value) {
            currentNode.right = delete(currentNode.right , value);
        }
        else {  // If the node to delete has no child
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            }
            else if (currentNode.right != null) {   
                currentNode = currentNode.right;
            }
            else if (currentNode.left != null) {
                currentNode = currentNode.left;
            }
            else {
                int min = minimum(currentNode.right);
                currentNode.value  = min;
                currentNode.right = delete(currentNode.right, min);
            }
         }
         return currentNode;
    }
    public void delete(int value) {
        delete(root, value);
    }
    
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.rInsert(7);
        bst.insert(5);
        bst.insert(10);
        bst.rInsert(9);
              
       // System.out.println(bst.root.right.left.left.value);
        System.out.println(bst.rContains(7));
        bst.delete(5);
        bst.delete(5);
        System.out.println(bst.rContains(5));
        
    }    
}