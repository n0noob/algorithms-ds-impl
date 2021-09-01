package com.n0noob.backtracking;

import com.n0noob.utils.Matrix;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KnightTour {

    //Possible delta moves
    private static final int[] rowDelta = {-2, -2, +1, -1, +2, +2, +1, -1};
    private static final int[] colDelta = {-1, +1, -2, -2, -1, +1, +2, +2};

    private boolean knightTourUtil(int[][] board, int row, int col, int pos) {

        if(pos == board.length * board[0].length)
            return true;

//        boolean foundSafePos = false;

        int newPosRow;
        int newPosCol;

        //For each position
        for(int i = 0; i < rowDelta.length; i++) {
            newPosRow = row + rowDelta[i];
            newPosCol = col + colDelta[i];
            if(isSafe(board, newPosRow, newPosCol)) {
//                foundSafePos = true;
                board[newPosRow][newPosCol] = pos;

                if(knightTourUtil(board, newPosRow, newPosCol, pos+1))
                    return true;

                board[newPosRow][newPosCol] = -1;
            }
        }

//        if(!foundSafePos && knightHasCompletedTour(board))
//            return true;

        return false;

    }

    private boolean knightHasCompletedTour(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    private boolean isSafe(int[][] board, int i, int j) {
        if(i < 0 || j < 0 || i > board.length-1 || j > board[0].length-1)
            return false;

        if(board[i][j] > -1)
            return false;

        return true;
    }

    public boolean solve(int rowCount, int colCount) {

        //Preparing the board
        int[][] board = new int[rowCount][colCount];

        for(int i = 0; i < rowCount; i++) {
            board[i] = new int[colCount];
            for(int j = 0; j < colCount; j++)
                board[i][j] = -1;
        }

        board[0][0] = 0;

        if(knightTourUtil(board, 0, 0, 1)) {
            Matrix.print(board);
            return true;
        }

        log.info("No solution found for this board");
        return false;
    }

}