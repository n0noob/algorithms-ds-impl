package com.n0noob.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.n0noob.utils.Matrix.print;
import static org.junit.jupiter.api.Assertions.*;

class SudokuSolverTest {
    private SudokuSolver sudokuSolver;

    @BeforeEach
    void init() {
        sudokuSolver = new SudokuSolver();
    }

    @Test
    void givenSudoku_whenMatrixIsGiven_thenSolved() {
        int grid[][] = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        if (sudokuSolver.solveSudoku(grid))
            print(grid);
        else
            System.out.println("No Solution exists");
    }
}