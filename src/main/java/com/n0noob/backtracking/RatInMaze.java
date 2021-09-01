package com.n0noob.backtracking;

import com.n0noob.utils.Matrix;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RatInMaze {

    private boolean isSafe(final int[][] maze, final int[][] sol, int i, int j) {
        int maxRow = maze.length - 1;
        int maxCol = maze[0].length - 1;

        //Out of maze
        if(i > maxRow || j > maxCol || i < 0 || j < 0)
            return false;

        //Invalid position
        if(maze[i][j] == 0)
            return false;

        //Is already covered
        if(sol[i][j] == 1)
            return false;

        return true;
    }

    private boolean solveMazeUtil(final int[][] maze, int[][] sol, int i, int j) {

        int maxRow = maze.length - 1;
        int maxCol = maze[0].length - 1;

        //Reached destination
        if(i == maxRow && j == maxCol)
            return true;

        if(isSafe(maze, sol,i-1, j)) {
            sol[i-1][j] = 1;
            if(solveMazeUtil(maze, sol, i-1, j))
                return true;
            sol[i-1][j] = 0;
        }

        if(isSafe(maze, sol, i, j-1)) {
            sol[i][j-1] = 1;
            if(solveMazeUtil(maze, sol, i, j-1))
                return true;
            sol[i][j-1] = 0;
        }

        if(isSafe(maze, sol, i+1, j)) {
            sol[i+1][j] = 1;
            if(solveMazeUtil(maze, sol, i+1, j))
                return true;
            sol[i+1][j] = 0;
        }

        if(isSafe(maze, sol, i, j+1)) {
            sol[i][j+1] = 1;
            if(solveMazeUtil(maze, sol, i, j+1))
                return true;
            sol[i][j+1] = 0;
        }

        return false;

    }

    public boolean solveMaze(int[][] maze) {
        int[][] sol = new int[maze.length][];

        for(int i = 0; i < maze.length; i++) {
            sol[i] = new int[maze[0].length];
        }

        sol[0][0] = 1;

        if(!solveMazeUtil(maze, sol, 0, 0)) {
            log.info("Couldn't find a solution");
            return false;
        }

        Matrix.print(sol);
        return true;
    }

}