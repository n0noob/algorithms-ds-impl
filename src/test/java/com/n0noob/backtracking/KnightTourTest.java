package com.n0noob.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTourTest {

    KnightTour knightTour;

    @BeforeEach
    void setUp() {
        knightTour = new KnightTour();
    }

    @Test
    public void givenStdBoard_whenSolveAttempted_thenShouldSolve() {
        boolean res = knightTour.solve(7, 7);
        assertTrue(res);
    }

}