package com.n0noob.backtracking;

import com.n0noob.utils.Matrix;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NQueen {

    private boolean nQueenInRow(int[][] board, int row) {

        //If board is completed
        if(row >= board.length) {
            Matrix.print(board);
            return true;
        }

        //Consider placing pawn on each row
        for(int i = 0; i < board.length; i++) {

            if(isSafe(board, row, i)) {
                board[row][i] = 1;

                if(nQueenInRow(board, row+1))
                    return true;

                //If not safe backtrack
                board[row][i] = 0;
            }

        }

        return false;
    }

    private boolean isSafe(int[][] board, int row, int col) {

        for(int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 1)
                return false;
        }

        for(int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 1)
                return false;
        }

        return true;

    }

    public boolean solveNQueen(int size) {

        int[][] board = new int[size][];

        //Initialize board
        for(int i = 0; i < size; i++) {
            board[i] = new int[size];
            for(int j = 0; j < size; j++)
                board[i][j] = 0;
        }

        if(nQueenInRow(board, 0)) {
            log.info("Found combination");
            return true;
        }

        log.info("Could not find combination");
        return false;
    }

}