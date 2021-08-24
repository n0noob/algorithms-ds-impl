package com.n0noob.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RatInMazeTest {

    RatInMaze ratInMaze;

    @BeforeEach
    public void init() {
        ratInMaze = new RatInMaze();
    }

    @Test
    public void when4X5MazeWithPossibleSolutionIsGiven_thenMazeIsSolved() {
        int maze[][] = {
                { 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1 },
                { 0, 1, 0, 0, 1 },
                { 1, 1, 1, 0, 1 }
        };
        assertTrue(ratInMaze.solveMaze(maze));
    }

    @Test
    public void when4X5MazeWithImpossibleSolutionIsGiven_thenMazeIsSolved() {
        int maze[][] = {
                { 1, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 1 },
                { 0, 1, 0, 0, 1 },
                { 1, 1, 1, 0, 1 }
        };
        assertFalse(ratInMaze.solveMaze(maze));
    }

}