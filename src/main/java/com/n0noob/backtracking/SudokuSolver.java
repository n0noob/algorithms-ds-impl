package com.n0noob.backtracking;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SudokuSolver {

    private static final int STD_SIZE = 9;

    public boolean solveSudoku(int[][] grid) {
        return solveSudokuUtil(grid, 0, 0);
    }

    private boolean solveSudokuUtil(int[][] grid, int row, int col) {

        //If row processing completes
        if(col == STD_SIZE) {
            col = 0;
            row++;
        }

        //Terminating condition
        if(row >= STD_SIZE) {
            return true;
        }

        log.trace("row : {} col : {}", row, col);

        //If grid value is already filled
        if(grid[row][col] != 0)
            return solveSudokuUtil(grid, row, col+1);

        //Try putting all values from 1 to 9
        for(int i = 1; i <= STD_SIZE; i++) {
            if(isSafe(grid, row, col, i)) {
                grid[row][col] = i;
                if(solveSudokuUtil(grid, row, col+1))
                    return true;
            }
            grid[row][col] = 0;
        }

        return false;

    }

    private boolean isSafe(int[][] grid, int row, int col, int value) {
        for(int i = 0; i < STD_SIZE; i++)
            if(grid[i][col] == value)
                return false;

        for(int i = 0; i < STD_SIZE; i++)
            if(grid[row][i] == value)
                return false;

        int startRow = row - (row%3);
        int startCol = col - (col%3);

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (grid[i + startRow][j + startCol] == value)
                    return false;
            }
        }

        return true;
    }
}
