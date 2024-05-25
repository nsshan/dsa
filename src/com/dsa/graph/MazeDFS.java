
package com.dsa.graph;

import java.util.Arrays;

class Maze {
    private int[][] maze; 
    private boolean[][] visited; 
    public Maze(int[][] maze, int startIndex, int endIndex) {
        this.maze = maze;
        visited = new boolean[maze.length][maze.length];
        startTheProcess(startIndex, endIndex);
    }
    public void startTheProcess(int x, int y) {
        if (dfs(x, y))
            System.out.println("Path Found");
        else
            System.out.println("No way exists");
        
    }
    // this method will validate each cell for feasibility
    private boolean isFeasible(int x, int y) { // x is row, y is column 
        if (x<0 || x > maze.length - 1) // checking for vertical error
            return false;
        if (y<0 || y > maze.length - 1 )
            return false;
        if (visited[x][y])
            return false;
        if (maze[x][y] == 1) 
            return false;
        return true;
    }
    
    private boolean dfs(int x, int y) { // initially x=1, y=0
        if (x == maze.length - 1 && y == maze.length - 1) // destination reached
            return true;
        else if (isFeasible(x, y)) {// 2, 0
            visited[x][y] = true;
            
            // scope to go to the next cell
            {
            if (dfs(x+1, y)) // inside here 2, 0
                return true;
            if (dfs(x-1, y ))
                return true;
            if (dfs(x, y+1)) 
                return true;
            if (dfs(x, y-1))
                return true;
            // backtracking from here
         //   visited[x][y] = false; // not needed
            return false; 
            }
        }
        return false;
    }
}

// this will contain the main method
public class MazeDFS {
    public static void main(String[] args) {
        int[][] maze1 = 
            {{1,1,1,1,1},
             {0,1,0,0,0},
             {0,0,0,0,0},
             {1,1,0,0,1},
             {1,1,1,0,0}};
        
        Maze maze = new Maze(maze1, 1, 0);
    }
}
